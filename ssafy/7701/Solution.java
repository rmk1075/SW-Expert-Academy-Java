import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            TreeSet<String>[] trees = new TreeSet[51];
            for(int i = 0; i < 51; i++) trees[i] = new TreeSet<String>();            

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                if(trees[str.length()].add(str));
            }

            sb.append("#" + t + "\n");
            for(int i = 1; i < 51; i++) {
                for(String str : trees[i]) sb.append(str + "\n");
            }
        }

        System.out.println(sb);
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Comparator;
// import java.util.TreeSet;

// public class Solution {
//     static int T, N;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         T = Integer.parseInt(br.readLine());
//         for (int t = 1; t <= T; t++) {
//             TreeSet<String> names = new TreeSet<>(new Comparator<String>() {
//                 @Override
//                 public int compare(String o1, String o2) {
//                     int r = o1.length() - o2.length();
//                     if(r == 0) return o1.compareTo(o2);
//                     return r;
//                 }
//             });

//             N = Integer.parseInt(br.readLine());
//             for (int i = 0; i < N; i++) names.add(br.readLine());

//             sb.append("#" + t + "\n");
//             for(String str : names) sb.append(str + "\n");
//         }

//         System.out.println(sb);
//     }
// }

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.HashSet;
// import java.util.PriorityQueue;
// import java.util.Set;

// class Element implements Comparable<Element> {
//     String str;

//     Element(String str) {
//         this.str = str;
//     }

//     @Override
//     public int compareTo(Element o) {
//         if (this.str.length() == o.str.length())
//             return (this.str.compareTo(o.str) < 0) ? -1 : 1;
//         return (this.str.length() < o.str.length()) ? -1 : 1;
//     }
// }

// public class Solution {
//     static int T, N;
//     static Set<String> names;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         T = Integer.parseInt(br.readLine());
//         for (int t = 1; t <= T; t++) {
//             names = new HashSet<>();
//             N = Integer.parseInt(br.readLine());
//             for (int i = 0; i < N; i++) names.add(br.readLine());

//             PriorityQueue<Element> pq = new PriorityQueue<>();
//             for (String str : names) pq.offer(new Element(str));

//             sb.append("#" + t + "\n");
//             while (!pq.isEmpty()) sb.append(pq.poll().str + "\n");
//         }

//         System.out.println(sb.toString());
//     }
// }