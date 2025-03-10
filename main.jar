package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class IpController {

    @GetMapping("/")
    public String getIpAndTime() {
        String publicIp = getPublicIp();
        String currentTime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date());
        return "<html><body><h1>IP Publique: " + publicIp + "</h1><h2>Heure actuelle: " + currentTime + "</h2></body></html>";
    }

    private String getPublicIp() {
        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            return in.readLine();  // Lit l'IP publique depuis le service
        } catch (Exception e) {
            e.printStackTrace();
            return "IP non trouvée";
        }
    }
}
