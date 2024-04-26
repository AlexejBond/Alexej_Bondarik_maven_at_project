package tests.junit;

import org.junit.Test;
import pages.booking.BookingHomePageXpath;
import pages.booking.BookingSearchPageXPath;

import static org.junit.Assert.assertEquals;

public class BookingJUnitTest {

    private BookingHomePageXpath bookingHomePageXpath = new BookingHomePageXpath();
    private BookingSearchPageXPath bookingSearchPageXPath = new BookingSearchPageXPath();

    @Test
    public void bookingParisRating6PlusTest() {
        bookingHomePageXpath.openBookingHomePage();
        bookingHomePageXpath.acceptCookies();
        bookingHomePageXpath.closeSignInPopup();
        bookingHomePageXpath.selectCityViaEnter("Париж");
//        bookingHomePageXpath.inputCityViaAutocomplete("Париж");
        bookingHomePageXpath.selectDaysForStay(3, 10);
        bookingHomePageXpath.selectAdultsChildrenRooms(4, 0, 2);
        bookingHomePageXpath.clickSearchButton();
        bookingSearchPageXPath.selectReviewScore6Plus();
        bookingSearchPageXPath.sortingLowToHigh();
        bookingSearchPageXPath.getRatingFirstOnList();

        assertEquals("Rating of first hotel is not as expected.", 6.0, bookingSearchPageXPath.getRatingFirstOnList());
    }


}

