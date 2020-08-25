package Day3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Soduku {
	public static int checkRow(int[][] arr, int i, int j) {
		for(int x = j + 1; x < 9; x++) {
			if(arr[i][x] == arr[i][j]) {
				return 0;
			}
		}
		return 1;
	}
	
	public static int checkCol(int[][] arr, int i, int j) {
		for(int x = i + 1; x < 9; x++) {
			if(arr[i][j] == arr[x][j]) {
				return 0;
			}
		}
		return 1;
	}
	
	public static int checkMatrix(int[][] arr, int i, int j) {
		int dx1, dx2, dy1, dy2;
		if(i >= 0 && i <= 2) {
			dx1 = 0;
			dx2 = 2;
		}
		else if(i >= 3 && i <= 5){
			dx1 = 3;
			dx2 = 5;
		}
		else {
			dx1 = 6;
			dx2 = 8;
		}
		if(j >= 0 && j <= 2) {
			dy1 = 0;
			dy2 = 2;
		}
		else if(j >= 3 && j <= 5){
			dy1 = 3;
			dy2 = 5;
		}
		else {
			dy1 = 6;
			dy2 = 8;
		}
		for(int x = dx1; x <= dx2 && x != i; x++) {
			for(int y = dy1; y <= dy2 && y != j; y++) {
				if(arr[x][y] == arr[i][j]) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	public static int checkSudoku(int[][] arr) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] != 0) {
					if(checkRow(arr, i, j) == 0) {
						return 0;
					}
					else if(checkCol(arr, i, j) == 0) {
						return 0;
					}
					else if(checkMatrix(arr, i, j) == 0) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input3.txt");
		Scanner scanner = new Scanner(fReader);
		int tc = scanner.nextInt();
		scanner.nextLine();
		for(int k = 1; k <= tc; k++) {
			int[][] arr = new int[9][9];
			for(int i = 0; i < 9; i++) {
				String str = scanner.nextLine();
				for(int j = 0; j < 9; j++) {
					char tmp = str.charAt(j);
					arr[i][j] = (tmp == '.') ? 0 : Character.getNumericValue(tmp);
				}
			}
			System.out.println("#" + k + " " + checkSudoku(arr));
		}
		fReader.close();
	}
}
