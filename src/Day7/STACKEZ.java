package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class STACKEZ {
	public static int st[] = new int[100];
	public static int top;
	
	public static void initStack() {
		top = -1;
	}
	
	public static boolean isEmpty() {
		return (top < 0);
	}
	
	public static void push(int x) {
		// ++top ~ top = top + 1 --> st[top] = x
		st[++top] = x;
	}
	
	public static int pop() {
		if (top > -1) {
			top--;
			return st[top + 1];
		}
		else {
			return -1;
		}
	}
	
	public static int peek() {
		if (top > -1) {
			return st[top];
		}
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input7.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/SVMCCLAS/problems/STACKEZ/
		int step = scanner.nextInt();
		for(int count = 1; count <= step; count++) {
			int tmp = scanner.nextInt();
			if(tmp == 1) {
				int n = scanner.nextInt();
				push(n);
			}
			if(tmp == 2) {
				pop();
			}
			if(tmp == 3) {
				int top_pop = pop();
				if(top_pop != -1) {
					System.out.println(top_pop);
				}
				else {
					System.out.println("Empty!");
				}
			}
		}
		
		fReader.close();
	}
}
