package com.dalg.mountainbikeroutes.infrastructure.database;

import com.dalg.mountainbikeroutes.domain.route.RoutesRepository;
import com.dalg.mountainbikeroutes.domain.route.Route;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.util.Collections.emptyMap;

@Repository
public class JdbcRoutesRepository implements RoutesRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcRoutesRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Route> getAllRoutes() {
        return namedParameterJdbcTemplate.query(
                """
                        select * from routes
                """,
                emptyMap(),
                new RouteRowMapper()
        );
    }

    private static class RouteRowMapper implements RowMapper<Route> {
        @Override
        public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Route(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("difficulty"),
                    rs.getDouble("distance")
            );
        }
    }
}
