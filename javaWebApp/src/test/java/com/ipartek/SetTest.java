package com.ipartek;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class SetTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		assertTrue(true);
		assertEquals(2, 2);
		assertNull(null);
		
		HashSet<String> paises = new HashSet<>();
		
		assertNotNull(paises);
		
		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");
		
		assertEquals("Mensaje personalizado por si falla", 4, paises.size());
		
		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");
		
		assertEquals("No deberia haber duplicados", 4, paises.size());
		
	}

}
