package whenDo;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DeleteTaskScreen {

    public static Target itemDelete = Target.the("[delete] itemDelete").located(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public static Target confirmDelete = Target.the("[confirmation delete] confirm").located(By.xpath("//android.widget.Button[@text=\"DELETE\"]"));
}
