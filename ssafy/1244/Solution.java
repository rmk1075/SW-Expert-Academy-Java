import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int T, C, MAX_VAL, maxVal;
    static String nums;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            maxVal = Integer.MIN_VALUE;
            nums = sc.next();
            C = sc.nextInt();

            // maxval
            char[] temp = nums.toCharArray();
            Arrays.sort(temp);
            int c = 1, tmp = 0;
            for (int i = 0; i < temp.length; i++) {
                tmp += (temp[i] - '0') * c;
                c *= 10;
            }
            MAX_VAL = tmp;

            // visited
            visited = new boolean[MAX_VAL + 1][C];
            find(0);

            sb.append("#" + t + " " + maxVal + "\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }

    public static void find(int count) {
        int num = Integer.parseInt(nums);

        // return
        if(count == C) {
            maxVal = Math.max(maxVal, num);
            return ;
        }

        // visited
        if (visited[num][count]) return ;
        visited[num][count] = true;

        // dfs
        for (int i = 0; i < nums.length(); i++) {
            for (int j = i + 1; j < nums.length(); j++) {
                swap(i, j);
                find(count+1);
                swap(i, j);
            }
        }
    }

    public static void swap(int x, int y) {
        StringBuilder str = new StringBuilder(nums);
        char temp = str.charAt(x);
        str.setCharAt(x, str.charAt(y));
        str.setCharAt(y, temp);

        nums = str.toString();
    }
}

// import java.util.Arrays;
// import java.util.Scanner;

// public class Solution {
//     static int T, C, MAX_VAL, maxVal;
//     static char[] nums;
//     static boolean[][] visited;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         StringBuilder sb = new StringBuilder();
        
//         T = sc.nextInt();
//         for(int t = 1; t <= T; t++) {
//             maxVal = Integer.MIN_VALUE;
//             nums = sc.next().toCharArray();
//             C = sc.nextInt();

//             char[] temp = new char[nums.length];
//             for(int i = 0; i < nums.length; i++) {
//                 temp[i] = nums[i];
//             }
//             Arrays.sort(temp);
//             int c = 1, tmp = 0;
//             for(int i = 0; i < temp.length; i++) {
//                 tmp += (temp[i]-'0') * c;
//                 c *= 10;
//             }
//             MAX_VAL = tmp;
            
//             visited = new boolean[MAX_VAL+1][C];
//             find(0);
//             sb.append("#" + t + " " + maxVal+ "\n");
//         }
//         sc.close();
//         System.out.println(sb.toString());
//     }

//     public static boolean find(int count) {
//         int num = toInt(nums);
//         if(count == C) {
//             maxVal = Math.max(maxVal, num);
//             if(maxVal == MAX_VAL) return true;
//             return false;
//         }

//         if(visited[num][count]) return false;
//         visited[num][count] = true;
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = i+1; j < nums.length; j++) {
//                 swap(i, j);
//                 if(find(count+1)) return true;
//                 swap(i, j);
//             }
//         }
//         return false;
//     }

//     public static void swap(int x, int y) {
//         char temp = nums[x];
//         nums[x] = nums[y];
//         nums[y] = temp;
//     }

//     public static int toInt(char[] arr) {
//         int result = 0, temp = 1;
//         for(int i = 0; i < arr.length; i++) {
//             result += temp*(arr[arr.length-1-i]-'0');
//             temp *= 10;
//         }
//         return result;
//     }
// }