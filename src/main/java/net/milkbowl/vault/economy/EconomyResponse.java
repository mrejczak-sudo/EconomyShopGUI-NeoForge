package net.milkbowl.vault.economy;

public class EconomyResponse {
    public enum ResponseType { SUCCESS, FAILURE, NOT_IMPLEMENTED }

    private final double amount;
    private final ResponseType type;
    private final String errorMessage;

    public EconomyResponse(double amount, ResponseType type, String errorMessage) {
        this.amount = amount;
        this.type = type;
        this.errorMessage = errorMessage;
    }

    public double amount() { return amount; }
    public ResponseType type() { return type; }
    public String errorMessage() { return errorMessage; }
}
