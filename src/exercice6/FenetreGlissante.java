package exercice6;

import java.util.Scanner;

public class FenetreGlissante {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Fenêtre glissante : valeurs distinctes ===");
        System.out.print("Entrez la taille du tableau n : ");
        int n = sc.nextInt();

        System.out.print("Entrez la taille de la fenêtre k : ");
        int k = sc.nextInt();

        int[] T = new int[n];
        System.out.println("Entrez les " + n + " entiers du tableau :");
        for (int i = 0; i < n; i++) {
            T[i] = sc.nextInt();
        }

        final int MAXV = 100000;
        int[] freq = new int[MAXV + 1];

        int distinct = 0;

     
        for (int i = 0; i < k; i++) {
            int x = T[i];
            if (freq[x] == 0) distinct++;
            freq[x]++;
        }

        System.out.println("\nNombre de valeurs distinctes dans chaque fenêtre :");
        System.out.print(distinct);


        for (int i = k; i < n; i++) {

            int out = T[i - k];  
            freq[out]--;
            if (freq[out] == 0) distinct--;

            int in = T[i];     
            if (freq[in] == 0) distinct++;
            freq[in]++;

            System.out.print(" " + distinct);
        }

        System.out.println();
        sc.close();
    }
}
