package com.discord.widgets.chat.list.adapter;

import android.view.View;
import b.d.b.a.outline;
import com.discord.utilities.uri.UriHandler;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed4 implements View.OnClickListener {
    public final /* synthetic */ String $mask;
    public final /* synthetic */ String $url;

    public WidgetChatListAdapterItemEmbed4(String str, String str2) {
        this.$url = str;
        this.$mask = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handleOrUntrusted(outline.x(view, "view", "view.context"), this.$url, this.$mask);
    }
}
