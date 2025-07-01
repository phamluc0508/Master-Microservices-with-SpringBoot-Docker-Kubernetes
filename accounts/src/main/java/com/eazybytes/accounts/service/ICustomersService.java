package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailDto;

public interface ICustomersService {

    /**
     * Fetch customer details based on a mobile number
     * @param mobileNumber
     * @return
     */
    CustomerDetailDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
