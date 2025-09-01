package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.message.Message;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: StoreUserTyping.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b4\u00105J)\u0010\u0007\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0010\u001a\"\u0012\u001e\u0012\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u00020\u000f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0005¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u000f2\n\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010$\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00050\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%RZ\u0010*\u001aF\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u0004\u0012\u00020(0'0&j\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u0004\u0012\u00020(0'`)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+RN\u0010-\u001a:\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060,0&j\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060,`)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/discord/stores/StoreUserTyping;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/ChannelId;", "", "Lcom/discord/primitives/UserId;", "getTypingUsers", "()Ljava/util/Map;", "Lcom/discord/api/user/TypingUser;", "typing", "", "handleTypingStop", "(Lcom/discord/api/user/TypingUser;)V", "channelIds", "Lrx/Observable;", "observeTypingUsersForChannels", "(Ljava/util/Set;)Lrx/Observable;", "channelId", "observeTypingUsers", "(J)Lrx/Observable;", "setUserTyping", "(J)V", "handleTypingStart", "Lcom/discord/api/message/Message;", "message", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "typingUsersSnapshot", "Ljava/util/Map;", "Ljava/util/HashMap;", "", "Lrx/Subscription;", "Lkotlin/collections/HashMap;", "typingUsersRemoveCallbacks", "Ljava/util/HashMap;", "", "typingUsers", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserTyping extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private final HashMap<Long, Set<Long>> typingUsers;
    private final HashMap<Long, Map<Long, Subscription>> typingUsersRemoveCallbacks;
    private Map<Long, ? extends Set<Long>> typingUsersSnapshot;

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/user/TypingUser;", "kotlin.jvm.PlatformType", "prevTyping", "", "invoke", "(Lcom/discord/api/user/TypingUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<TypingUser, Unit> {

        /* compiled from: StoreUserTyping.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01921 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ TypingUser $prevTyping;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01921(TypingUser typingUser) {
                super(0);
                this.$prevTyping = typingUser;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserTyping storeUserTyping = StoreUserTyping.this;
                TypingUser typingUser = this.$prevTyping;
                Intrinsics3.checkNotNullExpressionValue(typingUser, "prevTyping");
                StoreUserTyping.access$handleTypingStop(storeUserTyping, typingUser);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
            invoke2(typingUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TypingUser typingUser) {
            StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new C01921(typingUser));
        }
    }

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* compiled from: StoreUserTyping.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = (Map) StoreUserTyping.access$getTypingUsersRemoveCallbacks$p(StoreUserTyping.this).get(Long.valueOf(AnonymousClass2.this.$channelId));
                if (map != null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new AnonymousClass1(subscription));
        }
    }

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001c\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "Lcom/discord/primitives/UserId;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Set<? extends Long>> invoke2() {
            return StoreUserTyping.access$getTypingUsers(StoreUserTyping.this);
        }
    }

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0004 \u0005*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0004\u0018\u00010\u00030\u00032B\u0010\u0006\u001a>\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0003 \u0005*\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "typingUsersByChannel", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsers$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Set<? extends Long>>, Set<? extends Long>> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass2(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Set<? extends Long>> map) {
            return call2((Map<Long, ? extends Set<Long>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, ? extends Set<Long>> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "typingUsersByChannel");
            Set<Long> setEmptySet = map.get(Long.valueOf(this.$channelId));
            if (setEmptySet == null) {
                setEmptySet = Sets5.emptySet();
            }
            return setEmptySet;
        }
    }

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001c\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "Lcom/discord/primitives/UserId;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsersForChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Set<? extends Long>> invoke2() {
            return StoreUserTyping.access$getTypingUsers(StoreUserTyping.this);
        }
    }

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a>\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0003 \u0005*\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0003\u0018\u00010\u00000\u00002B\u0010\u0006\u001a>\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0003 \u0005*\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "typingUsersByChannel", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsersForChannels$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Set<? extends Long>>, Map<Long, ? extends Set<? extends Long>>> {
        public final /* synthetic */ Set $channelIds;

        public AnonymousClass2(Set set) {
            this.$channelIds = set;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> call(Map<Long, ? extends Set<? extends Long>> map) {
            return call2((Map<Long, ? extends Set<Long>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Set<Long>> call2(Map<Long, ? extends Set<Long>> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "typingUsersByChannel");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, ? extends Set<Long>> entry : map.entrySet()) {
                if (this.$channelIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreUserTyping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelTypingResponse;", "response", "", "invoke", "(Lcom/discord/models/domain/ModelTypingResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelTypingResponse, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreUserTyping.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01931 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ long $messageSendCooldownSecs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01931(long j) {
                super(0);
                this.$messageSendCooldownSecs = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(AnonymousClass1.this.$channelId, this.$messageSendCooldownSecs, StoreSlowMode.Type.MessageSend.INSTANCE);
            }
        }

        /* compiled from: StoreUserTyping.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ long $threadCreateCooldown;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(long j) {
                super(0);
                this.$threadCreateCooldown = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(AnonymousClass1.this.$channelId, this.$threadCreateCooldown, StoreSlowMode.Type.ThreadCreate.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelTypingResponse modelTypingResponse) {
            invoke2(modelTypingResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelTypingResponse modelTypingResponse) {
            Long threadCreateCooldownMs;
            Long messageSendCooldownMs;
            long jLongValue = (modelTypingResponse == null || (messageSendCooldownMs = modelTypingResponse.getMessageSendCooldownMs()) == null) ? 0L : messageSendCooldownMs.longValue();
            if (jLongValue > 0) {
                StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new C01931(jLongValue));
            }
            long jLongValue2 = (modelTypingResponse == null || (threadCreateCooldownMs = modelTypingResponse.getThreadCreateCooldownMs()) == null) ? 0L : threadCreateCooldownMs.longValue();
            if (jLongValue2 > 0) {
                StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new AnonymousClass2(jLongValue2));
            }
        }
    }

    public /* synthetic */ StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserTyping storeUserTyping) {
        return storeUserTyping.dispatcher;
    }

    public static final /* synthetic */ Map access$getTypingUsers(StoreUserTyping storeUserTyping) {
        return storeUserTyping.getTypingUsers();
    }

    public static final /* synthetic */ HashMap access$getTypingUsersRemoveCallbacks$p(StoreUserTyping storeUserTyping) {
        return storeUserTyping.typingUsersRemoveCallbacks;
    }

    public static final /* synthetic */ void access$handleTypingStop(StoreUserTyping storeUserTyping, TypingUser typingUser) {
        storeUserTyping.handleTypingStop(typingUser);
    }

    private final Map<Long, Set<Long>> getTypingUsers() {
        return this.typingUsersSnapshot;
    }

    @Store3
    private final void handleTypingStop(TypingUser typing) {
        Set<Long> set = this.typingUsers.get(Long.valueOf(typing.getChannelId()));
        if (set != null) {
            Intrinsics3.checkNotNullExpressionValue(set, "typingUsers[typing.channelId] ?: return");
            if (set.remove(Long.valueOf(typing.getUserId()))) {
                markChanged();
            }
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author != null) {
            long id2 = author.getId();
            Set<Long> set = this.typingUsers.get(Long.valueOf(message.getChannelId()));
            if (set != null) {
                Intrinsics3.checkNotNullExpressionValue(set, "typingUsers[message.channelId] ?: return");
                if (set.remove(Long.valueOf(id2))) {
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final void handleTypingStart(TypingUser typing) {
        Intrinsics3.checkNotNullParameter(typing, "typing");
        long id2 = this.stream.getUsers().getMe().getId();
        long userId = typing.getUserId();
        if (id2 == userId) {
            return;
        }
        long channelId = typing.getChannelId();
        HashMap<Long, Map<Long, Subscription>> map = this.typingUsersRemoveCallbacks;
        Long lValueOf = Long.valueOf(channelId);
        Map<Long, Subscription> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Subscription subscription = map2.get(Long.valueOf(userId));
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<T> observableQ = new ScalarSynchronousObservable(typing).q(10L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable\n        .just…lay(10, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableQ, (Context) null, "typingRemove", new AnonymousClass2(channelId, userId), new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
        HashMap<Long, Set<Long>> map3 = this.typingUsers;
        Long lValueOf2 = Long.valueOf(channelId);
        Set<Long> hashSet = map3.get(lValueOf2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map3.put(lValueOf2, hashSet);
        }
        if (hashSet.add(Long.valueOf(userId))) {
            markChanged();
        }
    }

    public final Observable<Set<Long>> observeTypingUsers(long channelId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new AnonymousClass2(channelId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Set<Long>>> observeTypingUsersForChannels(Set<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        Observable<Map<Long, Set<Long>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new AnonymousClass2(channelIds)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setUserTyping(long channelId) {
        if (channelId == 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.setUserTyping(channelId, new RestAPIParams.EmptyBody()), false, 1, null), (Context) null, "typingEvent", (Function1) null, new AnonymousClass1(channelId), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Set<Long>> entry : this.typingUsers.entrySet()) {
            map.put(Long.valueOf(entry.getKey().longValue()), new HashSet(entry.getValue()));
        }
        this.typingUsersSnapshot = map;
    }

    public StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.typingUsersRemoveCallbacks = new HashMap<>();
        this.typingUsers = new HashMap<>();
        this.typingUsersSnapshot = Maps6.emptyMap();
    }
}
