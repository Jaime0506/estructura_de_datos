public class NanoTimeExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        // Realiza alguna operación aquí
        
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        
        System.out.println("Tiempo transcurrido en nanosegundos: " + elapsedTime);
    }
}
