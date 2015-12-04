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

import br.com.cdweb.persistence.domain.Usuario;
import br.com.cdweb.persistence.jpa.JpaAllEntities;
import br.com.cdweb.persistence.type.OrderType;
import br.com.cdweb.persistence.util.UtlEntity;

@Path("users")
public class UserService {

 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAllUsersInJSON() {
    	List<Usuario> users = JpaAllEntities.listAll(null, null, Usuario.class, OrderType.ASC, UtlEntity.getIdFieldName(Usuario.class)); 
        return users;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUserById(@PathParam("id") long id) {
        return JpaAllEntities.findById(id,Usuario.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario create(Usuario user) {
        JpaAllEntities.insert(user);
        return user;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario update(Usuario user) {
        JpaAllEntities.update(user);
        return user;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
    	Usuario user = JpaAllEntities.findById(id,Usuario.class);
    	if(user != null){
    		JpaAllEntities.delete(user);
    	}    	
    }
}