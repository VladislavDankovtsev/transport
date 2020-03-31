package ru.dankovtsev.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.dankovtsev.transport.model.Transport;
import ru.dankovtsev.transport.repository.TransportRepository;

@Configuration
@EnableScheduling
public class TransportServiceConfig {
    public static Transport transport;

    @Autowired
    private TransportService transportService;
    @Autowired
    private TransportRepository transportRepository;

    @Scheduled(fixedDelay = 10000)
    public void scheduleFixInformationInBD(){
        try{
            transport= transportService.onlineSystem();
            if(transport!=null){
                transportRepository.save(transport);
            }
            System.out.println("SAVE: "+transport.toString());
        }catch (Exception e){
            System.out.println("нет соединения с arduino");
        }
    }

    public Transport getTransport(){ return transport;}
}
