
package BusinessLogic;

import BusinessEntity.InformeBE;
import DataAccessObject.InformesDAO;
import java.util.ArrayList;


public class InformesBL implements IBaseBL<InformeBE>{

    @Override
    public boolean Create(InformeBE input) {
     
    
        InformesDAO DAO = new InformesDAO();
        return DAO.Create(input);
    }

    @Override
    public InformeBE Read(String input) {
    
        InformesDAO DAO = new InformesDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InformeBE> ReadAll() {
    
        InformesDAO DAO = new InformesDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InformeBE input) {
    
        InformesDAO DAO = new InformesDAO();
        return DAO.Update(input);
    }
    

    @Override
    public boolean Delete(String input) {
     
        InformesDAO DAO = new InformesDAO();
        return DAO.Delete(input);
    }
    
    
    
}
