import java.lang.Math;

public class Solution {
    /**
     * Find gcd of two integers a and b.
     * @param a is the 1st param
     * @param b is the 2nd param
     * @return gcd(a, b)
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        if (a == 0) {
            return b;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcd(5, 4));
    }
}
