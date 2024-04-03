/* 
Cristina Alarcon & Francisco Samaniego
March 29, 2024
CS 3331 -- Adv. Object-Oriented Programng
Dr. Gurijala
Car Dealership Project
This work was done as a team and completely on our own. We did not share, reproduce, or alter any part 
of this assignment for any purpose. We did not share code, upload this assignment online in any form, or 
view/received/modified code written from anyone else. All deliverables were produced entirely on our own. 
This assignment is part of an academic course at The University of Texas at El Paso and a grade will be assigned
for the work we produced.
*/ 


public class MineCars 
{
    public class Person 
    {
        public String name;
        public int age;
        public String address;
        private int ssn ;
    
        public Person(String newName, int newAge, String newAddress, int newSSN) 
        {
            name = newName;
            age = newAge;
            address = newAddress;
            ssn = newSSN;
        }

        // setters 
        public void setName(String nameIn) 
        {
            name = nameIn;
        }

        public void setAge(int ageIn) 
        {
            age = ageIn;
        }

        public void setAddress(String addressIn) 
        {
            address = addressIn;
        }

        public void setSSN(int ssnIn) 
        {
            ssn = ssnIn;
        }

        // getters
        public String getName() 
        {
            return name;
        }
    
        public int getAge() 
        {
            return age;
        }
    
        public String getAddress() 
        {
            return address;
        }

        public int getSSN() 
        {
           return ssn;
        }
    }   

    public class User 
    {
        public String username;
        public int customerID;
        public int creditScore;
        
        public User(String newUsername, int newCustomerID, int newCreditScore) 
        {
            username = newUsername;
            customerID = newCustomerID;
            creditScore = newCreditScore;
            
        }

        /** Setters */
        public void setUsername(String newUsername)
        {
            username = newUsername;
        }

        public void setCustomerID(int newID)
        {
            customerID = newID;
        }

        public void setCreditScore(int newCreditScore)
        {
            creditScore = newCreditScore;
        }

        public String getUsername()
        {
            return username;
        }

        public int getCustomerID()
        {
            return customerID;
        }

        public int getCreditScore()
        {
            return creditScore;
        }
       
        
    }
        
    public class Admin 
    {
        public String username;
        public int employeeID;
        
        public Admin(String newUsername, int employeeID) 
        {
            username = newUsername;
            this.employeeID = employeeID;        
        }

        /** Setters  */
        public void setUsername(String newUsername)
        {
            username = newUsername;
        }

        public void setEmployeeID(int newID)
        {
            employeeID = newID;
        }

        /** Getters */
        public String getUsername()
        {
            return username;
        }

        public int getEmployeeID()
        {
            return employeeID;
        }

        
    }

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

    public class Log 
    {
        // attributes

        // setters & getters
    }

    public class RunShop 
    {
        // attributes

        // setters & getters
    }
}
