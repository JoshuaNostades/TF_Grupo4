/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.InventarioImpresorasBE;
import DataAccessObject.InventarioImpresorasDAO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class InventarioImpresorasBL implements IBaseBL<InventarioImpresorasBE>{

    @Override
    public boolean Create(InventarioImpresorasBE input) {
    
    
        InventarioImpresorasDAO DAO = new InventarioImpresorasDAO();
        return DAO.Create(input);
    }

    @Override
    public InventarioImpresorasBE Read(String input) {
   InventarioImpresorasDAO DAO = new InventarioImpresorasDAO();
        return DAO.Read(input); }

    @Override
    public ArrayList<InventarioImpresorasBE> ReadAll() {
    InventarioImpresorasDAO DAO = new InventarioImpresorasDAO();
        return DAO.ReadAll();}

    @Override
    public boolean Update(InventarioImpresorasBE input) {
    InventarioImpresorasDAO DAO = new InventarioImpresorasDAO();
        return DAO.Update(input);}

    @Override
    public boolean Delete(String input) {
    InventarioImpresorasDAO DAO = new InventarioImpresorasDAO();
        return DAO.Delete(input);}
    
}
