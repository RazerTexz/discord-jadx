package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAuthenticationlViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR!\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/HubAuthenticationArgs;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", NotificationCompat.CATEGORY_EMAIL, "guildId", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/widgets/hubs/HubAuthenticationArgs;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getGuildId", "Ljava/lang/String;", "getEmail", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubAuthenticationArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubAuthenticationlViewModel2> CREATOR = new Creator();
    private final String email;
    private final Long guildId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.HubAuthenticationArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAuthenticationlViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAuthenticationlViewModel2(parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAuthenticationlViewModel2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel2[] newArray(int i) {
            return new WidgetHubAuthenticationlViewModel2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAuthenticationlViewModel2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubAuthenticationlViewModel2() {
        this(null, null, 3, null);
    }

    public WidgetHubAuthenticationlViewModel2(String str, Long l) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.email = str;
        this.guildId = l;
    }

    public static /* synthetic */ WidgetHubAuthenticationlViewModel2 copy$default(WidgetHubAuthenticationlViewModel2 widgetHubAuthenticationlViewModel2, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubAuthenticationlViewModel2.email;
        }
        if ((i & 2) != 0) {
            l = widgetHubAuthenticationlViewModel2.guildId;
        }
        return widgetHubAuthenticationlViewModel2.copy(str, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final WidgetHubAuthenticationlViewModel2 copy(String email, Long guildId) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new WidgetHubAuthenticationlViewModel2(email, guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAuthenticationlViewModel2)) {
            return false;
        }
        WidgetHubAuthenticationlViewModel2 widgetHubAuthenticationlViewModel2 = (WidgetHubAuthenticationlViewModel2) other;
        return Intrinsics3.areEqual(this.email, widgetHubAuthenticationlViewModel2.email) && Intrinsics3.areEqual(this.guildId, widgetHubAuthenticationlViewModel2.guildId);
    }

    public final String getEmail() {
        return this.email;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.guildId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubAuthenticationArgs(email=");
        sbU.append(this.email);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        Long l = this.guildId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public /* synthetic */ WidgetHubAuthenticationlViewModel2(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l);
    }
}
