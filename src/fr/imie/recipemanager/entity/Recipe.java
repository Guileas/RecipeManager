package fr.imie.recipemanager.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Recipe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn (name ="User_fk")
	private User userRecipe;
	
	@OneToMany (mappedBy="recipePicture")
    private List<Picture> pictures;
	
	@OneToMany (mappedBy="recipeQuantity")
    private List<Quantity> quantitys;

	@OneToMany (mappedBy="recipeMark")
    private List<Mark> marks;

	private String name;
	private String description;
	private Timestamp preparationTime;
	private Timestamp cookingTime;
	private float totalPrice;
	
	public Recipe() {
		
	}
	
	public Recipe(String name, String description, float totalPrice) {
		
		this.name = name;
		this.description = description;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserRecipe() {
		return userRecipe;
	}

	public void setUserRecipe(User userRecipe) {
		this.userRecipe = userRecipe;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<Quantity> getQuantitys() {
		return quantitys;
	}

	public void setQuantitys(List<Quantity> quantitys) {
		this.quantitys = quantitys;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(Timestamp preparationTime) {
		this.preparationTime = preparationTime;
	}

	public Timestamp getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(Timestamp cookingTime) {
		this.cookingTime = cookingTime;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
