package com.discord.models.invite;

import com.discord.models.domain.ModelInvite;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InviteUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "Lcom/discord/utilities/time/Clock;", "clock", "", "isValid", "(Lcom/discord/models/domain/ModelInvite;Lcom/discord/utilities/time/Clock;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.invite.InviteUtilsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class InviteUtils2 {
    public static final boolean isValid(ModelInvite modelInvite, Clock clock) {
        Intrinsics3.checkNotNullParameter(modelInvite, "$this$isValid");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return modelInvite.getExpirationTime() < clock.currentTimeMillis() && !modelInvite.isRevoked();
    }

    public static /* synthetic */ boolean isValid$default(ModelInvite modelInvite, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return isValid(modelInvite, clock);
    }
}
