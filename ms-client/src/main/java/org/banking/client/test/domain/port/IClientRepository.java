package org.banking.client.test.domain.port;

import org.banking.client.test.domain.entities.ClientDto;

public interface IClientRepository {
    Long saveOrUpdate(ClientDto clientDto);
    ClientDto findById(Long id);
    void deleteById(Long id);
}
