package com.discord.api.stageinstance;

import b.d.b.a.outline;
import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: RecommendedStageInstanceGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/api/stageinstance/RecommendedStageInstanceGuild;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/guild/GuildFeature;", "features", "Ljava/util/Set;", "getFeatures", "()Ljava/util/Set;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "getName", "icon", "getIcon", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class RecommendedStageInstanceGuild {
    private final Set<GuildFeature> features;
    private final String icon;
    private final long id;
    private final String name;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedStageInstanceGuild)) {
            return false;
        }
        RecommendedStageInstanceGuild recommendedStageInstanceGuild = (RecommendedStageInstanceGuild) other;
        return this.id == recommendedStageInstanceGuild.id && Intrinsics3.areEqual(this.name, recommendedStageInstanceGuild.name) && Intrinsics3.areEqual(this.icon, recommendedStageInstanceGuild.icon) && Intrinsics3.areEqual(this.features, recommendedStageInstanceGuild.features);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<GuildFeature> set = this.features;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RecommendedStageInstanceGuild(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", features=");
        return outline.N(sbU, this.features, ")");
    }
}
