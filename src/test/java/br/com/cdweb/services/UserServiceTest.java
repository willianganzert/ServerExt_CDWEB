package br.com.cdweb.services;

import org.junit.Assert;
import org.junit.Test;

import br.com.cdweb.persistence.domain.Usuario;
import br.com.cdweb.server.services.UsuarioService;
import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	public static void main(String[] args) {
		new UserServiceTest().testCRUD_ServiceClass();
	}
	UsuarioService service;
	 public UserServiceTest() {
		service = new UsuarioService();
	}
	
	 @Test
    public void testCRUD_ServiceClass() {
        Usuario usuario = new Usuario();
        usuario.setLogin("joaosilva");
        usuario.setNome("Joao Da Silva");
        usuario.setSenha("12345");
        usuario.setTelefone("4199653630");
        long idUsuario = service.criar(usuario).getId();
        
        service.buscarId(idUsuario);
        
        usuario.setTelefone("4444444444");
        service.atualizar(usuario);
        
        Usuario update = service.buscarId(idUsuario);
        
        service.remover((int) idUsuario);
        
        Usuario deleted = service.buscarId(idUsuario);
        
        Assert.assertNull("Usuario nao foi removido", deleted);
        
    }
}
