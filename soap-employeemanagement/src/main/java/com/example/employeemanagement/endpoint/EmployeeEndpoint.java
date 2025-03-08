package com.example.employeemanagement.endpoint;

import com.example.employeemanagement.service.EmployeeService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.employees.GetEmployeeRequest;
import com.example.employees.GetEmployeeResponse;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/employees";

    private final EmployeeService employeeService;

    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(employeeService.getEmployeeById(request.getId()));
        return response;
    }
}

