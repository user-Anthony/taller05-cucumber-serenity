package calculator.actions;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class MainScreen {
    public static Target fiveButton = Target.the("[5] button").located(By.id("com.android.calculator2:id/digit_5"));
    public static Target sevenButton = Target.the("[7] button").located(By.id("com.android.calculator2:id/digit_7"));
    public static Target addButton = Target.the("[+] button").located(By.id("com.android.calculator2:id/op_add"));
    public static Target equalButton = Target.the("[=] button").located(By.id("com.android.calculator2:id/eq"));


}


/*
*
    public Label resultLabel = new Label(By.id("com.android.calculator2:id/result"));
}
* */