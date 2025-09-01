package com.discord.widgets.forums;

import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetForumBrowser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/widgets/forums/WidgetForumBrowser$configureListState$2$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureListState$$inlined$apply$lambda$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser6(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetForumBrowser.access$getViewModel$p(this.this$0).maybeFetchOlderPosts(this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
    }
}
