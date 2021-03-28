package element_wrapper;

import org.openqa.selenium.*;

public class Element extends BaseElement {


    public Element(WebElement webelement, By locator) {
        super(webelement, locator);
    }

    public Element(By locator) {
        super(locator);
    }

    public Element(String xpath) {
        super(xpath);
    }
}
