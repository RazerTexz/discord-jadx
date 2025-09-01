package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.persister.Persister;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserRelationships.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00014B\u0011\u0012\b\b\u0002\u0010,\u001a\u00020+¢\u0006\u0004\b2\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0007J!\u0010\u000e\u001a\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r0\t0\u0013¢\u0006\u0004\b\u0016\u0010\u0015J9\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r0\t0\u00132\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u0017¢\u0006\u0004\b\u0016\u0010\u0019J'\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u00132\n\u0010\u001a\u001a\u00060\nj\u0002`\u000b¢\u0006\u0004\b\u0016\u0010\u001bJ/\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r0\t0\u00132\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\u0005H\u0017¢\u0006\u0004\b(\u0010\u0007R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010*R0\u00100\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r0\t0/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/discord/stores/StoreUserRelationships;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Loaded;", "ensureRelationshipLoaded", "()Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Loaded;", "", "init", "()V", "handlePreLogout", "", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "getRelationships", "()Ljava/util/Map;", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "getRelationshipsState", "()Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "Lrx/Observable;", "observeUserRelationshipsState", "()Lrx/Observable;", "observe", "", "userIds", "(Ljava/util/Collection;)Lrx/Observable;", "userId", "(J)Lrx/Observable;", "relationshipType", "observeForType", "(I)Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/models/domain/ModelUserRelationship;", "relationship", "handleRelationshipAdd", "(Lcom/discord/models/domain/ModelUserRelationship;)V", "handleRelationshipRemove", "snapshotData", "relationshipsState", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "relationshipsStateSnapshot", "Lcom/discord/utilities/persister/Persister;", "relationshipsCache", "Lcom/discord/utilities/persister/Persister;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "UserRelationshipsState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserRelationships extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Persister<Map<Long, Integer>> relationshipsCache;
    private UserRelationshipsState relationshipsState;
    private UserRelationshipsState relationshipsStateSnapshot;

    /* compiled from: StoreUserRelationships.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "", "<init>", "()V", "Loaded", "Unloaded", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Unloaded;", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class UserRelationshipsState {

        /* compiled from: StoreUserRelationships.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\t\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0002¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\n\u001a\u00020\u00002\u001c\b\u0002\u0010\t\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R-\u0010\t\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Loaded;", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "component1", "()Ljava/util/Map;", "relationships", "copy", "(Ljava/util/Map;)Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getRelationships", "<init>", "(Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends UserRelationshipsState {
            private final Map<Long, Integer> relationships;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Map<Long, Integer> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "relationships");
                this.relationships = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.relationships;
                }
                return loaded.copy(map);
            }

            public final Map<Long, Integer> component1() {
                return this.relationships;
            }

            public final Loaded copy(Map<Long, Integer> relationships) {
                Intrinsics3.checkNotNullParameter(relationships, "relationships");
                return new Loaded(relationships);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.relationships, ((Loaded) other).relationships);
                }
                return true;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public int hashCode() {
                Map<Long, Integer> map = this.relationships;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.M(outline.U("Loaded(relationships="), this.relationships, ")");
            }
        }

        /* compiled from: StoreUserRelationships.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState$Unloaded;", "Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unloaded extends UserRelationshipsState {
            public static final Unloaded INSTANCE = new Unloaded();

            private Unloaded() {
                super(null);
            }
        }

        private UserRelationshipsState() {
        }

        public /* synthetic */ UserRelationshipsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserRelationships$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Integer> invoke2() {
            UserRelationshipsState userRelationshipsStateAccess$getRelationshipsStateSnapshot$p = StoreUserRelationships.access$getRelationshipsStateSnapshot$p(StoreUserRelationships.this);
            if (Intrinsics3.areEqual(userRelationshipsStateAccess$getRelationshipsStateSnapshot$p, UserRelationshipsState.Unloaded.INSTANCE)) {
                return Maps6.emptyMap();
            }
            if (!(userRelationshipsStateAccess$getRelationshipsStateSnapshot$p instanceof UserRelationshipsState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            UserRelationshipsState userRelationshipsStateAccess$getRelationshipsStateSnapshot$p2 = StoreUserRelationships.access$getRelationshipsStateSnapshot$p(StoreUserRelationships.this);
            Objects.requireNonNull(userRelationshipsStateAccess$getRelationshipsStateSnapshot$p2, "null cannot be cast to non-null type com.discord.stores.StoreUserRelationships.UserRelationshipsState.Loaded");
            return ((UserRelationshipsState.Loaded) userRelationshipsStateAccess$getRelationshipsStateSnapshot$p2).getRelationships();
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u000026\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserRelationships$observe$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>> {
        public final /* synthetic */ Collection $userIds;

        public AnonymousClass2(Collection collection) {
            this.$userIds = collection;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Integer> call2(Map<Long, Integer> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (this.$userIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "relationships", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserRelationships$observe$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Map<Long, ? extends Integer>, Integer> {
        public final /* synthetic */ long $userId;

        public AnonymousClass3(long j) {
            this.$userId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(Map<Long, Integer> map) {
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u000026\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "relationships", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserRelationships$observeForType$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>> {
        public final /* synthetic */ int $relationshipType;

        public AnonymousClass1(int i) {
            this.$relationshipType = i;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Integer> call2(Map<Long, Integer> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "relationships");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (entry.getValue().intValue() == this.$relationshipType) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "invoke", "()Lcom/discord/stores/StoreUserRelationships$UserRelationshipsState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserRelationships$observeUserRelationshipsState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserRelationshipsState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserRelationshipsState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserRelationshipsState invoke() {
            return StoreUserRelationships.this.getRelationshipsStateSnapshot();
        }
    }

    public StoreUserRelationships() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreUserRelationships(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ UserRelationshipsState access$getRelationshipsStateSnapshot$p(StoreUserRelationships storeUserRelationships) {
        return storeUserRelationships.relationshipsStateSnapshot;
    }

    public static final /* synthetic */ void access$setRelationshipsStateSnapshot$p(StoreUserRelationships storeUserRelationships, UserRelationshipsState userRelationshipsState) {
        storeUserRelationships.relationshipsStateSnapshot = userRelationshipsState;
    }

    @Store3
    private final UserRelationshipsState.Loaded ensureRelationshipLoaded() {
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        if (loaded == null) {
            loaded = new UserRelationshipsState.Loaded(Maps6.emptyMap());
        }
        this.relationshipsState = loaded;
        return loaded;
    }

    public final Map<Long, Integer> getRelationships() {
        Map<Long, Integer> relationships;
        UserRelationshipsState userRelationshipsState = this.relationshipsStateSnapshot;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        return (loaded == null || (relationships = loaded.getRelationships()) == null) ? Maps6.emptyMap() : relationships;
    }

    /* renamed from: getRelationshipsState, reason: from getter */
    public final UserRelationshipsState getRelationshipsStateSnapshot() {
        return this.relationshipsStateSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ModelUserRelationship> relationships = payload.getRelationships();
        Intrinsics3.checkNotNullExpressionValue(relationships, "payload\n        .relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(relationships, 10)), 16));
        for (ModelUserRelationship modelUserRelationship : relationships) {
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "it");
            Long lValueOf = Long.valueOf(modelUserRelationship.getId());
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "it");
            linkedHashMap.put(lValueOf, Integer.valueOf(modelUserRelationship.getType()));
        }
        this.relationshipsState = new UserRelationshipsState.Loaded(linkedHashMap);
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.relationshipsState = UserRelationshipsState.Unloaded.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = Maps6.toMutableMap(ensureRelationshipLoaded().getRelationships());
        Integer num = (Integer) mutableMap.get(Long.valueOf(relationship.getId()));
        int type = relationship.getType();
        if (num != null && num.intValue() == type) {
            return;
        }
        mutableMap.put(Long.valueOf(relationship.getId()), Integer.valueOf(relationship.getType()));
        this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
        markChanged();
    }

    @Store3
    public final void handleRelationshipRemove(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = Maps6.toMutableMap(ensureRelationshipLoaded().getRelationships());
        if (mutableMap.remove(Long.valueOf(relationship.getId())) != null) {
            this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
            markChanged();
        }
    }

    public final void init() {
        Map<Long, Integer> map = this.relationshipsCache.get();
        if (!Intrinsics3.areEqual(map, StoreUserRelationships2.access$getUNLOADED_RELATIONSHIPS_SENTINEL$p())) {
            this.relationshipsState = new UserRelationshipsState.Loaded(map);
            markChanged();
        }
    }

    public final Observable<Map<Long, Integer>> observe() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Integer>> observeForType(int relationshipType) {
        Observable<Map<Long, Integer>> observableR = observe().G(new AnonymousClass1(relationshipType)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<UserRelationshipsState> observeUserRelationshipsState() {
        Observable<UserRelationshipsState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        UserRelationshipsState loaded;
        super.snapshotData();
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (userRelationshipsState instanceof UserRelationshipsState.Loaded) {
            HashMap map = new HashMap(((UserRelationshipsState.Loaded) userRelationshipsState).getRelationships());
            Persister.set$default(this.relationshipsCache, map, false, 2, null);
            loaded = new UserRelationshipsState.Loaded(map);
        } else {
            Persister.clear$default(this.relationshipsCache, false, 1, null);
            loaded = UserRelationshipsState.Unloaded.INSTANCE;
        }
        this.relationshipsStateSnapshot = loaded;
    }

    public StoreUserRelationships(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        UserRelationshipsState.Unloaded unloaded = UserRelationshipsState.Unloaded.INSTANCE;
        this.relationshipsState = unloaded;
        this.relationshipsStateSnapshot = unloaded;
        this.relationshipsCache = new Persister<>("STORE_USER_RELATIONSHIPS_V9", StoreUserRelationships2.access$getUNLOADED_RELATIONSHIPS_SENTINEL$p());
    }

    public final Observable<Map<Long, Integer>> observe(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Integer>> observableR = observe().G(new AnonymousClass2(userIds)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observe(long userId) {
        Observable observableG = observe().G(new AnonymousClass3(userId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "observe()\n          .map…> relationships[userId] }");
        return observableG;
    }
}
