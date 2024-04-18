package tests.junit;

import org.junit.Test;
import pages.booking.BookingParisTask;

import static org.junit.Assert.assertEquals;

public class BookingParisTest {
    BookingParisTask bookingMainPage = new BookingParisTask();
    final double HOTEL_SCORE_EXPECTED = 6.0;

    @Test
    public void ratingTest() {
        bookingMainPage.openBooking();
        bookingMainPage.inputCity();
        bookingMainPage.inputPersons();
        bookingMainPage.inputDate();
        bookingMainPage.clickSearchButton();
        bookingMainPage.checkboxRatingEnable();
        bookingMainPage.sortingEnable();
        assertEquals(String.format("Rating of first hotel is not %s", HOTEL_SCORE_EXPECTED),
                String.format("Scored %s", HOTEL_SCORE_EXPECTED), bookingMainPage.getRating());
    }
}
