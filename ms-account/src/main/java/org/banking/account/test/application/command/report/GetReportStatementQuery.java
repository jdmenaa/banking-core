package org.banking.account.test.application.command.report;

import io.jkratz.mediator.core.Request;
import lombok.Data;
import org.banking.account.test.application.dto.request.account.ReportStatementRequest;
import org.banking.account.test.domain.entities.ReportView;

import java.util.List;

@Data
public class GetReportStatementQuery extends ReportStatementRequest implements Request<List<ReportView>> {

    public GetReportStatementQuery() {
        super();
    }

}
