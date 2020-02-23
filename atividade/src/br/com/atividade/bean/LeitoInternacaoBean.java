package br.com.atividade.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.atividade.dao.LeitoInternacaoDAO;
import br.com.atividade.dao.LeitoInternacaoDAOImpl;
import br.com.atividade.domain.LeitoInternacao;
import br.com.atividade.util.FacesUtil;

public class LeitoInternacaoBean {

	private LeitoInternacao leitoInternacaoCadastro;
	private List<LeitoInternacao> listaLeitoInternacoes;
	private List<LeitoInternacao> listaLeitoInternacoesFiltrados;
	private List<SelectItem> selectItemsLeitoInternacao;

	public LeitoInternacaoBean() {
		carregarPesquisa();
	}

	public void novo() {
		leitoInternacaoCadastro = new LeitoInternacao();
	}

	public void salvar() {
		try {
			LeitoInternacaoDAO leitoInternacaoDAO = new LeitoInternacaoDAOImpl();
			leitoInternacaoDAO.salvar(leitoInternacaoCadastro);

			FacesUtil.adicionarMensagemInfo("Leito Internação salvo com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um Leito Internação.");
		}
	}

	public boolean fecharModalPanel() {
		if (leitoInternacaoCadastro.getId() != null) {
			return true;
		} else {
			return false;
		}
	}

	public void carregarPesquisa() {
		try {
			LeitoInternacaoDAO leitoInternacaoDAO = new LeitoInternacaoDAOImpl();
			listaLeitoInternacoes = leitoInternacaoDAO.listar(LeitoInternacao.class);
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os leitos Internações.");
		}
	}

	public LeitoInternacao getLeitoCadastro() {
		if (leitoInternacaoCadastro == null) {
			leitoInternacaoCadastro = new LeitoInternacao();
		}
		return leitoInternacaoCadastro;
	}

	public LeitoInternacao getLeitoInternacaoCadastro() {
		return leitoInternacaoCadastro;
	}

	public void setLeitoInternacaoCadastro(LeitoInternacao leitoInternacaoCadastro) {
		this.leitoInternacaoCadastro = leitoInternacaoCadastro;
	}

	public List<LeitoInternacao> getListaLeitoInternacoes() {
		return listaLeitoInternacoes;
	}

	public void setListaLeitoInternacoes(List<LeitoInternacao> listaLeitoInternacoes) {
		this.listaLeitoInternacoes = listaLeitoInternacoes;
	}

	public List<LeitoInternacao> getListaLeitoInternacoesFiltrados() {
		return listaLeitoInternacoesFiltrados;
	}

	public void setListaLeitoInternacoesFiltrados(List<LeitoInternacao> listaLeitoInternacoesFiltrados) {
		this.listaLeitoInternacoesFiltrados = listaLeitoInternacoesFiltrados;
	}

	public List<SelectItem> getSelectItemsLeitoInternacao() {
		return selectItemsLeitoInternacao;
	}

	public void setSelectItemsLeitoInternacao(List<SelectItem> selectItemsLeitoInternacao) {
		this.selectItemsLeitoInternacao = selectItemsLeitoInternacao;
	}

}
