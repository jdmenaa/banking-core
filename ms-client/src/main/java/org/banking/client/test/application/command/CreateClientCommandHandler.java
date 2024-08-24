package org.banking.client.test.application.command;

import io.jkratz.mediator.core.RequestHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.client.test.domain.entities.ClientDto;
import org.banking.client.test.domain.port.IClientRepository;
import org.banking.client.test.domain.producer.ClientProducerDto;
import org.banking.client.test.infraestructure.config.RabbitMQConfig;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Slf4j
@EnableRabbit
public class CreateClientCommandHandler implements RequestHandler<CreateClientCommand, Boolean> {

    private final IClientRepository repository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Override
    @Transactional
    public Boolean handle(CreateClientCommand command) {
        log.info("Method save client");
        ClientProducerDto producerDto = null;
        ClientDto clientDto = new ClientDto();
        clientDto.setPassword(command.getPassword());
        clientDto.setStatus(Boolean.TRUE);
        clientDto.setAge(command.getAge());
        clientDto.setGender(command.getGender());
        clientDto.setAddress(command.getAddress());
        clientDto.setName(command.getName());
        clientDto.setIdentification(command.getIdentification());
        clientDto.setPhone(command.getPhone());
        Long clientId = repository.saveOrUpdate(clientDto);

        //RabbitMQ producer
        producerDto = new ClientProducerDto();
        producerDto.setClientId(clientId);
        producerDto.setIdentification(clientDto.getIdentification());
        producerDto.setName(clientDto.getName());

        // Enviar mensaje a RabbitMQ
        rabbitTemplate.convertAndSend(queue.getName(), producerDto);

        return Boolean.TRUE;
    }
}
