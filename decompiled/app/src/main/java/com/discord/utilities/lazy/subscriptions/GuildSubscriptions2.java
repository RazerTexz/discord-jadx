package com.discord.utilities.lazy.subscriptions;

import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.Ranges2;

/* compiled from: GuildSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a \u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptions$serializedRanges$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildSubscriptions2 extends Lambda implements Function0<Map<Long, ? extends List<? extends List<? extends Integer>>>> {
    public final /* synthetic */ GuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptions2(GuildSubscriptions guildSubscriptions) {
        super(0);
        this.this$0 = guildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends List<? extends Integer>>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends List<? extends List<? extends Integer>>> invoke2() {
        Map<Long, List<Ranges2>> channels = this.this$0.getChannels();
        if (channels == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(channels.size()));
        Iterator<T> it = channels.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            List<Ranges2> list = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (Ranges2 ranges2 : list) {
                arrayList.add(Collections2.listOf((Object[]) new Integer[]{Integer.valueOf(ranges2.getFirst()), Integer.valueOf(ranges2.getLast())}));
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }
}
