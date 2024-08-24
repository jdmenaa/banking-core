package org.banking.account.test.infraestructure.mapper;

import org.banking.account.test.domain.entities.MovementDto;
import org.banking.account.test.infraestructure.model.Movement;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="dateMovement", target="dateMovement")
    @Mapping(source="transactionType", target="transactionType")
    @Mapping(source="valueMovement", target="valueMovement")
    @Mapping(source="balance", target="balance")
    @Mapping(source="accountId", target="accountId")
    MovementDto toMovement(Movement model);

    @InheritInverseConfiguration
    Movement toMovementModel(MovementDto movementDto);

}
