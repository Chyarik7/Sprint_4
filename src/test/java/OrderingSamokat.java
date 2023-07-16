import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderingSamokat extends ChoiceBrowser {

//Тест заказа через кнопку в хэдере
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookiesButton()
                .clickHOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Ярослав")
                .sendClientLastName("Червонящий")
                .sendDeliveryAddress("Пенза, Ватутина, 4")
                .selectMetroStation("Черкизовская")
                .sendDeliveryClientPhoneNumber("89968988989")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("15.07.2023")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Привезите полность заряженный аппарат")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Окно заказа не появилось, попробуем ещё раз", isDisplayed);
    }
//Тест заказа через кнопку в середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookiesButton()
                .clickMOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Настя")
                .sendClientLastName("Червонящая")
                .sendDeliveryAddress("Пенза, Мира, 65")
                .selectMetroStation("Митино")
                .sendDeliveryClientPhoneNumber("89968988990")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("14.07.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Буду кататься с детьми")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Окно заказа не появилось, заказать немогу", isDisplayed);
    }
}