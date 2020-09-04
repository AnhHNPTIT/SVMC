package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MINSTACK {
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
	
	public static int minOfStack() {
		int min = (int) 10e9;
		for(int i = 1; i <= top; i++) {
			min = (st[i] < min) ? st[i] : min;
		}
		return min;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input7.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/SVMCCLAS/problems/MINSTACK/
		int step = scanner.nextInt();
		scanner.nextLine();
		for(int i = 1; i <= step; i++) {
			String str = scanner.nextLine();
			if(str.contains("PUSH")) {
				String s = str.substring(6, str.length());
				int tmp = Integer.parseInt(s);
				push(tmp);
			}
			
			if(str.contains("POP")) {
				pop();
			}
			
			if(str.contains("MIN")) {
				System.out.println(minOfStack());
				System.out.println();
			}
		}
		
		fReader.close();
	}
}
