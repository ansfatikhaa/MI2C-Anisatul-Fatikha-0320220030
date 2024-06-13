package com.astratech.MI2C_Anisatul.Fatikha_0320220030;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String  routingKey = "AnisatulQueue";

    private static final String exchange = "polmanExternalExchange";

    @RequestMapping(value = "/sendMyMessage", method = RequestMethod.POST)
    public DtoResponse kirimPesan(@RequestBody String pesan){
        rabbitTemplate.convertAndSend(exchange, routingKey, pesan);
        return new DtoResponse(200, "Pesan yang anda kirim ke RabbitMQ: " + pesan,"Suskes");
    }

    @RabbitListener(queues = routingKey)
    public void processMessage(String message) {
        System.out.println("Pesan dari RabbitMQ: " + message);
    }



}
