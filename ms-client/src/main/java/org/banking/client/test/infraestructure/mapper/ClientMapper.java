package org.banking.client.test.infraestructure.mapper;

import org.banking.client.test.domain.entities.ClientDto;
import org.banking.client.test.infraestructure.model.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source="clientId", target="clientId")
    @Mapping(source="password", target="password")
    @Mapping(source="status", target="status")
    @Mapping(source="name", target="name")
    @Mapping(source="gender", target="gender")
    @Mapping(source="age", target="age")
    @Mapping(source="identification", target="identification")
    @Mapping(source="address", target="address")
    @Mapping(source="phone", target="phone")
    ClientDto toClient(Client model);

    @InheritInverseConfiguration
    Client toClientModel(ClientDto clientDto);

}
