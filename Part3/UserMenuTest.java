import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public class UserMenuTest {
    
    private List<Car> cars;
    private List<User> users;
    private User currentUser;
    private UserMenu userMenu;

    @BeforeEach
    public void setUp() {
        // cars and users based on the provided data
        cars = new ArrayList<>();
        cars.add(new Car(1, "SUV", "Toyota", "New", "Black", 5, 2022, "Gas", "Automatic", "VIN1234", 30000.35, 5, "Yes"));
        cars.add(new Car(2, "Sedan", "Honda", "New", "White", 4, 2021, "Gas", "Automatic", "VIN5678", 25000.55, 1, "No"));
        cars.add(new Car(3, "Truck", "Ford", "Used", "Blue", 6, 2019, "Diesel", "Automatic", "VIN91011", 35000.03, 1, "Yes"));

        users = new ArrayList<>();
        currentUser = new User(1, "John", "Doe", 5000.0, 0, false, "john", "password");

        // UserMenu with the loaded data
        userMenu = new UserMenu(cars, users, currentUser, "userFile", "carFile");
    }
    

    @Test
    public void testPurchaseCar() {
        // set currentUser's money available
        currentUser.setMoneyAvailable(35000.03);

        // purchase a car
        userMenu.purchaseCar();

        // the currentUser's money available is updated
        assertEquals(2000, currentUser.getMoneyAvailable());

        // the car's availability is updated
        assertEquals(4, cars.get(0).getCarsAvailable());
    }

    @Test
    public void testReturnCar() {
        currentUser.getPurchasedCars().add(cars.get(1));

        // set currentUser's money available
        currentUser.setMoneyAvailable(20000);

        // return the purchased car
        userMenu.returnCar();

        // the currentUser's money available is updated
        assertEquals(5000, currentUser.getMoneyAvailable());

        // the car's availability is updated
        assertEquals(2, cars.get(1).getCarsAvailable());
    }

    @Test
    public void testViewTickets() {
        // add a purchased car to the currentUser's list
        currentUser.getPurchasedCars().add(cars.get(2));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // call viewTickets
        userMenu.viewTickets();

        // that the printed output contains the ticket information
        assertTrue(outputStream.toString().contains("Car Type: Truck"));
        assertTrue(outputStream.toString().contains("Model: Ford"));
        assertTrue(outputStream.toString().contains("Color: Blue"));
    }

}
