package calculatorTest;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import whenDo.CreateTaskScreen;
import whenDo.DeleteTaskScreen;
import whenDo.ListViewScreen;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenTest {

    @BeforeEach
    public void before(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void when(){
        theActorCalled("QA").attemptsTo(Click.on(ListViewScreen.addTaskButton));
        theActorInTheSpotlight().attemptsTo(SendKeys.of("Tarea 1").into(CreateTaskScreen.titleTxtBox));
        theActorInTheSpotlight().attemptsTo(SendKeys.of("Nota 1").into(CreateTaskScreen.noteTxtBox));
        theActorInTheSpotlight().attemptsTo(Click.on(CreateTaskScreen.saveButton));
        theActorInTheSpotlight().should(
                seeThat(
                        "verify",
                        Text.of(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")),
                        equalTo("Tarea 1")
                )
        );
        theActorInTheSpotlight().attemptsTo(Click.on(ListViewScreen.taskLabel));
        theActorInTheSpotlight().attemptsTo(Click.on(DeleteTaskScreen.itemDelete));
        theActorInTheSpotlight().attemptsTo(Click.on(DeleteTaskScreen.confirmDelete));
        theActorInTheSpotlight().should(
                seeThat(
                        "verify",
                        Text.of(By.id("com.vrproductiveapps.whendo:id/noNotesText")),
                        equalTo("No tasks added")
                )

        );
    }
}
