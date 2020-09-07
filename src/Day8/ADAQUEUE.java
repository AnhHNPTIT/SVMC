package Day8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ADAQUEUE {
	public static int[] q = new int[1000];
    public static int front, rear;
    
    public static void createQueue(){
        front = -1;
        rear = -1;
    }
    
    public static int front(){
        front++;
        return q[front];
    }
    
    public static int back(){
        rear--;
        return q[rear + 1];
    }
    
    public static void reverse(){
        if (!isEmpty()){
            for (int i = 0; i < (int) (rear - front - 1) / 2; i++){
                int tmp = q[front + i];
                q[front + i] = q[rear - i];
                q[rear - i] = tmp;
            }
        }
    }
    
    public static void toFront(int x){
        if (front == -1 && rear == -1){
            rear++;
            q[rear] = x;
        }
        else {
            front--;
            q[front + 1] = x;
        }
    }
    
    public static void push_back(int x){
        rear++;
        q[rear] = x;
    }
    
    public static boolean isEmpty(){
        return (front == rear);
    }
    
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input8.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/problems/ADAQUEUE/
		int step = scanner.nextInt();
        scanner.nextLine();
        createQueue();
        String tmp;
        int x;
        for(int count = 1; count <= step; count++){
            String str = scanner.nextLine();
            if (str.contains("toFront")){
                tmp = str.substring(8, str.length());
                x = Integer.parseInt(tmp);
                toFront(x);
            }
            else if (str.contains("front")){
                if (isEmpty()){
                    System.out.println("No job for Ada?");
                }
                else {
                    System.out.println(front());
                }
            }
            else if(str.contains("push_back")){
                tmp = str.substring(10, str.length());
                x = Integer.parseInt(tmp);
                push_back(x);
            }
            else if (str.contains("back")){
                if (isEmpty()){
                    System.out.println("No job for Ada?");
                }
                else {
                    System.out.println(back());
                }
            }
            else if (str.contains("reverse")){
                reverse();
            }

        }
		
		fReader.close();
	}
}
