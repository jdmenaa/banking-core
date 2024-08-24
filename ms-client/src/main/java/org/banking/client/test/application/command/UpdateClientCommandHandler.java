package org.banking.client.test.application.command;

import io.jkratz.mediator.core.RequestHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.client.test.domain.entities.ClientDto;
import org.banking.client.test.domain.port.IClientRepository;
import org.banking.client.test.infraestructure.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class UpdateClientCommandHandler implements RequestHandler<UpdateClientCommand, Boolean> {

    private final IClientRepository repository;

    @Override
    @Transactional
    public Boolean handle(UpdateClientCommand command) {
        log.info("Method update client");
        ClientDto clientDto = repository.findById(command.getId());
        if(clientDto == null){
            log.info("client query not found....");
            throw new NotFoundException("Client query not found.");
        }
        clientDto.setPassword(command.getPassword());
        clientDto.setStatus(command.getStatus());
        clientDto.setAge(command.getAge());
        clientDto.setGender(command.getGender());
        clientDto.setAddress(command.getAddress());
        clientDto.setName(command.getName());
        clientDto.setIdentification(command.getIdentification());
        clientDto.setPhone(command.getPhone());
        repository.saveOrUpdate(clientDto);
        return Boolean.TRUE;
    }

}
