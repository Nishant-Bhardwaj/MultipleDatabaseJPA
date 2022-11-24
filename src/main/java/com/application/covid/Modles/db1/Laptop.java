package com.application.covid.Modles.db1;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "l1")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "laptop1")
@ConfigurationProperties(prefix = "laptop1")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private String ram;
    private String rom;
    private String processor;
    private Long price;
}
