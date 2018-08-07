package fr.imie.recipemanager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Note implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private float note;
	
	@ManyToOne
	@JoinColumn (name ="Utilisateur_fk")
	private Utilisateur utilisateurNote;
	
	public Utilisateur getUtilisateurNote() {
		return utilisateurNote;
	}

	public void setUtilisateurNote(Utilisateur utilisateurNote) {
		this.utilisateurNote = utilisateurNote;
	}

	public Recette getRecetteNote() {
		return recetteNote;
	}

	public void setRecetteNote(Recette recetteNote) {
		this.recetteNote = recetteNote;
	}

	@ManyToOne
	@JoinColumn (name ="Recette_fk")
	private Recette recetteNote;
	
	public Note() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}
}
