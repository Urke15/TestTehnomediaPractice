package testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;



public class TestTehnomedia extends Base {

    KontaktPage firstClass;
    MessagePage workingClass;

    @Before

    public void setUpPage() {
        firstClass = new KontaktPage();
        workingClass = new MessagePage();
    }

    @Test

    public void sendingMessage(){
        //successfully sent message with filled  all mandatory fields
//uspeno je poslata poruka sa svim popunjenim obaveznim poljima
        firstClass.clickContact();
        //komanda za skrolovanje na tacno odredjeni element
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", workingClass.scrolling);
        workingClass.insertName("Petar Petrovic");
        workingClass.insertEmail("petar.p@gmail.com");
        workingClass.typeMessage("Hteo bih da porucim televizor marke Samsung.");
        workingClass.pressPosalji();

    }
@Test

public void sendingMessageWithoutName(){
        //the site does not work well, it sends the message with blank name and last name field
//sajt ne radi ispravno, prihvata prazno polje za ime i prezime i salje poruku uspesno iako je Ime obavezno polje
    firstClass.clickContact();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", workingClass.scrolling);
    workingClass.insertName("");
    workingClass.insertEmail("petar.p@gmail.com");
    workingClass.typeMessage("Hteo bih da porucim televizor marke Samsung.");
    workingClass.pressPosalji();
}

@Test

public void sendingMessageWIthoutEmail() {
        //the site does not work well, it sends the message with blank Email field
//salje se poruka bez popunjene email adrese koja je obavezno polje, test je pao jer je ocekivano da se ne posalje poruka
        firstClass.clickContact();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", workingClass.scrolling);
        workingClass.insertName("Petar Petrovic");
        workingClass.insertEmail("");
        workingClass.typeMessage("Hteo bih da porucim televizor marke Samsung.");
        workingClass.pressPosalji();
    }

    @Test
    public void sendingMessageWithoutTypingMessage() {
        //the site does not work well, it sends the message with blank text message field
//salje se poruka bez ispunjenog obaveznog polja za unos poruke, test prolazi iako ne bi trebalo da prolazi
        firstClass.clickContact();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", workingClass.scrolling);
        workingClass.insertName("Petar Petrovic");
        workingClass.insertEmail("petar.p@gmail.com");
        workingClass.typeMessage("");
        workingClass.pressPosalji();
    }
@Test
public void sendingMessageWithBlankMandatoryFields() {
        //the site does not work well, it sends the message with blank all mandatory fields
//poruka je poslata iako nije popunjeno nijedno obavezno polje, test je prosao iako ne bi trebalo da prodje
    firstClass.clickContact();
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", workingClass.scrolling);
    workingClass.insertName("");
    workingClass.insertEmail("");
    workingClass.typeMessage("");
    workingClass.pressPosalji();

}
@Test

    public void checkingLogoVisibility(){

    Assert.assertTrue(firstClass.displayedLogo());

}

@Test

    public void checkingIfTheLinkKontaktShowed(){

        Assert.assertEquals("Kontakt", firstClass.displayedKontakt());

}


}