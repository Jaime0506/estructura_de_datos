public class CambioDeVariables {
    public static void main(String[] args) {
        int var1 = 2;
        int var2 = 600;

        System.out.println("Antes del intercambio:");
        System.out.println("var1 = " + var1);
        System.out.println("var2 = " + var2);

        
        int temp = var1;

        
        var1 = var2;

        
        var2 = temp;

        System.out.println("\nDespués del intercambio:");
        System.out.println("var1 = " + var1);
        System.out.println("var2 = " + var2);
    }
}

