package com.aprendendoRest.aprendendoRestViajens.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    private Long Id;
    private String orderNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal amount;
    private TravelTypeEnum type;
    private List<Link> links;

    public Travel(TravelTypeEnum type) {
        this.type = type;
    }
    public void adLink(Link link) {
        if(links == null) links = new ArrayList<>();
        links.add(link);
    }
}
// https://mari-azevedo.medium.com/construindo-uma-api-restful-com-java-e-spring-framework-46b74371d107