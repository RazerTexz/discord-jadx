package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/utilities/BatchManager;", "", "", "dispose", "()V", "", "incomingType", "flushBatches", "(Ljava/lang/String;)V", ExifInterface.GPS_DIRECTION_TRUE, "type", "", "debounceDelayMs", "maxDebounceDelayMs", "Lcom/discord/stores/utilities/Batched;", "createBatched", "(Ljava/lang/String;JJ)Lcom/discord/stores/utilities/Batched;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "", "batches", "Ljava/util/Map;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/discord/utilities/time/Clock;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BatchManager {
    private final Map<String, Batched<?>> batches;
    private final Clock clock;
    private final CoroutineScope scope;

    public BatchManager(CoroutineDispatcher coroutineDispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.scope = f.c(coroutineDispatcher);
        this.batches = new LinkedHashMap();
    }

    public static /* synthetic */ Batched createBatched$default(BatchManager batchManager, String str, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 100;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = 300;
        }
        return batchManager.createBatched(str, j3, j2);
    }

    public final <T> Batched<T> createBatched(String type, long debounceDelayMs, long maxDebounceDelayMs) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Batched<T> batched = new Batched<>(type, debounceDelayMs, maxDebounceDelayMs, this.scope, this.clock);
        this.batches.put(type, batched);
        return batched;
    }

    public final void dispose() {
        f.r(this.scope, null);
    }

    public final void flushBatches(String incomingType) {
        for (Map.Entry<String, Batched<?>> entry : this.batches.entrySet()) {
            String key = entry.getKey();
            Batched<?> value = entry.getValue();
            if (!Intrinsics3.areEqual(key, incomingType)) {
                value.flush();
            }
        }
    }

    public /* synthetic */ BatchManager(CoroutineDispatcher coroutineDispatcher, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineDispatcher, (i & 2) != 0 ? ClockFactory.get() : clock);
    }
}
