public class isSubStromg {

    public static void main(String[] args) {
        System.out.println(strstr("abcabcabcd","abcd"));
    }

    static int strstr(String s, String x)
    {
        int s_len = s.length();
        int x_len = x.length();

        if(x_len > s_len)
        {
            return -1;
        }

        int start = 0;
        int end = x_len;

        while(end < s_len)
        {
            String compare = s.substring(start,end);
            if(compare.equals(x))
            {
                return start;
            }
            start++;
            end++;
        }

        return -1;
    }

}
