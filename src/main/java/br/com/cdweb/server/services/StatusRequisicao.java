package br.com.cdweb.server.services;

public class StatusRequisicao {
	private static String DESC_ERRO = "Requisição nula ou com erros.";
	public enum Status {OK,ERRO;};
	public Status status;
	public String descricao;
	
	public StatusRequisicao() {	
		this.status = Status.ERRO;
		this.descricao = DESC_ERRO;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setStatusOK() {
		this.status = Status.OK;
		this.descricao = "";
	}	
}
