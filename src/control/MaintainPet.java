
package control;

import da.PetDA;
import domain.Pet;

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
    
    public void updateRecord(Pet pet)
    {
        petDA.updateRecord(pet);
    }
    
    public void deleteRecord(String ID)
    {
        petDA.deleteRecord(ID);
    }
    
}
