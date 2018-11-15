package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTest {

	
	@Test
	void testPolynomString() {	

	Polynom p3 = new Polynom("3x^2");
	assertEquals("3.0x^2", p3.toString());
	
	Polynom p4 = new Polynom("-3.0x^2");
	assertEquals("-3.0x^2", p4.toString());
	
	Polynom p5 = new Polynom("3.0x^2");
	assertEquals("3.0x^2", p5.toString());
	
	Polynom p6 = new Polynom("-1x^2");
	assertEquals("-1.0x^2", p6.toString());
	
	Polynom p7 = new Polynom("1x^2");
	assertEquals("x^2", p7.toString());
	
	Polynom p8 = new Polynom("x^2");
	assertEquals("x^2", p8.toString());
	
	Polynom p9 = new Polynom("3x^1");
	assertEquals("3.0x", p9.toString());
	
	Polynom p10 = new Polynom("-3x");
	assertEquals("-3.0x", p10.toString());
	
	Polynom p11 = new Polynom("3x");
	assertEquals("3.0x", p11.toString());
	
	Polynom p12 = new Polynom("0x^2");
	assertEquals("0", p12.toString());
	
	Polynom p13 = new Polynom("0");
	assertEquals("0", p13.toString());
	
	Polynom p14 = new Polynom("3x^0");
	assertEquals("3.0", p14.toString());
	
	Polynom p15 = new Polynom("-3x^0");
	assertEquals("-3.0", p15.toString());
	
	Polynom p16 = new Polynom("3");
	assertEquals("3.0", p16.toString());
	
	Polynom p17 = new Polynom("+3");
	assertEquals("3.0", p17.toString());
	
	Polynom p18 = new Polynom("-3");
	assertEquals("-3.0", p18.toString());
	
	Polynom p19 = new Polynom("1x^1");
	assertEquals("x", p19.toString());
	
	Polynom p20 = new Polynom("-1x^1");
	assertEquals("-1.0x", p20.toString());
	
	Polynom p21 = new Polynom("x");
	assertEquals("x", p21.toString());
	
	Polynom p22 = new Polynom("4X^2");
	assertEquals("4.0x^2", p22.toString());
	
	Polynom p23 = new Polynom("425X^2");
	assertEquals("425.0x^2", p23.toString());
	
	Polynom p24 = new Polynom("-4.123123X^2");
	assertEquals("-4.123123x^2", p24.toString());
	
	Polynom p25 = new Polynom("4X^123");
	assertEquals("4.0x^123", p25.toString());
	
	Polynom p26 = new Polynom("123X^123");
	assertEquals("123.0x^123", p26.toString());
	
	Polynom p27 = new Polynom("123.0X^123");
	assertEquals("123.0x^123", p27.toString());
	
	Polynom p28 = new Polynom("3x^2+4x^3-6");
	assertEquals("4.0x^3+3.0x^2-6.0", p28.toString());
	
	Polynom p29 = new Polynom("-6+3x^2+4x^3");
	assertEquals("4.0x^3+3.0x^2-6.0", p29.toString());
	
	}

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
		Polynom p1 = new Polynom("3x^2");
		assertEquals(3.0, p1.f(1));
		
		Polynom p2 = new Polynom("3x^2");
		assertEquals(0.0, p2.f(0));
		
		Polynom p3 = new Polynom("3x^2");
		assertEquals(12.0, p3.f(2));
		
		Polynom p4 = new Polynom("3x^2-6+4x^3");
		assertEquals(38.0, p4.f(2));
		
		Polynom p5 = new Polynom("x^2-10x^3-2x+10");
		assertEquals(-257.0, p5.f(3));
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
		Monom m1 = new Monom(2, 2);
		Monom m2 = new Monom(8, 2);
		
		Polynom p32 = new Polynom("3x^2");
		p32.add(m1);
		assertEquals("5.0x^2", p32.toString());
		
		Polynom p2 = new Polynom("-6+2x^3");
		p2.add(m1);
		assertEquals("2.0x^3+2.0x^2-6.0", p2.toString());

		Polynom p3 = new Polynom("1-x-2x^2+3x^3");
		p3.add(m1);
		assertEquals("3.0x^3-1.0x+1.0", p3.toString());
		
		Polynom p4 = new Polynom("1-x-2x^2+3x^3");
		p4.add(m2);
		assertEquals("3.0x^3+6.0x^2-1.0x+1.0", p4.toString());
	}
	@Test
	void testPolynom() {
		Polynom r=new Polynom("+3");
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
		Polynom p5 = new Polynom("3x^2+10");
		Polynom p2 = new Polynom("-6+2x^3+x^2");
		p2.substract(p5);
		assertEquals("2.0x^3-2.0x^2-16.0", p2.toString());
		
		Polynom p3 = new Polynom("-6x+8x^0-2x^6");
		Polynom p4 = new Polynom("-X+x^3+x^6");
		p3.substract(p4);
		assertEquals("-3.0x^6-1.0x^3-5.0x+8.0", p3.toString());
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
	//	fail("Not yet implemented");
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
		
//		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		Polynom toSt=new Polynom ();
		Monom m1=new Monom (1,3);
		toSt.add(m1);
		//fail("Not yet implemented");
	}

}
