package whenDo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class CreateTaskScreen {

    public static Target titleTxtBox = Target.the("[title] textbox").located(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public static Target noteTxtBox = Target.the("[note] textbox").located(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public static Target saveButton = Target.the("[save] button").located(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
