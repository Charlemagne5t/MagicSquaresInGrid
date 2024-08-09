class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                res += check(i , j, grid);
            }
        }
        return res;
    }
    int check(int i, int j, int[][] grid) {
        boolean[] nums = new boolean[10];
        nums[0] = true;
        for(int k = i; k < i + 3; k++){
            for(int l = j; l < j + 3; l++) {
                if(grid[k][l] > 9) {
                    return 0;
                }else {
                    if(nums[grid[k][l]]){
                        return 0;
                    }
                    nums[grid[k][l]] = true;
                }
            }
        }
        
        int r1 = grid[i][j] + grid[i][j + 1] + grid[i][j+ 2];
        int r2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j+ 2];
        int r3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j+ 2];
        
        int c1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int c2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j+ 1];
        int c3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j+ 2];

        int d1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int d2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        if(r1 == r2 && r2 == r3 && r3 == c1 && c2 == c3 && c3 == d1 && d1 == d2){
            return 1;
        }
        return 0;
    }
}