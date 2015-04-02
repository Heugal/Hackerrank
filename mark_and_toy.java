import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Solution for: https://www.hackerrank.com/challenges/mark-and-toys

public class mark_and_toy {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        Arrays.sort(prices);
        
        int answer = 0;
        int sum = 0;
        // Compute the final answer from n,k,prices 
        for (int i = 0; i < n; i++){
            sum += prices[i];
            if (sum <= k){
                answer++;
            }
            else{
                break;
            }
        }
        
        System.out.println(answer);
    }
}
