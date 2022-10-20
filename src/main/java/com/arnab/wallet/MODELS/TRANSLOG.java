package com.arnab.wallet.MODELS;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Translog")
public class TRANSLOG {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int translog_id;
    @Column(name="DATE", nullable = false,columnDefinition = "Date")
    private String date;
    private int amount;
    private String status;
    private String type;
    @OneToOne(mappedBy = "translog")
    @JsonBackReference
    private USER user;





}
