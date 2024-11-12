import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import javax.net.ssl.*;

public class MailSent {
    private static DataOutputStream dos ;
    public static BufferedReader br ;
    public static void main(String[] args) throws Exception {
        String user = "s2011176142@ru.ac.bd" ;
        String pass = "nasirru@42" ;

        String username = new String(Base64.getEncoder().encode(user.getBytes())) ;
        String password = new String(Base64.getEncoder().encode(pass.getBytes())) ;
        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465) ;
        dos = new DataOutputStream(socket.getOutputStream()) ;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;

        sent("EHLO smtp.gmail.com \r\n") ;
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());
           System.out.println("SERVER: "+ br.readLine());

        sent("AUTH LOGIN\r\n");
           System.out.println("SERVER: "+ br.readLine());
        
        sent(username + "\r\n") ;
           System.out.println("SERVER: "+ br.readLine());
        
        sent(password + "\r\n") ;
           System.out.println("SERVER: "+ br.readLine());
        
        sent("MAIL FROM: <s2011176142@ru.ac.bd>\r\n");
           System.out.println("SERVER: "+ br.readLine());

        sent("RCPT TO: <asif@ru.ac.bd> \r\n");

        sent("DATA\r\n");
           System.out.println("SERVER: "+ br.readLine());

        sent("FROM: s2011176142@ru.ac.bd\r\n");
        sent("TO: asif@ru.ac.bd\r\n"); 
        sent("Subject: 2011176142\r\n");
        sent("This is a lab test\r\n");
        sent(".\r\n");
           System.out.println("SERVER: "+ br.readLine());

        sent("QUIT\r\n");
           System.out.println("SERVER: "+ br.readLine());
    }

    private static void sent(String s) throws Exception {
        dos.writeBytes(s);
        Thread.sleep(1000);
        System.out.println("Client: " + s);
    }
}
