public class Car 
{
    // attributes
    public String color;
    public int numbOfDoors;
    public String typeOfTires;
    public Sound honk;
    public Double price;
    public int numOfCylinders;
    public int year;
    public String make;
    public String model;

    /** Setters */
    public void setColor(String newColor)
    {
        color = newColor;
    }

    public void setNumberOfDoors(int newNumD)
    {
        numbOfDoors = newNumD;
    }

    public void setTypesOfTires(String newType)
    {
        typeOfTires = newType;
    }

    public void setHonk(Sound newSound)
    {
        honk = newSound;
    }

    public void setNumOfCylinders(int newNumC)
    {
        numOfCylinders = newNumC;
    }

    public void setYear(int newYear)
    {
        year = newYear;
    }

    public void setMake(String newMake)
    {
        make = newMake;
    }

    public void setModel(String newModel)
    {
        model = newModel;
    }

    /** Getters */
    public String getColor()
    {
        return color;
    }

    public int getNumberOfDoors()
    {
        return numbOfDoors;
    }

    public String getTypeOfTires()
    {
        return typeOfTires;
    }

    public Sound getHonk()
    {
        return honk;
    }

    public Double getPrice()
    {
        return price;
    }

    public int getNumOfCylinders()
    {
        return numOfCylinders;
    }

    public int getYear()
    {
        return year;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    
}
