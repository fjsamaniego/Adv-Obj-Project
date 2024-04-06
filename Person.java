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

public class Person {
    private String username;
    private String password;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
    } 

    // setters 
    public void setName(String nameIn) 
    {
        this.username = nameIn;
    }

    public void setPassword(String passwordIn) 
    {
        this.username = passwordIn;
    }


    // getters
    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }

}   

