package org.banking.client.test.application.command;


import io.jkratz.mediator.core.CommandHandler;
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
public class DeleteClientCommandHandler implements CommandHandler<DeleteClientCommand> {

    private final IClientRepository repository;

    @Override
    @Transactional
    public void handle(DeleteClientCommand deleteClientCommand) {
        log.info("Method delete client");
        ClientDto clientDto = repository.findById(deleteClientCommand.getId());
        if(clientDto == null){
            log.info("client query not found....");
            throw new NotFoundException("Client query not found.");
        }
        repository.deleteById(deleteClientCommand.getId());
    }
}
