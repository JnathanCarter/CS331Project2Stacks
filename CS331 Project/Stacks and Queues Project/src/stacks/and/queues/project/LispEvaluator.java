
package stacks.and.queues.project;

/**
 *
 * @author maurz
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class LispEvaluator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        // get espression from the user
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Vector<String> li = new Vector<String>();

        StringTokenizer stoken = new StringTokenizer(input, " ");

        // add each character token to list
        while (stoken.hasMoreTokens()) {
            li.add(stoken.nextToken(" "));
        }

        // loop over list starting from the back
        for (int i = li.size() - 1; i >= 0; i--) {

            // Ignore paranthesis
            if (li.get(i).equals("(") || li.get(i).equals(")"))
                continue;
            // if an operator
            else if (li.get(i).equals("+") || li.get(i).equals("-") || li.get(i).equals("*") || li.get(i).equals("/")) {
                // while the stack has operands pop off the stack and do corresponding operation
                while (st.size() > 1) {
                    switch (li.get(i)) {
                        case "+":
                            st.push(st.pop() + st.pop());
                            break;
                        case "-":
                            st.push(st.pop() - st.pop());
                            break;
                        case "*":
                            st.push(st.pop() * st.pop());
                            break;
                        case "/":
                            st.push(st.pop() / st.pop());
                            break;
                        default:
                            break;
                    }
                }
            }
            // then must be operand and add to the stack
            else {
                int n = Integer.parseInt(li.get(i));
                st.push(n);
            }

        }

        System.out.println(input + " evaluates to " + st.peek());

    }

}
