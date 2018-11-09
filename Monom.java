
package MyMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());

	}
	private boolean isFine(String s,int power,int coefficient) {
		if(s.charAt(0)==120||(s.charAt(0)>48&&s.charAt(0)<57)){
			s='+'+s;
		}
		if(coefficient==-1) {
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)<48||s.charAt(i)>57) {
					return false;
				}
			}
		}
		if(power==-1&&coefficient!=-1) {
			if(s.length()!=coefficient) {
				return false;
			}
			for(int i=1; i<coefficient; i++) {
				if(s.charAt(i)<48||s.charAt(i)>57) {
					return false;
				}
		}
		for(int i=1; i<coefficient; i++) {
			if(s.charAt(i)<48||s.charAt(i)>57) {
				return false;
			}
		}
		String powerS=s.substring(power+1);
		for(int i=power+1; i<s.length();i++) {
			if(s.charAt(i)<48||s.charAt(i)>57) {
				return false;
			}
		}
		}
		return true;
	}
	public Monom(String s) {
		s=s.toLowerCase();
		int powerindex=s.indexOf('^');
		int coefficientindex =s.indexOf('x');
		if(isFine(s,powerindex,coefficientindex))
		{
		String coefficientstring = s.substring(0,coefficientindex);
		double coefficient= Double.parseDouble(coefficientstring);
		String powerstring = s.substring(powerindex+1);
		double power= Double.parseDouble(powerstring);
		}
	}

	// ***************** add your code below **********************
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double fx;
		fx=Math.pow(x, _power)*_coefficient;
		return 0;
	} 
	public int get_power() {
		// TODO Auto-generated method stub
		return _power;
	}
	public double get_coefficient() {
		// TODO Auto-generated method stub
		return _coefficient;
	}
	public Monom derivative() {
		Monom dx=new Monom(_power*_coefficient,_power-1);
		return dx;
	}
	public void multiply(Monom m1) {
		_power=_power+m1._power;
		_coefficient=_coefficient*m1._coefficient;
	}
	public void add(Monom m1) {
		if(_power==m1._power) {
			_coefficient=_coefficient+m1._coefficient;
		}else {
			System.err.println("Error: cannot add functions without the same power");
		}
	}
	
	//****************** Private Methods and Data *****************
	
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}
	
	private double _coefficient; // 
	private int _power;
}
