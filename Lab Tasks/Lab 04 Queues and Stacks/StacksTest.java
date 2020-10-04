
public class StacksTest {
	public static void main(String[] args) {
		// testing for the isPalindrome function
		System.out.println(isPalindrome("civic"));
		System.out.println(isPalindrome("madam"));
		System.out.println(isPalindrome("apple"));
		//checking reverse
		Stack s = new Stack();
		s.push(new Integer(3));
		s.push(new Integer(5));
		s.push(new String("hi"));
		System.out.println(reverse(s));
		//checking is balanced
		System.out.println(isBalanced("[3 + (2 –4) + {(a –b)}]"));
		System.out.println(isBalanced("(){}[][]([])"));
		System.out.println(isBalanced("[3 + 2("));
		System.out.println(isBalanced("{ 7 + [ a –b} ]"));
	}

	public static boolean isPalindrome(String input){
	Stack s = new Stack();
	boolean isPalindrome = true;
	for(int i = 0; i < input.length(); i++)
		s.push(input.charAt(i));
	for(int i =0; i < input.length(); i++){
		if((char)s.pop() != input.charAt(i)){
			isPalindrome = false;
		}
	}
	return isPalindrome;
	}
	
	public static Stack reverse(Stack s){
		Queue q = new Queue();
		Stack reversedStack = new Stack();
		while(!s.isEmpty()) {
			q.enqueue(s.pop());
		}
		while (!q.isEmpty()){
			reversedStack.push(q.dequeue());
		}
		return reversedStack;
	}
	public static boolean isBalanced(String expression){
		Stack parentheses = new Stack();
		for(int i = 0; i < expression.length(); i++){
		if ( Character.compare(expression.charAt(i), '(') == 0 ||
		 Character.compare(expression.charAt(i), '[') == 0 ||
		 Character.compare(expression.charAt(i), '{') == 0 
		 ){
		parentheses.push(expression.charAt(i));
		 }
		 else if ( Character.compare(expression.charAt(i), ')') == 0 ||
		 Character.compare(expression.charAt(i), ']') == 0 ||
		 Character.compare(expression.charAt(i), '}') == 0 
		 ){
			if (parentheses.isEmpty()){
			return false;
			}else {
				if (Character.compare(expression.charAt(i), getOppositeParentheses((char) parentheses.pop())) != 0){
					return false;
				}

			}
		 }
		}
		if (parentheses.isEmpty())
			return true;
		else 
			return false;
	}
	public static char getOppositeParentheses(char x){
		if (x == '(')
			return ')';
		if (x == '[')
			return ']';
		if (x == '{')
			return '}';
		else
			return '0';
	}

}