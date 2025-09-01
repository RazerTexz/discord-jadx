package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Scheduler;
import rx.functions.Action0;

/* compiled from: Dispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u00022\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0015j\b\u0012\u0004\u0012\u00020\n`\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/stores/Dispatcher;", "", "", "assertCleanDispatch", "()V", "Lkotlin/Function0;", "action", "schedule", "(Lkotlin/jvm/functions/Function0;)V", "", "Lcom/discord/stores/DispatchHandler;", "dispatchHandlerArgs", "registerDispatchHandlers", "([Lcom/discord/stores/DispatchHandler;)V", "unregisterDispatchHandlers", "onDispatchEnded", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "getScheduler", "()Lrx/Scheduler;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dispatchHandlers", "Ljava/util/ArrayList;", "", "assertCleanDispatches", "Z", "Ljava/lang/Thread;", "dispatcherThread", "Ljava/lang/Thread;", "<init>", "(Lrx/Scheduler;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Dispatcher {
    private final boolean assertCleanDispatches;
    private final ArrayList<Store2> dispatchHandlers;
    private Thread dispatcherThread;
    private final Scheduler scheduler;

    /* compiled from: Dispatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.Dispatcher$schedule$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action0 {
        public final /* synthetic */ Function0 $action;

        public AnonymousClass1(Function0 function0) {
            this.$action = function0;
        }

        @Override // rx.functions.Action0
        public final void call() {
            if (Dispatcher.access$getDispatcherThread$p(Dispatcher.this) == null) {
                Dispatcher.access$setDispatcherThread$p(Dispatcher.this, Thread.currentThread());
            }
            this.$action.invoke();
            Dispatcher.this.onDispatchEnded();
        }
    }

    public Dispatcher(Scheduler scheduler, boolean z2) {
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.assertCleanDispatches = z2;
        this.dispatchHandlers = new ArrayList<>();
    }

    public static final /* synthetic */ Thread access$getDispatcherThread$p(Dispatcher dispatcher) {
        return dispatcher.dispatcherThread;
    }

    public static final /* synthetic */ void access$setDispatcherThread$p(Dispatcher dispatcher, Thread thread) {
        dispatcher.dispatcherThread = thread;
    }

    private final void assertCleanDispatch() {
        if (Thread.currentThread() == this.dispatcherThread) {
            AppLog.g.w("dirty dispatch", new RuntimeException());
        }
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    @Store3
    public final void onDispatchEnded() {
        Iterator<Store2> it = this.dispatchHandlers.iterator();
        while (it.hasNext()) {
            it.next().onDispatchEnded();
        }
    }

    @Store3
    public final void registerDispatchHandlers(Store2... dispatchHandlerArgs) {
        Intrinsics3.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (Store2 store2 : dispatchHandlerArgs) {
            this.dispatchHandlers.add(store2);
        }
    }

    public final void schedule(Function0<Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
        if (this.dispatchHandlers.isEmpty()) {
            AppLog appLog = AppLog.g;
            String name = Dispatcher.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Logger.e$default(appLog, name, "scheduled an action without registering DispatchHandlers", null, null, 12, null);
        }
        if (this.assertCleanDispatches) {
            assertCleanDispatch();
        }
        this.scheduler.a().a(new AnonymousClass1(action));
    }

    @Store3
    public final void unregisterDispatchHandlers(Store2... dispatchHandlerArgs) {
        Intrinsics3.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (Store2 store2 : dispatchHandlerArgs) {
            this.dispatchHandlers.remove(store2);
        }
    }

    public /* synthetic */ Dispatcher(Scheduler scheduler, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheduler, (i & 2) != 0 ? false : z2);
    }
}
