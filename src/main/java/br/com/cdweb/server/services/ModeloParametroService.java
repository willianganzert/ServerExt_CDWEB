package br.com.cdweb.server.services;

import javax.ws.rs.Path;

import br.com.cdweb.persistence.domain.ModeloParametro;

@Path("modelosparametro")
public class ModeloParametroService extends TemplateCRUDService<ModeloParametro>{

	public ModeloParametroService() {
		this(ModeloParametro.class);
	}
	public ModeloParametroService(Class<ModeloParametro> type) {
		super(type);
	}
	
}