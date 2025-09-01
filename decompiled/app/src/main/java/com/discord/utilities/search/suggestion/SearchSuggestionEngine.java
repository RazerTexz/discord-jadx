package com.discord.utilities.search.suggestion;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.Strings4;
import d0.g0.k;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* compiled from: SearchSuggestionEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b?\u00100JG\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJU\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u00172\u001a\u0010\"\u001a\u0016\u0012\b\u0012\u00060\u0018j\u0002` \u0012\b\u0012\u00060\u0018j\u0002`!0\u0017H\u0002¢\u0006\u0004\b$\u0010%J-\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u0004\u0018\u00010\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100R2\u00103\u001a\u001e\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00100\u0010018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b8\u00107R$\u00109\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/discord/utilities/search/suggestion/SearchSuggestionEngine;", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "input", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "", "recentQueries", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "getSuggestions", "(Ljava/util/List;Lcom/discord/utilities/search/validation/SearchData;Lcom/discord/utilities/search/strings/SearchStringProvider;Ljava/util/Collection;)Ljava/util/List;", "getHistorySuggestions", "(Ljava/util/Collection;)Ljava/util/Collection;", "", "rawContent", "Lcom/discord/utilities/search/query/FilterType;", "currentFilterType", "getHasSuggestions", "(Ljava/lang/CharSequence;Lcom/discord/utilities/search/query/FilterType;Lcom/discord/utilities/search/strings/SearchStringProvider;)Ljava/util/List;", "currentFilter", "", "", "Lcom/discord/models/guild/UserGuildMember;", "users", "Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;", "getUserSuggestions", "(Ljava/lang/CharSequence;Lcom/discord/utilities/search/query/FilterType;Ljava/util/Map;)Ljava/util/Collection;", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;", "getChannelSuggestions", "(Ljava/lang/CharSequence;Lcom/discord/utilities/search/query/FilterType;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "", "includeInChannels", "getFilterSuggestions", "(Ljava/lang/CharSequence;Lcom/discord/utilities/search/strings/SearchStringProvider;Z)Ljava/util/List;", "getRawContent", "(Ljava/util/List;)Ljava/lang/CharSequence;", "getCurrentFilterType", "(Ljava/util/List;)Lcom/discord/utilities/search/query/FilterType;", "", "setupMemberRequestSubscription", "()V", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "membersRequestSubject", "Lrx/subjects/SerializedSubject;", "", "MAX_ENTRY_TYPE_COUNT", "I", "MAX_USER_SORTING_THRESHOLD", "targetGuildId", "Ljava/lang/Long;", "getTargetGuildId", "()Ljava/lang/Long;", "setTargetGuildId", "(Ljava/lang/Long;)V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SearchSuggestionEngine {
    public static final SearchSuggestionEngine INSTANCE;
    private static final int MAX_ENTRY_TYPE_COUNT;
    private static final int MAX_USER_SORTING_THRESHOLD;
    private static final SerializedSubject<CharSequence, CharSequence> membersRequestSubject;
    private static Long targetGuildId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterType.FROM.ordinal()] = 1;
            iArr[FilterType.MENTIONS.ordinal()] = 2;
        }
    }

    /* compiled from: SearchSuggestionEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/CharSequence;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.suggestion.SearchSuggestionEngine$setupMemberRequestSubscription$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<CharSequence, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ String call(CharSequence charSequence) {
            return call2(charSequence);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    /* compiled from: SearchSuggestionEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.suggestion.SearchSuggestionEngine$setupMemberRequestSubscription$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<CharSequence, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, k.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence) {
            return Boolean.valueOf(invoke((String) charSequence));
        }

        public final boolean invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            return str.length() > 0;
        }
    }

    /* compiled from: SearchSuggestionEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "memberRequestStr", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.suggestion.SearchSuggestionEngine$setupMemberRequestSubscription$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
            Long targetGuildId = SearchSuggestionEngine.INSTANCE.getTargetGuildId();
            if (targetGuildId != null) {
                StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, targetGuildId.longValue(), str, null, null, 12, null);
            }
        }
    }

    static {
        SearchSuggestionEngine searchSuggestionEngine = new SearchSuggestionEngine();
        INSTANCE = searchSuggestionEngine;
        MAX_ENTRY_TYPE_COUNT = 10;
        MAX_USER_SORTING_THRESHOLD = 100;
        membersRequestSubject = new SerializedSubject<>(PublishSubject.k0());
        searchSuggestionEngine.setupMemberRequestSubscription();
    }

    private SearchSuggestionEngine() {
    }

    private final List<ChannelSuggestion> getChannelSuggestions(CharSequence rawContent, FilterType currentFilter, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
        if (currentFilter != FilterType.IN) {
            return Collections2.emptyList();
        }
        Collection<Channel> collectionValues = channels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) outline.d((Channel) obj, channelPermissions))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (ChannelSuggestion.INSTANCE.canComplete(ChannelUtils.c((Channel) obj2), rawContent)) {
                arrayList2.add(obj2);
            }
        }
        List<Channel> listSortedWith = _Collections.sortedWith(arrayList2, ChannelUtils.h(Channel.INSTANCE));
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        for (Channel channel : listSortedWith) {
            arrayList3.add(new ChannelSuggestion(ChannelUtils.c(channel), channel.getId()));
        }
        return _Collections.take(arrayList3, MAX_ENTRY_TYPE_COUNT);
    }

    private final FilterType getCurrentFilterType(List<? extends QueryNode> input) {
        if (input.isEmpty()) {
            return null;
        }
        QueryNode queryNode = (QueryNode) _Collections.last((List) input);
        if (queryNode instanceof FilterNode) {
            return ((FilterNode) queryNode).getFilterType();
        }
        if (input.size() == 1) {
            return null;
        }
        QueryNode queryNode2 = input.get(Collections2.getLastIndex(input) - 1);
        if ((queryNode instanceof ContentNode) && (queryNode2 instanceof FilterNode)) {
            return ((FilterNode) queryNode2).getFilterType();
        }
        return null;
    }

    private final List<SearchSuggestion> getFilterSuggestions(CharSequence rawContent, SearchStringProvider searchStringProvider, boolean includeInChannels) {
        FilterType[] filterTypeArrValues = FilterType.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            FilterType filterType = filterTypeArrValues[i];
            if (includeInChannels || filterType != FilterType.IN) {
                arrayList.add(filterType);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (FilterSuggestion.INSTANCE.canComplete(rawContent, (FilterType) obj, searchStringProvider)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(new FilterSuggestion((FilterType) it.next()));
        }
        return arrayList3;
    }

    private final List<SearchSuggestion> getHasSuggestions(CharSequence rawContent, FilterType currentFilterType, SearchStringProvider searchStringProvider) {
        if (currentFilterType != FilterType.HAS) {
            return Collections2.emptyList();
        }
        HasNode2[] hasNode2ArrValues = HasNode2.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            HasNode2 hasNode2 = hasNode2ArrValues[i];
            if (HasSuggestion.INSTANCE.canComplete(rawContent, hasNode2, searchStringProvider)) {
                arrayList.add(hasNode2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new HasSuggestion((HasNode2) it.next()));
        }
        return arrayList2;
    }

    private final Collection<SearchSuggestion> getHistorySuggestions(Collection<? extends List<? extends QueryNode>> recentQueries) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(recentQueries, 10));
        Iterator<T> it = recentQueries.iterator();
        while (it.hasNext()) {
            arrayList.add(new RecentQuerySuggestion((List) it.next()));
        }
        return arrayList;
    }

    private final CharSequence getRawContent(List<? extends QueryNode> input) {
        if (input.isEmpty()) {
            return "";
        }
        QueryNode queryNode = (QueryNode) _Collections.last((List) input);
        if (!(queryNode instanceof ContentNode)) {
            return "";
        }
        String string = ((ContentNode) queryNode).getContent().toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        return Strings4.trim(string).toString();
    }

    public static final List<SearchSuggestion> getSuggestions(List<? extends QueryNode> input, SearchData searchData, SearchStringProvider searchStringProvider, Collection<? extends List<? extends QueryNode>> recentQueries) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Intrinsics3.checkNotNullParameter(recentQueries, "recentQueries");
        ArrayList arrayList = new ArrayList();
        SearchSuggestionEngine searchSuggestionEngine = INSTANCE;
        FilterType currentFilterType = searchSuggestionEngine.getCurrentFilterType(input);
        CharSequence rawContent = searchSuggestionEngine.getRawContent(input);
        if (currentFilterType != null) {
            arrayList.addAll(searchSuggestionEngine.getUserSuggestions(rawContent, currentFilterType, searchData.getUsers()));
            arrayList.addAll(searchSuggestionEngine.getChannelSuggestions(rawContent, currentFilterType, searchData.getChannels(), searchData.getChannelPermissions()));
            arrayList.addAll(searchSuggestionEngine.getHasSuggestions(rawContent, currentFilterType, searchStringProvider));
        } else {
            arrayList.addAll(searchSuggestionEngine.getFilterSuggestions(rawContent, searchStringProvider, !searchData.getChannels().isEmpty()));
        }
        if (input.isEmpty()) {
            arrayList.addAll(searchSuggestionEngine.getHistorySuggestions(recentQueries));
        }
        return arrayList;
    }

    private final Collection<UserSuggestion> getUserSuggestions(CharSequence rawContent, FilterType currentFilter, Map<Long, UserGuildMember> users) {
        UserSuggestion.TargetType targetType;
        int iOrdinal = currentFilter.ordinal();
        if (iOrdinal == 0) {
            targetType = UserSuggestion.TargetType.FROM;
        } else {
            if (iOrdinal != 1) {
                return Collections2.emptyList();
            }
            targetType = UserSuggestion.TargetType.MENTIONS;
        }
        membersRequestSubject.k.onNext(rawContent);
        TreeSet treeSet = new TreeSet();
        boolean z2 = users.size() < MAX_USER_SORTING_THRESHOLD;
        Iterator<Map.Entry<Long, UserGuildMember>> it = users.entrySet().iterator();
        while (it.hasNext()) {
            UserGuildMember value = it.next().getValue();
            User user = value.getUser();
            GuildMember guildMember = value.getGuildMember();
            if (UserSuggestion.INSTANCE.canComplete(user.getUsername(), user.getDiscriminator(), value.getNickname(), rawContent)) {
                treeSet.add(new UserSuggestion(user, targetType, guildMember));
                if (!z2 && treeSet.size() >= MAX_ENTRY_TYPE_COUNT) {
                    return treeSet;
                }
            }
        }
        return _Collections.take(treeSet, MAX_ENTRY_TYPE_COUNT);
    }

    private final void setupMemberRequestSubscription() {
        Observable<R> observableG = membersRequestSubject.P(750L, TimeUnit.MILLISECONDS).G(AnonymousClass1.INSTANCE);
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Object searchSuggestionEngine2 = anonymousClass2;
        if (anonymousClass2 != null) {
            searchSuggestionEngine2 = new SearchSuggestionEngine2(anonymousClass2);
        }
        Observable observableR = observableG.y((Func1) searchSuggestionEngine2).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "membersRequestSubject\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, SearchSuggestionEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass3.INSTANCE, 62, (Object) null);
    }

    public final Long getTargetGuildId() {
        return targetGuildId;
    }

    public final void setTargetGuildId(Long l) {
        targetGuildId = l;
    }
}
