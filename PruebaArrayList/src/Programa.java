import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) {
		ArrayList<Integer> ai = new ArrayList<>();
		Float f = 0.0f;
		
		ai.add(5);
		ai.add(44);
		ai.add(45);

		for(Integer i : ai) {
			f += i;
		}
		
		System.out.println(f);

		System.out.println(f / ai.size());
	}	
}