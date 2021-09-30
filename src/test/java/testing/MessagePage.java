package testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage extends Base {

    public MessagePage (){
        PageFactory.initElements(driver, this);
    }

    public @FindBy(id = "cf_name")
    WebElement fieldNameLastName;

    public @FindBy(id = "cf_email")
    WebElement fieldEmail;

    public @FindBy(name = "cf_message")
    WebElement messageContent;

    public @FindBy(css = ".button_blue.middle_btn.kontaktsalji")
    WebElement sendButton;

    public @FindBy(className = "page_title")
    WebElement scrolling;

    public void insertName(String ime){
        fieldNameLastName.clear();
        fieldNameLastName.sendKeys(ime);
    }
    public void insertEmail(String email){
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
    }
    public void typeMessage(String message){
        messageContent.clear();
        messageContent.sendKeys(message);
    }
    public void pressPosalji(){
        sendButton.click();

    }

}


