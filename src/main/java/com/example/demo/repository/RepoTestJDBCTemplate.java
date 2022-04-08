package com.example.demo.repository;

import java.math.BigInteger;
import java.sql.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class RepoTestJDBCTemplate {

  private final static String PROCEDURE_NAME = "removeunresolvedutility";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void removeUnresolvedUtility (BigInteger startId, BigInteger finalId) {

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
        .withProcedureName(PROCEDURE_NAME)
        .declareParameters(
            new SqlParameter("startId", Types.BIGINT),
            new SqlParameter("finalId", Types.BIGINT)
        );

    simpleJdbcCall.execute(new MapSqlParameterSource("startId", startId).addValue("finalId", finalId));

  }

}
