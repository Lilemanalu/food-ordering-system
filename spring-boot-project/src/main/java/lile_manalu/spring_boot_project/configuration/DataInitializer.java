package lile_manalu.spring_boot_project.configuration;

import lile_manalu.spring_boot_project.entity.*;
import lile_manalu.spring_boot_project.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;

import static org.slf4j.LoggerFactory.getLogger;

@Slf4j
@Configuration
public class DataInitializer {

    private static final Logger logger = getLogger(DataInitializer.class);

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private AddOnRepository addOnRepository;

    @Autowired
    private FoodSnapshotRepository foodSnapshotRepository;

    @Autowired
    private AddOnSnapshotRepository addOnSnapshotRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private OutletRepository outletRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            try {
                // Insert data into Food table
                foodRepository.save(new Food("1", "1", "Pizza", "Delicious cheese pizza", 10.99));
                foodRepository.save(new Food("2", "1", "Burger", "Juicy beef burger", 8.99));
                foodRepository.save(new Food("3", "2", "Pasta", "Creamy Alfredo pasta", 12.99));
                foodRepository.save(new Food("4", "2", "Salad", "Fresh green salad", 7.99));
                foodRepository.save(new Food("5", "3", "Sushi", "Assorted sushi platter", 15.99));
                logger.info("Food data initialized");

                // Insert data into AddOn table
                addOnRepository.save(new AddOn("1", "1", "Extra Cheese", "Additional cheese on pizza", 1.99));
                addOnRepository.save(new AddOn("2", "2", "Bacon", "Crispy bacon strips", 2.49));
                addOnRepository.save(new AddOn("3", "3", "Garlic Bread", "Crispy garlic bread", 3.99));
                addOnRepository.save(new AddOn("4", "4", "Croutons", "Crunchy croutons for salad", 1.49));
                addOnRepository.save(new AddOn("5", "5", "Wasabi", "Spicy wasabi", 0.99));
                logger.info("AddOn data initialized");

                // Insert data into FoodSnapshot table
                foodSnapshotRepository.save(new FoodSnapshot("1", "1", "1", "1", "Pizza", "Delicious cheese pizza", 10.99, new Date()));
                foodSnapshotRepository.save(new FoodSnapshot("2", "2", "2", "2", "Burger", "Juicy beef burger", 8.99, new Date()));
                foodSnapshotRepository.save(new FoodSnapshot("3", "3", "3", "3", "Pasta", "Creamy Alfredo pasta", 12.99, new Date()));
                foodSnapshotRepository.save(new FoodSnapshot("4", "4", "4", "4", "Salad", "Fresh green salad", 7.99, new Date()));
                foodSnapshotRepository.save(new FoodSnapshot("5", "5", "5", "5", "Sushi", "Assorted sushi platter", 15.99, new Date()));
                logger.info("FoodSnapshot data initialized");

                // Insert data into AddOnSnapshot table
                addOnSnapshotRepository.save(new AddOnSnapshot("1", "1", "1", "Extra Cheese", "Additional cheese on pizza", 1.99, new Date()));
                addOnSnapshotRepository.save(new AddOnSnapshot("2", "2", "2", "Bacon", "Crispy bacon strips", 2.49, new Date()));
                addOnSnapshotRepository.save(new AddOnSnapshot("3", "3", "3", "Garlic Bread", "Crispy garlic bread", 3.99, new Date()));
                addOnSnapshotRepository.save(new AddOnSnapshot("4", "4", "4", "Croutons", "Crunchy croutons for salad", 1.49, new Date()));
                addOnSnapshotRepository.save(new AddOnSnapshot("5", "5", "5", "Wasabi", "Spicy wasabi", 0.99, new Date()));
                logger.info("AddOnSnapshot data initialized");

                // Insert data into Order table
                orderRepository.save(new Order("1", "1", "1", new Date()));
                orderRepository.save(new Order("2", "2", "2", new Date()));
                orderRepository.save(new Order("3", "3", "3", new Date()));
                orderRepository.save(new Order("4", "4", "4", new Date()));
                orderRepository.save(new Order("5", "5", "5", new Date()));
                logger.info("Order data initialized");

                // Insert data into User table
                userRepository.save(new User("1", "John Doe"));
                userRepository.save(new User("2", "Jane Doe"));
                userRepository.save(new User("3", "Alice Smith"));
                userRepository.save(new User("4", "Bob Johnson"));
                userRepository.save(new User("5", "Charlie Brown"));
                logger.info("User data initialized");

                // Insert data into Merchant table
                merchantRepository.save(new Merchant("1", "Merchant A", "Description of Merchant A"));
                merchantRepository.save(new Merchant("2", "Merchant B", "Description of Merchant B"));
                merchantRepository.save(new Merchant("3", "Merchant C", "Description of Merchant C"));
                merchantRepository.save(new Merchant("4", "Merchant D", "Description of Merchant D"));
                merchantRepository.save(new Merchant("5", "Merchant E", "Description of Merchant E"));
                logger.info("Merchant data initialized");

                // Insert data into Outlet table
                outletRepository.save(new Outlet("1", "1", "Outlet A", "Description of Outlet A"));
                outletRepository.save(new Outlet("2", "2", "Outlet B", "Description of Outlet B"));
                outletRepository.save(new Outlet("3", "3", "Outlet C", "Description of Outlet C"));
                outletRepository.save(new Outlet("4", "4", "Outlet D", "Description of Outlet D"));
                outletRepository.save(new Outlet("5", "5", "Outlet E", "Description of Outlet E"));
                logger.info("Outlet data initialized");

            } catch (Exception e) {
                logger.error("Error during data initialization", e);
            }
        };
    }

}
