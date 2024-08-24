package org.banking.account.test.infraestructure.adapter.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.entities.ReportView;
import org.banking.account.test.domain.port.IAccountRepository;
import org.banking.account.test.infraestructure.adapter.jpa.JpaAccountRepository;
import org.banking.account.test.infraestructure.mapper.AccountMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class AccountRepository implements IAccountRepository {

    private JpaAccountRepository jpaAccountRepository;
    private AccountMapper mapper;

    @Override
    public void saveOrUpdate(AccountDto accountDto) {
        jpaAccountRepository.save(mapper.toAccountModel(accountDto));
    }

    @Override
    public AccountDto findById(Long id) {
        return jpaAccountRepository.findById(id).map(mapper::toAccount).orElse(null);
    }

    @Override
    public AccountDto findByAccountNumber(String accountNumber) {
        return jpaAccountRepository.findByAccountNumberAndStatus(accountNumber, Boolean.TRUE).map(mapper::toAccount).orElse(null);
    }

    @Override
    public List<AccountDto> findByClientId(Long clientId) {
        return jpaAccountRepository.findByClientIdAndStatus(clientId, Boolean.TRUE).map(mapper::toAccounts).orElse(null);
    }

    @Override
    public List<ReportView> findByStatement(Long clientId, LocalDate startDate, LocalDate endDate) {
        return jpaAccountRepository.generateReportStateAccount(clientId, startDate, endDate, Boolean.TRUE);
    }

    @Override
    public void deleteById(Long id) {
        jpaAccountRepository.deleteById(id);
    }

}
