/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.InventarioRoboticaBE;
import DataAccessObject.InventarioRoboticaDAO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class InventarioRoboticaBL implements IBaseBL<InventarioRoboticaBE> {

    @Override
    public boolean Create(InventarioRoboticaBE input) {

        InventarioRoboticaDAO DAO = new InventarioRoboticaDAO();
        return DAO.Create(input);

    }

    @Override
    public InventarioRoboticaBE Read(String input) {
        InventarioRoboticaDAO DAO = new InventarioRoboticaDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioRoboticaBE> ReadAll() {
        InventarioRoboticaDAO DAO = new InventarioRoboticaDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioRoboticaBE input) {
        InventarioRoboticaDAO DAO = new InventarioRoboticaDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioRoboticaDAO DAO = new InventarioRoboticaDAO();
        return DAO.Delete(input);
    }

}
