package br.gov.fatec.moduloprofessor.config;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailConfig
{
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();
	
	public Session criarSessionMail() {
	     Properties props = new Properties();
	     props.put("mail.smtp.host", "smtp.gmail.com");
	     props.put("mail.smtp.socketFactory.port", 465);
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.auth", true);
	     props.put("mail.smtp.port", 465);
	 
	     Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	 
	            protected PasswordAuthentication getPasswordAuthentication() {
	                   return new PasswordAuthentication("antena.professor", "tanG1ble@34");
	            }
	     });
	     session.setDebug(true);
	     return session;
	}
	
	public void enviarEmail(String email, String nome) throws AddressException, MessagingException {
	      
	     String remetente = "antena.professor@gmail.com";
	     String assunto = "Cadastro de Professor";
	 
	     Message message = new MimeMessage(criarSessionMail());
	     message.setFrom(new InternetAddress(remetente));
	 
	     Address[] toUser = InternetAddress.parse(email.trim().toLowerCase());
	 
	     message.setRecipients(Message.RecipientType.TO, toUser);
	     message.setSubject(assunto);
	     message.setContent("Ola "+nome+", <p>"
	     		+ " Obrigado por se cadastrar.", "text/html");
	     Transport.send(message);
	}
	
	public void enviarEmailComChave(String email) throws AddressException, MessagingException {
	      
	     String remetente = "antena.professor@gmail.com";
	     String assunto = "Chave de Projeto";
	     
	     String chave = generateRandomString(8);
	 
	     Message message = new MimeMessage(criarSessionMail());
	     message.setFrom(new InternetAddress(remetente));
	 
	     Address[] toUser = InternetAddress.parse(email.trim().toLowerCase());
	 
	     message.setRecipients(Message.RecipientType.TO, toUser);
	     message.setSubject(assunto);
	     message.setContent("Ola, <p> Esta a sua chave " + chave , "text/html");
	     Transport.send(message);
	}
	
	 public static String generateRandomString(int length) {
	        if (length < 1) throw new IllegalArgumentException();

	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
				// 0-62 (exclusive), random returns 0-61
	            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
	            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
	            // debug
	            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);
	            sb.append(rndChar);
	        }
	        return sb.toString();
	    }
}