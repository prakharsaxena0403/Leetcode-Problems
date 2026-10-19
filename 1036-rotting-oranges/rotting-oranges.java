class Solution {
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int countFresh = 0;
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }

        int[] drow = new int[]{-1,0,1,0};
        int[] dcol = new int[]{0,1,0,-1};
        int count= 0;
        int maxTime = 0;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            maxTime = Math.max(maxTime,time);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow = drow[i] + row;
                int mcol = dcol[i] + col;
                if(nrow<n && nrow>=0 && mcol<m && mcol>=0 && grid[nrow][mcol]==1 && vis[nrow][mcol]==0){
                    q.add(new Pair(nrow,mcol,time+1));
                    grid[nrow][mcol] = 2;
                    vis[nrow][mcol] = 2;
                    count++;
                }
            }


        }
            if(count!=countFresh) return -1;
            return maxTime;
    }
}