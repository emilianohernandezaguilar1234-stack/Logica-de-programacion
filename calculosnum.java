import java.util.Scanner;
import java.util.Random;

public class calculosnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Ingreso datos de entrada 
        System.out.print("Ingrese un numero de entrada: ");
        double entrada = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese su mes de nacimiento(1-12): ");
        int mes = Integer.parseInt(sc.nextLine());

        double valoractual = entrada;

        //Etapa 1: Promedios
        double sumaleatoria = 0;

        System.out.println("\nNumeros aleatorios generados:");
        for (int i = 0; i < 5; i++){
            double aleatorio = rand.nextInt(100) + 1;
            System.out.println(aleatorio + " ");
            sumaleatoria += aleatorio;
        }

        double promedio = sumaleatoria / 5.0;
        valoractual += promedio;

        System.out.println("\npromedio calculado:\n" + promedio);
        System.out.println("Valor actual despues de la etapa 1:\n" + valoractual);

        //Etapa 2: Resuido % 7 

        double residuo = valoractual % 7;
        valoractual += residuo;

        System.out.println("\nResiduo calculado:\n" + residuo);
        System.out.println("Valor actual despues de la etapa 2:\n" + valoractual);

        //Etapa 3: Porcentaje 12%

        double sumadoce = valoractual * 0.12;
        valoractual += sumadoce; 

        System.out.println("\nAumento del 12% \n" + sumadoce);
        System.out.println("Valor actual despues de la etapa 3:\n" + valoractual);

        //Etapa 4: Suma 'N' valores enteros 

        System.out.print("\nEtapa 4 - ¿Cuántos valores enteros desea sumar?: \n");
        int n = sc.nextInt();

        int sumaN = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese el valor entero #" + i + ": ");
            sumaN += sc.nextInt();
        }

        valoractual += sumaN;
        System.out.println("\nSuma de los " + n + " valores: \n" + sumaN);
        System.out.println("Valor actual despues de la etapa 4:\n" + valoractual);

        //Etapa 5: Division (1-9)

        int divisor = 0;

        do {
            System.out.print("\nIngrese un numero divisor (1-9):");
            divisor = sc.nextInt();

            if (divisor < 1 || divisor > 9){
                System.out.println("Error");
            }
        } while (divisor < 1 || divisor > 9);

            valoractual /= divisor;
            System.out.println("\nDividor aplicado:\n" + divisor);
            System.out.println("Valor actual despues de etapa 5:\n" + valoractual);


        //Resultado Final     

        System.out.println("\n====================");
        System.out.println("RESULTADO FINAL");
        System.out.println("\n====================");

        if (mes % 2 == 0) {
            long valent = Math.round(valoractual);
            System.out.println("Mes de nacimiento:" + mes);
            System.out.println("Resultado Final:" + valent);
        } else {
            System.out.println("Mes de nacimiento:" + mes);
            System.out.println("Resultado final: %.4f%n" + valoractual);
        }

        sc.close();
        
    }


}
