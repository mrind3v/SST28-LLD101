import java.util.*;

public class BookingRequest {
    public final RoomType roomType;
    public final List<AddOnType> addOns;

    public BookingRequest(RoomType roomType, List<AddOnType> addOns) {
        this.roomType = roomType;
        this.addOns = addOns;
    }
}
