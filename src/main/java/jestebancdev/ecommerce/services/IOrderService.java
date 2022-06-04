/**
 * 
 */
package jestebancdev.ecommerce.services;

import java.util.Collection;

import jestebancdev.ecommerce.model.Orders;

/**
 * @author Juan Esteban Castaño Holguin
 * castanoesteban9@gmail.com
 * 2022-06-04
 */
public interface IOrderService {
	
	Orders createOrder(Orders order);

	Collection<Orders> getOrderBought();
	
	Collection<Orders> getOrderByProduct(String product);
	
	Collection<Orders> getOrderByDate(String startDate,String endDate);
	
}
