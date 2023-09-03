
public class FindValue {
	
	public int findElement(int[] array, int element) {
		int response = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				response = i;
			}
		} 
		
		if (response == 0) {
			response = -1;
		}
		
		return response;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindValue app = new FindValue();
		int[] array = {1,2,3,4,5,6};
		
		System.out.println(app.findElement(array, 4));
	}

}
