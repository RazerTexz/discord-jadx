package com.discord.stores;

import android.content.Context;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreEmojiGuild.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b-\u0010.J)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R,\u0010#\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R,\u0010,\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$¨\u0006/"}, d2 = {"Lcom/discord/stores/StoreEmojiGuild;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "emojis", "", "handleGuildEmojisLoaded", "(JLjava/util/List;)V", "getGuildEmoji", "(J)Ljava/util/List;", "Lrx/Observable;", "observeGuildEmoji", "(J)Lrx/Observable;", "fetchGuildEmoji", "(J)V", "activate", "deactivate", "()V", "Lcom/discord/api/emoji/GuildEmojisUpdate;", "emojiUpdate", "handleEmojiUpdate", "(Lcom/discord/api/emoji/GuildEmojisUpdate;)V", "emojiId", "deleteEmoji", "(JJ)V", "snapshotData", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "activeGuildId", "J", "", "guildEmoji", "Ljava/util/Map;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "guildEmojiSnapshot", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreEmojiGuild extends StoreV2 {
    private long activeGuildId;
    private final Dispatcher dispatcher;
    private final Map<Long, List<ModelEmojiGuild>> guildEmoji;
    private Map<Long, ? extends List<ModelEmojiGuild>> guildEmojiSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreEmojiGuild.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiGuild$activate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.access$setActiveGuildId$p(StoreEmojiGuild.this, this.$guildId);
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiGuild$deactivate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.access$setActiveGuildId$p(StoreEmojiGuild.this, -1L);
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiGuild$deleteEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $emojiId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$emojiId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map mapAccess$getGuildEmoji$p = StoreEmojiGuild.access$getGuildEmoji$p(StoreEmojiGuild.this);
            Long lValueOf = Long.valueOf(this.$guildId);
            List listEmptyList = (List) StoreEmojiGuild.access$getGuildEmoji$p(StoreEmojiGuild.this).get(Long.valueOf(this.$guildId));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : listEmptyList) {
                if (this.$emojiId != ((ModelEmojiGuild) obj).getId()) {
                    arrayList.add(obj);
                }
            }
            mapAccess$getGuildEmoji$p.put(lValueOf, arrayList);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "emojis", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiGuild$fetchGuildEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelEmojiGuild>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEmojiGuild> list) {
            invoke2((List<ModelEmojiGuild>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEmojiGuild> list) {
            Intrinsics3.checkNotNullParameter(list, "emojis");
            StoreEmojiGuild.access$handleGuildEmojisLoaded(StoreEmojiGuild.this, this.$guildId, list);
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiGuild$handleGuildEmojisLoaded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $emojis;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, long j) {
            super(0);
            this.$emojis = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.access$getGuildEmoji$p(StoreEmojiGuild.this).put(Long.valueOf(this.$guildId), this.$emojis);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmojiGuild$observeGuildEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ModelEmojiGuild>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelEmojiGuild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelEmojiGuild> invoke2() {
            return StoreEmojiGuild.this.getGuildEmoji(this.$guildId);
        }
    }

    public StoreEmojiGuild(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildEmoji = new LinkedHashMap();
        this.guildEmojiSnapshot = Maps6.emptyMap();
        this.activeGuildId = -1L;
    }

    public static final /* synthetic */ long access$getActiveGuildId$p(StoreEmojiGuild storeEmojiGuild) {
        return storeEmojiGuild.activeGuildId;
    }

    public static final /* synthetic */ Map access$getGuildEmoji$p(StoreEmojiGuild storeEmojiGuild) {
        return storeEmojiGuild.guildEmoji;
    }

    public static final /* synthetic */ void access$handleGuildEmojisLoaded(StoreEmojiGuild storeEmojiGuild, long j, List list) {
        storeEmojiGuild.handleGuildEmojisLoaded(j, list);
    }

    public static final /* synthetic */ void access$setActiveGuildId$p(StoreEmojiGuild storeEmojiGuild, long j) {
        storeEmojiGuild.activeGuildId = j;
    }

    @Store3
    private final void handleGuildEmojisLoaded(long guildId, List<ModelEmojiGuild> emojis) {
        this.dispatcher.schedule(new AnonymousClass1(emojis, guildId));
    }

    public final void activate(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void deactivate() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void deleteEmoji(long guildId, long emojiId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, emojiId));
    }

    public final void fetchGuildEmoji(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildEmojis(guildId), false, 1, null), StoreEmojiGuild.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public final List<ModelEmojiGuild> getGuildEmoji(long guildId) {
        return this.guildEmojiSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        Intrinsics3.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        long j = this.activeGuildId;
        if (guildId == j) {
            fetchGuildEmoji(j);
        }
    }

    public final Observable<List<ModelEmojiGuild>> observeGuildEmoji(long guildId) {
        Observable<List<ModelEmojiGuild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildEmojiSnapshot = new HashMap(this.guildEmoji);
    }
}
