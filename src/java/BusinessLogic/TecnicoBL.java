
package BusinessLogic;

import BusinessEntity.TecnicoBE;
import DataAccessObject.TecnicoDAO;
import java.util.ArrayList;


public class TecnicoBL implements IBaseBL<TecnicoBE>{

    @Override
    public boolean Create(TecnicoBE input) {
    
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Create(input);
        
    
    }

    @Override
    public TecnicoBE Read(String input) {
     
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Read(input);
        
    
    }

    @Override
    public ArrayList<TecnicoBE> ReadAll() {
    
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.ReadAll();
        
    
    }

    @Override
    public boolean Update(TecnicoBE input) {
     
        
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Update(input);
        
    }

    @Override
    public boolean Delete(String input) {
     
    
        TecnicoDAO DAO = new TecnicoDAO();
        return DAO.Delete(input);
        
    }
    
}
