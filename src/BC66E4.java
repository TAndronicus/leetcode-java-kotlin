public class BC66E4 {
    public static int topDownPyramids(int[][] grid) {
        if (grid.length == 1 || grid[0].length == 1) return 0;
        int pyramids = 0;
        for (int height = 2; height <= grid.length; height++) {
            for (int i = height - 1; i < grid[0].length - height + 1; i++) {
                searchLoop:
                for (int j = 0; j < grid.length - height + 1; j++) {
                    //
                    for (int heightSearch = 0; heightSearch < height; heightSearch++) {
                        for (int breadthSearch = -heightSearch; breadthSearch <= heightSearch; breadthSearch++) {
//                            System.out.println("Checking " + (j + heightSearch) + ", " + (i + breadthSearch));
                            if (grid[j + heightSearch][i + breadthSearch] != 1) break searchLoop;
                        }
                    }
                    System.out.println("Found: " + j + ", " + i);
                    pyramids++;
                }
            }
        }
        return pyramids;
    }

    public static int allPyramids(int[][] grid) {
        int topDown = topDownPyramids(grid);
        int[][] reversed = new int[grid.length][grid[0].length];
        for (int layer = 0; layer < grid.length; layer++) {
            reversed[grid.length - 1 - layer] = grid[layer];
        }
        return topDown + topDownPyramids(reversed);
    }

    public static void main(String[] args) {
//        System.out.println(allPyramids(new int[][]{{0,1,1,0},{1,1,1,1}}) == 2);
//        System.out.println(allPyramids(new int[][]{{1,1,1},{1,1,1}}) == 2);
//        System.out.println(allPyramids(new int[][]{{1,0,1},{0,0,0},{1,0,1}}) == 0);
//        System.out.println(allPyramids(new int[][]{{1,1,1,1,0},{1,1,1,1,1},{1,1,1,1,1},{0,1,0,0,1}}) == 13);
//        System.out.println(topDownPyramids(new int[][]{{1,1,1,1,0},{1,1,1,1,1},{1,1,1,1,1},{0,1,0,0,1}}));
        System.out.println(topDownPyramids(new int[][]{{0, 1, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 0}}));
    }
}
