import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Copy {
	public static void main(String args[]) {
		ArrayList<float[]> notes = new ArrayList<float[]>();
		//adding some dummy data to the list
		notes.add(new float[]{7f,3f,9f});
		notes.add(new float[]{6f,2f,10f});
		notes.add(new float[]{5f,3f,8f});
		
		//Use Collections.sort to sort Ascending values on the second value in the float arrays
		Collections.sort(notes, new Comparator<float[]>() {
		    @Override
		    public int compare(float[] o1, float[] o2) {
		        if (o1[0] > o2[0]) return 1;
		        else if(o1[0] < o2[0]) return -1;
		        return 0;
		    }
		});
		
		//Output the values
		for (float[] f : notes){
		    System.out.println(Arrays.toString(f));
		}
	}
}