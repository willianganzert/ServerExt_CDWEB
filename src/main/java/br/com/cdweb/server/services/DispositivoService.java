package br.com.cdweb.server.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cdweb.persistence.domain.Dispositivo;
import br.com.cdweb.persistence.domain.Parametro;
import br.com.cdweb.persistence.jpa.JpaAllEntities;
import br.com.cdweb.persistence.vo.FieldValuesVo;
import br.com.cdweb.persistence.vo.ResultFilterVo;

@Path("dispositivos")
public class DispositivoService extends TemplateCRUDService<Dispositivo>{

	public DispositivoService() {
		this(Dispositivo.class);
	}
	public DispositivoService(Class<Dispositivo> type) {
		super(type);
	}
	
	@GET
	@Path("/{id}/parametros")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parametro> buscarParametrosDispositivo(@PathParam("id") long id) {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setIdDispositivo(id);
		ResultFilterVo<Parametro> resultFilterVo = JpaAllEntities.doFilter(null, null, Parametro.class, new FieldValuesVo("dispositivo", dispositivo));
		return resultFilterVo.getResultQuery();
    }

}