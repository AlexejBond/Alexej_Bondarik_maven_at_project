package tests.junit;

import org.junit.After;
import org.junit.Test;
import pages.booking.BookingParisTask;

import static org.junit.Assert.assertEquals;

public class BookingParisTest {
    BookingParisTask bookingParisTask = new BookingParisTask();
    final double HOTEL_SCORE_EXPECTED = 6.0;

    @Test
    public void ratingTest() {
        bookingParisTask.openBooking();
        bookingParisTask.inputCity();
        bookingParisTask.inputPersons();
        bookingParisTask.inputDate();
        bookingParisTask.clickSearchButton();
        bookingParisTask.checkboxRatingEnable();
        bookingParisTask.sortingEnable();
        assertEquals(String.format("Rating of first hotel is not %s", HOTEL_SCORE_EXPECTED),
                String.format("Scored %s", HOTEL_SCORE_EXPECTED), bookingParisTask.getRating());
    }

}
