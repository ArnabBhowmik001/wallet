package com.arnab.wallet.REPOSITORY;

import com.arnab.wallet.MODELS.USER;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WALLETREPOSITORY extends CrudRepository<USER, Integer> {

 @Query(value="select * from USER u" , nativeQuery = true)
 public List<USER> findALL();
 @Query(value="select * from USER u where u.user_id=?1" , nativeQuery = true)
 public USER findById(int id);
}

