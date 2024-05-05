package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.booking.BookingHomePageXpath;
import pages.booking.BookingSearchPageXPath;

import static org.junit.Assert.assertEquals;

public class BookingTestNGTest {

    private BookingHomePageXpath bookingHomePageXpath = new BookingHomePageXpath();
    private BookingSearchPageXPath bookingSearchPageXPath = new BookingSearchPageXPath();
    final double FIRST_HOTEL_SCORE_EXPECTED = 6.0;

    @Test
    public void bookingParisRating6PlusTest() {
        bookingHomePageXpath.openBookingHomePage();
        bookingHomePageXpath.acceptCookies();
        bookingHomePageXpath.closeSignInPopup();
//        bookingHomePageXpath.selectCityViaEnter("Париж");
        bookingHomePageXpath.inputCityViaAutocomplete("Париж");
        bookingHomePageXpath.selectDaysForStay(3, 10);
        bookingHomePageXpath.selectAdultsChildrenRooms(4, 0, 2);
        bookingHomePageXpath.clickSearchButton();
        bookingSearchPageXPath.selectReviewScore6Plus();
        bookingSearchPageXPath.sortingLowToHigh();
        bookingSearchPageXPath.getRatingFirstHotelOnList();

        Assert.assertEquals(bookingSearchPageXPath.getRatingFirstHotelOnList(), 6.0, "Rating of first hotel is not as " +
                "expected.");
    }
}
