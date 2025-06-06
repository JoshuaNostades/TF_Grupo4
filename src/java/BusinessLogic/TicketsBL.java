/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.TicketsBE;
import DataAccessObject.TicketsDAO;
import java.util.ArrayList;

/**
 *
 * @author SOPORTE
 */
public class TicketsBL implements IBaseBL<TicketsBE> {

    @Override
    public boolean Create(TicketsBE input) {

        TicketsDAO DAO = new TicketsDAO();
        return DAO.Create(input);

    }

    @Override
    public TicketsBE Read(String input) {

        TicketsDAO DAO = new TicketsDAO();
        return DAO.Read(input);

    }

    @Override
    public ArrayList<TicketsBE> ReadAll() {

        TicketsDAO DAO = new TicketsDAO();
        return DAO.ReadAll();

    }

    @Override
    public boolean Update(TicketsBE input) {

        TicketsDAO DAO = new TicketsDAO();
        return DAO.Update(input);

    }

    @Override
    public boolean Delete(String input) {

        TicketsDAO DAO = new TicketsDAO();
        return DAO.Delete(input);

    }

}
