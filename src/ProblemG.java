import java.util.ArrayList;
import java.util.Scanner;

public class ProblemG {
	long val1, val2;
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// TODO Auto-generated method stub
		
		while (true) {
			ArrayList<Long> primes = new ArrayList<>();
			ArrayList<Long> values = new ArrayList<>();
			ArrayList<Long> foundprimes = new ArrayList<>();
			ArrayList<ArrayList<Long>> primes2 = new ArrayList<>();
			ArrayList<ArrayList<Long>> solutions = new ArrayList<>();
			ArrayList<Long> solutionstemp = new ArrayList<>();
			ArrayList<Long> primetemp = new ArrayList<>();
			String line = keyboard.nextLine();
			line = line.trim();
			long val1 = Long.parseLong(line.substring(0, line.indexOf(' ')).trim());
			long val2 = Long.parseLong(line.substring(line.indexOf(' ')).trim());
			if (val1 == 0 && val2 == 0) break;
			for (long x = val1; x<=val2; x++) {
				values.add(x);
			}
			int y;
			int primeflag = 0;
			//System.out.println(val1);
			//System.out.println(val2);
			for (long x = 2; x<=(val2/2); x++) {
				primeflag = 1;
				for (y = 2; y<=(x/2); y++) {
					if (x%y==0) {
						primeflag = 0;
						break;
					}
				}
				if (primeflag > 0) primes.add(x);
			}
			//System.out.println(primes);
			//System.out.println(values);
			for (int x = 0; x<values.size(); x++) {
				primetemp = new ArrayList<>();
				for (y = 0; y<primes.size(); y++) {
					if (values.get(x)%primes.get(y)==0) {
						primetemp.add(primes.get(y));
					}
				}
				primes2.add(primetemp);
			}
			//System.out.println(primes2.get(0));
			long counter = 1;
			long tempn = 0;
			for (int z = 0; z<200000; z++) {
				for (int x = 0; x<values.size(); x++) { //position in values
					solutionstemp = new ArrayList<>();
					if (primes2.get(x).size() == counter) {
						//System.out.println(counter);
						solutionstemp.add(values.get(x));
						solutionstemp.add(primes2.get(x).get(0));
						//System.out.println(primes2.get(x).get(0));
						solutions.add(solutionstemp);
						tempn = primes2.get(x).get(0);
						//System.out.println(primes2);
						primes2.get(x).clear();
						
						for (int n = 0; n<primes2.size(); n++) {
							//if (primes2.get(x).size()>0) if (primes2list.contains(primes2.get(x).get(0))) primes2list.remove(primes2list.indexOf(primes2.get(x).get(0)));
							//primes2.remove(primes2.indexOf(primes2.get(x).get(0)))
							if(primes2.get(n).size() > 0) {
								//System.out.println("BEGIN");
								//System.out.println(primes2.get(n));
								//System.out.println(primes2.get(x));
								//System.out.println("END");
								if(primes2.get(n).contains(tempn)) {
									primes2.get(n).remove(primes2.get(n).indexOf(tempn));
								}
							}
						}
						counter = 1;
					}
					if (z == 20000) counter = 1; //???????
				}
				counter += 1;

			}
			//System.out.println(values);
			//System.out.println(primes2);
			//System.out.println(solutions);
			String tempstring = "";
			for (long x = val1; x<=val2; x++) {
				for (ArrayList<Long> touple:solutions) {
					if (x == touple.get(0)) tempstring += touple.get(1)+" ";
				}
			}
			System.out.println(tempstring.trim());
		}
	}
}
