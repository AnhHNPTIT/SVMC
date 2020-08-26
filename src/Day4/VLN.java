package Day4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class VLN {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input4.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://www.spoj.com/problems/VLN/
		int d = 3;
		int n = scanner.nextInt();
		long[] arr = new long[n];
		long H = scanner.nextLong();
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextLong();
		}
		
		long max = 0;
		for(int index = 0; index < n; index++) {
			int i = 1;
			long sum = arr[index];
			while(i * d <= H) {
				if(index - i >= 0) {
					sum += arr[index - i];
				}
				if(index + i < n) {
					sum += arr[index + i];
				}
				i++;
			}
			max = (sum > max) ? sum : max;
		}
		System.out.println(max);
		
		
		fReader.close();
	}
}
