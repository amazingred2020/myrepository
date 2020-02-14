package my.project.one.services;

import java.util.Date;
import java.util.List;

import my.project.one.entity.Actor;
import my.project.one.entity.Film;

public interface ActorDao {
	Actor save(Actor actor);
	void delete(Actor actor);
	Actor findById(Long id);
	List<Actor> findAll();
	List<Actor> findActorsByFilmId(Long id);
	List<Actor> findActorsByCountry(String country);
	List<Actor> findActorsByDetails(String word, String gender);
	List<Actor> findActorsByDateAndFilmGenre(Date date, String genre);
}
