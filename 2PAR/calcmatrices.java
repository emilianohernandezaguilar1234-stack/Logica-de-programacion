import java.util.Scanner;

public class calcmatrices {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matriz1;
        int[][] matriz2;


        System.out.println("Ingresa el número de filas de la primera matriz: ");
        int filas1 = sc.nextInt();

        System.out.println("Ingresa el número de columnas de la primera matriz: ");
        int columnas1 = sc.nextInt();

        System.out.println("Ingresa el número de filas de la segunda matriz: ");
        int filas2 = sc.nextInt();

        System.out.println("Ingresa el número de columnas de la segunda matriz: ");
        int columnas2 = sc.nextInt();

        // Verificar si las dimensiones de las matrices son compatibles para la operación seleccionada 
        System.out.println("Que operación deseas realizar?");
        System.out.println("Operaciones Basicas:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. Matriz escalar");
        System.out.println("5. Escalar a la potencia");
        System.out.println("Ingresa tu seleccion:");
        int opcion = sc.nextInt();

        if (opcion == 1 || opcion == 2) {
            if (filas1 != filas2 || columnas1 != columnas2) {
                System.out.println("Las matrices deben tener las mismas dimensiones para realizar la operación.");
                return;
            }
        } else if (opcion == 3) {
            if (columnas1 != filas2) {
                System.out.println("El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz para multiplicarlas.");
                return;
            }
        } else if (opcion == 4) {
            if (filas1 != filas2 || columnas1 != columnas2) {
                System.out.println("Las matrices deben tener las mismas dimensiones para realizar la operación.");
                return;
            }
        } else if (opcion == 5) {
            if (filas1 != filas2 || columnas1 != columnas2) {
                System.out.println("Las matrices deben tener las mismas dimensiones para realizar la operación.");
                return;
            }
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        matriz1 = new int[filas1][columnas1];
        matriz2 = new int[filas2][columnas2];

        // Solicitar al usuario que ingrese los elementos de las matrices

        System.out.println("Ingresa los elementos de la primera matriz: ");
        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Ingresa los elementos de la segunda matriz: ");
        for (int i = 0; i < filas2; i++) {
            for (int j = 0; j < columnas2; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz2[i][j] = sc.nextInt();
            }
        }

        int[][] resultado = null;

        // Realizar la operación seleccionada 
        if (opcion == 1) {
            resultado = new int[filas1][columnas1];
            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas1; j++) {
                    resultado[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
        }  else if (opcion == 2) {
            resultado = new int[filas1][columnas1];
            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas1; j++) {
                    resultado[i][j] = matriz1[i][j] - matriz2[i][j];
                }
            }
        } else if (opcion == 3) {
            resultado = new int[filas1][columnas2];
            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas2; j++) {
                    resultado[i][j] = 0;
                    for (int k = 0; k < columnas1; k++) {
                        resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                }
            }
        } else if (opcion == 4) {
            System.out.println("Ingresa el escalar:");
            int escalar = sc.nextInt();
            resultado = new int[filas1][columnas1];
            for (int i = 0; i < filas1; i++) {
                for (int j =0; j < columnas1; j++) {
                    resultado[i][j] = matriz1[i][j] * escalar;
                }
            }
        } else if (opcion == 5) {
            System.out.println("Ingresa la potencia:");
            int potencia = sc.nextInt();
            resultado = new int[filas1][columnas1];
            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas1; j++) {
                    resultado[i][j] = (int) Math.pow(matriz1[i][j], potencia);
                }
            }
        }

        System.out.println("El resultado de la operación es: ");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    //Trasponer una matriz
    public static int[][] trasponer(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] traspuesta = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }
        return traspuesta;
    }

    //Verificar si es simétrica
    public static boolean esSimetrica(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        if (filas != columnas) {
            return false;
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

    
