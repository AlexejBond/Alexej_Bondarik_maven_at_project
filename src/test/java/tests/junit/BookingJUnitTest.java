package tests.junit;

import org.junit.Test;
import pages.booking.BookingHomePageXpath;
import pages.booking.BookingSearchPageXPath;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BookingJUnitTest {

    private BookingHomePageXpath bookingHomePageXpath = new BookingHomePageXpath();
    private BookingSearchPageXPath bookingSearchPageXPath = new BookingSearchPageXPath();

    @Test
    public void bookingParisRating6PlusTest() {
        int checkInDay = LocalDate.now().plusDays(2).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(7).getDayOfMonth();

        bookingHomePageXpath.openBookingHomePage();
        bookingHomePageXpath.acceptCookies();
        bookingHomePageXpath.closeSignInPopup();
        bookingHomePageXpath.inputAndSelectCityViaEnter("Париж");
//        bookingHomePageXpath.inputCityViaAutocomplete("Париж");
        bookingHomePageXpath.selectDaysForStay(checkInDay, checkOutDay);
        bookingHomePageXpath.selectAdultsChildrenRooms(4, 0, 2);
        bookingHomePageXpath.clickSearchButton();
        bookingSearchPageXPath.selectReviewScore6Plus();
        bookingSearchPageXPath.sortingLowToHigh();
        bookingSearchPageXPath.getRatingFirstOnList();

        assertEquals("Rating of first hotel is not as expected.", 6.0, bookingSearchPageXPath.getRatingFirstOnList());
    }


}

