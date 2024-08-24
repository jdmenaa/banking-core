package org.banking.client.test;

import org.banking.client.test.application.command.CreateClientCommandHandler;
import org.banking.client.test.domain.entities.ClientDto;
import org.banking.client.test.domain.port.IClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;

public class ClientServiceTest {

    @Mock
    private IClientRepository clientRepository;
    @InjectMocks
    CreateClientCommandHandler createClientCommandHandler;

    private ClientDto clientDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientDto = new ClientDto();
        clientDto.setClientId(1L);
        clientDto.setPassword("password123");
        clientDto.setStatus(true);
        clientDto.setName("John Doe");
        clientDto.setGender("Male");
        clientDto.setAge(30);
        clientDto.setIdentification("123456789");
        clientDto.setAddress("123 Main St");
        clientDto.setPhone("123-456-7890");
    }

    @Test
    void testSaveClient() {

        //Mock
        Mockito.when(clientRepository.saveOrUpdate(clientDto)).thenReturn(clientDto.getClientId());

        //test
        Long clientId = clientRepository.saveOrUpdate(clientDto);

        //Verifity
        Assertions.assertNotNull(clientId);
        Assertions.assertEquals(clientDto.getClientId(), clientId);
        Mockito.verify(clientRepository, times(1)).saveOrUpdate(clientDto);
    }


}
