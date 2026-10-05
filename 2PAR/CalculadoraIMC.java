import java.util.Scanner;   

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true; 

        double peso, altura, imc;
        String clasificacion;
        String recomendacion;
        String respuesta;

        do {

            System.out.print("Ingresa tu peso en Kilogramos: ");
            peso = sc.nextDouble();

            System.out.print("Ingresa tu altura en metros: ");
            altura = sc.nextDouble();

            imc = peso / (altura * altura);

            if (imc < 18.5){
                clasificacion = "Bajo peso";
                recomendacion = "Se recomienda aumentar la ingesta calórica y consultar a un nutricionista. Ademas, es importante realizar actividad física para ganar masa muscular.";
            } else if (imc < 25) {
                clasificacion = "Normal";
                recomendacion = "Mantener hábitos saludables y continuar con la actividad física regular. No olvides hidratarte adecuadamente y llevar una dieta equilibrada.";
            } else if (imc < 30) {
                clasificacion = "Sobrepeso";
                recomendacion = "Se recomienda reducir la ingesta calórica y aumentar la actividad física. Considere incorporar más frutas, verduras y proteínas magras en su dieta.";
            } else if (imc < 35) {
                clasificacion = "Obesidad 1";
                recomendacion = "Consultar a un profesional de la salud para un plan de pérdida de peso. Puede ser util incluir terapias de comportamiento, cambios en la dieta y un programa de ejercicios supervisado.";
            } else if (imc < 40) {
                clasificacion = "Obesidad 2";
                recomendacion = "Se recomienda supervisión médica estricta, evaluación nutricional especializada y un plan estructurado de salud adaptado a sus necesidades.";
            } else {
                clasificacion = "Obesidad 3";
                recomendacion = "Es fundamental la valoración por un equipo médico multidisciplinario para un control clínico riguroso y opciones de tratamiento avanzadas.";
            }

            System.out.println("Tu IMC es: " + imc);
            System.out.println("Clasificación: " + clasificacion);
            System.out.println("Recomendación: " + recomendacion);

            System.out.print("¿Deseas calcular otro IMC? (s/n): ");
            respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }

        } while (continuar); 

    sc.close();

    }
}