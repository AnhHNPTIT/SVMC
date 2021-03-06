package Day8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QUEUEEZ {
	public static int[] q = new int[100000];
	public static int front, rear;
	
	public static void createQueue() {
		front = -1;
		rear = -1;
	}
	
	public static void enQueue(int x) {
        rear++;
        q[rear] = x;
	}
	
	public static void deQueue() {
        if (front < rear){
            front++;
        }
	}
	
	public static int prQueue() {
		return q[front + 1];
	}
	public static boolean isEmpty() {
		return (front == rear);
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input8.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/problems/QUEUEEZ/
        int step = scanner.nextInt();
        createQueue();
        for(int count = 1; count <= step; count++) {
        	int n = scanner.nextInt();
        	if (n == 1) {
        		int x = scanner.nextInt();
        		enQueue(x);
        	}
        	else if (n == 2) {
        		deQueue();
        	}
        	else if (n == 3){
        		if (!isEmpty()) {
        			System.out.println(prQueue());
        		}
				else {
					System.out.println("Empty!");
				}
			}
        }
		
		fReader.close();
	}
}
