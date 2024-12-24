package steps;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import whenDo.CreateTaskScreen;
import whenDo.ListViewScreen;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class MyStepsCreate {

    @Before
    public void createDriver(){
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("{actor} has access to whendo")
    public void eynarHasAccessToWhendo(Actor actor) {
    }

    @When("{actor} creates a task")
    public void heCreatesATask(Actor actor, Map<String,String> data) {
        actor.attemptsTo(Click.on(ListViewScreen.addTaskButton));
        actor.attemptsTo(SendKeys.of(data.get("title")).into(CreateTaskScreen.titleTxtBox));
        actor.attemptsTo(SendKeys.of(data.get("note")).into(CreateTaskScreen.noteTxtBox));
        actor.attemptsTo(Click.on(CreateTaskScreen.saveButton));

    }

    @Then("{actor} expected the task {string} should be displayed")
    public void heExpectedTheTaskShouldBeDisplayed(Actor actor,String expectedResult) {
        actor.should(
            seeThat("verify task", Text.of(ListViewScreen.taskLabel),equalTo(expectedResult))
        );
    }

    @ParameterType(".*")
    public Actor actor(String name){
        return OnStage.theActorCalled(name);
    }
}
