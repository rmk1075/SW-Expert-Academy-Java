package coding_test.java.SWExpertAcademy.problem1824;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			run(sc, i);
		}
	}
	
	private static void run(Scanner sc, int number) {
		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//System.out.println("#" + (number+1) + " " + result);
	}
}
