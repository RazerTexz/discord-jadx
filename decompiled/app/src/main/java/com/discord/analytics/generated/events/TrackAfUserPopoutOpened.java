package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfParty2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAfUserPopoutOpened.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\bR\u001b\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u0010-¨\u00067"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAfUserPopoutOpened;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfCardReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfGameReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfPartyReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackAfGame;", "trackAfGame", "Lcom/discord/analytics/generated/traits/TrackAfGame;", "getTrackAfGame", "()Lcom/discord/analytics/generated/traits/TrackAfGame;", "setTrackAfGame", "(Lcom/discord/analytics/generated/traits/TrackAfGame;)V", "Lcom/discord/analytics/generated/traits/TrackAfParty;", "trackAfParty", "Lcom/discord/analytics/generated/traits/TrackAfParty;", "getTrackAfParty", "()Lcom/discord/analytics/generated/traits/TrackAfParty;", "setTrackAfParty", "(Lcom/discord/analytics/generated/traits/TrackAfParty;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "avatarPosition", "Ljava/lang/Long;", "getAvatarPosition", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackAfCard;", "trackAfCard", "Lcom/discord/analytics/generated/traits/TrackAfCard;", "getTrackAfCard", "()Lcom/discord/analytics/generated/traits/TrackAfCard;", "setTrackAfCard", "(Lcom/discord/analytics/generated/traits/TrackAfCard;)V", "popoutUserId", "getPopoutUserId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAfUserPopoutOpened implements AnalyticsSchema, TrackBase2, TrackAfCard2, TrackAfGame2, TrackAfParty2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackAfParty trackAfParty;
    private TrackBase trackBase;
    private final Long popoutUserId = null;
    private final Long avatarPosition = null;
    private final transient String analyticsSchemaTypeName = "af_user_popout_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfUserPopoutOpened)) {
            return false;
        }
        TrackAfUserPopoutOpened trackAfUserPopoutOpened = (TrackAfUserPopoutOpened) other;
        return Intrinsics3.areEqual(this.popoutUserId, trackAfUserPopoutOpened.popoutUserId) && Intrinsics3.areEqual(this.avatarPosition, trackAfUserPopoutOpened.avatarPosition);
    }

    public int hashCode() {
        Long l = this.popoutUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.avatarPosition;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfUserPopoutOpened(popoutUserId=");
        sbU.append(this.popoutUserId);
        sbU.append(", avatarPosition=");
        return outline.G(sbU, this.avatarPosition, ")");
    }
}
