package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringNumberConversions;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildsNsfw.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b'\u0010(J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002*\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00122\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00122\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010#\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010&\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$¨\u0006*"}, d2 = {"Lcom/discord/stores/StoreGuildsNsfw;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/GuildId;", "", "toStringSet", "(Ljava/util/Set;)Ljava/util/Set;", "toGuildIdSet", "guildId", "", "isGuildNsfwGateAgreed", "(J)Z", "Lrx/Observable;", "observeIsGuildNsfwGateAgreed", "(J)Lrx/Observable;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, "(J)V", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED, "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "guildIdsAllowedSnapshot", "Ljava/util/Set;", "", "guildIdsAllowed", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildsNsfw extends StoreV2 {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final String GUILDS_ALLOWED_KEY = "GUILDS_ALLOWED_KEY";
    private final Dispatcher dispatcher;
    private final Set<Long> guildIdsAllowed;
    private Set<Long> guildIdsAllowedSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* compiled from: StoreGuildsNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreGuildsNsfw$Companion;", "", "", StoreGuildsNsfw.GUILDS_ALLOWED_KEY, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildsNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsNsfw$allow$1, reason: invalid class name */
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
            StoreGuildsNsfw.access$getGuildIdsAllowed$p(StoreGuildsNsfw.this).add(Long.valueOf(this.$guildId));
            StoreGuildsNsfw.this.markChanged();
        }
    }

    /* compiled from: StoreGuildsNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsNsfw$deny$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null || channel.getNsfw()) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, 0L, null, null, 12, null);
            } else {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* compiled from: StoreGuildsNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsNsfw$observeIsGuildNsfwGateAgreed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreGuildsNsfw.this.isGuildNsfwGateAgreed(this.$guildId);
        }
    }

    public StoreGuildsNsfw(Dispatcher dispatcher, StoreChannels storeChannels, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.guildIdsAllowed = new LinkedHashSet();
        this.guildIdsAllowedSnapshot = Sets5.emptySet();
    }

    public static final /* synthetic */ Set access$getGuildIdsAllowed$p(StoreGuildsNsfw storeGuildsNsfw) {
        return storeGuildsNsfw.guildIdsAllowed;
    }

    private final Set<Long> toGuildIdSet(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Long longOrNull = StringNumberConversions.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return _Collections.toSet(arrayList);
    }

    private final Set<String> toStringSet(Set<Long> set) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return _Collections.toSet(arrayList);
    }

    public final void allow(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void deny(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.storeChannels.observeDefaultChannel(guildId), 0L, false, 3, null), StoreGuildsNsfw.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Set<Long> setEmptySet;
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(GUILDS_ALLOWED_KEY, Sets5.emptySet());
        if (stringSet == null || (setEmptySet = toGuildIdSet(stringSet)) == null) {
            setEmptySet = Sets5.emptySet();
        }
        this.guildIdsAllowed.addAll(setEmptySet);
        markChanged();
    }

    public final boolean isGuildNsfwGateAgreed(long guildId) {
        return this.guildIdsAllowedSnapshot.contains(Long.valueOf(guildId));
    }

    public final Observable<Boolean> observeIsGuildNsfwGateAgreed(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.guildIdsAllowedSnapshot = new HashSet(this.guildIdsAllowed);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet(GUILDS_ALLOWED_KEY, toStringSet(this.guildIdsAllowed));
        editorEdit.apply();
    }
}
