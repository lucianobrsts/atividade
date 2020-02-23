package br.com.atividade.bean;

import java.util.List;

import javax.annotation.ManagedBean;

import br.com.atividade.dao.LeitoDAO;
import br.com.atividade.dao.LeitoDAOImpl;
import br.com.atividade.domain.Leito;
import br.com.atividade.util.FacesUtil;

@ManagedBean
public class LeitoBean {

	private Leito leitoCadastro;
	private List<Leito> listaLeitos;
	private List<Leito> listaLeitosFiltrados;

	public LeitoBean() {
		carregarPesquisa();
	}

	public void novo() {
		leitoCadastro = new Leito();
	}

	public void salvar() {
		try {
			LeitoDAO leitoDAO = new LeitoDAOImpl();
			leitoDAO.salvar(leitoCadastro);

			FacesUtil.adicionarMensagemInfo("Leito salvo com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um paciente.");
		}
	}

	public boolean fecharModalPanel() {
		if (leitoCadastro.getDescricao() != null) {
			return true;
		} else {
			return false;
		}
	}

	public void carregarPesquisa() {
		try {
			LeitoDAO leitoDAO = new LeitoDAOImpl();
			listaLeitos = leitoDAO.listar(Leito.class);
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os leitos.");
		}
	}

	public Leito getLeitoCadastro() {
		if (leitoCadastro == null) {
			leitoCadastro = new Leito();
		}
		return leitoCadastro;
	}

	public List<Leito> getListaLeitos() {
		return listaLeitos;
	}

	public void setListaLeitos(List<Leito> listaLeitos) {
		this.listaLeitos = listaLeitos;
	}

	public List<Leito> getListaLeitosFiltrados() {
		return listaLeitosFiltrados;
	}

	public void setListaLeitosFiltrados(List<Leito> listaLeitosFiltrados) {
		this.listaLeitosFiltrados = listaLeitosFiltrados;
	}

	public void setLeitoCadastro(Leito leitoCadastro) {
		this.leitoCadastro = leitoCadastro;
	}

}
