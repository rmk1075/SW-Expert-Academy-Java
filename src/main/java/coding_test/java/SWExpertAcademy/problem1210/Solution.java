package coding_test.java.SWExpertAcademy.problem1210;

import java.util.Scanner;

public class Solution {
	static int arr[][];
	static int T = 10;
    static int result = 0;
	static int x = 99;
	static int y = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();	
			run(sc, num);
		}
	}
	
	public static void run(Scanner sc, int number) {
		arr = new int[100][100];
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2) y = j;
			}
		}	

		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}	
		
		while(x != 0) {
			arr[x][y] = 2;
			
			if(0 < y && arr[x][y-1] == 1) {
				y--;
			} else if (y < 99 && arr[x][y+1] == 1) {
                y++;
			} else if (arr[x-1][y] == 1) {
                x--;
			}		
		}
		
		result = y;
		System.out.println("#" + number + " " + result);
	}
}