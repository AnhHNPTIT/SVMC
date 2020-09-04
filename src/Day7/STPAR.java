package Day7;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class STPAR {
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input7.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/SVMCCLAS/problems/STPAR/
		
		fReader.close();
	}
}
