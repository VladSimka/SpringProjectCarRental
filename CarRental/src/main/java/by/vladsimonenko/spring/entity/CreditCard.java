package by.vladsimonenko.spring.entity;

import jakarta.validation.constraints.Pattern;

public class CreditCard {
    @Pattern(regexp = "^(?:\\\\d{4}[- ]){3}\\\\d{4}|\\\\d{16}$",message = "ожидается формат ХХХХ-ХХХХ-ХХХХ-ХХХХ")
    String number;
    @Pattern(regexp = "(0[1-9]|1[0-2])/(2[3-9])", message = "ожидается формат XX/XX")
    String expiration;
    @Pattern(regexp = "\\d{3}", message = "ожидается формат XXX")
    String CVV;

    public CreditCard() {
    }

    public CreditCard(String number, String expiration, String CVV) {
        this.number = number;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
