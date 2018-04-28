import java.util.*;

public class candycrush {

	public static void main(String[] args) {
		int[][] grid = new int[20][20];
		Random rn = new Random();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				grid[i][j] = rn.nextInt(5) + 1;
				System.out.print(grid[i][j] + " ");
			}
			System.out.print("\n");
		}
		int time = 0;
		int player1_score = 0;
		int player2_score = 0;
		int determine = 0;
		while (time < 10) {
			if(determine%2==0)
				System.out.println("Player1's turn: "+"\n");
			else
				System.out.println("Player2's turn: "+"\n");
			Scanner scanner = new Scanner(System.in);
	                System.out.println("Enter the index number of row: "+"\n");		
			int a = scanner.nextInt();
	                System.out.println("Enter the index number of column: "+"\n");		
			int b = scanner.nextInt();
			int d = grid[a][b];
			int e = a;
			int f = b;
			int count = 1;
			System.out.println("Press 1 for vertical selcetion and 2 for horizontal selection: "
							+ "\n");
			int st = scanner.nextInt();
			if (st == 1) {
				for (int i = a + 1;; i++) {
					if (grid[i][b] == d) {
						count++;
					} else
						break;

				}
				if (determine % 2 == 0)
					player1_score += count;
				else
					player2_score += count;

				int g = count + a - 1;
				if (count > 1 && a > 0) {
					while (e > 0) {
						grid[g][b] = grid[e - 1][b];
						g--;
						e--;
					}
					while (g >= 0) {
						grid[g][b] = rn.nextInt(5) + 1;
						g--;
					}
				} else {
					while (g >= 0) {
						grid[g][f] = rn.nextInt(5) + 1;
						g--;
					}
				}
			}
			if (st == 2) {
				for (int i = b + 1, j = a;; i++) {
					if (grid[j][i] == d) {
						count++;
					} else
						break;
				}
				if (determine % 2 == 0)
					player1_score += count;
				else
					player2_score += count;
				int g = count + b - 1;
				if (count > 1 && a > 0) {
					while (e != 0) {
						for (int i = f; i <= g; i++) {
							grid[e][i] = grid[e - 1][i];
						}
						e--;
					}
					for (int i = f; i <= g; i++) {
						grid[e][i] = rn.nextInt(5) + 1;
					}
				} else if (a == 0) {
					for (int i = b; i <= g; i++) {
						grid[a][i] = rn.nextInt(5) + 1;
					}
				}

			}
			System.out.println("Player1 score is = " + player1_score);
			System.out.println("Player2 score is = " + player2_score);

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.print("\n");
			}

			time++;
			determine++;
		}
		if (player1_score > player2_score)
			System.out.println("Player1 wins");
		else if (player2_score > player1_score)
			System.out.println("Player2 wins");
		else
			System.out.println("draw");

	}

}
