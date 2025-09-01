package com.discord.widgets.user.search;

import com.discord.utilities.frecency.FrecencyTracker;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: ChannelFrecencyTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/search/ChannelFrecencyTracker;", "Lcom/discord/utilities/frecency/FrecencyTracker;", "", "Lcom/discord/primitives/ChannelId;", "", "currentTime", "", "computeScore", "(Ljava/util/List;J)I", "oldestAllowedDeltaMs", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ChannelFrecencyTracker extends FrecencyTracker<Long> {
    private final long oldestAllowedDeltaMs;

    public ChannelFrecencyTracker() {
        super(35, 10);
        this.oldestAllowedDeltaMs = TimeUnit.MILLISECONDS.convert(7L, TimeUnit.DAYS);
    }

    @Override // com.discord.utilities.frecency.FrecencyTracker
    public int computeScore(List<Long> list, long j) {
        Intrinsics3.checkNotNullParameter(list, "$this$computeScore");
        Iterator<T> it = list.iterator();
        int iPow = 0;
        while (it.hasNext()) {
            long jLongValue = j - ((Number) it.next()).longValue();
            long j2 = this.oldestAllowedDeltaMs;
            iPow += jLongValue < j2 ? 100 - ((int) Math.pow(0.1d, jLongValue / j2)) : 0;
        }
        return iPow;
    }
}
