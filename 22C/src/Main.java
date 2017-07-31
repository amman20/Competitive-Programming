
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {//accepted

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            int n = input.nextInt();
        int m = input.nextInt(); 
        int v = input.nextInt();
        int min = n -1;
        int max = min + ((n - 3) * (n - 2) / 2);
        if (m < min || m > max) {
            out.println("-1");
        } else {
            int count = 0;
            int point = -1;
            
            //connect servers to v
            for (int i = 1; i <= n; i++) {
                if (i == v) {
                    continue;
                }
                out.println(i + " " + v);
                count++;
                point = i;
            }
            
            //connections between them
            for (int i = 1; i < point - 1 && count < m; i++) {
                if (i == v) {
                    continue;
                }
                for (int j = i + 1; j < point && count < m; j++) {
                    if (j == v) {
                        continue;
                    }
                    out.println(i + " " + j);
                    count++;
                }
            }
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
