package com.example.demobackend.util;
import com.example.demobackend.model.ServiceRequest;
import com.example.demobackend.model.ServiceRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ServiceRequestMapper {

    ServiceRequestMapper INSTANCE = Mappers.getMapper(ServiceRequestMapper.class);

    @Mapping(source = "short_description", target = "shortDescription")
    @Mapping(source = "current_status", target = "currentStatus")
    ServiceRequestDTO toServiceRequestDTO(ServiceRequest serviceRequest);

}
