package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ONP {
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
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input7.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://www.spoj.com/SVMCCLAS/problems/ONP/
		int tc = scanner.nextInt();
		scanner.nextLine();
		for(int count = 1; count <= tc; count++) {
			initStack();
			String str;
			str = scanner.nextLine();
			for(int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				if(tmp >= 'a' && tmp <= 'z') {
					System.out.print(tmp);
				}
				else {
					if(tmp == ')') {
						char c = pop();
						while (c != '(') {
							System.out.print(c);
							c = pop();
						}
					}
					else {
						push(tmp);
					}
				}
			}
			System.out.println();
		}
		
		fReader.close();
	}
}
