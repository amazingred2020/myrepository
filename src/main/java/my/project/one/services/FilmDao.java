package my.project.one.services;

import java.util.Date;
import java.util.List;

import my.project.one.entity.Film;

public interface FilmDao {
	Film save(Film film);
	List<Film> findAll();
	List<String> findByReleaseDates(Date one, Date two);
	List<Film> findByMoneyAndCountry(long money, String country);
	List<Film> findByProducerAndActorsDetail(String name, String name2);
}
