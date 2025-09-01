package com.discord.widgets.user.search;

import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "it", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "invoke", "(J)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2 extends Lambda implements Function1<Long, WidgetGlobalSearchModel.ItemUser> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2(WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.UsersContext usersContext, String str) {
        super(1);
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$usersContext = usersContext;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemUser invoke(Long l) {
        return invoke(l.longValue());
    }

    public final WidgetGlobalSearchModel.ItemUser invoke(long j) {
        User user = this.$usersContext.getUsers().get(Long.valueOf(j));
        if (user != null) {
            return WidgetGlobalSearchModel$Companion$create$2.invoke$default(this.$toItemUser$2, user, this.$sanitizedFilter, null, 2, null);
        }
        return null;
    }
}
