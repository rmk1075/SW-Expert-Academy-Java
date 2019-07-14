package coding_test.java.SWExpertAcademy.problem3752;

import java.util.Scanner;

public class Solution {

	static boolean arr[];
	static int T;
	static int N;
	
	public static void main(String[] args) {
		/*
		 * find the number of possible cases with a score that students can get
		 * N: number of problems
		 * -> each problem has allocated point
		 */
	
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		//each test case
		for(int i = 0; i < T; i++) {
			int result = 0;
			
			arr = new boolean[10001];
			arr[0] = true;
			
			N = sc.nextInt(); //number of problems
			
			int sum = 0;
			//point of each problem
			for(int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				sum += temp;

				for(int k = sum; k >= 0; k--) {
					if(arr[k]) {
						arr[k+temp] = true;
					}
				}
			}
			
			for (boolean b : arr) {
				if(b) result++;
			}
			
			System.out.println("#" + (i+1) + " " + result);
		}
	}
}