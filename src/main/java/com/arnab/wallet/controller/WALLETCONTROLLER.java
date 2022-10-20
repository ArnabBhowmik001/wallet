package com.arnab.wallet.controller;

import com.arnab.wallet.MODELS.TRANSLOG;
import com.arnab.wallet.MODELS.USER;
import com.arnab.wallet.SERVICES.WALLETSERVICES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WALLETCONTROLLER {
   @Autowired
   private  WALLETSERVICES  wc;
   @GetMapping("/userinfo/{id}")
   public USER userinfobyid(@PathVariable int id) {
       return wc.finduser(id);
   }


    @GetMapping("/showbalance/{id}")
    public String showbalance(@PathVariable("id") int id){


       return ("CURRENT BALANCE IS: "+wc.showbalance(id));


    }
    @PutMapping("/addmoney/{id}/{amount}/{Date}")
   public String addmoney(@PathVariable("id") int id,@PathVariable("amount") int amount,@PathVariable("Date") String Date){
            wc.addmoney(id,amount);
            USER us=wc.finduser(id);
            TRANSLOG tl=us.getTranslog();
            tl.setType("credit");
            tl.setStatus("success");
            tl.setAmount(amount);
            tl.setDate(Date);
            return ("NEW BALANCE: "+us.getBalance());
        }
    @PutMapping("/withdraw_money/{id}/{amount}/{Date}")
    public String   withdraw_money(@PathVariable("id") int id,@PathVariable("amount") int amount,@PathVariable("Date") String Date){
        wc.withdraw_money(id,amount);
        USER us=wc.finduser(id);
        TRANSLOG tl=us.getTranslog();
        tl.setType("debit");
        tl.setStatus("success");
        tl.setAmount(amount);
        tl.setDate(Date);
       return ("NEW BALANCE: "+us.getBalance());
    }
    @GetMapping("/transactionlog/{id}")
   public TRANSLOG transactionlog(@PathVariable("id") int id){
       return wc.transactionlog(id);

    }
    @PostMapping("/createaccount")
    public USER createaccount( @RequestBody USER us){
        wc.createaccount(us);
        return us;

    }


}
