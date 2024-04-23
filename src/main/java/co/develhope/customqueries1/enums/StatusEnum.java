package co.develhope.customqueries1.enums;

public enum StatusEnum {
    ONTIME("On time"),
    DELAYED("Delayed"),
    CANCELL("Cancelled");
    private String testo;

    StatusEnum(String testo) {
        this.testo = testo;
    }

    public String getTesto() {
        return testo;
    }
}
