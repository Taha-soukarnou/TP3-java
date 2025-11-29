package exercice4;

public class Tableaux {
    public static class TableauxUtil {


        public static void affiche(double t[][]) {
            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t[i].length; j++) {
                    System.out.print(t[i][j] + " ");
                }
                System.out.println();
            }
        }
        public static boolean regulier(double t[][]) {
            if (t.length == 0) return true;

            int taille = t[0].length;

            for (int i = 1; i < t.length; i++) {
                if (t[i].length != taille) {
                    return false;
                }
            }
            return true;
        }


        public static double[] sommeLignes(double t[][]) {
            double[] resultat = new double[t.length];

            for (int i = 0; i < t.length; i++) {
                double somme = 0;
                for (int j = 0; j < t[i].length; j++) {
                    somme += t[i][j];
                }
                resultat[i] = somme;
            }

            return resultat;
        }

 
        public static double[][] somme(double[][] t1, double[][] t2) {


            if (!regulier(t1) || !regulier(t2)) {
                System.out.println("Erreur : un des tableaux n'est pas régulier.");
                return null;
            }

            if (t1.length != t2.length || t1[0].length != t2[0].length) {
                System.out.println("Erreur : dimensions incompatibles.");
                return null;
            }

            double[][] res = new double[t1.length][t1[0].length];

            for (int i = 0; i < t1.length; i++) {
                for (int j = 0; j < t1[i].length; j++) {
                    res[i][j] = t1[i][j] + t2[i][j];
                }
            }

            return res;
        }
    }
    public static void main(String[] args) {

        double[][] t1 = {
            {1.5, 2.5, 3.0},
            {4.0, 5.0, 6.0},
            {7.5, 8.0, 9.5}
        };

        double[][] t2 = {
            {1.0, 1.0, 1.0},
            {2.0, 2.0, 2.0},
            {3.0, 3.0, 3.0}
        };

        System.out.println("=== Tableau t1 ===");
        TableauxUtil.affiche(t1);

        System.out.println("\n=== Tableau t2 ===");
        TableauxUtil.affiche(t2);

        System.out.println("\nT1 régulier ? " + TableauxUtil.regulier(t1));
        System.out.println("T2 régulier ? " + TableauxUtil.regulier(t2));

        System.out.println("\n=== Somme des lignes de t1 ===");
        double[] sl = TableauxUtil.sommeLignes(t1);
        for (int i = 0; i < sl.length; i++) {
            System.out.println("Ligne " + i + " => " + sl[i]);
        }

        System.out.println("\n=== Somme t1 + t2 ===");
        double[][] somme = TableauxUtil.somme(t1, t2);

        if (somme != null) {
            TableauxUtil.affiche(somme);
        }
    }
}
