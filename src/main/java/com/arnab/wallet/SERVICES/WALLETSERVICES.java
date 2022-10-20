package com.arnab.wallet.SERVICES;

import com.arnab.wallet.MODELS.TRANSLOG;
import com.arnab.wallet.MODELS.USER;
import com.arnab.wallet.REPOSITORY.WALLETREPOSITORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WALLETSERVICES  {
    @Autowired
    WALLETREPOSITORY wr;
    public USER finduser(int id){
        return wr.findById(id);
    }
    public int showbalance(int id){

      USER us= wr.findById(id);


      return us.getBalance();
    }

    public void addmoney(int id,int amount){
        USER us;
        us=wr.findById(id);
        us.setBalance(us.getBalance()+amount);
        wr.save(us);
    }
    public void withdraw_money(int id,int amount){
        USER us;
        us=wr.findById(id);
        us.setBalance(us.getBalance()-amount);
        wr.save(us);
    }

   public TRANSLOG transactionlog(int id){
        USER us;
        us=wr.findById(id);
       return us.getTranslog();

    }
    public void createaccount(USER us){
        wr.save(us);
    }











}
