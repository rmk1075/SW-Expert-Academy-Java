package coding_test.java.SWExpertAcademy.problem1824;

import java.util.Scanner;

public class Solution {
	
	static String[] arr;
	static int R;
	static int C;
	static boolean[][][][] memHistory;
	static boolean find;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String result = "NO";
			R = sc.nextInt();
			C = sc.nextInt();
			memHistory = new boolean[R][C][4][16];
						
			arr = new String[R];
			
			for(int r = 0; r < R; r++) {
				arr[r] = sc.next();
			}
			
			boolean end = false;
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(arr[r].charAt(c) == '@') end = true;
				}
			}
			
			int memory = 0;
			int x = 0;
			int y = 0;
			int direction = 1;
	        
			if(end) result = run(memory, x, y, direction);
			
			System.out.println("#" + (i+1) + " " + result);
		}
		
		sc.close();
	}

	public static String run(int mem, int x_, int y_, int di) {
		int memory = mem;
		int x = x_;
		int y = y_;
		int direction = di;
		
		if(arr[x].charAt(y) == '@') {
			return "YES";
		}
		
		//System.out.println(x + " " + y + " " + arr[x].charAt(y) + " " + memory + " " +memHistory[x][y][direction][memory]);
		
		if(memHistory[x][y][direction][memory]) {
            return "NO";
        }
		
		if(arr[x].charAt(y) == '?') {
			String[] q = new String[4];
			
			for(int k = 0; k < 4; k++) {
				if(k == 0) {
					q[k] = run(memory, x, y-1, k);
				} else if(k == 1) {
					q[k] = run(memory, x, y+1, k);
				} else if(k == 2) {
					q[k] = run(memory, x+1, y, k);
				} else if(k == 3) {
					q[k] = run(memory, x-1, y, k);
				}
				
				if(q[k] == "YES") return "YES";
			}

			return "NO";
		}
		
		switch(arr[x].charAt(y)) {
		case '<': direction = 0; break;
		case '>': direction = 1; break;
		case '^': direction = 2; break;
		case 'v': direction = 3; break;
		case '_': direction = (memory == 0 ? 1:0); break;
		case '|': direction = (memory == 0 ? 3:2); break;
		case '+': memory++; break;
		case '-': memory--; break;
		case '0':case '1':case '2':case '3':case '4':
		case '5':case '6':case '7':case '8':case '9': memory = arr[x].charAt(y)-'0'; break;
		}
		
		if(memory < 0) memory += 15;
		if(15 < memory) memory = 15 - memory;
	
		memHistory[x][y][direction][memory] = true;
				
		switch (direction) {
			case 0:
				y--;
				if(y < 0) y = C+y;
				break;
			case 1:
				y++;
				if(C-1 < y) y -= C;
				break;
			case 2:
				x++;
				if(R-1 < x) x -= R;
				break;
			case 3:
				x--;
				if(x < 0) x = R+x;
				break;
		}
		
		run(memory, x, y, direction);
		
		return "YES";
	}
}