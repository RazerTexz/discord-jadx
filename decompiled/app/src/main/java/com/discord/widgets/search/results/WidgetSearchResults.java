package com.discord.widgets.search.results;

import a0.a.a.b;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchResultsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSearchResults.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/search/results/WidgetSearchResults;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "", "addThreadSpineItemDecoration", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "model", "configureUI", "(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "onPause", "onDestroy", "Lcom/discord/databinding/WidgetSearchResultsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSearchResultsBinding;", "binding", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "<init>", ExifInterface.TAG_MODEL, "SearchResultAdapterEventHandler", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSearchResults extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSearchResults.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchResultsBinding;", 0)};
    private WidgetChatListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSearchResults.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\b\u0018\u0000 @2\u00020\u0001:\u0001@BY\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\b\u0002\u0010\u0016\u001a\u00060\u0006j\u0002`\u0007\u0012\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\n\u0010\u0018\u001a\u00060\u0006j\u0002`\u000f\u0012\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00120\u0011¢\u0006\u0004\b>\u0010?J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ \u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000b\u0012\u0004\u0012\u00020\f0\nHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00060\u0006j\u0002`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\tJ\u001a\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00120\u0011HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014Jj\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\b\u0002\u0010\u0016\u001a\u00060\u0006j\u0002`\u00072\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000b\u0012\u0004\u0012\u00020\f0\n2\f\b\u0002\u0010\u0018\u001a\u00060\u0006j\u0002`\u000f2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00120\u0011HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R \u0010&\u001a\u00060\u0006j\u0002`\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\tR&\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00120\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u0014R\u001e\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R \u00101\u001a\u00060\u0006j\u0002`08\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010\tR \u0010\u0016\u001a\u00060\u0006j\u0002`\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b3\u0010\tR \u0010\u0018\u001a\u00060\u0006j\u0002`\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b4\u0010\tR \u00105\u001a\u00060\u0006j\u0002`\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b5\u0010'\u001a\u0004\b6\u0010\tR\u001c\u00107\u001a\u00020#8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\b;\u0010\u0005R,\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000b\u0012\u0004\u0012\u00020\f0\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010<\u001a\u0004\b=\u0010\u000e¨\u0006A"}, d2 = {"Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "component1", "()Ljava/util/List;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "", "Lcom/discord/primitives/ChannelId;", "", "component3", "()Ljava/util/Map;", "Lcom/discord/primitives/MessageId;", "component4", "", "Lcom/discord/primitives/RoleId;", "component5", "()Ljava/util/Set;", "list", "userId", "channelNames", "oldestMessageId", "myRoleIds", "copy", "(Ljava/util/List;JLjava/util/Map;JLjava/util/Set;)Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "channelId", "J", "getChannelId", "Ljava/util/Set;", "getMyRoleIds", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/guild/Guild;", "getGuild", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/primitives/GuildId;", "guildId", "getGuildId", "getUserId", "getOldestMessageId", "newMessagesMarkerMessageId", "getNewMessagesMarkerMessageId", "isSpoilerClickAllowed", "Z", "()Z", "Ljava/util/List;", "getList", "Ljava/util/Map;", "getChannelNames", "<init>", "(Ljava/util/List;JLjava/util/Map;JLjava/util/Set;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final long userId;

        /* compiled from: WidgetSearchResults.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/search/results/WidgetSearchResults$Model$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableR = StoreStream.INSTANCE.getSearch().getStoreSearchQuery().getState().Y(WidgetSearchResults2.INSTANCE).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableR);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<? extends ChatListEntry> list, long j, Map<Long, String> map, long j2, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(set, "myRoleIds");
            this.list = list;
            this.userId = j;
            this.channelNames = map;
            this.oldestMessageId = j2;
            this.myRoleIds = set;
        }

        public static /* synthetic */ Model copy$default(Model model, List list, long j, Map map, long j2, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.getList();
            }
            if ((i & 2) != 0) {
                j = model.getUserId();
            }
            long j3 = j;
            if ((i & 4) != 0) {
                map = model.getChannelNames();
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                j2 = model.getOldestMessageId();
            }
            long j4 = j2;
            if ((i & 16) != 0) {
                set = model.getMyRoleIds();
            }
            return model.copy(list, j3, map2, j4, set);
        }

        public final List<ChatListEntry> component1() {
            return getList();
        }

        public final long component2() {
            return getUserId();
        }

        public final Map<Long, String> component3() {
            return getChannelNames();
        }

        public final long component4() {
            return getOldestMessageId();
        }

        public final Set<Long> component5() {
            return getMyRoleIds();
        }

        public final Model copy(List<? extends ChatListEntry> list, long userId, Map<Long, String> channelNames, long oldestMessageId, Set<Long> myRoleIds) {
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
            return new Model(list, userId, channelNames, oldestMessageId, myRoleIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(getList(), model.getList()) && getUserId() == model.getUserId() && Intrinsics3.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && Intrinsics3.areEqual(getMyRoleIds(), model.getMyRoleIds());
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public List<ChatListEntry> getList() {
            return this.list;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Set<Long> getMyRoleIds() {
            return this.myRoleIds;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getNewMessagesMarkerMessageId() {
            return this.newMessagesMarkerMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getOldestMessageId() {
            return this.oldestMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            List<ChatListEntry> list = getList();
            int iA = (b.a(getUserId()) + ((list != null ? list.hashCode() : 0) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iA2 = (b.a(getOldestMessageId()) + ((iA + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            return iA2 + (myRoleIds != null ? myRoleIds.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(list=");
            sbU.append(getList());
            sbU.append(", userId=");
            sbU.append(getUserId());
            sbU.append(", channelNames=");
            sbU.append(getChannelNames());
            sbU.append(", oldestMessageId=");
            sbU.append(getOldestMessageId());
            sbU.append(", myRoleIds=");
            sbU.append(getMyRoleIds());
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ Model(List list, long j, Map map, long j2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? 0L : j, map, j2, set);
        }
    }

    /* compiled from: WidgetSearchResults.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bn\u0010oJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010\u000f\u001a\u00060\u000bj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0006J#\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010$\u001a\u00060\u000bj\u0002`#H\u0016¢\u0006\u0004\b%\u0010&J#\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010$\u001a\u00060\u000bj\u0002`#H\u0016¢\u0006\u0004\b'\u0010&J'\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010$\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`#H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u0006JO\u00101\u001a\u00020\u00042\n\u0010$\u001a\u00060\u000bj\u0002`#2\n\u0010,\u001a\u00060\u000bj\u0002`+2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010-\u001a\u00060\u000bj\u0002`\u000e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u00102J;\u00103\u001a\u00020\u00042\n\u0010$\u001a\u00060\u000bj\u0002`#2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010-\u001a\u00060\u000bj\u0002`\u000e2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b3\u00104J'\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u00107J/\u00108\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010=\u001a\u00020\u00122\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u001eH\u0016¢\u0006\u0004\b=\u0010>JK\u0010F\u001a\u00020\u00042\n\u0010?\u001a\u00060\u000bj\u0002`+2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010-\u001a\u00060\u000bj\u0002`\u000e2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010IJ#\u0010M\u001a\u00020\u00042\n\u0010J\u001a\u00060\u000bj\u0002`\f2\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u001f\u0010Q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bS\u0010\u0006J\u0017\u0010T\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bT\u0010\u001dJY\u0010Y\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u000b2\u000e\u0010$\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`#2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010-\u001a\u00060\u000bj\u0002`\u000e2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bY\u0010ZJa\u0010b\u001a\u00020\u00042\n\u0010W\u001a\u00060\u000bj\u0002`[2\u000e\u0010$\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`#2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010-\u001a\u00060\u000bj\u0002`\u000e2\b\u0010\\\u001a\u0004\u0018\u00010\u000b2\n\u0010_\u001a\u00060]j\u0002`^2\u0006\u0010a\u001a\u00020`H\u0016¢\u0006\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010m¨\u0006p"}, d2 = {"Lcom/discord/widgets/search/results/WidgetSearchResults$SearchResultAdapterEventHandler;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "Lcom/discord/models/message/Message;", "message", "", "jumpToChat", "(Lcom/discord/models/message/Message;)V", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "onInteractionStateUpdated", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "oldestMessageId", "onOldestMessageId", "(JJ)V", "", "isThreadStarterMessage", "onMessageClicked", "(Lcom/discord/models/message/Message;Z)V", "", "formattedMessage", "onMessageLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;Z)V", "Lcom/discord/api/channel/Channel;", "channel", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "", "url", "onUrlLongClicked", "(Ljava/lang/String;)V", "onOpenPinsClicked", "Lcom/discord/primitives/GuildId;", "guildId", "onMessageAuthorNameClicked", "(Lcom/discord/models/message/Message;J)V", "onMessageAuthorAvatarClicked", "onMessageAuthorLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/Long;)V", "onMessageBlockedGroupClicked", "Lcom/discord/primitives/UserId;", "myUserId", "messageId", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "canAddReactions", "onReactionClicked", "(JJJJLcom/discord/api/message/reaction/MessageReaction;Z)V", "onReactionLongClicked", "(JJJLcom/discord/api/message/reaction/MessageReaction;)V", "userId", "onUserMentionClicked", "(JJJ)V", "onQuickAddReactionClicked", "(JJJJ)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "fileName", "onQuickDownloadClicked", "(Landroid/net/Uri;Ljava/lang/String;)Z", "authorId", "Lcom/discord/api/message/activity/MessageActivityType;", "actionType", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/application/Application;", "application", "onUserActivityAction", "(JJJLcom/discord/api/message/activity/MessageActivityType;Lcom/discord/api/activity/Activity;Lcom/discord/api/application/Application;)V", "onListClicked", "()V", "voiceChannelId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "callStatus", "onCallMessageClicked", "(JLcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;)V", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "onStickerClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "onDismissClicked", "onThreadLongClicked", "interactionId", "interactionUserId", "applicationId", "messageNonce", "onCommandClicked", "(JLjava/lang/Long;JJJJLjava/lang/String;)V", "Lcom/discord/primitives/ApplicationId;", "messageFlags", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "componentSendData", "onBotUiComponentClicked", "(JLjava/lang/Long;JJLjava/lang/Long;ILcom/discord/restapi/RestAPIParams$ComponentInteractionData;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/discord/utilities/channel/ChannelSelector;", "channelSelector", "Lcom/discord/utilities/channel/ChannelSelector;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "J", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/channel/ChannelSelector;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SearchResultAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Context context;
        private final FragmentManager fragmentManager;
        private long oldestMessageId;

        public SearchResultAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        private final void jumpToChat(Message message) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            AppScreen2.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
            Intrinsics3.checkNotNullParameter(componentSendData, "componentSendData");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
            if (!interactionState.getIsAtTop() || this.oldestMessageId == RecyclerView.FOREVER_NS) {
                return;
            }
            StoreStream.INSTANCE.getSearch().loadMore(this.oldestMessageId);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
            this.oldestMessageId = oldestMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String fileName) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(fileName, "fileName");
            return false;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            Intrinsics3.checkNotNullParameter(weakReference, "weakContext");
            Intrinsics3.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, StoreChannelsSelected3.EMBED, 2, null);
            AppScreen2.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            Intrinsics3.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            Intrinsics3.checkNotNullParameter(actionType, "actionType");
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long userId, long channelId, long guildId) {
        }
    }

    /* compiled from: WidgetSearchResults.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.results.WidgetSearchResults$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSearchResults widgetSearchResults) {
            super(1, widgetSearchResults, WidgetSearchResults.class, "configureUI", "configureUI(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetSearchResults.access$configureUI((WidgetSearchResults) this.receiver, model);
        }
    }

    public WidgetSearchResults() {
        super(R.layout.widget_search_results);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearchResults3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearchResults widgetSearchResults, Model model) {
        widgetSearchResults.configureUI(model);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f2523b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureUI(Model model) {
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
    }

    private final WidgetSearchResultsBinding getBinding() {
        return (WidgetSearchResultsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2523b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.searchResultsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new SearchResultAdapterEventHandler(context, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetSearchResults.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
