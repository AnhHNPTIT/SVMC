package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CALCULATOR3 {
	public static char st[] = new char[100];
	public static int top;
	
	public static void initStack() {
		top = -1;
	}
	
	public static boolean isEmpty() {
		return (top < 0);
	}
	
	public static void push(char x) {
		// ++top ~ top = top + 1 --> st[top] = x
		st[++top] = x;
	}
	
	public static char pop() {
		if (top > -1) {
			top--;
			return st[top + 1];
		}
		else {
			return ' ';
		}
	}
	
	public static char peek() {
		if (top > -1) {
			return st[top];
		}
		else {
			return ' ';
		}
	}
	
	public static boolean isOperand(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
	
	public static int priority(char c) {
		if (c == '*') {
			return 2;
		}
		else if (c == '+') {
			return 1;
		}
		else if (c == '(') {
			return 0;
		}
		return -1;
	}
	
	public static int calculator(int a, int b, char c) {
		if (c == '*') {
			return (a * b);
		}
		else {
			return (a + b);
		}
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input7.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/SVMCCLAS/problems/CALCULATOR3/
		int tc = 2;
		
		for(int count = 1; count <= tc; count++) {
			// convert from Infix to Postfix
			
			initStack();
			int n = scanner.nextInt();
			scanner.nextLine();
			scanner.nextLine();
			String str = scanner.nextLine();
			String str_pos = "";
	
			for(int i = 0; i < n; i++) {
				char tmp = str.charAt(i);
				if(isOperand(tmp)) {
					str_pos += tmp;
				}
				else {
					if (tmp == '(') {
						push(tmp);
					}
					else if (tmp == ')') {
						while (peek() != '(' && !isEmpty()) {
							str_pos += pop();
						}
						if (peek() == '(') {
							pop();
						}
					}
					else {
		
						while (priority(tmp) <= priority(peek()) && !isEmpty()) {
							str_pos += pop();
							
						}
						push(tmp);
						
					}
				}
			}

			while (!isEmpty()) {
				str_pos += pop();
			}
			
			// calculator value of str_pos
			int[] arr = new int[n];
			int index = -1;
			for(int i = 0; i < str_pos.length(); i++) {
				char current = str_pos.charAt(i);
				if (isOperand(current)) {
					int tmp = Character.getNumericValue(current);
					arr[++index] = tmp;
				}
				else {
					arr[index - 1] = calculator(arr[index], arr[index - 1], current);
					index--;
				}
			}
			System.out.println("#" + count + " " + arr[0]);
			System.out.println();
		}
		
		fReader.close();
	}
}
