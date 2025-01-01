class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int new_x=Math.max(x1,Math.min(x2,xCenter))-xCenter;
        int new_y=Math.max(y1,Math.min(y2,yCenter))-yCenter;
        int ans=(int)((new_x*new_x)+(new_y*new_y));
        if(ans<=radius*radius){
            return true;
        }
        return false;

    }
}