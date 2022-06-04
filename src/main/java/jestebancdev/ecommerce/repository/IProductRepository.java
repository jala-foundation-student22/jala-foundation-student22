/**
 * 
 */
package jestebancdev.ecommerce.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jestebancdev.ecommerce.model.Product;

/**
 * @author Juan Esteban Castaño Holguin
 * castanoesteban9@gmail.com
 * 2022-06-04
 */
 @Repository
public interface IProductRepository extends JpaRepository<Product, String>{
	 
	 @Query(value = "select * from product where title like '%:productName%'",nativeQuery = true)
	 public Collection<Product> getProductByName(String productName);

}
