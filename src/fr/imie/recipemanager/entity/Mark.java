package fr.imie.recipemanager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mark implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private float mark;
	
	@ManyToOne
	@JoinColumn (name ="User_fk")
	private User userMark;
	
	@ManyToOne
	@JoinColumn (name ="Recipe_fk")
	private Recipe recipeMark;
	
	public Mark() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public User getUserMark() {
		return userMark;
	}

	public void setUserMark(User userMark) {
		this.userMark = userMark;
	}

	public Recipe getRecipeMark() {
		return recipeMark;
	}

	public void setRecipeMark(Recipe recipeMark) {
		this.recipeMark = recipeMark;
	}
	

}
