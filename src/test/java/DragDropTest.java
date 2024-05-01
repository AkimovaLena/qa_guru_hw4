import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {

    @BeforeAll
    static void settingsBeforeAll(){
        Configuration.baseUrl="https://the-internet.herokuapp.com";
    }
   @Test
    void dragDropActionsTest(){
       open("/drag_and_drop");
       $("#column-a").shouldHave(text("A"));
       $("#column-b").shouldHave(text("B"));
       actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
       $("#column-a").shouldHave(text("B"));
       $("#column-b").shouldHave(text("A"));
   }

    @Test
    void dragDropSelenoideTest(){
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
