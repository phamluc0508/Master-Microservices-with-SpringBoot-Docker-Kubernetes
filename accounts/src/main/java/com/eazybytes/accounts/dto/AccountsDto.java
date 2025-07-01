package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account number of Eazy Bank Account",
            example = "1231231233"
    )
    @NotEmpty(message = "Account number should not be null or empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number should be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of Eazy Bank Account",
            example = "Saving"
    )
    @NotEmpty(message = "Account type should not be null or empty")
    private String accountType;

    @Schema(
            description = "Branch address of Eazy Bank Account",
            example = "123 Main Street"
    )
    @NotEmpty(message = "Branch address should not be null or empty")
    private String branchAddress;
}
