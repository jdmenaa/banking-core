package org.banking.account.test.application.dto.request.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportStatementRequest {

    private Long clientId;
    private LocalDate startDate;
    private LocalDate endDate;

}
