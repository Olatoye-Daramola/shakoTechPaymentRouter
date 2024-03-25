package com.payaza.shakorouter.model.constant;

import lombok.Getter;

@Getter
public enum CountryCode {

    Senegal("Senegal"),
    Mali("Mali"),
    Guinea("Guinea"),
    Benin("Benin"),
    Burkina_Faso("Burkina_Faso"),
    Niger("Niger"),
    Togo("Togo");

    private final String code;

    CountryCode(String code) {
        this.code = code;
    }

    public static CountryCode getCountryCode(String code) {
        for (CountryCode c : CountryCode.values()) {
            if (c.code.equalsIgnoreCase(code)) return c;
        }
        throw new IllegalArgumentException("Invalid country code");
    }
}
