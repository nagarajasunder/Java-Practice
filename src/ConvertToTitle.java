public class ConvertToTitle {

    public static void main(String[] args) {

        System.out.println(convertToTitle(701));

    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder builder = new StringBuilder();
        while(columnNumber > 0)
        {
            columnNumber--;
            System.out.println(columnNumber);
            System.out.println(columnNumber%26);
            System.out.println((char)('A'+columnNumber%26));
            builder.insert(0,(char)('A'+columnNumber%26));
            columnNumber/=26;
            System.out.println(columnNumber);
        }

        return builder.toString();
    }
}
