package com.discord.api.guild.preview;

import b.d.b.a.outline;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildPreview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0$8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001b\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0004¨\u0006/"}, d2 = {"Lcom/discord/api/guild/preview/GuildPreview;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "h", "()J", "banner", "Ljava/lang/String;", "getBanner", "featurableInDirectory", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "c", "icon", "g", ModelAuditLogEntry.CHANGE_KEY_NAME, "i", "approximatePresenceCount", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "approximateMemberCount", "a", "", "Lcom/discord/api/guild/GuildFeature;", "features", "Ljava/util/List;", "f", "()Ljava/util/List;", "Lcom/discord/api/emoji/GuildEmoji;", "emojis", "d", "splash", "j", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildPreview {
    private final Integer approximateMemberCount;
    private final Integer approximatePresenceCount;
    private final String banner;
    private final String description;
    private final List<GuildEmoji> emojis;
    private final Boolean featurableInDirectory;
    private final List<GuildFeature> features;
    private final String icon;
    private final long id;
    private final String name;
    private final String splash;

    /* renamed from: a, reason: from getter */
    public final Integer getApproximateMemberCount() {
        return this.approximateMemberCount;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<GuildEmoji> d() {
        return this.emojis;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getFeaturableInDirectory() {
        return this.featurableInDirectory;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPreview)) {
            return false;
        }
        GuildPreview guildPreview = (GuildPreview) other;
        return this.id == guildPreview.id && Intrinsics3.areEqual(this.name, guildPreview.name) && Intrinsics3.areEqual(this.description, guildPreview.description) && Intrinsics3.areEqual(this.splash, guildPreview.splash) && Intrinsics3.areEqual(this.banner, guildPreview.banner) && Intrinsics3.areEqual(this.icon, guildPreview.icon) && Intrinsics3.areEqual(this.approximatePresenceCount, guildPreview.approximatePresenceCount) && Intrinsics3.areEqual(this.approximateMemberCount, guildPreview.approximateMemberCount) && Intrinsics3.areEqual(this.emojis, guildPreview.emojis) && Intrinsics3.areEqual(this.features, guildPreview.features) && Intrinsics3.areEqual(this.featurableInDirectory, guildPreview.featurableInDirectory);
    }

    public final List<GuildFeature> f() {
        return this.features;
    }

    /* renamed from: g, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: h, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.splash;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.banner;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.icon;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.approximatePresenceCount;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.approximateMemberCount;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<GuildEmoji> list = this.emojis;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildFeature> list2 = this.features;
        int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool = this.featurableInDirectory;
        return iHashCode9 + (bool != null ? bool.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: j, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildPreview(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", splash=");
        sbU.append(this.splash);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", approximatePresenceCount=");
        sbU.append(this.approximatePresenceCount);
        sbU.append(", approximateMemberCount=");
        sbU.append(this.approximateMemberCount);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", featurableInDirectory=");
        return outline.D(sbU, this.featurableInDirectory, ")");
    }
}
