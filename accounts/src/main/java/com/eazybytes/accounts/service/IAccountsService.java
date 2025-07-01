package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
    *
    *@param customerDto - CustomerDto Object
    */
    void createAccount(CustomerDto customerDto);


    /**
    *
    *@param mobileNumber - String Object
    *@return Accounts Details based on a given mobile number
    */
    CustomerDto fetchAccountDetails(String mobileNumber);

    /**
    *
    *@param customerDto - CustomerDto Object
    *@return true if account is updated successfully else false
    */
    boolean updateAccount(CustomerDto customerDto);

    /**
    *
    *@param mobileNumber - String Object
    *@return true if account is deleted successfully else false
    */
    boolean deleteAccount(String mobileNumber);
}
