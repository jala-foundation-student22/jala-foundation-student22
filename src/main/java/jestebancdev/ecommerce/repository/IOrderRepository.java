/**
 * 
 */
package jestebancdev.ecommerce.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jestebancdev.ecommerce.model.Orders;

/**
 * @author Juan Esteban Castaño Holguin castanoesteban9@gmail.com 2022-06-04
 */
public interface IOrderRepository extends JpaRepository<Orders, Long> {

	@Query(value = "SELECT * FROM orders ord "
			+ "LEFT JOIN orders_product as ord_pro on ord.id_order=ord_pro.orders_id_order "
			+ "LEFT  JOIN product as produ on produ._id=ord_pro.product__id "
			+ "WHERE produ.title = 'productName'", nativeQuery = true)
	public Collection<Orders> getOrderByProduct(@Param("productName") String product);

	public Collection<Orders> findByDateBetween(Date startDate, Date endDate);
}
