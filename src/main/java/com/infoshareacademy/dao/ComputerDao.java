package com.infoshareacademy.dao;

        import com.infoshareacademy.model.Computer;

        import javax.ejb.Stateless;

@Stateless
public class ComputerDao extends GenericDao<Computer, Long> {

    public ComputerDao() {
        super(Computer.class);
    }

}
