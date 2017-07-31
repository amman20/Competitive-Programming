
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {//Accepted

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            HashMap<String, Integer> hm = new HashMap();

            hm.put("C", 0);
            hm.put("C#", 1);
            hm.put("D", 2);
            hm.put("D#", 3);
            hm.put("E", 4);
            hm.put("F", 5);
            hm.put("F#", 6);
            hm.put("G", 7);
            hm.put("G#", 8);
            hm.put("A", 9);
            hm.put("B", 10);
            hm.put("H", 11);

            String[] str = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};

            String s1 = input.next();
            String s2 = input.next();
            String s3 = input.next();
            out.println(check(hm, s1, s2, s3, str));
        }

        static String check(HashMap<String, Integer> hm, String s1, String s2, String s3, String[] str) {
            int c1 = 0;
            int c2 = 0;

            //try all posibilites
            int n = 5;

            for (int i = 0; i <= n; i++) {
                String t = s1;
                int indx = hm.get(s1);
                while (!t.equals(s2)) {
                    c1++;
                    indx = (++indx) % 12;
                    t = str[indx];
                }
                while (!t.equals(s3)) {
                    c2++;
                    indx = (++indx) % 12;
                    t = str[indx];
                }
                if (c1 == 4 && c2 == 3 || c1 == 3 && c2 == 4) {
                    break;
                } else {
                    c1 = c2 = 0;
                    String temp;
                    if (i == 0) {
                        temp = s2;
                        s2 = s3;
                        s3 = temp;
                    } else if (i == 1) {
                        temp = s1;
                        s1 = s3;
                        s3 = temp;
                    } else if (i == 2) {
                        temp = s2;
                        s2 = s3;
                        s3 = temp;
                    } else if (i == 3) {
                        temp = s1;
                        s1 = s3;
                        s3 = temp;
                    } else {
                        temp = s2;
                        s2 = s3;
                        s3 = temp;
                    }
                }
            }
            if (c1 == 4 && c2 == 3) {
                return "major";
            } else if (c1 == 3 && c2 == 4) {
                return "minor";
            } else {
                return "strange";
            }
        }
    }
}

class InputReader {

    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

}
