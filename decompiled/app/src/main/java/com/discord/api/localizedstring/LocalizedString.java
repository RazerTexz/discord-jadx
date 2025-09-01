package com.discord.api.localizedstring;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: LocalizedString.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R%\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/api/localizedstring/LocalizedString;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "default", "Ljava/lang/String;", "a", "", "localizations", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class LocalizedString implements Serializable {
    private final String default;
    private final Map<String, String> localizations;

    public LocalizedString(String str, Map<String, String> map) {
        Intrinsics3.checkNotNullParameter(str, "default");
        Intrinsics3.checkNotNullParameter(map, "localizations");
        this.default = str;
        this.localizations = map;
    }

    /* renamed from: a, reason: from getter */
    public final String getDefault() {
        return this.default;
    }

    public final Map<String, String> b() {
        return this.localizations;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalizedString)) {
            return false;
        }
        LocalizedString localizedString = (LocalizedString) other;
        return Intrinsics3.areEqual(this.default, localizedString.default) && Intrinsics3.areEqual(this.localizations, localizedString.localizations);
    }

    public int hashCode() {
        String str = this.default;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.localizations;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LocalizedString(default=");
        sbU.append(this.default);
        sbU.append(", localizations=");
        return outline.M(sbU, this.localizations, ")");
    }
}
