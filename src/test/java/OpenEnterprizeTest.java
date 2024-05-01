import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprizeTest {
    @Test
    void openEnterprizeTest (){
        open("https://github.com/");
        $(".header-menu-wrapper").find(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown").findBy(text("Enterprise")).find(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}
