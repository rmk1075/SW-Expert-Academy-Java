package coding_test.java.SWExpertAcademy.problem2819;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	/*
	 * board[4][4]
	 * value: 0~9
	 * 0000000 -> generate 7 digits number
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			run(sc, i);
		}
	}
	
	private static void run(Scanner sc, int number) {
		int[][] arr = new int[4][4];
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("#" + number + " " + result.size());
	}

}
