package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.InviteGenerator;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001RB\u0087\u0001\u0012\u000e\u0010\u0016\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0015\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\n\u0010I\u001a\u00060\bj\u0002`H\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010L\u001a\u00020K\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010?\u001a\u00020>\u0012\b\b\u0002\u0010:\u001a\u000209\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010D\u001a\u00020C\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\n\u0010\n\u001a\u00060\bj\u0002`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001d\u0010\n\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b/\u00100R\u0019\u00102\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R!\u0010\u0016\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00106\u001a\u0004\b7\u00108R\u0019\u0010:\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010?\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010D\u001a\u00020C8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u00060\bj\u0002`H8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010.\u001a\u0004\bJ\u00100R\u0019\u0010L\u001a\u00020K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "viewState", "", "generateInviteLinkFromViewState", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "eventId", "", "inviteStoreKey", "Lrx/Observable;", "observeInvite", "(JLjava/lang/Long;Ljava/lang/String;)Lrx/Observable;", "Lcom/discord/models/domain/ModelInvite$Settings;", "settings", "updateInviteSettings", "(Lcom/discord/models/domain/ModelInvite$Settings;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "generateInviteLink", "(Ljava/lang/Long;)V", "Lcom/discord/models/experiments/domain/Experiment;", "getDefaultInviteExperiment", "()Lcom/discord/models/experiments/domain/Experiment;", "Lcom/discord/stores/StoreGuildScheduledEvents;", "storeGuildScheduledEvents", "Lcom/discord/stores/StoreGuildScheduledEvents;", "getStoreGuildScheduledEvents", "()Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "getStoreChannels", "()Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lcom/discord/stores/StoreInviteSettings;", "getStoreInviteSettings", "()Lcom/discord/stores/StoreInviteSettings;", "Lcom/discord/widgets/guilds/invite/InviteGenerator;", "inviteGenerator", "Lcom/discord/widgets/guilds/invite/InviteGenerator;", "J", "getGuildId", "()J", "Landroid/content/res/Resources;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "Lcom/discord/stores/StoreStageInstances;", "storeStageInstances", "Lcom/discord/stores/StoreStageInstances;", "getStoreStageInstances", "()Lcom/discord/stores/StoreStageInstances;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "getStoreUser", "()Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreInstantInvites;", "storeInstantInvites", "Lcom/discord/stores/StoreInstantInvites;", "getStoreInstantInvites", "()Lcom/discord/stores/StoreInstantInvites;", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "getGuildScheduledEventId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "getStoreGuilds", "()Lcom/discord/stores/StoreGuilds;", "<init>", "(Ljava/lang/Long;JJLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreInviteSettings;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreInstantInvites;Lcom/discord/widgets/guilds/invite/InviteGenerator;Landroid/content/res/Resources;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccessViewModel extends AppViewModel<ViewState> {
    private final Long channelId;
    private final long guildId;
    private final long guildScheduledEventId;
    private final InviteGenerator inviteGenerator;
    private final Resources resources;
    private final StoreChannels storeChannels;
    private final StoreGuildScheduledEvents storeGuildScheduledEvents;
    private final StoreGuilds storeGuilds;
    private final StoreInstantInvites storeInstantInvites;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreStageInstances storeStageInstances;
    private final StoreUser storeUser;

    /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "kotlin.jvm.PlatformType", "viewState", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ViewState.Loaded> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ViewState.Loaded loaded) {
            call2(loaded);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ViewState.Loaded loaded) {
            WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel = WidgetGuildScheduledEventCreateSuccessViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(loaded, "viewState");
            WidgetGuildScheduledEventCreateSuccessViewModel.access$generateInviteLinkFromViewState(widgetGuildScheduledEventCreateSuccessViewModel, loaded);
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel) {
            super(1, widgetGuildScheduledEventCreateSuccessViewModel, WidgetGuildScheduledEventCreateSuccessViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventCreateSuccessViewModel.access$updateViewState((WidgetGuildScheduledEventCreateSuccessViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState;", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "component1", "()Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "", "component2", "()Z", "widgetInviteModel", "showInviteSettings", "copy", "(Lcom/discord/widgets/guilds/invite/WidgetInviteModel;Z)Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "getWidgetInviteModel", "Z", "getShowInviteSettings", "<init>", "(Lcom/discord/widgets/guilds/invite/WidgetInviteModel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean showInviteSettings;
            private final WidgetInviteModel widgetInviteModel;

            public /* synthetic */ Loaded(WidgetInviteModel widgetInviteModel, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(widgetInviteModel, (i & 2) != 0 ? true : z2);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, WidgetInviteModel widgetInviteModel, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    widgetInviteModel = loaded.widgetInviteModel;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showInviteSettings;
                }
                return loaded.copy(widgetInviteModel, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final Loaded copy(WidgetInviteModel widgetInviteModel, boolean showInviteSettings) {
                Intrinsics3.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                return new Loaded(widgetInviteModel, showInviteSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.widgetInviteModel, loaded.widgetInviteModel) && this.showInviteSettings == loaded.showInviteSettings;
            }

            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
                int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
                boolean z2 = this.showInviteSettings;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(widgetInviteModel=");
                sbU.append(this.widgetInviteModel);
                sbU.append(", showInviteSettings=");
                return outline.O(sbU, this.showInviteSettings, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(WidgetInviteModel widgetInviteModel, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                this.widgetInviteModel = widgetInviteModel;
                this.showInviteSettings = z2;
            }
        }

        /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$generateInviteLink$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(1);
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Long lValueOf = this.$channelId;
            if (lValueOf == null) {
                lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
            }
            if (lValueOf != null) {
                WidgetGuildScheduledEventCreateSuccessViewModel.access$getInviteGenerator$p(WidgetGuildScheduledEventCreateSuccessViewModel.this).generateForAppComponent(WidgetGuildScheduledEventCreateSuccessViewModel.this, lValueOf.longValue());
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000f0\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lcom/discord/models/domain/ModelInvite$Settings;", "settings", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invitableChannels", "Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;", "inviteGenerationState", "Lcom/discord/models/user/MeUser;", "me", "", "dms", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/stageinstance/StageInstance;", "guildStageInstances", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "storeInvite", "defaultChannel", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "invoke", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;Lcom/discord/models/user/MeUser;Ljava/util/List;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/stores/StoreInstantInvites$InviteState;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function10<ModelInvite.Settings, Map<Long, ? extends Channel>, InviteGenerator.InviteGenerationState, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites.InviteState, Channel, ViewState.Loaded> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(10);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ ViewState.Loaded invoke(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState, Channel channel) {
            return invoke2(settings, (Map<Long, Channel>) map, inviteGenerationState, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, inviteState, channel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ViewState.Loaded invoke2(ModelInvite.Settings settings, Map<Long, Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState, Channel channel) {
            Long lValueOf;
            StoreInstantInvites.InviteState inviteState2 = inviteState;
            Intrinsics3.checkNotNullParameter(settings, "settings");
            Intrinsics3.checkNotNullParameter(map, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(list, "dms");
            Intrinsics3.checkNotNullParameter(map2, "guildStageInstances");
            Intrinsics3.checkNotNullParameter(inviteState2, "storeInvite");
            WidgetInviteModel.Companion companion = WidgetInviteModel.INSTANCE;
            if (guildScheduledEvent == null || (lValueOf = guildScheduledEvent.getChannelId()) == null) {
                lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
            }
            if (!(inviteState2 instanceof StoreInstantInvites.InviteState.Resolved)) {
                inviteState2 = null;
            }
            StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState2;
            WidgetInviteModel widgetInviteModelCreate = companion.create(settings, map, inviteGenerationState, lValueOf, meUser, list, guild, map2, guildScheduledEvent, resolved != null ? resolved.getInvite() : null);
            boolean z2 = true;
            if (widgetInviteModelCreate.getInvite() != null && (widgetInviteModelCreate.getInvite().isStatic() || widgetInviteModelCreate.isInviteFromStore())) {
                z2 = false;
            }
            return new ViewState.Loaded(widgetInviteModelCreate, z2);
        }
    }

    public /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel(Long l, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, Resources resources, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, j, j2, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings, (i & 64) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 128) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 256) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 512) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 1024) != 0 ? new InviteGenerator() : inviteGenerator, resources);
    }

    public static final /* synthetic */ void access$generateInviteLinkFromViewState(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel, ViewState.Loaded loaded) {
        widgetGuildScheduledEventCreateSuccessViewModel.generateInviteLinkFromViewState(loaded);
    }

    public static final /* synthetic */ InviteGenerator access$getInviteGenerator$p(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel) {
        return widgetGuildScheduledEventCreateSuccessViewModel.inviteGenerator;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel, ViewState viewState) {
        widgetGuildScheduledEventCreateSuccessViewModel.updateViewState(viewState);
    }

    private final void generateInviteLinkFromViewState(ViewState.Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        if (widgetInviteModel.isValidInvite() || widgetInviteModel.isGeneratingInvite() || widgetInviteModel.getTargetChannel() == null) {
            return;
        }
        this.inviteGenerator.generateForAppComponent(this, widgetInviteModel.getTargetChannel().getId());
    }

    private final Observable<ViewState.Loaded> observeInvite(long guildId, Long eventId, String inviteStoreKey) {
        Observable<ViewState.Loaded> observableR = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloads2.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), this.storeChannels.observeDefaultChannel(guildId), AnonymousClass1.INSTANCE)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableR;
    }

    public final void generateInviteLink(Long channelId) {
        Observable<Channel> observableZ = this.storeChannels.observeDefaultChannel(this.guildId).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeChannels.observeDef…tChannel(guildId).first()");
        ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetGuildScheduledEventCreateSuccessViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(channelId), 62, (Object) null);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Experiment getDefaultInviteExperiment() {
        return this.storeInviteSettings.getInviteGuildExperiment(this.guildId, true);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuildScheduledEvents getStoreGuildScheduledEvents() {
        return this.storeGuildScheduledEvents;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreInstantInvites getStoreInstantInvites() {
        return this.storeInstantInvites;
    }

    public final StoreInviteSettings getStoreInviteSettings() {
        return this.storeInviteSettings;
    }

    public final StoreStageInstances getStoreStageInstances() {
        return this.storeStageInstances;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final void updateInviteSettings(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccessViewModel(Long l, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, Resources resources) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        Intrinsics3.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        this.channelId = l;
        this.guildId = j;
        this.guildScheduledEventId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeInviteSettings = storeInviteSettings;
        this.storeUser = storeUser;
        this.storeStageInstances = storeStageInstances;
        this.storeGuildScheduledEvents = storeGuildScheduledEvents;
        this.storeInstantInvites = storeInstantInvites;
        this.inviteGenerator = inviteGenerator;
        this.resources = resources;
        Observable<ViewState.Loaded> observableU = observeInvite(j, Long.valueOf(j2), null).u(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableU, "observeInvite(guildId, g…romViewState(viewState) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableU), this, null, 2, null), WidgetGuildScheduledEventCreateSuccessViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
