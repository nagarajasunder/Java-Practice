class CountPrimes {

    //2 is Prime but its multipliers 4,6,8, are not prime
    //like wise 3 is prime but its multipliers 6,9,12 are not prime
    //so we are cancelling the multiples of each i and count the remaining prime
    public static void main(String[] args) {
        System.out.println(countPrimes(1500000));
    }

    public static int countPrimes(int n) {

        boolean[] prime = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        int ct = 0;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                ct++;
            }
        }

        return ct;

    }


}