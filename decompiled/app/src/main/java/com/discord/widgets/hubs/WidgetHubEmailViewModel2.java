package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubEmailViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/widgets/hubs/HubEmailArgs;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "Lcom/discord/widgets/hubs/HubEmailEntryPoint;", "component3", "()Lcom/discord/widgets/hubs/HubEmailEntryPoint;", "guildName", "guildMemberCount", "entryPoint", "copy", "(Ljava/lang/String;ILcom/discord/widgets/hubs/HubEmailEntryPoint;)Lcom/discord/widgets/hubs/HubEmailArgs;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/discord/widgets/hubs/HubEmailEntryPoint;", "getEntryPoint", "I", "getGuildMemberCount", "Ljava/lang/String;", "getGuildName", "<init>", "(Ljava/lang/String;ILcom/discord/widgets/hubs/HubEmailEntryPoint;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubEmailArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEmailViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubEmailViewModel2> CREATOR = new Creator();
    private final WidgetHubEmailViewModel3 entryPoint;
    private final int guildMemberCount;
    private final String guildName;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.HubEmailArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubEmailViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEmailViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubEmailViewModel2(parcel.readString(), parcel.readInt(), (WidgetHubEmailViewModel3) Enum.valueOf(WidgetHubEmailViewModel3.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubEmailViewModel2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEmailViewModel2[] newArray(int i) {
            return new WidgetHubEmailViewModel2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubEmailViewModel2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubEmailViewModel2() {
        this(null, 0, null, 7, null);
    }

    public WidgetHubEmailViewModel2(String str, int i, WidgetHubEmailViewModel3 widgetHubEmailViewModel3) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(widgetHubEmailViewModel3, "entryPoint");
        this.guildName = str;
        this.guildMemberCount = i;
        this.entryPoint = widgetHubEmailViewModel3;
    }

    public static /* synthetic */ WidgetHubEmailViewModel2 copy$default(WidgetHubEmailViewModel2 widgetHubEmailViewModel2, String str, int i, WidgetHubEmailViewModel3 widgetHubEmailViewModel3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetHubEmailViewModel2.guildName;
        }
        if ((i2 & 2) != 0) {
            i = widgetHubEmailViewModel2.guildMemberCount;
        }
        if ((i2 & 4) != 0) {
            widgetHubEmailViewModel3 = widgetHubEmailViewModel2.entryPoint;
        }
        return widgetHubEmailViewModel2.copy(str, i, widgetHubEmailViewModel3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGuildMemberCount() {
        return this.guildMemberCount;
    }

    /* renamed from: component3, reason: from getter */
    public final WidgetHubEmailViewModel3 getEntryPoint() {
        return this.entryPoint;
    }

    public final WidgetHubEmailViewModel2 copy(String guildName, int guildMemberCount, WidgetHubEmailViewModel3 entryPoint) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        Intrinsics3.checkNotNullParameter(entryPoint, "entryPoint");
        return new WidgetHubEmailViewModel2(guildName, guildMemberCount, entryPoint);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEmailViewModel2)) {
            return false;
        }
        WidgetHubEmailViewModel2 widgetHubEmailViewModel2 = (WidgetHubEmailViewModel2) other;
        return Intrinsics3.areEqual(this.guildName, widgetHubEmailViewModel2.guildName) && this.guildMemberCount == widgetHubEmailViewModel2.guildMemberCount && Intrinsics3.areEqual(this.entryPoint, widgetHubEmailViewModel2.entryPoint);
    }

    public final WidgetHubEmailViewModel3 getEntryPoint() {
        return this.entryPoint;
    }

    public final int getGuildMemberCount() {
        return this.guildMemberCount;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public int hashCode() {
        String str = this.guildName;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.guildMemberCount) * 31;
        WidgetHubEmailViewModel3 widgetHubEmailViewModel3 = this.entryPoint;
        return iHashCode + (widgetHubEmailViewModel3 != null ? widgetHubEmailViewModel3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubEmailArgs(guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildMemberCount=");
        sbU.append(this.guildMemberCount);
        sbU.append(", entryPoint=");
        sbU.append(this.entryPoint);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.guildName);
        parcel.writeInt(this.guildMemberCount);
        parcel.writeString(this.entryPoint.name());
    }

    public /* synthetic */ WidgetHubEmailViewModel2(String str, int i, WidgetHubEmailViewModel3 widgetHubEmailViewModel3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? WidgetHubEmailViewModel3.Default : widgetHubEmailViewModel3);
    }
}
