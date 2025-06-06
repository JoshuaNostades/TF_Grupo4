/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessObject;

import java.util.ArrayList;

/**
 *
 * @author SOPORTE
 */
public interface IBaseDAO<T> {
    
    public boolean Create(T input);
   public T Read(String input);
   public ArrayList<T> ReadAll();
   public boolean Update(T input);
   public boolean Delete(String input);
    
}
