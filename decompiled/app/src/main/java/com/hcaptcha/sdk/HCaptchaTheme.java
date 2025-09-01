package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import b.g.a.a.JsonValue;
import com.discord.models.domain.ModelUserSettings;
import java.io.Serializable;

/* loaded from: classes3.dex */
public enum HCaptchaTheme implements Serializable {
    DARK(ModelUserSettings.THEME_DARK),
    LIGHT(ModelUserSettings.THEME_LIGHT),
    CONTRAST("contrast");

    private final String theme;

    HCaptchaTheme(String str) {
        this.theme = str;
    }

    public String getTheme() {
        return this.theme;
    }

    @Override // java.lang.Enum
    @NonNull
    @JsonValue
    public String toString() {
        return this.theme;
    }
}
