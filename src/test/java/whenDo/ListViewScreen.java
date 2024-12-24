package whenDo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ListViewScreen {
    public static Target addTaskButton = Target.the("[+] button").located(By.id("com.vrproductiveapps.whendo:id/fab"));
    public static Target taskLabel = Target.the("[name task] label").located(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public static Target getNote = Target.the("[task added]").located(By.id("com.vrproductiveapps.whendo:id/noNotesText"));

}


