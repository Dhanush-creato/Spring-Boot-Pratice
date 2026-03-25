package org.springexmaples.BankingApi;

public class BankingGetterandSetter {
    String message;

    public String getMessage() {
        return message;
    }

    public BankingGetterandSetter setMessage(String message) {
        this.message = message;
        return this;
    }

    public BankingGetterandSetter(String message) {
        this.message = message;
    }
}
