package com.discord.models.commands;

import com.discord.api.user.User;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/models/commands/Application;", "", "hasBotAvatar", "(Lcom/discord/models/commands/Application;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.ApplicationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Application3 {
    public static final boolean hasBotAvatar(Application application) {
        Intrinsics3.checkNotNullParameter(application, "$this$hasBotAvatar");
        User bot = application.getBot();
        return (bot != null ? bot.a() : null) instanceof NullSerializable.b;
    }
}
