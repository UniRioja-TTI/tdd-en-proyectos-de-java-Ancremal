package com.tt1.test;

public class MailerStub implements IMailerStub{
	
	@Override
	public boolean enviarCorreo(String destino, String mensaje) { 
		System.out.println("destino: "+ destino);
		System.out.println("mensaje" + mensaje);
		return true;
	}
}
