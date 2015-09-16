import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			String input = new String();
			input = keyboard.nextLine();
			input += " ";
			double numApartments = Integer.parseInt(input.substring(0, input.indexOf(' ')).trim());
			input = input.substring(input.indexOf(' '));
			input = input.substring(1);
			double width = Integer.parseInt(input.substring(0, input.indexOf(' ')).trim());
			input = input.substring(input.indexOf(' '));
			input = input.substring(1);
			double length = Integer.parseInt(input.substring(0, input.indexOf(' ')).trim());
			input = input.substring(input.indexOf(' '));
			input = input.substring(1);
			double height = Integer.parseInt(input.substring(0, input.indexOf(' ')).trim());
			input = input.substring(input.indexOf(' '));
			input = input.substring(1);
			double area = Integer.parseInt(input.substring(0, input.indexOf(' ')).trim());
			input = input.substring(input.indexOf(' '));
			input = input.substring(1);
			double doorsWindows = Integer.parseInt(input.substring(0, input.indexOf(' ')).trim()); //The above grabs the number of apartments, width, length, area, and number of doors/windows
			
			if(numApartments == 0 && width == 0 && length == 0 && height == 0 && area == 0 && doorsWindows == 0 ) break;
			
			double doorArea = 0;

			for(int i = 0; i < doorsWindows; i++) {
				String doorsDimension = keyboard.nextLine();
				doorsDimension += " ";
				double doorWidth = Integer.parseInt(doorsDimension.substring(0, doorsDimension.indexOf(' ')));
				doorsDimension = doorsDimension.substring(doorsDimension.indexOf(' '));
				doorsDimension = doorsDimension.substring(1);
				double doorHeight = Integer.parseInt(doorsDimension.substring(0, doorsDimension.indexOf(' ')));
				doorArea += doorWidth * doorHeight;
			}



			double wallArea1 = width * height * 2;
			double wallArea2 = length * height * 2;
			double ceilingArea = length * width;
			double totalArea = wallArea1 + wallArea2 + ceilingArea - doorArea;

			double cansNeeded =  ( totalArea * numApartments / area);
			if (cansNeeded > (int)cansNeeded) cansNeeded += 1;
			int returnThis = (int)cansNeeded;

			System.out.println(returnThis);
		}

	}

}
