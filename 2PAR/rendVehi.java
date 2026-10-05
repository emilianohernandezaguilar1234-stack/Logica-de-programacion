public class rendVehi {

    public static void main(String[] args) {

        String numSerie;
        double km, litros, rendEsp, rendReal;
        double costoTotal, difPor;
        double precio = 23.95;
        String clasificacion;

        System.out.print("Ingresa el numero de serie: ");
        numSerie = IO.readln();

        System.out.print("Ingresa los kilometros recorridos: ");
        km = Double.parseDouble(IO.readln());

        System.out.print("Ingresa los litros consumidos: ");
        litros = Double.parseDouble(IO.readln());

        System.out.print("Ingresa el rendimiento esperado: ");
        rendEsp = Double.parseDouble(IO.readln());

        rendReal = km / litros;
        costoTotal = litros * precio;
        difPor = ((rendEsp - rendReal) / rendEsp) * 100;

        if (rendReal >= rendEsp) {
            clasificacion = "Eficiente";
        } else if (rendReal >= rendEsp * 0.9) {
            clasificacion = "Aceptable";
        } else {
            clasificacion = "Ineficiente";
        }

        System.out.println("Numero de serie: " + numSerie);
        System.out.println("Rendimiento esperado: " + rendEsp);
        System.out.println("Rendimiento real: " + rendReal);
        System.out.println("Diferencia de porcentaje: " + difPor + "%");
        System.out.println("Clasificacion: " + clasificacion);
        System.out.println("Costo total: $" + costoTotal);
    }
}