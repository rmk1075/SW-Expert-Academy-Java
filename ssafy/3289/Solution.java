import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int T, N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        StringBuilder ans;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            ans = new StringBuilder();
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            arr = new int[N + 1];
            for(int i = 1; i < N + 1; i++) {
                arr[i] = i;
            }
 
            int op, a, b;
            for(int i = 0; i < M; i++) {
 
                st = new StringTokenizer(br.readLine());
 
                op = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
 
                if(op == 0) {
 
                    union(a, b);
 
                } else {
 
                    if(find(a) == find(b)) {
                        ans.append(1);
                    } else ans.append(0);
 
                }
            }
 
            sb.append("#" + t + " " + ans + "\n");
        }
 
        System.out.println(sb.toString());
    }
 
    public static void union(int a, int b) {
        
        a = find(a);
        b = find(b);
        
        if (a == b)
            return;
        
        arr[b] = a;
    }
 
    public static int find(int a) {
 
        if(arr[a] == a) return a;
 
        return arr[a] = find(arr[a]);
    }
}