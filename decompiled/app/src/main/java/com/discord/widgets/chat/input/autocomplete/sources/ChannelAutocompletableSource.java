package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: ChannelAutocompletableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/ChannelAutocompletableSource;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "observeChannelAutocompletables", "(J)Lrx/Observable;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "getStoreChannels", "()Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreThreadsActiveJoined;", "storeThreadsActiveJoined", "Lcom/discord/stores/StoreThreadsActiveJoined;", "getStoreThreadsActiveJoined", "()Lcom/discord/stores/StoreThreadsActiveJoined;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "getStorePermissions", "()Lcom/discord/stores/StorePermissions;", "<init>", "(Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreThreadsActiveJoined;Lcom/discord/stores/StorePermissions;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelAutocompletableSource {
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;

    /* compiled from: ChannelAutocompletableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a>\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u000b0\u000b0\n \u0004*\u001e\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u000b0\u000b0\n\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\u0006\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0007 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "guildChannels", "activeJoinedThreads", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource$observeChannelAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3) {
            return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, Long> map3) {
            TreeSet treeSet = new TreeSet(new AutocompletableComparator());
            Intrinsics3.checkNotNullExpressionValue(map2, "activeJoinedThreads");
            Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
            for (Channel channel : Maps6.plus(map2, map).values()) {
                if (ChannelUtils.v(channel) || ChannelUtils.J(channel) || ChannelUtils.k(channel)) {
                    Intrinsics3.checkNotNullExpressionValue(map3, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
                    if (PermissionUtils.hasAccess(channel, map3)) {
                        treeSet.add(new ChannelAutocompletable(channel));
                    }
                }
            }
            return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.CHANNELS, treeSet));
        }
    }

    public ChannelAutocompletableSource(StoreChannels storeChannels, StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        this.storeChannels = storeChannels;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storePermissions = storePermissions;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final StoreThreadsActiveJoined getStoreThreadsActiveJoined() {
        return this.storeThreadsActiveJoined;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeChannelAutocompletables(long guildId) {
        Observable observableI = Observable.i(ObservableExtensionsKt.computationLatest(StoreChannels.observeChannelsForGuild$default(this.storeChannels, guildId, null, 2, null)), this.storeThreadsActiveJoined.observeActiveJoinedThreadsChannelsForGuild(guildId), ObservableExtensionsKt.computationLatest(this.storePermissions.observePermissionsForAllChannels()), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ANNELS to channels)\n    }");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.leadingEdgeThrottle(observableR, 500L, TimeUnit.MILLISECONDS);
    }
}
