package Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DIEU_KHIEN_MAY_BAY {
	public static int findY(int y, int num) {
		if(num == 2) {
			y--;
		}
		else if(num == 3) {
			y++;
		}
		return y;
	}
	
	public static int returnY(int y, int num) {
		if(num == 2) {
			y++;
		}
		else if(num == 3) {
			y--;
		}
		return y;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input6.txt");
		Scanner scanner = new Scanner(fReader);
		
		int tc = scanner.nextInt();
		for(int k = 1; k <= tc; k++) {
			int m = scanner.nextInt();
			int n = 7;
			int step = scanner.nextInt();
			int[] arr_step = new int[step];
			for(int i = 0; i < step; i++) { // các lệnh di chuyển
				arr_step[i] = scanner.nextInt();
			}
			
			int[][] arr = new int[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			
			int x = m - 1, y = 3; // vị trí của máy bay
			int sum = 0; // tổng số vàng
			int count = 0;
			while (count < step) {
				x--;
				y = findY(y, arr_step[count]);
				System.out.println(x + " " + y);
				if(arr[x][y] == 1) {
					sum++;
				}
				else if(arr[x][y] == 2) { // gặp vật cản thì máy bay quay lại vị trí cũ
					x++;
					y = returnY(y, arr_step[count]);
				}
				count++;
			}
			System.out.println("#" + k + " " + sum);
		}
		fReader.close();
	}
}
