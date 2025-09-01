package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGuildScheduledEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackGuildScheduledEvent;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "associatedToDirectoryChannel", "Ljava/lang/Boolean;", "getAssociatedToDirectoryChannel", "()Ljava/lang/Boolean;", "isEveryoneRoleVisible", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEvent {
    private final Boolean isEveryoneRoleVisible = null;
    private final Boolean associatedToDirectoryChannel = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildScheduledEvent)) {
            return false;
        }
        TrackGuildScheduledEvent trackGuildScheduledEvent = (TrackGuildScheduledEvent) other;
        return Intrinsics3.areEqual(this.isEveryoneRoleVisible, trackGuildScheduledEvent.isEveryoneRoleVisible) && Intrinsics3.areEqual(this.associatedToDirectoryChannel, trackGuildScheduledEvent.associatedToDirectoryChannel);
    }

    public int hashCode() {
        Boolean bool = this.isEveryoneRoleVisible;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.associatedToDirectoryChannel;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildScheduledEvent(isEveryoneRoleVisible=");
        sbU.append(this.isEveryoneRoleVisible);
        sbU.append(", associatedToDirectoryChannel=");
        return outline.D(sbU, this.associatedToDirectoryChannel, ")");
    }
}
