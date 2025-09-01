package com.discord.utilities.frecency;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.time.ClockFactory;
import d0.t.Collections2;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: FrecencyTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0004\u001a\u00020\u0003H$¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR>\u0010\u001e\u001a*\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u001cj\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b`\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/discord/utilities/frecency/FrecencyTracker;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "currentTime", "", "computeScores", "(J)V", "", "", "computeScore", "(Ljava/util/List;J)I", "key", "now", "track", "(Ljava/lang/Object;J)V", "", "getSortedKeys", "(J)Ljava/util/Collection;", "removeEntry", "(Ljava/lang/Object;)V", "maxSamples", "I", "getMaxSamples", "()I", "", "dirty", "Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "history", "Ljava/util/HashMap;", "minScoreThreshold", "getMinScoreThreshold", "sortedKeys", "Ljava/util/List;", "<init>", "(II)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class FrecencyTracker<T> {
    private final int maxSamples;
    private final int minScoreThreshold;
    private final HashMap<T, List<Long>> history = new HashMap<>();
    private transient boolean dirty = true;
    private transient List<? extends T> sortedKeys = Collections2.emptyList();

    /* compiled from: FrecencyTracker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "first", "second", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.frecency.FrecencyTracker$computeScores$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Comparator<T> {
        public final /* synthetic */ HashMap $scores;

        public AnonymousClass1(HashMap map) {
            this.$scores = map;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompareValues;
            Integer num = (Integer) this.$scores.get(t);
            Integer num2 = (Integer) this.$scores.get(t2);
            if (!Intrinsics3.areEqual(num, num2)) {
                iCompareValues = a.compareValues(num, num2);
            } else {
                List list = (List) FrecencyTracker.access$getHistory$p(FrecencyTracker.this).get(t);
                Long l = list != null ? (Long) _Collections.last(list) : null;
                List list2 = (List) FrecencyTracker.access$getHistory$p(FrecencyTracker.this).get(t2);
                iCompareValues = a.compareValues(l, list2 != null ? (Long) _Collections.last(list2) : null);
            }
            return iCompareValues * (-1);
        }
    }

    public FrecencyTracker(int i, int i2) {
        this.minScoreThreshold = i;
        this.maxSamples = i2;
    }

    public static final /* synthetic */ HashMap access$getHistory$p(FrecencyTracker frecencyTracker) {
        return frecencyTracker.history;
    }

    private final void computeScores(long currentTime) {
        HashMap map = new HashMap(this.history.size());
        Iterator<Map.Entry<T, List<Long>>> it = this.history.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<T, List<Long>> next = it.next();
            T key = next.getKey();
            int iComputeScore = computeScore(next.getValue(), currentTime);
            if (iComputeScore > this.minScoreThreshold) {
                map.put(key, Integer.valueOf(iComputeScore));
            } else {
                it.remove();
            }
        }
        Set setKeySet = map.keySet();
        Intrinsics3.checkNotNullExpressionValue(setKeySet, "scores.keys");
        this.sortedKeys = _Collections.sortedWith(setKeySet, new AnonymousClass1(map));
        this.dirty = false;
    }

    public static /* synthetic */ Collection getSortedKeys$default(FrecencyTracker frecencyTracker, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSortedKeys");
        }
        if ((i & 1) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        return frecencyTracker.getSortedKeys(j);
    }

    public static /* synthetic */ void track$default(FrecencyTracker frecencyTracker, Object obj, long j, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
        if ((i & 2) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        frecencyTracker.track(obj, j);
    }

    public abstract int computeScore(List<Long> list, long j);

    public final int getMaxSamples() {
        return this.maxSamples;
    }

    public final int getMinScoreThreshold() {
        return this.minScoreThreshold;
    }

    public final synchronized Collection<T> getSortedKeys(long now) {
        if (this.dirty) {
            computeScores(now);
        }
        return this.sortedKeys;
    }

    public final synchronized void removeEntry(T key) {
        this.history.remove(key);
        this.dirty = true;
    }

    public final synchronized void track(T key, long now) {
        List<Long> listEmptyList = this.history.get(key);
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        this.history.put(key, _Collections.takeLast(_Collections.plus((Collection<? extends Long>) listEmptyList, Long.valueOf(now)), this.maxSamples));
        this.dirty = true;
    }
}
