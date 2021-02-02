
/*
Given two strings str1 and str2 and below operations that can be performed on str1. Find the minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.
*/

import java.io.*; 
import java.util.Arrays;
public class GFG 
{ 
	// Function to calculate the min no of operations
	static int convertOneStringToAnother(String s1 , int l1 ,  String s2, int l2, int dp[][]) 
	{ 

        if(l1>s1.length()-1)
        {
            return s2.length() - l2;
        }
        if(l2>s2.length()-1)
        {
            return s1.length() - l1;
        }
                System.out.println(s1+".."+s2+"  "+l1+" "+l2);

        if(s1.charAt(l1)==s2.charAt(l2))
        {
            return convertOneStringToAnother(s1,l1+1,s2,l2+1,dp);
        }
        
        if(dp[l1][l2]==0)
        {
            dp[l1][l2]=  Math.min(
                Math.min(convertOneStringToAnother(s1,l1,s2,l2+1,dp),
                convertOneStringToAnother(s1,l1+1,s2,l2+1,dp)),
                convertOneStringToAnother(s1,l1+1,s2,l2,dp)
                ) +1 ;
        }
        
        return dp[l1][l2];
        
	} 
	
	// Driver program 
	public static void main (String[] args) 
	{ 

        String s1= "porque";
        String s2 = "java";
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        System.out.println(dp);
        
		System.out.println("Minimum number of operations: " + convertOneStringToAnother(s1 , 0, s2, 0, dp)); 
	} 
} 
