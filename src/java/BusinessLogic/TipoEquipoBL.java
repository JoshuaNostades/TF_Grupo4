
package BusinessLogic;

import BusinessEntity.TipoEquipoBE;
import DataAccessObject.TipoEquipoDAO;
import java.util.ArrayList;


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
