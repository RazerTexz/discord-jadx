package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.call.MessageCall;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemCallBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.d0._Ranges;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemCallMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002RSB\u000f\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J!\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J/\u0010/\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0016\u0010.\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`,\u0012\u0004\u0012\u00020-0+H\u0002¢\u0006\u0004\b/\u00100J=\u00105\u001a\b\u0012\u0004\u0012\u000204032\u0016\u0010.\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`,\u0012\u0004\u0012\u00020-0+2\u0006\u0010\r\u001a\u00020\f2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b5\u00106J\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\b072\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0005H\u0016¢\u0006\u0004\b:\u0010\u0014J\u000f\u0010;\u001a\u00020\u0005H\u0016¢\u0006\u0004\b;\u0010\u0014J\u001f\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010AR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006T"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/FragmentLifecycleListener;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "configure", "(Lcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;", "state", "handleState", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;)V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "callStatus", "", "Lcom/discord/primitives/ChannelId;", "channelId", "onItemClick", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;J)V", "resetCurrentChatListEntry", "()V", "clearSubscriptions", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "getCallDrawable", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", "resources", "", "getTitleString", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;Landroid/content/res/Resources;)Ljava/lang/CharSequence;", "Lcom/discord/widgets/chat/list/entries/MessageEntry;", "messageEntry", "configureSubtitle", "(Lcom/discord/widgets/chat/list/entries/MessageEntry;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;Landroid/content/Context;)V", "", "time", "", "getMinWidthPxForTime", "(Ljava/lang/String;)I", "Lcom/discord/models/message/Message;", "message", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceParticipants", "getCallStatus", "(Lcom/discord/models/message/Message;Ljava/util/Map;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "Lcom/discord/models/user/User;", "messageAuthor", "", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "createCallParticipantUsers", "(Ljava/util/Map;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;Lcom/discord/models/user/User;)Ljava/util/List;", "Lrx/Observable;", "observeState", "(Lcom/discord/widgets/chat/list/entries/MessageEntry;)Lrx/Observable;", "onResume", "onPause", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "stateSubscription", "Lrx/Subscription;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/databinding/WidgetChatListAdapterItemCallBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemCallBinding;", "chatListEntry", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "ongoingCallDurationSubscription", "Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "usersAdapter", "Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "CallStatus", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage extends WidgetChatListItem implements FragmentLifecycleListener {
    private final WidgetChatListAdapterItemCallBinding binding;
    private ChatListEntry chatListEntry;
    private final Clock clock;
    private Subscription ongoingCallDurationSubscription;
    private Subscription stateSubscription;
    private final WidgetCollapsedUsersListAdapter usersAdapter;

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics3.checkNotNullParameter(v, "v");
            WidgetChatListAdapterItemCallMessage.access$resetCurrentChatListEntry(WidgetChatListAdapterItemCallMessage.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics3.checkNotNullParameter(v, "v");
            WidgetChatListAdapterItemCallMessage.access$clearSubscriptions(WidgetChatListAdapterItemCallMessage.this);
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE_UNJOINED", "ACTIVE_JOINED", "INACTIVE_UNJOINED", "INACTIVE_JOINED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum CallStatus {
        ACTIVE_UNJOINED,
        ACTIVE_JOINED,
        INACTIVE_UNJOINED,
        INACTIVE_JOINED
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\r\u001a\u00020\u00002\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R)\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;", "", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Ljava/util/Map;", "Lcom/discord/widgets/chat/list/entries/MessageEntry;", "component2", "()Lcom/discord/widgets/chat/list/entries/MessageEntry;", "voiceParticipants", "messageEntry", "copy", "(Ljava/util/Map;Lcom/discord/widgets/chat/list/entries/MessageEntry;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getVoiceParticipants", "Lcom/discord/widgets/chat/list/entries/MessageEntry;", "getMessageEntry", "<init>", "(Ljava/util/Map;Lcom/discord/widgets/chat/list/entries/MessageEntry;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final MessageEntry messageEntry;
        private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

        public State(Map<Long, StoreVoiceParticipants.VoiceUser> map, MessageEntry messageEntry) {
            Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(messageEntry, "messageEntry");
            this.voiceParticipants = map;
            this.messageEntry = messageEntry;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Map map, MessageEntry messageEntry, int i, Object obj) {
            if ((i & 1) != 0) {
                map = state.voiceParticipants;
            }
            if ((i & 2) != 0) {
                messageEntry = state.messageEntry;
            }
            return state.copy(map, messageEntry);
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
            return this.voiceParticipants;
        }

        /* renamed from: component2, reason: from getter */
        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        public final State copy(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, MessageEntry messageEntry) {
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(messageEntry, "messageEntry");
            return new State(voiceParticipants, messageEntry);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.voiceParticipants, state.voiceParticipants) && Intrinsics3.areEqual(this.messageEntry, state.messageEntry);
        }

        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        public int hashCode() {
            Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            MessageEntry messageEntry = this.messageEntry;
            return iHashCode + (messageEntry != null ? messageEntry.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(voiceParticipants=");
            sbU.append(this.voiceParticipants);
            sbU.append(", messageEntry=");
            sbU.append(this.messageEntry);
            sbU.append(")");
            return sbU.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            CallStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            CallStatus callStatus = CallStatus.INACTIVE_UNJOINED;
            iArr[callStatus.ordinal()] = 1;
            CallStatus callStatus2 = CallStatus.INACTIVE_JOINED;
            iArr[callStatus2.ordinal()] = 2;
            CallStatus callStatus3 = CallStatus.ACTIVE_JOINED;
            iArr[callStatus3.ordinal()] = 3;
            CallStatus callStatus4 = CallStatus.ACTIVE_UNJOINED;
            iArr[callStatus4.ordinal()] = 4;
            CallStatus.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[callStatus.ordinal()] = 1;
            iArr2[callStatus2.ordinal()] = 2;
            iArr2[callStatus3.ordinal()] = 3;
            iArr2[callStatus4.ordinal()] = 4;
            CallStatus.values();
            int[] iArr3 = new int[4];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[callStatus.ordinal()] = 1;
            iArr3[callStatus2.ordinal()] = 2;
            iArr3[callStatus3.ordinal()] = 3;
            iArr3[callStatus4.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configure$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetChatListAdapterItemCallMessage.access$setStateSubscription$p(WidgetChatListAdapterItemCallMessage.this, subscription);
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;", "state", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<State, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            WidgetChatListAdapterItemCallMessage.access$handleState(WidgetChatListAdapterItemCallMessage.this, state);
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configureSubtitle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ long $callJoinedTimestampMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$callJoinedTimestampMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            String string = TimeUtils.toFriendlyString$default(TimeUtils.INSTANCE, this.$callJoinedTimestampMs, WidgetChatListAdapterItemCallMessage.access$getClock$p(WidgetChatListAdapterItemCallMessage.this).currentTimeMillis(), null, null, 12, null).toString();
            int iAccess$getMinWidthPxForTime = WidgetChatListAdapterItemCallMessage.access$getMinWidthPxForTime(WidgetChatListAdapterItemCallMessage.this, string);
            TextView textView = WidgetChatListAdapterItemCallMessage.access$getBinding$p(WidgetChatListAdapterItemCallMessage.this).d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
            textView.setText(string);
            TextView textView2 = WidgetChatListAdapterItemCallMessage.access$getBinding$p(WidgetChatListAdapterItemCallMessage.this).g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemUnjoinedCallDuration");
            textView2.setText(string);
            TextView textView3 = WidgetChatListAdapterItemCallMessage.access$getBinding$p(WidgetChatListAdapterItemCallMessage.this).g;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemUnjoinedCallDuration");
            TextView textView4 = WidgetChatListAdapterItemCallMessage.access$getBinding$p(WidgetChatListAdapterItemCallMessage.this).g;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemUnjoinedCallDuration");
            textView3.setMinWidth(textView4.getPaddingStart() + iAccess$getMinWidthPxForTime);
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$configureSubtitle$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetChatListAdapterItemCallMessage.access$setOngoingCallDurationSubscription$p(WidgetChatListAdapterItemCallMessage.this, subscription);
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$handleState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ CallStatus $callStatus;
        public final /* synthetic */ Message $message;

        public AnonymousClass1(CallStatus callStatus, Message message) {
            this.$callStatus = callStatus;
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemCallMessage.access$onItemClick(WidgetChatListAdapterItemCallMessage.this, this.$callStatus, this.$message.getChannelId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemCallMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "kotlin.jvm.PlatformType", "voiceParticipants", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage$observeState$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, State> {
        public final /* synthetic */ MessageEntry $messageEntry;

        public AnonymousClass1(MessageEntry messageEntry) {
            this.$messageEntry = messageEntry;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ State call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final State call2(Map<Long, StoreVoiceParticipants.VoiceUser> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "voiceParticipants");
            return new State(map, this.$messageEntry);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemCallMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_call, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_call_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_item_call_icon);
        if (imageView != null) {
            i = R.id.chat_list_adapter_item_call_participants;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chat_list_adapter_item_call_participants);
            if (recyclerView != null) {
                i = R.id.chat_list_adapter_item_call_subtitle;
                TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_call_subtitle);
                if (textView != null) {
                    i = R.id.chat_list_adapter_item_call_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.chat_list_adapter_item_call_title);
                    if (textView2 != null) {
                        i = R.id.chat_list_adapter_item_call_unjoined_ongoing_subtitle;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.chat_list_adapter_item_call_unjoined_ongoing_subtitle);
                        if (linearLayout != null) {
                            i = R.id.chat_list_adapter_item_unjoined_call_duration;
                            TextView textView3 = (TextView) view.findViewById(R.id.chat_list_adapter_item_unjoined_call_duration);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemCallBinding widgetChatListAdapterItemCallBinding = new WidgetChatListAdapterItemCallBinding((CardView) view, imageView, recyclerView, textView, textView2, linearLayout, textView3);
                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemCallBinding, "WidgetChatListAdapterIte…allBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemCallBinding;
                                this.clock = ClockFactory.get();
                                MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListAdapterItemCallParticipants");
                                this.usersAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
                                this.itemView.addOnAttachStateChangeListener(new AnonymousClass1());
                                recyclerView.setHasFixedSize(false);
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$clearSubscriptions(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        widgetChatListAdapterItemCallMessage.clearSubscriptions();
    }

    public static final /* synthetic */ WidgetChatListAdapterItemCallBinding access$getBinding$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.binding;
    }

    public static final /* synthetic */ Clock access$getClock$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.clock;
    }

    public static final /* synthetic */ int access$getMinWidthPxForTime(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, String str) {
        return widgetChatListAdapterItemCallMessage.getMinWidthPxForTime(str);
    }

    public static final /* synthetic */ Subscription access$getOngoingCallDurationSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.ongoingCallDurationSubscription;
    }

    public static final /* synthetic */ Subscription access$getStateSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.stateSubscription;
    }

    public static final /* synthetic */ void access$handleState(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, State state) {
        widgetChatListAdapterItemCallMessage.handleState(state);
    }

    public static final /* synthetic */ void access$onItemClick(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, CallStatus callStatus, long j) {
        widgetChatListAdapterItemCallMessage.onItemClick(callStatus, j);
    }

    public static final /* synthetic */ void access$resetCurrentChatListEntry(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        widgetChatListAdapterItemCallMessage.resetCurrentChatListEntry();
    }

    public static final /* synthetic */ void access$setOngoingCallDurationSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, Subscription subscription) {
        widgetChatListAdapterItemCallMessage.ongoingCallDurationSubscription = subscription;
    }

    public static final /* synthetic */ void access$setStateSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, Subscription subscription) {
        widgetChatListAdapterItemCallMessage.stateSubscription = subscription;
    }

    private final void clearSubscriptions() {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.stateSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    private final void configure(ChatListEntry data) {
        this.chatListEntry = data;
        Objects.requireNonNull(data, "null cannot be cast to non-null type com.discord.widgets.chat.list.entries.MessageEntry");
        clearSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observeState((MessageEntry) data))), WidgetChatListAdapterItemCallMessage.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    private final void configureSubtitle(MessageEntry messageEntry, CallStatus callStatus, Context context) {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Message message = messageEntry.getMessage();
        CharSequence charSequenceHumanizeDuration = DurationUtils.humanizeDuration(context, message.getCallDuration());
        Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp = message.getTimestamp();
        String string = TimeUtils.toReadableTimeString$default(contextX, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null).toString();
        LinearLayout linearLayout = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        linearLayout.setVisibility(callStatus == CallStatus.ACTIVE_UNJOINED ? 0 : 8);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
        LinearLayout linearLayout2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        textView.setVisibility((linearLayout2.getVisibility() == 0) ^ true ? 0 : 8);
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            UtcDateTime timestamp2 = message.getTimestamp();
            long dateTimeMillis = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
            Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n            .…0L, 1L, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableE), WidgetChatListAdapterItemCallMessage.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(dateTimeMillis), 58, (Object) null);
            return;
        }
        if (iOrdinal == 2) {
            TextView textView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemCallSubtitle");
            FormatUtils.n(textView2, R.string.call_ended_description, new Object[]{charSequenceHumanizeDuration, string}, null, 4);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            TextView textView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemCallSubtitle");
            FormatUtils.n(textView3, R.string.call_ended_description, new Object[]{charSequenceHumanizeDuration, string}, null, 4);
        }
    }

    private final List<CollapsedUser> createCallParticipantUsers(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, CallStatus callStatus, User messageAuthor) {
        if (callStatus == CallStatus.INACTIVE_JOINED || callStatus == CallStatus.INACTIVE_UNJOINED) {
            return CollectionsJVM.listOf(new CollapsedUser(messageAuthor, false, 0L, 6, null));
        }
        List list = _Collections.toList(voiceParticipants.values());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getVoiceState() != null) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i = size - 3;
        Iterator<Integer> it2 = _Ranges.until(0, Math.min(size, 3)).iterator();
        while (it2.hasNext()) {
            arrayList2.add(new CollapsedUser(((StoreVoiceParticipants.VoiceUser) arrayList.get(((Iterators4) it2).nextInt())).getUser(), false, 0L, 6, null));
        }
        if (i > 0) {
            arrayList2.add(CollapsedUser.INSTANCE.createEmptyUser(i));
        }
        return arrayList2;
    }

    private final Drawable getCallDrawable(CallStatus callStatus, Context context) {
        Drawable drawable;
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            drawable = AppCompatResources.getDrawable(context, R.drawable.ic_call_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompat2.setTint(drawable, ColorCompat.getColor(context, R.color.status_green_600), false);
        } else if (iOrdinal == 2) {
            drawable = AppCompatResources.getDrawable(context, R.drawable.ic_call_disconnect_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompat2.setTint(drawable, ColorCompat.getColor(context, R.color.status_red), false);
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            drawable = AppCompatResources.getDrawable(context, R.drawable.ic_call_24dp);
            if (drawable == null) {
                return null;
            }
            ColorCompat2.setTint(drawable, ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal), false);
        }
        return drawable;
    }

    private final CallStatus getCallStatus(Message message, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants) {
        MessageCall call = message.getCall();
        if (call == null) {
            return CallStatus.INACTIVE_UNJOINED;
        }
        long userId = ((WidgetChatListAdapter) this.adapter).getData().getUserId();
        List list = _Collections.toList(voiceParticipants.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) ((Map.Entry) next).getValue()).getVoiceState() != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((Number) ((Map.Entry) it2.next()).getKey()).longValue()));
        }
        boolean zContains = call.b().contains(Long.valueOf(userId));
        boolean zContains2 = arrayList2.contains(Long.valueOf(userId));
        boolean z2 = call.getEndedTimestamp() == null;
        return (z2 && zContains2) ? CallStatus.ACTIVE_JOINED : z2 ? CallStatus.ACTIVE_UNJOINED : zContains ? CallStatus.INACTIVE_JOINED : CallStatus.INACTIVE_UNJOINED;
    }

    private final int getMinWidthPxForTime(String time) {
        int i = 0;
        for (int i2 = 0; i2 < time.length(); i2++) {
            if (time.charAt(i2) == ':') {
                i++;
            }
        }
        return (i * DimenUtils.dpToPixels(3.047619f)) + ((time.length() - i) * DimenUtils.dpToPixels(7.6190476f));
    }

    private final CharSequence getTitleString(CallStatus callStatus, Resources resources) {
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return FormatUtils.i(resources, R.string.ongoing_call, new Object[0], null, 4);
        }
        if (iOrdinal == 2) {
            return FormatUtils.i(resources, R.string.missed_call, new Object[0], null, 4);
        }
        if (iOrdinal == 3) {
            return FormatUtils.i(resources, R.string.call_ended, new Object[0], null, 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleState(State state) {
        MessageEntry messageEntry = state.getMessageEntry();
        Message message = messageEntry.getMessage();
        Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = state.getVoiceParticipants();
        CallStatus callStatus = getCallStatus(message, voiceParticipants);
        com.discord.api.user.User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        List<CollapsedUser> listCreateCallParticipantUsers = createCallParticipantUsers(voiceParticipants, callStatus, new CoreUser(author));
        configureSubtitle(messageEntry, callStatus, outline.I(this.binding.d, "binding.chatListAdapterItemCallSubtitle", "binding.chatListAdapterItemCallSubtitle.context"));
        this.binding.f2314b.setImageDrawable(getCallDrawable(callStatus, outline.x(this.itemView, "itemView", "itemView.context")));
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallTitle");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getTitleString(callStatus, resources));
        this.itemView.setOnClickListener(new AnonymousClass1(callStatus, message));
        this.usersAdapter.setData(_Collections.toList(listCreateCallParticipantUsers));
    }

    private final Observable<State> observeState(MessageEntry messageEntry) {
        Observable observableG = StoreStream.INSTANCE.getVoiceParticipants().get(messageEntry.getMessage().getChannelId()).G(new AnonymousClass1(messageEntry));
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream.getVoicePart…, messageEntry)\n        }");
        return observableG;
    }

    private final void onItemClick(CallStatus callStatus, long channelId) {
        ((WidgetChatListAdapter) this.adapter).getEventHandler().onCallMessageClicked(channelId, callStatus);
    }

    private final void resetCurrentChatListEntry() {
        ChatListEntry chatListEntry = this.chatListEntry;
        if (chatListEntry != null) {
            configure(chatListEntry);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        clearSubscriptions();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        resetCurrentChatListEntry();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        configure(data);
    }
}
