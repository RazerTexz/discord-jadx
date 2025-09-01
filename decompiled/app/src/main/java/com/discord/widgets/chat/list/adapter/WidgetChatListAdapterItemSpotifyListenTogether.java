package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.databinding.WidgetChatListAdapterItemSpotifyListenTogetherBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.Strings4;
import d0.t.Iterators5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;)V", "Landroid/content/Context;", "context", "Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "spotifyListenTogetherEntry", "", "getActivityName", "(Landroid/content/Context;Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;)Ljava/lang/String;", "Lcom/discord/models/presence/Presence;", "presence", "item", "", "isDeadInvite", "(Lcom/discord/models/presence/Presence;Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;)Z", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "userAdapter$delegate", "Lkotlin/Lazy;", "getUserAdapter", "()Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "userAdapter", "Lcom/discord/databinding/WidgetChatListAdapterItemSpotifyListenTogetherBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemSpotifyListenTogetherBinding;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether extends WidgetChatListItem {
    private static final long EMBED_LIFETIME_MILLIS = 7200000;
    private static final long MAX_USERS_SHOWN = 6;
    private final WidgetChatListAdapterItemSpotifyListenTogetherBinding binding;
    private Subscription subscription;

    /* renamed from: userAdapter$delegate, reason: from kotlin metadata */
    private final Lazy userAdapter;

    /* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u0000 '2\u00020\u0001:\u0001'B/\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\u0012\u0010\u000eR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u000b¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "", "Lcom/discord/models/presence/Presence;", "component1", "()Lcom/discord/models/presence/Presence;", "", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "component2", "()Ljava/util/List;", "Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "component3", "()Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "", "component4", "()Z", "presence", "users", "item", "isMe", "copy", "(Lcom/discord/models/presence/Presence;Ljava/util/List;Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;Z)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/presence/Presence;", "getPresence", "Z", "Ljava/util/List;", "getUsers", "Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "getItem", "<init>", "(Lcom/discord/models/presence/Presence;Ljava/util/List;Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isMe;
        private final SpotifyListenTogetherEntry item;
        private final Presence presence;
        private final List<CollapsedUser> users;

        /* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion;", "", "Lcom/discord/models/presence/Presence;", "presence", "", "", "Lcom/discord/models/user/User;", "userMap", "Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "item", "", "isMe", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "create", "(Lcom/discord/models/presence/Presence;Ljava/util/Map;Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;Z)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "Lrx/Observable;", "get", "(Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Model access$create(Companion companion, Presence presence, Map map, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2) {
                return companion.create(presence, map, spotifyListenTogetherEntry, z2);
            }

            private final Model create(Presence presence, Map<Long, ? extends User> userMap, SpotifyListenTogetherEntry item, boolean isMe) {
                ActivityParty party;
                HashMap map = new HashMap();
                for (User user : userMap.values()) {
                    map.put(Long.valueOf(user.getId()), new CollapsedUser(user, false, 0L, 6, null));
                }
                if (isMe) {
                    MeUser meSnapshot = StoreStream.INSTANCE.getUsers().getMeSnapshot();
                    map.put(Long.valueOf(meSnapshot.getId()), new CollapsedUser(meSnapshot, false, 0L, 6, null));
                }
                Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
                long maxSize = (spotifyListeningActivity == null || (party = spotifyListeningActivity.getParty()) == null) ? 0L : PresenceUtils.INSTANCE.getMaxSize(party);
                Collection collectionValues = map.values();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "collapsedUserMap.values");
                List mutableList = _Collections.toMutableList(collectionValues);
                Iterator<Long> it = _Ranges.until(userMap.size(), Math.min(WidgetChatListAdapterItemSpotifyListenTogether.MAX_USERS_SHOWN, maxSize)).iterator();
                while (it.hasNext()) {
                    mutableList.add(CollapsedUser.INSTANCE.createEmptyUser(((Iterators5) it).nextLong() == 5 ? maxSize - WidgetChatListAdapterItemSpotifyListenTogether.MAX_USERS_SHOWN : 0L));
                }
                return new Model(presence, mutableList, item, isMe);
            }

            public final Observable<Model> get(SpotifyListenTogetherEntry item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getPresences().observePresenceForUser(item.getUserId()), companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId()), companion.getUsers().observeMeId(), new WidgetChatListAdapterItemSpotifyListenTogether2(item));
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …m.userId)\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Presence presence, List<CollapsedUser> list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "users");
            Intrinsics3.checkNotNullParameter(spotifyListenTogetherEntry, "item");
            this.presence = presence;
            this.users = list;
            this.item = spotifyListenTogetherEntry;
            this.isMe = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Presence presence, List list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                presence = model.presence;
            }
            if ((i & 2) != 0) {
                list = model.users;
            }
            if ((i & 4) != 0) {
                spotifyListenTogetherEntry = model.item;
            }
            if ((i & 8) != 0) {
                z2 = model.isMe;
            }
            return model.copy(presence, list, spotifyListenTogetherEntry, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        public final List<CollapsedUser> component2() {
            return this.users;
        }

        /* renamed from: component3, reason: from getter */
        public final SpotifyListenTogetherEntry getItem() {
            return this.item;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        public final Model copy(Presence presence, List<CollapsedUser> users, SpotifyListenTogetherEntry item, boolean isMe) {
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(item, "item");
            return new Model(presence, users, item, isMe);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.presence, model.presence) && Intrinsics3.areEqual(this.users, model.users) && Intrinsics3.areEqual(this.item, model.item) && this.isMe == model.isMe;
        }

        public final SpotifyListenTogetherEntry getItem() {
            return this.item;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final List<CollapsedUser> getUsers() {
            return this.users;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Presence presence = this.presence;
            int iHashCode = (presence != null ? presence.hashCode() : 0) * 31;
            List<CollapsedUser> list = this.users;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            SpotifyListenTogetherEntry spotifyListenTogetherEntry = this.item;
            int iHashCode3 = (iHashCode2 + (spotifyListenTogetherEntry != null ? spotifyListenTogetherEntry.hashCode() : 0)) * 31;
            boolean z2 = this.isMe;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(presence=");
            sbU.append(this.presence);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", item=");
            sbU.append(this.item);
            sbU.append(", isMe=");
            return outline.O(sbU, this.isMe, ")");
        }
    }

    /* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Activity $listeningActivity;

        public AnonymousClass2(Activity activity) {
            this.$listeningActivity = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SpotifyHelper.INSTANCE.launchTrack(outline.x(view, "it", "it.context"), this.$listeningActivity);
        }
    }

    /* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Activity $listeningActivity;
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass3(Model model, Activity activity) {
            this.$this_configureUI = model;
            this.$listeningActivity = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SpotifyHelper.INSTANCE.launchAlbum(outline.x(view, "it", "it.context"), this.$listeningActivity, this.$this_configureUI.getItem().getUserId(), this.$this_configureUI.isMe());
        }
    }

    /* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
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
            WidgetChatListAdapterItemSpotifyListenTogether.access$setSubscription$p(WidgetChatListAdapterItemSpotifyListenTogether.this, subscription);
        }
    }

    /* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "it", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemSpotifyListenTogether.access$configureUI(WidgetChatListAdapterItemSpotifyListenTogether.this, model);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_spotify_listen_together, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.barrier;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
        if (barrier != null) {
            i = R.id.item_listen_together_album_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_listen_together_album_image);
            if (simpleDraweeView != null) {
                i = R.id.item_listen_together_artist;
                TextView textView = (TextView) view.findViewById(R.id.item_listen_together_artist);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.item_listen_together_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.item_listen_together_header);
                    if (textView2 != null) {
                        i = R.id.item_listen_together_join;
                        TextView textView3 = (TextView) view.findViewById(R.id.item_listen_together_join);
                        if (textView3 != null) {
                            i = R.id.item_listen_together_recycler;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.item_listen_together_recycler);
                            if (recyclerView != null) {
                                i = R.id.item_listen_together_session_ended;
                                TextView textView4 = (TextView) view.findViewById(R.id.item_listen_together_session_ended);
                                if (textView4 != null) {
                                    i = R.id.item_listen_together_track;
                                    TextView textView5 = (TextView) view.findViewById(R.id.item_listen_together_track);
                                    if (textView5 != null) {
                                        WidgetChatListAdapterItemSpotifyListenTogetherBinding widgetChatListAdapterItemSpotifyListenTogetherBinding = new WidgetChatListAdapterItemSpotifyListenTogetherBinding(constraintLayout, barrier, simpleDraweeView, textView, constraintLayout, textView2, textView3, recyclerView, textView4, textView5);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSpotifyListenTogetherBinding, "WidgetChatListAdapterIte…herBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemSpotifyListenTogetherBinding;
                                        this.userAdapter = LazyJVM.lazy(new WidgetChatListAdapterItemSpotifyListenTogether3(this));
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether, Model model) {
        widgetChatListAdapterItemSpotifyListenTogether.configureUI(model);
    }

    public static final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogetherBinding access$getBinding$p(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        return widgetChatListAdapterItemSpotifyListenTogether.binding;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        return widgetChatListAdapterItemSpotifyListenTogether.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether, Subscription subscription) {
        widgetChatListAdapterItemSpotifyListenTogether.subscription = subscription;
    }

    private final void configureUI(Model model) {
        String largeImage;
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemListenTogetherHeader");
        textView.setText(FormatUtils.h(outline.I(this.binding.e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), R.string.invite_embed_invite_to_listen, new Object[]{getActivityName(outline.I(this.binding.e, "binding.itemListenTogetherHeader", "binding.itemListenTogetherHeader.context"), model.getItem())}, null, 4));
        boolean zIsDeadInvite = isDeadInvite(model.getPresence(), model.getItem());
        Presence presence = model.getPresence();
        Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        TextView textView2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemListenTogetherSessionEnded");
        textView2.setVisibility(zIsDeadInvite ? 0 : 8);
        RecyclerView recyclerView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemListenTogetherRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView3 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemListenTogetherTrack");
        textView3.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemListenTogetherArtist");
        textView4.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        SimpleDraweeView simpleDraweeView = this.binding.f2331b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.itemListenTogetherContainer");
        constraintLayout.setSelected(true);
        if (zIsDeadInvite) {
            return;
        }
        getUserAdapter().setData(model.getUsers());
        TextView textView5 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.itemListenTogetherTrack");
        textView5.setText(spotifyListeningActivity != null ? spotifyListeningActivity.getDetails() : null);
        TextView textView6 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.itemListenTogetherArtist");
        Object[] objArr = new Object[1];
        objArr[0] = spotifyListeningActivity != null ? spotifyListeningActivity.getState() : null;
        FormatUtils.n(textView6, R.string.user_activity_listening_artists, objArr, null, 4);
        ActivityAssets assets = spotifyListeningActivity != null ? spotifyListeningActivity.getAssets() : null;
        if (assets != null && (largeImage = assets.getLargeImage()) != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f2331b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemListenTogetherAlbumImage");
            MGImages.setImage$default(simpleDraweeView2, IconUtils.getAssetImage$default(IconUtils.INSTANCE, null, largeImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        }
        SimpleDraweeView simpleDraweeView3 = this.binding.f2331b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemListenTogetherAlbumImage");
        simpleDraweeView3.setContentDescription(assets != null ? assets.getLargeText() : null);
        this.binding.h.setOnClickListener(new AnonymousClass2(spotifyListeningActivity));
        this.binding.f2331b.setOnClickListener(new AnonymousClass3(model, spotifyListeningActivity));
    }

    private final String getActivityName(Context context, SpotifyListenTogetherEntry spotifyListenTogetherEntry) {
        String partyId = spotifyListenTogetherEntry.getActivity().getPartyId();
        Platform platform = Platform.SPOTIFY;
        if (Strings4.contains((CharSequence) partyId, (CharSequence) platform.getPlatformId(), true)) {
            return platform.getProperName();
        }
        String string = context.getString(R.string.form_label_desktop_only);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri….form_label_desktop_only)");
        return string;
    }

    private final WidgetCollapsedUsersListAdapter getUserAdapter() {
        return (WidgetCollapsedUsersListAdapter) this.userAdapter.getValue();
    }

    private final boolean isDeadInvite(Presence presence, SpotifyListenTogetherEntry item) {
        ActivityParty party;
        String id2;
        Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        return !((spotifyListeningActivity == null || (party = spotifyListeningActivity.getParty()) == null || (id2 = party.getId()) == null) ? false : id2.equals(item.getActivity().getPartyId())) || TimeUtils.parseSnowflake(Long.valueOf(item.getMessageId())) + EMBED_LIFETIME_MILLIS < ClockFactory.get().currentTimeMillis();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(Model.INSTANCE.get((SpotifyListenTogetherEntry) data)), WidgetChatListAdapterItemSpotifyListenTogether.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }
}
