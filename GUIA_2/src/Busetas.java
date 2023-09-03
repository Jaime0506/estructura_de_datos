import javax.swing.JOptionPane;

public class Busetas {

    public static void main(String[] args) {
       
        int busetas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de busetas: "));
        int dias = 7;

        int[][] ventas = new int[busetas][dias];

        almacenarVentas(ventas, busetas, dias);

        JOptionPane.showMessageDialog(null, "Ventas almacenadas correctamente");
       
        busetaQueMasGana(ventas);
        busetaQueMenosGana(ventas);
        diaMasGananciaPorBuseta(ventas);
        aumentarVentasBajas(ventas);

        JOptionPane.showMessageDialog(null, "Ventas actualizadas");
        imprimirVentas(ventas);
    }

    public static void almacenarVentas(int[][] matriz, int filas, int columnas) {
        for(int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                int ventasxDia = Integer.parseInt(JOptionPane.showInputDialog("Ingresar las ventas para la buseta " + (i+1) + " para el día " + (j+1)));
               
                matriz[i][j] = ventasxDia;
            }
        }
    }

    public static void busetaQueMasGana(int[][] ventas) {
        int[] totalSemana = new int[ventas.length];

        for (int i = 0; i < ventas.length; i++) {
            int totalBuseta = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                totalBuseta += ventas[i][j];
            }
            totalSemana[i] = totalBuseta;
        }

        int busetaMasGana = 0;
        int maxGanancia = totalSemana[0];

        for (int i = 1; i < totalSemana.length; i++) {
            if (totalSemana[i] > maxGanancia) {
                maxGanancia = totalSemana[i];
                busetaMasGana = i;
            }
        }

        JOptionPane.showMessageDialog(null, "La buseta que más gana en la semana es la número " + (busetaMasGana + 1) + " con un total de ventas de " + maxGanancia);
    }

    public static void busetaQueMenosGana(int[][] ventas) {
        int[] totalSemana = new int[ventas.length];

        for (int i = 0; i < ventas.length; i++) {
            int totalBuseta = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                totalBuseta += ventas[i][j];
            }
            totalSemana[i] = totalBuseta;
        }

        int busetaMenosGana = 0;
        int minGanancia = totalSemana[0];

        for (int i = 1; i < totalSemana.length; i++) {
            if (totalSemana[i] < minGanancia) {
                minGanancia = totalSemana[i];
                busetaMenosGana = i;
            }
        }

        JOptionPane.showMessageDialog(null, "La buseta que menos gana en la semana es la número " + (busetaMenosGana + 1) + " con un total de ventas de " + minGanancia);
    }

    public static void diaMasGananciaPorBuseta(int[][] ventas) {
        for (int i = 0; i < ventas.length; i++) {
            int maxGanancia = ventas[i][0];
            int diaMasGanancia = 0;

            for (int j = 1; j < ventas[i].length; j++) {
                if (ventas[i][j] > maxGanancia) {
                    maxGanancia = ventas[i][j];
                    diaMasGanancia = j;
                }
            }

            String mensaje = "La buseta " + (i + 1) + " gana más el día " + (diaMasGanancia + 1) + " con ventas de " + maxGanancia;
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public static void aumentarVentasBajas(int[][] ventas) {
    double totalVentas = 0;
    int totalElementos = 0;

    for (int[] venta : ventas) {
        for (int j = 0; j < venta.length; j++) {
            totalVentas += venta[j];
            totalElementos++;
        }
    }

    double promedioDiario = totalVentas / totalElementos;
    JOptionPane.showMessageDialog(null, "El promedio diario de ventas es: " + promedioDiario);

    for (int[] venta : ventas) {
        for (int j = 0; j < venta.length; j++) {
            if (venta[j] < promedioDiario) {
                venta[j] = (int) (venta[j] * 1.20);
                
                }
            }
        }
    }

    public static void imprimirVentas(int[][] ventas) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ventas actualizadas:\n");

        for (int i = 0; i < ventas.length; i++) {
            sb.append("Buseta ").append(i + 1).append(": ");
            for (int j = 0; j < ventas[i].length; j++) {
                sb.append(ventas[i][j]).append(" ");
            }
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}