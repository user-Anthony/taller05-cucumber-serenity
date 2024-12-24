package calculatorTest;

import calculator.actions.MainScreen;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.findby.By;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import whenDo.CreateTaskScreen;
import whenDo.ListViewScreen;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class CalculatorTest {

    @BeforeEach
    public void before(){
       OnStage.setTheStage(new OnlineCast());
    }


    @Test
    public void suma(){
        theActorCalled("JBGroup").attemptsTo(Click.on(MainScreen.sevenButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen.addButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen.fiveButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen.equalButton));

        theActorInTheSpotlight().should(
              seeThat("Verify the result is: ",
                      Text.of(By.id("com.android.calculator2:id/result")),
                      equalTo("12"))
        );
    }




    @AfterEach
    public void after(){

    }
}
