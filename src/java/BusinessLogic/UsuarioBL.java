package BusinessLogic;

import BusinessEntity.UsuarioBE;
import DataAccessObject.UsuarioDAO;
import java.util.ArrayList;

public class UsuarioBL implements IBaseBL<UsuarioBE> {

    @Override
    public boolean Create(UsuarioBE input) {

        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.Create(input);
    }

    @Override
    public UsuarioBE Read(String input) {

        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<UsuarioBE> ReadAll() {

        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(UsuarioBE input) {

        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.Update(input);
    }

    @Override
    public boolean Delete(String input) {

        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.Delete(input);
    }

    public ArrayList<UsuarioBE> ReadAllSoporte() {

        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.ReadAllSoporte();
    }

}
