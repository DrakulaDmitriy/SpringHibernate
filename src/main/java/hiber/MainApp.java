package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Алексей", "Вольский", "Alex98spb@mail.ru",new Car("BMW",312)));
        userService.add(new User("Борис", "Рыбак", "Boris777@mail.ru",new Car("Lada",515)));
        userService.add(new User("Екатерина", "Чайковская", "katChay3@mail.ru",new Car("Audi",121)));
        userService.add(new User("Игорь", "Шмыгрь", "anonimus74ru4@mail.ru",new Car("Ford",891)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        System.out.println("\nHere's what we found for your request----> "+ userService.getUserByCar("Ford",891));
        context.close();
    }
}
