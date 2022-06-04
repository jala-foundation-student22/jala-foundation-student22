/**
 * 
 */
package jestebancdev.ecommerce.controller;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jestebancdev.ecommerce.model.Response;
import jestebancdev.ecommerce.model.Root;
import lombok.RequiredArgsConstructor;

/**
 * @author Juan Esteban Castaño Holguin
 * castanoesteban9@gmail.com
 * 2022-06-04
 */
@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreApi {
	
	@GetMapping
	public  ResponseEntity<Response> getProducts() {
		String url="https://api.storerestapi.com/products";
		RestTemplate restTemplate=new RestTemplate();
		try {
			return ResponseEntity
					.ok(Response.builder().timeStamp(Instant.now()).data(Map.of("api",restTemplate.getForEntity(url, Root.class).getBody()))
							.message("list store").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());
		} catch (Exception e) {
			return ResponseEntity
					.ok(Response.builder().timeStamp(Instant.now())
							.message("Server api down more information:"+e.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build());
		}
	}

}
