package org.banking.client.test.infraestructure.adapter.jpa;

import org.banking.client.test.infraestructure.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClientRepository extends JpaRepository<Client, Long> {

}
