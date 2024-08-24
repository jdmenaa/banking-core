package org.banking.account.test.infraestructure.adapter.jpa;

import org.banking.account.test.infraestructure.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovementRepository extends JpaRepository<Movement, Long> {

}
