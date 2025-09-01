package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreContactSync;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreFriendSuggestions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.widgets.friends.FriendsListViewModel;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: FriendsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;)Lcom/discord/widgets/friends/FriendsListViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.FriendsListViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FriendsListViewModel2<T, R> implements Func1<Unit, FriendsListViewModel.StoreState> {
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreContactSync $storeContactSync;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StoreFriendSuggestions $storeFriendSuggestions;
    public final /* synthetic */ StoreUserPresence $storePresences;
    public final /* synthetic */ StoreUserConnections $storeUserConnections;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUser $storeUsers;

    public FriendsListViewModel2(StoreChannelsSelected storeChannelsSelected, StoreUserPresence storeUserPresence, StoreUser storeUser, StoreUserRelationships storeUserRelationships, StoreApplicationStreaming storeApplicationStreaming, StoreUserConnections storeUserConnections, StoreExperiments storeExperiments, StoreContactSync storeContactSync, StoreFriendSuggestions storeFriendSuggestions) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storePresences = storeUserPresence;
        this.$storeUsers = storeUser;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeUserConnections = storeUserConnections;
        this.$storeExperiments = storeExperiments;
        this.$storeContactSync = storeContactSync;
        this.$storeFriendSuggestions = storeFriendSuggestions;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ FriendsListViewModel.StoreState call(Unit unit) {
        return call2(unit);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final FriendsListViewModel.StoreState call2(Unit unit) {
        boolean z2;
        boolean z3;
        long id2 = this.$storeChannelsSelected.getId();
        SnowflakePartitionMap.CopiablePartitionMap<Presence> presences = this.$storePresences.getPresences();
        Map<Long, User> users = this.$storeUsers.getUsers();
        StoreUserRelationships.UserRelationshipsState relationshipsStateSnapshot = this.$storeUserRelationships.getRelationshipsStateSnapshot();
        Map<Long, ModelApplicationStream> streamsByUser = this.$storeApplicationStreaming.getStreamsByUser();
        StoreUserConnections.State stateSnapshot = this.$storeUserConnections.getStateSnapshot();
        boolean z4 = stateSnapshot instanceof Collection;
        if (z4 && stateSnapshot.isEmpty()) {
            z2 = false;
        } else {
            Iterator<ConnectedAccount> it = stateSnapshot.iterator();
            while (it.hasNext()) {
                if (Intrinsics3.areEqual(it.next().getType(), "contacts")) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z4 && stateSnapshot.isEmpty()) {
            z3 = false;
        } else {
            for (ConnectedAccount connectedAccount : stateSnapshot) {
                if (Intrinsics3.areEqual(connectedAccount.getType(), "contacts") && connectedAccount.getFriendSync()) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        Experiment userExperiment = this.$storeExperiments.getUserExperiment("2021-04_contact_sync_android_main", !z2);
        boolean z5 = (userExperiment == null || userExperiment.getBucket() != 1 || z2) ? false : true;
        boolean z6 = !this.$storeContactSync.getFriendsListUpsellDismissed() && (userExperiment != null && userExperiment.getBucket() == 1 && !z3);
        return new FriendsListViewModel.StoreState(z5 && !z6, z6, id2, relationshipsStateSnapshot, users, presences, streamsByUser, (userExperiment == null || userExperiment.getBucket() != 1) ? Maps6.emptyMap() : this.$storeFriendSuggestions.getFriendSuggestions());
    }
}
