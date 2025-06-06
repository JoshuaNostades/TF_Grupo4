
package BusinessLogic;

import BusinessEntity.EventoCalendarioBE;
import DataAccessObject.EventoCalendarioDAO;
import java.util.ArrayList;


public class EventoCalendarioBL implements IBaseBL<EventoCalendarioBE> {

    @Override
    public boolean Create(EventoCalendarioBE input) {

        EventoCalendarioDAO dao = new EventoCalendarioDAO();
        return dao.Create(input);
    }

    @Override
    public EventoCalendarioBE Read(String input) {

        EventoCalendarioDAO dao = new EventoCalendarioDAO();
        return dao.Read(input);

    }

    @Override
    public ArrayList<EventoCalendarioBE> ReadAll() {

        EventoCalendarioDAO dao = new EventoCalendarioDAO();
        return dao.ReadAll();

    }

    @Override
    public boolean Update(EventoCalendarioBE input) {

        EventoCalendarioDAO dao = new EventoCalendarioDAO();
        return dao.Update(input);
    }

    @Override
    public boolean Delete(String input) {

        EventoCalendarioDAO dao = new EventoCalendarioDAO();
        return dao.Delete(input);
    }

}
