package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadBrowserActive.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActive4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetThreadBrowserActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActive4(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        super(0);
        this.this$0 = widgetThreadBrowserActive;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        return arguments.getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
