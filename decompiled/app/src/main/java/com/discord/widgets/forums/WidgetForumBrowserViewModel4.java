package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumBrowserViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/forums/ForumBrowserItem$PostItem;", "invoke", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/forums/ForumBrowserItem$PostItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel4 extends Lambda implements Function1<Channel, ForumBrowserItem.PostItem> {
    public final /* synthetic */ WidgetForumBrowserViewModel.AnonymousClass1 $convertChannelToPostItem$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel4(WidgetForumBrowserViewModel.AnonymousClass1 anonymousClass1) {
        super(1);
        this.$convertChannelToPostItem$1 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ForumBrowserItem.PostItem invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ForumBrowserItem.PostItem invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return this.$convertChannelToPostItem$1.invoke2(channel);
    }
}
