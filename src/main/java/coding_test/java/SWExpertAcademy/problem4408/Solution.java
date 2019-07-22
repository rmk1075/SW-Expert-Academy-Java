package coding_test.java.SWExpertAcademy.problem4408;

import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	static int T;
	static int N;
	static int[] path;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			path = new int[201];
			
			for(int j = 0; j < N; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(x%2 == 1) x++;
				if(y%2 == 1) y++;
				
				int temp;
				if(y < x) {
					temp = x;
					x = y;
					y = temp;
				}
				
				for(int k = x/2; k <= y/2; k++) {
					path[k]++;
				}
			}

			Arrays.sort(path);			
			int result = path[200];
			
			System.out.println("#" + (i+1) + " " + result);
		}
	}
}
