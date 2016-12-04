package com.zocrosfera.ratingmascotas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by rafaelocrin on 23/11/16.
 */

public class SendMessage {

    public static void sendMsg(String email, String mensaje) {
        String  to, subject = null, from = null,
                cc = null, bcc = null, url = null;
        String mailhost = null;
        String mailer = "msgsend";
        String file = null;
        String protocol = null, host = null, user = null, password = null;
        String record = null;	// name of folder in which to record mail
        boolean debug = false;
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
        int optind;

        try {
	    /*
	     * Initialize the JavaMail Session.
	     */
            to = email;

            Properties props = System.getProperties();
            // XXX - could use Session.getTransport() and Transport.connect()
            // XXX - assume we're using SMTP
            //if (mailhost != null)
                props.put("mail.smtp.host", "rafaelocrin@gmail.com");

            // Get a Session object
            Session session = Session.getInstance(props, null);
            if (debug)
                session.setDebug(true);

	    /*
	     * Construct the message and send it.
	     */
            Message msg = new MimeMessage(session);
            if (from != null)
                msg.setFrom(new InternetAddress(from));
            else
                msg.setFrom();


            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            if (cc != null)
                msg.setRecipients(Message.RecipientType.CC,
                        InternetAddress.parse(cc, false));
            if (bcc != null)
                msg.setRecipients(Message.RecipientType.BCC,
                        InternetAddress.parse(bcc, false));

            msg.setSubject(subject);

            String text = mensaje;
            //String text = collect(in);

            if (file != null) {
                // Attach the specified file.
                // We need a multipart message to hold the attachment.
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(text);
                MimeBodyPart mbp2 = new MimeBodyPart();
                mbp2.attachFile(file);
                MimeMultipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);
                msg.setContent(mp);
            } else {
                // If the desired charset is known, you can use
                // setText(text, charset)
                msg.setText(text);
            }

            msg.setHeader("X-Mailer", mailer);
            msg.setSentDate(new Date());

            // send the thing off
            Transport.send(msg);

            System.out.println("\nMail was sent successfully.");

	    /*
	     * Save a copy of the message, if requested.
	     */
            if (record != null) {
                // Get a Store object
                Store store = null;
                if (url != null) {
                    URLName urln = new URLName(url);
                    store = session.getStore(urln);
                    store.connect();
                } else {
                    if (protocol != null)
                        store = session.getStore(protocol);
                    else
                        store = session.getStore();

                    // Connect
                    if (host != null || user != null || password != null)
                        store.connect(host, user, password);
                    else
                        store.connect();
                }

                // Get record Folder.  Create if it does not exist.
                Folder folder = store.getFolder(record);
                if (folder == null) {
                    System.err.println("Can't get record folder.");
                    System.exit(1);
                }
                if (!folder.exists())
                    folder.create(Folder.HOLDS_MESSAGES);

                Message[] msgs = new Message[1];
                msgs[0] = msg;
                folder.appendMessages(msgs);

                System.out.println("Mail was recorded successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Read the body of the message until EOF.
     */
    public static String collect(BufferedReader in) throws IOException {
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = in.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }
}
