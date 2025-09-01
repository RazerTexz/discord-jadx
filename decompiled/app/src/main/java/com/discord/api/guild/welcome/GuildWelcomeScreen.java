package com.discord.api.guild.welcome;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildWelcomeScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "welcomeChannels", "Ljava/util/List;", "b", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "Ljava/lang/String;", "a", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildWelcomeScreen {
    private final String description;
    private final List<GuildWelcomeChannel> welcomeChannels;

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<GuildWelcomeChannel> b() {
        return this.welcomeChannels;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeScreen)) {
            return false;
        }
        GuildWelcomeScreen guildWelcomeScreen = (GuildWelcomeScreen) other;
        return Intrinsics3.areEqual(this.description, guildWelcomeScreen.description) && Intrinsics3.areEqual(this.welcomeChannels, guildWelcomeScreen.welcomeChannels);
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<GuildWelcomeChannel> list = this.welcomeChannels;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildWelcomeScreen(description=");
        sbU.append(this.description);
        sbU.append(", welcomeChannels=");
        return outline.L(sbU, this.welcomeChannels, ")");
    }
}
