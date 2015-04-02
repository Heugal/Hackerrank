import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Solution for: https://www.hackerrank.com/challenges/find-digits

public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lim = Integer.parseInt(in.next());
        for (int i = 0; i < lim; i++){
            int count = 0;
            String temp = in.next();
            int N = Integer.parseInt(temp);
            int[] ar = new int[temp.length()];
            // create an integer array from the string in stdin
            for (int j = 0; j < temp.length(); j++){
                ar[j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
            
            for (int j = 0; j < temp.length(); j++){
                if (ar[j] != 0){
                    if (N%ar[j] == 0){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}