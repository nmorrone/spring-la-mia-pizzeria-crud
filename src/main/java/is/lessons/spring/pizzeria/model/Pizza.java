package is.lessons.spring.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "pizze")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomePizza;
	private String descrizione;
	private String linkFoto; 
	private double prezzo;
	
	
	
	
	//getters setters methods
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePizza() {
		return nomePizza;
	}
	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nomePizza=" + nomePizza + ", descrizione=" + descrizione + ", linkFoto="
				+ linkFoto + ", prezzo=" + prezzo + "]";
	}
	
	
	
	

}
