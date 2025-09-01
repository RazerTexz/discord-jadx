package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubWaitlist.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/hubs/HubWaitlistResult;", "Lcom/discord/widgets/hubs/MultipleDomainResult;", "", "component1", "()Ljava/lang/String;", "school", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/hubs/HubWaitlistResult;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSchool", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubWaitlistResult, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubWaitlist2 implements WidgetHubDomains5 {
    public static final Parcelable.Creator<WidgetHubWaitlist2> CREATOR = new Creator();
    private final String school;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.HubWaitlistResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubWaitlist2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubWaitlist2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubWaitlist2(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubWaitlist2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubWaitlist2[] newArray(int i) {
            return new WidgetHubWaitlist2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubWaitlist2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubWaitlist2(String str) {
        Intrinsics3.checkNotNullParameter(str, "school");
        this.school = str;
    }

    public static /* synthetic */ WidgetHubWaitlist2 copy$default(WidgetHubWaitlist2 widgetHubWaitlist2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubWaitlist2.school;
        }
        return widgetHubWaitlist2.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public final WidgetHubWaitlist2 copy(String school) {
        Intrinsics3.checkNotNullParameter(school, "school");
        return new WidgetHubWaitlist2(school);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubWaitlist2) && Intrinsics3.areEqual(this.school, ((WidgetHubWaitlist2) other).school);
        }
        return true;
    }

    public final String getSchool() {
        return this.school;
    }

    public int hashCode() {
        String str = this.school;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("HubWaitlistResult(school="), this.school, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.school);
    }
}
