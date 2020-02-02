package br.com.atividade.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;

@ManagedBean
public class MenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String pacientePesquisa() {
		return "pacientePesquisa";
	}
	
	public String relatorio() {
		return "relatorio";
	}
	
	public String sobre() {
		return "sobre";
	}

}
