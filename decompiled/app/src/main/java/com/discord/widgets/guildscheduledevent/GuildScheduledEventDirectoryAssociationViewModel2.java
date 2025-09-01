package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationState;", "", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventBroadcast;", "component1", "()Lcom/discord/stores/utilities/RestCallState;", "enabledAsync", "copy", "(Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/utilities/RestCallState;", "getEnabledAsync", "<init>", "(Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDirectoryAssociationState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDirectoryAssociationViewModel2 {
    private final RestCallState<GuildScheduledEventBroadcast> enabledAsync;

    public GuildScheduledEventDirectoryAssociationViewModel2() {
        this(null, 1, null);
    }

    public GuildScheduledEventDirectoryAssociationViewModel2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "enabledAsync");
        this.enabledAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2 copy$default(GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = guildScheduledEventDirectoryAssociationViewModel2.enabledAsync;
        }
        return guildScheduledEventDirectoryAssociationViewModel2.copy(restCallState);
    }

    public final RestCallState<GuildScheduledEventBroadcast> component1() {
        return this.enabledAsync;
    }

    public final GuildScheduledEventDirectoryAssociationViewModel2 copy(RestCallState<GuildScheduledEventBroadcast> enabledAsync) {
        Intrinsics3.checkNotNullParameter(enabledAsync, "enabledAsync");
        return new GuildScheduledEventDirectoryAssociationViewModel2(enabledAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventDirectoryAssociationViewModel2) && Intrinsics3.areEqual(this.enabledAsync, ((GuildScheduledEventDirectoryAssociationViewModel2) other).enabledAsync);
        }
        return true;
    }

    public final RestCallState<GuildScheduledEventBroadcast> getEnabledAsync() {
        return this.enabledAsync;
    }

    public int hashCode() {
        RestCallState<GuildScheduledEventBroadcast> restCallState = this.enabledAsync;
        if (restCallState != null) {
            return restCallState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventDirectoryAssociationState(enabledAsync=");
        sbU.append(this.enabledAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
