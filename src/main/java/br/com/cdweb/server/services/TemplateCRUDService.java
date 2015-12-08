package br.com.cdweb.server.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cdweb.persistence.domain.ComunEntidades;
import br.com.cdweb.persistence.jpa.JpaAllEntities;
import br.com.cdweb.persistence.type.OrderType;
import br.com.cdweb.persistence.util.UtlEntity;

public class TemplateCRUDService<T extends ComunEntidades> {
	private final Class<T> type;

    public TemplateCRUDService(Class<T> type) {
         this.type = type;
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> buscarTodos() {
    	return JpaAllEntities.listAll(null, null, type, OrderType.ASC, UtlEntity.getIdFieldName(type));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T buscarId(@PathParam("id") long id) {
        return JpaAllEntities.findById(id,type);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public T criar(T object) {
        JpaAllEntities.insert(object);
        return object;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public T atualizar(T object) {
        JpaAllEntities.update(object);
        return object;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remover(@PathParam("id") long id) {
    	JpaAllEntities.delete(id,type);    	
    }

}
