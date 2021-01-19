/*
There are n houses build in a line, each of which contains some value in it. 
A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses because the owner of the stolen houses will tell his two neighbours left and right side.
What is the maximum stolen value?

Examples:

Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
Output: 19

Top down solution JAVA
/*

// Java program to find the maximum stolen value 
import java.io.*; 
import java.util.Arrays;

public class GFG 
{ 
	// Function to calculate the maximum stolen value 
	static int maxLoot(int hval[], int dp[] ,int n) 
	{ 
	    if(n>=hval.length)
	    {
	        return 0;
	    }
        
        if(dp[n]==-1){
            
            int c1 = hval[n] + maxLoot(hval , dp, n+2);
            int c2 = maxLoot(hval , dp ,n+1);
            dp[n] = Math.max(c1,c2);
        }
		return dp[n]; 
	} 
	
	// Driver program 
	public static void main (String[] args) 
	{ 
		int hval[] = {6, 7, 1, 3, 8, 2, 4}; 
		int n = hval.length; 
		
		int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
		System.out.println("Maximum loot value : " + maxLoot(hval, dp ,0)); 
	} 
} 

// Contributed by Varun 
