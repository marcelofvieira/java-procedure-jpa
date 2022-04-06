package com.example.demo.repository;

import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepoTestProc{

  private final static String PROCEDURE = "removeUnresolvedUtility";

  @Autowired
  private EntityManager entityManager;

  @Transactional
  public void removeUnresolvedUtility (BigInteger startId, BigInteger finalId) {

    StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(PROCEDURE);

    query.registerStoredProcedureParameter("startId", BigInteger.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("finalId", BigInteger.class, ParameterMode.IN);

    query.setParameter("startId", startId);
    query.setParameter("finalId", finalId);

    query.execute();

  }

}
