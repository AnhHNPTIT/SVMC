package Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QMAX {
	public static int max(int[] arr, int u, int v) {
		int max = 0;
		for(int i = u - 1; i < v; i++) {
			max = (arr[i] > max) ? arr[i] : max;
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input6.txt");
		Scanner scanner = new Scanner(fReader);
		
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = 0;
		}
		int m = scanner.nextInt();
		int u, v;
		for(int i = 1; i <= m; i++) {
			u = scanner.nextInt();
			v = scanner.nextInt();
			int k = scanner.nextInt();
			for(int j = u - 1; j < v; j++) {
				arr[j] += k;
			}
		}
		int p = scanner.nextInt();
		for(int i = 1; i <= p; i++) {
			u = scanner.nextInt();
			v = scanner.nextInt();
			System.out.println(max(arr, u, v));
		}
		fReader.close();
	}
}
