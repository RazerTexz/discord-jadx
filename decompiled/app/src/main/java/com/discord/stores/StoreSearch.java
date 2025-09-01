package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.history.MGPreferenceSearchHistoryCache;
import com.discord.utilities.search.history.SearchHistoryCache;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.widgets.chat.AutocompleteUtils;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002bcBG\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bY\u0010ZBA\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010`\u001a\u00020_¢\u0006\u0004\bY\u0010aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00062\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00062\n\u0010\u001f\u001a\u00060\u0019j\u0002`\u001e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001dJ\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\u00062\n\u0010(\u001a\u00060\u0019j\u0002`'¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0+0\u0016¢\u0006\u0004\b.\u0010\u0018J\r\u0010/\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\"J%\u00103\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0,H\u0000¢\u0006\u0004\b1\u00102R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R2\u0010:\u001a\u001e\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00020\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0019\u0010=\u001a\u00020<8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010GR2\u0010H\u001a\u001e\u0012\f\u0012\n 9*\u0004\u0018\u00010\u000f0\u000f\u0012\f\u0012\n 9*\u0004\u0018\u00010\u000f0\u000f088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010;R\u0019\u0010J\u001a\u00020I8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010O\u001a\u00020N8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006d"}, d2 = {"Lcom/discord/stores/StoreSearch;", "", "Lcom/discord/stores/StoreSearch$SearchTarget;", "searchTarget", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "", "init", "(Lcom/discord/stores/StoreSearch$SearchTarget;Lcom/discord/utilities/search/strings/SearchStringProvider;)V", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "handleSubscription", "(Lrx/Subscription;)V", "updateTarget", "(Lcom/discord/stores/StoreSearch$SearchTarget;)V", "Lcom/discord/stores/StoreSearch$DisplayState;", "displayState", "onStateChanged", "(Lcom/discord/stores/StoreSearch$DisplayState;)V", "", "includeNsfw", "(Lcom/discord/stores/StoreSearch$SearchTarget;)Z", "Lrx/Observable;", "getDisplayState", "()Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "initForChannel", "(JLcom/discord/utilities/search/strings/SearchStringProvider;)V", "Lcom/discord/primitives/GuildId;", "guildId", "initForGuild", "clear", "()V", "", "queryString", "loadInitial", "(Ljava/lang/String;Lcom/discord/utilities/search/strings/SearchStringProvider;)V", "Lcom/discord/primitives/MessageId;", "oldestMessageId", "loadMore", "(J)V", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "getHistory", "clearHistory", "query", "persistQuery$app_productionGoogleRelease", "(Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/util/List;)V", "persistQuery", "Lcom/discord/stores/StoreSearch$SearchTarget;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "searchTargetSubject", "Lrx/subjects/SerializedSubject;", "Lcom/discord/stores/StoreSearchInput;", "storeSearchInput", "Lcom/discord/stores/StoreSearchInput;", "getStoreSearchInput", "()Lcom/discord/stores/StoreSearchInput;", "Lcom/discord/utilities/search/history/SearchHistoryCache;", "historyCache", "Lcom/discord/utilities/search/history/SearchHistoryCache;", "Lcom/discord/stores/StoreGuildsNsfw;", "storeGuildsNsfw", "Lcom/discord/stores/StoreGuildsNsfw;", "Lrx/Subscription;", "displayStateSubject", "Lcom/discord/stores/StoreSearchData;", "storeSearchData", "Lcom/discord/stores/StoreSearchData;", "getStoreSearchData", "()Lcom/discord/stores/StoreSearchData;", "Lcom/discord/stores/StoreSearchQuery;", "storeSearchQuery", "Lcom/discord/stores/StoreSearchQuery;", "getStoreSearchQuery", "()Lcom/discord/stores/StoreSearchQuery;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "<init>", "(Lcom/discord/stores/StoreSearchData;Lcom/discord/stores/StoreSearchInput;Lcom/discord/stores/StoreSearchQuery;Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreGuildsNsfw;Lcom/discord/stores/StoreUser;Lcom/discord/utilities/search/history/SearchHistoryCache;)V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreGuildsNsfw;Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;)V", "DisplayState", "SearchTarget", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreSearch {
    private final Dispatcher dispatcher;
    private final SerializedSubject<DisplayState, DisplayState> displayStateSubject;
    private final SearchHistoryCache historyCache;
    private SearchTarget searchTarget;
    private final SerializedSubject<SearchTarget, SearchTarget> searchTargetSubject;
    private final StoreGuildsNsfw storeGuildsNsfw;
    private final StoreSearchData storeSearchData;
    private final StoreSearchInput storeSearchInput;
    private final StoreSearchQuery storeSearchQuery;
    private final StoreUser storeUser;
    private final StoreStream stream;
    private Subscription subscription;

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreSearch$DisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "SUGGESTIONS", "RESULTS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum DisplayState {
        SUGGESTIONS,
        RESULTS
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreSearch$SearchTarget;", "", "Lcom/discord/stores/StoreSearch$SearchTarget$Type;", "component1", "()Lcom/discord/stores/StoreSearch$SearchTarget$Type;", "", "component2", "()J", "type", ModelAuditLogEntry.CHANGE_KEY_ID, "copy", "(Lcom/discord/stores/StoreSearch$SearchTarget$Type;J)Lcom/discord/stores/StoreSearch$SearchTarget;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "Lcom/discord/stores/StoreSearch$SearchTarget$Type;", "getType", "<init>", "(Lcom/discord/stores/StoreSearch$SearchTarget$Type;J)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SearchTarget {
        private final long id;
        private final Type type;

        /* compiled from: StoreSearch.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreSearch$SearchTarget$Type;", "", "<init>", "(Ljava/lang/String;I)V", "GUILD", AutocompleteUtils.CHANNEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            GUILD,
            CHANNEL
        }

        public SearchTarget(Type type, long j) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.type = type;
            this.id = j;
        }

        public static /* synthetic */ SearchTarget copy$default(SearchTarget searchTarget, Type type, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                type = searchTarget.type;
            }
            if ((i & 2) != 0) {
                j = searchTarget.id;
            }
            return searchTarget.copy(type, j);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        public final SearchTarget copy(Type type, long id2) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new SearchTarget(type, id2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchTarget)) {
                return false;
            }
            SearchTarget searchTarget = (SearchTarget) other;
            return Intrinsics3.areEqual(this.type, searchTarget.type) && this.id == searchTarget.id;
        }

        public final long getId() {
            return this.id;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            return b.a(this.id) + ((type != null ? type.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SearchTarget(type=");
            sbU.append(this.type);
            sbU.append(", id=");
            return outline.C(sbU, this.id, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001aZ\u0012&\b\u0001\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0001*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00040\u0004 \u0001*,\u0012&\b\u0001\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0001*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreSearch$SearchTarget;", "kotlin.jvm.PlatformType", "searchTarget", "Lrx/Observable;", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreSearch$SearchTarget;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$getHistory$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<SearchTarget, Observable<? extends Collection<? extends List<? extends QueryNode>>>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends List<? extends QueryNode>>> call(SearchTarget searchTarget) {
            return call2(searchTarget);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Collection<List<QueryNode>>> call2(SearchTarget searchTarget) {
            return searchTarget != null ? StoreSearch.access$getHistoryCache$p(StoreSearch.this).getHistory(searchTarget) : new ScalarSynchronousObservable(Collections2.emptyList());
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/search/network/state/SearchState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/search/network/state/SearchState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<SearchState, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(SearchState searchState) {
            return call2(searchState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(SearchState searchState) {
            return Boolean.valueOf(searchState.getQueryFetchState() != QueryFetchState.NONE);
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/search/network/state/SearchState;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/stores/StoreSearch$DisplayState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/search/network/state/SearchState;)Lcom/discord/stores/StoreSearch$DisplayState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$init$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<SearchState, DisplayState> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ DisplayState call(SearchState searchState) {
            return call2(searchState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DisplayState call2(SearchState searchState) {
            return DisplayState.RESULTS;
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/utilities/search/query/node/QueryNode;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/stores/StoreSearch$DisplayState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/discord/stores/StoreSearch$DisplayState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$init$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<List<? extends QueryNode>, DisplayState> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ DisplayState call(List<? extends QueryNode> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DisplayState call2(List<? extends QueryNode> list) {
            return DisplayState.SUGGESTIONS;
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "p1", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$init$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public AnonymousClass4(StoreSearch storeSearch) {
            super(1, storeSearch, StoreSearch.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            StoreSearch.access$handleSubscription((StoreSearch) this.receiver, subscription);
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreSearch$DisplayState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/stores/StoreSearch$DisplayState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$init$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<DisplayState, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisplayState displayState) {
            invoke2(displayState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisplayState displayState) {
            if (displayState != DisplayState.RESULTS) {
                StoreSearch.this.getStoreSearchQuery().clear();
            }
            StoreSearch storeSearch = StoreSearch.this;
            Intrinsics3.checkNotNullExpressionValue(displayState, "it");
            StoreSearch.access$onStateChanged(storeSearch, displayState);
        }
    }

    /* compiled from: StoreSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/network/state/SearchState;", "searchState", "", "invoke", "(Lcom/discord/utilities/search/network/state/SearchState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearch$init$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<SearchState, Unit> {

        /* compiled from: StoreSearch.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSearch$init$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ SearchState $searchState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SearchState searchState) {
                super(0);
                this.$searchState = searchState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreSearch.access$getStream$p(StoreSearch.this).handleSearchFinish(this.$searchState);
            }
        }

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchState searchState) {
            invoke2(searchState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchState searchState) {
            Intrinsics3.checkNotNullParameter(searchState, "searchState");
            StoreSearch.access$getDispatcher$p(StoreSearch.this).schedule(new AnonymousClass1(searchState));
        }
    }

    public StoreSearch(StoreSearchData storeSearchData, StoreSearchInput storeSearchInput, StoreSearchQuery storeSearchQuery, StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, SearchHistoryCache searchHistoryCache) {
        Intrinsics3.checkNotNullParameter(storeSearchData, "storeSearchData");
        Intrinsics3.checkNotNullParameter(storeSearchInput, "storeSearchInput");
        Intrinsics3.checkNotNullParameter(storeSearchQuery, "storeSearchQuery");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(searchHistoryCache, "historyCache");
        this.storeSearchData = storeSearchData;
        this.storeSearchInput = storeSearchInput;
        this.storeSearchQuery = storeSearchQuery;
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.storeGuildsNsfw = storeGuildsNsfw;
        this.storeUser = storeUser;
        this.historyCache = searchHistoryCache;
        this.displayStateSubject = new SerializedSubject<>(BehaviorSubject.l0(DisplayState.SUGGESTIONS));
        this.searchTargetSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSearch storeSearch) {
        return storeSearch.dispatcher;
    }

    public static final /* synthetic */ SearchHistoryCache access$getHistoryCache$p(StoreSearch storeSearch) {
        return storeSearch.historyCache;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreSearch storeSearch) {
        return storeSearch.stream;
    }

    public static final /* synthetic */ void access$handleSubscription(StoreSearch storeSearch, Subscription subscription) {
        storeSearch.handleSubscription(subscription);
    }

    public static final /* synthetic */ void access$onStateChanged(StoreSearch storeSearch, DisplayState displayState) {
        storeSearch.onStateChanged(displayState);
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    private final boolean includeNsfw(SearchTarget searchTarget) {
        if (this.storeUser.getMeSnapshot().getNsfwAllowance() == NsfwAllowance.DISALLOWED) {
            return false;
        }
        int iOrdinal = searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            return this.storeGuildsNsfw.isGuildNsfwGateAgreed(searchTarget.getId());
        }
        if (iOrdinal == 1) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final synchronized void init(SearchTarget searchTarget, SearchStringProvider searchStringProvider) {
        if (Intrinsics3.areEqual(this.searchTarget, searchTarget)) {
            return;
        }
        updateTarget(searchTarget);
        this.storeSearchData.init(searchTarget);
        this.storeSearchInput.init(searchStringProvider);
        Observable observableI = Observable.I(this.storeSearchQuery.getState().y(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE), this.storeSearchInput.getCurrentParsedInput().G(AnonymousClass3.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .merg…splayState.SUGGESTIONS })");
        ObservableExtensionsKt.appSubscribe$default(observableI, getClass(), (Context) null, new AnonymousClass4(this), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 58, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.storeSearchQuery.getState(), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(), 62, (Object) null);
    }

    private final void onStateChanged(DisplayState displayState) {
        this.displayStateSubject.k.onNext(displayState);
    }

    private final synchronized void updateTarget(SearchTarget searchTarget) {
        this.searchTarget = searchTarget;
        this.searchTargetSubject.k.onNext(searchTarget);
    }

    public final synchronized void clear() {
        updateTarget(null);
        handleSubscription(null);
        onStateChanged(DisplayState.SUGGESTIONS);
        this.storeSearchQuery.clear();
        this.storeSearchInput.clear();
        this.storeSearchData.clear();
    }

    public final void clearHistory() {
        SearchHistoryCache searchHistoryCache = this.historyCache;
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            searchHistoryCache.clear(searchTarget);
        }
    }

    public final Observable<DisplayState> getDisplayState() {
        Observable<DisplayState> observableR = ObservableExtensionsKt.computationLatest(this.displayStateSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "displayStateSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Collection<List<QueryNode>>> getHistory() {
        Observable observableY = this.searchTargetSubject.Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "searchTargetSubject\n    …())\n          }\n        }");
        return observableY;
    }

    public final StoreSearchData getStoreSearchData() {
        return this.storeSearchData;
    }

    public final StoreSearchInput getStoreSearchInput() {
        return this.storeSearchInput;
    }

    public final StoreSearchQuery getStoreSearchQuery() {
        return this.storeSearchQuery;
    }

    public final void initForChannel(long channelId, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.CHANNEL, channelId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(null);
    }

    public final void initForGuild(long guildId, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.GUILD, guildId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(Long.valueOf(guildId));
    }

    public final void loadInitial(String queryString, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            this.storeSearchQuery.parseAndQuery(this, searchTarget, queryString, searchStringProvider, includeNsfw(searchTarget));
        }
    }

    public final void loadMore(long oldestMessageId) {
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            this.storeSearchQuery.loadMore(searchTarget, oldestMessageId);
        }
    }

    public final void persistQuery$app_productionGoogleRelease(SearchTarget searchTarget, List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(query, "query");
        this.historyCache.persistQuery(searchTarget, query);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreSearch(StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, ObservationDeck observationDeck, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        this(new StoreSearchData(observationDeck, storeChannels, storeUser, storeGuilds), new StoreSearchInput(), new StoreSearchQuery(new SearchFetcher()), storeStream, dispatcher, storeGuildsNsfw, storeUser, new MGPreferenceSearchHistoryCache());
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
    }
}
