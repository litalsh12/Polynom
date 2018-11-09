package MyMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	@Override
	public int compare(Monom arg0, Monom arg1) {
		// TODO Auto-generated method stub
		if(arg0.get_power()>arg1.get_power()) {
			return 1;
		}
		if(arg0.get_power()<arg1.get_power()) {
			return -1;
		}
		return 0;
	}

	// ******** add your code below *********

}
