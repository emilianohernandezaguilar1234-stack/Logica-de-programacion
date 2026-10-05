import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class CaMa {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

       do {
        System.out.println("\n========================================");
        System.out.println("         Calculadora de Matrices        ");
        System.out.println("========================================");
        System.out.println("Calculadora de Matrices");
        System.out.println("======Operaciones Basicas======");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. Matriz escalar");
        System.out.println("5. Escalar a la potencia N");
        System.out.println("6. Matriz al cuadrado");
        System.out.println("======Transformaciones======");
        System.out.println("7. Trasponer");
        System.out.println("8. Generar/Verificar Identidad, Diagonal, Triangular superior/inferior:");
        System.out.println("======Propiedades y Analisis======");
        System.out.println("9. Verificar Simetrica/Asimetrica");
        System.out.println("10. Determinante");
        System.out.println("11. Matriz menor");
        System.out.println("12. Cofactores");
        System.out.println("13. Adjunta");
        System.out.println("======Extras======");
        System.out.println("14. Cargar imagen como matriz");
        System.out.println("0. Salir");
        System.out.println("Ingresa tu seleccion:");

        opcion = sc.nextInt();

        if (opcion == 0){
            System.out.println("Nos vemos pronto!");
            break;
        }

        switch (opcion) {

            case 1:
            case 2:{
                System.out.print("Filas de la matriz 1: "); int f1 = sc.nextInt();
                    System.out.print("Columnas de la matriz 1: "); int c1 = sc.nextInt();
                    int[][] m1 = leerMatriz(f1, c1, sc);

                    System.out.print("Filas de la matriz 2: "); int f2 = sc.nextInt();
                    System.out.print("Columnas de la matriz 2: "); int c2 = sc.nextInt();
                    int[][] m2 = leerMatriz(f2, c2, sc);

                    if (f1 != f2 || c1 != c2) {
                        System.out.println("Error: Las matrices deben tener las mismas dimensiones para sumar o restar.");
                        break;
                    }

                    int[][] res = (opcion == 1) ? sumarMatrices(m1, m2) : restarMatrices(m1, m2);
                    imprimirMatriz(res);
                    break;
            }
            
            case 3:{
                System.out.print("Filas de la matriz 1: "); int f1 = sc.nextInt();
                    System.out.print("Columnas de la matriz 1: "); int c1 = sc.nextInt();
                    int[][] m1 = leerMatriz(f1, c1, sc);

                    System.out.print("Filas de la matriz 2: "); int f2 = sc.nextInt();
                    System.out.print("Columnas de la matriz 2: "); int c2 = sc.nextInt();
                    int[][] m2 = leerMatriz(f2, c2, sc);

                    if (c1 != f2) {
                        System.out.println("Error: El número de columnas de la matriz 1 debe ser igual a las filas de la matriz 2.");
                        break;
                    }

                    int[][] res = multiplicarMatrices(m1, m2);
                    imprimirMatriz(res);
                    break;
                }

            case 4:{
                System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);
                    System.out.print("Ingresa el valor del escalar: ");
                    int escalar = sc.nextInt();

                    int[][] res = escalarMatriz(m, escalar);
                    imprimirMatriz(res);
                    break;
            }

            case 5: { // Escalar a la potencia N
                    System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);
                    System.out.print("Ingresa la potencia N: ");
                    int pot = sc.nextInt();

                    try {
                        int[][] res = potenciaMatriz(m, pot);
                        imprimirMatriz(res);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

            case 6:{
                System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    if (f != c) {
                        System.out.println("Error: La matriz debe ser cuadrada para elevarla al cuadrado.");
                        break;
                    }

                    int[][] res = matrizAlCuadrado(m);
                    imprimirMatriz(res);
                    break;
            }    

            case 7:{
                System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    int[][] res = trasponerMatriz(m);
                    imprimirMatriz(res);
                    break;
                }

            case 8:{
                System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    verificarPropiedades(m);
                    break;
            }  
            
            case 9:{
                System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    if (f != c) {
                        System.out.println("La matriz NO es simétrica (debe ser cuadrada).");
                        break;
                    }

                    boolean simetrica = true;
                    boolean asimetrica = true;
                    for (int i = 0; i < f; i++) {
                        for (int j = 0; j < c; j++) {
                            if (m[i][j] != m[j][i]) simetrica = false;
                            if (m[i][j] != -m[j][i]) asimetrica = false;
                        }
                    }
                    System.out.println("¿Es simétrica?: " + simetrica);
                    System.out.println("¿Es asimétrica?: " + asimetrica);
                    break;
                }

                case 10: { // Determinante
                    System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    try {
                        int det = determinante(m);
                        System.out.println("El determinante es: " + det);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 11: { // Matriz menor
                    System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);
                    System.out.print("Ingresa la fila a omitir (índice): "); int filaOmitir = sc.nextInt();
                    System.out.print("Ingresa la columna a omitir (índice): "); int colOmitir = sc.nextInt();

                    try {
                        int[][] res = minor(m, filaOmitir, colOmitir);
                        imprimirMatriz(res);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }

                case 12: { // Cofactores
                    System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    if (f != c) {
                        System.out.println("Error: La matriz debe ser cuadrada para calcular cofactores.");
                        break;
                    }

                    int[][] res = matrizCofactores(m);
                    imprimirMatriz(res);
                    break;
                }

                case 13: { // Adjunta
                    System.out.print("Filas de la matriz: "); int f = sc.nextInt();
                    System.out.print("Columnas de la matriz: "); int c = sc.nextInt();
                    int[][] m = leerMatriz(f, c, sc);

                    if (f != c) {
                        System.out.println("Error: La matriz debe ser cuadrada para calcular la adjunta.");
                        break;
                    }

                    int[][] res = matrizAdjunta(m);
                    imprimirMatriz(res);
                    break;
                }

                case 14: { // Imagen a matriz
                    System.out.print("Ingresa la ruta de la imagen (ej. C:/imagen.jpg): ");
                    sc.nextLine(); // Limpiar el buffer de lectura
                    String ruta = sc.nextLine();
                    int[][] mImg = imagenAMatriz(ruta);

                    if (mImg != null) {
                        System.out.println("¡Imagen cargada con éxito! Dimensiones: " + mImg.length + "x" + mImg[0].length);
                        System.out.println("¿Deseas imprimir la matriz de píxeles en consola? (1. Sí / 2. No)");
                        int ver = sc.nextInt();
                        if (ver == 1) {
                            imprimirMatriz(mImg);
                        }
                    }
                    break;
                }

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
            


       } while (opcion != 0);

       sc.close();
}



// Auxiliares 
 
// Función para leer una matriz desde la entrada estándar
public static int[][] leerMatriz(int filas, int columnas, Scanner sc) {

    int[][] matriz = new int[filas][columnas];

    System.out.println("Ingresa los elementos de la matriz:");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            System.out.print("Elemento [" + i + "][" + j + "]: ");
            matriz[i][j] = sc.nextInt();
        }
    }

    return matriz;
}

//Funcion para imprimir una matriz en la salida estándar
public static void imprimirMatriz(int[][] matriz) {
    System.out.println("El resultado es:");
    for (int[] fila : matriz) {
        for (int valor : fila) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}

//Convertir una imagen a una matriz de enteros y escala de grises.
public static int[][] imagenAMatriz(String rutaArchivo) {
    try {
        BufferedImage imagen = ImageIO.read(new File(rutaArchivo));
        int filas = imagen.getHeight();
        int columnas = imagen.getWidth();
        int[][] matrizPixels = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                int rgb = imagen.getRGB(j, i);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                matrizPixels[i][j] = (r + g + b) / 3; 
                }
            }
            return matrizPixels;
        } catch (Exception e) {
        System.out.println("Error al leer la imagen" + e.getMessage());
        return null;
        }
    }

// Función para realizar operaciones básicas de matrices 

//Suma de matrices
public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
    int filas = matriz1.length;
    int columnas = matriz1[0].length;
    int [][] resultado = new int[filas][columnas];

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz1[i][j] + matriz2[i][j];
        }
    }
    return resultado;
}

//Resta de matrices
public static int[][] restarMatrices(int[][] matriz1, int[][] matriz2) {
    int filas = matriz1.length;
    int columnas = matriz1[0].length;
    int [][] resultado = new int[filas][columnas];

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz1[i][j] - matriz2[i][j];
        }
    }
    return resultado;   

}

//Multiplicación de matrices
public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
    int filas1 = matriz1.length;
    int columnas1 = matriz1[0].length;
    int filas2 = matriz2.length;
    int columnas2 = matriz2[0].length;
    int[][] resultado = new int[filas1][columnas2];

    for (int i = 0; i < filas1; i++) {
        for (int j = 0; j < columnas2; j++) {
            resultado[i][j] = 0;
            for (int k = 0; k < columnas1; k++) {
                resultado[i][j] += matriz1[i][k] * matriz2[k][j];
            }
        }
    }
    return resultado;
}

//Escalar una matriz
public static int[][] escalarMatriz(int[][] matriz, int escalar) {
    int filas = matriz.length;
    int columnas = matriz[0].length;
    int[][] resultado = new int[filas][columnas];

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz[i][j] * escalar;
        }
    }
    return resultado;
}

//Elevar una matriz a la potencia N
public static int[][] potenciaMatriz(int[][] matriz, int potencia) {
    if (potencia < 0) {
        throw new IllegalArgumentException("La potencia debe ser un número entero no negativo.");
    }
    if (potencia == 0) {
        // Retornar matriz identidad (opcional, por ahora una matriz cuadrada de 1s en la diagonal)
        int n = matriz.length;
        int[][] identidad = new int[n][n];
        for (int i = 0; i < n; i++) identidad[i][i] = 1;
        return identidad;
    }

    int[][] resultado = matriz;
    for (int p = 1; p < potencia; p++) {
        resultado = multiplicarMatrices(resultado, matriz);
    }
    return resultado;
}

//Matriz al cuadrado
public static int[][] matrizAlCuadrado(int[][] matriz) {
    return multiplicarMatrices(matriz, matriz);
}

// Función para trasponer una matriz
public static int[][] trasponerMatriz(int[][] matriz) {
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

//Generar/Verificar Identidad, Diagonal, Triangular superior/inferior
public static void verificarPropiedades(int[][] matriz) {
    int filas = matriz.length;
    int columnas = matriz[0].length;
    
    boolean esCuadrada = (filas == columnas);
    boolean esIdentidad = esCuadrada;
    boolean esDiagonal = esCuadrada;
    boolean esTriangularSuperior = true;
    boolean esTriangularInferior = true;

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            if (esCuadrada) {
                if (i == j && matriz[i][j] != 1) esIdentidad = false;
                if (i != j && matriz[i][j] != 0) {
                    esIdentidad = false;
                    esDiagonal = false;
                }
            }
            if (i > j && matriz[i][j] != 0) esTriangularSuperior = false;
            if (i < j && matriz[i][j] != 0) esTriangularInferior = false;
        }
    }

    System.out.println("Propiedades de la matriz:");
    System.out.println("Es cuadrada: " + esCuadrada);
    System.out.println("Es identidad: " + esIdentidad);
    System.out.println("Es diagonal: " + esDiagonal);
    System.out.println("Es triangular superior: " + esTriangularSuperior);
    System.out.println("Es triangular inferior: " + esTriangularInferior);
}


// Determinante
public static int determinante(int[][] matriz) {
    int filas = matriz.length;
    int columnas = matriz[0].length;

    if (filas != columnas) {
        throw new IllegalArgumentException("La matriz debe ser cuadrada para calcular el determinante.");
    }

    if (filas == 1) {
        return matriz[0][0];
    } else if (filas == 2) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
    } else {
        int det = 0;
        for (int j = 0; j < columnas; j++) {
            det += Math.pow(-1, j) * matriz[0][j] * determinante(minor(matriz, 0, j));
        }
        return det;
    }
}

// Matriz menor 
public static int[][] minor(int[][] matriz, int fila, int columna) {
    int filas = matriz.length;
    int columnas = matriz[0].length;
    int[][] menor = new int[filas - 1][columnas - 1];

    for (int i = 0, m = 0; i < filas; i++) {
        if (i == fila) continue;
        for (int j = 0, n = 0; j < columnas; j++) {
            if (j == columna) continue;
            menor[m][n] = matriz[i][j];
            n++;
        }
        m++;
    }
    return menor;
}

// Matriz de cofactores
public static int[][] matrizCofactores(int[][] matriz) {
    int filas = matriz.length;
    int columnas = matriz[0].length;
    int[][] cofactores = new int[filas][columnas];

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            // El cofactor es (-1)^(i+j) * determinante del menor
            int[][] menorMatriz = minor(matriz, i, j);
            int detMenor = determinante(menorMatriz);
            cofactores[i][j] = (int) (Math.pow(-1, i + j) * detMenor);
        }
    }
    return cofactores;
}

// Matriz adjunta
public static int[][] matrizAdjunta(int[][] matriz) {
    int[][] cofactores = matrizCofactores(matriz);
    return trasponerMatriz(cofactores);
}

}
