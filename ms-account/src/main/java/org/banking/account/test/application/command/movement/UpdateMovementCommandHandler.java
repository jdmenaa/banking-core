package org.banking.account.test.application.command.movement;

import io.jkratz.mediator.core.RequestHandler;
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
public class UpdateMovementCommandHandler implements RequestHandler<UpdateMovementCommand, Boolean> {

    private final IMovementRepository repository;

    @Override
    @Transactional
    public Boolean handle(UpdateMovementCommand command) {
        log.info("Method update movement");
        MovementDto movementDto = repository.findById(command.getId());
        if(movementDto == null){
            log.info("movement query not found....");
            throw new NotFoundException("movement query not found.");
        }
        movementDto.setDateMovement(command.getDateMovement());
        movementDto.setTransactionType(command.getTransactionType());
        movementDto.setValueMovement(command.getValueMovement());
        movementDto.setBalance(command.getBalance());
        movementDto.setAccountId(command.getAccountId());

        repository.saveOrUpdate(movementDto);
        return Boolean.TRUE;
    }

}
