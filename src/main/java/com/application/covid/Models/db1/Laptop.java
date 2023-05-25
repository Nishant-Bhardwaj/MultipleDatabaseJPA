package com.application.covid.Models.db1;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "l1")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String size;
    private String ram;
    private String rom;
    private String processor;
    private Long price;
}
