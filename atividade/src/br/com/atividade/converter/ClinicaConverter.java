package br.com.atividade.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.atividade.dao.ClinicaDAO;
import br.com.atividade.dao.ClinicaDAOImpl;
import br.com.atividade.domain.Clinica;


public class ClinicaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long id = Long.parseLong(valor);
			ClinicaDAO clinicaDAO = new ClinicaDAOImpl();
			Clinica clinica = clinicaDAO.pesquisaPorId(Clinica.class, id);
			return clinica;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Clinica clinica = (Clinica) objeto;
			Long codigo = clinica.getId();
			return codigo.toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}

}
