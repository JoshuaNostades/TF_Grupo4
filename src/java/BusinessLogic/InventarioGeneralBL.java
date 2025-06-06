/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.InventarioGeneralBE;
import DataAccessObject.InventarioGeneralDAO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class InventarioGeneralBL implements IBaseBL<InventarioGeneralBE>{

    @Override
    public boolean Create(InventarioGeneralBE input) {
    
    
        InventarioGeneralDAO DAO = new InventarioGeneralDAO();
        return DAO.Create(input);
    
    }

    @Override
    public InventarioGeneralBE Read(String input) {
    InventarioGeneralDAO DAO = new InventarioGeneralDAO();
        return DAO.Read(input);}

    @Override
    public ArrayList<InventarioGeneralBE> ReadAll() {
     InventarioGeneralDAO DAO = new InventarioGeneralDAO();
        return DAO.ReadAll();}

    @Override
    public boolean Update(InventarioGeneralBE input) {
    InventarioGeneralDAO DAO = new InventarioGeneralDAO();
        return DAO.Update(input);}

    @Override
    public boolean Delete(String input) {
    InventarioGeneralDAO DAO = new InventarioGeneralDAO();
        return DAO.Delete(input);}
    
}
