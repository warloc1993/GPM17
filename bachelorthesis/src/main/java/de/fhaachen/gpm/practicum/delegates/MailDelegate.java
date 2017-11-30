package de.fhaachen.gpm.practicum.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        String recipient = delegateExecution.getVariable("recipient").toString();
        String subject = delegateExecution.getVariable("subject").toString();
        String message = delegateExecution.getVariable("message").toString();


        sendMail(recipient,subject,message);


    }

    public static void sendMail( String recipient,
                                 String subject, String text )
            throws MessagingException
    {

        final String username = "gpm17.grp8@gmail.com";
        final String password = "GPM17Gruppe8";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gpm17.grp8@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

