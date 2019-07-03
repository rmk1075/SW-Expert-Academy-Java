package coding_test.java.SWExpertAcademy.problem2819;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static HashSet<Integer> result;
	static int[][] arr;
	static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			run(sc, i);
		}
	}
	
	private static void run(Scanner sc, int number) {
		result = new HashSet<Integer>();
		arr  = new int[4][4];
				
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
				
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				generateNumber(i, j, 0, arr[i][j]);
		
		System.out.println("#" + (number+1) + " " + result.size());
	}
	
	public static void generateNumber(int x, int y, int count, int number) {		
		if(count == 7)  {
			result.add(number);
			return ;
		}

		for(int i = 0; i < 4; i++) {
			int m = x + dx[i];
			int n = y + dy[i];
			
			 if(m < 0 || m >=4 || n < 0 || n >= 4) continue;
			
			generateNumber(m, n, count+1, number * 10 + arr[x][y]);
		}
	}
}