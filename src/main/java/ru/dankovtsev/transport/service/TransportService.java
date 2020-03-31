package ru.dankovtsev.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dankovtsev.transport.client.TransportClientForArduino;
import ru.dankovtsev.transport.model.Transport;

@Service
public class TransportService {

    @Autowired
    private TransportClientForArduino transportClientForArduino;

    public Transport onlineSystem(){
        Transport transport = transportClientForArduino.onlineTransport();
        return transport;
    }
}
