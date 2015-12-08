package br.com.cdweb.server.services;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceContext;


@Path("config")
public class Configuration {
	@Resource
	WebServiceContext wsContext;
	@Context 
	private HttpServletRequest hsr;
	
	@Context
	String ip;
/**/
//	@GET
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public String getIP() {
//		Configuracoes configuracoes = null;
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdwebPersistenceUnit");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
//		try {
//			configuracoes = manager
//					.getReference(Configuracoes.class, "IP_RASP");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return configuracoes != null ? configuracoes.getValor() : "";
//	}
//
//	@POST
//	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
//	public boolean setIP() {
//		String ipRequisicao = getIPRequisicao();
//		boolean inserido = false;
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("cdwebPersistenceUnit");
//		EntityManager manager = factory.createEntityManager();
//		 EntityTransaction tx = manager.getTransaction();
//		 tx.begin();
//		Configuracoes configuration = new Configuracoes();
//		configuration.setChave("IP_RASP");
//		configuration.setValor(ipRequisicao);
//		
//		Configuracoes configuracoes = manager.find(
//				Configuracoes.class, "IP_RASP");
//		if(configuracoes != null){
//			manager.merge(configuration);
//		}
//		else {
//			manager.persist(configuration);
//		}
//		
//		inserido = true;
//		 tx.commit();
//		return inserido;
//	}

	private String getIPRequisicao() {
		return hsr.getRemoteHost();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getIp(@Context HttpServletRequest req) {
		String remoteHost = req.getRemoteHost();
		String remoteAddr = req.getRemoteAddr();
		int remotePort = req.getRemotePort();
		String msg = remoteHost + " (" + remoteAddr + ":" + remotePort + ")";
		return Response.ok(msg).build();
	}

	// @POST
	// @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	// public boolean setIP(String ipRecebido) {
	// boolean inserido = false;
	// EntityManagerFactory factory =
	// Persistence.createEntityManagerFactory("cdwebPersistenceUnit");
	// EntityManager manager = factory.createEntityManager();
	// EntityTransaction tx = manager.getTransaction();
	// tx.begin();
	// try {
	// Configuracoes configuration = new Configuracoes();
	// configuration.setChave("IP_RASP");
	// configuration.setValor(ipRecebido);
	// if(manager.getReference(Configuracoes.class, "IP_RASP") != null){
	// manager.merge(configuration);
	// }
	// else {
	// manager.persist(configuration);
	// }
	//
	// inserido = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// tx.commit();
	// return inserido;
	// }

}