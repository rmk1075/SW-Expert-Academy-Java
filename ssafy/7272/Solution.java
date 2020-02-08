import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {

    static int T;
    static String[] chars = {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String a, b;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T + 1; t++) {
            st = new StringTokenizer(br.readLine());

            a = st.nextToken();
            b = st.nextToken();

            if(check(a, b)) {
                System.out.println("#" + t + " SAME");
            } else {
                System.out.println("#" + t + " DIFF");
            }
        }
    }

    public static boolean check(String a, String b) {
        if(a.length() != b.length()) return false;
        
        for(int i = 0; i < a.length(); i++) {
            if(charCheck(a.charAt(i) + "") != charCheck(b.charAt(i) + "")) return false;
        }

        return true;
    }

    public static int charCheck(String a) {
        for(int i = 0; i < 3; i++) {
            if(chars[i].contains(a)) return i;
        }

        return -1;
    }
}