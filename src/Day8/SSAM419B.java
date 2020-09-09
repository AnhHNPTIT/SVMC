package Day8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SSAM419B {
	public static int[] q = new int[110]; // hàng đợi
	public static int[][] g = new int[110][110]; // ma trận kề
	public static int n, m, u;
	public static boolean[] not_visit = new boolean[110]; // mảng đánh dấu đỉnh đã được xét
	
	public static void init(Scanner scanner) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		u = scanner.nextInt();
		
		for (int count = 1; count <= m; count++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			g[i][j] = g[j][i] = 1;
		}
		
		for(int count = 1; count <= n; count++) {
			not_visit[count] = true;
		}
	}
	
	public static void BFS(int v) {
		int u, front, rear, j;
		front = 1;
		rear = 1;
		q[rear] = v; // nạp v vào hàng đợi
		not_visit[v] = false; // đổi trạng thái của v
		// thiết lập hàng đợi với đỉnh đầu là  
		while (front <= rear) { // duyệt tới khi hàng đợi rỗng
			u = q[front]; // lấy u ra từ hàng đợi
			System.out.print(u + " ");
			front++; // duyệt đỉnh ở đầu hàng đợi
			for (j = 1; j <= n; j++) {
				if (g[u][j] == 1 && not_visit[j]) { // đưa các đỉnh v kề với p nhưng chưa được xét vào hàng đợi
					rear++;
					q[rear] = j;
					not_visit[j] = false;
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input8.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/PTIT/problems/SSAM419B/
		int tc = scanner.nextInt();
		for (int count = 1; count <= tc; count++) {
			init(scanner);
			BFS(u);
		}
		
		fReader.close();
	}
}
