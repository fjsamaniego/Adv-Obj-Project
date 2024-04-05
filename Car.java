
/**
 * This class represents a Car
 */
public class Car {

    // attributes
    private int id;
    private String carType;
    private String model;
    private String condition;
    private String color;
    private int capacity;
    private int mileage;
    private String fuelType;
    private String transmission;
    private int vin;
    private double price;
    private int carsAvailable;
    
    
    /**
     * Constructs a Car object
     * @param color
     * 
     */
    public Car(int id, String carType, String model, String condition, String color, int capacity, int mileage, String fuelType,
    String transmission, int vin, double price, int carsAvailable) {
        this.id = id;
        this.carType = carType;
        this.model = model;
        this.condition = condition;
        this.color = color;
        this.capacity = capacity;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.vin = vin;
        this.carsAvailable = carsAvailable;
    }

    /** Setters
     * 
     * @param id
     */
    public void setID(int id)
    {
        this.id = id;
    }


    /** 
     * 
     * @param carType
    */
    public void setCarType(String carType)
    {
        this.carType = carType;
    }


    /** 
     * 
     * @param model
    */
    public void setModel(String model)
    {
        this.model = model;
    }

    /** 
     * 
     * @param condition
    */
    public void setCondition(String condition)
    {
        this.condition = condition;
    }


    /** 
     * 
     * @param color
    */
    public void setColor(String color)
    {
        this.color = color;
    }


    /** 
     * 
     * @param capacity 
    */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

       /** Setters
     * 
     * @param mileage
     */
    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }


    /** 
     * 
     * @param fuelType
    */
    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }


    /** 
     * 
     * @param transmission
    */
    public void setTransmission(String transmission)
    {
        this.transmission = transmission;
    }

    /** 
     * 
     * @param vin
    */
    public void setVin(int vin)
    {
        this.vin = vin;
    }

    /** 
     * 
     * @param carsAvailable
    */
    public void setCarsAvailable(int carsAvailable)
    {
        this.carsAvailable = carsAvailable;
    }


    /**
     * 
     * @return
     */
    public int getID()
    {
        return id;
    }

    /**
     * 
     * @return
     */
    public String getCarType()
    {
        return carType;
    }

    /**
     * 
     * @return
     */
    public String getModel()
    {
        return model;
    }

    /**
     * 
     * @return
     */
    public String getCondition()
    {
        return condition;
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
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * 
     * @return
     */
    public int getMileage()
    {
        return mileage;
    }

    /**
     * 
     * @return
     */
    public String getFuelType()
    {
        return fuelType;
    }

    /**
     * 
     * @return
     */
    public String getTransmission()
    {
        return transmission;
    }

    /**
     * 
     * @return
     */
    public int getVin()
    {
        return vin;
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
    public int getCarsAvailable()
    {
        return carsAvailable;
    }
}

/**
 * 
 */

class Sedan extends Car {
    public Sedan(int id, String carType, String model, String condition, String color, int capacity, int mileage, String fuelType,
    String transmission, int vin, double price, int carsAvailable){
        super(id, carType, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
    }
}


/**
 * 
 */
class SUV extends Car {
    public SUV(int id, String carType, String model, String condition, String color, int capacity, int mileage, String fuelType,
    String transmission, int vin, double price, int carsAvailable){
        super(id, carType, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
    }
}


/**
 * 
 */
class Hatchback extends Car {
    public Hatchback(int id, String carType, String model, String condition, String color, int capacity, int mileage, String fuelType,
    String transmission, int vin, double price, int carsAvailable){
        super(id, carType, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
    }
}   


/**
 * 
 */
class Pickup extends Car {
    public Pickup(int id, String carType, String model, String condition, String color, int capacity, int mileage, String fuelType,
    String transmission, int vin, double price, int carsAvailable){
        super(id, carType, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable)
    }
}    