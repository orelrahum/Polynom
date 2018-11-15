package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void testF() {
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(10,2);
		m1.add(m2);
		assertEquals(13, m1.get_coefficient());
		assertEquals(2, m1.get_power());
		
		Monom m3 = new Monom(-10,2);
		m3.add(m2);
		assertEquals(0, m3.get_coefficient());
		assertEquals(2, m3.get_power());
		
		Monom m4 = new Monom(-12.25,2);
		m4.add(m2);
		assertEquals(-2.25, m4.get_coefficient());
		assertEquals(2, m4.get_power());
	}

	@Test
	void testDerivative() {
		Monom m1 = new Monom(-3,2);
		assertEquals(-6, m1.derivative().get_coefficient());
		assertEquals(1, m1.derivative().get_power());
		
		Monom m2 = new Monom(0,0);
		assertEquals(0, m2.derivative().get_coefficient());
		
		Monom m3 = new Monom(2,0);
		assertEquals(0, m3.derivative().get_coefficient());
		
		Monom m4 = new Monom(2, 3);
		assertEquals(6, m4.derivative().get_coefficient());
		assertEquals(2, m4.derivative().get_power());
		
		Monom m5 = new Monom(-2, 3);
		assertEquals(-6, m5.derivative().get_coefficient());
		assertEquals(2, m5.derivative().get_power());
		
		Monom m6 = new Monom(2.1, 3);
		assertEquals(6.300000000000001, m6.derivative().get_coefficient());
		assertEquals(2, m6.derivative().get_power());
		
		Monom m7 = new Monom(2, 2);
		assertEquals(4, m7.derivative().get_coefficient());
		assertEquals(1, m7.derivative().get_power());
		
		Monom m8 = new Monom(2, 1);
		assertEquals(2, m8.derivative().get_coefficient());
		assertEquals(0, m8.derivative().get_power());
	}

	@Test
	void testMultyply() {
		Monom m1 = new Monom(-3,2);
		Monom m2 = new Monom(10.5,6);
		m1.multyply(m2);
		assertEquals(-31.5, m1.get_coefficient());
		assertEquals(8, m1.get_power());
		
		Monom m3 = new Monom(0, 2);
		Monom m4 = new Monom(3,6);
		m4.multyply(m3);
		assertEquals(0, m4.get_coefficient());		
		Monom m5 = new Monom(1, 1);
		Monom m6 = new Monom(1,0);
		m5.multyply(m6);
		assertEquals(1, m5.get_coefficient());
		assertEquals(1, m5.get_power());
		
		Monom m7 = new Monom(-2.5, 1);
		Monom m8 = new Monom(-2,0);
		m7.multyply(m8);
		assertEquals(5, m7.get_coefficient());
		assertEquals(1, m7.get_power());
		
		Monom m9 = new Monom(-2.5, 0);
		Monom m10 = new Monom(2,0);
		m9.multyply(m10);
		assertEquals(-5, m9.get_coefficient());
		assertEquals(0, m9.get_power());
	}

	@Test
	void testAdd() {
	Monom m1 = new Monom(3,2);
	Monom m2 = new Monom(10,2);
	m1.add(m2);
	assertEquals(13, m1.get_coefficient());
	assertEquals(2, m1.get_power());
	
	Monom m3 = new Monom(-10,2);
	m3.add(m2);
	assertEquals(0, m3.get_coefficient());
	assertEquals(2, m3.get_power());
	
	Monom m4 = new Monom(-12.25,2);
	m4.add(m2);
	assertEquals(-2.25, m4.get_coefficient());
	assertEquals(2, m4.get_power());
	}



	@Test
	void testIsEquals() {
		Monom m1 = new Monom(0, 0);
		Monom m2 = new Monom(2, 0);
		Monom m3 = new Monom(2, 3);
		Monom m4 = new Monom(2, 3);
		System.out.println(m3.toString());
		System.out.println(m4.toString());
		assertFalse(m1.equals(m2));
		assertFalse(m2.equals(m3));
		assertTrue(!m3.equals(m4));
		assertTrue(m4.equals(m3));
	}

//	@Test
//	void testIsZero() {
//		fail("Not yet implemented");
//	}
}
