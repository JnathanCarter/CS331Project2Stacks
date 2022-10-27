
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

Scanner sc = new Scanner(System.in);

String input = sc.nextLine();

Vector<String> li = new Vector<String>();

StringTokenizer stoken = new StringTokenizer(input," ");

while (stoken.hasMoreTokens()) {
    li.add(stoken.nextToken(" "));
}
    
for(int i=li.size()-1;i>=0;i--) {

if( li.get(i).equals("(") || li.get(i).equals(")"))
    continue;
else if(li.get(i).equals("+") || li.get(i).equals("-") || li.get(i).equals("*") || li.get(i).equals("/") )
{
    while(st.size()>1)
    {
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
else
{
    int n = Integer.parseInt(li.get(i));
    st.push(n);
}

}

System.out.println(input + " evaluates to " + st.peek());

}

}


