package com.discord.api.commands;

import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/discord/api/commands/GuildApplicationCommands;", "", "", "guildId", "J", "getGuildId", "()J", "updatedAt", "getUpdatedAt", "", "Lcom/discord/api/commands/Application;", "applications", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "nonce", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Lcom/discord/api/commands/ApplicationCommand;", "applicationCommands", "a", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildApplicationCommands {
    private final List<ApplicationCommand> applicationCommands;
    private final List<Application> applications;
    private final long guildId;
    private final String nonce;
    private final long updatedAt;

    public final List<ApplicationCommand> a() {
        return this.applicationCommands;
    }

    public final List<Application> b() {
        return this.applications;
    }

    /* renamed from: c, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }
}
