package Day5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class XAY_THAP {
	public static void sortASC(int[] arr, int n) {
		for(int i = 1; i < n; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input5.txt");
		Scanner scanner = new Scanner(fReader);
		
		int tc = scanner.nextInt();
		for(int k = 1; k <= tc; k++) {
			int n = scanner.nextInt();
			int m1 = scanner.nextInt();
			int m2 = scanner.nextInt();
			int[] arr_klg = new int[n];
			for(int i = 0; i < n; i++) {
				arr_klg[i] = scanner.nextInt();
			}
			
			sortASC(arr_klg, n);
			int sum_cost = 0;
			int i = m1, j = m2, tmp = 0;
			while(tmp < n) {
				if(m1 >= m2) {
					if(i > 0) {
						sum_cost += arr_klg[tmp] * i;
						i--; tmp++;
					}
					if(j > 0 && i == j) {
						sum_cost += arr_klg[tmp] * j;
						j--; tmp++;
					}
				}
				else {
					if(j > 0) {
						sum_cost += arr_klg[tmp] * j;
						j--; tmp++;
					}
					if(i > 0 && i == j) {
						sum_cost += arr_klg[tmp] * i;
						i--; tmp++;
					}
				}				
			}
			System.out.println("#" + k + " " + sum_cost);
		}
		
		fReader.close();
	}
}
