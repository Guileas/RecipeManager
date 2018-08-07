package fr.imie.recipemanager.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Recette implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	@JoinColumn (name ="Utilisateur_fk")
	private Utilisateur utilisateurRecette;
	
	@OneToMany (mappedBy="recetteImage")
    private List<Image> images;
	
	public Utilisateur getUtilisateurRecette() {
		return utilisateurRecette;
	}

	public void setUtilisateurRecette(Utilisateur utilisateurRecette) {
		this.utilisateurRecette = utilisateurRecette;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Quantite> getQuantites() {
		return quantites;
	}

	public void setQuantites(List<Quantite> quantites) {
		this.quantites = quantites;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@OneToMany (mappedBy="recetteQuantite")
    private List<Quantite> quantites;

	@OneToMany (mappedBy="recetteNote")
    private List<Note> notes;

	private String nom;
	private String description;
	private Time tempsPreparation;
	private Time tempsCuisson;
	private float prixTotal;
	
	public Recette() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(Time tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public Time getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(Time tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}
}
