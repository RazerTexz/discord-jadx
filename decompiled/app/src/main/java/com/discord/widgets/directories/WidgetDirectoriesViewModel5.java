package com.discord.widgets.directories;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import d0.Tuples;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.t._Maps;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetDirectoriesViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lkotlin/Pair;", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$ViewState$mappedTabs$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel5 extends Lambda implements Function0<List<? extends Tuples2<? extends DirectoryEntryCategory, ? extends Integer>>> {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel5(WidgetDirectoriesViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Tuples2<? extends DirectoryEntryCategory, ? extends Integer>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Tuples2<? extends DirectoryEntryCategory, ? extends Integer>> invoke2() {
        Map mapEmptyMap;
        List listListOf = CollectionsJVM.listOf(Tuples.to(DirectoryEntryCategory.Home, 0));
        Map<Integer, Integer> mapInvoke = this.this$0.getTabs().invoke();
        if (mapInvoke != null) {
            mapEmptyMap = new LinkedHashMap(MapsJVM.mapCapacity(mapInvoke.size()));
            Iterator<T> it = mapInvoke.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
                int iIntValue = ((Number) entry.getKey()).intValue();
                Channel channel = this.this$0.getChannel();
                boolean z2 = true;
                if (channel == null || !ChannelUtils.x(channel)) {
                    z2 = false;
                }
                mapEmptyMap.put(companion.findByKey(iIntValue, z2), entry.getValue());
            }
        } else {
            mapEmptyMap = null;
        }
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        return _Collections.plus((Collection) listListOf, (Iterable) _Maps.toList(mapEmptyMap));
    }
}
