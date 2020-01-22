import java.util.Scanner;

class Solution{
    static int T;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            String line = sc.next();
            String init = "";
            for(int i = 0; i < line.length(); i++) {
                init += "0";
            }

            int count = 0;
            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) != init.charAt(i)) {
                    String temp = "";
                    count++;
                    for(int j = i; j < line.length(); j++) {
                        temp += line.charAt(i);
                    }

                    init = init.substring(0, i) + temp;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
        
        sc.close();
	}
}