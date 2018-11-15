
package myMath;

import javax.management.RuntimeErrorException;

/**
 * --------------------------boaz----------------------------------------------------
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 * @author orelr
 * @author Lital
 */
public class Monom implements function{

	public int get_power() {
		return _power;
	}
	public double get_coefficient() {
		return _coefficient;
	}
	/**
	 * 
	 * @param a : set as a coefficient of x
	 * @param b : set as a power of the monom
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	/**
	 * copy constructor
	 * @param ot : the monom that we want to copy
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	/**
	 * String constructor 
	 * @param s : string that Represents the monom
	 */
	public Monom (String s)
	{
		boolean minus=false;
		if(s.length()==0) {
			throw new IndexOutOfBoundsException("this String is empty :(");
		}
		s=s.toLowerCase();
		String s1=s;
		if (s.charAt(0)=='-')
		{
			s1=s1.substring(1);
			minus=true;
			
		}
		int xindex=s.indexOf('x');
		int powerindex=s.indexOf('^');
		if (isMonom(s1))
		{
			if(minus&&xindex!=1&&xindex!=-1) {
				String coe= s.substring(0, xindex);
				set_coefficient(Double.parseDouble(coe));
				String pow=s.substring(powerindex+1);
				if(powerindex==-1) {
					set_power(1);
				}else {
					set_power(Integer.parseInt(pow));
				}
				return;
			}
			if(minus&&xindex==1){
				set_coefficient(-1);
				String pow=s.substring(powerindex+1);
				if(powerindex==-1) {
					set_power(1);
				}else {
					set_power(Integer.parseInt(pow));
				}
				return;
			}
			if(xindex==0){
				set_coefficient(1);
				String pow=s.substring(powerindex+1);
				if(powerindex==-1) {
					set_power(1);
				}else {
					set_power(Integer.parseInt(pow));
				}
				return;
			}
			if (xindex==-1 && powerindex==-1){
				set_coefficient(Double.parseDouble(s));
				set_power(0);
				return;
			}
		}
		if (powerindex==-1 && xindex!=-1)
		{
			
			
			if(s.charAt(1)=='-') {
				String coe=s.substring(1, xindex);
				set_coefficient(Double.parseDouble(coe));
				return;
			}
			if(s.charAt(0)=='-') {
				String coe=s.substring(0, xindex)+"1";
				set_coefficient(Double.parseDouble(coe));
				return;
			}
			else {
				String coe= s.substring(0, xindex);
				set_coefficient(Double.parseDouble(coe));}
			set_power(1);
			return;
		}
		else
		{
			if(s.charAt(1)=='-') {
				String coe=s.substring(1, xindex);
				set_coefficient(Double.parseDouble(coe));
			}else {
				String coe=s.substring(0, xindex);
				set_coefficient(Double.parseDouble(coe));}
			String pow=s.substring(powerindex+1);
			set_power(Integer.parseInt(pow));
		}
	}
	// ***************** add your code below **********************
	/**
	 * Calculates the value of y (f(x))
	 * @param x - the value of x
	 */
	@Override

	public double f(double x) {
		double fx=(Math.pow(x, get_power()))*get_coefficient();
		return fx;
	} 
	/**
	 * that function Calculates the derivative of the correct function
	 * to read more: https://he.wikipedia.org/wiki/%D7%A0%D7%92%D7%96%D7%A8%D7%AA
	 * @return dx (is the monom after the derivative action)
	 */
	public Monom derivative () {
		double coe=get_coefficient()*get_power();
		int pow=get_power()-1;
		Monom dx=new Monom(coe,pow);
		return dx;
	}
	/**
	 * this function change this monom to the monom that we get after we Multiply the correct monom with m1
	 * @param m1 the monom that we Multiply
	 */
	public void multyply (Monom m1)
	{
		set_power(get_power()+m1.get_power());
		set_coefficient(get_coefficient()*m1.get_coefficient());

	}
	public Monom multyplyans (Monom m1)
	{
		Monom multy=new Monom (get_coefficient()*m1.get_coefficient(),get_power()+m1.get_power());
		return multy;
	}
	/**
	 * this function add m1 to the correct monom
	 * @param m1 - the monom that we want to add
	 */
	public void add (Monom m1)
	{
		if (get_power()==m1.get_power())
		{
			set_coefficient(get_coefficient()+m1.get_coefficient());
		}
		else
		{
			// note:we need add Exception
			System.err.println("Error: cannot add fuctions without the same power");
		}
	}
	public String toString () {
		if (get_coefficient()==0) {
			return "0";
		}
		if (get_power()==0) {
			return ""+get_coefficient();
		}
		if (get_power()==1 && get_coefficient()==1) {
			return "x";
		}
		if (get_power()==1 && get_coefficient()!=1) {
			return get_coefficient()+"x";
		}
		if(get_coefficient()==1 && get_power()!=1) {
			return "x^"+get_power();
		}
		else {
			return get_coefficient()+"x^"+get_power();
		}
	}
	public boolean isEquals(Monom m) {
		if(this.get_coefficient()==m.get_coefficient()) {
			if(this.get_power()==m.get_power()) {
				return true;
			}
		}
		return false;
	}
	public boolean isZero() {
		boolean zero=false;
		if(get_coefficient()==0) {
			zero=true;
		}
		return zero;
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
	/*this function check if the string is a legal monom 
	 * @param s the string that we want to check 
	 */
	private boolean isMonom (String s)
	{
		int xindex=s.indexOf('x');
		int powerindex=s.indexOf('^');
		if (oneDot(s)>1)
		{
			throw new RuntimeException("error: invaild input");
		}
		if (powerindex==-1 && xindex==-1) {
			return isNum(s);
		}
		if (xindex==0 && s.length()==1) {
			return true;
		}
		if (xindex==0 && powerindex==1) {
			if(oneDot(s.substring(2))!=0||!isNum(s.substring(2))) {
				throw new RuntimeException("error: invaild input");
			}
			return true;
		}
		if (powerindex==-1 &&xindex!=-1 && xindex!=0) {
			if (s.charAt(s.length()-1)=='x') {
				s=s.substring(0, s.length()-1);
			}
			return isNum(s);
		}
		if (powerindex!=-1 && xindex!=-1)
		{
			String coe=s.substring(0, xindex);
			if(isNum(coe))
			{
				String powindex=s.substring(powerindex+1);
				if (powindex.length()==0) {
					throw new RuntimeException("error: invaild input");
				}
				if ((powerindex==xindex+1)&& oneDot(powindex)==0){
					return isNum(powindex);
				}
			}
		}
		throw new RuntimeException("error: invaild input");
	}
	/**
	 * this function check if the string is a number
	 * @param s the string that we want to check
	 * @return boolean- true if its a number & false if isn't
	 */
	private boolean isNum (String s)
	{
		boolean isNum=true;
		if(s.charAt(0)<48 ||s.charAt(0)>57 ) {
			throw new RuntimeException("error: invaild input");
		}

		for (int i=0; i<s.length()&&isNum;i++)
		{
			if (s.charAt(i)!='.' &&(s.charAt(i)<48 ||s.charAt(i)>57 ))
			{
				throw new RuntimeException("error: invaild input");
			}
		}

		return isNum;
	}
	/**
	 * this function checks how much dot there is in this string
	 * @param s the string that we want to check
	 * @return the number of the dots
	 */
	private int oneDot (String s)
	{
		int counter=0;
		for (int i=0;i<s.length();i++)
		{
			if (s.charAt(i)==46)
			{
				counter++;
			}
		}
		return counter;
	}

	public void addForPolynom (Monom m1)
	{
		if (get_power()==m1.get_power()){
			set_coefficient(get_coefficient()+m1.get_coefficient());
		}
		return;
	}
}
