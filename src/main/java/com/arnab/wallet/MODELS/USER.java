package com.arnab.wallet.MODELS;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity
@Table(name="User")
public class USER {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private int balance;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private TRANSLOG translog;


}
