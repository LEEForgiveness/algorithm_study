import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Miro {
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	public static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	public static int bfs(int[][] graph, boolean[][] visited, int startx, int starty){
		int N = graph.length;
		int M = graph[0].length;

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(startx, starty));
		visited[startx][starty] = true;
		while(!queue.isEmpty()) {
			System.out.println("queue:" + queue.toString());
			Pair pair = queue.poll();
			int x = pair.x;
			System.out.println("x:" + x);
			int y = pair.y;
			System.out.println("y:" + y);
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				System.out.println("nx:" + nx);
				System.out.println("ny:" + ny);

				if (0 <= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] == 1
					&& !visited[nx][ny]) {
//					System.out.println("nx:" + nx);
//					System.out.println("ny:" + ny);
					queue.add(new Pair(nx, ny));
					graph[nx][ny] = graph[x][y] + 1;
					System.out.println("graph[nx][ny]:" + graph[nx][ny]);
				}
			}
		}
		return graph[N-1][M-1];
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int [][] map = new int[N][M];
		boolean [][] visited = new boolean[N][M];
		for (boolean[] row : visited) {
			Arrays.fill(row, false);
		}
		scanner.nextLine();
		for (int i = 0; i < N; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0'; // Convert char to int
			}
		}
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		int result = bfs(map, visited, 0, 0);
		System.out.println(result);
	}
}



