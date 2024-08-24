package org.banking.account.test.domain.port;

import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.entities.ReportView;

import java.time.LocalDate;
import java.util.List;

public interface IAccountRepository {
    void saveOrUpdate(AccountDto accountDto);
    AccountDto findById(Long id);
    AccountDto findByAccountNumber(String accountNumber);
    List<AccountDto> findByClientId(Long clientId);
    List<ReportView> findByStatement(Long clientId, LocalDate startDate, LocalDate endDate);
    void deleteById(Long id);
}
