package com.example.demo.Entity;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.query.Param;

@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(name = "purge.removeUnresolvedUtility", procedureName = "removeUnresolvedUtility",
    parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "startId", type = BigInteger.class),
                  @StoredProcedureParameter(mode = ParameterMode.IN, name = "finalId", type = BigInteger.class)})
public class PurgeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private BigInteger startId;

  private BigInteger finalId;

}
