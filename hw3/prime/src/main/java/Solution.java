public class Solution {
    /**
     * Check if n is a prime number.
     * @param n is the input
     * @return true or false
     */
    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPrime(10));
    }
}
