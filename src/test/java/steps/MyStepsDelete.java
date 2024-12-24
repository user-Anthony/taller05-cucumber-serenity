package steps;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import whenDo.CreateTaskScreen;
import whenDo.DeleteTaskScreen;
import whenDo.ListViewScreen;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class MyStepsDelete {

//    @Before
//    public void createDriver(){
//        OnStage.setTheStage(new OnlineCast());
//        System.out.println("Se inicia por primera vez");
//    }

    @Given("{actor1} agrega una tarea e ingresa un titulo de tarea {string}")
    public void elQaAgregaUnaTareaEIngresaUnTituloDeTarea(Actor actor1, String title) {
        actor1.attemptsTo(Click.on(ListViewScreen.addTaskButton));
        actor1.attemptsTo(SendKeys.of(title).into(CreateTaskScreen.titleTxtBox));
    }

    @And("{actor1} ingresa una descripcion de tarea {string}")
    public void elQaIngresaUnaDescripcionDeTarea(Actor actor1, String note) {
        actor1.attemptsTo(SendKeys.of(note).into(CreateTaskScreen.noteTxtBox));
    }

    @And("{actor1} guarda la tarea")
    public void elQaGuardaLaTarea(Actor actor) {
        actor.attemptsTo(Click.on(CreateTaskScreen.saveButton));
    }

    @And("{actor1} verfica que la tarea se creo correctamente como {string}")
    public void elQaVerficaQueLaTareaSeCreoCorrectamenteComo(Actor actor1, String expectedResult) {
        actor1.should(
                seeThat("verify task", Text.of(ListViewScreen.taskLabel),equalTo(expectedResult))
        );
    }

    @When("{actor1} ingresa a la tarea {string}")
    public void elQaIngresaALaTarea(Actor actor1, String title) {
        actor1.attemptsTo(Click.on(ListViewScreen.taskLabel));
    }

    @And("{actor1} da click en eliminar")
    public void elQaDaClickEnEliminar(Actor actor1) {
        actor1.attemptsTo(Click.on(DeleteTaskScreen.itemDelete));
    }

    @And("{actor1} confirma la eliminacion")
    public void elQaConfirmaLaEliminacion(Actor actor1) {
        actor1.attemptsTo(Click.on(DeleteTaskScreen.confirmDelete));
    }

    @Then("{actor1} tiene que visualizar el texto {string}")
    public void elQaTieneQueVisualizarElTexto(Actor actor1, String expectedResult) {
        actor1.should(
                seeThat("verify tasks", Text.of(ListViewScreen.getNote),equalTo(expectedResult))
        );
    }
    @ParameterType(".*")
    public Actor actor1(String name){
        return OnStage.theActorCalled(name);
    }


}
