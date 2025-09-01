package com.discord.widgets.user.search;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00060\u0001j\u0002`\u00022\u001a\u0010\u0004\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/MessageId;", "it", "invoke", "(Ljava/util/Map$Entry;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getRecentChannelIds$2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends Long>, Long> {
    public static final WidgetGlobalSearchModel$Companion$getRecentChannelIds$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getRecentChannelIds$2();

    public WidgetGlobalSearchModel$Companion$getRecentChannelIds$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends Long> entry) {
        return Long.valueOf(invoke2((Map.Entry<Long, Long>) entry));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(Map.Entry<Long, Long> entry) {
        Intrinsics3.checkNotNullParameter(entry, "it");
        return entry.getKey().longValue();
    }
}
