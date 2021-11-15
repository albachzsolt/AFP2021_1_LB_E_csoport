package webshop;

public enum Response {

    SUCCES("Succes"),
    FAILED("Failed");

    private String description;

    Response(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
