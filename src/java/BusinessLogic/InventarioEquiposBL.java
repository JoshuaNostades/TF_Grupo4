
package BusinessLogic;

import BusinessEntity.InventarioEquiposBE;
import DataAccessObject.ConexionMySQL;
import DataAccessObject.InventarioEquiposDAO;
import java.util.ArrayList;


public class InventarioEquiposBL implements IBaseBL<InventarioEquiposBE> {

    @Override
    public boolean Create(InventarioEquiposBE input) {

        InventarioEquiposDAO DAO = new InventarioEquiposDAO();
        return DAO.Create(input);

    }

    @Override
    public InventarioEquiposBE Read(String input) {
        InventarioEquiposDAO DAO = new InventarioEquiposDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioEquiposBE> ReadAll() {
        InventarioEquiposDAO DAO = new InventarioEquiposDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioEquiposBE input) {
        InventarioEquiposDAO DAO = new InventarioEquiposDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioEquiposDAO DAO = new InventarioEquiposDAO();
        return DAO.Delete(input);
    }

}
