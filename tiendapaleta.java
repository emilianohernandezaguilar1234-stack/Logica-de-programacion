import java.util.Scanner;

public class tiendapaleta {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /* Una paleteria vende tres sabores: fresa, limon y coco. Durante dos dias, el programa solicitara cuantas paletas de cada sabor se vendieron. Al final, mostrara el total vendido por dia, el dinero recaudado y el gran total. 
           Los precios son: fresa $15, limon $12 y coco $18 */

        final int PRECIO_FRESA = 15;
        final int PRECIO_LIMON = 12;
        final int PRECIO_COCO = 18;

        int[][] ventas = new int[2][3]; 
        int granTotalRecaudado = 0; 

        for (int dia = 0; dia < 2; dia++) {
            System.out.println("\n=== Dia " + (dia + 1) + " ===");
            
            int totalVendidoDia = 0;
            int totalRecaudadoDia = 0;

            for (int sabor = 0; sabor < 3; sabor++) {
                System.out.print("Ingrese la cantidad de paletas vendidas de ");
                
                switch (sabor) {
                    case 0:
                        System.out.print("Fresa: ");
                        break;
                    case 1:
                        System.out.print("Limon: ");
                        break;
                    case 2:
                        System.out.print("Coco: ");
                        break;    
                }

                // Guardamos en la matriz
                ventas[dia][sabor] = Integer.parseInt(sc.nextLine());

                // Calculamos de una vez por cada sabor ingresado
                int precioActual = 0;
                if (sabor == 0) {
                    precioActual = PRECIO_FRESA;
                } else if (sabor == 1) {
                    precioActual = PRECIO_LIMON;
                } else if (sabor == 2) {
                    precioActual = PRECIO_COCO;
                }

                totalVendidoDia += ventas[dia][sabor];
                totalRecaudadoDia += ventas[dia][sabor] * precioActual;
            }    

            // Mostramos los resultados del día actual
            System.out.println("\nTotal de paletas vendidas el dia " + (dia + 1) + ": " + totalVendidoDia);
            System.out.println("Dinero recaudado en el dia " + (dia + 1) + ": $" + totalRecaudadoDia);
            
            // Sumamos lo del día actual al gran total general
            granTotalRecaudado += totalRecaudadoDia;
        }

        // Mostramos el gran total al finalizar ambos días
        System.out.println("\n=======================================");
        System.out.println(" GRAN TOTAL RECAUDADO (Ambos dias): $" + granTotalRecaudado);
        System.out.println("=======================================");

        sc.close();
    }
}