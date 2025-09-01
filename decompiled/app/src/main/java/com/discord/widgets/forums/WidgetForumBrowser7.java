package com.discord.widgets.forums;

import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumBrowser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "newState", "", "invoke", "(I)V", "com/discord/widgets/forums/WidgetForumBrowser$configureListState$2$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureListState$$inlined$apply$lambda$4, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser7 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser7(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetForumBrowser.access$enqueueForumPostFirstMessageFetches(this.this$0, this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
        if (i == 0) {
            WidgetForumBrowserViewModel.maybeFetchForumPostFirstMessages$default(WidgetForumBrowser.access$getViewModel$p(this.this$0), this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId(), false, 4, null);
        }
    }
}
