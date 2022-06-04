/**
 * 
 */
package jestebancdev.ecommerce.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import org.springframework.format.annotation.DateTimeFormat;

import jestebancdev.ecommerce.enumerator.Status;
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
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOrder;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private Date date;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn()
	private Collection<Product> product= new ArrayList<>();
	private Status status;

}
