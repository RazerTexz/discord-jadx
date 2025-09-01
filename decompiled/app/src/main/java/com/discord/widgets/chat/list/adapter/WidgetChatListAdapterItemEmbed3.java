package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.media.WidgetMedia;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemEmbed$configureInlineEmbed$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed3 implements View.OnClickListener {
    public final /* synthetic */ MessageEmbed $embed$inlined;
    public final /* synthetic */ InlineMediaView $this_apply;

    public WidgetChatListAdapterItemEmbed3(InlineMediaView inlineMediaView, MessageEmbed messageEmbed) {
        this.$this_apply = inlineMediaView;
        this.$embed$inlined = messageEmbed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetMedia.Companion companion = WidgetMedia.INSTANCE;
        InlineMediaView inlineMediaView = this.$this_apply;
        Intrinsics3.checkNotNullExpressionValue(inlineMediaView, "this");
        Context context = inlineMediaView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "this.context");
        companion.launch(context, this.$embed$inlined);
    }
}
