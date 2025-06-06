
package BusinessLogic;

import BusinessEntity.InventarioAnexosBE;
import DataAccessObject.InventarioAnexosDAO;
import java.util.ArrayList;


public class InventarioAnexosBL implements IBaseBL<InventarioAnexosBE> {

    @Override
    public boolean Create(InventarioAnexosBE input) {

        InventarioAnexosDAO DAO = new InventarioAnexosDAO();
        return DAO.Create(input);

    }

    @Override
    public InventarioAnexosBE Read(String input) {

        InventarioAnexosDAO DAO = new InventarioAnexosDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioAnexosBE> ReadAll() {
        InventarioAnexosDAO DAO = new InventarioAnexosDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioAnexosBE input) {
        InventarioAnexosDAO DAO = new InventarioAnexosDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioAnexosDAO DAO = new InventarioAnexosDAO();
        return DAO.Delete(input);
    }

}
