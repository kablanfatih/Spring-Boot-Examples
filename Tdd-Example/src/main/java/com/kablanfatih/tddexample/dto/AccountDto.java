package com.kablanfatih.tddexample.dto;

import com.kablanfatih.tddexample.entitiy.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private String id;

    private String name;

    private String surname;

    private String email;

    private Date birth_date;

    private String password;

    private AccountStatus status;

    private Date createdAt;

}
