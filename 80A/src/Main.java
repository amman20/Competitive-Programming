
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;


public class Main {//Accepted

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        public void solve(int testNumber, InputReader input, PrintWriter out) {
            int n = input.nextInt(), m = input.nextInt();
            int prime = getPrimes(n);
            if (prime == m) {
                out.println("YES");
            }else{
                out.println("NO");
            }
        }
    }

    static int getPrimes(int n) {
        ArrayList<Integer> list = new  ArrayList();
        list.add(2);
        for (int i = 3; i < 50; i+=2) {
            for (int x : list ) {
                if ( x > i / x) {
                    if (i > n) {
                        return i;
                    }
                    list.add(i);
                    break;
                }
                if (i % x == 0) {
                    break;
                }
            }
        }
        return 0;
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
