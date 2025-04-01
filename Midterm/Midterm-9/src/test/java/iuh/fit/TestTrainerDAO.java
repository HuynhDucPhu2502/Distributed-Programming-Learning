package iuh.fit;

import iuh.fit.dao.TrainerDAO;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Admin 3/31/2025
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTrainerDAO {
    private TrainerDAO trainerDAO;

    @BeforeAll
    void setup() {
        trainerDAO = new TrainerDAO();
    }

    @AfterAll
    void teardown() {
        trainerDAO = null;
    }

}
