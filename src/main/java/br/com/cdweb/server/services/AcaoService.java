package br.com.cdweb.server.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.cdweb.persistence.domain.ModeloAcao;
import br.com.cdweb.persistence.domain.Usuario;
import br.com.cdweb.persistence.jpa.JpaAllEntities;

@Path("acao")
public class AcaoService {

	@POST
	@Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusRequisicao realizarAcao(@PathParam("id") long id, @Context HttpServletRequest req) {
		StatusRequisicao requisicao = new StatusRequisicao();
		ModeloAcao modeloAcao = JpaAllEntities.findById(id, ModeloAcao.class);
		if(modeloAcao != null){
			Usuario usuario = getUsuarioSessao(req);
			
			requisicao.setStatusOK();
		}
				
        return requisicao;
    }

	private Usuario getUsuarioSessao(HttpServletRequest req) {
		return JpaAllEntities.findById(1, Usuario.class);
	}

}