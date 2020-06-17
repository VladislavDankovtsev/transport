package ru.dankovtsev.transport.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import ru.dankovtsev.transport.model.CheckConnection;
import ru.dankovtsev.transport.model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.transport.service.TransportServiceConfig;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransportServiceConfig transportServiceConfig;

    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public Transport getTransportNow(){
        return transportServiceConfig.getTransport();
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public CheckConnection getAgricultureConnection(){
        CheckConnection checkConnection = new CheckConnection();
        checkConnection.setCheck("work");
        return checkConnection;
    }
}
