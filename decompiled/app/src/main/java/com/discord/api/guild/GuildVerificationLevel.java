package com.discord.api.guild;

import kotlin.Metadata;

/* compiled from: GuildVerificationLevel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/api/guild/GuildVerificationLevel;", "", "", "apiValue", "I", "getApiValue", "()I", "<init>", "(Ljava/lang/String;II)V", "NONE", "LOW", "MEDIUM", "HIGH", "HIGHEST", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum GuildVerificationLevel {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    HIGHEST(4);

    private final int apiValue;

    GuildVerificationLevel(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
