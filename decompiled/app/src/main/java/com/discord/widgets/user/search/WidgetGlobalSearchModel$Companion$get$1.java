package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\b\u0012\u00060\fj\u0002`\r0\b¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "p1", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;", "p2", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "p3", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "p4", "Lkotlin/Function1;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "p5", "", "Lcom/discord/primitives/ChannelId;", "p6", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "invoke", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$1 extends FunctionReferenceImpl implements Function6<WidgetGlobalSearchModel.SearchContext, WidgetGlobalSearchModel.UsersContext, WidgetGlobalSearchModel.ChannelContext, WidgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel.ItemDataPayload, ? extends Boolean>, Function1<? super WidgetGlobalSearchModel.SearchContext, ? extends Long>, WidgetGlobalSearchModel> {
    public WidgetGlobalSearchModel$Companion$get$1(WidgetGlobalSearchModel.Companion companion) {
        super(6, companion, WidgetGlobalSearchModel.Companion.class, "create", "create(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel invoke(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.UsersContext usersContext, WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel.ItemDataPayload, ? extends Boolean> function1, Function1<? super WidgetGlobalSearchModel.SearchContext, ? extends Long> function12) {
        return invoke2(searchContext, usersContext, channelContext, widgetGlobalSearchGuildsModel, (Function1<? super WidgetGlobalSearchModel.ItemDataPayload, Boolean>) function1, (Function1<? super WidgetGlobalSearchModel.SearchContext, Long>) function12);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel invoke2(WidgetGlobalSearchModel.SearchContext searchContext, WidgetGlobalSearchModel.UsersContext usersContext, WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1<? super WidgetGlobalSearchModel.ItemDataPayload, Boolean> function1, Function1<? super WidgetGlobalSearchModel.SearchContext, Long> function12) {
        Intrinsics3.checkNotNullParameter(searchContext, "p1");
        Intrinsics3.checkNotNullParameter(usersContext, "p2");
        Intrinsics3.checkNotNullParameter(channelContext, "p3");
        Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsModel, "p4");
        Intrinsics3.checkNotNullParameter(function12, "p6");
        return ((WidgetGlobalSearchModel.Companion) this.receiver).create(searchContext, usersContext, channelContext, widgetGlobalSearchGuildsModel, function1, function12);
    }
}
