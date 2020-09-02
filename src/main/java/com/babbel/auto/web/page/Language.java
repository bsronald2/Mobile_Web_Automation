package com.babbel.auto.web.page;

public enum Language {
    SPANISH("QMS"),
    GERMAN("DEU"),
    PORTUGUESE("POR");

    String code;

    Language(String code) {
        this.code = code;
    }

    String getCode() {
        return code;
    }
}
