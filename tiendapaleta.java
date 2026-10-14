import java.util.Scanner;

public class tiendapaleta {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
/*  una paleteria vende tres sabores: fresa, limon y coco. Durante dos dias, el programa solicitara cuantas paletas de cada sabor se vendieron. Al final, mostrara el total vendido por dia y el dinero recaudado. l
... os precios son: fresa $15, limon $12 y coco $18*/

        final int PRECIO_FRESA = 15;
        final int PRECIO_LIMON = 12;
        final int PRECIO_COCO = 18;

        int[][] ventas = new int[2][3]; 

        for (int dia = 0; dia < 2; dia++){
            System.out.println("\n===Dia " + (dia + 1) + ":===");
            for (int sabor = 0; sabor < 3; sabor++) {
                System.out.println("\nIngrese la cantidad de paletas vendidas de");
                switch (sabor) {

                    case 0:
                        System.out.print("Fresa:");
                        break;

                    case 1:
                        System.out.print("Limon:");
                        break;

                    case 2:
                        System.out.print("Coco:");
                        break;    
            }

            ventas[dia][sabor] = Integer.parseInt(sc.nextLine());

            }    
        }

        for (int dia = 0; dia < 2; dia++) {
            int totalvendido = 0;
            int totalrecaudado = 0;

            for (int sabor = 0; sabor < 3; sabor++) {
                switch (sabor) {

                    case 0:
                        totalvendido += ventas[dia][sabor];
                        totalrecaudado += ventas[dia][sabor] * PRECIO_FRESA;
                        break;

                    case 1:
                        totalvendido += ventas[dia][sabor];
                        totalrecaudado += ventas[dia][sabor] * PRECIO_LIMON;
                        break;

                    case 2:
                        totalvendido += ventas[dia][sabor];
                        totalrecaudado += ventas[dia][sabor] * PRECIO_COCO;
                        break;    


                }

            }

            System.out.println("\nTotal de paletas vendidas el dia " + (dia + 1) + ":\n" + totalvendido);
            System.out.println("\nDinero recaudado en el dia " + (dia + 1) + ":\n" + totalrecaudado);

        }

        sc.close();
    }
}
