package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUrl;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import d0.t.Collections2;
import d0.z.d.CollectionToArray;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.g0.KMarkers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserConnections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001:B!\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00104\u001a\u000203\u0012\b\b\u0002\u0010,\u001a\u00020+¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J%\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0017¢\u0006\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0019\u0010/\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0019\u00104\u001a\u0002038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/discord/stores/StoreUserConnections;", "Lcom/discord/stores/StoreV2;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "accounts", "handleUserConnections", "(Ljava/util/List;)V", "Lcom/discord/stores/StoreUserConnections$State;", "getConnectedAccounts", "()Lcom/discord/stores/StoreUserConnections$State;", "Lrx/Observable;", "observeConnectedAccounts", "()Lrx/Observable;", "connectedAccount", "", "syncFriends", "showActivity", "isVisible", "updateUserConnection", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;ZZZ)V", "", "platformName", "connectionId", "deleteUserConnection", "(Ljava/lang/String;Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "authorizeConnection", "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)V", "fetchConnectedAccounts", "()V", "snapshotData", "state", "Lcom/discord/stores/StoreUserConnections$State;", "stateSnapshot", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "getStream", "()Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserConnections extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private State stateSnapshot;
    private final StoreStream stream;

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0017\b\u0002\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b&\u0010'J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0096\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0010J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u001aJ&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u0082\u0001\u0002*+¨\u0006,"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State;", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "element", "", "contains", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "index", "get", "(I)Lcom/discord/api/connectedaccounts/ConnectedAccount;", "indexOf", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "getSize", "()I", "size", "connectedAccounts", "Ljava/util/List;", "getConnectedAccounts", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "ConnectedAccounts", "Loading", "Lcom/discord/stores/StoreUserConnections$State$Loading;", "Lcom/discord/stores/StoreUserConnections$State$ConnectedAccounts;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State implements List<ConnectedAccount>, KMarkers {
        private final List<ConnectedAccount> connectedAccounts;

        /* compiled from: StoreUserConnections.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State$ConnectedAccounts;", "Lcom/discord/stores/StoreUserConnections$State;", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "component1", "()Ljava/util/List;", "connectedAccounts", "copy", "(Ljava/util/List;)Lcom/discord/stores/StoreUserConnections$State$ConnectedAccounts;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getConnectedAccounts", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ConnectedAccounts extends State {
            private final List<ConnectedAccount> connectedAccounts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectedAccounts(List<ConnectedAccount> list) {
                super(list, null);
                Intrinsics3.checkNotNullParameter(list, "connectedAccounts");
                this.connectedAccounts = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ConnectedAccounts copy$default(ConnectedAccounts connectedAccounts, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = connectedAccounts.getConnectedAccounts();
                }
                return connectedAccounts.copy(list);
            }

            public final List<ConnectedAccount> component1() {
                return getConnectedAccounts();
            }

            public final ConnectedAccounts copy(List<ConnectedAccount> connectedAccounts) {
                Intrinsics3.checkNotNullParameter(connectedAccounts, "connectedAccounts");
                return new ConnectedAccounts(connectedAccounts);
            }

            @Override // java.util.List, java.util.Collection
            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ConnectedAccounts) && Intrinsics3.areEqual(getConnectedAccounts(), ((ConnectedAccounts) other).getConnectedAccounts());
                }
                return true;
            }

            @Override // com.discord.stores.StoreUserConnections.State
            public List<ConnectedAccount> getConnectedAccounts() {
                return this.connectedAccounts;
            }

            @Override // java.util.List, java.util.Collection
            public int hashCode() {
                List<ConnectedAccount> connectedAccounts = getConnectedAccounts();
                if (connectedAccounts != null) {
                    return connectedAccounts.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ConnectedAccounts(connectedAccounts=");
                sbU.append(getConnectedAccounts());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreUserConnections.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State$Loading;", "Lcom/discord/stores/StoreUserConnections$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(Collections2.emptyList(), null);
            }
        }

        private State(List<ConnectedAccount> list) {
            this.connectedAccounts = list;
        }

        /* renamed from: add, reason: avoid collision after fix types in other method */
        public void add2(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* synthetic */ void add(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends ConnectedAccount> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends ConnectedAccount> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(ConnectedAccount element) {
            Intrinsics3.checkNotNullParameter(element, "element");
            return this.connectedAccounts.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof ConnectedAccount) {
                return contains((ConnectedAccount) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics3.checkNotNullParameter(elements, "elements");
            return this.connectedAccounts.containsAll(elements);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public ConnectedAccount get(int index) {
            ConnectedAccount connectedAccount = this.connectedAccounts.get(index);
            Intrinsics3.checkNotNullExpressionValue(connectedAccount, "get(...)");
            return connectedAccount;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ ConnectedAccount get(int i) {
            return get(i);
        }

        public List<ConnectedAccount> getConnectedAccounts() {
            return this.connectedAccounts;
        }

        public int getSize() {
            return this.connectedAccounts.size();
        }

        public int indexOf(ConnectedAccount element) {
            Intrinsics3.checkNotNullParameter(element, "element");
            return this.connectedAccounts.indexOf(element);
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof ConnectedAccount) {
                return indexOf((ConnectedAccount) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.connectedAccounts.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<ConnectedAccount> iterator() {
            return this.connectedAccounts.iterator();
        }

        public int lastIndexOf(ConnectedAccount element) {
            Intrinsics3.checkNotNullParameter(element, "element");
            return this.connectedAccounts.lastIndexOf(element);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof ConnectedAccount) {
                return lastIndexOf((ConnectedAccount) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator<ConnectedAccount> listIterator() {
            return this.connectedAccounts.listIterator();
        }

        @Override // java.util.List
        public ListIterator<ConnectedAccount> listIterator(int index) {
            return this.connectedAccounts.listIterator(index);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public ConnectedAccount remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* synthetic */ ConnectedAccount remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<ConnectedAccount> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public ConnectedAccount set2(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* synthetic */ ConnectedAccount set(int i, ConnectedAccount connectedAccount) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public void sort(Comparator<? super ConnectedAccount> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List<ConnectedAccount> subList(int fromIndex, int toIndex) {
            return this.connectedAccounts.subList(fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.toArray(this, tArr);
        }

        public /* synthetic */ State(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUrl;", "response", "", "invoke", "(Lcom/discord/models/domain/ModelUrl;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$authorizeConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUrl, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUrl modelUrl) {
            invoke2(modelUrl);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUrl modelUrl) {
            Intrinsics3.checkNotNullParameter(modelUrl, "response");
            UriHandler.handle$default(UriHandler.INSTANCE, this.$context, modelUrl.getUrl(), false, false, null, 28, null);
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$deleteUserConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(Void r7) {
            return new TrackNetworkActionUserConnectionsUpdate(null, null, null, null, 15);
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$deleteUserConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            StoreUserConnections.this.fetchConnectedAccounts();
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "connectedAccounts", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$fetchConnectedAccounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ConnectedAccount>, Unit> {

        /* compiled from: StoreUserConnections.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserConnections$fetchConnectedAccounts$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01841 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $connectedAccounts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01841(List list) {
                super(0);
                this.$connectedAccounts = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserConnections.this.getStream().handleUserConnections(this.$connectedAccounts);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConnectedAccount> list) {
            invoke2((List<ConnectedAccount>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ConnectedAccount> list) {
            Intrinsics3.checkNotNullParameter(list, "connectedAccounts");
            StoreUserConnections.this.getDispatcher().schedule(new C01841(list));
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreUserConnections.this.fetchConnectedAccounts();
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State;", "invoke", "()Lcom/discord/stores/StoreUserConnections$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$observeConnectedAccounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreUserConnections.this.getStateSnapshot();
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$updateUserConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ConnectedAccount, TrackNetworkMetadata2> {
        public final /* synthetic */ ConnectedAccount $connectedAccount;
        public final /* synthetic */ boolean $syncFriends;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConnectedAccount connectedAccount, boolean z2) {
            super(1);
            this.$connectedAccount = connectedAccount;
            this.$syncFriends = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ConnectedAccount connectedAccount) {
            return invoke2(connectedAccount);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ConnectedAccount connectedAccount) {
            return new TrackNetworkActionUserConnectionsUpdate(this.$connectedAccount.getName(), Boolean.valueOf(this.$syncFriends), null, null, 12);
        }
    }

    /* compiled from: StoreUserConnections.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserConnections$updateUserConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ConnectedAccount, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "it");
            StoreUserConnections.this.fetchConnectedAccounts();
        }
    }

    public /* synthetic */ StoreUserConnections(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public final void authorizeConnection(String platformName, Context context, String location) {
        Intrinsics3.checkNotNullParameter(platformName, "platformName");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsTracker.INSTANCE.trackConnectedAccountInitiated(platformName, location);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().authorizeConnection(platformName), false, 1, null), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(context), 62, (Object) null);
    }

    public final void deleteUserConnection(String platformName, String connectionId) {
        Intrinsics3.checkNotNullParameter(platformName, "platformName");
        Intrinsics3.checkNotNullParameter(connectionId, "connectionId");
        ObservableExtensionsKt.appSubscribe$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteConnection(platformName, connectionId), false, 1, null), AnonymousClass1.INSTANCE), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public final void fetchConnectedAccounts() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getConnections(), false, 1, null), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    /* renamed from: getConnectedAccounts, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        Intrinsics3.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
    }

    @Store3
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        Intrinsics3.checkNotNullParameter(accounts, "accounts");
        this.state = new State.ConnectedAccounts(accounts);
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getGatewaySocket().getUserConnectionUpdate(), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final Observable<State> observeConnectedAccounts() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        State state = this.state;
        State connectedAccounts = State.Loading.INSTANCE;
        if (!Intrinsics3.areEqual(state, connectedAccounts)) {
            if (!(state instanceof State.ConnectedAccounts)) {
                throw new NoWhenBranchMatchedException();
            }
            connectedAccounts = new State.ConnectedAccounts(new ArrayList(state.getConnectedAccounts()));
        }
        this.stateSnapshot = connectedAccounts;
    }

    public final void updateUserConnection(ConnectedAccount connectedAccount, boolean syncFriends, boolean showActivity, boolean isVisible) {
        Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
        ObservableExtensionsKt.appSubscribe$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateConnection(connectedAccount.getType(), connectedAccount.getId(), RestAPIParams.ConnectedAccount.INSTANCE.create(connectedAccount, syncFriends, showActivity, isVisible ? 1 : 0)), false, 1, null), new AnonymousClass1(connectedAccount, syncFriends)), StoreUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public StoreUserConnections(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
