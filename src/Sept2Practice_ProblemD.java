import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sept2Practice_ProblemD {
	public static void main(String args[]) throws FileNotFoundException {
		//Max possible strategic value is 12,487,500

		//Get input
		Scanner input = new Scanner(System.in);
		//Scanner input = new Scanner(new File("../../../../../../../Users/Meece/Desktop/test1.in"));
		String line;
		
		int lineNum = 0;
		int n = 0;
		int m = 0;
		//ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		while((line = input.nextLine().trim()).charAt(0)!='-') {  //TODO: What if null line?
			//System.out.println("Line: " + line);
			//Create ints n and m
			n = Integer.parseInt(line.substring(0, line.indexOf(' ')).trim());
			m = Integer.parseInt(line.substring(line.indexOf(' ')).trim());
			if(n == 0 && m == 0) break; 
			//System.out.println("n:" + n); System.out.println("m:" + m);			
	
			line = input.nextLine();
			//System.out.println("Line: " + line);
			
			//Create ArrayList depots
			ArrayList<Integer> depots = new ArrayList<>();
			while(line.length() > 0) {
				int index;
				if ((index = line.indexOf(' '))!=-1) {
					depots.add(Integer.parseInt(line.substring(0, index).trim()));
					line = line.substring(line.indexOf(' ')).trim();
				} else {
					depots.add(Integer.parseInt(line.trim()));
					line = "";
				}
			}
			
			//System.out.println("STARTING STRATVAL: " + totalValue(depots));
			
			if(m == 0) {
				System.out.println(totalValue(depots));
				continue;
			}
			//System.out.println("attack 1");
			int split = highestValue(depots).get(0);
			ArrayList<Integer> lower = new ArrayList<>();
			ArrayList<Integer> higher = new ArrayList<>();
			for(int i=0; i<depots.size(); i++) {
				if(i<split) {
					lower.add(depots.get(i));
				} else {
					higher.add(depots.get(i));
				}
			}
			/*
			System.out.print("Lower: ");
			for(int x:lower) {
				System.out.print(x + " ");
			}
			System.out.println();
			System.out.print("Higher: ");
			for(int x:higher) {
				System.out.print(x + " ");
			}
			System.out.println();
			*/
			ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
			if(lower.size() > 1) {
				lists.add(lower);
				//System.out.println("ADDED LOWER");
			}
			if(higher.size() > 1) {
				lists.add(higher);
				//System.out.println("ADDED HIGHER");
			}
			//System.out.println("ls: " + lists.size());
			/*
			int totalValue2 = 0;
			for(ArrayList<Integer> aList:lists) {
				System.out.print("A List: ");
				for(int x:aList) {
					System.out.print(x + " ");
				}
				System.out.println();
				
				totalValue2 += totalValue(aList);
			}
			System.out.println("After first attack: " + totalValue2);
			*/
			int count = 1;
			
			while(count < m) {
				//System.out.println("attack " + (count+1));
				lists = updateListsList(lists);
				count++;
			}
			int totalValue = 0;
			for(ArrayList<Integer> aList:lists) {
				totalValue += totalValue(aList);
			}
			System.out.println(totalValue);
			//System.out.println("bottomofwhile");
		}
		//System.out.println("endwhile");
		//if(m == 0 && n != 0) System.out.println();
	}
	
	public static int totalValue(ArrayList<Integer> depots) {
		int n = depots.size();
		int totalValue = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				totalValue += depots.get(i) * depots.get(j);
			}
		}
		return totalValue;
	}
	
	public static ArrayList<ArrayList<Integer>> updateListsList(ArrayList<ArrayList<Integer>> lists) {
		//Index of best list
		int ibl = 0;
		//Value of best list
		int vbl = 0;
		for(int element=0; element<lists.size(); element++) {
			ArrayList<Integer> depotList = lists.get(element);
			//Sorted segments
			ArrayList<Integer> hV = highestValue(depotList);
			
			if(hV.get(hV.get(0)) > vbl) {
				ibl = element;
				vbl = hV.get(hV.get(0));
			}
		}
		ArrayList<Integer> depots = lists.get(ibl);
		int split = highestValue(depots).get(0);
		ArrayList<Integer> lower = new ArrayList<>();
		ArrayList<Integer> higher = new ArrayList<>();
		for(int i=0; i<depots.size(); i++) {
			if(i<split) {
				lower.add(depots.get(i));
			} else {
				higher.add(depots.get(i));
			}
		}
		
		lists.remove(ibl);
		if(lower.size() > 1) {
			lists.add(lower);
		}
		if(higher.size() > 1) {
			lists.add(higher);
		}
		return lists;
	}
	
	public static ArrayList<Integer> highestValue(ArrayList<Integer> depots) {
		int n = depots.size();
		//Create ArrayList segments
		ArrayList<Integer> segments = new ArrayList<>();
		segments.add(0);
		/* This is an arraylist, ordered by the position of the segment
		 * HOWEVER
		 * The 0th element indicates which segment is highest. It is a position, NOT a value 
		 */
		for(int i=1; i<n; i++) {
			ArrayList<Integer> before = new ArrayList<>();
			ArrayList<Integer> after = new ArrayList<>();
			for(int j=0; j<n; j++) {
				if(j<i) before.add(depots.get(j));
				else after.add(depots.get(j));
			}
			int value = 0;
			for(int q:before) {
				for(int w:after) {
					value += q*w;
				}
			}
			ArrayList<Integer> addMe = new ArrayList<>();
			segments.add(value);	
			if(value > segments.get(segments.get(0))) {
				segments.remove(0);
				segments.add(0, i);
			}
		}
		return segments;
	}
}