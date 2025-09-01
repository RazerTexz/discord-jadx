package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GuildInviteSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004789:BG\u0012\u000e\u0010%\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\u0010(\u001a\u00060\bj\u0002`'\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b5\u00106J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u0012J\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010%\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010(\u001a\u00060\bj\u0002`'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;)V", "", "Lcom/discord/primitives/ChannelId;", "targetChannelId", "generateInviteForChannel", "(J)V", "Lcom/discord/models/domain/ModelInvite;", "invite", "handleInviteCreationSuccess", "(Lcom/discord/models/domain/ModelInvite;)V", "handleInviteCreationFailure", "()V", "Lrx/Observable;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/models/domain/ModelInvite$Settings;", "settings", "updatePendingInviteSettings", "(Lcom/discord/models/domain/ModelInvite$Settings;)V", "saveInviteSettings", "Lcom/discord/api/channel/Channel;", "channel", "selectChannel", "(Lcom/discord/api/channel/Channel;)V", "Lrx/subjects/PublishSubject;", "eventSubject", "Lrx/subjects/PublishSubject;", "targetChannel", "Lcom/discord/api/channel/Channel;", "channelId", "Ljava/lang/Long;", "Lcom/discord/primitives/GuildId;", "guildId", "J", "currentStoreState", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "inviteSettings", "Lcom/discord/models/domain/ModelInvite$Settings;", "Lcom/discord/widgets/guilds/invite/TargetChannelSelector;", "targetChannelSelector", "Lcom/discord/widgets/guilds/invite/TargetChannelSelector;", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lcom/discord/stores/StoreInviteSettings;", "storeStateObservable", "<init>", "(Ljava/lang/Long;JLcom/discord/stores/StoreInviteSettings;Lcom/discord/widgets/guilds/invite/TargetChannelSelector;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private StoreState currentStoreState;
    private PublishSubject<Event> eventSubject;
    private final long guildId;
    private ModelInvite.Settings inviteSettings;
    private final StoreInviteSettings storeInviteSettings;
    private Channel targetChannel;
    private final TargetChannelSelector targetChannelSelector;

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildInviteSettingsViewModel.access$handleStoreState(GuildInviteSettingsViewModel.this, storeState);
        }
    }

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreInviteSettings;", "storeInviteSettings", "Lrx/Observable;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreInviteSettings;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreInviteSettings storeInviteSettings) {
            return companion.observeStoreState(j, storeInviteSettings);
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreInviteSettings storeInviteSettings) {
            Observable<StoreState> observableJ = Observable.j(storeInviteSettings.getInviteSettings(), storeInviteSettings.getInvitableChannels(guildId), GuildInviteSettingsViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…hannels\n        )\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;", "", "<init>", "()V", "InviteCreationFailure", "InviteCreationSuccess", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event$InviteCreationSuccess;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event$InviteCreationFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: GuildInviteSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event$InviteCreationFailure;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class InviteCreationFailure extends Event {
            public static final InviteCreationFailure INSTANCE = new InviteCreationFailure();

            private InviteCreationFailure() {
                super(null);
            }
        }

        /* compiled from: GuildInviteSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event$InviteCreationSuccess;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "component1", "()Lcom/discord/widgets/guilds/invite/GuildInvite;", "invite", "copy", "(Lcom/discord/widgets/guilds/invite/GuildInvite;)Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event$InviteCreationSuccess;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "getInvite", "<init>", "(Lcom/discord/widgets/guilds/invite/GuildInvite;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class InviteCreationSuccess extends Event {
            private final GuildInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InviteCreationSuccess(GuildInvite guildInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildInvite, "invite");
                this.invite = guildInvite;
            }

            public static /* synthetic */ InviteCreationSuccess copy$default(InviteCreationSuccess inviteCreationSuccess, GuildInvite guildInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildInvite = inviteCreationSuccess.invite;
                }
                return inviteCreationSuccess.copy(guildInvite);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildInvite getInvite() {
                return this.invite;
            }

            public final InviteCreationSuccess copy(GuildInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new InviteCreationSuccess(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof InviteCreationSuccess) && Intrinsics3.areEqual(this.invite, ((InviteCreationSuccess) other).invite);
                }
                return true;
            }

            public final GuildInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                GuildInvite guildInvite = this.invite;
                if (guildInvite != null) {
                    return guildInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("InviteCreationSuccess(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R)\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "", "Lcom/discord/models/domain/ModelInvite$Settings;", "component1", "()Lcom/discord/models/domain/ModelInvite$Settings;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component2", "()Ljava/util/Map;", "inviteSettings", "invitableChannels", "copy", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;)Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelInvite$Settings;", "getInviteSettings", "Ljava/util/Map;", "getInvitableChannels", "<init>", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> invitableChannels;
        private final ModelInvite.Settings inviteSettings;

        public StoreState(ModelInvite.Settings settings, Map<Long, Channel> map) {
            Intrinsics3.checkNotNullParameter(settings, "inviteSettings");
            Intrinsics3.checkNotNullParameter(map, "invitableChannels");
            this.inviteSettings = settings;
            this.invitableChannels = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, ModelInvite.Settings settings, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                settings = storeState.inviteSettings;
            }
            if ((i & 2) != 0) {
                map = storeState.invitableChannels;
            }
            return storeState.copy(settings, map);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final Map<Long, Channel> component2() {
            return this.invitableChannels;
        }

        public final StoreState copy(ModelInvite.Settings inviteSettings, Map<Long, Channel> invitableChannels) {
            Intrinsics3.checkNotNullParameter(inviteSettings, "inviteSettings");
            Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
            return new StoreState(inviteSettings, invitableChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.inviteSettings, storeState.inviteSettings) && Intrinsics3.areEqual(this.invitableChannels, storeState.invitableChannels);
        }

        public final Map<Long, Channel> getInvitableChannels() {
            return this.invitableChannels;
        }

        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public int hashCode() {
            ModelInvite.Settings settings = this.inviteSettings;
            int iHashCode = (settings != null ? settings.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.invitableChannels;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(inviteSettings=");
            sbU.append(this.inviteSettings);
            sbU.append(", invitableChannels=");
            return outline.M(sbU, this.invitableChannels, ")");
        }
    }

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005¨\u0006\""}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;", "", "", "Lcom/discord/api/channel/Channel;", "component1", "()Ljava/util/List;", "Lcom/discord/models/domain/ModelInvite$Settings;", "component2", "()Lcom/discord/models/domain/ModelInvite$Settings;", "component3", "()Lcom/discord/api/channel/Channel;", "invitableChannels", "inviteSettings", "targetChannel", "copy", "(Ljava/util/List;Lcom/discord/models/domain/ModelInvite$Settings;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelInvite$Settings;", "getInviteSettings", "Lcom/discord/api/channel/Channel;", "getTargetChannel", "Ljava/util/List;", "getInvitableChannels", "<init>", "(Ljava/util/List;Lcom/discord/models/domain/ModelInvite$Settings;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final List<Channel> invitableChannels;
        private final ModelInvite.Settings inviteSettings;
        private final Channel targetChannel;

        public ViewState(List<Channel> list, ModelInvite.Settings settings, Channel channel) {
            Intrinsics3.checkNotNullParameter(list, "invitableChannels");
            Intrinsics3.checkNotNullParameter(settings, "inviteSettings");
            this.invitableChannels = list;
            this.inviteSettings = settings;
            this.targetChannel = channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, ModelInvite.Settings settings, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.invitableChannels;
            }
            if ((i & 2) != 0) {
                settings = viewState.inviteSettings;
            }
            if ((i & 4) != 0) {
                channel = viewState.targetChannel;
            }
            return viewState.copy(list, settings, channel);
        }

        public final List<Channel> component1() {
            return this.invitableChannels;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getTargetChannel() {
            return this.targetChannel;
        }

        public final ViewState copy(List<Channel> invitableChannels, ModelInvite.Settings inviteSettings, Channel targetChannel) {
            Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteSettings, "inviteSettings");
            return new ViewState(invitableChannels, inviteSettings, targetChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.invitableChannels, viewState.invitableChannels) && Intrinsics3.areEqual(this.inviteSettings, viewState.inviteSettings) && Intrinsics3.areEqual(this.targetChannel, viewState.targetChannel);
        }

        public final List<Channel> getInvitableChannels() {
            return this.invitableChannels;
        }

        public final ModelInvite.Settings getInviteSettings() {
            return this.inviteSettings;
        }

        public final Channel getTargetChannel() {
            return this.targetChannel;
        }

        public int hashCode() {
            List<Channel> list = this.invitableChannels;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            ModelInvite.Settings settings = this.inviteSettings;
            int iHashCode2 = (iHashCode + (settings != null ? settings.hashCode() : 0)) * 31;
            Channel channel = this.targetChannel;
            return iHashCode2 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(invitableChannels=");
            sbU.append(this.invitableChannels);
            sbU.append(", inviteSettings=");
            sbU.append(this.inviteSettings);
            sbU.append(", targetChannel=");
            sbU.append(this.targetChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$generateInviteForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            GuildInviteSettingsViewModel.access$handleInviteCreationSuccess(GuildInviteSettingsViewModel.this, modelInvite);
        }
    }

    /* compiled from: GuildInviteSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$generateInviteForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            GuildInviteSettingsViewModel.access$handleInviteCreationFailure(GuildInviteSettingsViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreInviteSettings inviteSettings = (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings;
        this(l, j, inviteSettings, (i & 8) != 0 ? new TargetChannelSelector() : targetChannelSelector, (i & 16) != 0 ? Companion.access$observeStoreState(INSTANCE, j, inviteSettings) : observable);
    }

    public static final /* synthetic */ void access$handleInviteCreationFailure(GuildInviteSettingsViewModel guildInviteSettingsViewModel) {
        guildInviteSettingsViewModel.handleInviteCreationFailure();
    }

    public static final /* synthetic */ void access$handleInviteCreationSuccess(GuildInviteSettingsViewModel guildInviteSettingsViewModel, ModelInvite modelInvite) {
        guildInviteSettingsViewModel.handleInviteCreationSuccess(modelInvite);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteSettingsViewModel guildInviteSettingsViewModel, StoreState storeState) {
        guildInviteSettingsViewModel.handleStoreState(storeState);
    }

    private final void generateInviteForChannel(long targetChannelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StoreInviteSettings.generateInvite$default(this.storeInviteSettings, targetChannelId, null, 2, null), false, 1, null), this, null, 2, null), GuildInviteSettingsViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    private final void handleInviteCreationFailure() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.InviteCreationFailure.INSTANCE);
    }

    @MainThread
    private final void handleInviteCreationSuccess(ModelInvite invite) {
        GuildInvite guildInviteCreateFromModelInvite = GuildInvite.INSTANCE.createFromModelInvite(invite);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.InviteCreationSuccess(guildInviteCreateFromModelInvite));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ModelInvite.Settings inviteSettings = this.inviteSettings;
        if (inviteSettings == null) {
            this.inviteSettings = storeState.getInviteSettings();
            inviteSettings = storeState.getInviteSettings();
        }
        Map<Long, Channel> invitableChannels = storeState.getInvitableChannels();
        Channel targetChannel = this.targetChannel;
        if (targetChannel == null) {
            targetChannel = this.targetChannelSelector.getTargetChannel(invitableChannels, this.channelId);
            this.targetChannel = targetChannel;
        }
        updateViewState(new ViewState(_Collections.toList(invitableChannels.values()), inviteSettings, targetChannel));
        this.currentStoreState = storeState;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveInviteSettings() {
        Channel channel;
        ModelInvite.Settings settings = this.inviteSettings;
        if (settings == null || (channel = this.targetChannel) == null) {
            return;
        }
        this.storeInviteSettings.setInviteSettings(settings);
        generateInviteForChannel(channel.getId());
    }

    @MainThread
    public final void selectChannel(Channel channel) {
        ViewState viewState = getViewState();
        if (viewState == null || channel == null) {
            return;
        }
        this.targetChannel = channel;
        updateViewState(ViewState.copy$default(viewState, null, null, channel, 3, null));
    }

    @MainThread
    public final void updatePendingInviteSettings(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "settings");
        ViewState viewState = getViewState();
        if (viewState != null) {
            this.inviteSettings = settings;
            updateViewState(ViewState.copy$default(viewState, null, settings, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteSettingsViewModel(Long l, long j, StoreInviteSettings storeInviteSettings, TargetChannelSelector targetChannelSelector, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        Intrinsics3.checkNotNullParameter(targetChannelSelector, "targetChannelSelector");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = l;
        this.guildId = j;
        this.storeInviteSettings = storeInviteSettings;
        this.targetChannelSelector = targetChannelSelector;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
