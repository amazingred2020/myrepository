package my.project.one.services;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import my.project.one.entity.Film;

@Service("filmService")
@Repository
@Transactional
public class FilmDaoImpl implements FilmDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Film save(Film film) {
		if (film.getId() == null) {
			System.out.println("Inserting new film");
			em.persist(film);
		} else {
			System.out.println("Updating existing film");
			em.merge(film);
		}
			System.out.println("Film saved with id: "+ film.getId());
			
		return film;
	}

	@Override
	public List<Film> findAll() {
		TypedQuery<Film> query = em.createQuery("select f from Film f",Film.class);
		
		return query.getResultList();
	}

	@Override
	public List<String> findByReleaseDates(Date one, Date two) {
		Query query = em.createQuery("select f.name from Film f where f.releaseDate between :dateOne and :dateTwo");
		query.setParameter("dateOne",one,TemporalType.DATE);
		query.setParameter("dateTwo",two,TemporalType.DATE);
		
		return query.getResultList();
	}

	@Override
	public List<Film> findByMoneyAndCountry(long money, String country) {
		TypedQuery<Film> query = em.createQuery("select f from Film f where f.worldwideFees > :money and f.country = :country",Film.class);
		query.setParameter("money",money);
		query.setParameter("country",country);
		
		return query.getResultList();
	}

	@Override
	public List<Film> findByProducerAndActorsDetail(String name, String name2) {
		TypedQuery<Film> query = em.createQuery("select f from Film f join f.producer p join f.actors a where p.firstName = :name and a.firstName = :name2",Film.class);
		query.setParameter("name",name);
		query.setParameter("name2",name2);
		
		return query.getResultList();
	}
}
