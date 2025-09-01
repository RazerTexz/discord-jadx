package com.discord.widgets.forums;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetForumBrowser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/forums/WidgetForumBrowser$configureGuidelinesButton$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser3 implements View.OnClickListener {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    public WidgetForumBrowser3(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, this.$viewState$inlined.getGuildId(), this.$viewState$inlined.getChannelId(), "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY");
    }
}
