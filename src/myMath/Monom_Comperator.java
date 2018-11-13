package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {
	/**
	 * its Compare with 2 Monom's power
	 * its function help for us to make sort
	 * @param arg0 its the first Monom
	 * @param arg1 its the second Monom
	 * @return return number for us (if its return 1 its say that first Monom is bigger, if its return 0 its say that Monoms are equals, if its return -1 its say that the second Monom is bigger)
	 */
	@Override
	public int compare(Monom arg0, Monom arg1) {
		// TODO Auto-generated method stub
		if (arg0.get_power()>arg1.get_power()) {
			return -1;
		}
		if (arg0.get_power()<arg1.get_power()) {
			return 1;
		}
		return 0;
	}

	// ******** add your code below *********

}
