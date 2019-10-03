package tabd.Models;

import java.util.List;

public class Participante {

	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String empresa;
	private boolean revisor;
	private Endereco endereco;

	public List<Artigo> artigos;
	
	public Participante(String nome, String telefone, String email, String empresa, boolean revisor,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.empresa = empresa;
		this.revisor = revisor;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public boolean isRevisor() {
		return revisor;
	}

	public void setRevisor(boolean revisor) {
		this.revisor = revisor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
