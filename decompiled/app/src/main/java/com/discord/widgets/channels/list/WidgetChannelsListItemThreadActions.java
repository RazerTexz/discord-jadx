package com.discord.widgets.channels.list;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemThreadActionsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetThreadArchiveActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetChannelsListItemThreadActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b%\u0010\u001eJ\u0015\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "", "configureUI", "(Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;)V", "Lcom/discord/api/channel/Channel;", "channel", "", "isMuted", "Landroid/content/Context;", "context", "", "getMuteThreadText", "(Lcom/discord/api/channel/Channel;ZLandroid/content/Context;)Ljava/lang/CharSequence;", "", "getMuteIconResId", "(ZLandroid/content/Context;)I", "leaveThread", "(Lcom/discord/api/channel/Channel;)V", "unlockThread", "unarchiveThread", "(Lcom/discord/api/channel/Channel;Z)V", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "onPause", "()V", "Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", "binding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelsListItemThreadActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "", WidgetChannelsListItemThreadActions.INTENT_EXTRA_CHANNEL_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions = new WidgetChannelsListItemThreadActions();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChannelsListItemThreadActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            widgetChannelsListItemThreadActions.setArguments(bundle);
            widgetChannelsListItemThreadActions.show(fragmentManager, WidgetChannelsListItemThreadActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0082\b\u0018\u0000 >2\u00020\u0001:\u0001>Be\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0012\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0014J\u0084\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b)\u0010\u000eJ\u001a\u0010+\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010\u0011R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b4\u0010\u0014R\u0019\u0010\u001d\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\u000eR\u0019\u0010\u001f\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b\u001f\u0010\u0014R\u0019\u0010 \u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b \u0010\u0014R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b7\u0010\u0007R\u0019\u0010#\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b#\u00103\u001a\u0004\b#\u0010\u0014R\u0019\u0010!\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b8\u0010\u0014R\u0019\u00109\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b9\u00103\u001a\u0004\b9\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010:\u001a\u0004\b;\u0010\n¨\u0006?"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "component4", "", "component5", "()I", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "component6", "()Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "", "component7", "()Z", "component8", "component9", "component10", "component11", "meUser", "channel", "guild", "parentChannel", "notificationSetting", "joinedThread", "isActiveThread", "isModerator", "canManageThread", "canUnarchiveThread", "isMuted", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;ILcom/discord/stores/StoreThreadsJoined$JoinedThread;ZZZZZ)Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "getJoinedThread", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/user/MeUser;", "getMeUser", "Z", "getCanUnarchiveThread", "I", "getNotificationSetting", "getParentChannel", "getCanManageThread", "isDeveloper", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;ILcom/discord/stores/StoreThreadsJoined$JoinedThread;ZZZZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageThread;
        private final boolean canUnarchiveThread;
        private final Channel channel;
        private final Guild guild;
        private final boolean isActiveThread;
        private final boolean isDeveloper;
        private final boolean isModerator;
        private final boolean isMuted;
        private final StoreThreadsJoined.JoinedThread joinedThread;
        private final MeUser meUser;
        private final int notificationSetting;
        private final Channel parentChannel;

        /* compiled from: WidgetChannelsListItemThreadActions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(WidgetChannelsListItemThreadActions2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined.JoinedThread joinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.meUser = meUser;
            this.channel = channel;
            this.guild = guild;
            this.parentChannel = channel2;
            this.notificationSetting = i;
            this.joinedThread = joinedThread;
            this.isActiveThread = z2;
            this.isModerator = z3;
            this.canManageThread = z4;
            this.canUnarchiveThread = z5;
            this.isMuted = z6;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined.JoinedThread joinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
            return model.copy((i2 & 1) != 0 ? model.meUser : meUser, (i2 & 2) != 0 ? model.channel : channel, (i2 & 4) != 0 ? model.guild : guild, (i2 & 8) != 0 ? model.parentChannel : channel2, (i2 & 16) != 0 ? model.notificationSetting : i, (i2 & 32) != 0 ? model.joinedThread : joinedThread, (i2 & 64) != 0 ? model.isActiveThread : z2, (i2 & 128) != 0 ? model.isModerator : z3, (i2 & 256) != 0 ? model.canManageThread : z4, (i2 & 512) != 0 ? model.canUnarchiveThread : z5, (i2 & 1024) != 0 ? model.isMuted : z6);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getCanUnarchiveThread() {
            return this.canUnarchiveThread;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component4, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* renamed from: component5, reason: from getter */
        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        /* renamed from: component6, reason: from getter */
        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsActiveThread() {
            return this.isActiveThread;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final Model copy(MeUser meUser, Channel channel, Guild guild, Channel parentChannel, int notificationSetting, StoreThreadsJoined.JoinedThread joinedThread, boolean isActiveThread, boolean isModerator, boolean canManageThread, boolean canUnarchiveThread, boolean isMuted) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(meUser, channel, guild, parentChannel, notificationSetting, joinedThread, isActiveThread, isModerator, canManageThread, canUnarchiveThread, isMuted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.meUser, model.meUser) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.parentChannel, model.parentChannel) && this.notificationSetting == model.notificationSetting && Intrinsics3.areEqual(this.joinedThread, model.joinedThread) && this.isActiveThread == model.isActiveThread && this.isModerator == model.isModerator && this.canManageThread == model.canManageThread && this.canUnarchiveThread == model.canUnarchiveThread && this.isMuted == model.isMuted;
        }

        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final boolean getCanUnarchiveThread() {
            return this.canUnarchiveThread;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode4 = (((iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31) + this.notificationSetting) * 31;
            StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
            int iHashCode5 = (iHashCode4 + (joinedThread != null ? joinedThread.hashCode() : 0)) * 31;
            boolean z2 = this.isActiveThread;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            boolean z3 = this.isModerator;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canManageThread;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.canUnarchiveThread;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.isMuted;
            return i8 + (z6 ? 1 : z6 ? 1 : 0);
        }

        public final boolean isActiveThread() {
            return this.isActiveThread;
        }

        /* renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(meUser=");
            sbU.append(this.meUser);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", parentChannel=");
            sbU.append(this.parentChannel);
            sbU.append(", notificationSetting=");
            sbU.append(this.notificationSetting);
            sbU.append(", joinedThread=");
            sbU.append(this.joinedThread);
            sbU.append(", isActiveThread=");
            sbU.append(this.isActiveThread);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", canManageThread=");
            sbU.append(this.canManageThread);
            sbU.append(", canUnarchiveThread=");
            sbU.append(this.canUnarchiveThread);
            sbU.append(", isMuted=");
            return outline.O(sbU, this.isMuted, ")");
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "it", "", "invoke", "(Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            WidgetChannelsListItemThreadActions.access$configureUI(WidgetChannelsListItemThreadActions.this, model);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getMessageAck().ack(this.$this_configureUI.getChannel().getId(), false, true);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (this.$this_configureUI.isMuted()) {
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                Context contextRequireContext = WidgetChannelsListItemThreadActions.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                StoreUserGuildSettings.setChannelMuted$default(userGuildSettings, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, null, 8, null);
                return;
            }
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(id2, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass3(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context contextRequireContext = WidgetChannelsListItemThreadActions.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, 4, null);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadSettings.Companion companion = WidgetThreadSettings.INSTANCE;
            long id2 = this.$this_configureUI.getChannel().getId();
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            companion.launch(id2, context);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadArchiveActions.Companion companion = WidgetThreadArchiveActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetChannelsListItemThreadActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$this_configureUI.getChannel().getId(), this.$this_configureUI.getChannel().getGuildId());
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass6(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelsListItemThreadActions.access$unarchiveThread(WidgetChannelsListItemThreadActions.this, this.$this_configureUI.getChannel(), this.$this_configureUI.isModerator());
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass7(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelsListItemThreadActions.access$leaveThread(WidgetChannelsListItemThreadActions.this, this.$this_configureUI.getChannel());
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $this_configureUI;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(Model model) {
            super(1);
            this.$this_configureUI = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppToast.c(context, String.valueOf(this.$this_configureUI.getChannel().getId()), 0, 4);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$leaveThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
            AppToast.g(WidgetChannelsListItemThreadActions.this.getContext(), abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, null, 12);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$unarchiveThread$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetChannelsListItemThreadActions.this.dismiss();
        }
    }

    public WidgetChannelsListItemThreadActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsListItemThreadActions3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Model model) throws Resources.NotFoundException {
        widgetChannelsListItemThreadActions.configureUI(model);
    }

    public static final /* synthetic */ void access$leaveThread(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Channel channel) {
        widgetChannelsListItemThreadActions.leaveThread(channel);
    }

    public static final /* synthetic */ void access$unarchiveThread(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Channel channel, boolean z2) {
        widgetChannelsListItemThreadActions.unarchiveThread(channel, z2);
    }

    private final void configureUI(Model model) throws Resources.NotFoundException {
        ThreadMetadata threadMetadata;
        ThreadMetadata threadMetadata2;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListItemThreadActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        TextView textView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelsListItemThreadActionsMarkAsRead");
        setOnClickAndDismissListener(textView2, new AnonymousClass1(model));
        TextView textView3 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelsListItemThreadActionsMute");
        Channel channel2 = model.getChannel();
        boolean zIsMuted = model.isMuted();
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        textView3.setText(getMuteThreadText(channel2, zIsMuted, contextRequireContext2));
        TextView textView4 = getBinding().l;
        boolean zIsMuted2 = model.isMuted();
        Context contextRequireContext3 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        textView4.setCompoundDrawablesWithIntrinsicBounds(getMuteIconResId(zIsMuted2, contextRequireContext3), 0, 0, 0);
        TextView textView5 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.channelsListItemThreadActionsMute");
        setOnClickAndDismissListener(textView5, new AnonymousClass2(model));
        getBinding().d.setOnClickListener(new AnonymousClass3(model));
        View view = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelsListItemThreadActionsDivider");
        view.setVisibility(model.isActiveThread() ? 0 : 8);
        TextView textView6 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.channelsListItemThreadActionsEdit");
        textView6.setVisibility(model.getCanManageThread() ? 0 : 8);
        TextView textView7 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelsListItemThreadActionsEdit");
        setOnClickAndDismissListener(textView7, new AnonymousClass4(model));
        boolean z2 = model.getCanManageThread() && ((threadMetadata2 = model.getChannel().getThreadMetadata()) == null || !threadMetadata2.getArchived());
        LinearLayout linearLayout = getBinding().f2297b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelsListItem…eadActionsArchiveSettings");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Context contextRequireContext4 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
            ThreadMetadata threadMetadata3 = model.getChannel().getThreadMetadata();
            Intrinsics3.checkNotNull(threadMetadata3);
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(contextRequireContext4, threadMetadata3.getAutoArchiveDuration());
            TextView textView8 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.channelsListItem…sArchiveSettingsSubheader");
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            textView8.setText(FormatUtils.k(this, R.string.auto_archive_thread_after, new Object[]{lowerCase}, null, 4));
        }
        LinearLayout linearLayout2 = getBinding().f2297b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelsListItem…eadActionsArchiveSettings");
        setOnClickAndDismissListener(linearLayout2, new AnonymousClass5(model));
        TextView textView9 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.channelsListItemThreadActionsUnarchive");
        textView9.setVisibility(model.getCanUnarchiveThread() && (threadMetadata = model.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() ? 0 : 8);
        getBinding().n.setOnClickListener(new AnonymousClass6(model));
        TextView textView10 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.channelsListItemThreadActionsLeave");
        textView10.setVisibility(model.getJoinedThread() != null ? 0 : 8);
        getBinding().j.setOnClickListener(new AnonymousClass7(model));
        View view2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.channelsListItem…adActionsDeveloperDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView11 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.channelsListItemThreadActionsCopyId");
        textView11.setVisibility(model.getIsDeveloper() ? 0 : 8);
        TextView textView12 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.channelsListItemThreadActionsCopyId");
        setOnClickAndDismissListener(textView12, new AnonymousClass8(model));
    }

    private final WidgetChannelsListItemThreadActionsBinding getBinding() {
        return (WidgetChannelsListItemThreadActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getMuteIconResId(boolean isMuted, Context context) {
        return DrawableCompat.getThemedDrawableRes$default(context, isMuted ? R.attr.ic_channel_muted : R.attr.ic_channel_mute, 0, 2, (Object) null);
    }

    private final CharSequence getMuteThreadText(Channel channel, boolean isMuted, Context context) {
        return isMuted ? FormatUtils.h(context, R.string.unmute, new Object[0], null, 4) : FormatUtils.h(context, R.string.mute_channel, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
    }

    private final void leaveThread(Channel channel) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channel.getId(), "Context Menu"), false, 1, null), this, null, 2, null), getContext(), "REST: leaveThread", (Function1) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    private final void unarchiveThread(Channel channel, boolean unlockThread) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.FALSE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, unlockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), getContext(), "REST: unarchiveThread", (Function1) null, new AnonymousClass2(), new AnonymousClass1(), (Function0) null, (Function0) null, 100, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemThreadActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channels_list_item_thread_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
