package com.discord.widgets.voice.settings;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.SelectorDialog;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetChannelSettingsDeleteBinding;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildVoiceRegions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetVoiceChannelSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b5\u0010+J\u0015\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJW\u0010$\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010+R\u001d\u00101\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;", "", "configureUI", "(Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;)V", "", "isVisible", "configureUserLimitVisibility", "(Z)V", "configureRegionOverrideVisibility", "Lcom/discord/api/channel/Channel;", "channel", "confirmDelete", "(Lcom/discord/api/channel/Channel;)V", "", ModelAuditLogEntry.CHANGE_KEY_BITRATE, "", "getBitrateDisplayString", "(I)Ljava/lang/String;", "userLimit", "", "getUserLimitDisplayString", "(I)Ljava/lang/CharSequence;", "", "Lcom/discord/models/domain/ModelVoiceRegion;", "regions", "showRegionDialog", "(Ljava/util/List;)V", "", "channelId", "channelName", "channelType", "channelTopic", ModelAuditLogEntry.CHANGE_KEY_NSFW, "rtcRegion", "saveChannel", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;IILjava/lang/String;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceChannelSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Companion;", "", "", "channelId", "Landroid/content/Context;", "context", "", "launch", "(JLandroid/content/Context;)V", "", WidgetVoiceChannelSettings.INTENT_EXTRA_CHANNEL_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetVoiceChannelSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetVoiceChannelSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0082\b\u0018\u0000 /2\u00020\u0001:\u0001/B=\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JR\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\t2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000bJ\u001a\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u000bR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u000fR\u0019\u0010\u0018\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b,\u0010\u0007¨\u00060"}, d2 = {"Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "component3", "", "component4", "()I", "", "Lcom/discord/models/domain/ModelVoiceRegion;", "component5", "()Ljava/util/List;", "", "component6", "()J", "channel", "canManageChannel", "canManagePermissions", "maxBitrate", "regions", "guildID", "copy", "(Lcom/discord/api/channel/Channel;ZZILjava/util/List;J)Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "I", "getMaxBitrate", "Ljava/util/List;", "getRegions", "J", "getGuildID", "Z", "getCanManageChannel", "getCanManagePermissions", "<init>", "(Lcom/discord/api/channel/Channel;ZZILjava/util/List;J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final long guildID;
        private final int maxBitrate;
        private final List<ModelVoiceRegion> regions;

        /* compiled from: WidgetVoiceChannelSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model$Companion;", "", "", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreChannels channels = companion.getChannels();
                StoreGuilds guilds = companion.getGuilds();
                StoreUser users = companion.getUsers();
                StorePermissions permissions = companion.getPermissions();
                StoreGuildVoiceRegions guildVoiceRegions = companion.getGuildVoiceRegions();
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, guilds, StoreUser.INSTANCE.getMeUpdate(), permissions, guildVoiceRegions, companion.getExperiments()}, false, null, null, new WidgetVoiceChannelSettings2(channels, channelId, guilds, permissions, users, guildVoiceRegions), 14, null)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, boolean z2, boolean z3, int i, List<? extends ModelVoiceRegion> list, long j) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(list, "regions");
            this.channel = channel;
            this.canManageChannel = z2;
            this.canManagePermissions = z3;
            this.maxBitrate = i;
            this.regions = list;
            this.guildID = j;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, boolean z2, boolean z3, int i, List list, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = model.channel;
            }
            if ((i2 & 2) != 0) {
                z2 = model.canManageChannel;
            }
            boolean z4 = z2;
            if ((i2 & 4) != 0) {
                z3 = model.canManagePermissions;
            }
            boolean z5 = z3;
            if ((i2 & 8) != 0) {
                i = model.maxBitrate;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                list = model.regions;
            }
            List list2 = list;
            if ((i2 & 32) != 0) {
                j = model.guildID;
            }
            return model.copy(channel, z4, z5, i3, list2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* renamed from: component4, reason: from getter */
        public final int getMaxBitrate() {
            return this.maxBitrate;
        }

        public final List<ModelVoiceRegion> component5() {
            return this.regions;
        }

        /* renamed from: component6, reason: from getter */
        public final long getGuildID() {
            return this.guildID;
        }

        public final Model copy(Channel channel, boolean canManageChannel, boolean canManagePermissions, int maxBitrate, List<? extends ModelVoiceRegion> regions, long guildID) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(regions, "regions");
            return new Model(channel, canManageChannel, canManagePermissions, maxBitrate, regions, guildID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.maxBitrate == model.maxBitrate && Intrinsics3.areEqual(this.regions, model.regions) && this.guildID == model.guildID;
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

        public final long getGuildID() {
            return this.guildID;
        }

        public final int getMaxBitrate() {
            return this.maxBitrate;
        }

        public final List<ModelVoiceRegion> getRegions() {
            return this.regions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.canManageChannel;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.canManagePermissions;
            int i3 = (((i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.maxBitrate) * 31;
            List<ModelVoiceRegion> list = this.regions;
            return b.a(this.guildID) + ((i3 + (list != null ? list.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", canManageChannel=");
            sbU.append(this.canManageChannel);
            sbU.append(", canManagePermissions=");
            sbU.append(this.canManagePermissions);
            sbU.append(", maxBitrate=");
            sbU.append(this.maxBitrate);
            sbU.append(", regions=");
            sbU.append(this.regions);
            sbU.append(", guildID=");
            return outline.C(sbU, this.guildID, ")");
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$1, reason: invalid class name */
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
            if (menuItem.getItemId() != R.id.menu_channel_settings_delete) {
                return;
            }
            WidgetVoiceChannelSettings.access$confirmDelete(WidgetVoiceChannelSettings.this, this.$this_configureUI.getChannel());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/voice/settings/WidgetVoiceChannelSettings$configureUI$2", "Lb/a/y/j;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends OnSeekBarChangeListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).n;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
            textView.setText(WidgetVoiceChannelSettings.access$getUserLimitDisplayString(WidgetVoiceChannelSettings.this, progress));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/voice/settings/WidgetVoiceChannelSettings$configureUI$3", "Lb/a/y/j;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends OnSeekBarChangeListenerAdapter {
        public AnonymousClass3() {
        }

        @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).m;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentBitrateDisplay");
            textView.setText(WidgetVoiceChannelSettings.access$getBitrateDisplayString(WidgetVoiceChannelSettings.this, Bitrate.MIN.getKbps() + progress));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass4(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceChannelSettings.access$showRegionDialog(WidgetVoiceChannelSettings.this, this.$this_configureUI.getRegions());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass5(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(WidgetVoiceChannelSettings.this.requireContext(), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass6(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceChannelSettings widgetVoiceChannelSettings = WidgetVoiceChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextInputLayout textInputLayout = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            String str = (String) statefulViewsAccess$getState$p.get(textInputLayout.getId(), ChannelUtils.c(this.$this_configureUI.getChannel()));
            StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextInputLayout textInputLayout2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
            int id3 = textInputLayout2.getId();
            String topic = this.$this_configureUI.getChannel().getTopic();
            if (topic == null) {
                topic = "";
            }
            String str2 = (String) statefulViewsAccess$getState$p2.get(id3, topic);
            CheckedSetting checkedSetting = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
            Boolean boolValueOf = Boolean.valueOf(checkedSetting.isChecked());
            int type = this.$this_configureUI.getChannel().getType();
            SeekBar seekBar = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).t;
            Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f2702b;
            Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
            int kbps = (Bitrate.MIN.getKbps() + seekBar2.getProgress()) * 1000;
            StatefulViews statefulViewsAccess$getState$p3 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
            WidgetVoiceChannelSettings.access$saveChannel(widgetVoiceChannelSettings, id2, str, type, str2, boolValueOf, progress, kbps, (String) statefulViewsAccess$getState$p3.get(textView.getId(), this.$this_configureUI.getChannel().getRtcRegion()));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$1, reason: invalid class name */
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

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetVoiceChannelSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03672 extends Lambda implements Function1<Channel, Unit> {
            public C03672() {
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
                    AppToast.i(WidgetVoiceChannelSettings.this, numB.intValue(), 0, 4);
                }
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(this.$channel.getId()), false, 1, null), WidgetVoiceChannelSettings.this, null, 2, null);
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new C03672(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;", "it", "", "invoke", "(Lcom/discord/widgets/voice/settings/WidgetVoiceChannelSettings$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetVoiceChannelSettings.access$configureUI(WidgetVoiceChannelSettings.this, model);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$saveChannel$1, reason: invalid class name */
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
            AppToast.g(WidgetVoiceChannelSettings.this.getContext(), R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$showRegionDialog$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ List $regions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list) {
            super(1);
            this.$regions = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            if (i == 0) {
                StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
                TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
                statefulViewsAccess$getState$p.put(textView.getId(), null);
                TextView textView2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsRegionOverride");
                textView2.setText(FormatUtils.k(WidgetVoiceChannelSettings.this, R.string.automatic_region, new Object[0], null, 4));
            } else {
                StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
                TextView textView3 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelSettingsRegionOverride");
                int i2 = i - 1;
                statefulViewsAccess$getState$p2.put(textView3.getId(), ((ModelVoiceRegion) this.$regions.get(i2)).getId());
                TextView textView4 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelSettingsRegionOverride");
                textView4.setText(((ModelVoiceRegion) this.$regions.get(i2)).getName());
            }
            WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this).configureSaveActionView(WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).j);
        }
    }

    public WidgetVoiceChannelSettings() {
        super(R.layout.widget_voice_channel_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceChannelSettings3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.channel_settings_edit_topic, R.id.current_user_limit_display, R.id.current_bitrate_display, R.id.channel_settings_region_override, R.id.channel_settings_nsfw);
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceChannelSettings widgetVoiceChannelSettings, Model model) {
        widgetVoiceChannelSettings.configureUI(model);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetVoiceChannelSettings widgetVoiceChannelSettings, Channel channel) {
        widgetVoiceChannelSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetVoiceChannelSettingsBinding access$getBinding$p(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        return widgetVoiceChannelSettings.getBinding();
    }

    public static final /* synthetic */ String access$getBitrateDisplayString(WidgetVoiceChannelSettings widgetVoiceChannelSettings, int i) {
        return widgetVoiceChannelSettings.getBitrateDisplayString(i);
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        return widgetVoiceChannelSettings.state;
    }

    public static final /* synthetic */ CharSequence access$getUserLimitDisplayString(WidgetVoiceChannelSettings widgetVoiceChannelSettings, int i) {
        return widgetVoiceChannelSettings.getUserLimitDisplayString(i);
    }

    public static final /* synthetic */ void access$saveChannel(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, bool, i2, i3, str3);
    }

    public static final /* synthetic */ void access$showRegionDialog(WidgetVoiceChannelSettings widgetVoiceChannelSettings, List list) {
        widgetVoiceChannelSettings.showRegionDialog(list);
    }

    private final void configureRegionOverrideVisibility(boolean isVisible) {
        View view = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.regionOverrideDivider");
        view.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsRegionOverrideContainer");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverrideHelp");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    private final void configureUI(Model model) {
        Object next;
        String string;
        if (model == null || !(model.getCanManageChannel() || model.getCanManagePermissions())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.state.clear(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_voice_channel_settings, new AnonymousClass1(model), null, 4, null);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        StatefulViews statefulViews = this.state;
        TextView textView2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        textView.setText((CharSequence) statefulViews.get(textView2.getId(), getUserLimitDisplayString(model.getChannel().getUserLimit())));
        TextView textView3 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.settingsUserLimitHelp");
        FormatUtils.n(textView3, R.string.form_help_user_limit, new Object[0], null, 4);
        SeekBar seekBar = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        seekBar.setProgress(model.getChannel().getUserLimit());
        getBinding().t.setOnSeekBarChangeListener(new AnonymousClass2());
        configureUserLimitVisibility(model.getChannel().getType() == 2);
        int bitrate = model.getChannel().getBitrate() / 1000;
        TextView textView4 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.currentBitrateDisplay");
        StatefulViews statefulViews2 = this.state;
        TextView textView5 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.currentBitrateDisplay");
        textView4.setText((CharSequence) statefulViews2.get(textView5.getId(), getBitrateDisplayString(bitrate)));
        TextView textView6 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.settingsBitrateHelp");
        FormatUtils.n(textView6, R.string.form_help_bitrate, new Object[]{"64"}, null, 4);
        SeekBar seekBar2 = getBinding().f2702b;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int maxBitrate = model.getMaxBitrate();
        Bitrate bitrate2 = Bitrate.MIN;
        seekBar2.setMax(maxBitrate - bitrate2.getKbps());
        SeekBar seekBar3 = getBinding().f2702b;
        Intrinsics3.checkNotNullExpressionValue(seekBar3, "binding.bitrateSeekbar");
        seekBar3.setProgress(bitrate - bitrate2.getKbps());
        getBinding().f2702b.setOnSeekBarChangeListener(new AnonymousClass3());
        StatefulViews statefulViews3 = this.state;
        TextView textView7 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelSettingsRegionOverride");
        String str = (String) statefulViews3.get(textView7.getId(), model.getChannel().getRtcRegion());
        Iterator<T> it = model.getRegions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics3.areEqual(((ModelVoiceRegion) next).getId(), str)) {
                    break;
                }
            }
        }
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) next;
        if (modelVoiceRegion == null || (string = modelVoiceRegion.getName()) == null) {
            string = getString(R.string.automatic_region);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.automatic_region)");
        }
        TextView textView8 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.channelSettingsRegionOverride");
        textView8.setText(string);
        TextView textView9 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.channelSettingsRegionOverrideHelp");
        FormatUtils.n(textView9, R.string.form_help_region_override, new Object[0], null, 4);
        getBinding().h.setOnClickListener(new AnonymousClass4(model));
        configureRegionOverrideVisibility(model.getCanManageChannel());
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews4 = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews4.get(textInputLayout2.getId(), ChannelUtils.c(model.getChannel())));
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        textInputLayout3.setVisibility(8);
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews5 = this.state;
        TextInputLayout textInputLayout5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout5.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout4, (CharSequence) statefulViews5.get(id2, topic));
        LinearLayout linearLayout = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsSectionUserManagement");
        linearLayout.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass5(model));
        LinearLayout linearLayout2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsSectionPrivacySafety");
        linearLayout2.setVisibility(model.getCanManageChannel() && ChannelUtils.J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId())) ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        checkedSetting.setVisibility(model.getCanManageChannel() ? 0 : 8);
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.channelSettingsNsfw");
        getBinding().e.g(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(model.getChannel().getNsfw()))).booleanValue(), false);
        getBinding().j.setOnClickListener(new AnonymousClass6(model));
        this.state.configureSaveActionView(getBinding().j);
    }

    private final void configureUserLimitVisibility(boolean isVisible) {
        View view = getBinding().f2703s;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.userLimitDivider");
        view.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().u;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userLimitTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsUserLimit");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView2 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsUserLimitHelp");
        textView2.setVisibility(isVisible ? 0 : 8);
    }

    private final void confirmDelete(Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingA = WidgetChannelSettingsDeleteBinding.a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingA.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        widgetChannelSettingsDeleteBindingA.c.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        widgetChannelSettingsDeleteBindingA.d.setOnClickListener(new AnonymousClass2(channel));
        TextView textView = widgetChannelSettingsDeleteBindingA.f199b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        LinearLayout linearLayout2 = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.root");
        Context context = linearLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        FormatUtils.n(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetVoiceChannelSettingsBinding getBinding() {
        return (WidgetVoiceChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getBitrateDisplayString(int bitrate) {
        return bitrate + " Kbps";
    }

    private final CharSequence getUserLimitDisplayString(int userLimit) {
        if (userLimit == 0) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            return FormatUtils.i(resources, R.string.no_user_limit, new Object[0], null, 4);
        }
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        return StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.num_users_num, userLimit, Integer.valueOf(userLimit));
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long channelId, String channelName, int channelType, String channelTopic, Boolean nsfw, int userLimit, int bitrate, String rtcRegion) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApiSerializeNulls().editVoiceChannel(channelId, channelName, channelTopic, nsfw, Integer.valueOf(channelType), Integer.valueOf(bitrate), Integer.valueOf(userLimit), rtcRegion), this, null, 2, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3, int i4, Object obj) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, (i4 & 16) != 0 ? null : bool, i2, i3, str3);
    }

    private final void showRegionDialog(List<? extends ModelVoiceRegion> regions) {
        SelectorDialog.Companion companion = SelectorDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceK = FormatUtils.k(this, R.string.form_label_region_override, new Object[0], null, 4);
        List listListOf = CollectionsJVM.listOf(FormatUtils.k(this, R.string.automatic_region, new Object[0], null, 4));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(regions, 10));
        Iterator<T> it = regions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelVoiceRegion) it.next()).getName());
        }
        Object[] array = _Collections.plus((Collection) listListOf, (Iterable) arrayList).toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.a(parentFragmentManager, charSequenceK, (CharSequence[]) array, new AnonymousClass2(regions));
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
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        statefulViews2.addOptionalFields(textView);
        StatefulViews statefulViews3 = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        TextView textView2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        TextView textView3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.currentBitrateDisplay");
        CheckedSetting checkedSetting = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        statefulViews3.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3, textView2, textView3, checkedSetting);
        TextInputLayout textInputLayout4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetVoiceChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
