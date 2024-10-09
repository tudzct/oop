public class Solution {
    /**
     * Find the n-th fibonacci number.
     * @param n is the param
     * @return n-th fibonacci number
     */
    public long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;

            if (c < a) {
                return Long.MAX_VALUE;
            }

            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fibonacci(100));
    }
}
