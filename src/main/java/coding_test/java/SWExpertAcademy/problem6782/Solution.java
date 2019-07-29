package coding_test.java.SWExpertAcademy.problem6782;

import java.util.Scanner;

public class Solution {
	static int T;
	static long N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextLong();
			int count = 0;
			double temp = 0.0;
            
			while(N != 2) {
				temp = Math.sqrt(N);
				if((int)temp == temp) {
					N = (int)temp;
				} else {
					temp = (int)temp;
					count += ((temp+1) * (temp+1) - N);
					N = (int)Math.sqrt((temp + 1) * (temp + 1));
				}
				
				count++;
			}
			
			System.out.println("#" + (t+1) + " " + count);
		}	
	}
}