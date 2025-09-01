package com.discord.models.experiments.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExperimentContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ>\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R!\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\bR!\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/models/experiments/domain/ExperimentContext;", "", "", "component1", "()Z", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/primitives/ChannelId;", "component3", "shouldTrigger", "guildId", "channelId", "copy", "(ZLjava/lang/Long;Ljava/lang/Long;)Lcom/discord/models/experiments/domain/ExperimentContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getChannelId", "getGuildId", "Z", "getShouldTrigger", "<init>", "(ZLjava/lang/Long;Ljava/lang/Long;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ExperimentContext {
    private final Long channelId;
    private final Long guildId;
    private final boolean shouldTrigger;

    public ExperimentContext() {
        this(false, null, null, 7, null);
    }

    public ExperimentContext(boolean z2, Long l, Long l2) {
        this.shouldTrigger = z2;
        this.guildId = l;
        this.channelId = l2;
    }

    public static /* synthetic */ ExperimentContext copy$default(ExperimentContext experimentContext, boolean z2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = experimentContext.shouldTrigger;
        }
        if ((i & 2) != 0) {
            l = experimentContext.guildId;
        }
        if ((i & 4) != 0) {
            l2 = experimentContext.channelId;
        }
        return experimentContext.copy(z2, l, l2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShouldTrigger() {
        return this.shouldTrigger;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    public final ExperimentContext copy(boolean shouldTrigger, Long guildId, Long channelId) {
        return new ExperimentContext(shouldTrigger, guildId, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExperimentContext)) {
            return false;
        }
        ExperimentContext experimentContext = (ExperimentContext) other;
        return this.shouldTrigger == experimentContext.shouldTrigger && Intrinsics3.areEqual(this.guildId, experimentContext.guildId) && Intrinsics3.areEqual(this.channelId, experimentContext.channelId);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final boolean getShouldTrigger() {
        return this.shouldTrigger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.shouldTrigger;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Long l = this.guildId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ExperimentContext(shouldTrigger=");
        sbU.append(this.shouldTrigger);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        return outline.G(sbU, this.channelId, ")");
    }

    public /* synthetic */ ExperimentContext(boolean z2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }
}
