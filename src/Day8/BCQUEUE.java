package Day8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BCQUEUE {
    public static int[] q = new int[1000];
    public static int front, rear;
    
    public static void createQueue(){
        front = -1; 
        rear = -1;
    }
    
    public static void enQueue(int x){
        rear++;
        q[rear] = x;
    }
    
    public static void deQueue(){
        if (front < rear){
            front++;
        }
    }
    
    public static int deFrontQueue(){
        if (front == rear){
            return -1;
        }
        return q[front + 1];
    }
    
    public static int deRearQueue(){
        if (front == rear){
            return -1;
        }
        return q[rear];
    }
    
    public static boolean isEmpty(){
        return (front == rear);
    }
    
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input8.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/PTIT/problems/BCQUEUE/
        int step = scanner.nextInt();
        scanner.nextLine();
        for(int count = 1; count <= step; count++){
            int n = scanner.nextInt();
            if (n == 1){
                System.out.println(rear - front);
                System.out.println();
            }
            else if (n == 2){
                if (isEmpty()){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
                System.out.println();
            }
            else if (n == 3){
                int x = scanner.nextInt();
                enQueue(x);
            }
            else if (n == 4){
                deQueue();
            }
            else if (n == 5){
                System.out.println(deFrontQueue());
                System.out.println();
            }
            else if (n == 6){
                System.out.println(deRearQueue());
                System.out.println();
            }
            
            scanner.nextLine();
        }
		
		fReader.close();
	}
}
