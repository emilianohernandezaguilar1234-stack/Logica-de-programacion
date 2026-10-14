import java.util.ArrayList;
import java.util.Scanner;

public class listanum {
    public static void main(String[] args) {
        // Se declara el arreglo dinámico (ArrayList) para enteros
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // 1. Leer los 10 números y agregarlos dinámicamente
        System.out.println("Por favor, ingresa 10 números enteros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int num = sc.nextInt();
            numeros.add(num); 
        }

        // 2. Inicializar el mayor y menor con el primer elemento de la lista
        int mayor = numeros.get(0);
        int menor = numeros.get(0);
        int posMayor = 0;
        int posMenor = 0;

        // 3. Recorrer el ArrayList para encontrar los valores y sus posiciones
        for (int i = 1; i < numeros.size(); i++) {
            int actual = numeros.get(i); 
            
            if (actual > mayor) {
                mayor = actual;
                posMayor = i;
            }
            if (actual < menor) {
                menor = actual;
                posMenor = i;
            }
        }

        // 4. Mostrar los cuatro datos requeridos
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("El número mayor es: " + mayor);
        System.out.println("La posición del número mayor es: " + posMayor);
        System.out.println("El número menor es: " + menor);
        System.out.println("La posición del número menor es: " + posMenor);

        sc.close();
    }
}