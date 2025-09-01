package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubDescriptionViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b3\u00104J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jb\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0013\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0014\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\rJ\u0010\u0010\u001d\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b#\u0010\u001eJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b(\u0010)R\u001d\u0010\u0013\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\u0005R\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b\u0017\u0010\nR\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\rR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b1\u0010\rR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b\u0015\u0010\nR\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b2\u0010\u0005¨\u00065"}, d2 = {"Lcom/discord/widgets/hubs/HubDescriptionArgs;", "Landroid/os/Parcelable;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "", "component3", "()Z", "", "component4", "()Ljava/lang/String;", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "guildId", "channelId", "isEditing", "hubName", "isNewGuild", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "primaryCategoryId", "copy", "(JJZLjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lcom/discord/widgets/hubs/HubDescriptionArgs;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getGuildId", "Z", "Ljava/lang/String;", "getHubName", "Ljava/lang/Integer;", "getPrimaryCategoryId", "getDescription", "getChannelId", "<init>", "(JJZLjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubDescriptionArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubDescriptionViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubDescriptionViewModel2> CREATOR = new Creator();
    private final long channelId;
    private final String description;
    private final long guildId;
    private final String hubName;
    private final boolean isEditing;
    private final boolean isNewGuild;
    private final Integer primaryCategoryId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.HubDescriptionArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDescriptionViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescriptionViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubDescriptionViewModel2(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDescriptionViewModel2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescriptionViewModel2[] newArray(int i) {
            return new WidgetHubDescriptionViewModel2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDescriptionViewModel2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubDescriptionViewModel2(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.channelId = j2;
        this.isEditing = z2;
        this.hubName = str;
        this.isNewGuild = z3;
        this.description = str2;
        this.primaryCategoryId = num;
    }

    public static /* synthetic */ WidgetHubDescriptionViewModel2 copy$default(WidgetHubDescriptionViewModel2 widgetHubDescriptionViewModel2, long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num, int i, Object obj) {
        return widgetHubDescriptionViewModel2.copy((i & 1) != 0 ? widgetHubDescriptionViewModel2.guildId : j, (i & 2) != 0 ? widgetHubDescriptionViewModel2.channelId : j2, (i & 4) != 0 ? widgetHubDescriptionViewModel2.isEditing : z2, (i & 8) != 0 ? widgetHubDescriptionViewModel2.hubName : str, (i & 16) != 0 ? widgetHubDescriptionViewModel2.isNewGuild : z3, (i & 32) != 0 ? widgetHubDescriptionViewModel2.description : str2, (i & 64) != 0 ? widgetHubDescriptionViewModel2.primaryCategoryId : num);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsNewGuild() {
        return this.isNewGuild;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public final WidgetHubDescriptionViewModel2 copy(long guildId, long channelId, boolean isEditing, String hubName, boolean isNewGuild, String description, Integer primaryCategoryId) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        return new WidgetHubDescriptionViewModel2(guildId, channelId, isEditing, hubName, isNewGuild, description, primaryCategoryId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDescriptionViewModel2)) {
            return false;
        }
        WidgetHubDescriptionViewModel2 widgetHubDescriptionViewModel2 = (WidgetHubDescriptionViewModel2) other;
        return this.guildId == widgetHubDescriptionViewModel2.guildId && this.channelId == widgetHubDescriptionViewModel2.channelId && this.isEditing == widgetHubDescriptionViewModel2.isEditing && Intrinsics3.areEqual(this.hubName, widgetHubDescriptionViewModel2.hubName) && this.isNewGuild == widgetHubDescriptionViewModel2.isNewGuild && Intrinsics3.areEqual(this.description, widgetHubDescriptionViewModel2.description) && Intrinsics3.areEqual(this.primaryCategoryId, widgetHubDescriptionViewModel2.primaryCategoryId);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.channelId) + (b.a(this.guildId) * 31)) * 31;
        boolean z2 = this.isEditing;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        String str = this.hubName;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.isNewGuild;
        int i3 = (iHashCode + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.primaryCategoryId;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isEditing() {
        return this.isEditing;
    }

    public final boolean isNewGuild() {
        return this.isNewGuild;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubDescriptionArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", isEditing=");
        sbU.append(this.isEditing);
        sbU.append(", hubName=");
        sbU.append(this.hubName);
        sbU.append(", isNewGuild=");
        sbU.append(this.isNewGuild);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", primaryCategoryId=");
        return outline.F(sbU, this.primaryCategoryId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.channelId);
        parcel.writeInt(this.isEditing ? 1 : 0);
        parcel.writeString(this.hubName);
        parcel.writeInt(this.isNewGuild ? 1 : 0);
        parcel.writeString(this.description);
        Integer num = this.primaryCategoryId;
        if (num != null) {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        } else {
            iIntValue = 0;
        }
        parcel.writeInt(iIntValue);
    }

    public /* synthetic */ WidgetHubDescriptionViewModel2(long j, long j2, boolean z2, String str, boolean z3, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, z2, str, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num);
    }
}
