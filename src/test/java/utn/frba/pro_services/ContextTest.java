package utn.frba.pro_services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;

public class ContextTest implements SimplePersistenceTest {
    @Test
    void contextUp() {
        assertNotNull(entityManager());
    }

    @Test
    void contextUpWithTransaction() throws Exception {
        withTransaction(() -> {
        });
    }
}
