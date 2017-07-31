package C34;

/**
 *
 * @author Abdulrahman Mobarak
 */
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
    
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
    
    static class TaskA {
        
        public void solve(int testNumber, InputReader input, PrintWriter out) throws IOException {
            String[] s = input.next().split(",");
            TreeSet<Integer> ts = new TreeSet();
            for (int i = 0; i < s.length; i++) {
                ts.add(Integer.parseInt(s[i]));
            }
            int arr[] = new int[ts.size()];
            Iterator<Integer> iter = ts.iterator();
            int i = 0;
            while (ts.iterator().hasNext() && i != arr.length) {
                arr[i] = iter.next();
                i++;
            }
            Stack<Integer> stack = new Stack();
            stack.push(arr[0]);
            boolean poped = false;
            for (int j = 1; j < arr.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(arr[j]);
                }
                if (arr[j] - arr[j - 1] == 1) {
                    stack.push(arr[j]);
                } else {
                    if (stack.size() > 1) {
                        int r = stack.pop();
                        int l = 0;
                        while (!stack.isEmpty()) {
                            l = stack.pop();
                        }
                        out.print(l + "-" + r);
                        stack.push(arr[j]);
                    } else {
                        out.print(stack.pop());
                    }
                    poped = true;
                }
                out.print(poped && j < arr.length - 1 ? "," : "");
                poped = false;
            }
            while (!stack.isEmpty()) {
                if (stack.size() > 1) {
                    int temp = stack.pop();
                    int temp1 = stack.pop();
                    if (temp - temp1 == 1) {
                        while (!stack.isEmpty() && temp - temp1 == 1) {
                            temp1 = stack.pop();
                        }
                        out.print(temp1 + "-" + temp);
                    }else{
                         out.print(temp1 + "-" + temp);
                    }
                } else {
                    out.print("," + stack.pop());
                }
                
            }
            
        }
    }
    
    static class InputReader {
        
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
}
