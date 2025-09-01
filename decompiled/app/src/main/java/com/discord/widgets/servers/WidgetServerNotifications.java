package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.i.ViewAddOverrideItemBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.servers.NotificationHighlightsSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetServerNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b#\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bR\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotifications;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerNotifications$Model;)V", "configureForHub", "()V", "Lcom/discord/views/CheckedSetting;", "radio", "", "type", "configureRadio", "(Lcom/discord/views/CheckedSetting;ILcom/discord/widgets/servers/WidgetServerNotifications$Model;)V", "Landroidx/recyclerview/widget/ItemTouchHelper;", "createSwipeableItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/databinding/WidgetServerNotificationsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerNotificationsBinding;", "binding", "Lcom/discord/views/RadioManager;", "notificationSettingsRadioManager", "Lcom/discord/views/RadioManager;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter;", "overrideAdapter", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;
    private NotificationsOverridesAdapter overrideAdapter;

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JW\u0010\t\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \b*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotifications$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "kotlin.jvm.PlatformType", "getNotificationOverrides", "(J)Lrx/Observable;", "Landroid/content/Context;", "context", "", "launch", "(JLandroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getNotificationOverrides(Companion companion, long j) {
            return companion.getNotificationOverrides(j);
        }

        private final Observable<List<NotificationsOverridesAdapter.Item>> getNotificationOverrides(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.i(companion.getUserGuildSettings().observeGuildSettings(guildId).G(WidgetServerNotifications2.INSTANCE), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), GuildChannelsInfo.INSTANCE.get(guildId), WidgetServerNotifications3.INSTANCE);
        }

        public final void launch(long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerNotifications.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010!\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b!\u0010\u001eR\u0019\u0010\"\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0015R\u0018\u0010%\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0019\u0010'\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001eR\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010\n¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/domain/ModelNotificationSettings;", "component2", "()Lcom/discord/models/domain/ModelNotificationSettings;", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "component3", "()Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "guild", "guildSettings", "guildProfile", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;)Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "isAboveNotifyAllSize", "Z", "()Z", "Lcom/discord/models/domain/ModelNotificationSettings;", "getGuildSettings", "isAboveHighlightsSize", "notificationsSetting", "I", "getNotificationsSetting", "approximateMemberCount", "Ljava/lang/Integer;", "highlightsEnabled", "getHighlightsEnabled", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "getGuildProfile", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer approximateMemberCount;
        private final Guild guild;
        private final StoreGuildProfiles.GuildProfileData guildProfile;
        private final ModelNotificationSettings guildSettings;
        private final boolean highlightsEnabled;
        private final boolean isAboveHighlightsSize;
        private final boolean isAboveNotifyAllSize;
        private final int notificationsSetting;

        /* compiled from: WidgetServerNotifications.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotifications$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", "get", "(J)Lrx/Observable;", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "", "isValid", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelNotificationSettings;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), WidgetServerNotifications4.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n          .co…  } else null\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationBuffered(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public final boolean isValid(Guild guild, ModelNotificationSettings guildSettings) {
                return (guild == null || guildSettings == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
            GuildPreview data;
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(modelNotificationSettings, "guildSettings");
            this.guild = guild;
            this.guildSettings = modelNotificationSettings;
            this.guildProfile = guildProfileData;
            this.notificationsSetting = modelNotificationSettings.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET ? modelNotificationSettings.getMessageNotifications() : guild.getDefaultMessageNotifications();
            Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
            this.approximateMemberCount = approximateMemberCount;
            this.isAboveNotifyAllSize = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
            boolean zIsHighlightsSettingsEnabled = GrowthTeamFeatures.INSTANCE.isHighlightsSettingsEnabled();
            this.highlightsEnabled = zIsHighlightsSettingsEnabled;
            this.isAboveHighlightsSize = zIsHighlightsSettingsEnabled && approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                modelNotificationSettings = model.guildSettings;
            }
            if ((i & 4) != 0) {
                guildProfileData = model.guildProfile;
            }
            return model.copy(guild, modelNotificationSettings, guildProfileData);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelNotificationSettings getGuildSettings() {
            return this.guildSettings;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final Model copy(Guild guild, ModelNotificationSettings guildSettings, StoreGuildProfiles.GuildProfileData guildProfile) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
            return new Model(guild, guildSettings, guildProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.guildSettings, model.guildSettings) && Intrinsics3.areEqual(this.guildProfile, model.guildProfile);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final ModelNotificationSettings getGuildSettings() {
            return this.guildSettings;
        }

        public final boolean getHighlightsEnabled() {
            return this.highlightsEnabled;
        }

        public final int getNotificationsSetting() {
            return this.notificationsSetting;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ModelNotificationSettings modelNotificationSettings = this.guildSettings;
            int iHashCode2 = (iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
            StoreGuildProfiles.GuildProfileData guildProfileData = this.guildProfile;
            return iHashCode2 + (guildProfileData != null ? guildProfileData.hashCode() : 0);
        }

        /* renamed from: isAboveHighlightsSize, reason: from getter */
        public final boolean getIsAboveHighlightsSize() {
            return this.isAboveHighlightsSize;
        }

        /* renamed from: isAboveNotifyAllSize, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", guildSettings=");
            sbU.append(this.guildSettings);
            sbU.append(", guildProfile=");
            sbU.append(this.guildProfile);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ int $type;

        public AnonymousClass1(Model model, int i) {
            this.$model = model;
            this.$type = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserGuildSettings().setGuildFrequency(outline.x(view, "view", "view.context"), this.$model.getGuild(), this.$type);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "newHighlightsState", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            NotificationHighlightsSettingsView notificationHighlightsSettingsView = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).j;
            Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
            Context context = notificationHighlightsSettingsView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsHighlights.context");
            userGuildSettings.setNotifyHighlights(context, this.$model.getGuild(), i);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsEveryoneSwitch.context");
            StoreUserGuildSettings.setGuildToggles$default(userGuildSettings, context, this.$model.getGuild(), Boolean.valueOf(!this.$model.getGuildSettings().isSuppressEveryone()), null, null, null, 32, null);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).q;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsRolesSwitch");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsRolesSwitch.context");
            StoreUserGuildSettings.setGuildToggles$default(userGuildSettings, context, this.$model.getGuild(), null, Boolean.valueOf(!this.$model.getGuildSettings().isSuppressRoles()), null, null, 32, null);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).o.toggle();
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).o;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsPushSwitch");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverNotificationsPushSwitch.context");
            userGuildSettings.setGuildToggles(context, this.$model.getGuild(), null, null, null, Boolean.valueOf(!this.$model.getGuildSettings().isMobilePush()));
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/servers/WidgetServerNotifications$createSwipeableItemTouchHelper$1", "Lcom/discord/utilities/views/SwipeableItemTouchHelper;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "direction", "", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$createSwipeableItemTouchHelper$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SwipeableItemTouchHelper {
        public final /* synthetic */ SwipeableItemTouchHelper.SwipeRevealConfiguration $deleteConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration2, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration3) {
            super(0, 0, swipeRevealConfiguration2, swipeRevealConfiguration3, 3, null);
            this.$deleteConfig = swipeRevealConfiguration;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
            NotificationsOverridesAdapter.Item item = (NotificationsOverridesAdapter.Item) _Collections.getOrNull(WidgetServerNotifications.access$getOverrideAdapter$p(WidgetServerNotifications.this).getData(), viewHolder.getAdapterPosition());
            if (item != null) {
                Channel channel = item.getChannel();
                if (item.getOverrideSettings().isMuted()) {
                    StoreUserGuildSettings.setChannelMuted$default(StoreStream.INSTANCE.getUserGuildSettings(), WidgetServerNotifications.this.requireContext(), channel.getId(), false, null, 8, null);
                }
                StoreStream.INSTANCE.getUserGuildSettings().setChannelFrequency(WidgetServerNotifications.this.requireContext(), channel, ModelNotificationSettings.FREQUENCY_UNSET);
            }
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "itemView", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "item", "", "invoke", "(Landroid/view/View;Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<View, NotificationsOverridesAdapter.Item, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, NotificationsOverridesAdapter.Item item) {
            invoke2(view, item);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, NotificationsOverridesAdapter.Item item) {
            Intrinsics3.checkNotNullParameter(view, "itemView");
            Intrinsics3.checkNotNullParameter(item, "item");
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, context, item.getChannel().getId(), false, 4, null);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerNotificationsOverrideSelector.INSTANCE.launch(outline.x(view, "it", "it.context"), this.$guildId);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", "it", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerNotifications$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerNotifications.access$configureUI(WidgetServerNotifications.this, model);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends NotificationsOverridesAdapter.Item>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends NotificationsOverridesAdapter.Item> list) {
            invoke2((List<NotificationsOverridesAdapter.Item>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<NotificationsOverridesAdapter.Item> list) {
            NotificationsOverridesAdapter notificationsOverridesAdapterAccess$getOverrideAdapter$p = WidgetServerNotifications.access$getOverrideAdapter$p(WidgetServerNotifications.this);
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            notificationsOverridesAdapterAccess$getOverrideAdapter$p.setData(list);
        }
    }

    public WidgetServerNotifications() {
        super(R.layout.widget_server_notifications);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerNotifications5.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerNotifications widgetServerNotifications, Model model) throws Exception {
        widgetServerNotifications.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerNotificationsBinding access$getBinding$p(WidgetServerNotifications widgetServerNotifications) {
        return widgetServerNotifications.getBinding();
    }

    public static final /* synthetic */ NotificationsOverridesAdapter access$getOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications) {
        NotificationsOverridesAdapter notificationsOverridesAdapter = widgetServerNotifications.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        return notificationsOverridesAdapter;
    }

    public static final /* synthetic */ void access$setOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications, NotificationsOverridesAdapter notificationsOverridesAdapter) {
        widgetServerNotifications.overrideAdapter = notificationsOverridesAdapter;
    }

    private final void configureForHub() {
        View view = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(8);
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(8);
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setVisibility(8);
        View view2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.serverNotificationsRolesDivider");
        view2.setVisibility(8);
        CheckedSetting checkedSetting2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverNotificationsRolesSwitch");
        checkedSetting2.setVisibility(8);
        CheckedSetting checkedSetting3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsPushSwitch");
        checkedSetting3.setVisibility(8);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverNotificationsOverrideTitle");
        textView.setVisibility(8);
        ViewAddOverrideItemBinding viewAddOverrideItemBinding = getBinding().f2538b;
        Intrinsics3.checkNotNullExpressionValue(viewAddOverrideItemBinding, "binding.addOverride");
        ConstraintLayout constraintLayout = viewAddOverrideItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.addOverride.root");
        constraintLayout.setVisibility(8);
        View view3 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(view3, "binding.serverNotificationsOverrideDivider");
        view3.setVisibility(8);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setVisibility(8);
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(8);
        View view4 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(view4, "binding.serverNotificationsHighlightsDivider");
        view4.setVisibility(8);
    }

    @MainThread
    private final void configureRadio(CheckedSetting radio, int type, Model model) {
        if (model.getNotificationsSetting() == type) {
            RadioManager radioManager = this.notificationSettingsRadioManager;
            if (radioManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
            }
            radioManager.a(radio);
        }
        if (model.getIsAboveNotifyAllSize() && type == ModelNotificationSettings.FREQUENCY_ALL) {
            CharSequence charSequenceK = FormatUtils.k(this, R.string.large_guild_notify_all_messages_description, new Object[0], null, 4);
            int i = CheckedSetting.j;
            radio.h(charSequenceK, false);
        } else {
            int i2 = CheckedSetting.j;
            radio.h(null, false);
        }
        radio.e(new AnonymousClass1(model, type));
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_settings);
        setActionBarSubtitle(model.getGuild().getName());
        ModelNotificationSettings guildSettings = model.getGuildSettings();
        boolean zIsMuted = guildSettings.isMuted();
        long id2 = model.getGuild().getId();
        View view = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(zIsMuted ^ true ? 0 : 8);
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(zIsMuted ^ true ? 0 : 8);
        getBinding().l.updateView(new NotificationMuteSettingsView.ViewState(zIsMuted, guildSettings.getMuteEndTime(), FormatUtils.h(requireContext(), R.string.form_label_mute_server, new Object[]{model.getGuild().getName()}, null, 4), FormatUtils.h(requireContext(), R.string.form_label_unmute_server, new Object[]{model.getGuild().getName()}, null, 4), FormatUtils.h(requireContext(), R.string.form_label_mobile_server_muted, new Object[0], null, 4), R.string.form_label_mobile_server_muted_until, FormatUtils.h(requireContext(), R.string.form_label_mute_server_description, new Object[0], null, 4)), new WidgetServerNotifications6(this, id2), new WidgetServerNotifications7(this, id2));
        if (model.getGuild().isHub()) {
            configureForHub();
            return;
        }
        NotificationHighlightsSettingsView.ViewState viewState = new NotificationHighlightsSettingsView.ViewState(model.getGuildSettings().isMuted(), model.getGuildSettings().getNotifyHighlights(), model.getIsAboveHighlightsSize());
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        View view2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.serverNotificationsHighlightsDivider");
        view2.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        if (model.getHighlightsEnabled()) {
            getBinding().j.updateView(viewState, new AnonymousClass1(model));
        }
        getBinding().d.setOnCheckedListener(new AnonymousClass2(model));
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setChecked(model.getGuildSettings().isSuppressEveryone());
        CheckedSetting checkedSetting2 = getBinding().d;
        CheckedSetting checkedSetting3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting2.setText(FormatUtils.j(checkedSetting3, R.string.form_label_suppress_everyone, new Object[0], null, 4));
        getBinding().q.setOnCheckedListener(new AnonymousClass3(model));
        CheckedSetting checkedSetting4 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.serverNotificationsRolesSwitch");
        checkedSetting4.setChecked(model.getGuildSettings().isSuppressRoles());
        CheckedSetting checkedSetting5 = getBinding().q;
        CheckedSetting checkedSetting6 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.serverNotificationsRolesSwitch");
        checkedSetting5.setText(FormatUtils.j(checkedSetting6, R.string.form_label_suppress_roles, new Object[0], null, 4));
        CheckedSetting checkedSetting7 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.serverNotificationsPushSwitch");
        checkedSetting7.setChecked(model.getGuildSettings().isMobilePush() && !model.getGuildSettings().isMuted());
        if (model.getGuildSettings().isMuted()) {
            CheckedSetting.d(getBinding().o, null, 1);
        } else {
            getBinding().o.e(new AnonymousClass4(model));
        }
        CheckedSetting checkedSetting8 = getBinding().f;
        CheckedSetting checkedSetting9 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.serverNotificationsFrequency1Radio");
        checkedSetting8.setText(FormatUtils.j(checkedSetting9, R.string.form_label_only_mentions, new Object[0], null, 4));
        CheckedSetting checkedSetting10 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.serverNotificationsFrequency0Radio");
        configureRadio(checkedSetting10, ModelNotificationSettings.FREQUENCY_ALL, model);
        CheckedSetting checkedSetting11 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting11, "binding.serverNotificationsFrequency1Radio");
        configureRadio(checkedSetting11, ModelNotificationSettings.FREQUENCY_MENTIONS, model);
        CheckedSetting checkedSetting12 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting12, "binding.serverNotificationsFrequency2Radio");
        configureRadio(checkedSetting12, ModelNotificationSettings.FREQUENCY_NOTHING, model);
    }

    private final ItemTouchHelper createSwipeableItemTouchHelper() {
        SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(this, R.color.status_red_500), ContextCompat.getDrawable(requireContext(), R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
        return new ItemTouchHelper(new AnonymousClass1(swipeRevealConfiguration, swipeRevealConfiguration, swipeRevealConfiguration));
    }

    private final WidgetServerNotificationsBinding getBinding() {
        return (WidgetServerNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.notificationSettingsRadioManager = new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().e, getBinding().f, getBinding().g}));
        this.overrideAdapter = new NotificationsOverridesAdapter(AnonymousClass1.INSTANCE);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsOverrideList");
        NotificationsOverridesAdapter notificationsOverridesAdapter = this.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        recyclerView2.setAdapter(notificationsOverridesAdapter);
        createSwipeableItemTouchHelper().attachToRecyclerView(getBinding().c);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        ViewAddOverrideItemBinding viewAddOverrideItemBinding = getBinding().f2538b;
        Intrinsics3.checkNotNullExpressionValue(viewAddOverrideItemBinding, "binding.addOverride");
        viewAddOverrideItemBinding.a.setOnClickListener(new AnonymousClass2(longExtra));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), WidgetServerNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable observableAccess$getNotificationOverrides = Companion.access$getNotificationOverrides(INSTANCE, longExtra);
        Intrinsics3.checkNotNullExpressionValue(observableAccess$getNotificationOverrides, "getNotificationOverrides(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableAccess$getNotificationOverrides), this, null, 2, null), WidgetServerNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
