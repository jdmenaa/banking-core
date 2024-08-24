package org.banking.account.test.application.command.account;

import io.jkratz.mediator.core.RequestHandler;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.port.IAccountRepository;
import org.banking.account.test.infraestructure.exception.AccountExistException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CreateAccountCommandHandler implements RequestHandler<CreateAccountCommand, Boolean> {

    private final IAccountRepository repository;

    @Override
    @Transactional
    public Boolean handle(CreateAccountCommand command) {
        log.info("Method save account");
        AccountDto accountDto = null;
        List<AccountDto> lstAccount = repository.findByClientId(command.getClientId());
        if(CollectionUtils.isNotEmpty(lstAccount)){
            if(getExistTypeAccount(lstAccount, command.getAccountType())){
                throw new AccountExistException("El cliente ya tiene una cuenta con el tipo "+command.getAccountType());
            }
        }
        accountDto = new AccountDto();
        accountDto.setAccountNumber(command.getAccountNumber());
        accountDto.setStatus(Boolean.TRUE);
        accountDto.setClientId(command.getClientId());
        accountDto.setAccountType(command.getAccountType());
        accountDto.setInitialBalance(command.getInitialBalance());
        repository.saveOrUpdate(accountDto);
        return Boolean.TRUE;
    }

    private Boolean getExistTypeAccount(List<AccountDto> lstAccount, String type){
        return lstAccount.stream().anyMatch(a -> a.getAccountType().equals(type));
    }
}
