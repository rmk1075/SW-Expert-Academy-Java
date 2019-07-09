package coding_test.java.SWExpertAcademy.problem1824;

import java.util.Scanner;
import java.util.Random;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String result = "YES";
			int R = sc.nextInt();
			int C = sc.nextInt();
            
			String[] arr = new String[R];
			
			for(int r = 0; r < R; r++) {
				arr[r] = sc.next();
			}
			
			int memory = 0;
			int x = 0;
			int y = 0;
			int direction = 1;
			int[][] memHistory = new int[R][C];
			int[][] memVisit = new int[R][C];
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					memVisit[r][c] = 0;
				}
			}

			while(arr[x].charAt(y) != '@') {
				if(memVisit[x][y] == 1 && memory == memHistory[x][y]) {
					result = "NO";
					break;
				}
				
				memVisit[x][y] = 1;
				memHistory[x][y] = memory;
				
				if(arr[x].charAt(y) == '<') {
					direction = 0;
				} else if(arr[x].charAt(y) == '>') {
					direction = 1;
				} else if(arr[x].charAt(y) == '^') {
					direction = 2;
				} else if(arr[x].charAt(y) == 'V') {
					direction = 3;
				} else if(arr[x].charAt(y) == '_') {
					if(memory == 0) {
						direction = 1;
					} else {
						direction = 0;
					}
				} else if(arr[x].charAt(y) == '|') {
					if(memory == 0) {
						direction = 3;
					} else {
						direction = 2;
					}
				} else if(arr[x].charAt(y) == '?') {
					Random rand = new Random();
					direction = rand.nextInt(4);
				} else if(arr[x].charAt(y) == '.') {
					
				} else if(48 <= (int)arr[x].charAt(y) && (int)arr[x].charAt(y) <= 57) {
					memory = (int)arr[x].charAt(y) - 48;
				} else if(arr[x].charAt(y) == '+') {
					memory++;
				} else if(arr[x].charAt(y) == '-') {
					memory--;
				}
                
				switch (direction) {
					case 0:
						y--;
						break;
					case 1:
						y++;
						break;
					case 2:
						x--;
						break;
					case 3:
						x++;
						break;
				}
				
				if(x < 0) x += R;
				if(R-1 < x) x -= R;
				if(y < 0) y += C;
				if(C-1 < y) y -= C;
			}
		
			System.out.println("#" + (i+1) + " " + result);
		}
		
		sc.close();
	}
}