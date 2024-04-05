
/**
 * This class represents a Car
 */
public class Car {

    // attributes
    private String color;
    private int numOfDoors;
    private String typeOfTires;
    private double price;
    private int numOfCylinders;
    private int year;
    private String make;
    private String model;

    
    /**
     * Constructs a Car object
     * @param color
     * 
     */
    public Car(String color, int numOfDoors, double price, int numOfCylinders, int year, String make, String model) {
        this.color = color;
        this.numOfDoors = numOfDoors;
        this.price = price;
        this.numOfCylinders = numOfCylinders;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    /** Setters
     * 
     * @param newColor
     */
    public void setColor(String newColor)
    {
        color = newColor;
    }


    /** 
     * 
     * @param newNumD
    */
    public void setNumberOfDoors(int newNumD)
    {
        numOfDoors = newNumD;
    }


    /** 
     * 
     * @param newType
    */
    public void setTypesOfTires(String newType)
    {
        typeOfTires = newType;
    }

    /** 
     * 
     * @param newNumC
    */
    public void setNumOfCylinders(int newNumC)
    {
        numOfCylinders = newNumC;
    }


    /** 
     * 
     * @param newYear
    */
    public void setYear(int newYear)
    {
        year = newYear;
    }


    /** 
     * 
     * @param newMake 
    */
    public void setMake(String newMake)
    {
        make = newMake;
    }


    /** 
     * 
     * @param newModel
    */
    public void setModel(String newModel)
    {
        model = newModel;
    }

    /**
     * 
     * @return
     */
    public String getColor()
    {
        return color;
    }

    /**
     * 
     * @return
     */
    public int getNumberOfDoors()
    {
        return numOfDoors;
    }


    /**
     * 
     * @return
     */
    public String getTypeOfTires()
    {
        return typeOfTires;
    }

    /**
     * 
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * 
     * @return
     */
    public int getNumOfCylinders()
    {
        return numOfCylinders;
    }

    /**
     * 
     * @return
     */
    public int getYear()
    {
        return year;
    }

    /**
     * 
     * @return
     */
    public String getMake()
    {
        return make;
    }

    /**
     * 
     * @return
     */
    public String getModel()
    {
        return model;
    }

    
}

/**
 * 
 */

class Sedan extends Car {
    public Sedan(String color, int numOfDoors, double price, int numOfCylinders, int year, String make, String model){
        super(color, numOfDoors, price, numOfCylinders, year, make, model);
    }
}


/**
 * 
 */
class SUV extends Car {
    public SUV(String color, int numOfDoors, double price, int numOfCylinders, int year, String make, String model){
        super(color, numOfDoors, price, numOfCylinders, year, make, model);
    }
}


/**
 * 
 */
class Hatchback extends Car {
    public Hatchback(String color, int numOfDoors, double price, int numOfCylinders, int year, String make, String model){
        super(color, numOfDoors, price, numOfCylinders, year, make, model);
    }
}   


/**
 * 
 */
class Pickup extends Car {
    public Pickup(String color, int numOfDoors, double price, int numOfCylinders, int year, String make, String model){
        super(color, numOfDoors, price, numOfCylinders, year, make, model);
    }
}    