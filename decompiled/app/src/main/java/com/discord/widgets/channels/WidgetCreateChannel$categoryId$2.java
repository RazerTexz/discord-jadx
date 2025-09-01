package com.discord.widgets.channels;

import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCreateChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "invoke", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateChannel$categoryId$2 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetCreateChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$categoryId$2(WidgetCreateChannel widgetCreateChannel) {
        super(0);
        this.this$0 = widgetCreateChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "INTENT_CATEGORY_ID");
    }
}
