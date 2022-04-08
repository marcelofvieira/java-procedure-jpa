package com.example.demo.services;

import com.example.demo.repository.RepoTestJDBCTemplate;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTest {

    //@Autowired private RepoTest repo;

    //@Autowired private RepoTestEntityManager repoTestEntityManager;

    @Autowired
    private RepoTestJDBCTemplate repoTestJDBCTemplate;

    public void executeProc() {

      try {

        //repo.removeUnresolvedUtilty(BigInteger.valueOf(1),BigInteger.valueOf(2));

        //repoTestEntityManager.removeUnresolvedUtility(BigInteger.valueOf(4),BigInteger.valueOf(5));

        repoTestJDBCTemplate.removeUnresolvedUtility(BigInteger.valueOf(1),BigInteger.valueOf(5));


      } catch (Exception e) {

        System.out.println(e);

      }


    }

}
