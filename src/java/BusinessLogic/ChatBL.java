
package BusinessLogic;

import BusinessEntity.ChatBE;
import DataAccessObject.ChatDAO;
import java.util.ArrayList;


public class ChatBL implements IBaseBL<ChatBE>{

    @Override
    public boolean Create(ChatBE input) {
     
        ChatDAO DAO = new ChatDAO();
        return DAO.Create(input);
    
    
    }

    @Override
    public ChatBE Read(String input) {
    
    
        ChatDAO DAO = new ChatDAO();
        return DAO.Read(input);
    }

    @Override
    public ArrayList<ChatBE> ReadAll() {
     
    
        ChatDAO DAO = new ChatDAO();
        return DAO.ReadAll();
    }

    @Override
    public boolean Update(ChatBE input) {
    
        ChatDAO DAO = new ChatDAO();
        return DAO.Update(input);
    
    }

    @Override
    public boolean Delete(String input) {
    
        ChatDAO DAO = new ChatDAO();
        return DAO.Delete(input);
    
    }
    
}
