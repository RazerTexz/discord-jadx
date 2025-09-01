package com.discord.widgets.botuikit;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: ComponentChatListState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/botuikit/ComponentChatListState;", "", "Lrx/Observable;", "", "", "Lcom/discord/primitives/MessageId;", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "observeChatListComponentState", "()Lrx/Observable;", "<init>", "()V", "ComponentStoreState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ComponentChatListState {
    public static final ComponentChatListState INSTANCE = new ComponentChatListState();

    /* compiled from: ComponentChatListState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012 \b\u0002\u0010\u000f\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\"\u0010\u0006\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJX\u0010\u0011\u001a\u00020\u00002\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022 \b\u0002\u0010\u000f\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\rR+\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R1\u0010\u000f\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "", "", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "component1", "()Ljava/util/Map;", "", "Lcom/discord/api/botuikit/SelectItem;", "component2", "", "component3", "()Z", "interactionState", "selections", "animateEmojis", "copy", "(Ljava/util/Map;Ljava/util/Map;Z)Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAnimateEmojis", "Ljava/util/Map;", "getInteractionState", "getSelections", "<init>", "(Ljava/util/Map;Ljava/util/Map;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ComponentStoreState {
        private final boolean animateEmojis;
        private final Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState;
        private final Map<Integer, List<SelectComponent2>> selections;

        public ComponentStoreState() {
            this(null, null, false, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ComponentStoreState(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map, Map<Integer, ? extends List<SelectComponent2>> map2, boolean z2) {
            this.interactionState = map;
            this.selections = map2;
            this.animateEmojis = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ComponentStoreState copy$default(ComponentStoreState componentStoreState, Map map, Map map2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = componentStoreState.interactionState;
            }
            if ((i & 2) != 0) {
                map2 = componentStoreState.selections;
            }
            if ((i & 4) != 0) {
                z2 = componentStoreState.animateEmojis;
            }
            return componentStoreState.copy(map, map2, z2);
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> component1() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectComponent2>> component2() {
            return this.selections;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final ComponentStoreState copy(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> interactionState, Map<Integer, ? extends List<SelectComponent2>> selections, boolean animateEmojis) {
            return new ComponentStoreState(interactionState, selections, animateEmojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentStoreState)) {
                return false;
            }
            ComponentStoreState componentStoreState = (ComponentStoreState) other;
            return Intrinsics3.areEqual(this.interactionState, componentStoreState.interactionState) && Intrinsics3.areEqual(this.selections, componentStoreState.selections) && this.animateEmojis == componentStoreState.animateEmojis;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> getInteractionState() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectComponent2>> getSelections() {
            return this.selections;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Map<Integer, StoreApplicationInteractions.InteractionSendState> map = this.interactionState;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Integer, List<SelectComponent2>> map2 = this.selections;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ComponentStoreState(interactionState=");
            sbU.append(this.interactionState);
            sbU.append(", selections=");
            sbU.append(this.selections);
            sbU.append(", animateEmojis=");
            return outline.O(sbU, this.animateEmojis, ")");
        }

        public /* synthetic */ ComponentStoreState(Map map, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Maps6.emptyMap() : map, (i & 2) != 0 ? Maps6.emptyMap() : map2, (i & 4) != 0 ? true : z2);
        }
    }

    /* compiled from: ComponentChatListState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\r \u0006*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\u00000\u00002N\u0010\u0007\u001aJ\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0000 \u0006*$\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0000\u0018\u00010\u00000\u00002Z\u0010\n\u001aV\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0000 \u0006**\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0000\u0018\u00010\u00000\u00002\u000e\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\u000b0\u000bH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"", "", "Lcom/discord/primitives/MessageId;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState;", "kotlin.jvm.PlatformType", "interactions", "", "Lcom/discord/api/botuikit/SelectItem;", "selections", "", "animateEmojis", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.ComponentChatListState$observeChatListComponentState$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>>, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>>, Boolean, Map<Long, ? extends ComponentStoreState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ Map<Long, ? extends ComponentStoreState> call(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectComponent2>>> map2, Boolean bool) {
            return call2(map, (Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>>) map2, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ComponentStoreState> call2(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<SelectComponent2>>> map2, Boolean bool) {
            List listDistinct = _Collections.distinct(_Sets.plus((Set) map.keySet(), (Iterable) map2.keySet()));
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listDistinct, 10)), 16));
            for (Object obj : listDistinct) {
                long jLongValue = ((Number) obj).longValue();
                Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map3 = map.get(Long.valueOf(jLongValue));
                Map<Integer, ? extends List<SelectComponent2>> map4 = map2.get(Long.valueOf(jLongValue));
                Intrinsics3.checkNotNullExpressionValue(bool, "animateEmojis");
                linkedHashMap.put(obj, new ComponentStoreState(map3, map4, bool.booleanValue()));
            }
            return linkedHashMap;
        }
    }

    private ComponentChatListState() {
    }

    public final Observable<Map<Long, ComponentStoreState>> observeChatListComponentState() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, ComponentStoreState>> observableI = Observable.i(companion.getInteractions().observeComponentInteractionState(), companion.getLocalActionComponentState().observeSelectComponentSelections(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…s\n        )\n      }\n    }");
        return observableI;
    }
}
