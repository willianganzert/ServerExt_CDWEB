package br.com.cdweb.server.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cdweb.persistence.domain.Dispositivo;
import br.com.cdweb.persistence.domain.ModeloAcao;
import br.com.cdweb.persistence.domain.ModeloParametro;
import br.com.cdweb.persistence.domain.Parametro;
import br.com.cdweb.persistence.jpa.JpaAllEntities;
import br.com.cdweb.persistence.vo.FieldValuesVo;
import br.com.cdweb.persistence.vo.ResultFilterVo;

@Path("modelosacao")
public class ModeloAcaoService extends TemplateCRUDService<ModeloAcao>{

	public ModeloAcaoService() {
		this(ModeloAcao.class);
	}
	public ModeloAcaoService(Class<ModeloAcao> type) {
		super(type);
	}
	
	@GET
	@Path("/{id}/parametros")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parametro> buscarParametrosPossiveis(@PathParam("id") long id) {
		ModeloAcao modeloAcao = JpaAllEntities.findById(id, ModeloAcao.class);
		if(modeloAcao != null){
			ResultFilterVo<Parametro> resultFilterVo = JpaAllEntities.doFilter(null, null, Parametro.class, new FieldValuesVo("dispositivo", modeloAcao.getModeloDispositivo().getDispositivo()));
			return resultFilterVo.getResultQuery();
		}		
		return null;
    }
	
	@GET
	@Path("/{id}/modelosparametro")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModeloParametro> buscarModelosDeParametroCadastrados(@PathParam("id") long id) {
		ModeloAcao modeloAcao = JpaAllEntities.findById(id, ModeloAcao.class);
		if(modeloAcao != null){
			ResultFilterVo<ModeloParametro> resultFilterVo = JpaAllEntities.doFilter(null, null, ModeloParametro.class, new FieldValuesVo("modeloAcao", modeloAcao));
			return resultFilterVo.getResultQuery();
		}	
		return null;
    }
}