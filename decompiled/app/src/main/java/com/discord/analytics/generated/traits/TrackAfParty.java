package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAfParty.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackAfParty;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "afRecentlyPlayed", "Ljava/lang/Boolean;", "getAfRecentlyPlayed", "()Ljava/lang/Boolean;", "", "afPeopleCount", "Ljava/lang/Long;", "getAfPeopleCount", "()Ljava/lang/Long;", "afVoiceChat", "getAfVoiceChat", "afRichPresence", "getAfRichPresence", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAfParty {
    private final Boolean afVoiceChat = null;
    private final Long afPeopleCount = null;
    private final Boolean afRecentlyPlayed = null;
    private final Boolean afRichPresence = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfParty)) {
            return false;
        }
        TrackAfParty trackAfParty = (TrackAfParty) other;
        return Intrinsics3.areEqual(this.afVoiceChat, trackAfParty.afVoiceChat) && Intrinsics3.areEqual(this.afPeopleCount, trackAfParty.afPeopleCount) && Intrinsics3.areEqual(this.afRecentlyPlayed, trackAfParty.afRecentlyPlayed) && Intrinsics3.areEqual(this.afRichPresence, trackAfParty.afRichPresence);
    }

    public int hashCode() {
        Boolean bool = this.afVoiceChat;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.afPeopleCount;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.afRecentlyPlayed;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.afRichPresence;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfParty(afVoiceChat=");
        sbU.append(this.afVoiceChat);
        sbU.append(", afPeopleCount=");
        sbU.append(this.afPeopleCount);
        sbU.append(", afRecentlyPlayed=");
        sbU.append(this.afRecentlyPlayed);
        sbU.append(", afRichPresence=");
        return outline.D(sbU, this.afRichPresence, ")");
    }
}
