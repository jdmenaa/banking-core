package org.banking.account.test.application.command.movement;


import io.jkratz.mediator.core.CommandHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.MovementDto;
import org.banking.account.test.domain.port.IMovementRepository;
import org.banking.account.test.infraestructure.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DeleteMovementCommandHandler implements CommandHandler<DeleteMovementCommand> {

    private final IMovementRepository repository;

    @Override
    @Transactional
    public void handle(DeleteMovementCommand deleteMovementCommand) {
        log.info("Method delete movement");
        MovementDto movementDto = repository.findById(deleteMovementCommand.getId());
        if(movementDto == null){
            log.info("movement query not found....");
            throw new NotFoundException("movement query not found.");
        }
        repository.deleteById(deleteMovementCommand.getId());
    }
}
