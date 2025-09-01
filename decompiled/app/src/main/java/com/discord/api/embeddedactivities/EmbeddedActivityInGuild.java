package com.discord.api.embeddedactivities;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: EmbeddedActivityInGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR#\u0010\u000f\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u00060\rj\u0002`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/discord/api/embeddedactivities/EmbeddedActivityInGuild;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "Lcom/discord/primitives/UserId;", "users", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "a", "()J", "Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "embeddedActivity", "Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "b", "()Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EmbeddedActivityInGuild {
    private final long channelId;
    private final EmbeddedActivity embeddedActivity;
    private final List<Long> users;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final EmbeddedActivity getEmbeddedActivity() {
        return this.embeddedActivity;
    }

    public final List<Long> c() {
        return this.users;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivityInGuild)) {
            return false;
        }
        EmbeddedActivityInGuild embeddedActivityInGuild = (EmbeddedActivityInGuild) other;
        return this.channelId == embeddedActivityInGuild.channelId && Intrinsics3.areEqual(this.embeddedActivity, embeddedActivityInGuild.embeddedActivity) && Intrinsics3.areEqual(this.users, embeddedActivityInGuild.users);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        EmbeddedActivity embeddedActivity = this.embeddedActivity;
        int iHashCode = (i + (embeddedActivity != null ? embeddedActivity.hashCode() : 0)) * 31;
        List<Long> list = this.users;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbeddedActivityInGuild(channelId=");
        sbU.append(this.channelId);
        sbU.append(", embeddedActivity=");
        sbU.append(this.embeddedActivity);
        sbU.append(", users=");
        return outline.L(sbU, this.users, ")");
    }
}
