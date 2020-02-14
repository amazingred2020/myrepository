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
import my.project.one.entity.Actor;
import my.project.one.services.ActorDao;

public class ActorTest {

	private GenericApplicationContext ctx;
	private ActorDao actorService;
	
	@Before
	public void prepareSutup() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		actorService = ctx.getBean(ActorDao.class);
		assertNotNull(actorService);
	}
	
	@Test
	public void testSave() {
		Actor actor = new Actor();
		actor.setFirstName("Леонардо");
		actor.setLastName("ДиКаприо");
		actor.setBirthDate(new Date((new GregorianCalendar(1974,10,11)).getTime().getTime()));
		actor.setCountry("США");
		actor.setGender("мужчина");

		actorService.save(actor);
		
		assertNotNull(actor.getId());
	}
	
	@Test
	public void testFindActorsByFilmId() {
		System.out.println("INTO testFindActorsByFilmId METHOD");
		List<Actor> result = actorService.findActorsByFilmId(2l);
		assertEquals(4, result.size());
	}
	
	@Test
	public void testDelete() {
		System.out.println("INTO testDelete METHOD");
		Actor actor = actorService.findById(4L);
		assertNotNull(actor);
		actorService.delete(actor);
	}
	
	@Test
	public void testFindActorsByCountry() {
		System.out.println("INTO testFindActorsByCountry METHOD");
		List<Actor> result = actorService.findActorsByCountry("США");
		assertEquals(7, result.size());
	}
	
	@Test
	public void testFindActorsByDetails() {
		System.out.println("INTO testFindActorsByDetails METHOD");
		List<Actor> result = actorService.findActorsByDetails("М", "мужчина");
		assertEquals(4, result.size());
	}
	
	@Test
	public void testFindActorsByDateAndFilmGenre() {
		System.out.println("INTO testFindActorsByDate METHOD");
		List<Actor> result = actorService.findActorsByDateAndFilmGenre(new Date((new GregorianCalendar(1981,5,13)).getTime().getTime()), "драма");
		assertEquals(1,result.size());
	}

	@After
	public void closeContext() {
		ctx.close();
	}
}
