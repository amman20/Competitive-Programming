
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import static java.lang.System.in;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {//ACCEPTED

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            int n = input.nextInt(), k = input.nextInt();
            ArrayList<Integer> primes = primes(n);
            
            if (k == 0) {
                out.print("YES");
                return;
            }
            if (primes.size() < 6) {
                System.out.println("NO");
                return;
            }

            for (int i = 5; i < primes.size(); i++) {
                for (int j = i; primes.get(j - 1) + primes.get(j - 2) + 1 >= primes.get(i); j--) {
                    if (primes.get(j - 1) + primes.get(j - 2) + 1 == primes.get(i)) {
                        k--;
                        break;
                    }
                }
                if (k == 0) {
                    break;
                }
            }
            System.out.print(k == 0 ? "YES" : "NO");
        }

        static ArrayList<Integer> primes(int mx) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(2);
            for (int i = 3; i <= mx; i += 2) {
                for (int x : res) {
                    if (x > i / x) {
                        res.add(i);
                        break;
                    }
                    if (i % x == 0) {
                        break;
                    }
                }
            }
            return res;
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
