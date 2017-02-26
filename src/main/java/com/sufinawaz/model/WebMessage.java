package com.sufinawaz.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebMessage {

    private String message;
    private WebMessageLevel level = WebMessageLevel.WARNING;

    public WebMessage(final String messageKey) {
        this.message = messageKey;
        this.level = WebMessageLevel.INFO;
    }

    public WebMessage(final WebMessageLevel level, final String message) {
        this.message = message;
        this.level = level;
    }
}