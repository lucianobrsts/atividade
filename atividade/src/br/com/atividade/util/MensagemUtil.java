package br.com.atividade.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static void adicionarMensagemInfo(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public static void adiconarMensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
