package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer, Account, Cards and Loans information"
)
public class CustomerDetailDto {

    @Schema(
            description = "Name of the customer",
            example = "Eazy Bytes"
    )
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 5, max = 30, message = "Name should have at least 2 and at most 30 characters")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "email@example.com"
    )
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;

    @Schema(
            description = "mobile number of the customer",
            example = "0987654321"
    )
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Cards details of the customer"
    )
    private CardsDto cardsDto;

    @Schema(
            description = "Loans details of the customer"
    )
    private LoansDto loansDto;
}
