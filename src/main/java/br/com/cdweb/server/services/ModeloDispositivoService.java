package br.com.cdweb.server.services;

import javax.ws.rs.Path;

import br.com.cdweb.persistence.domain.ModeloDispositivo;

@Path("modelosdispositivo")
public class ModeloDispositivoService extends TemplateCRUDService<ModeloDispositivo>{

	public ModeloDispositivoService() {
		this(ModeloDispositivo.class);
	}
	public ModeloDispositivoService(Class<ModeloDispositivo> type) {
		super(type);
	}
	
}