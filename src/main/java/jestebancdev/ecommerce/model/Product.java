package jestebancdev.ecommerce.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Product{
	
	@Id
	private String _id;
	private String title;
	private int price;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn
	private Category category;
	private String description;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn
	private CreatedBy createdBy;
	private Date createdAt;
	private Date updatedAt;
	private String slug;
	private String image;
}
