/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.InventarioTelevisoresBE;
import DataAccessObject.InventarioTelevisoresDAO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class InventarioTelevisoresBL implements IBaseBL<InventarioTelevisoresBE> {

    @Override
    public boolean Create(InventarioTelevisoresBE input) {

        InventarioTelevisoresDAO DAO = new InventarioTelevisoresDAO();
        return DAO.Create(input);

    }

    @Override
    public InventarioTelevisoresBE Read(String input) {
        InventarioTelevisoresDAO DAO = new InventarioTelevisoresDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioTelevisoresBE> ReadAll() {
        InventarioTelevisoresDAO DAO = new InventarioTelevisoresDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioTelevisoresBE input) {
        InventarioTelevisoresDAO DAO = new InventarioTelevisoresDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioTelevisoresDAO DAO = new InventarioTelevisoresDAO();
        return DAO.Delete(input);
    }

}
