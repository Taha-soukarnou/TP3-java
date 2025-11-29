package exercice5;
import java.util.Scanner;

public class Rotation {
    public static void rotate90ClockwiseInPlace(int[][] A) {
        int N = A.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int tmp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][N - 1 - j];
                A[i][N - 1 - j] = tmp;
            }
        }
    }

    public static void rotate90CounterClockwiseInPlace(int[][] A) {
        int N = A.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int tmp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = tmp;
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N / 2; i++) {
                int tmp = A[i][j];
                A[i][j] = A[N - 1 - i][j];
                A[N - 1 - i][j] = tmp;
            }
        }
    }

    public static void rotate180InPlace(int[][] A) {
        int N = A.length;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i > N - 1 - i || (i == N - 1 - i && j >= N - 1 - j)) {
                    continue; 
                }

                int tmp = A[i][j];
                A[i][j] = A[N - 1 - i][N - 1 - j];
                A[N - 1 - i][N - 1 - j] = tmp;
            }
        }
    }

    public static void afficher(int[][] A) {
        for (int[] ligne : A) {
            for (int x : ligne) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N = ");
        int N = sc.nextInt();

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        rotate90ClockwiseInPlace(A);

     
        afficher(A);

        sc.close();
    }
}

