import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaAleatoria {

    public List<Integer> generateRandomNumbers(int numberOfElements) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            int randomNumber = random.nextInt(6901) + 100; // Rango de 100 a 7000
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

    public static void main(String[] args) {
        int numberOfElements = 10; // Cambia este valor al número deseado de elementos

        ListaAleatoria app = new ListaAleatoria();
        List<Integer> randomNumbers = app.generateRandomNumbers(numberOfElements);

        // Imprime la lista de números aleatorios generados
        System.out.println("Números aleatorios generados:");
        for (int number : randomNumbers) {
            System.out.print(number + " ");
        }
    }
}
