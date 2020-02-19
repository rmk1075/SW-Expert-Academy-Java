import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Solution {
    static int T, N, M;
    static int[] pwd;
    static String[] nums;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
 
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nums = new String[N];
 
            for(int i = 0; i < N; i++) {
                nums[i] = br.readLine();
            }
 
            pwd = new int[8];
            boolean isPwd = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < nums[i].length(); j++) {
                    if(nums[i].length() <= j+7) break;
                     
                    if(map.get(nums[i].substring(j, j+7)) != null) {
 
                        if(isPwd(i, j)) {
                            isPwd = true;
                            break;
                        }
                    }
                }
                 
                if(isPwd) break;
            } 
 
            // check is right pwd
            if(check()) {
                int ans = 0;
                for(int p : pwd) ans += p;
 
                sb.append("#" + t + " " + ans + "\n");
            } else sb.append("#" + t + " 0\n");
 
        }
 
        System.out.println(sb.toString());
    }
 
    public static boolean isPwd(int x, int y) {
 
        int y_ = y;
        for(int i = 0; i < 8; i++) {
            if(map.get(nums[x].substring(y_, y_+7)) != null) {
                pwd[i] = map.get(nums[x].substring(y_, y_+7));
                y_ += 7;
            } else return false;
        }
 
        if(check()) return true;
        else return false;
    }
 
    public static boolean check() {
        if(((pwd[0] + pwd[2] + pwd[4] + pwd[6])*3 + (pwd[1] + pwd[3] + pwd[5]) + pwd[7]) % 10 == 0) return true;
        return false;
    }
}