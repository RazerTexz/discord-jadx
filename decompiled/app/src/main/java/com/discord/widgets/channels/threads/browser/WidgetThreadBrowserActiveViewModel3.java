package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001aÂ\u0001\u0012,\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000\u0012,\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000 \u0004*`\u0012,\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000\u0012,\u0012*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000\u0018\u00010\u00070\u00072.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\u0006\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "activeJoinedThreads", "activeThreads", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel3<T1, T2, R> implements Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>> {
    public static final WidgetThreadBrowserActiveViewModel3 INSTANCE = new WidgetThreadBrowserActiveViewModel3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2) {
        return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Map<Long, Channel>, Map<Long, Channel>> call2(Map<Long, Channel> map, Map<Long, Channel> map2) {
        return new Tuples2<>(map, map2);
    }
}
