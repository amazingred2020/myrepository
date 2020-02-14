package my.project.one.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import my.project.one.entity.Producer;

@Service("producerService")
@Repository
@Transactional
public class ProducerDaoImpl implements ProducerDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Producer save(Producer producer) {
		if (producer.getId() == null) {
			System.out.println("Inserting new producer");
			em.persist(producer);
		} else {
			System.out.println("Updating existing producer");
			em.merge(producer);
		}
		System.out.println("Film saved with id: "+ producer.getId());
			
		return producer;	
	}

	@Override
	public List<Producer> findAllWithFilms() {
		TypedQuery<Producer> query = em.createQuery("select p from Producer p left join fetch p.films f",Producer.class);
		
		return query.getResultList();
	}

	@Override
	public Producer findById(Long id) {
		TypedQuery<Producer> query = em.createQuery("select p from Producer p where p.id = :id",Producer.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public List<Producer> findProducersByCountry(String country) {
		TypedQuery<Producer> query = em.createQuery("select p from Producer p where p.residenceCountry = :country", Producer.class);
		query.setParameter("country",country);
		
		return query.getResultList();
	}
}
