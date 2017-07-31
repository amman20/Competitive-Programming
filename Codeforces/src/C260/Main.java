package C260;

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
            int n = input.nextInt(), indx = input.nextInt();
            long[] arr = new long[n];
            long min = (long) 1e22;
            boolean zero = false;
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
                if (arr[i] != 0) {
                    min = Math.min(arr[i], min);
                } else {
                    zero = true;
                }
            }
            long count = 0;
            int i = indx - 1;
            boolean flag = false;
            
            min = zero ? 1 : min;
            while (true) {
                if (i == -1) {
                    i = n - 1;
                }
                
                if ((i == indx -1) && flag) {
                    min = 1;
                }    
                
                if (arr[i] == 0) {
                    arr[i] = count;
                    break;
                }else{
                    arr[i] -= min;
                }
                
                               
                count += min;
                i--;
                flag = true;
                
            }

            for (int j = 0; j < n; j++) {
                out.print(arr[j] + " ");
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
