
package BusinessLogic;

import BusinessEntity.AsistenciaBE;
import DataAccessObject.AsistenciaDAO;
import java.util.ArrayList;


public class AsistenciaBL implements IBaseBL<AsistenciaBE>{

    @Override
    public boolean Create(AsistenciaBE input) {
    
    
        AsistenciaDAO DAO = new AsistenciaDAO();
        return DAO.Create(input);
    }

    @Override
    public AsistenciaBE Read(String input) {
    
    
        AsistenciaDAO DAO = new AsistenciaDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<AsistenciaBE> ReadAll() {
    
    
        AsistenciaDAO DAO = new AsistenciaDAO();
        return DAO.ReadAll();
    
    }

    @Override
    public boolean Update(AsistenciaBE input) {
    
    
        AsistenciaDAO DAO = new AsistenciaDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
    
        AsistenciaDAO DAO = new AsistenciaDAO();
        return DAO.Delete(input);
    
    }
    
}
