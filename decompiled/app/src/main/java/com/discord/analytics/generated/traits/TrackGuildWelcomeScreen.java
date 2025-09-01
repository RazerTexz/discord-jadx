package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackGuildWelcomeScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackGuildWelcomeScreen;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "optionsChannelIds", "Ljava/util/List;", "getOptionsChannelIds", "()Ljava/util/List;", "", "guildDescription", "Ljava/lang/CharSequence;", "getGuildDescription", "()Ljava/lang/CharSequence;", "options", "getOptions", "hasCustomEmojis", "Ljava/lang/Boolean;", "getHasCustomEmojis", "()Ljava/lang/Boolean;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildWelcomeScreen {
    private final List<CharSequence> options = null;
    private final List<Long> optionsChannelIds = null;
    private final CharSequence guildDescription = null;
    private final Boolean hasCustomEmojis = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildWelcomeScreen)) {
            return false;
        }
        TrackGuildWelcomeScreen trackGuildWelcomeScreen = (TrackGuildWelcomeScreen) other;
        return Intrinsics3.areEqual(this.options, trackGuildWelcomeScreen.options) && Intrinsics3.areEqual(this.optionsChannelIds, trackGuildWelcomeScreen.optionsChannelIds) && Intrinsics3.areEqual(this.guildDescription, trackGuildWelcomeScreen.guildDescription) && Intrinsics3.areEqual(this.hasCustomEmojis, trackGuildWelcomeScreen.hasCustomEmojis);
    }

    public int hashCode() {
        List<CharSequence> list = this.options;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Long> list2 = this.optionsChannelIds;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.guildDescription;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasCustomEmojis;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildWelcomeScreen(options=");
        sbU.append(this.options);
        sbU.append(", optionsChannelIds=");
        sbU.append(this.optionsChannelIds);
        sbU.append(", guildDescription=");
        sbU.append(this.guildDescription);
        sbU.append(", hasCustomEmojis=");
        return outline.D(sbU, this.hasCustomEmojis, ")");
    }
}
