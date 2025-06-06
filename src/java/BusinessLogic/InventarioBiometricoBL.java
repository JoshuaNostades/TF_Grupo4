
package BusinessLogic;

import BusinessEntity.InventarioAnexosBE;
import BusinessEntity.InventarioBiometricoBE;
import DataAccessObject.InventarioBiometricoDAO;
import java.util.ArrayList;


public class InventarioBiometricoBL implements IBaseBL<InventarioBiometricoBE> {

    @Override
    public boolean Create(InventarioBiometricoBE input) {
        InventarioBiometricoDAO DAO = new InventarioBiometricoDAO();
        return DAO.Create(input);
    }

    @Override
    public InventarioBiometricoBE Read(String input) {
        InventarioBiometricoDAO DAO = new InventarioBiometricoDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<InventarioBiometricoBE> ReadAll() {
        InventarioBiometricoDAO DAO = new InventarioBiometricoDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(InventarioBiometricoBE input) {
        InventarioBiometricoDAO DAO = new InventarioBiometricoDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {
        InventarioBiometricoDAO DAO = new InventarioBiometricoDAO();
        return DAO.Delete(input);
    }

}
