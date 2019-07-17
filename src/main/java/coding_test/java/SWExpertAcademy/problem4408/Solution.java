package coding_test.java.SWExpertAcademy.problem4408;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static ArrayList<Integer[]> arr;
	static boolean path[];

	public static void main(String[] args) {
		/*
		 * arr[N][2] = {start_room, destination_room}
		 * start && dest <= 400
		 */
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			
			Integer[] value = new Integer[3];
			for(int j = 0; j < N; j++) {
				value[1] = sc.nextInt();
				value[2] = sc.nextInt();
				value[0] = Math.abs(value[1] - value[2]);
				
				arr.add(value);
			}
			
			//sort arr
			
			/*
			 * for loop: i = 0 ~ length()
			 * path 채우기
			 * 	for loop: i = 1 ~ length()
			 * 		path check하면서 count++
			 */
			
			int count = 0;
			
			System.out.println("#" + (i+1) + " " + count);
		}
	}
}
