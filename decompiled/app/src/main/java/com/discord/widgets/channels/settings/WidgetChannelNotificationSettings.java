package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelNotificationSettingsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.notifications.NotificationUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetChannelNotificationSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u000eJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "", "configureUI", "(Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;)V", "configureChannel", "configureGuildForumChannel", "configureNotificationRadios", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", "binding", "Lcom/discord/views/RadioManager;", "notificationSettingsRadioManager", "Lcom/discord/views/RadioManager;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelNotificationSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_SHOW_SYSTEM_SETTINGS = "SHOW_SYSTEM_SETTING";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;

    /* compiled from: WidgetChannelNotificationSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "showSystemSetting", "", "launch", "(Landroid/content/Context;JZ)V", "", "INTENT_SHOW_SYSTEM_SETTINGS", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.launch(context, j, z2);
        }

        public final void launch(Context context, long channelId, boolean showSystemSetting) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra(WidgetChannelNotificationSettings.INTENT_SHOW_SYSTEM_SETTINGS, showSystemSetting);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…TINGS, showSystemSetting)");
            AppScreen2.d(context, WidgetChannelNotificationSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelNotificationSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b-\b\u0082\b\u0018\u0000 92\u00020\u0001:\u00019Bm\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u008c\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b$\u0010\u000bJ\u0010\u0010%\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b%\u0010\u000fJ\u001a\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R!\u0010\u0019\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u000bR\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010\u000fR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0011R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b/\u0010\u0011R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\u0007R\u0019\u0010 \u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u00102\u001a\u0004\b \u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b4\u0010\u0007R\u0019\u0010!\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b5\u0010\u0007R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b6\u0010\u0011¨\u0006:"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "Lcom/discord/primitives/UtcTimestamp;", "component3", "()Ljava/lang/String;", "component4", "", "component5", "()I", "component6", "()Ljava/lang/Integer;", "component7", "component8", "component9", "component10", "component11", "channel", "channelIsMuted", "channelMuteEndTime", "isGuildMuted", "notificationSetting", "channelOverrideFlags", "forumPostNotificationSetting", "parentNotificationSetting", "notificationSettingIsInherited", "isAboveNotifyAllSize", "canAccessRedesignedForumChannels", "copy", "(Lcom/discord/api/channel/Channel;ZLjava/lang/String;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZZ)Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getChannelMuteEndTime", "I", "getNotificationSetting", "Ljava/lang/Integer;", "getForumPostNotificationSetting", "getParentNotificationSetting", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "getNotificationSettingIsInherited", "getChannelIsMuted", "getCanAccessRedesignedForumChannels", "getChannelOverrideFlags", "<init>", "(Lcom/discord/api/channel/Channel;ZLjava/lang/String;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final float RADIO_DIMMED_ALPHA = 0.3f;
        public static final float RADIO_OPAQUE_ALPHA = 1.0f;
        private final boolean canAccessRedesignedForumChannels;
        private final Channel channel;
        private final boolean channelIsMuted;
        private final String channelMuteEndTime;
        private final Integer channelOverrideFlags;
        private final Integer forumPostNotificationSetting;
        private final boolean isAboveNotifyAllSize;
        private final boolean isGuildMuted;
        private final int notificationSetting;
        private final boolean notificationSettingIsInherited;
        private final Integer parentNotificationSetting;

        /* compiled from: WidgetChannelNotificationSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "get", "(J)Lrx/Observable;", "", "RADIO_DIMMED_ALPHA", "F", "RADIO_OPAQUE_ALPHA", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(WidgetChannelNotificationSettings3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …ust(null)\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationBuffered(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, boolean z2, String str, boolean z3, int i, Integer num, Integer num2, Integer num3, boolean z4, boolean z5, boolean z6) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.channelIsMuted = z2;
            this.channelMuteEndTime = str;
            this.isGuildMuted = z3;
            this.notificationSetting = i;
            this.channelOverrideFlags = num;
            this.forumPostNotificationSetting = num2;
            this.parentNotificationSetting = num3;
            this.notificationSettingIsInherited = z4;
            this.isAboveNotifyAllSize = z5;
            this.canAccessRedesignedForumChannels = z6;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, boolean z2, String str, boolean z3, int i, Integer num, Integer num2, Integer num3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
            return model.copy((i2 & 1) != 0 ? model.channel : channel, (i2 & 2) != 0 ? model.channelIsMuted : z2, (i2 & 4) != 0 ? model.channelMuteEndTime : str, (i2 & 8) != 0 ? model.isGuildMuted : z3, (i2 & 16) != 0 ? model.notificationSetting : i, (i2 & 32) != 0 ? model.channelOverrideFlags : num, (i2 & 64) != 0 ? model.forumPostNotificationSetting : num2, (i2 & 128) != 0 ? model.parentNotificationSetting : num3, (i2 & 256) != 0 ? model.notificationSettingIsInherited : z4, (i2 & 512) != 0 ? model.isAboveNotifyAllSize : z5, (i2 & 1024) != 0 ? model.canAccessRedesignedForumChannels : z6);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getChannelIsMuted() {
            return this.channelIsMuted;
        }

        /* renamed from: component3, reason: from getter */
        public final String getChannelMuteEndTime() {
            return this.channelMuteEndTime;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsGuildMuted() {
            return this.isGuildMuted;
        }

        /* renamed from: component5, reason: from getter */
        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getChannelOverrideFlags() {
            return this.channelOverrideFlags;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getForumPostNotificationSetting() {
            return this.forumPostNotificationSetting;
        }

        /* renamed from: component8, reason: from getter */
        public final Integer getParentNotificationSetting() {
            return this.parentNotificationSetting;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getNotificationSettingIsInherited() {
            return this.notificationSettingIsInherited;
        }

        public final Model copy(Channel channel, boolean channelIsMuted, String channelMuteEndTime, boolean isGuildMuted, int notificationSetting, Integer channelOverrideFlags, Integer forumPostNotificationSetting, Integer parentNotificationSetting, boolean notificationSettingIsInherited, boolean isAboveNotifyAllSize, boolean canAccessRedesignedForumChannels) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(channel, channelIsMuted, channelMuteEndTime, isGuildMuted, notificationSetting, channelOverrideFlags, forumPostNotificationSetting, parentNotificationSetting, notificationSettingIsInherited, isAboveNotifyAllSize, canAccessRedesignedForumChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && this.channelIsMuted == model.channelIsMuted && Intrinsics3.areEqual(this.channelMuteEndTime, model.channelMuteEndTime) && this.isGuildMuted == model.isGuildMuted && this.notificationSetting == model.notificationSetting && Intrinsics3.areEqual(this.channelOverrideFlags, model.channelOverrideFlags) && Intrinsics3.areEqual(this.forumPostNotificationSetting, model.forumPostNotificationSetting) && Intrinsics3.areEqual(this.parentNotificationSetting, model.parentNotificationSetting) && this.notificationSettingIsInherited == model.notificationSettingIsInherited && this.isAboveNotifyAllSize == model.isAboveNotifyAllSize && this.canAccessRedesignedForumChannels == model.canAccessRedesignedForumChannels;
        }

        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getChannelIsMuted() {
            return this.channelIsMuted;
        }

        public final String getChannelMuteEndTime() {
            return this.channelMuteEndTime;
        }

        public final Integer getChannelOverrideFlags() {
            return this.channelOverrideFlags;
        }

        public final Integer getForumPostNotificationSetting() {
            return this.forumPostNotificationSetting;
        }

        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        public final boolean getNotificationSettingIsInherited() {
            return this.notificationSettingIsInherited;
        }

        public final Integer getParentNotificationSetting() {
            return this.parentNotificationSetting;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.channelIsMuted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            String str = this.channelMuteEndTime;
            int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            boolean z3 = this.isGuildMuted;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (((iHashCode2 + i3) * 31) + this.notificationSetting) * 31;
            Integer num = this.channelOverrideFlags;
            int iHashCode3 = (i4 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.forumPostNotificationSetting;
            int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.parentNotificationSetting;
            int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31;
            boolean z4 = this.notificationSettingIsInherited;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (iHashCode5 + i5) * 31;
            boolean z5 = this.isAboveNotifyAllSize;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.canAccessRedesignedForumChannels;
            return i8 + (z6 ? 1 : z6 ? 1 : 0);
        }

        public final boolean isAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        public final boolean isGuildMuted() {
            return this.isGuildMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", channelIsMuted=");
            sbU.append(this.channelIsMuted);
            sbU.append(", channelMuteEndTime=");
            sbU.append(this.channelMuteEndTime);
            sbU.append(", isGuildMuted=");
            sbU.append(this.isGuildMuted);
            sbU.append(", notificationSetting=");
            sbU.append(this.notificationSetting);
            sbU.append(", channelOverrideFlags=");
            sbU.append(this.channelOverrideFlags);
            sbU.append(", forumPostNotificationSetting=");
            sbU.append(this.forumPostNotificationSetting);
            sbU.append(", parentNotificationSetting=");
            sbU.append(this.parentNotificationSetting);
            sbU.append(", notificationSettingIsInherited=");
            sbU.append(this.notificationSettingIsInherited);
            sbU.append(", isAboveNotifyAllSize=");
            sbU.append(this.isAboveNotifyAllSize);
            sbU.append(", canAccessRedesignedForumChannels=");
            return outline.O(sbU, this.canAccessRedesignedForumChannels, ")");
        }
    }

    /* compiled from: WidgetChannelNotificationSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isChecked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$configureGuildForumChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $this_configureGuildForumChannel;

        public AnonymousClass1(Model model) {
            this.$this_configureGuildForumChannel = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
            int i = bool.booleanValue() ? ModelNotificationSettings.FORUM_THREAD_CREATED_ON : ModelNotificationSettings.FORUM_THREAD_CREATED_OFF;
            Integer channelOverrideFlags = this.$this_configureGuildForumChannel.getChannelOverrideFlags();
            int iIntValue = i | ((channelOverrideFlags != null ? channelOverrideFlags.intValue() : 0) & (~ModelNotificationSettings.FORUM_THREAD_CREATED_MASK));
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetChannelNotificationSettings.access$getBinding$p(WidgetChannelNotificationSettings.this).d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.frequencyAllPosts");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.frequencyAllPosts.context");
            userGuildSettings.setChannelNotificationFlags(context, this.$this_configureGuildForumChannel.getChannel(), iIntValue);
        }
    }

    /* compiled from: WidgetChannelNotificationSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "Lcom/discord/views/CheckedSetting;", "radio", "", "type", "", "invoke", "(Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;Lcom/discord/views/CheckedSetting;I)V", "configureNotificationRadio"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$configureNotificationRadios$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Model, CheckedSetting, Integer, Unit> {
        public final /* synthetic */ Ref$IntRef $notificationSetting;

        /* compiled from: WidgetChannelNotificationSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$configureNotificationRadios$1$1, reason: invalid class name and collision with other inner class name */
        public static final class ViewOnClickListenerC02491 implements View.OnClickListener {
            public final /* synthetic */ Model $this_configureNotificationRadio;
            public final /* synthetic */ int $type;

            public ViewOnClickListenerC02491(Model model, int i) {
                this.$this_configureNotificationRadio = model;
                this.$type = i;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserGuildSettings().setChannelFrequency(outline.x(view, "it", "it.context"), this.$this_configureNotificationRadio.getChannel(), this.$type);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$IntRef ref$IntRef) {
            super(3);
            this.$notificationSetting = ref$IntRef;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Model model, CheckedSetting checkedSetting, Integer num) {
            invoke(model, checkedSetting, num.intValue());
            return Unit.a;
        }

        public final void invoke(Model model, CheckedSetting checkedSetting, int i) {
            Intrinsics3.checkNotNullParameter(model, "$this$configureNotificationRadio");
            Intrinsics3.checkNotNullParameter(checkedSetting, "radio");
            if (model.isGuildMuted() || model.getChannelIsMuted()) {
                checkedSetting.b(R.string.channel_or_guild_muted);
            } else {
                checkedSetting.e(new ViewOnClickListenerC02491(model, i));
            }
            if (model.isAboveNotifyAllSize() && i == ModelNotificationSettings.FREQUENCY_ALL) {
                CharSequence charSequenceK = FormatUtils.k(WidgetChannelNotificationSettings.this, R.string.large_guild_notify_all_messages_description, new Object[0], null, 4);
                int i2 = CheckedSetting.j;
                checkedSetting.h(charSequenceK, false);
            } else {
                int i3 = CheckedSetting.j;
                checkedSetting.h(null, false);
            }
            boolean z2 = this.$notificationSetting.element == i;
            checkedSetting.setButtonAlpha((z2 && model.getNotificationSettingIsInherited()) ? 0.3f : 1.0f);
            if (z2) {
                WidgetChannelNotificationSettings.access$getNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings.this).a(checkedSetting);
            }
        }
    }

    /* compiled from: WidgetChannelNotificationSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationUtils.INSTANCE.showNotificationPage(WidgetChannelNotificationSettings.this);
        }
    }

    /* compiled from: WidgetChannelNotificationSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;", "it", "", "invoke", "(Lcom/discord/widgets/channels/settings/WidgetChannelNotificationSettings$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$onViewBoundOrOnResume$2, reason: invalid class name */
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
            if (model != null) {
                WidgetChannelNotificationSettings.access$configureUI(WidgetChannelNotificationSettings.this, model);
                return;
            }
            FragmentActivity activity = WidgetChannelNotificationSettings.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetChannelNotificationSettings() {
        super(R.layout.widget_channel_notification_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelNotificationSettings4.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelNotificationSettings widgetChannelNotificationSettings, Model model) {
        widgetChannelNotificationSettings.configureUI(model);
    }

    public static final /* synthetic */ WidgetChannelNotificationSettingsBinding access$getBinding$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        return widgetChannelNotificationSettings.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        RadioManager radioManager = widgetChannelNotificationSettings.notificationSettingsRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ void access$setNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings, RadioManager radioManager) {
        widgetChannelNotificationSettings.notificationSettingsRadioManager = radioManager;
    }

    private final void configureChannel(Model model) {
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.forumChannelNotificationSettings");
        linearLayout.setVisibility(8);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.frequencySubheader");
        textView.setVisibility(8);
        getBinding().i.setText(R.string.form_label_notification_frequency);
    }

    private final void configureGuildForumChannel(Model model) {
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.forumChannelNotificationSettings");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.frequencySubheader");
        textView.setVisibility(0);
        getBinding().e.setText(R.string.forum_message_notifications);
        getBinding().i.setText(R.string.forum_message_notifications_description);
        Integer parentNotificationSetting = model.getParentNotificationSetting();
        boolean z3 = parentNotificationSetting != null && parentNotificationSetting.intValue() == ModelNotificationSettings.FREQUENCY_ALL;
        Integer forumPostNotificationSetting = model.getForumPostNotificationSetting();
        int iIntValue = forumPostNotificationSetting != null ? forumPostNotificationSetting.intValue() : ModelNotificationSettings.FREQUENCY_UNSET;
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.frequencyAllPosts");
        if (iIntValue == ModelNotificationSettings.FREQUENCY_UNSET) {
            z2 = z3;
        } else if (iIntValue == ModelNotificationSettings.FORUM_THREAD_CREATED_ON) {
            z2 = true;
        }
        checkedSetting.setChecked(z2);
        getBinding().d.setOnCheckedListener(new AnonymousClass1(model));
    }

    private final void configureNotificationRadios(Model model) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = model.getNotificationSetting();
        if (ChannelUtils.D(model.getChannel()) && ref$IntRef.element == ModelNotificationSettings.FREQUENCY_ALL) {
            ref$IntRef.element = ModelNotificationSettings.FREQUENCY_MENTIONS;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$IntRef);
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.frequencyRadioAll");
        checkedSetting.setVisibility(ChannelUtils.F(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().g;
        String string = requireContext().getString(ChannelUtils.D(model.getChannel()) ? R.string.form_label_live_stages_only : R.string.form_label_only_mentions);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…s\n            }\n        )");
        checkedSetting2.setText(FormatUtils.l(string, new Object[0], null, 2));
        CheckedSetting checkedSetting3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.frequencyRadioAll");
        anonymousClass1.invoke(model, checkedSetting3, ModelNotificationSettings.FREQUENCY_ALL);
        CheckedSetting checkedSetting4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.frequencyRadioMentions");
        anonymousClass1.invoke(model, checkedSetting4, ModelNotificationSettings.FREQUENCY_MENTIONS);
        CheckedSetting checkedSetting5 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.frequencyRadioNothing");
        anonymousClass1.invoke(model, checkedSetting5, ModelNotificationSettings.FREQUENCY_NOTHING);
    }

    private final void configureUI(Model model) {
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        boolean z2 = true;
        NotificationMuteSettingsView.ViewState viewState = new NotificationMuteSettingsView.ViewState(model.getChannelIsMuted(), model.getChannelMuteEndTime(), ChannelUtils.F(model.getChannel()) ? FormatUtils.h(requireContext(), R.string.mute_channel, new Object[]{ChannelUtils.e(model.getChannel(), requireContext(), false, 2)}, null, 4) : FormatUtils.h(requireContext(), R.string.mute_category, new Object[0], null, 4), ChannelUtils.F(model.getChannel()) ? FormatUtils.h(requireContext(), R.string.unmute_channel, new Object[]{ChannelUtils.e(model.getChannel(), requireContext(), false, 2)}, null, 4) : FormatUtils.h(requireContext(), R.string.unmute_category, new Object[0], null, 4), FormatUtils.h(requireContext(), R.string.form_label_mobile_channel_muted, new Object[0], null, 4), ChannelUtils.F(model.getChannel()) ? R.string.form_label_mobile_channel_muted_until : R.string.form_label_mobile_category_muted_until, ChannelUtils.F(model.getChannel()) ? FormatUtils.h(requireContext(), R.string.form_label_mobile_channel_override_mute, new Object[0], null, 4) : FormatUtils.h(requireContext(), R.string.form_label_mobile_category_override_mute, new Object[0], null, 4));
        WidgetChannelNotificationSettings5 widgetChannelNotificationSettings5 = new WidgetChannelNotificationSettings5(this, model);
        WidgetChannelNotificationSettings6 widgetChannelNotificationSettings6 = new WidgetChannelNotificationSettings6(this, model);
        if (!ChannelUtils.F(model.getChannel()) && !ChannelUtils.k(model.getChannel())) {
            z2 = false;
        }
        NotificationMuteSettingsView notificationMuteSettingsView = getBinding().k;
        notificationMuteSettingsView.setVisibility(z2 ? 0 : 8);
        notificationMuteSettingsView.updateView(viewState, widgetChannelNotificationSettings5, widgetChannelNotificationSettings6);
        View view = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.frequencyTopDivider");
        view.setVisibility(z2 ? 0 : 8);
        configureNotificationRadios(model);
        if (ChannelUtils.q(model.getChannel()) && model.getCanAccessRedesignedForumChannels()) {
            configureGuildForumChannel(model);
        } else {
            configureChannel(model);
        }
    }

    private final WidgetChannelNotificationSettingsBinding getBinding() {
        return (WidgetChannelNotificationSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_settings);
        this.notificationSettingsRadioManager = new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().f, getBinding().g, getBinding().h}));
        LinearLayout linearLayout = getBinding().f2262b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelNotificationSettingsSystem");
        linearLayout.setVisibility(getMostRecentIntent().getBooleanExtra(INTENT_SHOW_SYSTEM_SETTINGS, false) ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        getBinding().f2262b.setOnClickListener(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), WidgetChannelNotificationSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
