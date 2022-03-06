public class PeakElement {

    public static void main(String[] args)
    {
        System.out.println(peakElement(new int[]{15},1));
    }

    public static  int peakElement(int[] arr,int n)
    {
        if(n == 1)
        {
            return 0;
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                if(i == 0 && arr[i+1] < arr[i])
                {
                    return i;
                }
                else if(i == n-1 && arr[i-1]<arr[i])
                {
                    return i;
                }
                else
                {
                    if(i!=0 && arr[i-1] < arr[i] && arr[i+1] < arr[i])
                    {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}
