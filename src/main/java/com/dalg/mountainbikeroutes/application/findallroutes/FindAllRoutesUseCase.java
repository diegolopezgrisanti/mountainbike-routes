package com.dalg.mountainbikeroutes.application.findallroutes;

import com.dalg.mountainbikeroutes.domain.route.Route;
import com.dalg.mountainbikeroutes.domain.route.RoutesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllRoutesUseCase {

    private final RoutesRepository routesRepository;

    public FindAllRoutesUseCase(RoutesRepository routesRepository) { this.routesRepository = routesRepository; }

    public List<Route> getAllRoutes() {
        return routesRepository.findAllRoutes();
    }
}
