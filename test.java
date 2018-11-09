package MyMath;
import java.util.Iterator;
public class test {

	public static void main(String[] args) {
		System.out.println("######test1######");
		test1();
		System.out.println("\n\n######test2######\n");
		test2();
		

	}
	
	public static void test2() {
		Polynom_able p1 = new Polynom("2x+-3x^2+x^3");
		Polynom_able p2 = new Polynom("-0.2+2.1x+-x^3");
		
		//add
		p1.add(p2);
		System.out.println("get \"-0.2+4.1x-3x^2\":");
		System.out.println(p1);
		
		//substract
		p1.substract(p2);
		System.out.println("get \"2x-3x^2+x^3\":");
		System.out.println(p1);
		
		//multiply
		Polynom_able mul = p1.copy();
		mul.multiply(p2);
		System.out.println("get \"-0.4x+4.8x^2-6.5x^3+0.1x^4+3x^5-x^6\":");
		System.out.println(mul);
		
		//derivative
		System.out.println("get \"2-6x+3x^2\":");
		System.out.println(p1.derivative());
		
		System.out.println("get \"2.1-3x^2\":");
		System.out.println(p2.derivative());
		
		//f(x)
		System.out.println("get 6:" + p1.f(3));
		System.out.println("get -20.9:" + p2.f(3));
		
		
		
		//root and area
		double eps = Double.MIN_VALUE;
		System.out.println("\nroot\n");
		
		//root p1
		System.out.println("get something close to 0:" + p1.root(-0.5, 0.5, eps));
		System.out.println("get something close to 1:" + p1.root(0.5, 1.5, eps));
		System.out.println("get something close to 2:" + p1.root(1.5, 2.5, eps));
		
		//root p2
		System.out.println("get something close to -1.49:" + p2.root(-2, -1, eps));
		System.out.println("get something close to 0.09:" + p2.root(0, 1, eps));
		System.out.println("get something close to 1.39:" + p2.root(1, 2, eps));
		
		eps = 0.00001;
		System.out.println("\narea\n");
		//area
		System.out.println("get something close to -0.25:" + p1.area(0, 1, eps));
		System.out.println("get something close to 0:" + p1.area(0.5, 1.5, eps));
		System.out.println("get something close to -0.140625:" + p1.area(0.5, 2, eps));
		
		System.out.println("get something close to 0.6:" + p2.area(0, 1, eps));
		
		
	}
	
	public static void test1() {
		//zero test
		Polynom_able p1 = new Polynom();
		p1.add(new Monom(0.2,0));
		p1.add(new Monom(-0.1,0));
		p1.add(new Monom(-0.1,0));
		
		System.out.println("get zero:"+p1.toString());
		
		Polynom_able p2 = new Polynom(p1.toString());
		System.out.println("get zero:"+p2.toString());
		
		System.out.println("get true:"+p2.equals(p2));//zero = zero
		
		//polynom test
		p2.add(new Monom(-0.3,0));
		p2.add(new Monom(4,5));
		p2.add(new Monom(-8,1));
		p2.add(new Monom(7.3,3));
		p2.add(new Monom(7,7));
		p2.add(new Monom(-0.2,8));
		p2.add(new Monom(5.2,11));
		
		System.out.println("get this polynom \"-0.3x^0 + -8.0x^1 + 7.3x^3 + 4.0x^5 + 7.0x^7 + -0.2x^8 + 5.2x^11\":");
		System.out.println("polynom is: "+p2);
		
		//copy 1 test
		p1 = new Polynom(p2.toString());
		System.out.println("get same polynom:");
		System.out.println("polynom is: "+p1);
		
		//copy 2 test
		p1 = p2.copy();
		System.out.println("get same polynom:");
		System.out.println("polynom is: "+p1);
		
		//equals 1 test
		p2.add(new Monom(0.2,0));
		p2.add(new Monom(-0.1,0));
		p2.add(new Monom(-0.1,0));
		System.out.println("get true:"+p1.equals(p2));
		
		//equals 2 test
		System.out.println("get true:"+p1.toString().equals(p2.toString()));
		
		
		//Iterator test
		System.out.println("get \"0, 1, 3, 5, 7, 8, 11,\":");
		Iterator<Monom> iterator = p1.iteretor();
		while(iterator.hasNext()){
			System.out.print(iterator.next().get_power() + ", ");
		}
		
		System.out.println();
		
	}
	
	

}
