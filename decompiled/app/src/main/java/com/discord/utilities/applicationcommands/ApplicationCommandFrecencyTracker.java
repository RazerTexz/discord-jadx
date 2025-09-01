package com.discord.utilities.applicationcommands;

import com.discord.utilities.frecency.FrecencyTracker;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommandFrecencyTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/applicationcommands/ApplicationCommandFrecencyTracker;", "Lcom/discord/utilities/frecency/FrecencyTracker;", "", "", "earlierTime", "laterTime", "", "getDaysDiff", "(JJ)I", "daysDiff", "getDaysWeight", "(I)I", "", "currentTime", "computeScore", "(Ljava/util/List;J)I", "maxSamples", "minScoreThreshold", "<init>", "(II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApplicationCommandFrecencyTracker extends FrecencyTracker<String> {
    public ApplicationCommandFrecencyTracker() {
        this(0, 0, 3, null);
    }

    public ApplicationCommandFrecencyTracker(int i, int i2) {
        super(i2, i);
    }

    private final int getDaysDiff(long earlierTime, long laterTime) {
        return (int) ((laterTime - earlierTime) / 86400000);
    }

    private final int getDaysWeight(int daysDiff) {
        if (daysDiff <= 3) {
            return 100;
        }
        if (daysDiff <= 15) {
            return 70;
        }
        if (daysDiff <= 30) {
            return 50;
        }
        if (daysDiff <= 45) {
            return 30;
        }
        return daysDiff <= 80 ? 10 : 0;
    }

    @Override // com.discord.utilities.frecency.FrecencyTracker
    public int computeScore(List<Long> list, long j) {
        Intrinsics3.checkNotNullParameter(list, "$this$computeScore");
        Iterator<T> it = list.iterator();
        int daysWeight = 0;
        while (it.hasNext()) {
            daysWeight += getDaysWeight(getDaysDiff(((Number) it.next()).longValue(), j));
        }
        return daysWeight;
    }

    public /* synthetic */ ApplicationCommandFrecencyTracker(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : i, (i3 & 2) != 0 ? 70 : i2);
    }
}
