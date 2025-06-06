
package BusinessLogic;

import BusinessEntity.InventarioProyectoresBE;
import DataAccessObject.InventarioProyectoresDAO;
import java.util.ArrayList;


public class InventarioProyectoresBL implements IBaseBL<InventarioProyectoresBE> {

    @Override
    public boolean Create(InventarioProyectoresBE input) {

        InventarioProyectoresDAO DAO = new InventarioProyectoresDAO();
        return DAO.Create(input);

    }

    @Override
    public InventarioProyectoresBE Read(String input) {
        InventarioProyectoresDAO DAO = new InventarioProyectoresDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioProyectoresBE> ReadAll() {
        InventarioProyectoresDAO DAO = new InventarioProyectoresDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioProyectoresBE input) {
        InventarioProyectoresDAO DAO = new InventarioProyectoresDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioProyectoresDAO DAO = new InventarioProyectoresDAO();
        return DAO.Delete(input);
    }

}
