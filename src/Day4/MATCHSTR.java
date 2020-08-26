package Day4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MATCHSTR {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input4.txt");
		Scanner scanner = new Scanner(fReader);

		//https://www.spoj.com/problems/MATCHSTR/
		String s = scanner.nextLine();
		String t = scanner.nextLine();
		int count = 0;
		for(int i = 0; i < s.length() - t.length(); i++) {
			String tmp = s.substring(i, i + t.length());
			if(tmp.equals(t)) {
				count++;
			}
		}
		System.out.println(count);
		
		fReader.close();
	}
}
