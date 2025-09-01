package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackRolePageViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$R\u001b\u0010.\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0011R\u001b\u00100\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010$R\u001c\u00102\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0006¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRolePageViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isEveryone", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "roleHoist", "getRoleHoist", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "", "tabOpened", "Ljava/lang/CharSequence;", "getTabOpened", "()Ljava/lang/CharSequence;", "", "rolePermissions", "Ljava/lang/Long;", "getRolePermissions", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "roleId", "getRoleId", "roleMentionable", "getRoleMentionable", "roleNumMembers", "getRoleNumMembers", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRolePageViewed implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence tabOpened = null;
    private final Boolean isEveryone = null;
    private final Long roleId = null;
    private final Boolean roleMentionable = null;
    private final Boolean roleHoist = null;
    private final Long rolePermissions = null;
    private final Long roleNumMembers = null;
    private final transient String analyticsSchemaTypeName = "role_page_viewed";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRolePageViewed)) {
            return false;
        }
        TrackRolePageViewed trackRolePageViewed = (TrackRolePageViewed) other;
        return Intrinsics3.areEqual(this.tabOpened, trackRolePageViewed.tabOpened) && Intrinsics3.areEqual(this.isEveryone, trackRolePageViewed.isEveryone) && Intrinsics3.areEqual(this.roleId, trackRolePageViewed.roleId) && Intrinsics3.areEqual(this.roleMentionable, trackRolePageViewed.roleMentionable) && Intrinsics3.areEqual(this.roleHoist, trackRolePageViewed.roleHoist) && Intrinsics3.areEqual(this.rolePermissions, trackRolePageViewed.rolePermissions) && Intrinsics3.areEqual(this.roleNumMembers, trackRolePageViewed.roleNumMembers);
    }

    public int hashCode() {
        CharSequence charSequence = this.tabOpened;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isEveryone;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.roleId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.roleMentionable;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.roleHoist;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.rolePermissions;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.roleNumMembers;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRolePageViewed(tabOpened=");
        sbU.append(this.tabOpened);
        sbU.append(", isEveryone=");
        sbU.append(this.isEveryone);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", roleMentionable=");
        sbU.append(this.roleMentionable);
        sbU.append(", roleHoist=");
        sbU.append(this.roleHoist);
        sbU.append(", rolePermissions=");
        sbU.append(this.rolePermissions);
        sbU.append(", roleNumMembers=");
        return outline.G(sbU, this.roleNumMembers, ")");
    }
}
