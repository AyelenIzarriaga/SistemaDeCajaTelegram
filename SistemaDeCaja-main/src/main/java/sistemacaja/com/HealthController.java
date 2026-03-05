package sistemacaja.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HealthController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/health")
    public String health() {
        try (Connection conn = dataSource.getConnection()) {

            if (conn.isValid(2)) {
                return "BOT_OK | DB_OK";
            } else {
                return "BOT_OK | DB_FAIL";
            }

        } catch (Exception e) {
            return "BOT_OK | DB_ERROR";
        }
    }
}
