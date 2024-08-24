package org.banking.client.test.infraestructure.controller;

import io.jkratz.mediator.core.Mediator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.client.test.application.command.CreateClientCommand;
import org.banking.client.test.application.command.DeleteClientCommand;
import org.banking.client.test.application.command.UpdateClientCommand;
import org.banking.client.test.application.dto.request.CreateClientRequest;
import org.banking.client.test.application.dto.request.UpdateClientRequest;
import org.banking.client.test.application.dto.response.Response;
import org.banking.client.test.infraestructure.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final Mediator mediator;

    @PostMapping
    public ResponseEntity<Response<Boolean>> createClient(@RequestBody CreateClientRequest request) {
        // Implement logic to create a new client
        var command = new CreateClientCommand();
        command.setPassword(request.getPassword());
        command.setAge(request.getAge());
        command.setGender(request.getGender());
        command.setAddress(request.getAddress());
        command.setName(request.getName());
        command.setIdentification(request.getIdentification());
        command.setPhone(request.getPhone());
        return new ResponseEntity<>(Response.<Boolean>builder().data(this.mediator.dispatch(command)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Boolean>> updateClient(@PathVariable Long id, @RequestBody UpdateClientRequest request) {
        // Implement logic to update a client
        var command = new UpdateClientCommand();
        command.setId(id);
        command.setPassword(request.getPassword());
        command.setAge(request.getAge());
        command.setGender(request.getGender());
        command.setAddress(request.getAddress());
        command.setName(request.getName());
        command.setIdentification(request.getIdentification());
        command.setPhone(request.getPhone());
        command.setStatus(request.getStatus());
        return new ResponseEntity<>(Response.<Boolean>builder().data(this.mediator.dispatch(command)).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> deleteClient(@PathVariable Long id) {
        // Implement logic to delete a client
        var command = new DeleteClientCommand();
        command.setId(id);
        this.mediator.dispatch(command);
        return new ResponseEntity<>(Response.<Boolean>builder().data(Boolean.TRUE).code(Constants.CODE).message(Constants.MESSAGE).build(), HttpStatus.OK);
    }

}
