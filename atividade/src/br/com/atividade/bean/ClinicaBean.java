package br.com.atividade.bean;

import java.util.List;

import br.com.atividade.domain.Clinica;

public class ClinicaBean {

	private Clinica clinicaCadastro;
	private List<Clinica> listaClinicas;
	private List<Clinica> listaClinicasFiltradas;
	
	public void novo() {
		clinicaCadastro = new Clinica();
	}
	
	public void salvar() {
		
	}
	
	public boolean fecharModalPanel() {
		return false;
	}
	
	public void carregarPesquisa() {
		
	}
	
	public Clinica getClinicaCadastro() {
		return clinicaCadastro;
	}

	public void setClinicaCadastro(Clinica clinicaCadastro) {
		this.clinicaCadastro = clinicaCadastro;
	}

	public List<Clinica> getListaClinicas() {
		return listaClinicas;
	}

	public void setListaClinicas(List<Clinica> listaClinicas) {
		this.listaClinicas = listaClinicas;
	}

	public List<Clinica> getListaClinicasFiltradas() {
		return listaClinicasFiltradas;
	}

	public void setListaClinicasFiltradas(List<Clinica> listaClinicasFiltradas) {
		this.listaClinicasFiltradas = listaClinicasFiltradas;
	}

}
