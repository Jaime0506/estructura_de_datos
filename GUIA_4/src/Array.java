import java.util.Arrays;
import java.util.Random;

public class Array {
	
	public int[] array; 
	
	private int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(100001) - 50000;
		
		return number;
	}
	
	public void fillMatrix() {
		for (int i = 0; i < array.length; i++) {
			array[i] = randomNumber();
		}
	} 
	
	public void showMatrix() {
		System.out.println(Arrays.toString(array));
	}
	
	public int[] getArray() {
		return array;
	}
	
	public void setSize(int size) {
		array = new int[size];
	}
	
	public static void main(String[] args) {
		Array array = new Array();
		array.setSize(100);

		array.fillMatrix();
		array.showMatrix();
	}
}
