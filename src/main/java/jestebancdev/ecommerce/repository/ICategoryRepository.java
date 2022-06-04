package jestebancdev.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jestebancdev.ecommerce.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, String> {

}
