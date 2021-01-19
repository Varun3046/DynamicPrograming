/*
There are n houses build in a line, each of which contains some value in it. A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses because the owner of the stolen houses will tell his two neighbours left and right side. What is the maximum stolen value?

Examples:

Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
Output: 19

Bottom up approach
*/

// Java program to find the maximum stolen value 
import java.io.*; 
  
public class GFG  
{ 
    // Function to calculate the maximum stolen value 
    static int maxLoot(int hval[]) 
    { 
      int dp[] = new int[hval.length+2];
      dp[hval.length] = 0;
      dp[hval.length+1] = 0;
      
      for(int i= hval.length-1;i>=0 ;i--)
      {
          dp[i] = Math.max(hval[i]+ dp[i+2] , dp[i+1]);
      }
      
      return dp[0];
    } 
      
    // Driver program 
    public static void main (String[] args)  
    { 
        int hval[] = {6, 7, 1, 3, 8, 2, 4}; 
        System.out.println("Maximum loot value : " + maxLoot(hval)); 
    } 
} 
  
