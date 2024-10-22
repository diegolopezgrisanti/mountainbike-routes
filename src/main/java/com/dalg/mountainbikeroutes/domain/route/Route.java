package com.dalg.mountainbikeroutes.domain.route;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Route {
    private Long id;
    private String name;
    private String difficulty;
    private double distance;
}
