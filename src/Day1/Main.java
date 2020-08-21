package Day1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input1.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://www.spoj.com/problems/EXPECT/
//		int a = 1;
//		while (a != 42) {
//			a = scanner.nextInt();
//			System.out.println(a);
//		}
		
		
		//https://www.spoj.com/problems/SMPSEQ3/
//		int m = scanner.nextInt();
//		int[] s = new int[m];
//		for(int i = 0; i < m; i++) {
//			s[i] = scanner.nextInt();
//		}
//		int n = scanner.nextInt();
//		int[] q = new int[n];
//		for(int i = 0; i < n; i++) {
//			q[i] = scanner.nextInt();
//		}
//		
//		for(int i = 0; i < m; i++) {
//			boolean isAvail = false;
//			for(int j = 0; j < n; j++) {
//				if(s[i] == q[j]) {
//					isAvail = true;
//				}
//			}
//			if(isAvail == false) {
//				System.out.print(s[i] + " ");
//			}
//		}
		
		// Cách 2: tối ưu hóa	
		int m = scanner.nextInt();
		Stack<Integer> stackS = new Stack<Integer>();
		for(int i = 0; i < m; i++) {
			stackS.push(scanner.nextInt());
		}
		int n = scanner.nextInt();
		Stack<Integer> stackQ = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			stackQ.push(scanner.nextInt());
		}
			
		Stack<Integer> stackR = new Stack<Integer>();
		
		int a = stackS.pop();
		int b = stackQ.pop();
		int countS = m - 1, countQ = n - 1;
		while(countS >= 0) {
			if(countQ == 0) {
				if(a != b) {
					stackR.push(a);
				}
				if(countS != 0) {
					a = stackS.pop();
				}
				countS--;
			}
			else if(countS == 0) {
				if(a == b) {
					countS--;
				}
				else if(a > b) {
					stackR.push(a);
					countS--;
				}
				else {
					b = stackQ.pop();
					countQ--;
				}
				
			}
			else {
				if(a > b) {
					stackR.push(a);
					a = stackS.pop();
					countS--;
				}
				else if(a < b){
					b = stackQ.pop();
					countQ--;
				}
				else {
					a = stackS.pop();
					countS--; 
				}
			}	
		}
		if(stackR.size() > 0) {
			for(int i = 0; i < stackR.size(); i++) {
				System.out.print(stackR.pop() + " ");
			}
			System.out.println(stackR.pop());
		}
		
		
//		int a = stackS.pop();
//		int b = stackQ.pop();
//		while(stackR.size() >= 0) {
//			if(stackQ.size() == 0) {
//				if(a != b) {
//					stackR.push(a);
//				}
//				if(stackR.size() != 0) {
//					a = stackS.pop();
//				}
//			}
//			else {
//				if(a > b) {
//					if(stackS.size() == 1) {
//						stackR.push(a);
//					}
//					else {
//						stackR.push(a);
//						a = stackS.pop();
//					}
//
//				}
//				else if(a < b){
//					b = stackQ.pop();
//					
//				}
//				else {
//					a = stackS.pop();
//				
//				}
//			}
//			
//		}

//		for(int i = 0; i < stackR.size(); i++) {
//			System.out.print(stackR.pop() + " ");
//		}
//		System.out.println(stackR.pop());
		
		
		
		//https://www.spoj.com/problems/FACEFRND/
//		int m = scanner.nextInt();
//		int[][] arr = new int[m][2];
//		int i, j;
//		int[][] arr_fri = new int[m][100];
//		int[] list = new int[100];
//		int tmp = 0;
//		for(i = 0; i < m; i++) {
//			arr[i][0] = scanner.nextInt();
//			arr[i][1] = scanner.nextInt();
//			for(j = 0; j < arr[i][1]; j++) {
//				arr_fri[i][j] = scanner.nextInt();
//			}
//		}
//		for(i = 0; i < m; i++) {
//			for(j = 0; j < arr[i][1]; j++) {
//				boolean isAvail = false;
//				for(int t = 0; t < m; t++) {
//					if(arr_fri[i][j] == arr[t][0]) {
//						isAvail = true;
//					}					
//				}
//				if(tmp > 0) {
//					for(int k = 0; k < tmp; k++) {
//						if(arr_fri[i][j] == list[k]) {
//							isAvail = true;
//						}
//					}
//				}
//
//				if(!isAvail) {
//					list[tmp++] = arr_fri[i][j];
//				}
//			}
//		}
//		System.out.println(tmp);
		
		

		
		//https://vn.spoj.com/problems/LIQ/
		// Cách 1
//		int m = scanner.nextInt();
//		int[] arr = new int[1000];
//		for(int i = 0; i < m; i++) {
//			arr[i] = scanner.nextInt();
//		}
//		
//		int max = 1;
//		for(int i = 0; i < m - 1; i++) {
//			int tmp = arr[i];
//			int count = 1;
//			for(int j = i + 1; j < m; j++) {
//				if(arr[j] >= tmp) {
//					count++;
//					tmp = arr[j];
//				}
//			}
//			max = (count > max) ? count : max;
//		}
//		System.out.println(max);
		
		// Cách 2: dùng phương pháp quy hoạch động
//		int m = scanner.nextInt();
//		int[] arr = new int[m];
//		int[] l = new int[1001];
//		int len_max = 0;
//		for(int i = 0; i < m; i++) {
//			arr[i] = scanner.nextInt();
//			l[i] = 1 ;
//			for(int j = 0; j < i; j++)
//				if (l[j] + 1 > l[i] && arr[i] > arr[j]) {
//					l[i] = l[j] + 1 ;
//				}
//			if (l[i] > len_max) {
//				len_max = l[i] ;
//			}
//		}
//		System.out.print(len_max);
	
		
		
		
		//�?ếm số chuỗi con đối xứng
//		int m = scanner.nextInt();
//		scanner.nextLine();
//		for(int i = 0; i < m; i++) {
//			String tmp = scanner.nextLine();
//			int count = 0;
//			for(int j = 0; j < tmp.length(); j++) {
//				for(int k = j; k < tmp.length(); k++) {
//					String str = tmp.substring(j, k+1);
//					boolean isSymmetry = true;
//					int len = str.length();
//					for (int t = 0; t <= (int)len/2 - 1; t++) {
//						if(str.charAt(t) != str.charAt(len-1-t)) {
//							isSymmetry = false;
//						}
//					}
//					if(isSymmetry) {
//						count++;
//					}
//				}
//			}
//			System.out.println("#" + (i + 1) + " " + count);
//		}
				
		
		//First duplicate
//		// đ�?c số phần tử m và mảng arrA
//		int m = scanner.nextInt();
//		int[] arrA = new int[m];
//		for(int i = 0; i < m; i++) {
//			arrA[i] = scanner.nextInt();
//		}
//		// khởi tạo mảng 2 chi�?u tmpA có chứa số nguyên và chỉ số của số lặp
//		int[][] tmpA = new int[m][2];
//		for(int i = 0; i < m; i++) {
//			tmpA[i][0] = arrA[i];
//			tmpA[i][1] = -1;
//			for(int j = i + 1; j < m; j++) {
//				if(arrA[i] == arrA[j]) {
//					tmpA[i][1] = j;
//				}
//			}
//		}
//		// kiểm tra xem có số nào lặp không?
//		boolean isLoop = false;
//		for(int i = 0; i < m; i++) {
//			if(tmpA[i][1] != -1) {
//				isLoop = true;
//			}
//		}
//		// nếu không thì in ra -1
//		if(!isLoop) {
//			System.out.println(-1);
//		}
//		// nếu có thì tìm chỉ số nh�? nhất và in ra số có chỉ số đó
//		else {
//			int indexA = m - 1;
//			for(int i = 0; i < m; i++) {
//				if(tmpA[i][1] != -1 && tmpA[i][1] < indexA) {
//					indexA = tmpA[i][1];
//				}
//			}
//			System.out.println(arrA[indexA]);
//		}
		
		
		fReader.close();
	}
}
