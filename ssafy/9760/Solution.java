// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;
 
// public class Solution {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         int T = Integer.parseInt(br.readLine());
//         for(int t = 1; t <= T; t++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int[][] cards = new int[5][2];
//             for(int i = 0; i < 5; i++) {
//                 char[] card = st.nextToken().toCharArray();
//                 cards[i][0] = card[0];
//                 switch (card[1]) {
//                     case 'A':
//                         cards[i][1] = 1;
//                         break;
//                     case 'T':
//                         cards[i][1] = 10;
//                         break;
//                     case 'J':
//                         cards[i][1] = 11;
//                         break;
//                     case 'Q':
//                         cards[i][1] = 12;
//                         break;
//                     case 'K':
//                         cards[i][1] = 13;
//                         break;
//                     default:
//                         cards[i][1] = card[1] - '0';
//                         break;
//                 }
//             }
 
//             boolean flush = cards[0][0] == cards[1][0] && cards[1][0] == cards[2][0] && cards[2][0] == cards[3][0] && cards[3][0] == cards[4][0];
//             boolean straight = straight(cards);
//             int[] values = value(cards);

//             if(values[13] == 1 && flush && straight) sb.append("#" + t + " Straight Flush\n");
//             else if(values[13] == 4) sb.append("#" + t + " Four of a Kind\n");
//             else if(values[13] == 3 && values[12] == 2) sb.append("#" + t + " Full House\n");
//             else if(flush) sb.append("#" + t + " Flush\n");  
//             else if(values[13] == 1 && straight) sb.append("#" + t + " Straight\n");
//             else if(values[13] == 3) sb.append("#" + t + " Three of a kind\n");
//             else if(values[13] == 2 && values[12] == 2) sb.append("#" + t + " Two pair\n");
//             else if(values[13] == 2) sb.append("#" + t + " One pair\n");
//             else sb.append("#" + t + " High card\n");
//         }
//         System.out.println(sb);
//     }
 
//     public static boolean straight(int[][] cards) {
//         int[] arr = new int[5];
//         for(int i = 0; i < 5; i++) arr[i] = cards[i][1];
//         Arrays.sort(arr);
//         if(arr[1] + 1 == arr[2] && arr[2] + 1 == arr[3] && arr[3] + 1 == arr[4]) {
//             if(arr[0] + 1 == arr[1]) return true;
//             if(arr[0] == 1 && arr[4] == 13) return true;
//         }
//         return false;
//     }
 
//     public static int[] value(int[][] cards) {
//         int[] arr = new int[14];
//         for(int i = 0; i < 5; i++) arr[cards[i][1]]++;
//         Arrays.sort(arr);
//         return arr;
//     }
// }

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[] suit, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            suit = new int[4];
            rank = new int[14];
            for(int i = 0; i < 5; i++) {
                char[] temp = st.nextToken().toCharArray();
                switch(temp[0]) {
                    case 'S':
                        suit[0]++;
                        break;
                    case 'D':
                        suit[1]++;
                        break;
                    case 'H':
                        suit[2]++;
                        break;
                    case 'C':
                        suit[3]++;
                        break;
                }
                switch(temp[1]) {
                    case 'A':
                        rank[1]++;
                        break;
                    case 'T':
                        rank[10]++;
                        break;
                    case 'J':
                        rank[11]++;
                        break;
                    case 'Q':
                        rank[12]++;
                        break;
                    case 'K':
                        rank[13]++;
                        break;
                    default:
                        rank[temp[1] - '0']++;
                }
            }

            boolean flush = flush();
            boolean straight = straight(rank);
            int[] sorted = sort();
            if(flush && straight) sb.append("#" + t + " Straight Flush\n");
            else if(sorted[13] == 4) sb.append("#" + t + " Four of a Kind\n");
            else if(sorted[13] == 3 && sorted[12] == 2) sb.append("#" + t + " Full House\n");
            else if(flush) sb.append("#" + t + " Flush\n");
            else if(straight) sb.append("#" + t + " Straight\n");
            else if(sorted[13] == 3) sb.append("#" + t + " Three of a kind\n");
            else if(sorted[13] == 2 && sorted[12] == 2) sb.append("#" + t + " Two pair\n");
            else if(sorted[13] == 2) sb.append("#" + t + " One pair\n");
            else sb.append("#" + t + " High card\n");
        }
        System.out.println(sb);
    }

    public static boolean flush() {
        for(int i = 0; i < 4; i++) if(suit[i] == 5) return true;
        return false;
    }

    public static int[] sort() {
        int[] arr = new int[14];
        for(int i = 0; i < 14; i++) arr[i] = rank[i];
        Arrays.sort(arr);
        return arr;
    }

    public static boolean straight(int[] arr) {
        for(int i = 1; i < 10; i++) {
            if(arr[i] == 1) {
                int c = 1;
                for(int j = 1; j < 5 && (i + j) < 14; j++) {
                    if(arr[i+j] == 1) c++;
                }
                if(c == 5) return true;
                else break;
            }
        }
        if(arr[1] == 1 && arr[10] == 1 && arr[11] == 1 && arr[12] == 1 && arr[13] == 1) return true;
        return false;
    }
}