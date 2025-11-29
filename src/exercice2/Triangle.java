package exercice2;

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la hauteur du triangle : ");
        int hauteur = scanner.nextInt();

        int etoiles = 1;

        for (int i = 1; i <= hauteur; i++) {

            for (int j = 1; j <= etoiles; j++) {
                System.out.print("*");
            }
            System.out.println();
            etoiles += 2; 
        }

        scanner.close();
    }
}
