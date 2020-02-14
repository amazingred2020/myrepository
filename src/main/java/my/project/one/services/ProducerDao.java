package my.project.one.services;

import java.util.List;

import my.project.one.entity.Producer;

public interface ProducerDao {
	Producer save(Producer producer);
	List<Producer> findAllWithFilms();
	Producer findById(Long id);
	List<Producer> findProducersByCountry(String country);	
}
