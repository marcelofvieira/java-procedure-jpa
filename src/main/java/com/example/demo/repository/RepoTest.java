package com.example.demo.repository;

import com.example.demo.Entity.PurgeEntity;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RepoTest extends JpaRepository<PurgeEntity, BigInteger> {

  @Transactional
  @Procedure(name = "purge.removeUnresolvedUtility")
  void removeUnresolvedUtilty(@Param("startId") BigInteger startId, @Param("finalId") BigInteger finalId);

  @Transactional
  @Query(value= "{CALL removeUnresolvedUtility (:startId, :finalId)};", nativeQuery = true )
  void removeUnresolvedUtiltyNative(@Param("startId") BigInteger startId, @Param("finalId") BigInteger finalId);

}
