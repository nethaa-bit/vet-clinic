
package domain;

import java.util.Date;


public class Pet {
   private String petID;
   private String petName;
   private Double petHeight;
   private Double petWeight;
   private Double petLength;
   private String animalType;
   private String breed;
   private Date petDOB;
   private char petGender;
   private Customer customer;

    public Pet() {
    }

    public Pet(String petID, String petName, Double petHeight, Double petWeight, Double petLength, String animalType, String breed, Date petDOB, char petGender, Customer customer) {
        this.petID = petID;
        this.petName = petName;
        this.petHeight = petHeight;
        this.petWeight = petWeight;
        this.petLength = petLength;
        this.animalType = animalType;
        this.breed = breed;
        this.petDOB = petDOB;
        this.petGender = petGender;
        this.customer = customer;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Double getPetHeight() {
        return petHeight;
    }

    public void setPetHeight(Double petHeight) {
        this.petHeight = petHeight;
    }

    public Double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Double petWeight) {
        this.petWeight = petWeight;
    }

    public Double getPetLength() {
        return petLength;
    }

    public void setPetLength(Double petLength) {
        this.petLength = petLength;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getPetDOB() {
        return petDOB;
    }

    public void setPetDOB(Date petDOB) {
        this.petDOB = petDOB;
    }

    public char getPetGender() {
        return petGender;
    }

    public void setPetGender(char petGender) {
        this.petGender = petGender;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Pet{" + "petID=" + petID + ", petName=" + petName + ", petHeight=" + petHeight + ", petWeight=" + petWeight + ", petLength=" + petLength + ", animalType=" + animalType + ", breed=" + breed + ", petDOB=" + petDOB + ", petGender=" + petGender + ", customer=" + customer + '}';
    }

    public Object[] getObjects() {
        Object[] objList ={petID,petName,petHeight, petWeight,petLength ,animalType,breed, petDOB,petGender,customer };
        return objList;
    }    
  
}
