package sg.edu.rp.c36.id21028831.carparkavailability;

public class Availability {
    public int total_lots;
    public String lot_type;
    public int lots_available;

    public Availability(int total_lots, String lot_type, int lots_available) {
        this.total_lots = total_lots;
        this.lot_type = lot_type;
        this.lots_available = lots_available;
    }

    public int getTotal_lots() {
        return total_lots;
    }

    public void setTotal_lots(int total_lots) {
        this.total_lots = total_lots;
    }

    public String getLot_type() {
        return lot_type;
    }

    public void setLot_type(String lot_type) {
        this.lot_type = lot_type;
    }

    public int getLots_available() {
        return lots_available;
    }

    public void setLots_available(int lots_available) {
        this.lots_available = lots_available;
    }

    @Override
    public String toString() {
        return
                "\n"+"AVAILABILITY" + "\n" + "Total lots: " + total_lots + "\n" + "Lot type: " + lot_type + "\n" + "Lots Available: " + lots_available;
    }
}
