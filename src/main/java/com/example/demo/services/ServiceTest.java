package com.example.demo.services;

import com.example.demo.repository.RepoTest;
import com.example.demo.repository.RepoTestProc;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceTest {

    @Autowired
    private RepoTest repository;

    @Autowired
    private RepoTestProc repoProc;

    public void executeProc() {

      try {

        repository.removeUnresolvedUtilty(BigInteger.valueOf(1),BigInteger.valueOf(2));

        repoProc.removeUnresolvedUtility(BigInteger.valueOf(4),BigInteger.valueOf(5));

      } catch (Exception e) {

        System.out.println(e);

      }


    }

}
