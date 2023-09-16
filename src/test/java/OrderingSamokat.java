package tests;

import pageobject.OrderPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class OrderingSamokat extends tests.ChoiceBrowser {

    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    //задали переменные для теста
    boolean upButton;
    String name;
    String surname;
    String adress;
    String metroStation;
    String number;
    int Time;
    String comment;
    String colour;

    public OrderingSamokat(boolean upButton, String name, String surname, String adress, String metroStation, String number, int Time, String comment, String colour) {
        this.upButton = upButton;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.number = number;
        this.Time = Time;
        this.comment = comment;
        this.colour = colour;
    }



    @Parameterized.Parameters
    public static Object[] getInfo() {
        return new Object[][]{
                {true, "Ярослав", "Червонящий", "Ватутина 4", "56", "89969999999", 1, "Проверка №1", "black"},

                {false, "Настя", "Червонящая", "Ватутина 4", "56", "89969999998", 2, "Проверка №1", "grey"},
        };
    }

    //@Before


    @Test
    public void checkScooterOrder() {
        driver.get(URL);
        OrderPage orderpage = new OrderPage(driver);

        orderpage.clickCookie();
        orderpage.clickOderButton(upButton);
        orderpage.login(name, surname, adress, number);
        orderpage.clickUndegroundList(metroStation);
        orderpage.clickNextButton();
        orderpage.setOrderDate();
        orderpage.setPeriod(Time);
        orderpage.setColour(colour);
        orderpage.setComment(comment);
        orderpage.clickOrderFormButton();
        orderpage.clickYesButton();
        orderpage.setConfirmationButton();
        orderpage.getConfirmationInfo();
    }

}