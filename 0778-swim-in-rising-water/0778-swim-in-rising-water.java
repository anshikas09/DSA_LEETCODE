class Solution {

    class Pair {
        int time;
        int row;
        int col;

        Pair(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        boolean[][] vis = new boolean[n][n];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.add(new Pair(grid[0][0], 0, 0));
        vis[0][0] = true;

        int res = 0;

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int time = cur.time;
            int r = cur.row;
            int c = cur.col;

            res = Math.max(res, time);

            if (r == n - 1 && c == n - 1) {
                return res;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;

                    pq.add(new Pair(
                        grid[nr][nc],
                        nr,
                        nc
                    ));
                }
            }
        }

        return res;
    }
}