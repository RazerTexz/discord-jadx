package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010\rR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b,\u0010\u0004¨\u0006/"}, d2 = {"Lcom/discord/widgets/nux/GuildCreateArgs;", "Landroid/os/Parcelable;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "component3", "()Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "Lcom/discord/widgets/nux/GuildTemplateArgs;", "component4", "()Lcom/discord/widgets/nux/GuildTemplateArgs;", "component5", "isNux", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "trigger", "guildTemplate", "closeWithResult", "copy", "(ZLjava/lang/String;Lcom/discord/widgets/guilds/create/CreateGuildTrigger;Lcom/discord/widgets/nux/GuildTemplateArgs;Z)Lcom/discord/widgets/nux/GuildCreateArgs;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "getTrigger", "Ljava/lang/String;", "getLocation", "Lcom/discord/widgets/nux/GuildTemplateArgs;", "getGuildTemplate", "getCloseWithResult", "<init>", "(ZLjava/lang/String;Lcom/discord/widgets/guilds/create/CreateGuildTrigger;Lcom/discord/widgets/nux/GuildTemplateArgs;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildCreateArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetGuildTemplates2 implements Parcelable {
    public static final Parcelable.Creator<WidgetGuildTemplates2> CREATOR = new Creator();
    private final boolean closeWithResult;
    private final WidgetGuildTemplates3 guildTemplate;
    private final boolean isNux;
    private final String location;
    private final CreateGuildTrigger trigger;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.GuildCreateArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetGuildTemplates2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetGuildTemplates2(parcel.readInt() != 0, parcel.readString(), (CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildTemplates3.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetGuildTemplates2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates2[] newArray(int i) {
            return new WidgetGuildTemplates2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetGuildTemplates2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetGuildTemplates2(boolean z2, String str, CreateGuildTrigger createGuildTrigger, WidgetGuildTemplates3 widgetGuildTemplates3, boolean z3) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(createGuildTrigger, "trigger");
        Intrinsics3.checkNotNullParameter(widgetGuildTemplates3, "guildTemplate");
        this.isNux = z2;
        this.location = str;
        this.trigger = createGuildTrigger;
        this.guildTemplate = widgetGuildTemplates3;
        this.closeWithResult = z3;
    }

    public static /* synthetic */ WidgetGuildTemplates2 copy$default(WidgetGuildTemplates2 widgetGuildTemplates2, boolean z2, String str, CreateGuildTrigger createGuildTrigger, WidgetGuildTemplates3 widgetGuildTemplates3, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGuildTemplates2.isNux;
        }
        if ((i & 2) != 0) {
            str = widgetGuildTemplates2.location;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            createGuildTrigger = widgetGuildTemplates2.trigger;
        }
        CreateGuildTrigger createGuildTrigger2 = createGuildTrigger;
        if ((i & 8) != 0) {
            widgetGuildTemplates3 = widgetGuildTemplates2.guildTemplate;
        }
        WidgetGuildTemplates3 widgetGuildTemplates32 = widgetGuildTemplates3;
        if ((i & 16) != 0) {
            z3 = widgetGuildTemplates2.closeWithResult;
        }
        return widgetGuildTemplates2.copy(z2, str2, createGuildTrigger2, widgetGuildTemplates32, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsNux() {
        return this.isNux;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component3, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* renamed from: component4, reason: from getter */
    public final WidgetGuildTemplates3 getGuildTemplate() {
        return this.guildTemplate;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final WidgetGuildTemplates2 copy(boolean isNux, String location, CreateGuildTrigger trigger, WidgetGuildTemplates3 guildTemplate, boolean closeWithResult) {
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(trigger, "trigger");
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new WidgetGuildTemplates2(isNux, location, trigger, guildTemplate, closeWithResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildTemplates2)) {
            return false;
        }
        WidgetGuildTemplates2 widgetGuildTemplates2 = (WidgetGuildTemplates2) other;
        return this.isNux == widgetGuildTemplates2.isNux && Intrinsics3.areEqual(this.location, widgetGuildTemplates2.location) && Intrinsics3.areEqual(this.trigger, widgetGuildTemplates2.trigger) && Intrinsics3.areEqual(this.guildTemplate, widgetGuildTemplates2.guildTemplate) && this.closeWithResult == widgetGuildTemplates2.closeWithResult;
    }

    public final boolean getCloseWithResult() {
        return this.closeWithResult;
    }

    public final WidgetGuildTemplates3 getGuildTemplate() {
        return this.guildTemplate;
    }

    public final String getLocation() {
        return this.location;
    }

    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z2 = this.isNux;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.location;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        CreateGuildTrigger createGuildTrigger = this.trigger;
        int iHashCode2 = (iHashCode + (createGuildTrigger != null ? createGuildTrigger.hashCode() : 0)) * 31;
        WidgetGuildTemplates3 widgetGuildTemplates3 = this.guildTemplate;
        int iHashCode3 = (iHashCode2 + (widgetGuildTemplates3 != null ? widgetGuildTemplates3.hashCode() : 0)) * 31;
        boolean z3 = this.closeWithResult;
        return iHashCode3 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isNux() {
        return this.isNux;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildCreateArgs(isNux=");
        sbU.append(this.isNux);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", trigger=");
        sbU.append(this.trigger);
        sbU.append(", guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(", closeWithResult=");
        return outline.O(sbU, this.closeWithResult, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.isNux ? 1 : 0);
        parcel.writeString(this.location);
        parcel.writeString(this.trigger.name());
        this.guildTemplate.writeToParcel(parcel, 0);
        parcel.writeInt(this.closeWithResult ? 1 : 0);
    }

    public /* synthetic */ WidgetGuildTemplates2(boolean z2, String str, CreateGuildTrigger createGuildTrigger, WidgetGuildTemplates3 widgetGuildTemplates3, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, str, createGuildTrigger, widgetGuildTemplates3, (i & 16) != 0 ? false : z3);
    }
}
