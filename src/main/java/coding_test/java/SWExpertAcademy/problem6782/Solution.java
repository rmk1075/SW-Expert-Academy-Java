package coding_test.java.SWExpertAcademy.problem6782;

import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			int count = 0;
			double temp = 0.0;
						
			while(N != 2) {
				temp = Math.sqrt(N);

				if((2 < N) && ((temp - (int)Math.sqrt(N) == 0))) {
					N = (int)Math.sqrt(N);
				} else {
					N++;
				}
				
				count++;
			}
			
			System.out.println("#" + (t+1) + " " + count);
		}	
	}
}
