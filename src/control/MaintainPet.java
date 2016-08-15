
package control;

import da.PetDA;
import domain.Pet;
import java.util.ArrayList;

public class MaintainPet {
    
    private PetDA petDA;
    
    public MaintainPet()
    {
        petDA = new PetDA();
    }
    
    public void addRecord(Pet pet)
    {
        petDA.addRecord(pet);
    }
    
    public Pet searchRecord(String ID)
    {
        return petDA.getRecord(ID);
    }
    
    public ArrayList<Pet> searchRecord(String queryStr, int option)
    {
        return petDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Pet pet)
    {
        petDA.updateRecord(pet);
    }
    
    public void deleteRecord(String ID)
    {
        petDA.deleteRecord(ID);
    }
    
}
