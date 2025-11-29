package exercice3;

import java.util.Scanner;

public class CarresImpairs {
	 public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Combien de valeurs : ");
	        int n = scanner.nextInt();
	        int[] impairs = new int[n];

	        int valeur = 1; 

	        for (int i = 0; i < n; i++) {
	            impairs[i] = valeur;
	            valeur += 2; 
	        }
	        for (int i = 0; i < n; i++) {
	            int x = impairs[i];
	            System.out.println(x + " a pour carre " + (x * x));
	        }

	        scanner.close();

}}
