package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.textprocessing.node.EmojiNode;
import d0.LazyJVM;
import d0.e0.KClass;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMediaFavorites.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0003!\"#B-\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\b2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013¨\u0006$"}, d2 = {"Lcom/discord/stores/StoreMediaFavorites;", "Lcom/discord/stores/StoreV2;", "", "Ld0/e0/c;", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "types", "getFavorites", "(Ljava/util/Set;)Ljava/util/Set;", "Lrx/Observable;", "observeFavorites", "(Ljava/util/Set;)Lrx/Observable;", "favorite", "", "addFavorite", "(Lcom/discord/stores/StoreMediaFavorites$Favorite;)V", "removeFavorite", "snapshotData", "()V", "favoritesSnapshot", "Ljava/util/Set;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/persister/Persister;", "persister", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "favorites", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/persister/Persister;)V", "Companion", "Favorite", "FavoriteEmoji", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMediaFavorites extends StoreV2 {
    public static final String FAVORITES_CACHE_KEY = "STORE_FAVORITES";
    private final Dispatcher dispatcher;
    private final Set<Favorite> favorites;
    private Set<? extends Favorite> favoritesSnapshot;
    private final ObservationDeck observationDeck;
    private final Persister<Set<Favorite>> persister;

    /* compiled from: StoreMediaFavorites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreMediaFavorites$Favorite;", "", "<init>", "()V", "Companion", "FavCustomEmoji", "FavUnicodeEmoji", "Lcom/discord/stores/StoreMediaFavorites$Favorite$FavCustomEmoji;", "Lcom/discord/stores/StoreMediaFavorites$Favorite$FavUnicodeEmoji;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Favorite {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy AllTypes$delegate = LazyJVM.lazy(StoreMediaFavorites2.INSTANCE);
        private static final Set<KClass<? extends Favorite>> EmojiTypes = Sets5.setOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(FavCustomEmoji.class), Reflection2.getOrCreateKotlinClass(FavUnicodeEmoji.class)});

        /* compiled from: StoreMediaFavorites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR+\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR'\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/discord/stores/StoreMediaFavorites$Favorite$Companion;", "", "", "Ld0/e0/c;", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "AllTypes$delegate", "Lkotlin/Lazy;", "getAllTypes", "()Ljava/util/Set;", "AllTypes", "EmojiTypes", "Ljava/util/Set;", "getEmojiTypes", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Set<KClass<? extends Favorite>> getAllTypes() {
                Lazy lazyAccess$getAllTypes$cp = Favorite.access$getAllTypes$cp();
                Companion companion = Favorite.INSTANCE;
                return (Set) lazyAccess$getAllTypes$cp.getValue();
            }

            public final Set<KClass<? extends Favorite>> getEmojiTypes() {
                return Favorite.access$getEmojiTypes$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: StoreMediaFavorites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/discord/stores/StoreMediaFavorites$Favorite$FavCustomEmoji;", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "Lcom/discord/stores/StoreMediaFavorites$FavoriteEmoji;", "", "component1", "()Ljava/lang/String;", "emojiUniqueId", "copy", "(Ljava/lang/String;)Lcom/discord/stores/StoreMediaFavorites$Favorite$FavCustomEmoji;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmojiUniqueId", "<init>", "(Ljava/lang/String;)V", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "custom", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class FavCustomEmoji extends Favorite implements FavoriteEmoji {
            private final String emojiUniqueId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavCustomEmoji(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "emojiUniqueId");
                this.emojiUniqueId = str;
            }

            public static /* synthetic */ FavCustomEmoji copy$default(FavCustomEmoji favCustomEmoji, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = favCustomEmoji.getEmojiUniqueId();
                }
                return favCustomEmoji.copy(str);
            }

            public final String component1() {
                return getEmojiUniqueId();
            }

            public final FavCustomEmoji copy(String emojiUniqueId) {
                Intrinsics3.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
                return new FavCustomEmoji(emojiUniqueId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FavCustomEmoji) && Intrinsics3.areEqual(getEmojiUniqueId(), ((FavCustomEmoji) other).getEmojiUniqueId());
                }
                return true;
            }

            @Override // com.discord.stores.StoreMediaFavorites.FavoriteEmoji
            public String getEmojiUniqueId() {
                return this.emojiUniqueId;
            }

            public int hashCode() {
                String emojiUniqueId = getEmojiUniqueId();
                if (emojiUniqueId != null) {
                    return emojiUniqueId.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("FavCustomEmoji(emojiUniqueId=");
                sbU.append(getEmojiUniqueId());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public FavCustomEmoji(EmojiNode.EmojiIdAndType.Custom custom) {
                this(String.valueOf(custom.getId()));
                Intrinsics3.checkNotNullParameter(custom, "custom");
            }
        }

        /* compiled from: StoreMediaFavorites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/discord/stores/StoreMediaFavorites$Favorite$FavUnicodeEmoji;", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "Lcom/discord/stores/StoreMediaFavorites$FavoriteEmoji;", "", "component1", "()Ljava/lang/String;", "emojiUniqueId", "copy", "(Ljava/lang/String;)Lcom/discord/stores/StoreMediaFavorites$Favorite$FavUnicodeEmoji;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmojiUniqueId", "<init>", "(Ljava/lang/String;)V", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "unicode", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class FavUnicodeEmoji extends Favorite implements FavoriteEmoji {
            private final String emojiUniqueId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavUnicodeEmoji(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "emojiUniqueId");
                this.emojiUniqueId = str;
            }

            public static /* synthetic */ FavUnicodeEmoji copy$default(FavUnicodeEmoji favUnicodeEmoji, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = favUnicodeEmoji.getEmojiUniqueId();
                }
                return favUnicodeEmoji.copy(str);
            }

            public final String component1() {
                return getEmojiUniqueId();
            }

            public final FavUnicodeEmoji copy(String emojiUniqueId) {
                Intrinsics3.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
                return new FavUnicodeEmoji(emojiUniqueId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FavUnicodeEmoji) && Intrinsics3.areEqual(getEmojiUniqueId(), ((FavUnicodeEmoji) other).getEmojiUniqueId());
                }
                return true;
            }

            @Override // com.discord.stores.StoreMediaFavorites.FavoriteEmoji
            public String getEmojiUniqueId() {
                return this.emojiUniqueId;
            }

            public int hashCode() {
                String emojiUniqueId = getEmojiUniqueId();
                if (emojiUniqueId != null) {
                    return emojiUniqueId.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("FavUnicodeEmoji(emojiUniqueId=");
                sbU.append(getEmojiUniqueId());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public FavUnicodeEmoji(ModelEmojiUnicode modelEmojiUnicode) {
                Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "unicode");
                String uniqueId = modelEmojiUnicode.getUniqueId();
                Intrinsics3.checkNotNullExpressionValue(uniqueId, "unicode.uniqueId");
                this(uniqueId);
            }
        }

        private Favorite() {
        }

        public static final /* synthetic */ Lazy access$getAllTypes$cp() {
            return AllTypes$delegate;
        }

        public static final /* synthetic */ Set access$getEmojiTypes$cp() {
            return EmojiTypes;
        }

        public /* synthetic */ Favorite(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMediaFavorites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreMediaFavorites$FavoriteEmoji;", "", "", "getEmojiUniqueId", "()Ljava/lang/String;", "emojiUniqueId", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface FavoriteEmoji {
        String getEmojiUniqueId();
    }

    /* compiled from: StoreMediaFavorites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaFavorites$addFavorite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Favorite $favorite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Favorite favorite) {
            super(0);
            this.$favorite = favorite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreMediaFavorites.access$getFavorites$p(StoreMediaFavorites.this).add(this.$favorite)) {
                StoreMediaFavorites.this.markChanged();
            }
        }
    }

    /* compiled from: StoreMediaFavorites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaFavorites$observeFavorites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Favorite>> {
        public final /* synthetic */ Set $types;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Set set) {
            super(0);
            this.$types = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Favorite> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Favorite> invoke2() {
            return StoreMediaFavorites.this.getFavorites(this.$types);
        }
    }

    /* compiled from: StoreMediaFavorites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaFavorites$removeFavorite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Favorite $favorite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Favorite favorite) {
            super(0);
            this.$favorite = favorite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreMediaFavorites.access$getFavorites$p(StoreMediaFavorites.this).remove(this.$favorite)) {
                StoreMediaFavorites.this.markChanged();
            }
        }
    }

    public /* synthetic */ StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? new Persister(FAVORITES_CACHE_KEY, Sets5.emptySet()) : persister);
    }

    public static final /* synthetic */ Set access$getFavorites$p(StoreMediaFavorites storeMediaFavorites) {
        return storeMediaFavorites.favorites;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getFavorites$default(StoreMediaFavorites storeMediaFavorites, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = Favorite.INSTANCE.getAllTypes();
        }
        return storeMediaFavorites.getFavorites(set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable observeFavorites$default(StoreMediaFavorites storeMediaFavorites, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = Favorite.INSTANCE.getAllTypes();
        }
        return storeMediaFavorites.observeFavorites(set);
    }

    public final void addFavorite(Favorite favorite) {
        Intrinsics3.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new AnonymousClass1(favorite));
    }

    public final Set<Favorite> getFavorites(Set<? extends KClass<? extends Favorite>> types) {
        Intrinsics3.checkNotNullParameter(types, "types");
        Set<? extends Favorite> set = this.favoritesSnapshot;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (types.contains(Reflection2.getOrCreateKotlinClass(((Favorite) obj).getClass()))) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public final Observable<Set<Favorite>> observeFavorites(Set<? extends KClass<? extends Favorite>> types) {
        Intrinsics3.checkNotNullParameter(types, "types");
        Observable<Set<Favorite>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(types), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeFavorite(Favorite favorite) {
        Intrinsics3.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new AnonymousClass1(favorite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashSet hashSet = new HashSet(this.favorites);
        this.favoritesSnapshot = hashSet;
        this.persister.set(hashSet, true);
    }

    public StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister<Set<Favorite>> persister) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(persister, "persister");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.persister = persister;
        Set<Favorite> set = persister.get();
        this.favoritesSnapshot = set;
        this.favorites = _Collections.toMutableSet(set);
    }
}
