package tests.junit;

import org.junit.After;
import org.junit.Test;
import pages.booking.BookingHomePageXpath;
import pages.booking.BookingParisTask;
import pages.booking.BookingSearchPageXPath;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private BookingHomePageXpath bookingHomePageXpath = new BookingHomePageXpath();
    private BookingSearchPageXPath bookingSearchPageXPath = new BookingSearchPageXPath();
    final double HOTEL_SCORE_EXPECTED = 6.0;

    @Test
    public void bookingParisRating6PlusTest() {
        bookingHomePageXpath.openBookingHomePage();
        bookingHomePageXpath.inputCityViaAutocomplete("Париж");
        bookingHomePageXpath.selectDaysForStay(2, 1);
        bookingHomePageXpath.selectAdultsChildrenRooms(4, 0, 2);
        bookingHomePageXpath.clickSearchButton();
        bookingSearchPageXPath.selectReviewScore6Plus();
        bookingSearchPageXPath.sortingLowToHigh();
        bookingSearchPageXPath.getRatingFirstOnList();

        assertEquals(String.format("Rating of first hotel is not %s", HOTEL_SCORE_EXPECTED),
                String.format("Scored %s", HOTEL_SCORE_EXPECTED), bookingSearchPageXPath.getRatingFirstOnList());
    }

}
