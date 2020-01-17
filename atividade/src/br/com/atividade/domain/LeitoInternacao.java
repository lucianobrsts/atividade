package br.com.atividade.domain;

import java.util.Date;

public class LeitoInternacao {

	private Long id;
	private Leito leito;
	private Paciente paciente;
	private Date dataInternacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Leito getLeito() {
		return leito;
	}

	public void setLeito(Leito leito) {
		this.leito = leito;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDataInternacao() {
		return dataInternacao;
	}

	public void setDataInternacao(Date dataInternacao) {
		this.dataInternacao = dataInternacao;
	}

}
