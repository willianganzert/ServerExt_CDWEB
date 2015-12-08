package br.com.cdweb.server.services;

import javax.ws.rs.Path;

import br.com.cdweb.persistence.domain.Area;

@Path("areas")
public class AreaService extends TemplateCRUDService<Area>{

	public AreaService() {
		this(Area.class);
	}
	public AreaService(Class<Area> type) {
		super(type);
	}
	
}