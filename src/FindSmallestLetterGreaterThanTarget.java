public class FindSmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {

        char c =  getNextGreater(0,letters.length-1,target,letters);

        if(c == 0)
        {
            return letters[0];
        }
        return c;


    }

    public static char getNextGreater(int start,int end,char search,char[] letters)
    {
        if(start <= end)
        {
            int mid = (start+end)/2;
            System.out.println("Start "+start+" Mid "+mid+" End "+end+" letter "+letters[mid]);
            if(letters[mid] > search)
            {
                System.out.println("Found target "+search+" at index "+mid);
                char leftGreater = getNextGreater(start,mid-1,search,letters);
                if(leftGreater != 0 && leftGreater < letters[mid])
                {
                    return leftGreater;
                }
                return letters[mid];
            }
            else if(letters[mid] <= search)
            {
                return getNextGreater(mid+1,end,search,letters);
            }

        }

        return 0;
    }
}
