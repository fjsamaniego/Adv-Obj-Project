/* 
Cristina Alarcon & Francisco Samaniego
April 5, 2024
CS 3331 -- Adv. Object-Oriented Programng
Dr. Gurijala
Car Dealership Project
This work was done as a team and completely on our own. We did not share, reproduce, or alter any part 
of this assignment for any purpose. We did not share code, upload this assignment online in any form, or 
view/received/modified code written from anyone else. All deliverables were produced entirely on our own. 
This assignment is part of an academic course at The University of Texas at El Paso and a grade will be assigned
for the work we produced.
*/ 

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

