package com.application.covid.Modles.db2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "l2")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "laptop2")
@ConfigurationProperties(prefix = "laptop2")
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
