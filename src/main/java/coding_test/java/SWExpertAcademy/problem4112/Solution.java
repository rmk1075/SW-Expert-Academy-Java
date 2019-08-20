package coding_test.java.SWExpertAcademy.problem4112;

import java.util.Scanner;

public class Solution {
	static int T;
	static int a, b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			System.out.println("#" + (i+1) + " " + run(a, b));
		}
	}
	
	public static int run(int a, int b) {
		if(a == b) return 0;
		
		int count = 0;
		int countA = 0;
		int countB = 0;
		int[] locA = new int[2];
		int[] locB = new int[2];
		
		int c = 1;
		for(int i = 1; c < 10013; i++) {
			if(countA ==1 && countB == 1) break;
			
			if(a < c && countA == 0) {
				locA[0] = i-1;
				locA[1] = a - c + i;
				countA = 1;
			}
			
			if(b < c && countB == 0) {
				locB[0] = i-1;
				locB[1] = b - c + i;
				countB = 1;
			}
			
			c += i;
		}
		
		count += Math.abs(locA[0] - locB[0]);
		if(Math.abs(locA[1] - locB[1]) > Math.abs(locA[0] - locB[0])) {
			count += Math.abs(locA[1] - locB[1]) - Math.abs(locA[0] - locB[0]);
		}
		
		return count;
	}
}