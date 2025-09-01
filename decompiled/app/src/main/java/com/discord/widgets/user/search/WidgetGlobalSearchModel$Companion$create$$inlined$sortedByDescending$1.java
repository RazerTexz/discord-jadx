package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.u.a;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: Comparisons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1<T> implements Comparator {
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext$inlined;

    public WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1(WidgetGlobalSearchModel.SearchContext searchContext) {
        this.$searchContext$inlined = searchContext;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        WidgetGlobalSearchScoreStrategy widgetGlobalSearchScoreStrategy = WidgetGlobalSearchScoreStrategy.INSTANCE;
        return a.compareValues(Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel.ItemDataPayload) t2, this.$searchContext$inlined.getSearchType(), this.$searchContext$inlined.getFrecencyChannels())), Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel.ItemDataPayload) t, this.$searchContext$inlined.getSearchType(), this.$searchContext$inlined.getFrecencyChannels())));
    }
}
