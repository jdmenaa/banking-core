package org.banking.client.test.infraestructure.adapter.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.client.test.domain.entities.ClientDto;
import org.banking.client.test.domain.port.IClientRepository;
import org.banking.client.test.infraestructure.adapter.jpa.JpaClientRepository;
import org.banking.client.test.infraestructure.mapper.ClientMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class ClientRepository implements IClientRepository {

    private JpaClientRepository jpaClientRepository;
    private ClientMapper mapper;

    @Override
    public Long saveOrUpdate(ClientDto clientDto) {
        return jpaClientRepository.save(mapper.toClientModel(clientDto)).getClientId();
    }

    @Override
    public ClientDto findById(Long id) {
        return jpaClientRepository.findById(id).map(mapper::toClient).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaClientRepository.deleteById(id);
    }

}
