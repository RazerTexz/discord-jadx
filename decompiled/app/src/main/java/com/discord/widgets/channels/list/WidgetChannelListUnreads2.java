package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelListUnreads.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/databinding/WidgetChannelsListUnreadsBinding;", "invoke", "()Lcom/discord/databinding/WidgetChannelsListUnreadsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelListUnreads2 extends Lambda implements Function0<WidgetChannelsListUnreadsBinding> {
    public final /* synthetic */ WidgetChannelListUnreads this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListUnreads2(WidgetChannelListUnreads widgetChannelListUnreads) {
        super(0);
        this.this$0 = widgetChannelListUnreads;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelsListUnreadsBinding invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelsListUnreadsBinding invoke() {
        View viewInflate = WidgetChannelListUnreads.access$getUnreadsStub$p(this.this$0).inflate();
        int i = R.id.channels_list_unreads;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channels_list_unreads);
        if (textView != null) {
            i = R.id.channels_list_unreads_background;
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.channels_list_unreads_background);
            if (relativeLayout != null) {
                WidgetChannelsListUnreadsBinding widgetChannelsListUnreadsBinding = new WidgetChannelsListUnreadsBinding((FrameLayout) viewInflate, textView, relativeLayout);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelsListUnreadsBinding, "WidgetChannelsListUnread…nd(unreadsStub.inflate())");
                return widgetChannelsListUnreadsBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
