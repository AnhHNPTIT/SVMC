package Day4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LOGIC_DOI_XUNG {
	public static boolean checkSymmetryX(int[][] arr, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < (int) n/2; j++) {
				if(arr[i][j] != arr[i][n - 1 - j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkSymmetryY(int[][] arr, int n) {
		for(int i = 0; i < (int) n/2; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] != arr[n - 1 - i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkMatrix(int[][] arr, int n) {
		if(!checkSymmetryX(arr, n)) {
			return false;
		}
		if(!checkSymmetryY(arr, n)) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input4.txt");
		Scanner scanner = new Scanner(fReader);
		
		int tc = scanner.nextInt();
		for(int k = 1; k <= tc; k++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				String str = scanner.nextLine();
				for(int j = 0; j < n; j++) {
					char tmp = str.charAt(j);
					arr[i][j] = Character.getNumericValue(tmp);
				}
			}
			
			if(checkMatrix(arr, n)) {
				System.out.println("#" + k + " YES");
			}
			else {
				System.out.println("#" + k + " NO");
			}
		}
		
		fReader.close();
	}
}
