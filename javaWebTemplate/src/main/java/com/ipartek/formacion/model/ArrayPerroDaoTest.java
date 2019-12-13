package com.ipartek.formacion.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.ArrayPerroDao;
import com.ipartek.formacion.modelo.pojo.Perro;
public class ArrayPerroDaoTest {

	private static ArrayPerroDao dao;
	private static Perro mock;
	private static int indice = 1;
	private static final String MOCK_NOMBRE = "pulgas mock";
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dao = ArrayPerroDao.getInstance();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		mock = new Perro(indice, "pulgas Mock");
		dao.create(mock);
		indice++;
	}

	@After
	public void tearDown() throws Exception {
		mock = null;
	}

	@Test
	public void testGetAll() throws Exception {
		assertEquals(indice, dao.getAll().size());
		
		dao.delete(mock.getId());
		
		assertEquals(indice-1, dao.getAll().size());
	}

	@Test
	public void testGetById() throws Exception {
		assertNull("Es imposible que exista este perro",dao.getById(indice-2));
		
		Perro p =  dao.getById(indice);
		assertSame("deberia existir pulgas",p,  mock);
	}

	@Test
	public void testDelete() {
		try {
			Perro pEliminar = new Perro(345, "Pulgas 345");
			Perro p = dao.delete(indice);
			assertSame(p, pEliminar);
			assertEquals("No queda ninguno", 0 , dao.getAll().size());
			
			dao.delete(-indice);
			fail("deberia de haber lanzado una excepcion");
			
		} catch (Exception e) {
			assertTrue("lanzada exception correctamente al eliminar el perro que no existe", true);
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

}
