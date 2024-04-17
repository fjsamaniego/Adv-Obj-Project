
/**
 * This class represents a Car and its atrributes. 
 * Also has car types extending from Car class.
 */
public class Car 
{
    private int id;
    private String carType;
    private String model;
    private String condition;
    private String color;
    private int capacity;
    private int year;
    private String fuelType;
    private String transmission;
    private String vin;
    private double price;
    private int carsAvailable;
    private String hasTurbo;
    
    /**
     * Consructs Car object with its attributes 
     * 
     * @param id integer of car ID 
     * @param carType String of the car type
     * @param model String of car model
     * @param condition String of car condition
     * @param color String of car color
     * @param capacity integer of car capacity
     * @param mileage integer of car mileage
     * @param fuelType String of fuel type
     * @param transmission String of car transmission
     * @param vin String of car vin
     * @param price double of car price 
     * @param carsAvailable integer of cars available
     */
    public Car(int id, String carType, String model, String condition, String color, int capacity, int year, String fuelType,
            String transmission, String vin, double price, int carsAvailable, String hasTurbo) {
        this.id = id;
        this.carType = carType;
        this.model = model;
        this.condition = condition;
        this.color = color;
        this.capacity = capacity;
        this.year = year;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.price = price;
        this.vin = vin;
        this.carsAvailable = carsAvailable;
        this.hasTurbo = hasTurbo;
    }

    /**
     * Sets the ID of the car 
     * @param id the car id to et
     */
    public void setID(int id)
    {
        this.id = id;
    }


    /**
     * Sets thr car type
     * @param carType the car type to set
     */
    public void setCarType(String carType)
    {
        this.carType = carType;
    }


    /**
     * Sets the car model
     * @param model the model to set
     */
    public void setModel(String model)
    {
        this.model = model;
    }

    /**
     * Sets the car condition
     * @param condition car condition to set
     */
    public void setCondition(String condition)
    {
        this.condition = condition;
    }


    /**
     * Sets the car color
     * @param color car color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }


    /**
     * Sets the car capacity
     * @param capacity car capacity to set
     */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    /**
     * Sets the car mileage
     * @param mileage car mileage to set
     */
    public void setYear(int year)
    {
        this.year = year;
    }


    /**
     * Sets the car fuel type
     * @param fuelType type of fuel to set
     */
    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }


    /**
     * Sets the car transmission
     * @param transmission car transmission to set
     */
    public void setTransmission(String transmission)
    {
        this.transmission = transmission;
    }

    /**
     * Sets the car vin
     * @param vin vin to be set
     */
    public void setVin(String vin)
    {
        this.vin = vin;
    }

    /**
     * Sets the cars available
     * @param carsAvailable cars available to be set
     */
    public void setCarsAvailable(int carsAvailable)
    {
        this.carsAvailable = carsAvailable;
    }

    public void setHasTurbo(String hasTurbo)
    {
        this.hasTurbo = hasTurbo;
    }

    /**
     * Returns the car ID
     * @return integer car ID
     */
    public int getID()
    {
        return id;
    }

    /**
     * Returns the car type
     * @return String car type
     */
    public String getCarType()
    {
        return carType;
    }

    /**
     * Returns the car model
     * @return String car model
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Returns the car condition
     * @return String car condition
     */
    public String getCondition()
    {
        return condition;
    }

    /**
     * Returns the car color
     * @return String car color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Returns the car capacity
     * @return integer for car capacity
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Returns the car mileage
     * @return integer for car mileage
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the fuel type
     * @return String for fuel type
     */
    public String getFuelType()
    {
        return fuelType;
    }

    /**
     * Returns the car transmission
     * @return String for car transmission
     */
    public String getTransmission()
    {
        return transmission;
    }

    /**
     * Returns the car vin
     * @return String for car vin
     */
    public String getVin()
    {
        return vin;
    }

    /**
     * Returns the car price
     * @return double for car price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the cars available
     * @return integer for the cars available
     */
    public int getCarsAvailable()
    {
        return carsAvailable;
    }

    public String getHasTurbo()
    {
        return hasTurbo;
    }
    /**
     * Returns string representation of car object with all previous 
     * car attributes
     * @return formatted string of car
     */
    public String toString()
    {
        return String.format("%-5s %-15s %-18s %-10s %-8s %-9d %-15d %-12s %-12s $%-8.2f %d",
            id, carType, model, condition, color, capacity, year, fuelType, transmission, price, carsAvailable);
    }   
}

/**
 * Car type class Sedan extending from Car class
 */
class Sedan extends Car {
    /**
     * Constructs car type Sedan object with attributes
     * 
     * @param id integer of car ID 
     * @param carType String of the car type
     * @param model String of car model
     * @param condition String of car condition
     * @param color String of car color
     * @param capacity integer of car capacity
     * @param mileage integer of car mileage
     * @param fuelType String of fuel type
     * @param transmission String of car transmission
     * @param vin String of car vin
     * @param price double of car price 
     * @param carsAvailable integer of cars available
     */
    public Sedan(int id, String carType, String model, String condition, String color, int capacity, int year, String fuelType,
    String transmission, String vin, double price, int carsAvailable, String hasTurbo){
        super(id, carType, model, condition, color, capacity, year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
    }
}


/**
 *  Car type class SUV extending from Car class
 */
class SUV extends Car {
    /**
     * Constructs the car type SUV object with attributes
     * 
     * @param id integer of car ID 
     * @param carType String of the car type
     * @param model String of car model
     * @param condition String of car condition
     * @param color String of car color
     * @param capacity integer of car capacity
     * @param mileage integer of car mileage
     * @param fuelType String of fuel type
     * @param transmission String of car transmission
     * @param vin String of car vin
     * @param price double of car price 
     * @param carsAvailable integer of cars available
     */
    public SUV(int id, String carType, String model, String condition, String color, int capacity, int year, String fuelType,
    String transmission, String vin, double price, int carsAvailable, String hasTurbo){
        super(id, carType, model, condition, color, capacity, year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
    }
}



/**
 *  Car type class Hatchback extending from Car class
 */
class Hatchback extends Car {
    /**
     * Constructs the car type Hatchback object with attributes
     * @param id integer of car ID 
     * @param carType String of the car type
     * @param model String of car model
     * @param condition String of car condition
     * @param color String of car color
     * @param capacity integer of car capacity
     * @param mileage integer of car mileage
     * @param fuelType String of fuel type
     * @param transmission String of car transmission
     * @param vin String of car vin
     * @param price double of car price 
     * @param carsAvailable integer of cars available
     */
    public Hatchback(int id, String carType, String model, String condition, String color, int capacity, int year, String fuelType,
    String transmission, String vin, double price, int carsAvailable, String hasTurbo){
        super(id, carType, model, condition, color, capacity, year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
    }
}   


/**
 *  Car type class Pickup extending from Car class
 */
class Pickup extends Car {
    /**
     * Constructs the car type Pickup object with attributes
     * 
     * @param id integer of car ID 
     * @param carType String of the car type
     * @param model String of car model
     * @param condition String of car condition
     * @param color String of car color
     * @param capacity integer of car capacity
     * @param mileage integer of car mileage
     * @param fuelType String of fuel type
     * @param transmission String of car transmission
     * @param vin String of car vin
     * @param price double of car price 
     * @param carsAvailable integer of cars available
     */
    public Pickup(int id, String carType, String model, String condition, String color, int capacity, int year, String fuelType,
    String transmission, String vin, double price, int carsAvailable, String hasTurbo){
        super(id, carType, model, condition, color, capacity, year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
    }
}    