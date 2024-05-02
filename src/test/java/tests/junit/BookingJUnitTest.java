package tests.junit;

import org.junit.Test;
import pages.booking.BookingHomePageSignInXpath;
import pages.booking.BookingHomePageXpath;
import pages.booking.BookingSearchPageXPath;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BookingJUnitTest {

    private BookingHomePageXpath bookingHomePageXpath = new BookingHomePageXpath();
    private BookingHomePageSignInXpath bookingSignInPageXpath = new BookingHomePageSignInXpath();
    private BookingSearchPageXPath bookingSearchPageXPath = new BookingSearchPageXPath();

    @Test
    public void bookingParisRating6PlusTest() {

        bookingHomePageXpath.openBookingHomePage();
        bookingHomePageXpath.acceptCookies();
        bookingHomePageXpath.closeSignInPopup();
        bookingHomePageXpath.inputAndSelectCityViaEnter("Париж");
//        bookingHomePageXpath.inputCityViaAutocomplete("Париж");
        bookingHomePageXpath.selectDaysForStay(30, 36);
        bookingHomePageXpath.selectAdultsChildrenRooms(4, 0, 2);
        bookingHomePageXpath.clickSearchButton();
        bookingSearchPageXPath.selectReviewScore6Plus();
        bookingSearchPageXPath.sortingLowToHigh();
        bookingSearchPageXPath.getRatingFirstOnList();

        assertEquals("Rating of first hotel is not as expected.", 6.0, bookingSearchPageXPath.getRatingFirstOnList());
    }


    @Test
    public void bookingLogInAndMadridInFavoriteTest() throws InterruptedException {
        bookingHomePageXpath.openBookingHomePage();
        bookingHomePageXpath.acceptCookies();
        bookingHomePageXpath.closeSignInPopup();
        bookingHomePageXpath.clickSignInButton();
        bookingSignInPageXpath.enterEmailToLogin("chuck.norris.autotest@gmail.com");
        bookingSignInPageXpath.enterPasswordToLogin("Chuck_Norris_777");
        bookingSignInPageXpath.submitLoginButton();
//        bookingSignInPageXpath.clickAndHoldHumanConfirmButton();
        bookingHomePageXpath.inputAndSelectCityViaEnter("Мадрид");
        bookingHomePageXpath.selectDaysForStay(30,40);
        bookingHomePageXpath.clickSearchButton();
        bookingHomePageXpath.addToFavoritesFirstAndLastHotelInTheList();
        bookingHomePageXpath.returnColorValue();



    }


}

