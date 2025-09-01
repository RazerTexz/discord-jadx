package com.discord.api.report;

import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/discord/api/report/ReportType;", "", "", "pathValue", "Ljava/lang/String;", "getPathValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Message", "StageChannel", "DirectoryServer", "GuildScheduledEvent", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum ReportType {
    Message("message"),
    StageChannel("stage_channel"),
    DirectoryServer("guild_directory_entry"),
    GuildScheduledEvent("guild_scheduled_event");

    private final String pathValue;

    ReportType(String str) {
        this.pathValue = str;
    }

    public final String getPathValue() {
        return this.pathValue;
    }
}
