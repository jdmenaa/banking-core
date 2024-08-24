package org.banking.account.test.domain.port;

import org.banking.account.test.domain.entities.MovementDto;

public interface IMovementRepository {
    void saveOrUpdate(MovementDto movementDto);
    MovementDto findById(Long id);
    void deleteById(Long id);
}
