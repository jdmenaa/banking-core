package org.banking.account.test.infraestructure.controller;

import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.application.command.account.CreateAccountCommand;
import org.banking.account.test.application.command.account.DeleteAccountCommand;
import org.banking.account.test.application.command.account.UpdateAccountCommand;
import org.banking.account.test.application.dto.request.account.CreateAccountRequest;
import org.banking.account.test.application.dto.request.account.UpdateAccountRequest;
import org.banking.account.test.application.dto.response.Response;
import org.banking.account.test.infraestructure.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cuentas")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final Mediator mediator;

    @PostMapping
    public ResponseEntity<Response<Boolean>> createAccount(@RequestBody CreateAccountRequest request) {
        // Implement logic to create a new account
        var command = new CreateAccountCommand();
        command.setAccountNumber(request.getAccountNumber());
        command.setClientId(request.getClientId());
        command.setAccountType(request.getAccountType());
        command.setInitialBalance(request.getInitialBalance());
        return new ResponseEntity<>(Response.<Boolean>builder().data(this.mediator.dispatch(command)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Boolean>> updateAccount(@PathVariable Long id, @RequestBody UpdateAccountRequest request) {
        // Implement logic to update a client
        var command = new UpdateAccountCommand();
        command.setId(id);
        command.setAccountNumber(request.getAccountNumber());
        command.setStatus(request.getStatus());
        command.setClientId(request.getClientId());
        command.setAccountType(request.getAccountType());
        command.setInitialBalance(request.getInitialBalance());
        return new ResponseEntity<>(Response.<Boolean>builder().data(this.mediator.dispatch(command)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deleteAccount(@PathVariable Long id) {
        // Implement logic to delete a Account
        var command = new DeleteAccountCommand();
        command.setId(id);
        this.mediator.dispatch(command);
        return new ResponseEntity<>(Response.<Boolean>builder().data(Boolean.TRUE).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

}
