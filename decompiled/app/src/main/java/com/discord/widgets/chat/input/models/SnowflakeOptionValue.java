package com.discord.widgets.chat.input.models;

import kotlin.Metadata;

/* compiled from: CommandOptionValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/chat/input/models/SnowflakeOptionValue;", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "", "Lcom/discord/primitives/Snowflake;", "snowflake", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SnowflakeOptionValue extends CommandOptionValue {
    public SnowflakeOptionValue(long j) {
        super(String.valueOf(j), null);
    }
}
