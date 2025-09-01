package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetChannelSettingsCannotDeleteBinding;
import b.a.i.WidgetChannelSettingsDeleteBinding;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTextChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetTextChannelSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u000234B\u0007¢\u0006\u0004\b2\u0010(J\u0015\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000b\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J_\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "", "configureUI", "(Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;)V", "", "Lcom/google/android/material/radiobutton/MaterialRadioButton;", "", "durationMap", "newDuration", "updateRadioState", "(Ljava/util/Map;I)V", "Lcom/discord/api/channel/Channel;", "channel", "confirmDelete", "(Lcom/discord/api/channel/Channel;)V", "", "isPublicGuildRulesChannel", "cannotDeleteWarn", "(Z)V", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_NAME, "type", ModelAuditLogEntry.CHANGE_KEY_TOPIC, ModelAuditLogEntry.CHANGE_KEY_NSFW, "rateLimit", "defaultAutoArchiveDuration", "saveChannel", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "cooldownSecs", "setSlowmodeLabel", "(I)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetTextChannelSettings extends AppFragment {
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTextChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> SLOWMODE_COOLDOWN_VALUES = Collections2.listOf((Object[]) new Integer[]{0, 5, 10, 15, 30, 60, 120, 300, 600, 900, Integer.valueOf(ModelInvite.Settings.HALF_HOUR), 3600, 7200, Integer.valueOf(ModelInvite.Settings.SIX_HOURS)});

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Companion;", "", "Landroid/widget/TextView;", "textView", "", "seconds", "Landroid/content/Context;", "context", "zeroLabel", "", "setDurationSecondsLabel", "(Landroid/widget/TextView;ILandroid/content/Context;I)V", "", "channelId", "launch", "(JLandroid/content/Context;)V", "", "SLOWMODE_COOLDOWN_VALUES", "Ljava/util/List;", "getSLOWMODE_COOLDOWN_VALUES", "()Ljava/util/List;", "ONE_DAY", "I", "ONE_HOUR", "ONE_MINUTE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void setDurationSecondsLabel$default(Companion companion, TextView textView, int i, Context context, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = R.string.form_label_slowmode_off;
            }
            companion.setDurationSecondsLabel(textView, i, context, i2);
        }

        public final List<Integer> getSLOWMODE_COOLDOWN_VALUES() {
            return WidgetTextChannelSettings.access$getSLOWMODE_COOLDOWN_VALUES$cp();
        }

        public final void launch(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetTextChannelSettings.class, intentPutExtra);
        }

        public final void setDurationSecondsLabel(TextView textView, int seconds, Context context, int zeroLabel) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            Intrinsics3.checkNotNullParameter(context, "context");
            if (seconds == 0) {
                textView.setText(context.getString(zeroLabel));
                return;
            }
            if (1 <= seconds && 60 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.SECONDS, seconds);
                return;
            }
            if (60 <= seconds && 3600 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.MINS, seconds / 60);
            } else if (3600 <= seconds && 86400 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.HOURS, seconds / 3600);
            } else {
                DurationUtils3.setDurationText(textView, DurationUtils2.DAYS, seconds / 86400);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u0000 ,2\u00020\u0001:\u0001,BG\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ`\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b\u0017\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b(\u0010\nR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b)\u0010\n¨\u0006-"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "component3", "()Z", "component4", "component5", "component6", "component7", "component8", "guild", "channel", "canManageChannel", "canManagePermissions", "isPinsEnabled", "isPublicGuildRulesChannel", "isPublicGuildUpdatesChannel", "isCommunityGuild", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;ZZZZZZ)Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "getCanManageChannel", "getCanManagePermissions", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;ZZZZZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final Guild guild;
        private final boolean isCommunityGuild;
        private final boolean isPinsEnabled;
        private final boolean isPublicGuildRulesChannel;
        private final boolean isPublicGuildUpdatesChannel;

        /* compiled from: WidgetTextChannelSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetTextChannelSettings2(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.guild = guild;
            this.channel = channel;
            this.canManageChannel = z2;
            this.canManagePermissions = z3;
            this.isPinsEnabled = z4;
            this.isPublicGuildRulesChannel = z5;
            this.isPublicGuildUpdatesChannel = z6;
            this.isCommunityGuild = z7;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.guild : guild, (i & 2) != 0 ? model.channel : channel, (i & 4) != 0 ? model.canManageChannel : z2, (i & 8) != 0 ? model.canManagePermissions : z3, (i & 16) != 0 ? model.isPinsEnabled : z4, (i & 32) != 0 ? model.isPublicGuildRulesChannel : z5, (i & 64) != 0 ? model.isPublicGuildUpdatesChannel : z6, (i & 128) != 0 ? model.isCommunityGuild : z7);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsPinsEnabled() {
            return this.isPinsEnabled;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final Model copy(Guild guild, Channel channel, boolean canManageChannel, boolean canManagePermissions, boolean isPinsEnabled, boolean isPublicGuildRulesChannel, boolean isPublicGuildUpdatesChannel, boolean isCommunityGuild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(guild, channel, canManageChannel, canManagePermissions, isPinsEnabled, isPublicGuildRulesChannel, isPublicGuildUpdatesChannel, isCommunityGuild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.isPinsEnabled == model.isPinsEnabled && this.isPublicGuildRulesChannel == model.isPublicGuildRulesChannel && this.isPublicGuildUpdatesChannel == model.isPublicGuildUpdatesChannel && this.isCommunityGuild == model.isCommunityGuild;
        }

        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.canManageChannel;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.canManagePermissions;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.isPinsEnabled;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isPublicGuildRulesChannel;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.isPublicGuildUpdatesChannel;
            int i9 = z6;
            if (z6 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z7 = this.isCommunityGuild;
            return i10 + (z7 ? 1 : z7 ? 1 : 0);
        }

        public final boolean isCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final boolean isPinsEnabled() {
            return this.isPinsEnabled;
        }

        public final boolean isPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        public final boolean isPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", canManageChannel=");
            sbU.append(this.canManageChannel);
            sbU.append(", canManagePermissions=");
            sbU.append(this.canManagePermissions);
            sbU.append(", isPinsEnabled=");
            sbU.append(this.isPinsEnabled);
            sbU.append(", isPublicGuildRulesChannel=");
            sbU.append(this.isPublicGuildRulesChannel);
            sbU.append(", isPublicGuildUpdatesChannel=");
            sbU.append(this.isPublicGuildUpdatesChannel);
            sbU.append(", isCommunityGuild=");
            return outline.O(sbU, this.isCommunityGuild, ")");
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$cannotDeleteWarn$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "context", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass1(Model model) {
            this.$this_configureUI = model;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_channel_settings_delete /* 2131364369 */:
                    if (!this.$this_configureUI.isPublicGuildRulesChannel() && !this.$this_configureUI.isPublicGuildUpdatesChannel()) {
                        WidgetTextChannelSettings.access$confirmDelete(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel());
                        break;
                    } else {
                        WidgetTextChannelSettings.access$cannotDeleteWarn(WidgetTextChannelSettings.this, this.$this_configureUI.isPublicGuildRulesChannel());
                        break;
                    }
                    break;
                case R.id.menu_channel_settings_reset /* 2131364370 */:
                    StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    userGuildSettings.setChannelNotificationsDefault(context, this.$this_configureUI.getChannel());
                    break;
            }
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass10(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, 60);
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, 60);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass11(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, 1440);
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, 1440);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass12(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES));
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$13, reason: invalid class name */
    public static final class AnonymousClass13 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass13(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES));
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass2(Model model) {
            this.$this_configureUI = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_channel_settings_delete);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
            menuItemFindItem.setVisible(this.$this_configureUI.getCanManageChannel());
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass3(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            TextInputLayout textInputLayout = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            String str = (String) statefulViewsAccess$getState$p.getIfChanged(textInputLayout.getId());
            StatefulViews statefulViewsAccess$getState$p2 = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            TextInputLayout textInputLayout2 = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
            String str2 = (String) statefulViewsAccess$getState$p2.getIfChanged(textInputLayout2.getId());
            StatefulViews statefulViewsAccess$getState$p3 = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            SeekBar seekBar = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).q;
            Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
            WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, str, null, str2, null, (Integer) statefulViewsAccess$getState$p3.getIfChanged(seekBar.getId()), (Integer) WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).getIfChanged(R.id.duration_selector), 20, null);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass5(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPinnedMessages.INSTANCE.show(outline.x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            AppToast.g(view.getContext(), R.string.pins_disabled_nsfw, 0, null, 12);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass7(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(outline.x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass8(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ChannelUtils.i(this.$this_configureUI.getChannel())) {
                WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel().getId(), null, 0, null, null, null, null, 122, null);
            } else {
                WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel().getId(), null, 5, null, null, null, null, 122, null);
            }
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass9(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            Intrinsics3.checkNotNullExpressionValue(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f, "binding.channelSettingsNsfw");
            WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, null, null, null, Boolean.valueOf(!r12.isChecked()), null, null, 110, null);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetTextChannelSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02502 extends Lambda implements Function1<Channel, Unit> {
            public C02502() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Integer numB = ChannelUtils.b(channel);
                if (numB != null) {
                    AppToast.i(WidgetTextChannelSettings.this, numB.intValue(), 0, 4);
                }
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(this.$channel.getId()), false, 1, null), WidgetTextChannelSettings.this, null, 2, null);
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new C02502(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/channels/settings/WidgetTextChannelSettings$onViewBound$1", "Lb/a/y/j;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends OnSeekBarChangeListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser) {
                int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                WidgetTextChannelSettings.access$setSlowmodeLabel(WidgetTextChannelSettings.this, iIntValue);
                WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(iIntValue));
                WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
                TextView textView = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).p;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
                seekBar.setContentDescription(textView.getText());
            }
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "it", "", "invoke", "(Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetTextChannelSettings.access$configureUI(WidgetTextChannelSettings.this, model);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$saveChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Context context = WidgetTextChannelSettings.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(channel, "it");
            AppToast.g(context, ChannelUtils.k(channel) ? R.string.category_settings_have_been_updated : R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    public WidgetTextChannelSettings() {
        super(R.layout.widget_text_channel_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTextChannelSettings3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.channel_settings_edit_topic, R.id.channel_settings_slow_mode_cooldown_slider, R.id.duration_selector, R.id.channel_settings_announcement);
    }

    public static final /* synthetic */ void access$cannotDeleteWarn(WidgetTextChannelSettings widgetTextChannelSettings, boolean z2) {
        widgetTextChannelSettings.cannotDeleteWarn(z2);
    }

    public static final /* synthetic */ void access$configureUI(WidgetTextChannelSettings widgetTextChannelSettings, Model model) {
        widgetTextChannelSettings.configureUI(model);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetTextChannelSettings widgetTextChannelSettings, Channel channel) {
        widgetTextChannelSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetTextChannelSettingsBinding access$getBinding$p(WidgetTextChannelSettings widgetTextChannelSettings) {
        return widgetTextChannelSettings.getBinding();
    }

    public static final /* synthetic */ List access$getSLOWMODE_COOLDOWN_VALUES$cp() {
        return SLOWMODE_COOLDOWN_VALUES;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetTextChannelSettings widgetTextChannelSettings) {
        return widgetTextChannelSettings.state;
    }

    public static final /* synthetic */ void access$setSlowmodeLabel(WidgetTextChannelSettings widgetTextChannelSettings, int i) {
        widgetTextChannelSettings.setSlowmodeLabel(i);
    }

    public static final /* synthetic */ void access$updateRadioState(WidgetTextChannelSettings widgetTextChannelSettings, Map map, int i) {
        widgetTextChannelSettings.updateRadioState(map, i);
    }

    private final void cannotDeleteWarn(boolean isPublicGuildRulesChannel) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.widget_channel_settings_cannot_delete, (ViewGroup) null, false);
        int i = R.id.channel_settings_cannot_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_settings_cannot_delete_body);
        if (textView != null) {
            i = R.id.channel_settings_cannot_delete_confirm;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.channel_settings_cannot_delete_confirm);
            if (materialButton != null) {
                i = R.id.channel_settings_cannot_delete_title;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.channel_settings_cannot_delete_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetChannelSettingsCannotDeleteBinding(linearLayout, textView, materialButton, textView2), "WidgetChannelSettingsCan…om(context), null, false)");
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                    Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
                    textView.setText(isPublicGuildRulesChannel ? R.string.delete_rules_channel_body : R.string.delete_updates_channel_body);
                    materialButton.setOnClickListener(new AnonymousClass1(alertDialogCreate));
                    alertDialogCreate.show();
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void configureUI(Model model) {
        if (model == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(ChannelUtils.F(model.getChannel()) ? R.string.channel_settings : R.string.category_settings);
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(ChannelUtils.F(model.getChannel()) ? R.menu.menu_text_channel_settings : R.menu.menu_category_settings, new AnonymousClass1(model), new AnonymousClass2(model));
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), ChannelUtils.c(model.getChannel())));
        getBinding().c.setHint(ChannelUtils.F(model.getChannel()) ? R.string.form_label_channel_name : R.string.category_name);
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout4.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, topic));
        TextInputLayout textInputLayout5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        textInputLayout5.setVisibility(ChannelUtils.F(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsEditWrap");
        linearLayout.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().k.setOnClickListener(new AnonymousClass3(model));
        this.state.configureSaveActionView(getBinding().k);
        LinearLayout linearLayout2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsPinnedMessagesContainer");
        linearLayout2.setVisibility(ChannelUtils.F(model.getChannel()) ? 0 : 8);
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsPinnedMessages");
        textView.setEnabled(model.isPinsEnabled());
        getBinding().h.setOnClickListener(new AnonymousClass5(model));
        View view = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(model.isPinsEnabled() ^ true ? 0 : 8);
        getBinding().j.setOnClickListener(AnonymousClass6.INSTANCE);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsPermissions");
        textView2.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().g.setOnClickListener(new AnonymousClass7(model));
        CheckedSetting checkedSetting = getBinding().f2665b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsAnnouncement");
        checkedSetting.setVisibility((ChannelUtils.u(model.getChannel()) || ChannelUtils.i(model.getChannel())) && model.getCanManageChannel() && model.isCommunityGuild() && !model.isPublicGuildRulesChannel() && !model.isPublicGuildUpdatesChannel() ? 0 : 8);
        getBinding().f2665b.g(ChannelUtils.i(model.getChannel()), false);
        CheckedSetting checkedSetting2 = getBinding().f2665b;
        Context context = getContext();
        checkedSetting2.h(context != null ? FormatUtils.h(context, R.string.form_help_news_android, new Object[]{AppHelpDesk.a.a(360032008192L, null)}, null, 4) : null, true);
        getBinding().f2665b.e(new AnonymousClass8(model));
        LinearLayout linearLayout3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.channelSettingsSectionUserManagement");
        linearLayout3.setVisibility(model.getCanManageChannel() || model.getCanManagePermissions() ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.channelSettingsSectionPrivacySafety");
        linearLayout4.setVisibility(model.getCanManageChannel() && ChannelUtils.F(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
        checkedSetting3.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f.g(model.getChannel().getNsfw(), false);
        getBinding().f.e(new AnonymousClass9(model));
        LinearLayout linearLayout5 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(linearLayout5, "binding.channelSettingsSectionSlowMode");
        linearLayout5.setVisibility(model.getCanManageChannel() && ChannelUtils.F(model.getChannel()) && !ChannelUtils.i(model.getChannel()) ? 0 : 8);
        int iIntValue = ((Number) this.state.get(R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(model.getChannel().getRateLimitPerUser()))).intValue();
        setSlowmodeLabel(iIntValue);
        Iterator<Integer> it = SLOWMODE_COOLDOWN_VALUES.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().intValue() >= iIntValue) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SeekBar seekBar = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        this.state.configureSaveActionView(getBinding().k);
        SeekBar seekBar2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.channelSettingsSlowModeCooldownSlider");
        TextView textView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView3.getText());
        LinearLayout linearLayout6 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout6, "binding.channelSettingsS…efaultAutoArchiveDuration");
        linearLayout6.setVisibility(model.getCanManageChannel() && ChannelUtils.I(model.getChannel()) && ThreadUtils.INSTANCE.isThreadsEnabled(model.getGuild().getId()) ? 0 : 8);
        Integer num = (Integer) this.state.get(R.id.duration_selector, model.getChannel().getDefaultAutoArchiveDuration());
        int iIntValue2 = num != null ? num.intValue() : 1440;
        this.state.configureSaveActionView(getBinding().k);
        Map<MaterialRadioButton, Integer> mapMapOf = Maps6.mapOf(Tuples.to(getBinding().r.e, 60), Tuples.to(getBinding().r.k, 1440), Tuples.to(getBinding().r.i, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES)), Tuples.to(getBinding().r.g, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES)));
        getBinding().r.d.setOnClickListener(new AnonymousClass10(mapMapOf));
        getBinding().r.j.setOnClickListener(new AnonymousClass11(mapMapOf));
        getBinding().r.h.setOnClickListener(new AnonymousClass12(mapMapOf));
        getBinding().r.f.setOnClickListener(new AnonymousClass13(mapMapOf));
        updateRadioState(mapMapOf, iIntValue2);
    }

    private final void confirmDelete(Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingA = WidgetChannelSettingsDeleteBinding.a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingA.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        widgetChannelSettingsDeleteBindingA.e.setText(ChannelUtils.F(channel) ? R.string.delete_channel : R.string.delete_category);
        widgetChannelSettingsDeleteBindingA.c.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        widgetChannelSettingsDeleteBindingA.d.setOnClickListener(new AnonymousClass2(channel));
        TextView textView = widgetChannelSettingsDeleteBindingA.f199b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        FormatUtils.n(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetTextChannelSettingsBinding getBinding() {
        return (WidgetTextChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long id2, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().editTextChannel(id2, name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration), this, null, 2, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetTextChannelSettings widgetTextChannelSettings, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        widgetTextChannelSettings.saveChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        Companion companion = INSTANCE;
        TextView textView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), R.string.form_label_slowmode_off);
    }

    private final void updateRadioState(Map<MaterialRadioButton, Integer> durationMap, int newDuration) {
        for (Map.Entry<MaterialRadioButton, Integer> entry : durationMap.entrySet()) {
            entry.getKey().setChecked(entry.getValue().intValue() == newDuration);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().k;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3);
        SeekBar seekBar = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setMax(Collections2.getLastIndex(SLOWMODE_COOLDOWN_VALUES));
        getBinding().q.setOnSeekBarChangeListener(new AnonymousClass1());
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)), this, null, 2, null), WidgetTextChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
