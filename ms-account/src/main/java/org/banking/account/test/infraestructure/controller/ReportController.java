package org.banking.account.test.infraestructure.controller;

import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.application.command.report.GetReportStatementQuery;
import org.banking.account.test.application.dto.response.Response;
import org.banking.account.test.domain.entities.ReportView;
import org.banking.account.test.infraestructure.utils.Constants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reportes")
@AllArgsConstructor
@Slf4j
public class ReportController {

    private final Mediator mediator;

    @GetMapping("/statement")
    public ResponseEntity<Response<List<ReportView>>> getReportStatement(@RequestParam(required = true) Long clientId,
                                                                         @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                                         @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        var query = new GetReportStatementQuery();
        query.setClientId(clientId);
        query.setStartDate(startDate);
        query.setEndDate(endDate);
        return new ResponseEntity<>(Response.<List<ReportView>>builder().data(this.mediator.dispatch(query)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }
}
