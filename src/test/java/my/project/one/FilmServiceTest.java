package my.project.one;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import my.project.one.config.AppConfig;
import my.project.one.entity.Film;
import my.project.one.services.FilmDao;

public class FilmServiceTest {

	private GenericApplicationContext ctx;
	private FilmDao filmService;
	
	@Before
	public void prepareSutup() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		filmService = ctx.getBean(FilmDao.class);
		assertNotNull(filmService);
	}
	
	@Test
	public void testFindAll(){
		System.out.println("INTO testFindAll METHOD");
		List<Film> result = filmService.findAll();
		assertEquals(15, result.size());
	}
	
	@Test
	public void testFindByReleaseDates() {
		System.out.println("INTO testFindByReleaseDates METHOD");
		List<String> result = filmService.findByReleaseDates(
				new Date((new GregorianCalendar(1990,0,1)).getTime().getTime()),
				new Date((new GregorianCalendar(2019,11,30)).getTime().getTime()));
		assertEquals(15, result.size());
	}
	
	@Test
	public void testFindByMoneyAndCountry() {
		System.out.println("INTO testFindByMoneyAndCountry METHOD");
		List<Film> result = filmService.findByMoneyAndCountry(1000000000, "США");
		assertEquals(2, result.size());
	}
	
	@Test
	public void testFindByProducerAndActorDetails() {
		System.out.println("INTO testFindByProducerAndActorDetails METHOD");
		List<Film> result = filmService.findByProducerAndActorsDetail("Гай", "Наоми");
		assertEquals(1, result.size());
	}
	
	@After
	public void closeContext() {
		ctx.close();
	}
}
