class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int n_x=Math.min(x2,xCenter);
        int n_y=Math.min(y2,yCenter);
        int x=Math.max(x1,n_x);
        int y=Math.max(y1,n_y);
        int new_x=x-xCenter;
        int new_y=y-yCenter;
        int ans=(int)((new_x*new_x)+(new_y*new_y));
        if(ans<=radius*radius){
            return true;
        }
        return false;

    }
}