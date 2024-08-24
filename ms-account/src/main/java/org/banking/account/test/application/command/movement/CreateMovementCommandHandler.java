package org.banking.account.test.application.command.movement;

import io.jkratz.mediator.core.RequestHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.entities.MovementDto;
import org.banking.account.test.domain.port.IAccountRepository;
import org.banking.account.test.domain.port.IMovementRepository;
import org.banking.account.test.infraestructure.exception.InsufficientFundsException;
import org.banking.account.test.infraestructure.exception.NotFoundException;
import org.banking.account.test.infraestructure.utils.TypeMovementEnum;
import org.banking.account.test.infraestructure.utils.UtilDates;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateMovementCommandHandler implements RequestHandler<CreateMovementCommand, Boolean> {

    private final IMovementRepository repository;
    private final IAccountRepository accountRepository;

    @Override
    @Transactional
    public Boolean handle(CreateMovementCommand command) {
        log.info("Method save movement");
        double newBalance = 0.0;
        AccountDto accountDto = null;
        MovementDto movementDto = null;
        accountDto = accountRepository.findByAccountNumber(command.getAccountNumber());
        if(accountDto == null){
            throw new NotFoundException("Account not exist.");
        }
        if(command.getTransactionType().equals(TypeMovementEnum.WITHDRAWAL.getValue())){
            if(accountDto.getInitialBalance() < command.getValueMovement()){
                throw new InsufficientFundsException("Saldo insuficiente para el retiro.");
            }
        }
        //Actualizo saldo cuenta
        newBalance = this.getCalculateBalance(command.getTransactionType(), command.getValueMovement(), accountDto);
        accountDto.setInitialBalance(newBalance);
        accountRepository.saveOrUpdate(accountDto);

        //Registro el movimiento
        movementDto = new MovementDto();
        movementDto.setDateMovement(UtilDates.getCurrentDate());
        movementDto.setTransactionType(command.getTransactionType());
        movementDto.setValueMovement(command.getValueMovement());
        movementDto.setBalance(newBalance);
        movementDto.setAccountId(accountDto.getId());
        repository.saveOrUpdate(movementDto);
        return Boolean.TRUE;
    }

    private double getCalculateBalance(String typeMovement, Double valueMovement, AccountDto accountDto){
        double newBalance = 0.0;

        switch (typeMovement) {
            case "Deposito" :
                newBalance = accountDto.getInitialBalance() + valueMovement;
                break;
            case "Retiro" :
                newBalance = accountDto.getInitialBalance() - valueMovement;
                break;
            case "Transferencia" :
                newBalance = accountDto.getInitialBalance() - valueMovement;
                break;
            case "Pagos" :
                newBalance = accountDto.getInitialBalance() - valueMovement;
                break;
            default:
                throw new IllegalArgumentException("Tipo de transacción no válido.");
        }
        return newBalance;
    }
}
