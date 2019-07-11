package coding_test.java.SWExpertAcademy.problem1824;

import java.util.Scanner;

public class Solution {
	
	static char[][] arr;
	static int R;
	static int C;
	static boolean[][][][] memHistory;
	static boolean exit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			test(sc, i);
		}
		
		sc.close();
	}
	
	public static void test(Scanner sc, int testNumber) {
		R = sc.nextInt();
		C = sc.nextInt();
		memHistory = new boolean[R][C][4][16];
		arr = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String line = sc.next();
			for(int c = 0; c < C; c++) {
				arr[r][c] = line.charAt(c);
			}
		}
		
		boolean end = false;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(arr[r][c] == '@') end = true;
			}
		}
        
		exit = false;
		//it has exit character '@'
		if(end) run(0, 0, 0, 1);
		
		System.out.println("#" + (testNumber+1) + " " + (exit?"YES":"NO"));
	}
	
	public static void run(int memory, int x, int y, int direction) {
		
		if(y < 0) y = C+y;
		if(C-1 < y) y -= C;
		if(R-1 < x) x -= R;
		if(x < 0) x = R+x;
		
		if(memory < 0) memory += 16;
		if(15 < memory) memory = 16 - memory;		

		//System.out.println(x + " " + y + " " + arr[x].charAt(y) + " " + memory + " " +memHistory[x][y][direction][memory]);
		
		//exit
		if(arr[x][y] == '@') {
			exit = true;
			return ;
		}
		
		//already visit
		if(memHistory[x][y][direction][memory]) {
            return ;
        }
		
		//visited node
		memHistory[x][y][direction][memory] = true;
		
		switch(arr[x][y]) {
		case '<': direction = 0; break;
		case '>': direction = 1; break;
		case '^': direction = 2; break;
		case 'v': direction = 3; break;
		case '_': direction = (memory == 0 ? 1:0); break;
		case '|': direction = (memory == 0 ? 3:2); break;
		case '+': memory++; break;
		case '-': memory--; break;
		case '0':case '1':case '2':case '3':case '4':
		case '5':case '6':case '7':case '8':case '9': memory = arr[x][y]-'0'; break;
		}
		
		//char is ?
		if(arr[x][y] == '?') {
			String[] q = new String[4];
			
			for(int k = 0; k < 4; k++) {
				if(k == 0) {
					run(memory, x, y-1, k);
				} else if(k == 1) {
					run(memory, x, y+1, k);
				} else if(k == 2) {
					run(memory, x+1, y, k);
				} else if(k == 3) {
					run(memory, x-1, y, k);
				}
			}
		} else {
			switch (direction) {
			case 0:
				run(memory, x, y-1, direction);
				break;
			case 1:
				run(memory, x, y+1, direction);
				break;
			case 2:
				run(memory, x-1, y, direction);
				break;
			case 3:
				run(memory, x+1, y, direction);
				break;
			}
		}
	}
}