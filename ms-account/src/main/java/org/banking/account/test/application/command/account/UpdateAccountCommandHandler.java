package org.banking.account.test.application.command.account;

import io.jkratz.mediator.core.RequestHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.port.IAccountRepository;
import org.banking.account.test.infraestructure.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class UpdateAccountCommandHandler implements RequestHandler<UpdateAccountCommand, Boolean> {

    private final IAccountRepository repository;

    @Override
    @Transactional
    public Boolean handle(UpdateAccountCommand command) {
        log.info("Method update account");
        AccountDto accountDto = repository.findById(command.getId());
        if(accountDto == null){
            log.info("account query not found....");
            throw new NotFoundException("Account query not found.");
        }
        accountDto.setAccountNumber(command.getAccountNumber());
        accountDto.setStatus(command.getStatus());
        accountDto.setClientId(command.getClientId());
        accountDto.setAccountType(command.getAccountType());
        accountDto.setInitialBalance(command.getInitialBalance());

        repository.saveOrUpdate(accountDto);
        return Boolean.TRUE;
    }

}
