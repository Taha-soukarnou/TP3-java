public class Main {

    // ===== Exercice 1 =====
    public static double exercice1(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) sum += 1.0 / i;
        return sum;
    }

    // ===== Exercice 2 =====
    public static void exercice2(int h) {
        for (int i = 1; i <= h; i++) {
            for (int j = 0; j < 2*i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // ===== Exercice 3 =====
    public static int[] exercice3(int n) {
        int[] res = new int[n];
        int val = 1;
        for (int i = 0; i < n; i++) {
            res[i] = val * val;
            val += 2;
        }
        return res;
    }

    // ===== Exercice 4 =====
    public static void affiche(double[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean regulier(double[][] t) {
        if (t.length == 0) return true;
        int size = t[0].length;
        for (int i = 1; i < t.length; i++) if (t[i].length != size) return false;
        return true;
    }

    public static double[] sommeLignes(double[][] t) {
        double[] s = new double[t.length];
        for (int i = 0; i < t.length; i++) {
            double sum = 0;
            for (int j = 0; j < t[i].length; j++) sum += t[i][j];
            s[i] = sum;
        }
        return s;
    }

    public static double[][] somme(double[][] t1, double[][] t2) {
        if (!regulier(t1) || !regulier(t2)) return null;
        if (t1.length != t2.length || t1[0].length != t2[0].length) return null;

        double[][] r = new double[t1.length][t1[0].length];
        for (int i = 0; i < t1.length; i++)
            for (int j = 0; j < t1[0].length; j++)
                r[i][j] = t1[i][j] + t2[i][j];
        return r;
    }

    // ===== Exercice 5 =====
    public static void exercice5(int[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                int tmp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = tmp;
            }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N/2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][N-1-j];
                A[i][N-1-j] = tmp;
            }
    }

    // ===== Exercice 6 =====
    public static int[] exercice6(int[] T, int k) {
        int n = T.length;
        int MAXV = 100000;
        int[] freq = new int[MAXV + 1];
        int[] result = new int[n - k + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            if (freq[T[i]] == 0) distinct++;
            freq[T[i]]++;
        }
        result[0] = distinct;

        for (int i = k; i < n; i++) {
            int out = T[i - k];
            freq[out]--;
            if (freq[out] == 0) distinct--;

            int in = T[i];
            if (freq[in] == 0) distinct++;
            freq[in]++;

            result[i - k + 1] = distinct;
        }

        return result;
    }


    // ===== MAIN =====
    public static void main(String[] args) {

        System.out.println("Exercice 1 → " + exercice1(5));

        exercice2(4);

        int[] impairs = exercice3(5);
        for (int x : impairs) System.out.println(x);

        double[][] a = { {1,2}, {3,4} };
        double[][] b = { {5,6}, {7,8} };
        affiche(somme(a,b));

        int[][] M = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        exercice5(M);
        for (int[] row : M) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }

        int[] T = {1,2,2,3,2,1,4,2};
        int[] d = exercice6(T, 4);
        for (int x : d) System.out.print(x + " ");
        System.out.println();
    }
}
