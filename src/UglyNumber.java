class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }

    public static boolean isUgly(int n) {

        int a = -1;
        if(n < 0)
        {
            n*=a;
        }

        System.out.println(n);

        if(n < 7)
        {
            return true;
        }

        for(int i = 2;i<=n/2;i++)
        {
            if(n%i == 0)
            {
                if(isPrime(i) && i > 5)
                {
                    return false;
                }

            }
        }

        return true;

    }

    public static boolean isPrime(int n)
    {
        for(int i = 2;i<=Math.sqrt(n);i++)
        {
            if(n%i == 0)
            {
                return false;
            }
        }

        return true;
    }
}