package com.discord.api.hubs;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: EmailVerification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/api/hubs/EmailVerificationCode;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guild/Guild;", "guild", "Lcom/discord/api/guild/Guild;", "a", "()Lcom/discord/api/guild/Guild;", "joined", "Z", "b", "()Z", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.hubs.EmailVerificationCode, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class EmailVerification2 {
    private final Guild guild;
    private final boolean joined;

    /* renamed from: a, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getJoined() {
        return this.joined;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerification2)) {
            return false;
        }
        EmailVerification2 emailVerification2 = (EmailVerification2) other;
        return Intrinsics3.areEqual(this.guild, emailVerification2.guild) && this.joined == emailVerification2.joined;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.joined;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmailVerificationCode(guild=");
        sbU.append(this.guild);
        sbU.append(", joined=");
        return outline.O(sbU, this.joined, ")");
    }
}
