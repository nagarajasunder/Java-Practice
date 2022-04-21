public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(encode("aaaabbbccc"));
    }

    static String encode(String str)
    {

        StringBuilder s = new StringBuilder();


        int i = 1;
        int ct = 1;
        char checker = str.charAt(0);

        while(i < str.length())
        {
            if(str.charAt(i) == checker)
            {
                ct++;
            }
            else
            {
                s.append(checker);
                s.append(ct);
                ct = 1;
                checker = str.charAt(i);
            }
            i++;
        }

        s.append(checker);
        s.append(ct);

        return s.toString();
    }

}
