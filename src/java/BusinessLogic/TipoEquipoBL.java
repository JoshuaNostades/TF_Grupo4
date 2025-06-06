/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.TipoEquipoBE;
import DataAccessObject.TipoEquipoDAO;
import java.util.ArrayList;

/**
 *
 * @author SOPORTE
 */
public class TipoEquipoBL implements IBaseBL<TipoEquipoBE>{

    @Override
    public boolean Create(TipoEquipoBE input) {
    
    
        TipoEquipoDAO DAO = new TipoEquipoDAO();
        return DAO.Create(input);
    }

    @Override
    public TipoEquipoBE Read(String input) {
     
        TipoEquipoDAO DAO = new TipoEquipoDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<TipoEquipoBE> ReadAll() {
    
        TipoEquipoDAO DAO = new TipoEquipoDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(TipoEquipoBE input) {
    
        TipoEquipoDAO DAO = new TipoEquipoDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
    
        TipoEquipoDAO DAO = new TipoEquipoDAO();
        return DAO.Delete(input);
    }
    
}
