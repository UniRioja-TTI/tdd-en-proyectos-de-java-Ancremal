package com.tt1.test;
/**
 * Clase que emula el funcionamiento de un servicio de envío de correos electrónicos 
 * asi se puede probar el funcionamiento del proyecto evitando el envio de mensajes real.
 */
public class MailerStub implements IMailerStub{
	
	/**
     * Emula el envío de un mensaje de correo electrónico a una dirección escribiendo el 
     * destino y el mensaje por pantalla.
     * * @param destino Dirección de correo electrónico a la que se enviará el mensaje.
     * @param mensaje Contenido que se desea transmitir.
     * @return true simulando que se ha enviado con exito.
     */
	@Override
	public boolean enviarCorreo(String destino, String mensaje) { 
		System.out.println("destino: "+ destino);
		System.out.println("mensaje" + mensaje);
		return true;
	}
}
