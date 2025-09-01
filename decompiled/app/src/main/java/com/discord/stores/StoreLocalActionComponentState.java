package com.discord.stores;

import com.discord.api.botuikit.SelectComponent2;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreLocalActionComponentState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b,\u0010-J3\u0010\t\u001a(\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ9\u0010\f\u001a.\u0012*\u0012(\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00020\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0014\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u00042\u000e\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0016\u0010\u0017R?\u0010\u0019\u001a(\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nRH\u0010\u001c\u001a(\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\u001fR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R%\u0010*\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0\u00188\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\n¨\u0006."}, d2 = {"Lcom/discord/stores/StoreLocalActionComponentState;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/MessageId;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "", "Lcom/discord/api/botuikit/SelectItem;", "getSelectComponentSelectionsData", "()Ljava/util/Map;", "Lrx/Observable;", "observeSelectComponentSelections", "()Lrx/Observable;", "messageId", "componentIndex", "selectedItems", "", "setSelectComponentSelection", "(JILjava/util/List;)V", "clearState", "(JLjava/lang/Integer;)V", "snapshotData", "()V", "", "selectComponentSelections", "Ljava/util/Map;", "getSelectComponentSelections", "selectComponentSelectionsSnapshot", "getSelectComponentSelectionsSnapshot", "setSelectComponentSelectionsSnapshot", "(Ljava/util/Map;)V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "Lcom/discord/stores/StoreApplicationInteractions$ComponentLocation;", "componentInteractions", "getComponentInteractions", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreLocalActionComponentState extends StoreV2 {
    private final Map<String, StoreApplicationInteractions.ComponentLocation> componentInteractions;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<Integer, List<SelectComponent2>>> selectComponentSelections;
    private Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>> selectComponentSelectionsSnapshot;

    /* compiled from: StoreLocalActionComponentState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/MessageId;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "", "Lcom/discord/api/botuikit/SelectItem;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLocalActionComponentState$observeSelectComponentSelections$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>> invoke2() {
            return StoreLocalActionComponentState.this.getSelectComponentSelectionsData();
        }
    }

    /* compiled from: StoreLocalActionComponentState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreLocalActionComponentState$setSelectComponentSelection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $componentIndex;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ List $selectedItems;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, List list, int i) {
            super(0);
            this.$messageId = j;
            this.$selectedItems = list;
            this.$componentIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<Integer, List<SelectComponent2>> linkedHashMap;
            Map<Integer, List<SelectComponent2>> map = StoreLocalActionComponentState.this.getSelectComponentSelections().get(Long.valueOf(this.$messageId));
            if (map == null || (linkedHashMap = Maps6.toMutableMap(map)) == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            linkedHashMap.put(Integer.valueOf(this.$componentIndex), this.$selectedItems);
            StoreLocalActionComponentState.this.getSelectComponentSelections().put(Long.valueOf(this.$messageId), linkedHashMap);
            StoreLocalActionComponentState.this.markChanged();
        }
    }

    public /* synthetic */ StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    public final void clearState(long messageId, Integer componentIndex) {
        Map<Integer, List<SelectComponent2>> map;
        Map<Integer, List<SelectComponent2>> mutableMap;
        if (!this.selectComponentSelections.containsKey(Long.valueOf(messageId)) || (map = this.selectComponentSelections.get(Long.valueOf(messageId))) == null || (mutableMap = Maps6.toMutableMap(map)) == null) {
            return;
        }
        if (componentIndex != null && mutableMap.containsKey(componentIndex)) {
            mutableMap.remove(componentIndex);
            this.selectComponentSelections.put(Long.valueOf(messageId), mutableMap);
            markChanged();
        } else if (componentIndex == null) {
            this.selectComponentSelections.remove(Long.valueOf(messageId));
            markChanged();
        }
    }

    public final Map<String, StoreApplicationInteractions.ComponentLocation> getComponentInteractions() {
        return this.componentInteractions;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Map<Long, Map<Integer, List<SelectComponent2>>> getSelectComponentSelections() {
        return this.selectComponentSelections;
    }

    public final Map<Long, Map<Integer, List<SelectComponent2>>> getSelectComponentSelectionsData() {
        return this.selectComponentSelectionsSnapshot;
    }

    public final Map<Long, Map<Integer, List<SelectComponent2>>> getSelectComponentSelectionsSnapshot() {
        return this.selectComponentSelectionsSnapshot;
    }

    public final Observable<Map<Long, Map<Integer, List<SelectComponent2>>>> observeSelectComponentSelections() {
        Observable<Map<Long, Map<Integer, List<SelectComponent2>>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setSelectComponentSelection(long messageId, int componentIndex, List<SelectComponent2> selectedItems) {
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        this.dispatcher.schedule(new AnonymousClass1(messageId, selectedItems, componentIndex));
    }

    public final void setSelectComponentSelectionsSnapshot(Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>> map) {
        Intrinsics3.checkNotNullParameter(map, "<set-?>");
        this.selectComponentSelectionsSnapshot = map;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.selectComponentSelectionsSnapshot = new HashMap(this.selectComponentSelections);
    }

    public StoreLocalActionComponentState(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.componentInteractions = new LinkedHashMap();
        this.selectComponentSelections = new LinkedHashMap();
        this.selectComponentSelectionsSnapshot = Maps6.emptyMap();
    }
}
