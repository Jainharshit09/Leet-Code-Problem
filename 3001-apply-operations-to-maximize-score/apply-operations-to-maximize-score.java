class Solution {
    final int MOD = (int) 1e9 + 7;
    //find power
        private long findPower(long a, long b) {
        if (b == 0) return 1;
        long half = findPower(a, b / 2);
        long result = (half * half) % MOD;
        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }
        return result;
    }

    private List<Integer> getPrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    private int[] findPrimeScores(List<Integer> nums) {
        int n = nums.size();
        int[] primeScores = new int[n];

        int maxElement = Collections.max(nums);
        List<Integer> primes = getPrimes(maxElement);

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            for (int prime : primes) {
                if (prime * prime > num) break;

                if (num % prime != 0) continue;

                primeScores[i]++;
                while (num % prime == 0) {
                    num /= prime;
                }
            }
            if (num > 1) {
                primeScores[i]++;
            }
        }

        return primeScores;
    }


    //find thr next greater index
    private int[] findNextGreater(int[] primeScores) {
        int n = primeScores.length;
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScores[stack.peek()] <= primeScores[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nextGreater;
    }


    //find thr prev greater index
    private int[] findPrevGreater(int[] primeScores) {
        int n = primeScores.length;
        int[] prevGreater = new int[n];
        Arrays.fill(prevGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return prevGreater;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n=nums.size();
        int[] primeScores = findPrimeScores(nums);
        int[] nextGreater = findNextGreater(primeScores);
        int[] prevGreater = findPrevGreater(primeScores);
        long[] subarrays = new long[n];
        for(int i=0;i<n;i++){
            subarrays[i] = (long) (nextGreater[i] - i) * (i - prevGreater[i]);
        }
         List<int[]> sortedNums = new ArrayList<>();
         for(int i=0;i<n;i++){
            sortedNums.add(new int[]{nums.get(i),i});
         }
         sortedNums.sort((a, b) -> b[0] - a[0]);
        long score = 1;
        int idx = 0;
        while(k>0){
            int num=sortedNums.get(idx)[0];
            int i=sortedNums.get(idx)[1];
            long operations = Math.min((long) k, subarrays[i]);
            score = (score * findPower(num, operations)) % MOD;
            k -= operations;
            idx++;
        }
        return (int)score;
    }
}