package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetCreationIntent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/discord/widgets/guilds/create/CreationIntentArgs;", "Landroid/os/Parcelable;", "Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "component1", "()Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "component2", "()Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "trigger", "createGuildOptions", "copy", "(Lcom/discord/widgets/guilds/create/CreateGuildTrigger;Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;)Lcom/discord/widgets/guilds/create/CreationIntentArgs;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "getTrigger", "Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "getCreateGuildOptions", "<init>", "(Lcom/discord/widgets/guilds/create/CreateGuildTrigger;Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.create.CreationIntentArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetCreationIntent2 implements Parcelable {
    public static final Parcelable.Creator<WidgetCreationIntent2> CREATOR = new Creator();
    private final WidgetGuildCreate.Options createGuildOptions;
    private final CreateGuildTrigger trigger;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.CreationIntentArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetCreationIntent2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetCreationIntent2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetCreationIntent2((CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildCreate.Options.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetCreationIntent2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetCreationIntent2[] newArray(int i) {
            return new WidgetCreationIntent2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetCreationIntent2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetCreationIntent2(CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options) {
        Intrinsics3.checkNotNullParameter(createGuildTrigger, "trigger");
        Intrinsics3.checkNotNullParameter(options, "createGuildOptions");
        this.trigger = createGuildTrigger;
        this.createGuildOptions = options;
    }

    public static /* synthetic */ WidgetCreationIntent2 copy$default(WidgetCreationIntent2 widgetCreationIntent2, CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options, int i, Object obj) {
        if ((i & 1) != 0) {
            createGuildTrigger = widgetCreationIntent2.trigger;
        }
        if ((i & 2) != 0) {
            options = widgetCreationIntent2.createGuildOptions;
        }
        return widgetCreationIntent2.copy(createGuildTrigger, options);
    }

    /* renamed from: component1, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* renamed from: component2, reason: from getter */
    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final WidgetCreationIntent2 copy(CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
        Intrinsics3.checkNotNullParameter(trigger, "trigger");
        Intrinsics3.checkNotNullParameter(createGuildOptions, "createGuildOptions");
        return new WidgetCreationIntent2(trigger, createGuildOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCreationIntent2)) {
            return false;
        }
        WidgetCreationIntent2 widgetCreationIntent2 = (WidgetCreationIntent2) other;
        return Intrinsics3.areEqual(this.trigger, widgetCreationIntent2.trigger) && Intrinsics3.areEqual(this.createGuildOptions, widgetCreationIntent2.createGuildOptions);
    }

    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        CreateGuildTrigger createGuildTrigger = this.trigger;
        int iHashCode = (createGuildTrigger != null ? createGuildTrigger.hashCode() : 0) * 31;
        WidgetGuildCreate.Options options = this.createGuildOptions;
        return iHashCode + (options != null ? options.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CreationIntentArgs(trigger=");
        sbU.append(this.trigger);
        sbU.append(", createGuildOptions=");
        sbU.append(this.createGuildOptions);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.trigger.name());
        this.createGuildOptions.writeToParcel(parcel, 0);
    }
}
