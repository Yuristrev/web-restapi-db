package ps2.restapidb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="discplinas")
public class Disciplina {

	@Id @GeneratedValue
	private long id;
	
	private String nome;
	private double nota;
	private int numAulas;

	@ManyToOne(optional=false)
	private Faculdade faculdade;
		
	public Disciplina() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int numAulas(){
		return numAulas;
	}
	public void setNumAulas (int numAulas){
		this.numAulas= numAulas;
	}

}