package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackGuildMembershipGateMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackGuildMembershipGateMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "previewEnabled", "Ljava/lang/Boolean;", "getPreviewEnabled", "()Ljava/lang/Boolean;", "", "", "requirements", "Ljava/util/List;", "getRequirements", "()Ljava/util/List;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildMembershipGateMetadata {
    private final Boolean previewEnabled = null;
    private final List<CharSequence> requirements = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildMembershipGateMetadata)) {
            return false;
        }
        TrackGuildMembershipGateMetadata trackGuildMembershipGateMetadata = (TrackGuildMembershipGateMetadata) other;
        return Intrinsics3.areEqual(this.previewEnabled, trackGuildMembershipGateMetadata.previewEnabled) && Intrinsics3.areEqual(this.requirements, trackGuildMembershipGateMetadata.requirements);
    }

    public int hashCode() {
        Boolean bool = this.previewEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<CharSequence> list = this.requirements;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildMembershipGateMetadata(previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", requirements=");
        return outline.L(sbU, this.requirements, ")");
    }
}
