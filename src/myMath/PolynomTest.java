package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void testF() {
		Polynom p= new Polynom("6x^2+12x+4");
		double fx=p.f(1);
		if (fx!=22) {
			fail("Not yet implemented");
		}
		fx=p.f(2.5);
		if (fx!=71.5) {
			fail("Not yet implemented");
		}
		fx=p.f(0);
		if (fx!=4) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testAddPolynom_able() {	
		Polynom p=new Polynom("5x+2");
		p.add(new Polynom("6x^2"));
		Polynom p1=new Polynom("0+6x^2+5x+2+0x^8");
		if(!p.equals(p1)) {
			fail("Not yet implemented");
		}
		p.add(new Polynom("0"));
		if(!p.equals(p1)) {
			fail("Not yet implemented");
		}
		Polynom p2=new Polynom("4x+7x^4");
		p2.add(new Polynom("0"));
		if(!p2.equals(new Polynom ("7x^4+4x"))) {
			fail("Not yet implemented");}

	}

	@Test
	void testAddMonom() {
		Polynom p=new Polynom("5x+2");
		p.add(new Monom("6x^2"));
		Polynom p1=new Polynom("6x^2+5x+2");
		if(!p.equals(p1)) {
			fail("Not yet implemented");
		}
		p.add(new Monom("0"));
		if(!p.equals(p1)) {
			fail("Not yet implemented");
		}
	}
	@Test
	void testPolynom() {
		Polynom r=new Polynom("+3");
		System.err.println(r.toString());
		if(!r.equals(new Polynom("3"))) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void testSubstract() {
		Polynom p=new Polynom("5x+2");
		p.substract(new Polynom("6x^2"));
		Polynom p1=new Polynom("-6x^2+5x+2");
		if(!p.equals(p1)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testMultiply() {
		Polynom p=new Polynom("5x+2");
		p.multiply(new Polynom("6x^2"));
		Polynom p1=new Polynom("30x^3+12x^2");
		if(!p.equals(p1)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testEqualsPolynom_able() {
		Polynom p =new Polynom("3x^2");
		Polynom p1 =new Polynom("3x^2");
		if (!p.equals(p1)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testIsZero() {
		Polynom p =new Polynom("0x+1");
		if(p.isZero()) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		Polynom p =new Polynom("3x^2");
		Polynom_able p1 =p.copy();
		if (!p.equals(p1)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testDerivative() {
		Polynom p=new Polynom("5x+2");
		Polynom_able p1=p.derivative();
		Polynom p2=new Polynom("5");
		if(!p2.equals(p1)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		Polynom toSt=new Polynom ();
		Monom m1=new Monom (1,3);
		toSt.add(m1);
		fail("Not yet implemented");
	}

}
