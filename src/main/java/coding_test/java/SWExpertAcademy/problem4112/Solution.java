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
		for(int i = 1; c < 10000; i++) {
			if(a < c && countA == 0) {
				locA[0] = i;
				locA[1] = a - c;
				countA = 1;
			}
			
			if(b < c && countB == 0) {
				locB[0] = i;
				locB[1] = b - c;
				countB = 1;
			}
			
			c += i;
		}
		System.out.println(locA[0] + " " + locA[1]);
		System.out.println(locB[0] + " " + locB[1]);
		
		return count;
	}
}