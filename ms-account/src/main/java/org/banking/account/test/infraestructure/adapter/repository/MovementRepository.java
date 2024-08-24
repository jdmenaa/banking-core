package org.banking.account.test.infraestructure.adapter.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.banking.account.test.domain.entities.MovementDto;
import org.banking.account.test.domain.port.IMovementRepository;
import org.banking.account.test.infraestructure.adapter.jpa.JpaMovementRepository;
import org.banking.account.test.infraestructure.mapper.MovementMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class MovementRepository implements IMovementRepository {

    private JpaMovementRepository jpaMovementRepository;
    private MovementMapper mapper;

    @Override
    public void saveOrUpdate(MovementDto movementDto) {
        jpaMovementRepository.save(mapper.toMovementModel(movementDto));
    }

    @Override
    public MovementDto findById(Long id) {
        return jpaMovementRepository.findById(id).map(mapper::toMovement).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaMovementRepository.deleteById(id);
    }

}
