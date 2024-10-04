// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.sql.SQLOutput;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int minj = Integer.MAX_VALUE;
        int maxj = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    mini = Math.min(mini, i);
                    maxi = Math.max(maxi, i);
                    minj = Math.min(minj, j);
                    maxj = Math.max(maxj, j);
                }
            }
        }
        return (maxi - mini + 1) * (maxj - minj + 1);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    private static int[] c = {0, 1, 0, -1};
    private static int[] h = {1, 0, -1, 0};

    private boolean checkThap(int x, int y) {
        int armLength = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int left = 0;

        while (x - armLength >= 0 && y - armLength >= 0
                && x + armLength < grid.length && y + armLength < grid[0].length) {
            if (grid[x + armLength][y] == grid[x][y]) {
                right++;
            }
            if (grid[x - armLength][y] == grid[x][y]) {
                left++;
            }
            if (grid[x][y + armLength] == grid[x][y]) {
                up++;
            }
            if (grid[x][y - armLength] == grid[x][y]) {
                down++;
            }
            if (right == left && left == up && up == down) {
                armLength++;
            } else {
                return false;
            }
        }
        if (x - armLength >= 0 && grid[x - armLength][y] == grid[x][y]) {
            return false;
        }
        if (x + armLength < grid.length && grid[x + armLength][y] == grid[x][y]) {
            return false;
        }
        if (y - armLength >= 0 && grid[x][y - armLength] == grid[x][y]) {
            return false;
        }
        if (y + armLength < grid[0].length && grid[x][y + armLength] == grid[x][y]) {
            return false;
        }
        return armLength > 1;
    }

    public int countPlus() {
        int count = 0;
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[i].length;j++) {
                if(checkThap(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'c', 'a', 'x' },
                {'a', 'a', 'a' },
                {'a', 'a', 'a' }
        };
        CharGrid grid1 = new CharGrid(grid);
        System.out.println(grid1.charArea('c'));
        System.out.println(grid1.countPlus());
    }

}
