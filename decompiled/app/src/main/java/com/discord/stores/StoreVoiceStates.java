package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeToMap;
import j0.l.e.UtilityFunctions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import rx.Observable;

/* compiled from: StoreVoiceStates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B;\u0012*\u0010>\u001a&\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\b\u0012\u00060\u0004j\u0002`\u0011\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00070=\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b@\u0010AJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r0\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r0\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0011¢\u0006\u0004\b\u000f\u0010\u0013J/\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r0\f2\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0010J5\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0011¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0017\u001a\"\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r0\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r0\rH\u0001¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b#\u0010\"J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0017¢\u0006\u0004\b*\u0010\u000bR6\u0010+\u001a\"\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\r0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00100\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0082\u0001\u00104\u001an\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012(\u0012&\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u000202j\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u0002`302j6\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012(\u0012&\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u000202j\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u0002`3`38\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R.\u00108\u001a\u001a\u0012\b\u0012\u00060\u0004j\u0002`\u000506j\f\u0012\b\u0012\u00060\u0004j\u0002`\u0005`78\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010;\u001a\n\u0018\u00010&j\u0004\u0018\u0001`:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R:\u0010>\u001a&\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\b\u0012\u00060\u0004j\u0002`\u0011\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u00070=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/discord/stores/StoreVoiceStates;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "updateVoiceState", "(Lcom/discord/api/voice/state/VoiceState;Ljava/lang/Long;)V", "clear", "()V", "Lrx/Observable;", "", "Lcom/discord/primitives/UserId;", "observe", "(J)Lrx/Observable;", "Lcom/discord/primitives/ChannelId;", "channelId", "(JJ)Lrx/Observable;", "observeForPrivateChannels", "getForChannel", "(JJ)Ljava/util/Map;", "get", "()Ljava/util/Map;", "getInternal$app_productionGoogleRelease", "getInternal", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "handleGuildRemove", "handleVoiceStateUpdate", "(Lcom/discord/api/voice/state/VoiceState;)V", "", "authToken", "handleAuthToken", "(Ljava/lang/String;)V", "snapshotData", "voiceStatesSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "myUserId", "Ljava/lang/Long;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "voiceStates", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "dirtyGuildIds", "Ljava/util/HashSet;", "Lcom/discord/primitives/SessionId;", "sessionId", "Ljava/lang/String;", "Lkotlin/Function3;", "notifyVoiceStatesUpdated", "Lkotlin/jvm/functions/Function3;", "<init>", "(Lkotlin/jvm/functions/Function3;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreVoiceStates extends StoreV2 {
    private final HashSet<Long> dirtyGuildIds;
    private Long myUserId;
    private final Function3<Long, Long, Long, Unit> notifyVoiceStatesUpdated;
    private final ObservationDeck observationDeck;
    private String sessionId;
    private final HashMap<Long, HashMap<Long, VoiceState>> voiceStates;
    private Map<Long, ? extends Map<Long, VoiceState>> voiceStatesSnapshot;

    /* compiled from: StoreVoiceStates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceStates$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends VoiceState>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends VoiceState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends VoiceState> invoke2() {
            Map<Long, ? extends VoiceState> map = (Map) StoreVoiceStates.access$getVoiceStatesSnapshot$p(StoreVoiceStates.this).get(Long.valueOf(this.$guildId));
            return map != null ? map : Maps6.emptyMap();
        }
    }

    /* compiled from: StoreVoiceStates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\u0010\n\u001a\u009a\u0001\u0012F\b\u0001\u0012B\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0007 \u0004*L\u0012F\b\u0001\u0012B\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0007\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "kotlin.jvm.PlatformType", "voiceStates", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceStates$observe$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, VoiceState>>> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreVoiceStates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/voice/state/VoiceState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/voice/state/VoiceState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreVoiceStates$observe$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<VoiceState, Boolean> {
            public AnonymousClass1() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(VoiceState voiceState) {
                return call2(voiceState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(VoiceState voiceState) {
                Long channelId = voiceState.getChannelId();
                return Boolean.valueOf(channelId != null && channelId.longValue() == AnonymousClass2.this.$channelId);
            }
        }

        /* compiled from: StoreVoiceStates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/voice/state/VoiceState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/voice/state/VoiceState;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreVoiceStates$observe$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02002<T, R> implements Func1<VoiceState, Long> {
            public static final C02002 INSTANCE = new C02002();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Long call(VoiceState voiceState) {
                return call2(voiceState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(VoiceState voiceState) {
                return Long.valueOf(voiceState.getUserId());
            }
        }

        public AnonymousClass2(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, VoiceState>> call(Map<Long, ? extends VoiceState> map) {
            return call2((Map<Long, VoiceState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, VoiceState>> call2(Map<Long, VoiceState> map) {
            return Observable.h0(new OnSubscribeToMap(Observable.B(map.values()).y(new AnonymousClass1()), C02002.INSTANCE, UtilityFunctions.a.INSTANCE));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreVoiceStates(Function3<? super Long, ? super Long, ? super Long, Unit> function3, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(function3, "notifyVoiceStatesUpdated");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.notifyVoiceStatesUpdated = function3;
        this.observationDeck = observationDeck;
        HashMap<Long, HashMap<Long, VoiceState>> map = new HashMap<>();
        this.voiceStates = map;
        this.voiceStatesSnapshot = new HashMap(map);
        this.dirtyGuildIds = new HashSet<>();
    }

    public static final /* synthetic */ Map access$getVoiceStatesSnapshot$p(StoreVoiceStates storeVoiceStates) {
        return storeVoiceStates.voiceStatesSnapshot;
    }

    public static final /* synthetic */ void access$setVoiceStatesSnapshot$p(StoreVoiceStates storeVoiceStates, Map map) {
        storeVoiceStates.voiceStatesSnapshot = map;
    }

    @Store3
    private final void clear() {
        this.dirtyGuildIds.addAll(this.voiceStates.keySet());
        this.voiceStates.clear();
        markChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateVoiceState(VoiceState voiceState, Long guildId) {
        Long channelId;
        Long l;
        long jLongValue = guildId != null ? guildId.longValue() : voiceState.getGuildId();
        long userId = voiceState.getUserId();
        if ((!Intrinsics3.areEqual(voiceState.getSessionId(), this.sessionId)) && (l = this.myUserId) != null && userId == l.longValue()) {
            HashMap<Long, VoiceState> map = this.voiceStates.get(Long.valueOf(jLongValue));
            if (map != null && map.remove(Long.valueOf(userId)) != null) {
                this.dirtyGuildIds.add(Long.valueOf(jLongValue));
            }
        } else {
            boolean z2 = false;
            HashMap<Long, HashMap<Long, VoiceState>> map2 = this.voiceStates;
            Long lValueOf = Long.valueOf(jLongValue);
            HashMap<Long, VoiceState> map3 = this.voiceStates.get(Long.valueOf(jLongValue));
            if (map3 == null) {
                map3 = new HashMap<>();
            }
            long jLongValue2 = 0;
            if (AnimatableValueParser.X0(voiceState)) {
                VoiceState voiceStateRemove = map3.remove(Long.valueOf(userId));
                if (voiceStateRemove != null) {
                    Long channelId2 = voiceStateRemove.getChannelId();
                    if (channelId2 != null) {
                        jLongValue2 = channelId2.longValue();
                    }
                    z2 = true;
                }
                map2.put(lValueOf, map3);
                if (z2) {
                    this.dirtyGuildIds.add(Long.valueOf(jLongValue));
                    this.notifyVoiceStatesUpdated.invoke(Long.valueOf(jLongValue), Long.valueOf(jLongValue2), Long.valueOf(userId));
                }
            } else {
                if (!Intrinsics3.areEqual(voiceState, map3.get(Long.valueOf(userId)))) {
                    VoiceState voiceState2 = map3.get(Long.valueOf(userId));
                    if (voiceState2 != null && (channelId = voiceState2.getChannelId()) != null) {
                        jLongValue2 = channelId.longValue();
                    }
                    map3.put(Long.valueOf(userId), voiceState);
                    z2 = true;
                }
                map2.put(lValueOf, map3);
                if (z2) {
                }
            }
        }
        if (!this.dirtyGuildIds.isEmpty()) {
            markChanged();
        }
    }

    public static /* synthetic */ void updateVoiceState$default(StoreVoiceStates storeVoiceStates, VoiceState voiceState, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeVoiceStates.updateVoiceState(voiceState, l);
    }

    public final Map<Long, Map<Long, VoiceState>> get() {
        return this.voiceStatesSnapshot;
    }

    public final Map<Long, VoiceState> getForChannel(long guildId, long channelId) {
        Map<Long, VoiceState> mapEmptyMap = this.voiceStatesSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, VoiceState> entry : mapEmptyMap.entrySet()) {
            Long channelId2 = entry.getValue().getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @Store3
    public final Map<Long, Map<Long, VoiceState>> getInternal$app_productionGoogleRelease() {
        return this.voiceStates;
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            clear();
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        this.myUserId = Long.valueOf(payload.getMe().getId());
        clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listR = guild.R();
            if (listR != null) {
                Iterator<T> it = listR.iterator();
                while (it.hasNext()) {
                    updateVoiceState((VoiceState) it.next(), Long.valueOf(guild.getId()));
                }
            }
        }
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<VoiceState> listR = guild.R();
        if (listR != null) {
            Iterator<T> it = listR.iterator();
            while (it.hasNext()) {
                updateVoiceState((VoiceState) it.next(), Long.valueOf(guild.getId()));
            }
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.voiceStates.remove(Long.valueOf(guild.getId()));
        this.dirtyGuildIds.add(Long.valueOf(guild.getId()));
        markChanged();
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        updateVoiceState$default(this, voiceState, null, 2, null);
    }

    public final Observable<Map<Long, VoiceState>> observe(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    public final Observable<Map<Long, VoiceState>> observeForPrivateChannels(long channelId) {
        return observe(0L, channelId);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        HashMap map = new HashMap(this.voiceStates.size());
        for (Map.Entry<Long, HashMap<Long, VoiceState>> entry : this.voiceStates.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            HashMap<Long, VoiceState> value = entry.getValue();
            if (this.dirtyGuildIds.contains(Long.valueOf(jLongValue))) {
                map.put(Long.valueOf(jLongValue), new HashMap(value));
            } else {
                Map<Long, VoiceState> map2 = this.voiceStatesSnapshot.get(Long.valueOf(jLongValue));
                if (map2 != null) {
                    map.put(Long.valueOf(jLongValue), map2);
                }
            }
        }
        this.voiceStatesSnapshot = map;
        this.dirtyGuildIds.clear();
    }

    public final Observable<Map<Long, VoiceState>> observe(long guildId, long channelId) {
        Observable<Map<Long, VoiceState>> observableR = observe(guildId).Y(new AnonymousClass2(channelId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observe(guildId)\n       …  .distinctUntilChanged()");
        return observableR;
    }
}
