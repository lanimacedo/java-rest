package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    public static final String BASE_URI;
    public static final String BASE_PATH;

    static {
        Properties props = new Properties();

        String environment = System.getProperty("env", "prod"); // padrao dev

        String configFileName = String.format("config-%s.properties", environment);

        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(configFileName)) {

            if( input == null) {
                throw new RuntimeException("Arquivo de configuração não encontrado: " + configFileName);
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao carregar" + configFileName, e);
        }

        BASE_URI = props.getProperty("base.uri");
        BASE_PATH = props.getProperty("base.path");

    }

}
