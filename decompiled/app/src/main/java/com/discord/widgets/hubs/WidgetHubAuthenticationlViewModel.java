package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubAuthenticationlViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/hubs/AuthenticationResult;", "Lcom/discord/widgets/hubs/MultipleDomainResult;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/hubs/AuthenticationResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.AuthenticationResult, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel implements WidgetHubDomains5 {
    public static final Parcelable.Creator<WidgetHubAuthenticationlViewModel> CREATOR = new Creator();
    private final long guildId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.AuthenticationResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAuthenticationlViewModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAuthenticationlViewModel(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAuthenticationlViewModel createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel[] newArray(int i) {
            return new WidgetHubAuthenticationlViewModel[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAuthenticationlViewModel[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubAuthenticationlViewModel(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHubAuthenticationlViewModel copy$default(WidgetHubAuthenticationlViewModel widgetHubAuthenticationlViewModel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubAuthenticationlViewModel.guildId;
        }
        return widgetHubAuthenticationlViewModel.copy(j);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHubAuthenticationlViewModel copy(long guildId) {
        return new WidgetHubAuthenticationlViewModel(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubAuthenticationlViewModel) && this.guildId == ((WidgetHubAuthenticationlViewModel) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return outline.C(outline.U("AuthenticationResult(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
