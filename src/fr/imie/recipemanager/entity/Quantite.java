package fr.imie.recipemanager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quantite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@ManyToOne
	@JoinColumn (name ="Recette_fk")
	private Recette recetteQuantite;
	
	public Recette getRecetteQuantite() {
		return recetteQuantite;
	}

	public void setRecetteQuantite(Recette recetteQuantite) {
		this.recetteQuantite = recetteQuantite;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	@ManyToOne
	@JoinColumn (name ="Ingredient_fk")
	private Ingredient ingredient;
	
	private float quantite;
	private String unite;
	
	public Quantite() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getQuantite() {
		return quantite;
	}
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
}
