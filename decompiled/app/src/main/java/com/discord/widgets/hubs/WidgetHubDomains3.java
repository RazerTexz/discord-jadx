package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetHubDomains.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/HubDomainArgs;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/widgets/hubs/DomainGuildInfo;", "component2", "()Ljava/util/List;", NotificationCompat.CATEGORY_EMAIL, "guildInfos", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/widgets/hubs/HubDomainArgs;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getEmail", "Ljava/util/List;", "getGuildInfos", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubDomainArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubDomains3 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubDomains3> CREATOR = new Creator();
    private final String email;
    private final List<WidgetHubDomains2> guildInfos;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.HubDomainArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDomains3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDomains3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add(WidgetHubDomains2.CREATOR.createFromParcel(parcel));
                i--;
            }
            return new WidgetHubDomains3(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDomains3 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDomains3[] newArray(int i) {
            return new WidgetHubDomains3[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDomains3[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubDomains3(String str, List<WidgetHubDomains2> list) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(list, "guildInfos");
        this.email = str;
        this.guildInfos = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubDomains3 copy$default(WidgetHubDomains3 widgetHubDomains3, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubDomains3.email;
        }
        if ((i & 2) != 0) {
            list = widgetHubDomains3.guildInfos;
        }
        return widgetHubDomains3.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final List<WidgetHubDomains2> component2() {
        return this.guildInfos;
    }

    public final WidgetHubDomains3 copy(String email, List<WidgetHubDomains2> guildInfos) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(guildInfos, "guildInfos");
        return new WidgetHubDomains3(email, guildInfos);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDomains3)) {
            return false;
        }
        WidgetHubDomains3 widgetHubDomains3 = (WidgetHubDomains3) other;
        return Intrinsics3.areEqual(this.email, widgetHubDomains3.email) && Intrinsics3.areEqual(this.guildInfos, widgetHubDomains3.guildInfos);
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<WidgetHubDomains2> getGuildInfos() {
        return this.guildInfos;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<WidgetHubDomains2> list = this.guildInfos;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubDomainArgs(email=");
        sbU.append(this.email);
        sbU.append(", guildInfos=");
        return outline.L(sbU, this.guildInfos, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        List<WidgetHubDomains2> list = this.guildInfos;
        parcel.writeInt(list.size());
        Iterator<WidgetHubDomains2> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}
