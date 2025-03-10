import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleJavaWebServer {
    public static void main(String[] args) throws Exception {
        // Créer un serveur HTTP qui écoute sur le port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Créer un contexte pour la route "/"
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Contenu de la page HTML que le serveur enverra au client
                String response = "<html><body>" +
                        "<h1>Bienvenue sur mon site Web Java !</h1>" +
                        "<p>Ceci est un test de déploiement de page en Java.</p>" +
                        "<p>Ce texte est généré directement par le serveur Java, pas par un fichier HTML externe.</p>" +
                        "</body></html>";

                // Définir le code de réponse HTTP et envoyer la page HTML générée
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        });

        // Démarrer le serveur
        System.out.println("Serveur démarré sur http://localhost:8080");
        server.start();
    }
}
