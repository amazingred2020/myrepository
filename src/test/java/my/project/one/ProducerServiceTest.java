package my.project.one;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import my.project.one.config.AppConfig;
import my.project.one.entity.Producer;
import my.project.one.services.ProducerDao;


public class ProducerServiceTest {

	private GenericApplicationContext ctx;
	private ProducerDao producerService;
	
	@Before
	public void prepareSutup() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		producerService = ctx.getBean(ProducerDao.class);
		assertNotNull(producerService);
	}
	
	@Test
	public void testFindAllWithFilms() {
		System.out.println("INTO testFindAllWithFilms METHOD");
		List<Producer> result = producerService.findAllWithFilms();
		assertEquals(15, result.size());
	}
	
	@Test
	public void testFindById() {
		System.out.println("INTO testFindById METHOD");
		Producer result = producerService.findById(2l);
		assertNotNull(result);
	}
	
	@Test
	public void testFindProducersByCountry() {
		System.out.println("INTO testFindProducersByCountry METHOD");
		List<Producer> result = producerService.findProducersByCountry("Англия");
		assertEquals(2, result.size());
	}

	@After
	public void closeContext() {
		ctx.close();
	}
}
