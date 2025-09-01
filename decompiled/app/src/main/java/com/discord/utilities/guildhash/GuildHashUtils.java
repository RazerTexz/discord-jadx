package com.discord.utilities.guildhash;

import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildHashUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/guildhash/GuildHashes;", "", "isSupported", "(Lcom/discord/api/guildhash/GuildHashes;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guildhash.GuildHashUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildHashUtils {
    public static final boolean isSupported(GuildHashes guildHashes) {
        Intrinsics3.checkNotNullParameter(guildHashes, "$this$isSupported");
        return guildHashes.getVersion() == 1;
    }
}
