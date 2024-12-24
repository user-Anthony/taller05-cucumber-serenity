package steps;


import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        plugin =  {"pretty"},
        features = "src/test/resources",
        glue ={"steps"}
)
public class SerennityRunnerTest {
}
