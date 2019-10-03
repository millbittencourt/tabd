package tabd.Models;

import java.util.List;

public class Artigo {

	private int id;
	private String titulo;
	private String resumo;
	private int pdf;

	public List<Participante> autores; 
	public List<Revisao> revisoes; 
	
	public Artigo(int id, String titulo, String resumo, int pdf) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.pdf = pdf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public int getPdf() {
		return pdf;
	}

	public void setPdf(int pdf) {
		this.pdf = pdf;
	}

}
