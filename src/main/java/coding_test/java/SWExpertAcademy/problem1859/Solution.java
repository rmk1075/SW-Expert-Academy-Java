package coding_test.java.SWExpertAcademy.problem1859;

import java.util.Scanner;

public class Solution {

	/*	T: number of test case
	 * 	N: number of the prices
	 * 	arr[]: N prices (each price is same or lower than 10,000)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			run(sc, i);
		}
	}

	private static void run(Scanner sc, int number) {
		long result = 0;

		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		long max = 0;

		for(int i = N-1; 0 <= i; i--) {
			if(max < arr[i]) {
				max = arr[i];
			} else {
				result += max - arr[i];
			}
		}

		System.out.println("#" + (number+1) + " " + result);
	}
}