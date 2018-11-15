package myMath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import org.omg.CORBA.PolicyError;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 * @author orelr
 * @author Lital
 */

public class Polynom implements Polynom_able{
	ArrayList<Monom> poly;

	Monom_Comperator CompareSort=new Monom_Comperator();

	public Polynom () {
		poly=new ArrayList<Monom>(0);
	}
	public Polynom (String s) {
		Polynom polyString=new Polynom();
		poly=new ArrayList<Monom>();
		Monom m;
		if(s.length()==0) { // if its emepy string its throw exception
			throw new IndexOutOfBoundsException("this String is empty :(");
		}
		s=s.replaceAll("\\+-", "-"); //change all +- to plus (if user inpot +- )
		s=s.replaceAll("\\-", "+-"); // change all - to +- (to make split by +)
		if (s.charAt(0)=='+'){ // if we start with - in Polynom
			s=s.substring(1);
		}
		String str [];
		str=s.split("\\+");

		for (int i=0;i<str.length;i++) { // all String in my array its need be polynom and I add it)
			m =new Monom(str[i]);
			polyString.add(m);
		}
		this.poly=polyString.poly;
		if (poly.size()==0) { // if we dont have nothing on polynom (all is zero). give me one zero
			poly.add(new Monom ("0"));
		}

	}
	public Polynom(Polynom p) { // copy constractor
		poly = new ArrayList<Monom>();
		Iterator<Monom> monoms = p.iteretor();
		while(monoms.hasNext()) {
			Monom a = new Monom(monoms.next());
			add(a);
		}
	}


	/**
	 *this function of type y=f(x), where both y and x are real numbers.
	 *@param x this is the value of x
	 *@return the value of this function on axis x
	 */
	@Override
	public double f(double x) { // 
		// TODO Auto-generated method stub
		double fx=0;
		Iterator<Monom> monoms =this.iteretor();
		while (monoms.hasNext()) {
			Monom m=monoms.next();
			fx=fx+m.f(x);
		}
		return fx;
	}
	/**
	 * this function add to my original Polynom. another Polynom
	 * @param p1 this is the Polynom that I need to add to my own Polynom
	 */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> monoms =p1.iteretor();
		// TODO Auto-generated method stub
		while (monoms.hasNext()) {

			this.add(monoms.next());
		}
		poly.sort(CompareSort);
	}
	/**
	 * * this function add to my original Polynom. new Monom
	 * @param m1 this is the Monom that I need to add to my own Polynom
	 */

	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		if (m1.get_coefficient()==0) {
			return;
		}
		Iterator<Monom> monoms = this.iteretor();
		while (monoms.hasNext()&& !poly.isEmpty())
		{
			Monom m=monoms.next();

			if (m.get_power()==m1.get_power()) { //if the result have the same power. connect them
				m.add(m1);
				if(m.isZero()) { //it the result is zero so remove it from my Polynom
					poly.remove(m);
				}
				return;
			}
		}
		poly.add(m1);
		poly.sort(CompareSort); // sort my Polynom
	}
	/**
	 * this function substract to my original Polynom. another Polynom 
	 * @param p1 this is the Polynom that I need to substract to my own Polynom
	 */
	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub

		Iterator<Monom> monoms =p1.iteretor();
		while (monoms.hasNext()) {
			poly.sort(CompareSort);
			Monom m1=monoms.next();
			Monom m=new Monom (m1.get_coefficient()*-1,m1.get_power());
			this.add(m);
		}
		poly.sort(CompareSort);

	}
	/**
	 * Multiply this Polynom by p1
	 * @param p1 its the Polynom that function get
	 */
	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms= this.iteretor();
		Iterator<Monom> monomsp1= p1.iteretor();

		Polynom ans=new Polynom();
		while(monoms.hasNext()) {
			Monom m=monoms.next();
			monomsp1=p1.iteretor();
			while(monomsp1.hasNext()) {
				Monom m1=monomsp1.next();
				Monom answer=m.multyplyans(m1);
				ans.add(answer);		
			}
		}	
		poly.clear();
		poly=ans.poly;
	}
	/**
	 * Test if its same Polynom
	 * @param p1 this Polynom that I need to compare with my Polynom
	 * @return  if its the same Polynom.the answer I get its: True/False
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms=this.iteretor();
		Iterator<Monom> monomsp1=p1.iteretor();
		int counter=0;
		while (monoms.hasNext() && monomsp1.hasNext()) {
			counter++;
			if(!monoms.next().isEquals(monomsp1.next())){
				return false;
			}
		}
		if (counter!=poly.size()) {
			return false;
		}
		return true;
	}
	/**
	 * Test if this is the Zero Polynom
	 * @return if its the "0" Polynom . the answer I get its: True/False
	 */
	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		Iterator<Monom> monoms=this.iteretor();
		while (monoms.hasNext()) {
			if (monoms.next().get_coefficient()!=0) {
				return false;
			} 
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		if (f(x0) * f(x1) <= 0) {
			double middle = (x1 + x0) / 2;
			if (Math.abs(f(middle)) < eps) {
				return middle;
			}
			if (f(x0) == 0) {
				return x0;
			}
			if (f(x1) == 0) {
				return x1;
			}
			if (f(middle) < 0) {
				x0 = middle;
			} else if (f(middle) > 0) {
				x1 = middle;
			}
		}
		else {
			throw new IllegalArgumentException("exponent cannot be calculate ");
		}
		return root(x0, x1, eps);
	}
	/**
	 * create a deep copy of this Polynum
	 * @return Polynom that equal to the original polynom
	 */
	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		Iterator <Monom> monoms= this.iteretor();
		Polynom p = new Polynom();
		while (monoms.hasNext()) {
			p.add(monoms.next());
		}
		return p;
	}
	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 * @return Polynom that derivative to my original Polynom
	 */
	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Iterator <Monom> monoms=this.iteretor();
		Polynom dx= new Polynom();
	
			while (monoms.hasNext()) {
			Monom next=monoms.next();
			Monom deri=next.derivative();
			if (deri.get_coefficient()!=0){
				dx.add(deri);}	
		}
		return dx;
	}
	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub

		double area = 0;
		for(double i=x0;i<x1;i=i+eps)
		{
			if(f(i)<0)
			{

			}
			else
			{
				area+=f(i)*eps;
			}
		}
		return area;
	}

	/**
	 * @return an Iterator (of Monoms) over this Polynom
	 */
	@Override
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub
		return poly.iterator();
	}
	/**
	 * toString function for this polynom
	 * @return the String of this polynom
	 */

	public String toString() {
		String s ="";
		String check="";
		Monom m;
		Iterator <Monom> monoms=this.iteretor();
		if(monoms.hasNext()) {
			s=monoms.next().toString();
		}
		while(monoms.hasNext()) {
			m=monoms.next();
			check=""+m.get_coefficient();
			if (check.charAt(0)=='-'|| check.charAt(0)=='+'){
				s=s+m.toString();
			}
			else {
				s=s+"+"+m.toString();
			}
		}


		return s;
	}
	public void GUI(double xStart, double xFinish) {
		Graph frame = new Graph(this, xStart, xFinish);
		frame.setVisible(true);
	}
	// ********** add your code below ***********

}
