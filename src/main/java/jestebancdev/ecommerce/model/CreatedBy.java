package jestebancdev.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Juan Esteban Castaño Holguin
 * castanoesteban9@gmail.com
 * 2022-06-04
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CreatedBy {
	@Id
	private String _id;
	private String role;
	private String name;
}
