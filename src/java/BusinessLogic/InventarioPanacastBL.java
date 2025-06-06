/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.InventarioPanacastBE;
import DataAccessObject.InventarioPanacastDAO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class InventarioPanacastBL implements IBaseBL<InventarioPanacastBE> {

    @Override
    public boolean Create(InventarioPanacastBE input) {

        InventarioPanacastDAO DAO = new InventarioPanacastDAO();
        return DAO.Create(input);

    }

    @Override
    public InventarioPanacastBE Read(String input) {
        InventarioPanacastDAO DAO = new InventarioPanacastDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioPanacastBE> ReadAll() {
        InventarioPanacastDAO DAO = new InventarioPanacastDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioPanacastBE input) {
        InventarioPanacastDAO DAO = new InventarioPanacastDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioPanacastDAO DAO = new InventarioPanacastDAO();
        return DAO.Delete(input);
    }

}
