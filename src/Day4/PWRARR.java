package Day4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PWRARR {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input4.txt");
		Scanner scanner = new Scanner(fReader);

		//https://vn.spoj.com/problems/PWRARR/		
		int tc = scanner.nextInt();
		for(int k = 1; k <= tc; k++) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
				sum += arr[i];
			}
			System.out.println(sum);
		}
		
		fReader.close();
	}
}
