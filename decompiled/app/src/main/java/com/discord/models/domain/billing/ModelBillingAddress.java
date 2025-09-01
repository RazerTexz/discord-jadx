package com.discord.models.domain.billing;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelBillingAddress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/models/domain/billing/ModelBillingAddress;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", ModelAuditLogEntry.CHANGE_KEY_NAME, "line_1", "line_2", "city", "state", "country", "postalCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/billing/ModelBillingAddress;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCountry", "getLine_2", "getPostalCode", "getCity", "getName", "getLine_1", "getState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelBillingAddress {
    private final String city;
    private final String country;
    private final String line_1;
    private final String line_2;
    private final String name;
    private final String postalCode;
    private final String state;

    public ModelBillingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "line_1");
        Intrinsics3.checkNotNullParameter(str3, "line_2");
        Intrinsics3.checkNotNullParameter(str4, "city");
        Intrinsics3.checkNotNullParameter(str5, "state");
        Intrinsics3.checkNotNullParameter(str6, "country");
        Intrinsics3.checkNotNullParameter(str7, "postalCode");
        this.name = str;
        this.line_1 = str2;
        this.line_2 = str3;
        this.city = str4;
        this.state = str5;
        this.country = str6;
        this.postalCode = str7;
    }

    public static /* synthetic */ ModelBillingAddress copy$default(ModelBillingAddress modelBillingAddress, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelBillingAddress.name;
        }
        if ((i & 2) != 0) {
            str2 = modelBillingAddress.line_1;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = modelBillingAddress.line_2;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = modelBillingAddress.city;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = modelBillingAddress.state;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = modelBillingAddress.country;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = modelBillingAddress.postalCode;
        }
        return modelBillingAddress.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLine_1() {
        return this.line_1;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLine_2() {
        return this.line_2;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    public final ModelBillingAddress copy(String name, String line_1, String line_2, String city, String state, String country, String postalCode) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(line_1, "line_1");
        Intrinsics3.checkNotNullParameter(line_2, "line_2");
        Intrinsics3.checkNotNullParameter(city, "city");
        Intrinsics3.checkNotNullParameter(state, "state");
        Intrinsics3.checkNotNullParameter(country, "country");
        Intrinsics3.checkNotNullParameter(postalCode, "postalCode");
        return new ModelBillingAddress(name, line_1, line_2, city, state, country, postalCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelBillingAddress)) {
            return false;
        }
        ModelBillingAddress modelBillingAddress = (ModelBillingAddress) other;
        return Intrinsics3.areEqual(this.name, modelBillingAddress.name) && Intrinsics3.areEqual(this.line_1, modelBillingAddress.line_1) && Intrinsics3.areEqual(this.line_2, modelBillingAddress.line_2) && Intrinsics3.areEqual(this.city, modelBillingAddress.city) && Intrinsics3.areEqual(this.state, modelBillingAddress.state) && Intrinsics3.areEqual(this.country, modelBillingAddress.country) && Intrinsics3.areEqual(this.postalCode, modelBillingAddress.postalCode);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getLine_1() {
        return this.line_1;
    }

    public final String getLine_2() {
        return this.line_2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.line_1;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.line_2;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.city;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.country;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.postalCode;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelBillingAddress(name=");
        sbU.append(this.name);
        sbU.append(", line_1=");
        sbU.append(this.line_1);
        sbU.append(", line_2=");
        sbU.append(this.line_2);
        sbU.append(", city=");
        sbU.append(this.city);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", country=");
        sbU.append(this.country);
        sbU.append(", postalCode=");
        return outline.J(sbU, this.postalCode, ")");
    }
}
