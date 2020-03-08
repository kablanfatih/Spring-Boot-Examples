package com.kablanfatih.tddexample.entitiy;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntityModel implements Serializable{

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "surname")
    private String surname;

    @Setter
    @Column(name = "email")
    private String email;

    @Setter
    @Column(name = "birth_date")
    private Date birth_date;

    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private AccountStatus status;
}
