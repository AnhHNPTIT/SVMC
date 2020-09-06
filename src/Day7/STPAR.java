package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class STPAR {
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
	
	public static boolean checkSortASC(int[] arr, int n) {
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {				
		FileReader fReader = new FileReader("src\\input7.txt");			
		Scanner scanner = new Scanner(fReader);			
					
		// https://www.spoj.com/SVMCCLAS/problems/STPAR/
		int n = scanner.nextInt();
		while(n != 0) {
			initStack();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
			
			int[] tmp = new int[n];
			int count = 0;
			for(int i = 0; i < n - 1; i++) {
				if(arr[i] > arr[i + 1]) {
					push(arr[i]);
					
				}
				else {
					tmp[count++] = arr[i];
				}

			}
		
				tmp[count++] = arr[n - 1];
		
			while(top > -1) {
				tmp[count++] = pop();
			}

			if(checkSortASC(tmp, n)) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}

			n = scanner.nextInt();
		}
		
		fReader.close();	
	}				
}
