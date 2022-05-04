class GoodMeals {
    public int countPairs(int[] deliciousness) {

        int ct = 0;
        int mod = 1000000007;

        int len = deliciousness.length;

        for(int i = 0;i<len-1;i++)
        {
            for(int j = i+1;j<len;j++)
            {
                float sum = (float) Math.sqrt((deliciousness[i]+deliciousness[j]));
                if(sum%2 == 0)
                {
                    ct++;
                }
            }
        }

        return ct%mod;

    }
}