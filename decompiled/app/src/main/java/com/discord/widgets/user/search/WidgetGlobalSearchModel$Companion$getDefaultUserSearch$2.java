package com.discord.widgets.user.search;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "it", "", "invoke", "(Lcom/discord/models/user/User;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2 extends Lambda implements Function1<User, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2();

    public WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(User user) {
        return Boolean.valueOf(invoke2(user));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        return user.isBot();
    }
}
