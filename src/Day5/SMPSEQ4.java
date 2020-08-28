package Day5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SMPSEQ4 {
	public static boolean isExist(int num, int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			if(num == arr[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input5.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://www.spoj.com/problems/SMPSEQ4/
		int m = scanner.nextInt();
		int[] s = new int[m];
		for(int i = 0; i < m; i++) {
			s[i] = scanner.nextInt();
		}
		int n = scanner.nextInt();
		int[] q = new int[n];
		for(int i = 0; i < n; i++) {
			q[i] = scanner.nextInt();
		}
		
		int[] tmp = new int[100];
		int count = 0;
		for(int i = 0; i < m; i++) {
			if(isExist(s[i], q, n)) {
				tmp[count] = s[i];
				count++;
			}
		}
		
		for(int i = 0; i < count; i++) {
			System.out.print(tmp[i] + " ");
		}
		
		fReader.close();
	}
}
