package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.models.domain.ModelPayload;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.user.CoreUser;
import com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreFriendSuggestions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b0\u00101J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\u000f2\n\u0010\u0016\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\u000f2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012H\u0007¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010\u001f\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010 R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R&\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00050*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010+R&\u0010,\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/discord/stores/StoreFriendSuggestions;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "Lcom/discord/stores/ApiFriendSuggestion;", "apiFriendSuggestion", "Lcom/discord/models/friendsuggestions/FriendSuggestion;", "convertApiFriendSuggestion", "(Lcom/discord/api/friendsuggestions/FriendSuggestion;)Lcom/discord/models/friendsuggestions/FriendSuggestion;", "", "", "Lcom/discord/primitives/UserId;", "getFriendSuggestions", "()Ljava/util/Map;", "Lcom/discord/models/domain/ModelPayload;", "readyPayload", "", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "", "suggestions", "updateFriendSuggestions", "(Ljava/util/List;)V", "friendSuggestionCreate", "handleFriendSuggestionCreate", "(Lcom/discord/api/friendsuggestions/FriendSuggestion;)V", "Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;", "friendSuggestionDelete", "handleFriendSuggestionDelete", "(Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;)V", "loadedSuggestions", "handleFriendSuggestionsLoaded", "handleFriendSuggestionsLoadFailure", "()V", "snapshotData", "Lcom/discord/utilities/friendsuggestions/FriendSuggestionsFetcher;", "friendSuggestionsFetcher", "Lcom/discord/utilities/friendsuggestions/FriendSuggestionsFetcher;", "getFriendSuggestionsFetcher", "()Lcom/discord/utilities/friendsuggestions/FriendSuggestionsFetcher;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "Ljava/util/Map;", "suggestionsSnapshot", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/friendsuggestions/FriendSuggestionsFetcher;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreFriendSuggestions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final FriendSuggestionsFetcher friendSuggestionsFetcher;
    private final StoreStream storeStream;
    private final Map<Long, FriendSuggestion> suggestions;
    private Map<Long, FriendSuggestion> suggestionsSnapshot;

    /* compiled from: StoreFriendSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreFriendSuggestions$updateFriendSuggestions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $suggestions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$suggestions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreFriendSuggestions.access$getStoreStream$p(StoreFriendSuggestions.this).handleFriendSuggestionsLoaded(this.$suggestions);
        }
    }

    public StoreFriendSuggestions(StoreStream storeStream, Dispatcher dispatcher, FriendSuggestionsFetcher friendSuggestionsFetcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(friendSuggestionsFetcher, "friendSuggestionsFetcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.friendSuggestionsFetcher = friendSuggestionsFetcher;
        this.suggestions = new HashMap();
        this.suggestionsSnapshot = Maps6.emptyMap();
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreFriendSuggestions storeFriendSuggestions) {
        return storeFriendSuggestions.storeStream;
    }

    private final FriendSuggestion convertApiFriendSuggestion(com.discord.api.friendsuggestions.FriendSuggestion apiFriendSuggestion) {
        CoreUser coreUser = new CoreUser(apiFriendSuggestion.getSuggestedUser());
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) _Collections.firstOrNull((List) apiFriendSuggestion.a());
        return new FriendSuggestion(coreUser, friendSuggestionReason != null ? friendSuggestionReason.getName() : null);
    }

    public final Map<Long, FriendSuggestion> getFriendSuggestions() {
        return this.suggestionsSnapshot;
    }

    public final FriendSuggestionsFetcher getFriendSuggestionsFetcher() {
        return this.friendSuggestionsFetcher;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload readyPayload) {
        Intrinsics3.checkNotNullParameter(readyPayload, "readyPayload");
        this.suggestions.clear();
        if (readyPayload.getFriendSuggestionCount() > 0) {
            this.friendSuggestionsFetcher.maybeFetch();
        }
        markChanged();
    }

    @Store3
    public final void handleFriendSuggestionCreate(com.discord.api.friendsuggestions.FriendSuggestion friendSuggestionCreate) {
        Intrinsics3.checkNotNullParameter(friendSuggestionCreate, "friendSuggestionCreate");
        CoreUser coreUser = new CoreUser(friendSuggestionCreate.getSuggestedUser());
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) _Collections.firstOrNull((List) friendSuggestionCreate.a());
        FriendSuggestion friendSuggestion = new FriendSuggestion(coreUser, friendSuggestionReason != null ? friendSuggestionReason.getName() : null);
        this.suggestions.put(Long.valueOf(friendSuggestion.getUser().getId()), friendSuggestion);
        markChanged();
    }

    @Store3
    public final void handleFriendSuggestionDelete(FriendSuggestionDelete friendSuggestionDelete) {
        Intrinsics3.checkNotNullParameter(friendSuggestionDelete, "friendSuggestionDelete");
        if (this.suggestions.remove(Long.valueOf(friendSuggestionDelete.getSuggestedUserId())) != null) {
            markChanged();
        }
    }

    @Store3
    public final void handleFriendSuggestionsLoadFailure() {
        this.suggestions.clear();
        markChanged();
    }

    @Store3
    public final void handleFriendSuggestionsLoaded(List<com.discord.api.friendsuggestions.FriendSuggestion> loadedSuggestions) {
        Intrinsics3.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        this.suggestions.clear();
        Map<Long, FriendSuggestion> map = this.suggestions;
        for (com.discord.api.friendsuggestions.FriendSuggestion friendSuggestion : loadedSuggestions) {
            map.put(Long.valueOf(friendSuggestion.getSuggestedUser().getId()), convertApiFriendSuggestion(friendSuggestion));
        }
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.suggestionsSnapshot = new HashMap(this.suggestions);
    }

    public final void updateFriendSuggestions(List<com.discord.api.friendsuggestions.FriendSuggestion> suggestions) {
        Intrinsics3.checkNotNullParameter(suggestions, "suggestions");
        this.dispatcher.schedule(new AnonymousClass1(suggestions));
    }
}
