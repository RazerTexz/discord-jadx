package com.discord.models.phone;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PhoneCountryCode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", ModelAuditLogEntry.CHANGE_KEY_NAME, "alpha2", "phoneCountryCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/phone/PhoneCountryCode;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getPhoneCountryCode", "getAlpha2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PhoneCountryCode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PhoneCountryCode DEFAULT_COUNTRY_CODE = new PhoneCountryCode("United States", "US", "+1");
    private static final PhoneCountryCode MISSING_COUNTRY_CODE = new PhoneCountryCode("", "", "");
    private final String alpha2;
    private final String name;
    private final String phoneCountryCode;

    /* compiled from: PhoneCountryCode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode$Companion;", "", "Lcom/discord/models/phone/PhoneCountryCode;", "MISSING_COUNTRY_CODE", "Lcom/discord/models/phone/PhoneCountryCode;", "getMISSING_COUNTRY_CODE", "()Lcom/discord/models/phone/PhoneCountryCode;", "DEFAULT_COUNTRY_CODE", "getDEFAULT_COUNTRY_CODE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final PhoneCountryCode getDEFAULT_COUNTRY_CODE() {
            return PhoneCountryCode.access$getDEFAULT_COUNTRY_CODE$cp();
        }

        public final PhoneCountryCode getMISSING_COUNTRY_CODE() {
            return PhoneCountryCode.access$getMISSING_COUNTRY_CODE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PhoneCountryCode(String str, String str2, String str3) {
        outline.q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "alpha2", str3, "phoneCountryCode");
        this.name = str;
        this.alpha2 = str2;
        this.phoneCountryCode = str3;
    }

    public static final /* synthetic */ PhoneCountryCode access$getDEFAULT_COUNTRY_CODE$cp() {
        return DEFAULT_COUNTRY_CODE;
    }

    public static final /* synthetic */ PhoneCountryCode access$getMISSING_COUNTRY_CODE$cp() {
        return MISSING_COUNTRY_CODE;
    }

    public static /* synthetic */ PhoneCountryCode copy$default(PhoneCountryCode phoneCountryCode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneCountryCode.name;
        }
        if ((i & 2) != 0) {
            str2 = phoneCountryCode.alpha2;
        }
        if ((i & 4) != 0) {
            str3 = phoneCountryCode.phoneCountryCode;
        }
        return phoneCountryCode.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAlpha2() {
        return this.alpha2;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public final PhoneCountryCode copy(String name, String alpha2, String phoneCountryCode) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(alpha2, "alpha2");
        Intrinsics3.checkNotNullParameter(phoneCountryCode, "phoneCountryCode");
        return new PhoneCountryCode(name, alpha2, phoneCountryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneCountryCode)) {
            return false;
        }
        PhoneCountryCode phoneCountryCode = (PhoneCountryCode) other;
        return Intrinsics3.areEqual(this.name, phoneCountryCode.name) && Intrinsics3.areEqual(this.alpha2, phoneCountryCode.alpha2) && Intrinsics3.areEqual(this.phoneCountryCode, phoneCountryCode.phoneCountryCode);
    }

    public final String getAlpha2() {
        return this.alpha2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.alpha2;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phoneCountryCode;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PhoneCountryCode(name=");
        sbU.append(this.name);
        sbU.append(", alpha2=");
        sbU.append(this.alpha2);
        sbU.append(", phoneCountryCode=");
        return outline.J(sbU, this.phoneCountryCode, ")");
    }
}
