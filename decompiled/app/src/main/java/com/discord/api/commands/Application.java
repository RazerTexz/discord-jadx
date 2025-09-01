package com.discord.api.commands;

import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/discord/api/commands/Application;", "Ljava/io/Serializable;", "Lcom/discord/api/user/User;", "bot", "Lcom/discord/api/user/User;", "a", "()Lcom/discord/api/user/User;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "", "icon", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "builtIn", "Z", "getBuiltIn", "()Z", "", "commandCount", "I", "b", "()I", ModelAuditLogEntry.CHANGE_KEY_NAME, "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Application implements Serializable {
    private final User bot;
    private final boolean builtIn;
    private final int commandCount;
    private final String icon;
    private final long id;
    private final String name;

    /* renamed from: a, reason: from getter */
    public final User getBot() {
        return this.bot;
    }

    /* renamed from: b, reason: from getter */
    public final int getCommandCount() {
        return this.commandCount;
    }

    /* renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final long getId() {
        return this.id;
    }
}
