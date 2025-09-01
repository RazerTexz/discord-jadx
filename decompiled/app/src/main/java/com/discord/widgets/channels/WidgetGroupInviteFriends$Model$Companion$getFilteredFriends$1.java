package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0014 \u0001*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "it", "", "Lcom/discord/primitives/UserId;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/User;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1<T, R> implements Func1<User, Long> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Long call(User user) {
        return call2(user);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(User user) {
        return Long.valueOf(user.getId());
    }
}
