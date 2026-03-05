package com.tt1.test;

public class MailerStubFake implements IMailerStub{

	private String ultdest;
	private String ultmen;
	private int numllamado=0;
	
	
	@Override
	public boolean enviarCorreo(String destino, String mensaje) {
		this.ultdest=destino;
		this.ultmen=mensaje;
		this.numllamado++;
		return true; 
		
	}
	
	public String getUltimoDestino() {
		return this.ultdest;
	}
	
	public String getUltimoMensaje() {
		return this.ultdest;
	}
	
	public int getVecesLlamado() {
		return this.numllamado;
	}
}
