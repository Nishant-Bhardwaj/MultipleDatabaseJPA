package com.application.covid.Models.db2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "l2")
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
