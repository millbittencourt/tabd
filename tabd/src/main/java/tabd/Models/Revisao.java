package tabd.Models;

import java.util.List;

public class Revisao {//???

	private int id;
	private Participante revisor;
	// private Artigo artigo;
	private int nota;
	private String comentario;

	public List<Artigo> artigos;

	public Revisao(int id, Participante revisor, Artigo artigo, int nota, String comentario) {
		super();
		this.id = id;
		this.revisor = revisor;
		// this.artigo = artigo;
		this.nota = nota;
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Participante getRevisor() {
		return revisor;
	}

	public void setRevisor(Participante revisor) {
		this.revisor = revisor;
	}

	/*
	 * public Artigo getArtigo() { return artigo; }
	 * 
	 * public void setArtigo(Artigo artigo) { this.artigo = artigo; }
	 */

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
