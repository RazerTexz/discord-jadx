package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.u.a;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: Comparisons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1<T> implements Comparator {
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext$inlined;

    public WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1(WidgetGlobalSearchModel.SearchContext searchContext) {
        this.$searchContext$inlined = searchContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(T t, T t2) {
        int iIntValue;
        Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) t).getChannel();
        int iIntValue2 = Integer.MAX_VALUE;
        if (channel != null) {
            Integer numValueOf = Integer.valueOf(this.$searchContext$inlined.getRecentGuildIds().indexOf(Long.valueOf(channel.getGuildId())));
            if (!(numValueOf.intValue() != -1)) {
                numValueOf = null;
            }
            iIntValue = numValueOf != null ? numValueOf.intValue() : Integer.MAX_VALUE;
        }
        Integer numValueOf2 = Integer.valueOf(iIntValue);
        Channel channel2 = ((WidgetGlobalSearchModel.ItemDataPayload) t2).getChannel();
        if (channel2 != null) {
            Integer numValueOf3 = Integer.valueOf(this.$searchContext$inlined.getRecentGuildIds().indexOf(Long.valueOf(channel2.getGuildId())));
            Integer num = numValueOf3.intValue() != -1 ? numValueOf3 : null;
            if (num != null) {
                iIntValue2 = num.intValue();
            }
        }
        return a.compareValues(numValueOf2, Integer.valueOf(iIntValue2));
    }
}
