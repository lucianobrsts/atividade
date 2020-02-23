package br.com.atividade.bean;

import java.util.List;

import javax.annotation.ManagedBean;

import br.com.atividade.dao.LeitoInternacaoDAO;
import br.com.atividade.dao.LeitoInternacaoDAOImpl;
import br.com.atividade.domain.LeitoInternacao;
import br.com.atividade.util.FacesUtil;

@ManagedBean
public class LeitoInternacaoBean {
	private LeitoInternacao internacaoCadastro;
	private List<LeitoInternacao> listaInternacoes;
	private List<LeitoInternacao> listaInternacoesFiltrados;

	public LeitoInternacaoBean() {
		System.out.println("Construtor LeitoInternacaoBean");
		carregarPesquisa();
	}

	public void novo() {
		internacaoCadastro = new LeitoInternacao();
	}

	public void salvar() {
		try {
			LeitoInternacaoDAO internacaoDAO = new LeitoInternacaoDAOImpl();
			internacaoDAO.salvar(internacaoCadastro);

			FacesUtil.adicionarMensagemInfo("Leito Interna��o salvo com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um Leito Interna��o.");
		}
	}

	public boolean fecharModalPanel() {
		if (internacaoCadastro.getId() != null) {
			return true;
		} else {
			return false;
		}
	}

	public void carregarPesquisa() {
		System.out.println("CarregarPesquisa()");
		try {
			LeitoInternacaoDAO internacaoDAO = new LeitoInternacaoDAOImpl();
			listaInternacoes = internacaoDAO.listar(LeitoInternacao.class);
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os leitos Interna��es.");
		}
	}

	public LeitoInternacao getLeitoCadastro() {
		if (internacaoCadastro == null) {
			internacaoCadastro = new LeitoInternacao();
		}
		return internacaoCadastro;
	}

	public LeitoInternacao getInternacaoCadastro() {
		return internacaoCadastro;
	}

	public void setInternacaoCadastro(LeitoInternacao internacaoCadastro) {
		this.internacaoCadastro = internacaoCadastro;
	}

	public List<LeitoInternacao> getListaInternacoes() {
		return listaInternacoes;
	}

	public void setListaInternacoes(List<LeitoInternacao> listaInternacoes) {
		this.listaInternacoes = listaInternacoes;
	}

	public List<LeitoInternacao> getListaInternacoesFiltrados() {
		return listaInternacoesFiltrados;
	}

	public void setListaInternacoesFiltrados(List<LeitoInternacao> listaInternacoesFiltrados) {
		this.listaInternacoesFiltrados = listaInternacoesFiltrados;
	}

}
