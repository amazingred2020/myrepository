package my.project.one.run;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import my.project.one.config.AppConfig;
import my.project.one.entity.Actor;
import my.project.one.entity.Film;
import my.project.one.entity.Producer;
import my.project.one.services.ActorDao;
import my.project.one.services.FilmDao;
import my.project.one.services.ProducerDao;

public class OneRunning {
	
	private static ApplicationContext ctx;
	
	public static void main(String ... args) {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("PROJECT ONE");
		ActorDao service = ctx.getBean(ActorDao.class);
		ProducerDao pservice = ctx.getBean(ProducerDao.class);
		Producer actor = new Producer();
		actor.setFirstName("Леонардо");
		actor.setLastName("ДиКаприо");
		actor.setBirthDate(new Date((new GregorianCalendar(1974,10,11)).getTime().getTime()));
		actor.setCountry("США");
		actor.setGender("мужчина");
		pservice.save(actor);
		
		List<Actor> actors = service.findAll();
		printActors(actors);
	}
	
	public static void printActors(List<Actor> actors) {
		System.out.println("---- Listing actors:");
		for (Actor actor : actors) 
			System.out.println("\t" + actor.toString());
	}
}
