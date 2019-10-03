package tabd.Models;

import java.sql.Date;

public class Cartao {

	private String numero;
	private Date dataVencimento;
	private String marca;
	private Participante participante;

	public Cartao(String numero, Date dataVencimento, String marca, Participante participante) {
		super();
		this.numero = numero;
		this.dataVencimento = dataVencimento;
		this.marca = marca;
		this.participante = participante;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
