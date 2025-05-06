package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.Properties;

import static config.TestConfig.BASE_PATH;
import static config.TestConfig.BASE_URI;

public class BaseTest {

    @BeforeAll
    public static void setup() throws IOException {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
    }
}
