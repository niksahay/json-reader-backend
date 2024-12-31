package com.example.demobackend.controller;


import com.example.demobackend.model.ServiceRequest;
import com.example.demobackend.model.ServiceRequestDTO;
import com.example.demobackend.util.ServiceRequestMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class JsonController {

    @GetMapping("/service-request")
    public ServiceRequestDTO getServiceRequest(@RequestParam String attribute, @RequestParam String value) throws IOException {
        // Path to the JSON file
        File jsonFile = new File("src/main/resources/static/service_requests.json");

        // ObjectMapper to read JSON
        ObjectMapper objectMapper = new ObjectMapper();
        List<ServiceRequest> serviceRequests = objectMapper.readValue(jsonFile, new TypeReference<List<ServiceRequest>>() {});

        // Find the service request with the given attribute and value
        Optional<ServiceRequestDTO> foundServiceRequest = serviceRequests.stream()
                .filter(serviceRequest -> {
                    if ("service_req_no".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getService_req_no().equalsIgnoreCase(value);
                    } else if ("short_description".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getShort_description().equalsIgnoreCase(value);
                    } else if ("current_status".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getCurrent_status().equalsIgnoreCase(value);
                    } else if ("long_description".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getLong_description().equalsIgnoreCase(value);
                    } else if ("sr_open_date".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getSr_open_date().equalsIgnoreCase(value);
                    } else if ("request_notes".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getRequest_notes().equalsIgnoreCase(value);
                    } else if ("sr_close_date".equalsIgnoreCase(attribute)) {
                        return serviceRequest.getSr_close_date().equalsIgnoreCase(value);
                    }
                    return false;
                })
                .findFirst().map(sr-> ServiceRequestMapper.INSTANCE.toServiceRequestDTO(sr));

        return foundServiceRequest.orElse(null);
    }
}