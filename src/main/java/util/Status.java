package util;

public enum Status {
    SOLD("sold"),
    AVAILABLE("available"),
    PENDING("pending");

    public String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
