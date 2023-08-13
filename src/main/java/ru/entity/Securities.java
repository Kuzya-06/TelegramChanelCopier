package ru.entity;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "securities_list")
public class Securities {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "broker")
    private String broker;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "exchange")
    private String exchange;

//    @Column(name = "sec_type")
//    @Enumerated(value = EnumType.STRING)
//    private SecType secType;
//
//    @Column(name = "what_to_show")
//    @Enumerated(value = EnumType.STRING)
//    private WhatToShow whatToShow;

    @Column(name = "currency")
    private String currency;




    @Column(name = "strike")
    private Double strike;

    @Column(name = "expiration")
    private String expiration;

//    @Column(name = "right")
//    private String right;

    @Column(name = "multiplier")
    private Double multiplier; // should be double

    @Column(name = "local_symbol")
    private String localSymbol;

    @Column(name = "primary_exchange")
    private String primaryExchange; // pick a non-aggregate (ie not the SMART exchange) exchange that the contract trades on.  DO NOT SET TO SMART.

    @Column(name = "trading_class")
    private String tradingClass;

    @Column(name = "sec_id_type")
    private String secIdType; // CUSIP;SEDOL;ISIN;RIC

    @Column(name = "include_expired")
    private Boolean includeExpired = true;  // can not be set to true for orders

    @Column(name = "con_id")
    private Integer conId;



}
