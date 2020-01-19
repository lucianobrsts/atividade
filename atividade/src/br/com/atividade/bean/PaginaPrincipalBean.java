package br.com.atividade.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;

/**
 * Prova elaborada por Daniel Oliveira, para avalia��o dos candidatos ao projeto
 * Vitae. Fortaleza, 07/01/2020.
 */
@ManagedBean
public class PaginaPrincipalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6791807627637800136L;

	public String paginaMenu() {
		return "pricipalMenu";
	}

}
