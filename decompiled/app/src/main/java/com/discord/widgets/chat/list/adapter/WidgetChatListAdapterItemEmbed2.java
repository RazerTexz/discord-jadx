package com.discord.widgets.chat.list.adapter;

import android.view.View;
import b.d.b.a.outline;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.media.WidgetMedia;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemEmbed$configureEmbedImage$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureEmbedImage$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed2 implements View.OnClickListener {
    public final /* synthetic */ MessageEmbed $embed$inlined;
    public final /* synthetic */ RenderableEmbedMedia $previewImage$inlined;
    public final /* synthetic */ MessageEmbed $this_apply;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed this$0;

    public WidgetChatListAdapterItemEmbed2(MessageEmbed messageEmbed, WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, RenderableEmbedMedia renderableEmbedMedia, MessageEmbed messageEmbed2) {
        this.$this_apply = messageEmbed;
        this.this$0 = widgetChatListAdapterItemEmbed;
        this.$previewImage$inlined = renderableEmbedMedia;
        this.$embed$inlined = messageEmbed2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String externalOpenUrl = EmbedResourceUtils.INSTANCE.getExternalOpenUrl(this.$this_apply);
        if (externalOpenUrl != null) {
            UriHandler.handleOrUntrusted(outline.x(view, "view", "view.context"), externalOpenUrl, this.$embed$inlined.getTitle());
        } else {
            WidgetMedia.INSTANCE.launch(outline.x(view, "view", "view.context"), this.$embed$inlined);
        }
    }
}
