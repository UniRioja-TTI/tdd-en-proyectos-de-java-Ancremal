package com.tt1.test;
/**
 * 
 * Interfaz que implementan las clases MailerStub y MailerStubFake
 *
 */
public interface IMailerStub {
	public boolean enviarCorreo(String destino, String mensaje);
}
