package com.infoshareacademy.dao;

import com.infoshareacademy.model.Address;

import javax.ejb.Stateless;

@Stateless
public class AddressDao extends GenericDao<Address, Long> {


    public AddressDao() {
        super(Address.class);
    }


}
