import java.util.ArrayList;
import java.util.Scanner;


public class Sept9Practice_ProblemE {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Character> alphabet = new ArrayList<>();
		alphabet.add('A');
		alphabet.add('B');
		alphabet.add('C');
		alphabet.add('D');
		alphabet.add('E');
		alphabet.add('F');
		alphabet.add('G');
		alphabet.add('H');
		alphabet.add('I');
		alphabet.add('J');
		alphabet.add('K');
		alphabet.add('L');
		alphabet.add('M');
		alphabet.add('N');
		alphabet.add('O');
		alphabet.add('P');
		alphabet.add('Q');
		alphabet.add('R');
		alphabet.add('S');
		alphabet.add('T');
		alphabet.add('U');
		alphabet.add('V');
		alphabet.add('W');
		alphabet.add('X');
		alphabet.add('Y');
		alphabet.add('Z');
		
		//System.out.println(alphabet.get(0));
		//String ay = "ayyy";
		
		while(true) {
			int numNames = Integer.parseInt(keyboard.nextLine().trim());
			ArrayList<String> names = new ArrayList<>();
			for(int i=0; i<numNames; i++) {
				names.add(keyboard.nextLine());
			}
			ArrayList<Integer> values = new ArrayList<>();
			for(String aName:names) {
				System.out.println("STARTED aName:names FOR LOOP");
				int nameVal = 0;
				int counter;
				for(int i=0; i<aName.length(); i++) {
					System.out.println("STARTED i=0 FOR LOOP");
					counter = 0;
					while(aName.charAt(i) != alphabet.get(i)) {
						System.out.println("STARTED char WHILE LOOP");
						counter ++;
						System.out.println(aName.charAt(i) + ":" + alphabet.get(i));
					}
					counter ++;
					System.out.println("Ended char WHILE LOOP");
					nameVal += counter;
					System.out.println("Added " + counter + " to " + nameVal);
				}
				System.out.println("Ended i=0 FOR LOOP");
				values.add(nameVal);
				System.out.println(aName + " " + nameVal);
			}
			System.out.println("Ended");
		}
	}
}
