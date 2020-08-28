package Day5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SMPSEQ5 {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input5.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://www.spoj.com/problems/SMPSEQ5/
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
		
		if(m <= n) {
			for(int i = 0; i < m; i++) {
				if(s[i] == q[i]) {
					System.out.print((i + 1) + " ");
				}
			}
		}
		else {
			for(int i = 0; i < n; i++) {
				if(s[i] == q[i]) {
					System.out.print((i + 1) + " ");
				}
			}
		}
		
		
		fReader.close();
	}
}
