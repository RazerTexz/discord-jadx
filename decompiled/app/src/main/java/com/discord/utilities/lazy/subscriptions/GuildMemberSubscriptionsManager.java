package com.discord.utilities.lazy.subscriptions;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* compiled from: GuildMemberSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BY\u0012,\u0010(\u001a(\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002`\n0\t\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00020&\u0012\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 \u0012\u0004\u0012\u00020\u00020\u001f\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J#\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\n0\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\r\u001a\u00060\u0006j\u0002`\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\r\u001a\u00060\u0006j\u0002`\n¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u001f\u0010\u0016\u001a\u00020\u00022\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0014¢\u0006\u0004\b\u0016\u0010\u0017RZ\u0010\u001c\u001aF\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u001a0\u00190\u0018j\"\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u001a0\u0019`\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dRZ\u0010\u001e\u001aF\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u001a0\u00190\u0018j\"\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u001a0\u0019`\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR(\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 \u0012\u0004\u0012\u00020\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R<\u0010(\u001a(\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002`\n0\t\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/discord/utilities/lazy/subscriptions/GuildMemberSubscriptionsManager;", "", "", "triggerUnsubscribe", "()V", "flushUnsubscriptions", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/primitives/UserId;", "get", "(J)Ljava/util/Set;", "userId", "subscribe", "(JJ)V", "unsubscribe", "remove", "(J)V", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "", "guildIds", "retainAll", "(Ljava/util/List;)V", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "pendingUnsubscriptions", "Ljava/util/HashMap;", "subscriptions", "Lkotlin/Function1;", "Lkotlin/Function0;", "requestFlushUnsubscriptions", "Lkotlin/jvm/functions/Function1;", "Lrx/Subscription;", "delayedFlushSubscription", "Lrx/Subscription;", "Lkotlin/Function3;", "", "onChange", "Lkotlin/jvm/functions/Function3;", "Lrx/Scheduler;", "delayScheduler", "Lrx/Scheduler;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lrx/Scheduler;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildMemberSubscriptionsManager {
    private final Scheduler delayScheduler;
    private Subscription delayedFlushSubscription;
    private final Function3<Long, Set<Long>, Boolean, Unit> onChange;
    private final HashMap<Long, Map<Long, Integer>> pendingUnsubscriptions;
    private final Function1<Function0<Unit>, Unit> requestFlushUnsubscriptions;
    private final HashMap<Long, Map<Long, Integer>> subscriptions;

    /* compiled from: GuildMemberSubscriptionsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.lazy.subscriptions.GuildMemberSubscriptionsManager$triggerUnsubscribe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            GuildMemberSubscriptionsManager.access$setDelayedFlushSubscription$p(GuildMemberSubscriptionsManager.this, subscription);
        }
    }

    /* compiled from: GuildMemberSubscriptionsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.lazy.subscriptions.GuildMemberSubscriptionsManager$triggerUnsubscribe$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: GuildMemberSubscriptionsManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.lazy.subscriptions.GuildMemberSubscriptionsManager$triggerUnsubscribe$2$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
            public AnonymousClass1(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
                super(0, guildMemberSubscriptionsManager, GuildMemberSubscriptionsManager.class, "flushUnsubscriptions", "flushUnsubscriptions()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildMemberSubscriptionsManager.access$flushUnsubscriptions((GuildMemberSubscriptionsManager) this.receiver);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            GuildMemberSubscriptionsManager.access$getRequestFlushUnsubscriptions$p(GuildMemberSubscriptionsManager.this).invoke(new AnonymousClass1(GuildMemberSubscriptionsManager.this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberSubscriptionsManager(Function3<? super Long, ? super Set<Long>, ? super Boolean, Unit> function3, Function1<? super Function0<Unit>, Unit> function1, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(function3, "onChange");
        Intrinsics3.checkNotNullParameter(function1, "requestFlushUnsubscriptions");
        Intrinsics3.checkNotNullParameter(scheduler, "delayScheduler");
        this.onChange = function3;
        this.requestFlushUnsubscriptions = function1;
        this.delayScheduler = scheduler;
        this.subscriptions = new HashMap<>();
        this.pendingUnsubscriptions = new HashMap<>();
    }

    public static final /* synthetic */ void access$flushUnsubscriptions(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        guildMemberSubscriptionsManager.flushUnsubscriptions();
    }

    public static final /* synthetic */ Subscription access$getDelayedFlushSubscription$p(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        return guildMemberSubscriptionsManager.delayedFlushSubscription;
    }

    public static final /* synthetic */ Function1 access$getRequestFlushUnsubscriptions$p(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        return guildMemberSubscriptionsManager.requestFlushUnsubscriptions;
    }

    public static final /* synthetic */ void access$setDelayedFlushSubscription$p(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager, Subscription subscription) {
        guildMemberSubscriptionsManager.delayedFlushSubscription = subscription;
    }

    private final void flushUnsubscriptions() {
        if (this.pendingUnsubscriptions.isEmpty()) {
            return;
        }
        for (Map.Entry<Long, Map<Long, Integer>> entry : this.pendingUnsubscriptions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Map<Long, Integer> value = entry.getValue();
            Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(jLongValue));
            if (map != null) {
                Intrinsics3.checkNotNullExpressionValue(map, "subscriptions[guildId] ?: continue");
                boolean z2 = false;
                for (Map.Entry<Long, Integer> entry2 : value.entrySet()) {
                    long jLongValue2 = entry2.getKey().longValue();
                    int iIntValue = entry2.getValue().intValue();
                    Integer num = map.get(Long.valueOf(jLongValue2));
                    if (num != null) {
                        int iIntValue2 = num.intValue() - iIntValue;
                        if (iIntValue2 > 0) {
                            map.put(Long.valueOf(jLongValue2), Integer.valueOf(iIntValue2));
                        } else {
                            map.remove(Long.valueOf(jLongValue2));
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    if (map.isEmpty()) {
                        this.subscriptions.remove(Long.valueOf(jLongValue));
                    }
                    this.onChange.invoke(Long.valueOf(jLongValue), get(jLongValue), Boolean.TRUE);
                }
            }
        }
        this.delayedFlushSubscription = null;
        this.pendingUnsubscriptions.clear();
    }

    private final void triggerUnsubscribe() {
        if (this.delayedFlushSubscription == null) {
            Observable<Long> observableE0 = Observable.e0(20L, TimeUnit.SECONDS, this.delayScheduler);
            Intrinsics3.checkNotNullExpressionValue(observableE0, "Observable\n          .ti….SECONDS, delayScheduler)");
            ObservableExtensionsKt.appSubscribe$default(observableE0, GuildMemberSubscriptionsManager.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
        }
    }

    public final Set<Long> get(long guildId) {
        Set<Long> setKeySet;
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        return (map == null || (setKeySet = map.keySet()) == null) ? Sets5.emptySet() : setKeySet;
    }

    public final void remove(long guildId) {
        this.subscriptions.remove(Long.valueOf(guildId));
        this.pendingUnsubscriptions.remove(Long.valueOf(guildId));
    }

    public final void reset() {
        this.subscriptions.clear();
        this.pendingUnsubscriptions.clear();
        Subscription subscription = this.delayedFlushSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.delayedFlushSubscription = null;
    }

    public final void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        Iterator<Map.Entry<Long, Map<Long, Integer>>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
    }

    public final void subscribe(long guildId, long userId) {
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        if (map == null) {
            map = new HashMap<>();
        }
        Long lValueOf = Long.valueOf(userId);
        Integer num = map.get(Long.valueOf(userId));
        map.put(lValueOf, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.subscriptions.put(Long.valueOf(guildId), map);
        Integer num2 = map.get(Long.valueOf(userId));
        if (num2 != null && num2.intValue() == 1) {
            this.onChange.invoke(Long.valueOf(guildId), map.keySet(), Boolean.FALSE);
        }
    }

    public final void unsubscribe(long guildId, long userId) {
        Map<Long, Integer> map = this.subscriptions.get(Long.valueOf(guildId));
        if ((map != null ? map.get(Long.valueOf(userId)) : null) == null) {
            return;
        }
        Map<Long, Integer> map2 = this.pendingUnsubscriptions.get(Long.valueOf(guildId));
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Long lValueOf = Long.valueOf(userId);
        Integer num = map2.get(Long.valueOf(userId));
        map2.put(lValueOf, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.pendingUnsubscriptions.put(Long.valueOf(guildId), map2);
        Integer num2 = map2.get(Long.valueOf(userId));
        if (num2 != null && num2.intValue() == 1) {
            triggerUnsubscribe();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildMemberSubscriptionsManager(Function3 function3, Function1 function1, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            scheduler = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        this(function3, function1, scheduler);
    }
}
