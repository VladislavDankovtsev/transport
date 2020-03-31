package ru.dankovtsev.transport.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.transport.model.Transport;
import ru.dankovtsev.transport.uuid.UUIDRandom;

import java.time.LocalDateTime;

import static ru.dankovtsev.transport.other.UrlSmartCityModule.URL_TRANSPORT_ONLINE;

@Service
public class TransportClientForArduino {

    @Autowired
    private UUIDRandom uuidRandom;

    public Transport onlineTransport(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Transport> responseEntity = restTemplate.getForEntity(URL_TRANSPORT_ONLINE,
                Transport.class);
        responseEntity.getBody().setId(uuidRandom.randomkey());
        responseEntity.getBody().setTime(LocalDateTime.now());
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }
}
