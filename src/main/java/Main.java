import com.cczywyc.fileserver.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class
 *
 * @author wangyc
 */
public class Main {

    /** http server */
    private HttpServer server;
    /** log object */
    private Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        logger.info("File server is starting......");
        try {
            // server port
            String serverPort = System.getProperty("serverPort", "8089");
            int port = Integer.parseInt(serverPort);
            server = new HttpServer(port);
            server.run();
        } catch (InterruptedException e) {
            logger.error(null, e);
        } finally {
            if (server != null) {
                server.close();
            }
        }
    }
}
