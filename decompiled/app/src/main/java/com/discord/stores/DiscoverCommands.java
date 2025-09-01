package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.commands.ApplicationCommand;
import com.discord.stores.LoadState;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015BQ\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b3\u00104J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014Jh\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\"\u0010\bJ\u001a\u0010$\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\bR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\fR\u0019\u0010\u0019\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b,\u0010\fR\u0019\u0010\u001c\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010\u0014R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b/\u0010\bR\u0019\u0010\u0016\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b0\u0010\bR\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b2\u0010\u0005¨\u00066"}, d2 = {"Lcom/discord/stores/DiscoverCommands;", "", "", "Lcom/discord/models/commands/ApplicationCommand;", "component1", "()Ljava/util/List;", "", "component2", "()I", "component3", "", "component4", "()Z", "component5", "component6", "", "component7", "()Ljava/lang/Long;", "Lcom/discord/stores/LoadState;", "component8", "()Lcom/discord/stores/LoadState;", "commands", "currentStartOffset", "currentEndOffset", "hasMoreBefore", "hasMoreAfter", "jumpedSequenceId", "jumpedApplicationId", "loadState", "copy", "(Ljava/util/List;IIZZILjava/lang/Long;Lcom/discord/stores/LoadState;)Lcom/discord/stores/DiscoverCommands;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getCurrentEndOffset", "Ljava/lang/Long;", "getJumpedApplicationId", "Z", "getHasMoreBefore", "getHasMoreAfter", "Lcom/discord/stores/LoadState;", "getLoadState", "getJumpedSequenceId", "getCurrentStartOffset", "Ljava/util/List;", "getCommands", "<init>", "(Ljava/util/List;IIZZILjava/lang/Long;Lcom/discord/stores/LoadState;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class DiscoverCommands {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ApplicationCommand> commands;
    private final int currentEndOffset;
    private final int currentStartOffset;
    private final boolean hasMoreAfter;
    private final boolean hasMoreBefore;
    private final Long jumpedApplicationId;
    private final int jumpedSequenceId;
    private final LoadState loadState;

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/DiscoverCommands$Companion;", "", "Lcom/discord/stores/DiscoverCommands;", "getDefaultModelDiscoveryCommands", "()Lcom/discord/stores/DiscoverCommands;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final DiscoverCommands getDefaultModelDiscoveryCommands() {
            return new DiscoverCommands(Collections2.emptyList(), 0, 0, false, false, 0, null, null, 128, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoverCommands(List<? extends ApplicationCommand> list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState) {
        Intrinsics3.checkNotNullParameter(list, "commands");
        Intrinsics3.checkNotNullParameter(loadState, "loadState");
        this.commands = list;
        this.currentStartOffset = i;
        this.currentEndOffset = i2;
        this.hasMoreBefore = z2;
        this.hasMoreAfter = z3;
        this.jumpedSequenceId = i3;
        this.jumpedApplicationId = l;
        this.loadState = loadState;
    }

    public static /* synthetic */ DiscoverCommands copy$default(DiscoverCommands discoverCommands, List list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState, int i4, Object obj) {
        return discoverCommands.copy((i4 & 1) != 0 ? discoverCommands.commands : list, (i4 & 2) != 0 ? discoverCommands.currentStartOffset : i, (i4 & 4) != 0 ? discoverCommands.currentEndOffset : i2, (i4 & 8) != 0 ? discoverCommands.hasMoreBefore : z2, (i4 & 16) != 0 ? discoverCommands.hasMoreAfter : z3, (i4 & 32) != 0 ? discoverCommands.jumpedSequenceId : i3, (i4 & 64) != 0 ? discoverCommands.jumpedApplicationId : l, (i4 & 128) != 0 ? discoverCommands.loadState : loadState);
    }

    public final List<ApplicationCommand> component1() {
        return this.commands;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCurrentStartOffset() {
        return this.currentStartOffset;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCurrentEndOffset() {
        return this.currentEndOffset;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    /* renamed from: component6, reason: from getter */
    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    /* renamed from: component8, reason: from getter */
    public final LoadState getLoadState() {
        return this.loadState;
    }

    public final DiscoverCommands copy(List<? extends ApplicationCommand> commands, int currentStartOffset, int currentEndOffset, boolean hasMoreBefore, boolean hasMoreAfter, int jumpedSequenceId, Long jumpedApplicationId, LoadState loadState) {
        Intrinsics3.checkNotNullParameter(commands, "commands");
        Intrinsics3.checkNotNullParameter(loadState, "loadState");
        return new DiscoverCommands(commands, currentStartOffset, currentEndOffset, hasMoreBefore, hasMoreAfter, jumpedSequenceId, jumpedApplicationId, loadState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoverCommands)) {
            return false;
        }
        DiscoverCommands discoverCommands = (DiscoverCommands) other;
        return Intrinsics3.areEqual(this.commands, discoverCommands.commands) && this.currentStartOffset == discoverCommands.currentStartOffset && this.currentEndOffset == discoverCommands.currentEndOffset && this.hasMoreBefore == discoverCommands.hasMoreBefore && this.hasMoreAfter == discoverCommands.hasMoreAfter && this.jumpedSequenceId == discoverCommands.jumpedSequenceId && Intrinsics3.areEqual(this.jumpedApplicationId, discoverCommands.jumpedApplicationId) && Intrinsics3.areEqual(this.loadState, discoverCommands.loadState);
    }

    public final List<ApplicationCommand> getCommands() {
        return this.commands;
    }

    public final int getCurrentEndOffset() {
        return this.currentEndOffset;
    }

    public final int getCurrentStartOffset() {
        return this.currentStartOffset;
    }

    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    public final LoadState getLoadState() {
        return this.loadState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<ApplicationCommand> list = this.commands;
        int iHashCode = (((((list != null ? list.hashCode() : 0) * 31) + this.currentStartOffset) * 31) + this.currentEndOffset) * 31;
        boolean z2 = this.hasMoreBefore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.hasMoreAfter;
        int i3 = (((i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.jumpedSequenceId) * 31;
        Long l = this.jumpedApplicationId;
        int iHashCode2 = (i3 + (l != null ? l.hashCode() : 0)) * 31;
        LoadState loadState = this.loadState;
        return iHashCode2 + (loadState != null ? loadState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DiscoverCommands(commands=");
        sbU.append(this.commands);
        sbU.append(", currentStartOffset=");
        sbU.append(this.currentStartOffset);
        sbU.append(", currentEndOffset=");
        sbU.append(this.currentEndOffset);
        sbU.append(", hasMoreBefore=");
        sbU.append(this.hasMoreBefore);
        sbU.append(", hasMoreAfter=");
        sbU.append(this.hasMoreAfter);
        sbU.append(", jumpedSequenceId=");
        sbU.append(this.jumpedSequenceId);
        sbU.append(", jumpedApplicationId=");
        sbU.append(this.jumpedApplicationId);
        sbU.append(", loadState=");
        sbU.append(this.loadState);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ DiscoverCommands(List list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, i2, z2, z3, i3, l, (i4 & 128) != 0 ? LoadState.None.INSTANCE : loadState);
    }
}
