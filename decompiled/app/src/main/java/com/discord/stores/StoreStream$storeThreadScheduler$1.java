package com.discord.stores;

import com.discord.stores.StoreStream;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "runnable", "Ljava/lang/Thread;", "newThread", "(Ljava/lang/Runnable;)Ljava/lang/Thread;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStream$storeThreadScheduler$1 implements ThreadFactory {
    public static final StoreStream$storeThreadScheduler$1 INSTANCE = new StoreStream$storeThreadScheduler$1();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Thread thread = new Thread(runnable, companion.getSTORE_THREAD_NAME());
        thread.setPriority((int) 8.0d);
        companion.setSTORE_THREAD_ID(thread.getId());
        return thread;
    }
}
