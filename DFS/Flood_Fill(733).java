class Solution {
    private void dfs(int[][] img , int r , int c , int org , int col){
        if(r >= img.length || r < 0 || c >= img[0].length || c < 0){
            return ;
        }
        if(img[r][c] != org) return ; // check remove calling dfs

        img[r][c] = col ;
        dfs(img , r+1 , c ,org , col);
        dfs(img , r-1 , c ,org , col);
        dfs(img , r , c+1 ,org , col);
        dfs(img , r , c-1 ,org , col);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int org = image[sr][sc] ;
        
        if(org == color) return image ;
        dfs(image , sr , sc ,org , color); // alway start from mention point
        return image ;
    }
}
