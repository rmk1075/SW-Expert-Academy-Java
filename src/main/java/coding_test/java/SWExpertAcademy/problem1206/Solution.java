package coding_test.java.SWExpertAcademy.problem1206;

import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	/*
	 * number of test cases = 10
	 * width <= 1000
	 * left 2 & right 2 -> no element
	 * maximum highest = 255
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int i = 0; i < T; i++) {
			run(sc, i);
		}		
	}

	public static void run(Scanner sc, int number) {
		int result = 0;
		
		int width = sc.nextInt();
		int[] arr = new int[width];
		
		for(int i = 0; i < width; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 2; i < width-2; i++) {
			int[] temp = new int[5];
			
			for(int j = 0; j < 5; j++) {
				temp[j] = arr[i-2+j];
			}
			
			Arrays.sort(temp);
			if(temp[4] == arr[i]) {
				result += arr[i] - temp[3];
			}
		}
		
		System.out.println("#" + (number+1) + " " + result);
	}
}
