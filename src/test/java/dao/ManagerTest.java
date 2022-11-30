package dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager();

    @Test
    void createDeliveryManager() {
        assertNotNull( manager.addDeliveryManager("Dmanager", "123456"));
    }

}