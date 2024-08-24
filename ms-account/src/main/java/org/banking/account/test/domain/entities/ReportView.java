package org.banking.account.test.domain.entities;

import java.util.List;

public interface ReportView {
    String getAccountNumber();
    String getAccountType();
    Double getInitialBalance();
    Long getClientId();
    List<MovementView> getMovements();

}
