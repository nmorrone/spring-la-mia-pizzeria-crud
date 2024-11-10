package is.lessons.spring.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Fritti;

public interface FrittiRepository extends JpaRepository<Fritti, Integer>{

}
