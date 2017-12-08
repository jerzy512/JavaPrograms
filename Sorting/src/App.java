import java.util.Stack;

public class App {
	public static void main(String[] args) {

		// Declaring stacks used for sorting

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		// Selecting a random number of random integers

		int num = (int) (Math.random() * 20) + 15;
		System.out.println("There are: " + num + " random numbers.");

		for (int i = 0; i < num; i++) {
			stack1.push((int) (Math.random() * 1000));
		}

		// Printing the selected integers

		while (!(stack1.empty())) {
			System.out.print(stack1.peek() + " ");
			stack2.push(stack1.pop());
		}
		System.out.println();
		System.out.println();

		while (!(stack2.empty())) {
			stack1.push(stack2.pop());
		}

		/*
		 * Numbers are moved from stack1 to stack2 and back so that the largest 
		 * will be on the bottom of stack1. After each repetition more and more 
		 * numbers on the bottom of stack1 will be sorted.
		 * We repeat it as long as the variable rep is true, which signals that
		 * the ordering was changed during the run. When rep is false to the end
		 * it means that the sorting is done.
		 */

		boolean rep;

		do {
			int max = stack1.pop();
			rep = false;

			while (!(stack1.empty())) {
				if (stack1.peek().compareTo(max) < 0 ) {
					rep = true;
					stack2.push(stack1.pop());
				} else {
					stack2.push(max);
					max = stack1.pop();
				}
			}
			stack1.push(max);
			
			while (!(stack2.empty())) {
				stack1.push(stack2.pop());
			}
		} while (rep);
		
		// Printing the sorted values
		
		System.out.println("They are sorted in increasing order: ");
		while (!(stack1.empty())) {
			System.out.print(stack1.pop() + " ");
		}
	}
}
