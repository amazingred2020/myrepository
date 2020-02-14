package my.project.one.services;

import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import my.project.one.entity.Actor;

@Service("actorService")
@Repository
@Transactional
public class ActorDaoImpl implements ActorDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Actor save(Actor actor) {
		if (actor.getId() == null) {
			System.out.println("Inserting new actor");
			em.persist(actor);
		} else {
			System.out.println("Updating existing actor");
			em.merge(actor);
		}
		System.out.println("Actor saved with id: "+ actor.getId());
			
		return actor;	
	}

	@Override
	public void delete(Actor actor) {
		Actor mergedActor = em.merge(actor);
		em.remove(mergedActor);
		System.out.println("Actor with id: " + actor.getId() + " deleted successfully");
	}

	@Override
	public Actor findById(Long id) {
		TypedQuery<Actor> query = em.createQuery("select a from Actor a where a.id = :id",Actor.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
	
	@Override
	public List<Actor> findAll() {
		TypedQuery<Actor> query = em.createQuery("select a from Actor a",Actor.class);
		
		return query.getResultList();
	}
	
	@Override
	public List<Actor> findActorsByFilmId(Long id) {
		TypedQuery<Actor> query = em.createQuery("select a from Actor a join a.films f where f.id = :id",Actor.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
	@Override
	public List<Actor> findActorsByCountry(String country) {
		TypedQuery<Actor> query = em.createQuery("select a from Actor a where a.residenceCountry = :country", Actor.class);
		query.setParameter("country", country);
		
		return query.getResultList();
	}

	@Override
	public List<Actor> findActorsByDetails(String word, String gender) {
		TypedQuery<Actor> query = em.createQuery("select a from Actor a where a.firstName like :word and a.gender = :gender", Actor.class);
		query.setParameter("word", word+"%");
		query.setParameter("gender", gender);
		
		return query.getResultList();
	}

	@Override
	public List<Actor> findActorsByDateAndFilmGenre(Date date, String genre) {
		TypedQuery<Actor> query = em.createQuery("select a from Actor a join a.films f where a.birthDate = :date and f.genre = :genre", Actor.class);
		query.setParameter("date",date,TemporalType.DATE);
		query.setParameter("genre",genre);
		
		return query.getResultList();
	}
}
