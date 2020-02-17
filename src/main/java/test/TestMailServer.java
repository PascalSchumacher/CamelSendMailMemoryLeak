package test;

import com.dumbster.smtp.ServerOptions;
import com.dumbster.smtp.SmtpServerFactory;


public class TestMailServer {

    public static void main(String[] args) throws Exception {
        ServerOptions serverOptions = new ServerOptions();
        serverOptions.port = 1234;
        SmtpServerFactory.startServer(serverOptions);
    }
}
