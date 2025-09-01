package com.discord.widgets.home;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HomeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ>\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00062\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R!\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR!\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/discord/widgets/home/HomeConfig;", "Ljava/io/Serializable;", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/lang/Long;", "Lcom/discord/primitives/GuildScheduledEventId;", "component2", "", "component3", "()Z", "guildWelcomeSheetId", "guildScheduledEventId", "ageGated", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Z)Lcom/discord/widgets/home/HomeConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getGuildScheduledEventId", "Z", "getAgeGated", "getGuildWelcomeSheetId", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class HomeConfig implements Serializable {
    private final boolean ageGated;
    private final Long guildScheduledEventId;
    private final Long guildWelcomeSheetId;

    public HomeConfig() {
        this(null, null, false, 7, null);
    }

    public HomeConfig(Long l, Long l2, boolean z2) {
        this.guildWelcomeSheetId = l;
        this.guildScheduledEventId = l2;
        this.ageGated = z2;
    }

    public static /* synthetic */ HomeConfig copy$default(HomeConfig homeConfig, Long l, Long l2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = homeConfig.guildWelcomeSheetId;
        }
        if ((i & 2) != 0) {
            l2 = homeConfig.guildScheduledEventId;
        }
        if ((i & 4) != 0) {
            z2 = homeConfig.ageGated;
        }
        return homeConfig.copy(l, l2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getGuildWelcomeSheetId() {
        return this.guildWelcomeSheetId;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAgeGated() {
        return this.ageGated;
    }

    public final HomeConfig copy(Long guildWelcomeSheetId, Long guildScheduledEventId, boolean ageGated) {
        return new HomeConfig(guildWelcomeSheetId, guildScheduledEventId, ageGated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeConfig)) {
            return false;
        }
        HomeConfig homeConfig = (HomeConfig) other;
        return Intrinsics3.areEqual(this.guildWelcomeSheetId, homeConfig.guildWelcomeSheetId) && Intrinsics3.areEqual(this.guildScheduledEventId, homeConfig.guildScheduledEventId) && this.ageGated == homeConfig.ageGated;
    }

    public final boolean getAgeGated() {
        return this.ageGated;
    }

    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final Long getGuildWelcomeSheetId() {
        return this.guildWelcomeSheetId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Long l = this.guildWelcomeSheetId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildScheduledEventId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        boolean z2 = this.ageGated;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HomeConfig(guildWelcomeSheetId=");
        sbU.append(this.guildWelcomeSheetId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", ageGated=");
        return outline.O(sbU, this.ageGated, ")");
    }

    public /* synthetic */ HomeConfig(Long l, Long l2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? false : z2);
    }
}
