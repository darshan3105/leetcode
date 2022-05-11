// https://leetcode.com/problems/flood-fill/
// TC: O(n*m)
// SC: O(n*m)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        int curColor = image[sr][sc];
        q.add(new int[]{sr, sc});
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            if(!isValid(image, x, y, curColor)) {
                continue;
            }
            
            image[x][y] = Integer.MAX_VALUE;
            int[] dx = new int[]{-1,0,1,0};
            int[] dy = new int[]{0,1,0,-1};
            
            for(int i=0;i<4;i++) {
                q.add(new int[]{x+dx[i], y+dy[i]});
            }
        }
        
        for(int i=0;i<image.length;i++) {
            for(int j=0;j<image[0].length;j++) {
                if(image[i][j] == Integer.MAX_VALUE) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
    
    private boolean isValid(int[][] image, int x, int y, int color) {
        return x>=0 && x<image.length && y>=0 && y<image[0].length && image[x][y] == color;
    }
}