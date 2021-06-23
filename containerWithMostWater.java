Idea is to find the max amount of water b/w two points , the formula is essentially 
  => maxWater = Math.max(Math.min(height[l],height[r])*(r-l), maxWater); where land r are left and right points on x axis respectively
  maxwater is local variable to track maxwater so far observed
     |
 |x x|
 |x|x| the max water would be the minimum of height b/w two points times the difference b/w the two points i.e. Math.min(height[l],height[r])*(r-l)
 keep comparing with the variable maxWater for maximum
 if(height[l]<height[r]) => move left++ as the water would not spill else move right++


class Solution {
    public int maxArea(int[] height) {
        // int maxWater = 0;
        // int len = height.length;
        // for(int i=0;i<len;i++)
        // {
        //     for(int j=i+1;j<len;j++)
        //     {
        //         maxWater = Math.max(Math.min(height[i],height[j])*(j-i), maxWater);
        //     }
        // }
        // return maxWater;
        
        int maxWater = 0;
        int l=0,r= height.length -1;
        
        while(l<r)
        {
            maxWater = Math.max(Math.min(height[l],height[r])*(r-l), maxWater);
            
            if(height[l]<height[r])
            {
                l++;   // this maneuver is to find the largest height for the two containers
            }
            else r--;
        }
        return maxWater;
    }
}
