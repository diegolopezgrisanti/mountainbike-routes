package com.dalg.mountainbikeroutes.application.findallroutes;

import com.dalg.mountainbikeroutes.domain.route.Route;
import com.dalg.mountainbikeroutes.domain.route.RoutesRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FindAllRoutesUseCaseTest {

    private final RoutesRepository routesRepository = mock(RoutesRepository.class);
    private final FindAllRoutesUseCase useCase = new FindAllRoutesUseCase(routesRepository);

    @Test
    void shouldReturnAllRoutes() {
        // GIVEN
        List<Route> mockRoutes = List.of(new Route(1L, "Route A", "Intermedia", 15));
        when(routesRepository.getAllRoutes()).thenReturn(mockRoutes);

        // WHEN
        List<Route> result = useCase.execute();

        // THEN
        assertThat(result)
                .isNotEmpty()
                .isEqualTo(mockRoutes);

        verify(routesRepository, times(1)).getAllRoutes();
    }
}
