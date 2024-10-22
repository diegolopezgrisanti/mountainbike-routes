package com.dalg.mountainbikeroutes.infrastructure.entrypoint.rest;

import com.dalg.mountainbikeroutes.application.findallroutes.FindAllRoutesUseCase;
import com.dalg.mountainbikeroutes.domain.route.Route;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RoutesController {

    private final FindAllRoutesUseCase findAllRoutesUseCase;
    
    public RoutesController(FindAllRoutesUseCase findAllRoutesUseCase) {
        this.findAllRoutesUseCase = findAllRoutesUseCase;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Route> getAllRoutes() {
        return findAllRoutesUseCase.getAllRoutes();
    }
}
