package org.banking.account.test.application.command.report;

import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.AccountDto;
import org.banking.account.test.domain.entities.ReportView;
import org.banking.account.test.domain.port.IAccountRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class GetReportStatementQueryHandler implements RequestHandler<GetReportStatementQuery, List<ReportView>>  {

    private final IAccountRepository repository;

    @Override
    public List<ReportView> handle(GetReportStatementQuery getReportStatementQuery) {
        return repository.findByStatement(getReportStatementQuery.getClientId(), getReportStatementQuery.getStartDate(), getReportStatementQuery.getEndDate());
    }
}
