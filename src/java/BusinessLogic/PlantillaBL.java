
package BusinessLogic;

import BusinessEntity.PlantillaBE;
import DataAccessObject.PlantillaDAO;
import java.util.ArrayList;


public class PlantillaBL implements IBaseBL<PlantillaBE> {

    @Override
    public boolean Create(PlantillaBE input) {

        PlantillaDAO DAO = new PlantillaDAO();
        return DAO.Create(input);

    }

    @Override
    public PlantillaBE Read(String input) {

        PlantillaDAO DAO = new PlantillaDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<PlantillaBE> ReadAll() {

        PlantillaDAO DAO = new PlantillaDAO();
        return DAO.ReadAll();

    }

    @Override
    public boolean Update(PlantillaBE input) {

        PlantillaDAO DAO = new PlantillaDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {

        PlantillaDAO DAO = new PlantillaDAO();
        return DAO.Delete(input);

    }

}
