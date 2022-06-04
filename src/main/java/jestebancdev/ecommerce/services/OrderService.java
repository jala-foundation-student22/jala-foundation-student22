/**
 * 
 */
package jestebancdev.ecommerce.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jestebancdev.ecommerce.model.Orders;
import jestebancdev.ecommerce.model.Product;
import jestebancdev.ecommerce.repository.IOrderRepository;
import jestebancdev.ecommerce.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Esteban Castaño Holguin castanoesteban9@gmail.com 2022-06-04
 */
@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	IProductRepository productRepository;
	@Override
	public Orders createOrder(Orders order) {
		log.info("createOrder");
		return orderRepository.save(order);
	}

	@Override
	public Collection<Orders> getOrderBought() {
		log.info("getOrderBought");
		return orderRepository.findAll();
	}

	@Override
	public Collection<Orders> getOrderByProduct(String product) {
//		log.info("getOrderByProduct");
//		Collection<Product> getProduct= productRepository.getProductByName(product);
//		Orders dataOrders=new Orders();
		
		return orderRepository.getOrderByProduct(product);
	}

	@Override
	public Collection<Orders> getOrderByDate(String startDate, String endDate) {
		log.info("getOrdertByDate");
		try {
			return orderRepository.findByDateBetween(new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
