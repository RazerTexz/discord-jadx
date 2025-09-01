package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "com/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$configureUI$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$3(TextView textView, WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, WidgetChannelsListItemChannelActions.Model model) {
        super(1);
        this.$this_apply = textView;
        this.this$0 = widgetChannelsListItemChannelActions;
        this.$this_configureUI$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        if (this.$this_configureUI$inlined.isMuted()) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            Context context = this.$this_apply.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            StoreUserGuildSettings.setChannelMuted$default(userGuildSettings, context, this.$this_configureUI$inlined.getChannel().getId(), false, null, 8, null);
            return;
        }
        WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
        long id2 = this.$this_configureUI$inlined.getChannel().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForChannel(id2, parentFragmentManager);
    }
}
