package org.banking.account.test.infraestructure.listener;

import io.jkratz.mediator.core.Mediator;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.application.command.account.CreateAccountCommand;
import org.banking.account.test.domain.entities.ClientDto;
import org.banking.account.test.infraestructure.utils.TypeAccountEnum;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Slf4j
@Component
public class CreateAccountListener {

    private final Mediator mediator;

    public static final String QUEUE = "clientQueue";

    public CreateAccountListener(Mediator mediator) {
        this.mediator = mediator;
    }

    @RabbitListener(queues = QUEUE)
    public void receiveClientMessage(ClientDto clientDto) {
        log.info("**** CLIENTE RECIBIDO ****{}", clientDto.getClientId());
        var command = new CreateAccountCommand();
        command.setAccountNumber(this.generateAccountNumber());
        command.setClientId(clientDto.getClientId());
        command.setAccountType(TypeAccountEnum.SAVINGS.getValue());
        command.setInitialBalance(0.0D);
        this.mediator.dispatch(command);
    }

    private String generateAccountNumber() {
        Set<String> generatedAccountNumbers = new HashSet<>();
        Random random = new Random();
        String accountNumber;

        do {
            accountNumber = String.format("%06d", random.nextInt(1000000));
        } while (generatedAccountNumbers.contains(accountNumber));

        generatedAccountNumbers.add(accountNumber);
        return accountNumber;
    }
}