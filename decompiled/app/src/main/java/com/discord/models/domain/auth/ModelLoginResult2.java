package com.discord.models.domain.auth;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelLoginResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;", "", "", "component1", "()Ljava/lang/String;", "component2", "theme", "locale", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/auth/ModelUserSettingsBootstrap;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTheme", "getLocale", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.auth.ModelUserSettingsBootstrap, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelLoginResult2 {
    private final String locale;
    private final String theme;

    public ModelLoginResult2(String str, String str2) {
        this.theme = str;
        this.locale = str2;
    }

    public static /* synthetic */ ModelLoginResult2 copy$default(ModelLoginResult2 modelLoginResult2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelLoginResult2.theme;
        }
        if ((i & 2) != 0) {
            str2 = modelLoginResult2.locale;
        }
        return modelLoginResult2.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final ModelLoginResult2 copy(String theme, String locale) {
        return new ModelLoginResult2(theme, locale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLoginResult2)) {
            return false;
        }
        ModelLoginResult2 modelLoginResult2 = (ModelLoginResult2) other;
        return Intrinsics3.areEqual(this.theme, modelLoginResult2.theme) && Intrinsics3.areEqual(this.locale, modelLoginResult2.locale);
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getTheme() {
        return this.theme;
    }

    public int hashCode() {
        String str = this.theme;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.locale;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelUserSettingsBootstrap(theme=");
        sbU.append(this.theme);
        sbU.append(", locale=");
        return outline.J(sbU, this.locale, ")");
    }
}
