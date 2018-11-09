package MyMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import MyMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	ArrayList<Monom> poly=new ArrayList<Monom>();
	
	Monom_Comperator ComperSort = new Monom_Comperator();
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double fx=0;
		for(int i=0; i<poly.size(); i++) {
			fx+=poly.get(i).f(x);
		}
		
		return fx;
	}
	@Override
	public void add(Polynom_able p1) {
		// TODO Auto-generated method stub
			Iterator<Monom> monoms = p1.iteretor();
			while(monoms.hasNext()) {
					add(monoms.next());
				}
		}
	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms = this.iteretor();
		while(monoms.hasNext()) {
			if(monoms.next().get_power()==m1.get_power()) {
				monoms.next().add(m1);
				return;
			}
		}
		poly.add(m1);
		poly.sort(ComperSort);
	}

	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
			Iterator<Monom> monoms = p1.iteretor();
			while (monoms.hasNext()) {
				Monom m1 = monoms.next();
				Monom m =new Monom(m1.get_coefficient()*-1,m1.get_power());
				add(m);
		}
	}

	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms=this.iteretor();
		Iterator<Monom> monomsp1=p1.iteretor();
		while (monoms.hasNext())
		{
			while (monomsp1.hasNext())
			{
				monoms.next().multiply(monomsp1.next());
			}
		}
	}

	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms=this.iteretor();
		Iterator<Monom> monomsp1=p1.iteretor();
		boolean equal=true;
		while (monoms.hasNext()&&equal)
		{
			while (monomsp1.hasNext())
			{
				equal=isEqual(monoms.next(), monomsp1.next());
			}
		}
		return equal;
	}
	
	
	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms=this.iteretor();
		while (monoms.hasNext())
		{
			if (monoms.next().get_coefficient()!=0)
			return false;
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		double left=x1-x0;
		double center =(x0+x1)/2;
		if(left<eps) {
			return f(center);
		}
		if(f(x0)*f(center)<0) {
			return root(x0,center,eps);
		}
		return root(center, x1,eps);
	}
	@Override
	public Polynom_able copy() {
		Iterator<Monom> monoms = this.iteretor();
		Polynom p=new Polynom();
		while(monoms.hasNext()) {
			p.add(monoms.next());
		}
		return p;
	}

	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms = this.iteretor();
		Polynom dx=new Polynom();
		while(monoms.hasNext()) {
			dx.add(monoms.next().derivative());
		}
		return dx;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
			double area = 0;
			while(x0<x1) {
				double y= (eps/2)+x0;
				area=area+(eps*f(y));
				x0=x0+eps;
			}
			return area;
		}
	@Override
	public Iterator<Monom> iteretor() {
		return poly.iterator();
	}

	// ********** add your code below ***********
	public Polynom(String s) {
	
	}
	public Polynom() {
		this.poly.add(new Monom(0,0));
	}
	public Polynom(Polynom M) {
		Iterator<Monom> monoms = M.iteretor();
		while(monoms.hasNext()) {
			this.add(monoms.next());
		}
	}
	private boolean isEqual(Monom m1, Monom m2) {
		if(m1.get_coefficient()==m2.get_coefficient()) {
			if(m1.get_power()==m2.get_power()) {
				return true;
			}
		}
		return false;
	}
}
