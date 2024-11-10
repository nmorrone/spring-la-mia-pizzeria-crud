package is.lessons.spring.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.lessons.spring.pizzeria.model.Pizza;

public interface PizzeRepository extends JpaRepository <Pizza, Integer> {

}
