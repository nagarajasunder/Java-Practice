import java.util.Arrays;


class HashSetImple
{
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
    }
}


public class MyHashSet {

    private int[] arr;
    private int remaining_space;
    private int recentIndex;
    private int getRecentIndex()
    {
        return recentIndex;
    }
    private int getRemainingSpace()
    {
        return remaining_space;
    }


    private int getArraySize()
    {
        return arr.length;
    }

    private int searchElement(int low,int high,int[] arr,int search)
    {
        if(low < high)
        {
            int mid = (low+high)/2;
            if(arr[mid] == search)
            {
                return mid;
            }
            else if(arr[mid] < search)
            {
                return searchElement(mid+1,high,arr,search);
            }
            return searchElement(low,mid-1,arr,search);
        }

        return -1;
    }

    public MyHashSet() {
        this.remaining_space = 1;
        this.recentIndex = 0;
        arr = new int[1];
    }

    public void increaseSpace()
    {
        int[] new_arr = new int[getArraySize()*2];
        int i = 0;
        for(;i<getArraySize();i++)
        {
            new_arr[i] = arr[i];
        }
        remaining_space = (getArraySize()*2) - i;
        recentIndex++;
        arr = new_arr;

    }

    public void add(int key) {
        Arrays.sort(arr);

        int index = searchElement(0,getArraySize(),arr,key);

        if(index == -1)
        {
            if(remaining_space < 1)
            {
                increaseSpace();
            }
            arr[recentIndex] = key;
            recentIndex++;
            remaining_space--;
        }
    }

    public void remove(int key) {
        Arrays.sort(arr);
        int index = searchElement(0,getArraySize(),arr,key);
        if(index != -1)
        {
            removeElement(index);
        }
    }

    public void removeElement(int index)
    {
        arr[index] = -1;
        for(int i = index+1;i<getArraySize();i++)
        {
            arr[i-1] = arr[i];
        }
        recentIndex--;
        remaining_space++;
    }

    public boolean contains(int key) {
        Arrays.sort(arr);
        int index = searchElement(0,getArraySize(),arr,key);

        if(index == -1)
        {
            return false;
        }
        return true;
    }
}

