import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	stack1.push(node);
    }
    

    
    public int pop() throws Exception {
    	if(stack2.empty() && stack1.empty()) throw new Exception();
    	if(stack2.empty()) {
    		while(! stack1.empty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
    
    public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		for(int i = 0; i < 10; i++) {
			solution.push(i + 1);
		}
		for(int i = 0; i < 10; i++) {
			System.out.print(solution.pop());
		}
    }
}

