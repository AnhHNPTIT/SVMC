package Day5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QBSTR {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input5.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://vn.spoj.com/problems/QBSTR/
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		int m = str1.length();
		int n = str2.length();
		str1 = " " + str1;
		str2 = " " + str2;
		
		int[][] f = new int[1000][1000];
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					f[i][j] = f[i - 1][j - 1] + 1;
				}
				else {
					f[i][j] = (f[i - 1][j] > f[i][j - 1]) ? f[i - 1][j] : f[i][j - 1];
				}
			}
		}
		
		System.out.println(f[m][n]);
		
		fReader.close();
	}
}
