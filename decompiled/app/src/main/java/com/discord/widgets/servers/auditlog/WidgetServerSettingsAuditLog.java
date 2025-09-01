package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsAuditLogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsAuditLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\"\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\u00020\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "onDestroy", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;", "adapter", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;", "", "loadingAuditLogs", "Z", "", "guildId", "J", "Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", "binding", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsAuditLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DIRECTION_DOWN = 1;
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_NAME = "GUILD_NAME";
    private static final int RESULTS_VIEW_INDEX_LOGS = 0;
    private static final int RESULTS_VIEW_INDEX_NO_LOGS = 1;
    private static final int VIEW_INDEX_LOGS_CONTENT = 1;
    private static final int VIEW_INDEX_LOGS_LOADING = 0;
    private WidgetServerSettingsAuditLogAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private boolean loadingAuditLogs;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "guildName", "", "create", "(Landroid/content/Context;JLjava/lang/String;)V", "", "DIRECTION_DOWN", "I", WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, "Ljava/lang/String;", "INTENT_EXTRA_GUILD_NAME", "RESULTS_VIEW_INDEX_LOGS", "RESULTS_VIEW_INDEX_NO_LOGS", "VIEW_INDEX_LOGS_CONTENT", "VIEW_INDEX_LOGS_LOADING", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, String guildName) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(guildName, "guildName");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("AUDIT_LOG", guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsAuditLog.INTENT_EXTRA_GUILD_ID, guildId).putExtra(WidgetServerSettingsAuditLog.INTENT_EXTRA_GUILD_NAME, guildName);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_GUILD_NAME, guildName)");
            AppScreen2.d(context, WidgetServerSettingsAuditLog.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "", "<init>", "()V", "Companion", "Loaded", "Loading", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model$Loading;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\u0010\r\u001a\u00060\u0003j\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model$Companion;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/models/domain/ModelAuditLogEntry;", "entry", "", "resolveChannelName", "(Ljava/util/Map;Lcom/discord/models/domain/ModelAuditLogEntry;)Ljava/lang/String;", "Lcom/discord/primitives/GuildId;", "guildId", "Landroid/content/Context;", "context", "Lrx/Observable;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "get", "(JLandroid/content/Context;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    ModelAuditLogEntry.TargetType.values();
                    int[] iArr = new int[15];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[ModelAuditLogEntry.TargetType.CHANNEL.ordinal()] = 1;
                    iArr[ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE.ordinal()] = 2;
                    iArr[ModelAuditLogEntry.TargetType.USER.ordinal()] = 3;
                    iArr[ModelAuditLogEntry.TargetType.ROLE.ordinal()] = 4;
                    iArr[ModelAuditLogEntry.TargetType.GUILD.ordinal()] = 5;
                    iArr[ModelAuditLogEntry.TargetType.INVITE.ordinal()] = 6;
                    iArr[ModelAuditLogEntry.TargetType.ALL.ordinal()] = 7;
                    iArr[ModelAuditLogEntry.TargetType.WEBHOOK.ordinal()] = 8;
                    iArr[ModelAuditLogEntry.TargetType.EMOJI.ordinal()] = 9;
                    iArr[ModelAuditLogEntry.TargetType.INTEGRATION.ordinal()] = 10;
                    iArr[ModelAuditLogEntry.TargetType.STAGE_INSTANCE.ordinal()] = 11;
                    iArr[ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 12;
                    iArr[ModelAuditLogEntry.TargetType.THREAD.ordinal()] = 13;
                    iArr[ModelAuditLogEntry.TargetType.UNKNOWN.ordinal()] = 14;
                    iArr[ModelAuditLogEntry.TargetType.STICKER.ordinal()] = 15;
                }
            }

            private Companion() {
            }

            public static final /* synthetic */ String access$resolveChannelName(Companion companion, Map map, ModelAuditLogEntry modelAuditLogEntry) {
                return companion.resolveChannelName(map, modelAuditLogEntry);
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00ac  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private final String resolveChannelName(Map<Long, Channel> channels, ModelAuditLogEntry entry) {
                Object next;
                Object next2;
                Channel channel = channels.get(Long.valueOf(entry.getTargetId()));
                if (channel != null) {
                    boolean zV = ChannelUtils.v(channel);
                    if (zV) {
                        StringBuilder sbQ = outline.Q(MentionUtils.CHANNELS_CHAR);
                        sbQ.append(ChannelUtils.c(channel));
                        return sbQ.toString();
                    }
                    if (zV) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return ChannelUtils.c(channel);
                }
                if (entry.getActionTypeId() == 12) {
                    List<ModelAuditLogEntry.Change> changes = entry.getChanges();
                    if (changes != null) {
                        Iterator<T> it = changes.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it.next();
                            ModelAuditLogEntry.Change change = (ModelAuditLogEntry.Change) next2;
                            Intrinsics3.checkNotNullExpressionValue(change, "it");
                            if (Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                break;
                            }
                        }
                        ModelAuditLogEntry.Change change2 = (ModelAuditLogEntry.Change) next2;
                        Object oldValue = change2 != null ? change2.getOldValue() : null;
                        if (!(oldValue instanceof String)) {
                            oldValue = null;
                        }
                        String str = (String) oldValue;
                        List<ModelAuditLogEntry.Change> changes2 = entry.getChanges();
                        if (changes2 != null) {
                            Iterator<T> it2 = changes2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                ModelAuditLogEntry.Change change3 = (ModelAuditLogEntry.Change) next;
                                Intrinsics3.checkNotNullExpressionValue(change3, "it");
                                if (Intrinsics3.areEqual(change3.getKey(), "type")) {
                                    break;
                                }
                            }
                            ModelAuditLogEntry.Change change4 = (ModelAuditLogEntry.Change) next;
                            Object oldValue2 = change4 != null ? change4.getOldValue() : null;
                            if (!(oldValue2 instanceof Long)) {
                                oldValue2 = null;
                            }
                            Long l = (Long) oldValue2;
                            if (str != null && l != null) {
                                boolean zL = ChannelUtils.l((int) l.longValue());
                                if (!zL) {
                                    if (zL) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return str;
                                }
                                return MentionUtils.CHANNELS_CHAR + str;
                            }
                        }
                    }
                }
                return null;
            }

            public final Observable<Model> get(long guildId, Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableR = Observable.f(companion.getAuditLog().observeAuditLogState(guildId), companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), ObservableExtensionsKt.leadingEdgeThrottle(companion.getUsers().observeAllUsers(), 3L, TimeUnit.SECONDS), companion.getGuilds().observeRoles(guildId), companion.getGuilds().observeComputed(guildId), new WidgetServerSettingsAuditLog3(guildId, context)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model$Loaded;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "", "usernameFilterText", "Ljava/lang/CharSequence;", "getUsernameFilterText", "()Ljava/lang/CharSequence;", "actionFilterText", "getActionFilterText", "", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "auditLogEntryItems", "Ljava/util/List;", "getAuditLogEntryItems", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends Model {
            private final CharSequence actionFilterText;
            private final List<MGRecyclerDataPayload> auditLogEntryItems;
            private final CharSequence usernameFilterText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends MGRecyclerDataPayload> list, CharSequence charSequence, CharSequence charSequence2) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "auditLogEntryItems");
                Intrinsics3.checkNotNullParameter(charSequence, "usernameFilterText");
                Intrinsics3.checkNotNullParameter(charSequence2, "actionFilterText");
                this.auditLogEntryItems = list;
                this.usernameFilterText = charSequence;
                this.actionFilterText = charSequence2;
            }

            public final CharSequence getActionFilterText() {
                return this.actionFilterText;
            }

            public final List<MGRecyclerDataPayload> getAuditLogEntryItems() {
                return this.auditLogEntryItems;
            }

            public final CharSequence getUsernameFilterText() {
                return this.usernameFilterText;
            }
        }

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model$Loading;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Menu> {

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class ViewOnClickListenerC03161 implements View.OnClickListener {

            /* compiled from: WidgetServerSettingsAuditLog.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "it", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03171 implements PopupMenu.OnMenuItemClickListener {
                public final /* synthetic */ View $view;

                public C03171(View view) {
                    this.$view = view;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intrinsics3.checkNotNullExpressionValue(menuItem, "it");
                    switch (menuItem.getItemId()) {
                        case R.id.menu_audit_log_sort_actions /* 2131364361 */:
                            WidgetServerSettingsAuditLogFilter.INSTANCE.show(outline.x(this.$view, "view", "view.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 1);
                            return true;
                        case R.id.menu_audit_log_sort_users /* 2131364362 */:
                            WidgetServerSettingsAuditLogFilter.INSTANCE.show(outline.x(this.$view, "view", "view.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 0);
                            return true;
                        default:
                            return true;
                    }
                }
            }

            public ViewOnClickListenerC03161() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(WidgetServerSettingsAuditLog.this.getContext(), 2131951663), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_audit_log_sort, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new C03171(view));
                popupMenu.show();
            }
        }

        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            View actionView;
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_filter);
            if (menuItemFindItem == null || (actionView = menuItemFindItem.getActionView()) == null) {
                return;
            }
            actionView.setOnClickListener(new ViewOnClickListenerC03161());
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$onViewBound$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends RecyclerView.OnScrollListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (recyclerView.canScrollVertically(1)) {
                return;
            }
            StoreStream.INSTANCE.getAuditLog().fetchMoreAuditLogEntries();
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsAuditLogFilter.INSTANCE.show(outline.x(view, "it", "it.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 0);
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsAuditLogFilter.INSTANCE.show(outline.x(view, "it", "it.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 1);
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
            super(1, widgetServerSettingsAuditLog, WidgetServerSettingsAuditLog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetServerSettingsAuditLog.access$configureUI((WidgetServerSettingsAuditLog) this.receiver, model);
        }
    }

    public WidgetServerSettingsAuditLog() {
        super(R.layout.widget_server_settings_audit_log);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsAuditLog4.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsAuditLog5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog, Model model) {
        widgetServerSettingsAuditLog.configureUI(model);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        return widgetServerSettingsAuditLog.guildId;
    }

    public static final /* synthetic */ void access$setGuildId$p(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog, long j) {
        widgetServerSettingsAuditLog.guildId = j;
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (model instanceof Model.Loaded) {
            WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = this.adapter;
            if (widgetServerSettingsAuditLogAdapter != null) {
                widgetServerSettingsAuditLogAdapter.configure(((Model.Loaded) model).getAuditLogEntryItems());
            }
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsAuditLogsUserFilter");
            Model.Loaded loaded = (Model.Loaded) model;
            textView.setText(loaded.getUsernameFilterText());
            TextView textView2 = getBinding().f2539b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsAuditLogsActionFilter");
            textView2.setText(loaded.getActionFilterText());
            if (!loaded.getAuditLogEntryItems().isEmpty()) {
                AppViewFlipper appViewFlipper3 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper3.setDisplayedChild(0);
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper4.setDisplayedChild(1);
            }
            this.loadingAuditLogs = false;
        }
    }

    public static final void create(Context context, long j, String str) {
        INSTANCE.create(context, j, str);
    }

    private final WidgetServerSettingsAuditLogBinding getBinding() {
        return (WidgetServerSettingsAuditLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            StoreStream.INSTANCE.getAuditLog().clearState();
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        this.guildId = longExtra;
        if (longExtra == -1) {
            AppToast.g(getContext(), R.string.crash_unexpected, 0, null, 12);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
        setActionBarTitle(R.string.guild_settings_label_audit_log);
        setActionBarSubtitle(getMostRecentIntent().getStringExtra(INTENT_EXTRA_GUILD_NAME));
        setActionBarOptionsMenu(R.menu.menu_filter, null, new AnonymousClass1());
        getBinding().c.addOnScrollListener(new AnonymousClass2());
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsAuditLogsRecycler");
        WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = (WidgetServerSettingsAuditLogAdapter) companion.configure(new WidgetServerSettingsAuditLogAdapter(recyclerView));
        widgetServerSettingsAuditLogAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLog2(this));
        this.adapter = widgetServerSettingsAuditLogAdapter;
        getBinding().d.setOnClickListener(new AnonymousClass4());
        getBinding().f2539b.setOnClickListener(new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(this.guildId, requireContext())), this, null, 2, null), WidgetServerSettingsAuditLog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
