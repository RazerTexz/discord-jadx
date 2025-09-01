package com.discord.utilities.analytics;

import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.CollectionExtensions;
import d0.t.Maps6;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticsTracker$searchResultViewed$propertyProvider$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsTracker3 extends Lambda implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ Traits.Location $locationTrait;
    public final /* synthetic */ Integer $lockedResultsCount;
    public final /* synthetic */ Map $properties;
    public final /* synthetic */ SearchType $searchType;
    public final /* synthetic */ int $totalResultsCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker3(SearchType searchType, int i, Integer num, Traits.Location location, Map map) {
        super(0);
        this.$searchType = searchType;
        this.$totalResultsCount = i;
        this.$lockedResultsCount = num;
        this.$locationTrait = location;
        this.$properties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("search_type", this.$searchType.name());
        linkedHashMap.put("total_results", Integer.valueOf(this.$totalResultsCount));
        Integer num = this.$lockedResultsCount;
        if (num != null) {
            linkedHashMap.put("num_results_locked", num);
        }
        Traits.Location location = this.$locationTrait;
        if (location != null) {
            location.serializeTo(linkedHashMap);
        }
        return Maps6.plus(linkedHashMap, CollectionExtensions.filterNonNullValues(this.$properties));
    }
}
