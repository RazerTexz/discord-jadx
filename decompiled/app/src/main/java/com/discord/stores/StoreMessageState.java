package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.message.Message;
import com.discord.models.domain.ModelMessageDelete;
import d0.Tuples;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreMessageState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b.\u0010/J/\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0018\u001a\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b\u0019\u0010\u0017J-\u0010\u001c\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0018\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'R,\u0010)\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u00100(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/discord/stores/StoreMessageState;", "", "", "Lcom/discord/primitives/MessageId;", "messageId", "Lkotlin/Function1;", "Lcom/discord/stores/StoreMessageState$State;", "updateFunction", "", "updateState", "(JLkotlin/jvm/functions/Function1;)V", "", "messagesList", "resetState", "(Ljava/util/List;)V", "Lrx/Observable;", "", "getMessageState", "()Lrx/Observable;", "", "Lcom/discord/primitives/Index;", "spoilerIndex", "revealSpoiler", "(JI)V", "spoilerEmbedIndex", "revealSpoilerEmbed", "", "key", "revealSpoilerEmbedData", "(JILjava/lang/String;)V", "handleChannelSelected", "()V", "Lcom/discord/api/message/Message;", "message", "handleMessageUpdate", "(Lcom/discord/api/message/Message;)V", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDelete", "handleMessageDelete", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "Lrx/subjects/BehaviorSubject;", "messageStateSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessageState {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, State>> messageStateSubject;

    /* compiled from: StoreMessageState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\"\b\u0002\u0010\r\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0002j\u0002`\t0\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\n\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0002j\u0002`\t0\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJH\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\"\b\u0002\u0010\r\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0002j\u0002`\t0\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R#\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006R3\u0010\r\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0002j\u0002`\t0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreMessageState$State;", "", "", "", "Lcom/discord/primitives/Index;", "component1", "()Ljava/util/Set;", "", "", "Lcom/discord/stores/VisibleKeys;", "component2", "()Ljava/util/Map;", "visibleSpoilerNodeIndices", "visibleSpoilerEmbedMap", "copy", "(Ljava/util/Set;Ljava/util/Map;)Lcom/discord/stores/StoreMessageState$State;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getVisibleSpoilerNodeIndices", "Ljava/util/Map;", "getVisibleSpoilerEmbedMap", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        private final Set<Integer> visibleSpoilerNodeIndices;

        public State() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(Set<Integer> set, Map<Integer, ? extends Set<String>> map) {
            Intrinsics3.checkNotNullParameter(set, "visibleSpoilerNodeIndices");
            Intrinsics3.checkNotNullParameter(map, "visibleSpoilerEmbedMap");
            this.visibleSpoilerNodeIndices = set;
            this.visibleSpoilerEmbedMap = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.visibleSpoilerNodeIndices;
            }
            if ((i & 2) != 0) {
                map = state.visibleSpoilerEmbedMap;
            }
            return state.copy(set, map);
        }

        public final Set<Integer> component1() {
            return this.visibleSpoilerNodeIndices;
        }

        public final Map<Integer, Set<String>> component2() {
            return this.visibleSpoilerEmbedMap;
        }

        public final State copy(Set<Integer> visibleSpoilerNodeIndices, Map<Integer, ? extends Set<String>> visibleSpoilerEmbedMap) {
            Intrinsics3.checkNotNullParameter(visibleSpoilerNodeIndices, "visibleSpoilerNodeIndices");
            Intrinsics3.checkNotNullParameter(visibleSpoilerEmbedMap, "visibleSpoilerEmbedMap");
            return new State(visibleSpoilerNodeIndices, visibleSpoilerEmbedMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.visibleSpoilerNodeIndices, state.visibleSpoilerNodeIndices) && Intrinsics3.areEqual(this.visibleSpoilerEmbedMap, state.visibleSpoilerEmbedMap);
        }

        public final Map<Integer, Set<String>> getVisibleSpoilerEmbedMap() {
            return this.visibleSpoilerEmbedMap;
        }

        public final Set<Integer> getVisibleSpoilerNodeIndices() {
            return this.visibleSpoilerNodeIndices;
        }

        public int hashCode() {
            Set<Integer> set = this.visibleSpoilerNodeIndices;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Integer, Set<String>> map = this.visibleSpoilerEmbedMap;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(visibleSpoilerNodeIndices=");
            sbU.append(this.visibleSpoilerNodeIndices);
            sbU.append(", visibleSpoilerEmbedMap=");
            return outline.M(sbU, this.visibleSpoilerEmbedMap, ")");
        }

        public /* synthetic */ State(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sets5.emptySet() : set, (i & 2) != 0 ? Maps6.emptyMap() : map);
        }
    }

    /* compiled from: StoreMessageState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerIndex;

        /* compiled from: StoreMessageState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessageState$State;", "currentState", "invoke", "(Lcom/discord/stores/StoreMessageState$State;)Lcom/discord/stores/StoreMessageState$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01541 extends Lambda implements Function1<State, State> {
            public C01541() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, _Sets.plus(state.getVisibleSpoilerNodeIndices(), Integer.valueOf(AnonymousClass1.this.$spoilerIndex)), null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new C01541());
        }
    }

    /* compiled from: StoreMessageState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* compiled from: StoreMessageState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessageState$State;", "currentState", "invoke", "(Lcom/discord/stores/StoreMessageState$State;)Lcom/discord/stores/StoreMessageState$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01551 extends Lambda implements Function1<State, State> {
            public C01551() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, null, Maps6.plus(state.getVisibleSpoilerEmbedMap(), Tuples.to(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex), Sets5.emptySet())), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new C01551());
        }
    }

    /* compiled from: StoreMessageState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* compiled from: StoreMessageState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessageState$State;", "currentState", "invoke", "(Lcom/discord/stores/StoreMessageState$State;)Lcom/discord/stores/StoreMessageState$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01561 extends Lambda implements Function1<State, State> {
            public C01561() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                Set<String> setEmptySet = state.getVisibleSpoilerEmbedMap().get(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex));
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                return State.copy$default(state, null, Maps6.plus(state.getVisibleSpoilerEmbedMap(), Tuples.to(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex), _Sets.plus(setEmptySet, AnonymousClass1.this.$key))), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i, String str) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
            this.$key = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new C01561());
        }
    }

    public StoreMessageState(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        BehaviorSubject<Map<Long, State>> behaviorSubjectL0 = BehaviorSubject.l0(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.messageStateSubject = behaviorSubjectL0;
    }

    public static final /* synthetic */ void access$updateState(StoreMessageState storeMessageState, long j, Function1 function1) {
        storeMessageState.updateState(j, function1);
    }

    @Store3
    private final void resetState(List<Long> messagesList) {
        Map<Long, State> mapN0 = this.messageStateSubject.n0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : messagesList) {
            long jLongValue = ((Number) obj).longValue();
            Intrinsics3.checkNotNullExpressionValue(mapN0, "messageStateMap");
            if (mapN0.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        Intrinsics3.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(Maps6.minus((Map) mapN0, (Iterable) arrayList));
    }

    @Store3
    private final void updateState(long messageId, Function1<? super State, State> updateFunction) {
        Map<Long, State> mapN0 = this.messageStateSubject.n0();
        State state = mapN0.get(Long.valueOf(messageId));
        if (state == null) {
            state = new State(null, null, 3, null);
        }
        State stateInvoke = updateFunction.invoke(state);
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        Intrinsics3.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(Maps6.plus(mapN0, Tuples.to(Long.valueOf(messageId), stateInvoke)));
    }

    public final Observable<Map<Long, State>> getMessageState() {
        Observable<Map<Long, State>> observableR = this.messageStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "messageStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleChannelSelected() {
        this.messageStateSubject.onNext(Maps6.emptyMap());
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        List<Long> messageIds = messageDelete.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        resetState(messageIds);
    }

    @Store3
    public final void handleMessageUpdate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        resetState(CollectionsJVM.listOf(Long.valueOf(message.getId())));
    }

    public final void revealSpoiler(long messageId, int spoilerIndex) {
        if (spoilerIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerIndex));
    }

    public final void revealSpoilerEmbed(long messageId, int spoilerEmbedIndex) {
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerEmbedIndex));
    }

    public final void revealSpoilerEmbedData(long messageId, int spoilerEmbedIndex, String key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerEmbedIndex, key));
    }
}
