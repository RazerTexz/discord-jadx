package com.discord.api.hubs;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: EmailVerification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/discord/api/hubs/EmailVerification;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/hubs/GuildInfo;", "guildsInfo", "Ljava/util/List;", "a", "()Ljava/util/List;", "hasMatchingGuild", "Z", "b", "()Z", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EmailVerification {
    private final List<EmailVerification3> guildsInfo;
    private final boolean hasMatchingGuild;

    public final List<EmailVerification3> a() {
        return this.guildsInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMatchingGuild() {
        return this.hasMatchingGuild;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerification)) {
            return false;
        }
        EmailVerification emailVerification = (EmailVerification) other;
        return Intrinsics3.areEqual(this.guildsInfo, emailVerification.guildsInfo) && this.hasMatchingGuild == emailVerification.hasMatchingGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<EmailVerification3> list = this.guildsInfo;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMatchingGuild;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmailVerification(guildsInfo=");
        sbU.append(this.guildsInfo);
        sbU.append(", hasMatchingGuild=");
        return outline.O(sbU, this.hasMatchingGuild, ")");
    }
}
