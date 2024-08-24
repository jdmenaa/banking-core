package org.banking.account.test.infraestructure.controller;

import io.jkratz.mediator.core.Mediator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.application.command.movement.CreateMovementCommand;
import org.banking.account.test.application.command.movement.DeleteMovementCommand;
import org.banking.account.test.application.command.movement.UpdateMovementCommand;
import org.banking.account.test.application.dto.request.movement.CreateMovementRequest;
import org.banking.account.test.application.dto.request.movement.UpdateMovementRequest;
import org.banking.account.test.application.dto.response.Response;
import org.banking.account.test.infraestructure.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movimientos")
@AllArgsConstructor
@Slf4j
public class MovementController {

    private final Mediator mediator;

    @PostMapping
    public ResponseEntity<Response<Boolean>> createMovement(@Valid @RequestBody CreateMovementRequest request) {
        // Implement logic to create a new movement
        var command = new CreateMovementCommand();
        //command.setDateMovement(request.getDateMovement());
        command.setTransactionType(request.getTransactionType());
        command.setValueMovement(request.getValueMovement());
        //command.setBalance(request.getBalance());
        command.setAccountNumber(request.getAccountNumber());
        return new ResponseEntity<>(Response.<Boolean>builder().data(this.mediator.dispatch(command)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Boolean>> updateMovement(@PathVariable Long id, @RequestBody UpdateMovementRequest request) {
        // Implement logic to update a Movement
        var command = new UpdateMovementCommand();
        command.setId(id);
        command.setDateMovement(request.getDateMovement());
        command.setTransactionType(request.getTransactionType());
        command.setValueMovement(request.getValueMovement());
        command.setBalance(request.getBalance());
        command.setAccountId(request.getAccountId());
        return new ResponseEntity<>(Response.<Boolean>builder().data(this.mediator.dispatch(command)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deleteMovement(@PathVariable Long id) {
        // Implement logic to delete a Movement
        var command = new DeleteMovementCommand();
        command.setId(id);
        this.mediator.dispatch(command);
        return new ResponseEntity<>(Response.<Boolean>builder().data(Boolean.TRUE).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

}
