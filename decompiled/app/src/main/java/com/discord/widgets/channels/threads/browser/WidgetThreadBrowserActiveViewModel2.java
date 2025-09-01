package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreThreadsActiveJoined;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0006 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "kotlin.jvm.PlatformType", "threadMap", "Lcom/discord/api/channel/Channel;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel2<T, R> implements Func1<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>> {
    public static final WidgetThreadBrowserActiveViewModel2 INSTANCE = new WidgetThreadBrowserActiveViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map) {
        return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Channel> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "threadMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((StoreThreadsActiveJoined.ActiveJoinedThread) entry.getValue()).getChannel());
        }
        return linkedHashMap;
    }
}
