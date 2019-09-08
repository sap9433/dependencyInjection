import java.util.List;

public class Booking {
    @IncludePrint
    private long bookingId;
    @IncludePrint
    private String description;
    private List<String> dontPrint;

    public Booking(long bookingId, String description, List<String> dontPrint) {

        this.bookingId = bookingId;
        this.description = description;
        this.dontPrint = dontPrint;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDontPrint() {
        return dontPrint;
    }

    public void setDontPrint(List<String> dontPrint) {
        this.dontPrint = dontPrint;
    }
}
