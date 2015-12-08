package br.com.cdweb.server.services;

import javax.ws.rs.Path;

import br.com.cdweb.persistence.domain.Parametro;

@Path("parametros")
public class ParametroService extends TemplateCRUDService<Parametro>{

	public ParametroService() {
		this(Parametro.class);
	}
	public ParametroService(Class<Parametro> type) {
		super(type);
	}
	
}