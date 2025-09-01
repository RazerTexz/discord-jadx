package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.user.search.ChannelFrecencyTracker;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: StoreChannelsSelected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 r2\u00020\u0001:\u0003rstB7\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bp\u0010qJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\n\u0010\bJk\u0010\u0019\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\r0\u000f2\n\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\u001a\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\b\u0012\u00060\u0010j\u0002`\u00150\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ?\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\u001a\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\b\u0012\u00060\u0010j\u0002`\u00150\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJQ\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\r0\u000f2\n\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\u001a\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\b\u0012\u00060\u0010j\u0002`\u00150\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170 ¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110 ¢\u0006\u0004\b#\u0010\"J\u0011\u0010$\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0 ¢\u0006\u0004\b(\u0010\"J\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020 ¢\u0006\u0004\b)\u0010\"J\u0017\u0010*\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110 ¢\u0006\u0004\b*\u0010\"J\u000f\u0010+\u001a\u00020\u0004H\u0007¢\u0006\u0004\b+\u0010\bJ\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/JA\u00104\u001a\u00020\u00042\n\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\n\u00100\u001a\u00060\u0010j\u0002`\u00112\u000e\u00101\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\b\u00103\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0004\b4\u00105JA\u0010:\u001a\u00020\u00042\n\u0010\u0014\u001a\u00060\u0010j\u0002`\u00132\n\u00100\u001a\u00060\u0010j\u0002`\u00112\u000e\u00107\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`62\b\u00109\u001a\u0004\u0018\u000108H\u0007¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0007¢\u0006\u0004\b<\u0010\bJ\u000f\u0010=\u001a\u00020\u0004H\u0007¢\u0006\u0004\b=\u0010\bJ\u0017\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\bB\u0010AJ\u000f\u0010C\u001a\u00020\u0004H\u0017¢\u0006\u0004\bC\u0010\bJ\u000f\u0010D\u001a\u00020\u0004H\u0007¢\u0006\u0004\bD\u0010\bJ\u0017\u0010E\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\rH\u0007¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\rH\u0007¢\u0006\u0004\bG\u0010FR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR&\u0010L\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0013\u0012\u0004\u0012\u00020\u000b0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0019\u0010O\u001a\u00020N8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010TR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR0\u0010h\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0010j\u0002`\u0013\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u000f0g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010VR\u0016\u0010n\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010VR\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020N0g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010i¨\u0006u"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "resolvedSelectedChannel", "", "onSelectedChannelResolved", "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)V", "updateInitializationState", "()V", "validateSelectedChannel", "loadFromCache", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection;", "userChannelSelection", "Lcom/discord/api/channel/Channel;", "resolvedChannel", "", "", "Lcom/discord/primitives/ChannelId;", "channels", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "", "storeChannelsInitializedForAuthedUser", "resolveSelectedChannel", "(Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection;Lcom/discord/api/channel/Channel;Ljava/util/Map;JLjava/util/Map;Z)Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "channel", "isValidResolution", "(Lcom/discord/api/channel/Channel;JLjava/util/Map;)Z", "getFirstAvailableChannel", "(Ljava/util/Map;JLjava/util/Map;)Lcom/discord/api/channel/Channel;", "Lrx/Observable;", "observeInitializedForAuthedUser", "()Lrx/Observable;", "observeId", "getId", "()J", "getSelectedChannel", "()Lcom/discord/api/channel/Channel;", "observeSelectedChannel", "observeResolvedSelectedChannel", "observePreviousId", "init", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "channelId", "peekParent", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "analyticsLocation", "trySelectChannel", "(JJLjava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "Lcom/discord/primitives/MessageId;", "parentMessageId", "", "threadStartLocation", "openCreateThread", "(JJLjava/lang/Long;Ljava/lang/String;)V", "dismissCreateThread", "handleGuildSelected", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "handleGuildRemove", "snapshotData", "handleStoreInitTimeout", "handleChannelOrThreadDelete", "(Lcom/discord/api/channel/Channel;)V", "handleChannelOrThreadCreateOrUpdate", "Lcom/discord/stores/StoreGuildSelected;", "storeGuildSelected", "Lcom/discord/stores/StoreGuildSelected;", "", "userChannelSelections", "Ljava/util/Map;", "Lcom/discord/widgets/user/search/ChannelFrecencyTracker;", "frecency", "Lcom/discord/widgets/user/search/ChannelFrecencyTracker;", "getFrecency", "()Lcom/discord/widgets/user/search/ChannelFrecencyTracker;", "selectedChannel", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "handledReadyPayload", "Z", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "previouslySelectedChannel", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/utilities/persister/Persister;", "selectedChannelIdsCache", "Lcom/discord/utilities/persister/Persister;", "Lrx/Subscription;", "validateSelectedChannelSubscription", "Lrx/Subscription;", "initializedForAuthedUser", "isStoreInitTimedOut", "frecencyCache", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuildSelected;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "ResolvedSelectedChannel", "UserChannelSelection", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreChannelsSelected extends StoreV2 {
    private static final String CACHE_KEY_SELECTED_CHANNEL_IDS = "CACHE_KEY_SELECTED_CHANNEL_IDS";
    public static final long ID_THREAD_DRAFT = -3;
    public static final long ID_UNAVAILABLE = -1;
    public static final long ID_UNINITIALIZED = -2;
    public static final long ID_UNSELECTED = 0;
    private final Dispatcher dispatcher;
    private final ChannelFrecencyTracker frecency;
    private final Persister<ChannelFrecencyTracker> frecencyCache;
    private boolean handledReadyPayload;
    private boolean initializedForAuthedUser;
    private boolean isStoreInitTimedOut;
    private final ObservationDeck observationDeck;
    private ResolvedSelectedChannel previouslySelectedChannel;
    private ResolvedSelectedChannel selectedChannel;
    private final Persister<Map<Long, Long>> selectedChannelIdsCache;
    private final StoreChannels storeChannels;
    private final StoreGuildSelected storeGuildSelected;
    private final StorePermissions storePermissions;
    private final StoreStream stream;
    private final Map<Long, UserChannelSelection> userChannelSelections;
    private Subscription validateSelectedChannelSubscription;
    private static final StoreChannelsSelected4 InitializedUpdateSource = new StoreChannelsSelected4();

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0015\u0010\n\u001a\u0004\u0018\u00010\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0015\u0010\f\u001a\u0004\u0018\u00010\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0082\u0001\u0005\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "", "", "Lcom/discord/primitives/ChannelId;", "getId", "()J", ModelAuditLogEntry.CHANGE_KEY_ID, "Lcom/discord/api/channel/Channel;", "getChannelOrParent", "()Lcom/discord/api/channel/Channel;", "channelOrParent", "getMaybeChannel", "maybeChannel", "<init>", "()V", "Channel", "ThreadDraft", "Unavailable", "Uninitialized", "Unselected", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Channel;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Unselected;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Unavailable;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ResolvedSelectedChannel {

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R!\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Channel;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "component3", "()Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "channel", "peekParent", "analyticsLocation", "copy", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Channel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "getAnalyticsLocation", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/stores/ChannelAnalyticsViewType;", "analyticsViewType", "Lcom/discord/stores/ChannelAnalyticsViewType;", "getAnalyticsViewType", "()Lcom/discord/stores/ChannelAnalyticsViewType;", "Ljava/lang/Long;", "getPeekParent", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Channel extends ResolvedSelectedChannel {
            private final StoreChannelsSelected3 analyticsLocation;
            private final StoreChannelsSelected2 analyticsViewType;
            private final com.discord.api.channel.Channel channel;
            private final Long peekParent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Channel(com.discord.api.channel.Channel channel, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.peekParent = l;
                this.analyticsLocation = storeChannelsSelected3;
                this.analyticsViewType = l != null ? StoreChannelsSelected2.PEEK_VIEW : StoreChannelsSelected2.FULL_VIEW;
            }

            public static /* synthetic */ Channel copy$default(Channel channel, com.discord.api.channel.Channel channel2, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel2 = channel.channel;
                }
                if ((i & 2) != 0) {
                    l = channel.peekParent;
                }
                if ((i & 4) != 0) {
                    storeChannelsSelected3 = channel.analyticsLocation;
                }
                return channel.copy(channel2, l, storeChannelsSelected3);
            }

            /* renamed from: component1, reason: from getter */
            public final com.discord.api.channel.Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getPeekParent() {
                return this.peekParent;
            }

            /* renamed from: component3, reason: from getter */
            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final Channel copy(com.discord.api.channel.Channel channel, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new Channel(channel, peekParent, analyticsLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Channel)) {
                    return false;
                }
                Channel channel = (Channel) other;
                return Intrinsics3.areEqual(this.channel, channel.channel) && Intrinsics3.areEqual(this.peekParent, channel.peekParent) && Intrinsics3.areEqual(this.analyticsLocation, channel.analyticsLocation);
            }

            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final StoreChannelsSelected2 getAnalyticsViewType() {
                return this.analyticsViewType;
            }

            public final com.discord.api.channel.Channel getChannel() {
                return this.channel;
            }

            public final Long getPeekParent() {
                return this.peekParent;
            }

            public int hashCode() {
                com.discord.api.channel.Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Long l = this.peekParent;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                StoreChannelsSelected3 storeChannelsSelected3 = this.analyticsLocation;
                return iHashCode2 + (storeChannelsSelected3 != null ? storeChannelsSelected3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Channel(channel=");
                sbU.append(this.channel);
                sbU.append(", peekParent=");
                sbU.append(this.peekParent);
                sbU.append(", analyticsLocation=");
                sbU.append(this.analyticsLocation);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR!\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "", "hasStarterMessage", "()Z", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/primitives/MessageId;", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/String;", "parentChannel", "starterMessageId", "threadStartLocation", "copy", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Ljava/lang/String;)Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getStarterMessageId", "Ljava/lang/String;", "getThreadStartLocation", "Lcom/discord/api/channel/Channel;", "getParentChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ThreadDraft extends ResolvedSelectedChannel {
            private final com.discord.api.channel.Channel parentChannel;
            private final Long starterMessageId;
            private final String threadStartLocation;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThreadDraft(com.discord.api.channel.Channel channel, Long l, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "parentChannel");
                this.parentChannel = channel;
                this.starterMessageId = l;
                this.threadStartLocation = str;
            }

            public static /* synthetic */ ThreadDraft copy$default(ThreadDraft threadDraft, com.discord.api.channel.Channel channel, Long l, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = threadDraft.parentChannel;
                }
                if ((i & 2) != 0) {
                    l = threadDraft.starterMessageId;
                }
                if ((i & 4) != 0) {
                    str = threadDraft.threadStartLocation;
                }
                return threadDraft.copy(channel, l, str);
            }

            /* renamed from: component1, reason: from getter */
            public final com.discord.api.channel.Channel getParentChannel() {
                return this.parentChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getThreadStartLocation() {
                return this.threadStartLocation;
            }

            public final ThreadDraft copy(com.discord.api.channel.Channel parentChannel, Long starterMessageId, String threadStartLocation) {
                Intrinsics3.checkNotNullParameter(parentChannel, "parentChannel");
                return new ThreadDraft(parentChannel, starterMessageId, threadStartLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ThreadDraft)) {
                    return false;
                }
                ThreadDraft threadDraft = (ThreadDraft) other;
                return Intrinsics3.areEqual(this.parentChannel, threadDraft.parentChannel) && Intrinsics3.areEqual(this.starterMessageId, threadDraft.starterMessageId) && Intrinsics3.areEqual(this.threadStartLocation, threadDraft.threadStartLocation);
            }

            public final com.discord.api.channel.Channel getParentChannel() {
                return this.parentChannel;
            }

            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            public final String getThreadStartLocation() {
                return this.threadStartLocation;
            }

            public final boolean hasStarterMessage() {
                return this.starterMessageId != null;
            }

            public int hashCode() {
                com.discord.api.channel.Channel channel = this.parentChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Long l = this.starterMessageId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                String str = this.threadStartLocation;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ThreadDraft(parentChannel=");
                sbU.append(this.parentChannel);
                sbU.append(", starterMessageId=");
                sbU.append(this.starterMessageId);
                sbU.append(", threadStartLocation=");
                return outline.J(sbU, this.threadStartLocation, ")");
            }
        }

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Unavailable;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unavailable extends ResolvedSelectedChannel {
            public static final Unavailable INSTANCE = new Unavailable();

            private Unavailable() {
                super(null);
            }
        }

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ResolvedSelectedChannel {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel$Unselected;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unselected extends ResolvedSelectedChannel {
            public static final Unselected INSTANCE = new Unselected();

            private Unselected() {
                super(null);
            }
        }

        private ResolvedSelectedChannel() {
        }

        public final com.discord.api.channel.Channel getChannelOrParent() {
            if (this instanceof Channel) {
                return ((Channel) this).getChannel();
            }
            if (this instanceof ThreadDraft) {
                return ((ThreadDraft) this).getParentChannel();
            }
            return null;
        }

        public final long getId() {
            if (this instanceof Channel) {
                return ((Channel) this).getChannel().getId();
            }
            if (this instanceof ThreadDraft) {
                return -3L;
            }
            if (Intrinsics3.areEqual(this, Unselected.INSTANCE)) {
                return 0L;
            }
            if (Intrinsics3.areEqual(this, Unavailable.INSTANCE)) {
                return -1L;
            }
            if (Intrinsics3.areEqual(this, Uninitialized.INSTANCE)) {
                return -2L;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final com.discord.api.channel.Channel getMaybeChannel() {
            Channel channel = (Channel) (!(this instanceof Channel) ? null : this);
            if (channel != null) {
                return channel.getChannel();
            }
            return null;
        }

        public /* synthetic */ ResolvedSelectedChannel(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00060\u0007j\u0002`\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "resolveWithChannel", "(Lcom/discord/api/channel/Channel;)Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "", "Lcom/discord/primitives/ChannelId;", "getId", "()J", ModelAuditLogEntry.CHANGE_KEY_ID, "<init>", "()V", "SelectedChannel", "ThreadDraft", "Unselected", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$Unselected;", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$SelectedChannel;", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$ThreadDraft;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class UserChannelSelection {

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ<\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R!\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$SelectedChannel;", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "component2", "()Ljava/lang/Long;", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "component3", "()Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "channelId", "peekParent", "analyticsLocation", "copy", "(JLjava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$SelectedChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Ljava/lang/Long;", "getPeekParent", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "getAnalyticsLocation", "<init>", "(JLjava/lang/Long;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SelectedChannel extends UserChannelSelection {
            private final StoreChannelsSelected3 analyticsLocation;
            private final long channelId;
            private final Long peekParent;

            public /* synthetic */ SelectedChannel(long j, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : storeChannelsSelected3);
            }

            public static /* synthetic */ SelectedChannel copy$default(SelectedChannel selectedChannel, long j, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = selectedChannel.channelId;
                }
                if ((i & 2) != 0) {
                    l = selectedChannel.peekParent;
                }
                if ((i & 4) != 0) {
                    storeChannelsSelected3 = selectedChannel.analyticsLocation;
                }
                return selectedChannel.copy(j, l, storeChannelsSelected3);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getPeekParent() {
                return this.peekParent;
            }

            /* renamed from: component3, reason: from getter */
            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final SelectedChannel copy(long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
                return new SelectedChannel(channelId, peekParent, analyticsLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectedChannel)) {
                    return false;
                }
                SelectedChannel selectedChannel = (SelectedChannel) other;
                return this.channelId == selectedChannel.channelId && Intrinsics3.areEqual(this.peekParent, selectedChannel.peekParent) && Intrinsics3.areEqual(this.analyticsLocation, selectedChannel.analyticsLocation);
            }

            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getPeekParent() {
                return this.peekParent;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                Long l = this.peekParent;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                StoreChannelsSelected3 storeChannelsSelected3 = this.analyticsLocation;
                return iHashCode + (storeChannelsSelected3 != null ? storeChannelsSelected3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SelectedChannel(channelId=");
                sbU.append(this.channelId);
                sbU.append(", peekParent=");
                sbU.append(this.peekParent);
                sbU.append(", analyticsLocation=");
                sbU.append(this.analyticsLocation);
                sbU.append(")");
                return sbU.toString();
            }

            public SelectedChannel(long j, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
                super(null);
                this.channelId = j;
                this.peekParent = l;
                this.analyticsLocation = storeChannelsSelected3;
            }
        }

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R!\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$ThreadDraft;", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/String;", "parentChannelId", "starterMessageId", "locationThreadStart", "copy", "(JLjava/lang/Long;Ljava/lang/String;)Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$ThreadDraft;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getParentChannelId", "Ljava/lang/Long;", "getStarterMessageId", "Ljava/lang/String;", "getLocationThreadStart", "<init>", "(JLjava/lang/Long;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ThreadDraft extends UserChannelSelection {
            private final String locationThreadStart;
            private final long parentChannelId;
            private final Long starterMessageId;

            public ThreadDraft(long j, Long l, String str) {
                super(null);
                this.parentChannelId = j;
                this.starterMessageId = l;
                this.locationThreadStart = str;
            }

            public static /* synthetic */ ThreadDraft copy$default(ThreadDraft threadDraft, long j, Long l, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = threadDraft.parentChannelId;
                }
                if ((i & 2) != 0) {
                    l = threadDraft.starterMessageId;
                }
                if ((i & 4) != 0) {
                    str = threadDraft.locationThreadStart;
                }
                return threadDraft.copy(j, l, str);
            }

            /* renamed from: component1, reason: from getter */
            public final long getParentChannelId() {
                return this.parentChannelId;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getLocationThreadStart() {
                return this.locationThreadStart;
            }

            public final ThreadDraft copy(long parentChannelId, Long starterMessageId, String locationThreadStart) {
                return new ThreadDraft(parentChannelId, starterMessageId, locationThreadStart);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ThreadDraft)) {
                    return false;
                }
                ThreadDraft threadDraft = (ThreadDraft) other;
                return this.parentChannelId == threadDraft.parentChannelId && Intrinsics3.areEqual(this.starterMessageId, threadDraft.starterMessageId) && Intrinsics3.areEqual(this.locationThreadStart, threadDraft.locationThreadStart);
            }

            public final String getLocationThreadStart() {
                return this.locationThreadStart;
            }

            public final long getParentChannelId() {
                return this.parentChannelId;
            }

            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            public int hashCode() {
                int iA = b.a(this.parentChannelId) * 31;
                Long l = this.starterMessageId;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                String str = this.locationThreadStart;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ThreadDraft(parentChannelId=");
                sbU.append(this.parentChannelId);
                sbU.append(", starterMessageId=");
                sbU.append(this.starterMessageId);
                sbU.append(", locationThreadStart=");
                return outline.J(sbU, this.locationThreadStart, ")");
            }
        }

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection$Unselected;", "Lcom/discord/stores/StoreChannelsSelected$UserChannelSelection;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unselected extends UserChannelSelection {
            public static final Unselected INSTANCE = new Unselected();

            private Unselected() {
                super(null);
            }
        }

        private UserChannelSelection() {
        }

        public final long getId() {
            if (this instanceof SelectedChannel) {
                return ((SelectedChannel) this).getChannelId();
            }
            if (this instanceof ThreadDraft) {
                return ((ThreadDraft) this).getParentChannelId();
            }
            if (Intrinsics3.areEqual(this, Unselected.INSTANCE)) {
                return 0L;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final ResolvedSelectedChannel resolveWithChannel(Channel channel) {
            ResolvedSelectedChannel threadDraft;
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (this instanceof Unselected) {
                return ResolvedSelectedChannel.Unselected.INSTANCE;
            }
            if (this instanceof SelectedChannel) {
                SelectedChannel selectedChannel = (SelectedChannel) this;
                threadDraft = new ResolvedSelectedChannel.Channel(channel, selectedChannel.getPeekParent(), selectedChannel.getAnalyticsLocation());
            } else {
                if (!(this instanceof ThreadDraft)) {
                    throw new NoWhenBranchMatchedException();
                }
                ThreadDraft threadDraft2 = (ThreadDraft) this;
                threadDraft = new ResolvedSelectedChannel.ThreadDraft(channel, threadDraft2.getStarterMessageId(), threadDraft2.getLocationThreadStart());
            }
            return threadDraft;
        }

        public /* synthetic */ UserChannelSelection(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$observeId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreChannelsSelected.this.getId();
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isStoreChannelsInitialized", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$observeInitializedForAuthedUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Boolean, Observable<? extends Boolean>> {

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreChannelsSelected$observeInitializedForAuthedUser$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01061 extends Lambda implements Function0<Boolean> {
            public C01061() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return StoreChannelsSelected.access$getInitializedForAuthedUser$p(StoreChannelsSelected.this);
            }
        }

        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Boolean> call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isStoreChannelsInitialized");
            return bool.booleanValue() ? ObservationDeck.connectRx$default(StoreChannelsSelected.access$getObservationDeck$p(StoreChannelsSelected.this), new ObservationDeck.UpdateSource[]{StoreChannelsSelected.access$getInitializedUpdateSource$cp()}, false, null, null, new C01061(), 14, null) : new ScalarSynchronousObservable(Boolean.FALSE);
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$observePreviousId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreChannelsSelected.access$getPreviouslySelectedChannel$p(StoreChannelsSelected.this).getId();
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "invoke", "()Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$observeResolvedSelectedChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ResolvedSelectedChannel> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ResolvedSelectedChannel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResolvedSelectedChannel invoke() {
            return StoreChannelsSelected.access$getSelectedChannel$p(StoreChannelsSelected.this);
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/channel/Channel;", "invoke", "()Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$observeSelectedChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            return StoreChannelsSelected.this.getSelectedChannel();
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "invoke", "()Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ResolvedSelectedChannel> {
        public final /* synthetic */ Map $allChannels;
        public final /* synthetic */ UserChannelSelection $channelSelection;
        public final /* synthetic */ boolean $isChannelStoreInitializedForAuthedUser;
        public final /* synthetic */ Map $permissionsForChannelsInGuild;
        public final /* synthetic */ long $selectedGuildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UserChannelSelection userChannelSelection, Map map, long j, Map map2, boolean z2) {
            super(0);
            this.$channelSelection = userChannelSelection;
            this.$allChannels = map;
            this.$selectedGuildId = j;
            this.$permissionsForChannelsInGuild = map2;
            this.$isChannelStoreInitializedForAuthedUser = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ResolvedSelectedChannel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResolvedSelectedChannel invoke() {
            UserChannelSelection userChannelSelection = this.$channelSelection;
            return StoreChannelsSelected.access$resolveSelectedChannel(StoreChannelsSelected.this, this.$channelSelection, userChannelSelection != null ? StoreChannelsSelected.access$getStoreChannels$p(StoreChannelsSelected.this).getChannel(userChannelSelection.getId()) : null, this.$allChannels, this.$selectedGuildId, this.$permissionsForChannelsInGuild, this.$isChannelStoreInitializedForAuthedUser);
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreChannelsSelected.access$setValidateSelectedChannelSubscription$p(StoreChannelsSelected.this, subscription);
        }
    }

    /* compiled from: StoreChannelsSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "selected", "", "invoke", "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ResolvedSelectedChannel, Unit> {

        /* compiled from: StoreChannelsSelected.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ResolvedSelectedChannel $selected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ResolvedSelectedChannel resolvedSelectedChannel) {
                super(0);
                this.$selected = resolvedSelectedChannel;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChannelsSelected storeChannelsSelected = StoreChannelsSelected.this;
                ResolvedSelectedChannel resolvedSelectedChannel = this.$selected;
                Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "selected");
                StoreChannelsSelected.access$onSelectedChannelResolved(storeChannelsSelected, resolvedSelectedChannel);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ResolvedSelectedChannel resolvedSelectedChannel) {
            invoke2(resolvedSelectedChannel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ResolvedSelectedChannel resolvedSelectedChannel) {
            StoreChannelsSelected.access$getDispatcher$p(StoreChannelsSelected.this).schedule(new AnonymousClass1(resolvedSelectedChannel));
        }
    }

    public StoreChannelsSelected(StoreStream storeStream, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildSelected storeGuildSelected, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.storeGuildSelected = storeGuildSelected;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.userChannelSelections = new HashMap();
        this.selectedChannelIdsCache = new Persister<>(CACHE_KEY_SELECTED_CHANNEL_IDS, new HashMap());
        ResolvedSelectedChannel.Uninitialized uninitialized = ResolvedSelectedChannel.Uninitialized.INSTANCE;
        this.selectedChannel = uninitialized;
        this.previouslySelectedChannel = uninitialized;
        Persister<ChannelFrecencyTracker> persister = new Persister<>("CHANNEL_HISTORY_V3", new ChannelFrecencyTracker());
        this.frecencyCache = persister;
        this.frecency = persister.get();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.dispatcher;
    }

    public static final /* synthetic */ boolean access$getInitializedForAuthedUser$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.initializedForAuthedUser;
    }

    public static final /* synthetic */ StoreChannelsSelected4 access$getInitializedUpdateSource$cp() {
        return InitializedUpdateSource;
    }

    public static final /* synthetic */ ObservationDeck access$getObservationDeck$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.observationDeck;
    }

    public static final /* synthetic */ ResolvedSelectedChannel access$getPreviouslySelectedChannel$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.previouslySelectedChannel;
    }

    public static final /* synthetic */ ResolvedSelectedChannel access$getSelectedChannel$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.selectedChannel;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.storeChannels;
    }

    public static final /* synthetic */ Subscription access$getValidateSelectedChannelSubscription$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.validateSelectedChannelSubscription;
    }

    public static final /* synthetic */ void access$onSelectedChannelResolved(StoreChannelsSelected storeChannelsSelected, ResolvedSelectedChannel resolvedSelectedChannel) {
        storeChannelsSelected.onSelectedChannelResolved(resolvedSelectedChannel);
    }

    public static final /* synthetic */ ResolvedSelectedChannel access$resolveSelectedChannel(StoreChannelsSelected storeChannelsSelected, UserChannelSelection userChannelSelection, Channel channel, Map map, long j, Map map2, boolean z2) {
        return storeChannelsSelected.resolveSelectedChannel(userChannelSelection, channel, map, j, map2, z2);
    }

    public static final /* synthetic */ void access$setInitializedForAuthedUser$p(StoreChannelsSelected storeChannelsSelected, boolean z2) {
        storeChannelsSelected.initializedForAuthedUser = z2;
    }

    public static final /* synthetic */ void access$setPreviouslySelectedChannel$p(StoreChannelsSelected storeChannelsSelected, ResolvedSelectedChannel resolvedSelectedChannel) {
        storeChannelsSelected.previouslySelectedChannel = resolvedSelectedChannel;
    }

    public static final /* synthetic */ void access$setSelectedChannel$p(StoreChannelsSelected storeChannelsSelected, ResolvedSelectedChannel resolvedSelectedChannel) {
        storeChannelsSelected.selectedChannel = resolvedSelectedChannel;
    }

    public static final /* synthetic */ void access$setValidateSelectedChannelSubscription$p(StoreChannelsSelected storeChannelsSelected, Subscription subscription) {
        storeChannelsSelected.validateSelectedChannelSubscription = subscription;
    }

    private final Channel getFirstAvailableChannel(Map<Long, Channel> channels, long guildId, Map<Long, Long> permissions) {
        Collection<Channel> collectionValues = channels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Channel channel = (Channel) obj;
            if (channel.getGuildId() == guildId && ChannelUtils.v(channel) && PermissionUtils.hasAccess(channel, permissions)) {
                arrayList.add(obj);
            }
        }
        return (Channel) _Collections.firstOrNull(_Collections.sortedWith(arrayList, ChannelUtils.h(Channel.INSTANCE)));
    }

    private final boolean isValidResolution(Channel channel, long guildId, Map<Long, Long> permissions) {
        return channel.getGuildId() == guildId && ChannelUtils.G(channel) && PermissionUtils.hasAccess(channel, permissions);
    }

    @Store3
    private final void loadFromCache() {
        Map<Long, UserChannelSelection> map = this.userChannelSelections;
        Map<Long, Long> map2 = this.selectedChannelIdsCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new UserChannelSelection.SelectedChannel(((Number) entry.getValue()).longValue(), null, null, 6, null));
        }
        map.putAll(linkedHashMap);
    }

    @Store3
    private final void onSelectedChannelResolved(ResolvedSelectedChannel resolvedSelectedChannel) {
        if (this.selectedChannel.getId() != resolvedSelectedChannel.getId()) {
            this.previouslySelectedChannel = this.selectedChannel;
        }
        this.selectedChannel = resolvedSelectedChannel;
        boolean z2 = resolvedSelectedChannel instanceof ResolvedSelectedChannel.Channel;
        if (z2) {
            ResolvedSelectedChannel.Channel channel = (ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
            this.userChannelSelections.put(Long.valueOf(channel.getChannel().getGuildId()), new UserChannelSelection.SelectedChannel(channel.getChannel().getId(), channel.getPeekParent(), null, 4, null));
            FrecencyTracker.track$default(this.frecency, Long.valueOf(channel.getChannel().getId()), 0L, 2, null);
        }
        if (z2) {
            ResolvedSelectedChannel.Channel channel2 = (ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
            if (ChannelUtils.J(channel2.getChannel())) {
                this.stream.getAnalytics().trackTextInVoiceOpened(resolvedSelectedChannel.getId(), channel2.getAnalyticsLocation());
            }
            this.stream.getAnalytics().trackChannelOpened(resolvedSelectedChannel.getId(), channel2.getAnalyticsViewType(), channel2.getAnalyticsLocation());
        }
        updateInitializationState();
        markChanged();
    }

    private final ResolvedSelectedChannel resolveSelectedChannel(UserChannelSelection userChannelSelection, Channel resolvedChannel, Map<Long, Channel> channels, long guildId, Map<Long, Long> permissions, boolean storeChannelsInitializedForAuthedUser) {
        ResolvedSelectedChannel resolvedSelectedChannelResolveWithChannel;
        if (!storeChannelsInitializedForAuthedUser) {
            return ResolvedSelectedChannel.Uninitialized.INSTANCE;
        }
        if (resolvedChannel != null && isValidResolution(resolvedChannel, guildId, permissions)) {
            return (userChannelSelection == null || (resolvedSelectedChannelResolveWithChannel = userChannelSelection.resolveWithChannel(resolvedChannel)) == null) ? ResolvedSelectedChannel.Unselected.INSTANCE : resolvedSelectedChannelResolveWithChannel;
        }
        if (guildId == 0) {
            return ResolvedSelectedChannel.Unselected.INSTANCE;
        }
        Channel firstAvailableChannel = getFirstAvailableChannel(channels, guildId, permissions);
        return firstAvailableChannel == null ? ResolvedSelectedChannel.Unavailable.INSTANCE : new ResolvedSelectedChannel.Channel(firstAvailableChannel, null, null);
    }

    @Store3
    private final void updateInitializationState() {
        boolean z2 = this.stream.getAuthentication().getAuthState() != null;
        boolean z3 = this.initializedForAuthedUser;
        boolean z4 = z2 && this.storeChannels.getInitializedForAuthedUser() && ((this.userChannelSelections.isEmpty() ^ true) || this.handledReadyPayload || this.isStoreInitTimedOut) && (Intrinsics3.areEqual(this.selectedChannel, ResolvedSelectedChannel.Uninitialized.INSTANCE) ^ true);
        if (z3 || !z4) {
            return;
        }
        this.initializedForAuthedUser = true;
        markChanged(InitializedUpdateSource);
    }

    @Store3
    private final void validateSelectedChannel() {
        Subscription subscription = this.validateSelectedChannelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.storeChannels.getChannelsByIdInternal$app_productionGoogleRelease();
        boolean initializedForAuthedUser = this.storeChannels.getInitializedForAuthedUser();
        long selectedGuildIdInternal$app_productionGoogleRelease = this.storeGuildSelected.getSelectedGuildIdInternal$app_productionGoogleRelease();
        Observable observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuildSelected, this.storeChannels, this.storePermissions}, false, null, null, new AnonymousClass1(this.userChannelSelections.get(Long.valueOf(selectedGuildIdInternal$app_productionGoogleRelease)), channelsByIdInternal$app_productionGoogleRelease, selectedGuildIdInternal$app_productionGoogleRelease, this.storePermissions.getPermissionsByChannelInternal$app_productionGoogleRelease(selectedGuildIdInternal$app_productionGoogleRelease), initializedForAuthedUser), 14, null)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, StoreChannelsSelected.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 58, (Object) null);
    }

    @Store3
    public final void dismissCreateThread() {
        ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        if (!(resolvedSelectedChannel instanceof ResolvedSelectedChannel.ThreadDraft)) {
            resolvedSelectedChannel = null;
        }
        ResolvedSelectedChannel.ThreadDraft threadDraft = (ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
        if (threadDraft != null) {
            Channel parentChannel = threadDraft.getParentChannel();
            this.userChannelSelections.put(Long.valueOf(parentChannel.getGuildId()), new UserChannelSelection.SelectedChannel(parentChannel.getId(), null, null, 6, null));
            validateSelectedChannel();
        }
    }

    public final ChannelFrecencyTracker getFrecency() {
        return this.frecency;
    }

    public final long getId() {
        return this.selectedChannel.getId();
    }

    public final Channel getSelectedChannel() {
        ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        if (!(resolvedSelectedChannel instanceof ResolvedSelectedChannel.Channel)) {
            resolvedSelectedChannel = null;
        }
        ResolvedSelectedChannel.Channel channel = (ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
        if (channel != null) {
            return channel.getChannel();
        }
        return null;
    }

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (channel.getId() == this.selectedChannel.getId()) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void handleChannelOrThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (channel.getId() == this.selectedChannel.getId()) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        HashSet hashSetHashSetOf = Sets5.hashSetOf(0L);
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            hashSetHashSetOf.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        Map<Long, UserChannelSelection> map = this.userChannelSelections;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, UserChannelSelection> entry : map.entrySet()) {
            if (hashSetHashSetOf.contains(Long.valueOf(entry.getKey().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<? extends Long, ? extends UserChannelSelection> mutableMap = Maps6.toMutableMap(linkedHashMap);
        if (!mutableMap.containsKey(0L)) {
            mutableMap.put(0L, UserChannelSelection.Unselected.INSTANCE);
        }
        this.userChannelSelections.clear();
        this.userChannelSelections.putAll(mutableMap);
        this.handledReadyPayload = true;
        validateSelectedChannel();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.storeGuildSelected.getSelectedGuildIdInternal$app_productionGoogleRelease() == guild.getId()) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Channel maybeChannel = this.selectedChannel.getMaybeChannel();
        if (maybeChannel == null || maybeChannel.getGuildId() != guild.getId()) {
            return;
        }
        validateSelectedChannel();
    }

    @Store3
    public final void handleGuildSelected() {
        validateSelectedChannel();
    }

    @Store3
    public final void handleStoreInitTimeout() {
        this.isStoreInitTimedOut = true;
        updateInitializationState();
        if (Intrinsics3.areEqual(this.selectedChannel, ResolvedSelectedChannel.Uninitialized.INSTANCE)) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void init() {
        loadFromCache();
        validateSelectedChannel();
    }

    public final Observable<Long> observeId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeInitializedForAuthedUser() {
        Observable observableY = this.storeChannels.observeInitializedForAuthedUser().Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels.observeIni…            }\n          }");
        return observableY;
    }

    public final Observable<Long> observePreviousId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<ResolvedSelectedChannel> observeResolvedSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Channel> observeSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Store3
    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String threadStartLocation) {
        this.userChannelSelections.put(Long.valueOf(guildId), new UserChannelSelection.ThreadDraft(channelId, parentMessageId, threadStartLocation));
        validateSelectedChannel();
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
        Map<Long, UserChannelSelection> map = this.userChannelSelections;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), Long.valueOf(((UserChannelSelection) entry.getValue()).getId()));
        }
        this.selectedChannelIdsCache.set(linkedHashMap, true);
    }

    @Store3
    public final void trySelectChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        UserChannelSelection userChannelSelection = this.userChannelSelections.get(Long.valueOf(guildId));
        if (!(userChannelSelection instanceof UserChannelSelection.SelectedChannel)) {
            userChannelSelection = null;
        }
        UserChannelSelection.SelectedChannel selectedChannel = (UserChannelSelection.SelectedChannel) userChannelSelection;
        if (selectedChannel == null || selectedChannel.getChannelId() != channelId) {
            this.userChannelSelections.put(Long.valueOf(guildId), new UserChannelSelection.SelectedChannel(channelId, peekParent, analyticsLocation));
            validateSelectedChannel();
        }
    }
}
