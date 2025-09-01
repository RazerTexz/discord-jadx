package com.discord.widgets.channels.permissions;

import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/User;", "p1", "p2", "", "invoke", "(Lcom/discord/models/user/User;Lcom/discord/models/user/User;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsAdvanced3 extends FunctionReferenceImpl implements Function2<User, User, Integer> {
    public static final WidgetChannelSettingsPermissionsAdvanced3 INSTANCE = new WidgetChannelSettingsPermissionsAdvanced3();

    public WidgetChannelSettingsPermissionsAdvanced3() {
        super(2, UserUtils.class, "compareUserNames", "compareUserNames(Lcom/discord/models/user/User;Lcom/discord/models/user/User;)I", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(User user, User user2) {
        return Integer.valueOf(invoke2(user, user2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(User user, User user2) {
        return UserUtils.INSTANCE.compareUserNames(user, user2);
    }
}
