// Using dynamic programming
// Algorithm

// Find maximum height of bar from the left end upto an index i in the array left_max.
// Find maximum height of bar from the right end upto an index i in the arrayright_max.
// Iterate over the \text{height}height array and update ans:
// Add min(left_max[i],right_max[i]) - height[i] to ans

class Solution {
    public int trap(int[] height) {
      
    if(height.length==0)
            return 0;
        int ans=0;
        int size = height.length;
        int rightMax[]= new int[size];
        int leftMax[]= new int[size];
        leftMax[0] = height[0];
        int i; 
        for( i=1; i<size;i++)
        {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        rightMax[size-1] = height[size-1];
          for(i=size-2; i>=0;i--)
        {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        for(i=0;i<size;i++)
        {
            ans+=Math.min(rightMax[i],leftMax[i]) - height[i];
        }
        return ans;
    }
}

// Using two pointers

class Solution {
    public int trap(int[] height) {
      
 int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]); // watwr is only stored when height is smaller than left max
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
    }
}
