package org.banking.account.test.infraestructure.mapper;

import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.infraestructure.model.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="accountNumber", target="accountNumber")
    @Mapping(source="accountType", target="accountType")
    @Mapping(source="initialBalance", target="initialBalance")
    @Mapping(source="status", target="status")
    @Mapping(source="clientId", target="clientId")
    AccountDto toAccount(Account model);

    List<AccountDto> toAccounts(List<Account> accounts);

    @InheritInverseConfiguration
    Account toAccountModel(AccountDto accountDto);

}
