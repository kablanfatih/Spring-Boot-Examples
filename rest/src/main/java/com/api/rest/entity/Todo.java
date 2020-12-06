package com.api.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Todo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ad", length = 255)
    private String ad;

    @Column(name = "todo", length = 1000)
    private String todo;

    @Column(name = "date")
    private String date;

    /*@Column(name = "status")
    @Enumerated(EnumType.STRING)
    private String status;*/
}
