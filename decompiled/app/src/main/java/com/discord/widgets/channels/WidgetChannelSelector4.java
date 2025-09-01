package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.channels.WidgetChannelSelector;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: WidgetChannelSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007 \u0004*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channels", "", "Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelSelector$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSelector4<T, R> implements Func1<Map<Long, ? extends Channel>, List<? extends WidgetChannelSelector.Model.Item>> {
    public final /* synthetic */ WidgetChannelSelector.FilterFunction $filterFunction;
    public final /* synthetic */ boolean $includeNoChannel;

    public WidgetChannelSelector4(WidgetChannelSelector.FilterFunction filterFunction, boolean z2) {
        this.$filterFunction = filterFunction;
        this.$includeNoChannel = z2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends WidgetChannelSelector.Model.Item> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<WidgetChannelSelector.Model.Item> call2(Map<Long, Channel> map) {
        Collection<Channel> collectionValues = map.values();
        WidgetChannelSelector.FilterFunction filterFunction = this.$filterFunction;
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (filterFunction.includeChannel((Channel) t)) {
                arrayList.add(t);
            }
        }
        List listListOf = this.$includeNoChannel ? CollectionsJVM.listOf(new WidgetChannelSelector.Model.Item(null, 0, null, 6, null)) : Collections2.emptyList();
        List listSortedWith = _Collections.sortedWith(arrayList, ChannelUtils.h(Channel.INSTANCE));
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        Iterator<T> it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList2.add(new WidgetChannelSelector.Model.Item((Channel) it.next(), 0, null, 6, null));
        }
        return _Collections.plus((Collection) listListOf, (Iterable) arrayList2);
    }
}
