package com.discord.widgets.user.search;

import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "it", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "invoke", "(Lcom/discord/models/user/User;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$1 extends Lambda implements Function1<User, WidgetGlobalSearchModel.ItemUser> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$1(WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, String str) {
        super(1);
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemUser invoke(User user) {
        return invoke2(user);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemUser invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        return WidgetGlobalSearchModel$Companion$create$2.invoke$default(this.$toItemUser$2, user, this.$sanitizedFilter, null, 2, null);
    }
}
