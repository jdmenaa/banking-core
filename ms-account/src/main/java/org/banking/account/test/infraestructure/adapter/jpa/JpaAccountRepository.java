package org.banking.account.test.infraestructure.adapter.jpa;

import org.banking.account.test.domain.entities.ReportView;
import org.banking.account.test.infraestructure.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumberAndStatus(String accountNumber, Boolean status);

    Optional<List<Account>> findByClientIdAndStatus(Long clientId, Boolean status);

    @Query("SELECT DISTINCT a.accountNumber as accountNumber, a.accountType as accountType, a.initialBalance as initialBalance, a.clientId as clientId, m as movements \n" +
            "FROM Account a inner join a.transactions m \n" +
            " WHERE a.status = :status AND a.clientId = :clientId \n" +
            " AND cast(m.dateMovement as LocalDate) BETWEEN  :startDate AND :endDate")
    List<ReportView> generateReportStateAccount(Long clientId, LocalDate startDate, LocalDate endDate, Boolean status);
}
