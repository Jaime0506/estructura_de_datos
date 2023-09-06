import java.util.Random;

public class Selection {

    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100001);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        long endTime = System.currentTimeMillis();
        double elapsedTimeSeconds = (endTime - startTime);
        // Print the sorted array
        System.out.println("Sorted array:");
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        System.out.println();
        System.out.println("Time elapsed: " + elapsedTimeSeconds + " ms");
        
    }
}
