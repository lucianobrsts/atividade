package br.com.atividade.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;

@ManagedBean
public class MenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String clinicaPesquisa() {
		return "clinicaPesquisa";
	}

	public String leitoInternacaoPesquisa() {
		return "leitoInternacaoPesquisa";
	}

	public String leitoPesquisa() {
		return "leitoPesquisa";
	}

	public String pacientePesquisa() {
		return "pacientePesquisa";
	}

	public String relatorio() {
		return "relatorio";
	}

	public String sobre() {
		return "sobre";
	}

	public String paginaPrincipal() {
		return "paginaPrincipal";
	}

}
