package BusinessLogic;

import java.util.ArrayList;

public interface IBaseBL<T> {

    public boolean Create(T input);

    public T Read(String input);

    public ArrayList<T> ReadAll();

    public boolean Update(T input);

    public boolean Delete(String input);
}
