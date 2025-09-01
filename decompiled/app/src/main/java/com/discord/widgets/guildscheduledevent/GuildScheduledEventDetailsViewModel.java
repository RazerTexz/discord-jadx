package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildScheduledEventDetailsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003@ABB\u0097\u0001\u0012\u0006\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u00109\u001a\u000208\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030<\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u001a¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\fJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006C"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "storeState", "Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "getRsvpUsersFetchState", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "", "handleStoreState", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)V", "onRsvpButtonClicked", "()V", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "weakFragment", "onShareButtonClicked", "(Ljava/lang/ref/WeakReference;)V", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "onSuccess", "onDeleteButtonClicked", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "endEventClicked", "onGuildNameClicked", "", "index", "setSegmentedControlIndex", "(I)V", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "segmentControlIndex", "I", "rsvpUsersFetchState", "Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;", "section", "Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreUserSettings;", "userSettingsStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreDirectories;Lrx/Observable;Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;I)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WidgetGuildScheduledEventDetailsBottomSheet2 args;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState;
    private GuildScheduledEventDetailsViewModel3 section;
    private int segmentControlIndex;
    private final StoreUser userStore;

    /* compiled from: GuildScheduledEventDetailsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel) {
            super(1, guildScheduledEventDetailsViewModel, GuildScheduledEventDetailsViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            GuildScheduledEventDetailsViewModel.access$handleStoreState((GuildScheduledEventDetailsViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: GuildScheduledEventDetailsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJe\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$Companion;", "", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreUserSettings;", "userSettingsStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lrx/Observable;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "observeStores", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreDirectories;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                WidgetGuildScheduledEventDetailsBottomSheet3.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3 = WidgetGuildScheduledEventDetailsBottomSheet3.Directory;
                iArr[widgetGuildScheduledEventDetailsBottomSheet3.ordinal()] = 1;
                WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet32 = WidgetGuildScheduledEventDetailsBottomSheet3.Guild;
                iArr[widgetGuildScheduledEventDetailsBottomSheet32.ordinal()] = 2;
                WidgetGuildScheduledEventDetailsBottomSheet3.values();
                int[] iArr2 = new int[2];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[widgetGuildScheduledEventDetailsBottomSheet3.ordinal()] = 1;
                iArr2[widgetGuildScheduledEventDetailsBottomSheet32.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories) {
            return companion.observeStores(widgetGuildScheduledEventDetailsBottomSheet2, observationDeck, storeGuildScheduledEvents, storeGuilds, storeUser, storeChannels, storePermissions, storeUserSettings, storeVoiceChannelSelected, storeDirectories);
        }

        private final Observable<StoreState> observeStores(WidgetGuildScheduledEventDetailsBottomSheet2 args, ObservationDeck observationDeck, StoreGuildScheduledEvents guildScheduledEventsStore, StoreGuilds guildsStore, StoreUser userStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreUserSettings userSettingsStore, StoreVoiceChannelSelected selectedVoiceChannelStore, StoreDirectories directoriesStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildScheduledEventsStore, guildsStore, userStore, channelsStore, permissionsStore, selectedVoiceChannelStore, directoriesStore}, false, null, null, new GuildScheduledEventDetailsViewModel6(args, directoriesStore, guildScheduledEventsStore, guildsStore, channelsStore, selectedVoiceChannelStore, permissionsStore, userSettingsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildScheduledEventDetailsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010)\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016\u0012\b\b\u0002\u0010*\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\b\b\u0002\u0010,\u001a\u00020\u000e\u0012\b\b\u0002\u0010-\u001a\u00020\u000e¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J\u0018\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010\u001f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0010J²\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\u0010\b\u0002\u0010)\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00162\b\b\u0002\u0010*\u001a\u00020\u000e2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b7\u00108R\u0019\u0010(\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00109\u001a\u0004\b(\u0010\u0010R!\u0010)\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b;\u0010\u0018R\u0019\u0010*\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u00109\u001a\u0004\b<\u0010\u0010R\u0019\u0010,\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u00109\u001a\u0004\b,\u0010\u0010R\u0019\u0010-\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u00109\u001a\u0004\b-\u0010\u0010R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010=\u001a\u0004\b>\u0010\u0004R\u0019\u0010&\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\b?\u0010\u0010R\u0019\u0010%\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\b%\u0010\u0010R\u001b\u0010\"\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010\nR\u0019\u0010$\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00109\u001a\u0004\b$\u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010B\u001a\u0004\bC\u0010\u0007R\u0019\u0010'\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u00109\u001a\u0004\bD\u0010\u0010R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010E\u001a\u0004\bF\u0010\u001dR\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010G\u001a\u0004\bH\u0010\r¨\u0006K"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/guild/UserGuildMember;", "component4", "()Lcom/discord/models/guild/UserGuildMember;", "", "component5", "()Z", "component6", "component7", "component8", "component9", "", "Lcom/discord/primitives/ChannelId;", "component10", "()Ljava/lang/Long;", "component11", "", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "component12", "()Ljava/util/List;", "component13", "component14", "guildScheduledEvent", "channel", "guild", "creator", "isInGuild", "isRsvped", "canShare", "canStartEvent", "isDeveloperMode", "selectedVoiceChannelId", "canConnect", "rsvpUsers", "isRsvpUsersFetching", "isRsvpUsersError", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/UserGuildMember;ZZZZZLjava/lang/Long;ZLjava/util/List;ZZ)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Long;", "getSelectedVoiceChannelId", "getCanConnect", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "getCanShare", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/channel/Channel;", "getChannel", "getCanStartEvent", "Ljava/util/List;", "getRsvpUsers", "Lcom/discord/models/guild/UserGuildMember;", "getCreator", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/UserGuildMember;ZZZZZLjava/lang/Long;ZLjava/util/List;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean canConnect;
        private final boolean canShare;
        private final boolean canStartEvent;
        private final Channel channel;
        private final UserGuildMember creator;
        private final Guild guild;
        private final GuildScheduledEvent guildScheduledEvent;
        private final boolean isDeveloperMode;
        private final boolean isInGuild;
        private final boolean isRsvpUsersError;
        private final boolean isRsvpUsersFetching;
        private final boolean isRsvped;
        private final List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers;
        private final Long selectedVoiceChannelId;

        public StoreState() {
            this(null, null, null, null, false, false, false, false, false, null, false, null, false, false, 16383, null);
        }

        public StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List<GuildScheduledEventRsvpUserListItem.RsvpUser> list, boolean z8, boolean z9) {
            Intrinsics3.checkNotNullParameter(list, "rsvpUsers");
            this.guildScheduledEvent = guildScheduledEvent;
            this.channel = channel;
            this.guild = guild;
            this.creator = userGuildMember;
            this.isInGuild = z2;
            this.isRsvped = z3;
            this.canShare = z4;
            this.canStartEvent = z5;
            this.isDeveloperMode = z6;
            this.selectedVoiceChannelId = l;
            this.canConnect = z7;
            this.rsvpUsers = list;
            this.isRsvpUsersFetching = z8;
            this.isRsvpUsersError = z9;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List list, boolean z8, boolean z9, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.guildScheduledEvent : guildScheduledEvent, (i & 2) != 0 ? storeState.channel : channel, (i & 4) != 0 ? storeState.guild : guild, (i & 8) != 0 ? storeState.creator : userGuildMember, (i & 16) != 0 ? storeState.isInGuild : z2, (i & 32) != 0 ? storeState.isRsvped : z3, (i & 64) != 0 ? storeState.canShare : z4, (i & 128) != 0 ? storeState.canStartEvent : z5, (i & 256) != 0 ? storeState.isDeveloperMode : z6, (i & 512) != 0 ? storeState.selectedVoiceChannelId : l, (i & 1024) != 0 ? storeState.canConnect : z7, (i & 2048) != 0 ? storeState.rsvpUsers : list, (i & 4096) != 0 ? storeState.isRsvpUsersFetching : z8, (i & 8192) != 0 ? storeState.isRsvpUsersError : z9);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        /* renamed from: component10, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> component12() {
            return this.rsvpUsers;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getIsRsvpUsersFetching() {
            return this.isRsvpUsersFetching;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getIsRsvpUsersError() {
            return this.isRsvpUsersError;
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
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsInGuild() {
            return this.isInGuild;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsDeveloperMode() {
            return this.isDeveloperMode;
        }

        public final StoreState copy(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, boolean isInGuild, boolean isRsvped, boolean canShare, boolean canStartEvent, boolean isDeveloperMode, Long selectedVoiceChannelId, boolean canConnect, List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers, boolean isRsvpUsersFetching, boolean isRsvpUsersError) {
            Intrinsics3.checkNotNullParameter(rsvpUsers, "rsvpUsers");
            return new StoreState(guildScheduledEvent, channel, guild, creator, isInGuild, isRsvped, canShare, canStartEvent, isDeveloperMode, selectedVoiceChannelId, canConnect, rsvpUsers, isRsvpUsersFetching, isRsvpUsersError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildScheduledEvent, storeState.guildScheduledEvent) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.creator, storeState.creator) && this.isInGuild == storeState.isInGuild && this.isRsvped == storeState.isRsvped && this.canShare == storeState.canShare && this.canStartEvent == storeState.canStartEvent && this.isDeveloperMode == storeState.isDeveloperMode && Intrinsics3.areEqual(this.selectedVoiceChannelId, storeState.selectedVoiceChannelId) && this.canConnect == storeState.canConnect && Intrinsics3.areEqual(this.rsvpUsers, storeState.rsvpUsers) && this.isRsvpUsersFetching == storeState.isRsvpUsersFetching && this.isRsvpUsersError == storeState.isRsvpUsersError;
        }

        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final boolean getCanShare() {
            return this.canShare;
        }

        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> getRsvpUsers() {
            return this.rsvpUsers;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode4 = (iHashCode3 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            boolean z2 = this.isInGuild;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            boolean z3 = this.isRsvped;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canShare;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.canStartEvent;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.isDeveloperMode;
            int i9 = z6;
            if (z6 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode5 = (i10 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z7 = this.canConnect;
            int i11 = z7;
            if (z7 != 0) {
                i11 = 1;
            }
            int i12 = (iHashCode5 + i11) * 31;
            List<GuildScheduledEventRsvpUserListItem.RsvpUser> list = this.rsvpUsers;
            int iHashCode6 = (i12 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z8 = this.isRsvpUsersFetching;
            int i13 = z8;
            if (z8 != 0) {
                i13 = 1;
            }
            int i14 = (iHashCode6 + i13) * 31;
            boolean z9 = this.isRsvpUsersError;
            return i14 + (z9 ? 1 : z9 ? 1 : 0);
        }

        public final boolean isDeveloperMode() {
            return this.isDeveloperMode;
        }

        public final boolean isInGuild() {
            return this.isInGuild;
        }

        public final boolean isRsvpUsersError() {
            return this.isRsvpUsersError;
        }

        public final boolean isRsvpUsersFetching() {
            return this.isRsvpUsersFetching;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", isInGuild=");
            sbU.append(this.isInGuild);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", canShare=");
            sbU.append(this.canShare);
            sbU.append(", canStartEvent=");
            sbU.append(this.canStartEvent);
            sbU.append(", isDeveloperMode=");
            sbU.append(this.isDeveloperMode);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", canConnect=");
            sbU.append(this.canConnect);
            sbU.append(", rsvpUsers=");
            sbU.append(this.rsvpUsers);
            sbU.append(", isRsvpUsersFetching=");
            sbU.append(this.isRsvpUsersFetching);
            sbU.append(", isRsvpUsersError=");
            return outline.O(sbU, this.isRsvpUsersError, ")");
        }

        public /* synthetic */ StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List list, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guildScheduledEvent, (i & 2) != 0 ? null : channel, (i & 4) != 0 ? null : guild, (i & 8) != 0 ? null : userGuildMember, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? false : z5, (i & 256) != 0 ? false : z6, (i & 512) == 0 ? l : null, (i & 1024) != 0 ? false : z7, (i & 2048) != 0 ? Collections2.emptyList() : list, (i & 4096) != 0 ? false : z8, (i & 8192) == 0 ? z9 : false);
        }
    }

    /* compiled from: GuildScheduledEventDetailsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "", "<init>", "()V", "Initialized", "Invalid", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Initialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildScheduledEventDetailsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010)\u001a\u00020\b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010+\u001a\u00020\u000e\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\u0006\u0010-\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u0010/\u001a\u00020\u000e\u0012\u0006\u00100\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u00020\u000e\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u00103\u001a\u00020\u001b\u0012\u0006\u00104\u001a\u00020\u001e\u0012\u0006\u00105\u001a\u00020!\u0012\b\u00106\u001a\u0004\u0018\u00010$¢\u0006\u0004\bW\u0010XJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010%\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0004\b%\u0010&J¼\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010'\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u00103\u001a\u00020\u001b2\b\b\u0002\u00104\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020!2\n\b\u0002\u00106\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0004\b7\u00108J\u0010\u0010:\u001a\u000209HÖ\u0001¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020!HÖ\u0001¢\u0006\u0004\b<\u0010#J\u001a\u0010?\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010=HÖ\u0003¢\u0006\u0004\b?\u0010@R\u0019\u00100\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010A\u001a\u0004\b0\u0010\u0010R\u0019\u00105\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010B\u001a\u0004\bC\u0010#R\u0019\u0010'\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010D\u001a\u0004\bE\u0010\u0004R\u0019\u0010.\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010A\u001a\u0004\b.\u0010\u0010R\u001b\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bG\u0010\rR\u0019\u0010+\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010A\u001a\u0004\b+\u0010\u0010R\u0019\u00101\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010A\u001a\u0004\bH\u0010\u0010R\u0019\u00104\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010I\u001a\u0004\bJ\u0010 R\u0019\u0010)\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010K\u001a\u0004\bL\u0010\nR\u0019\u00103\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010M\u001a\u0004\bN\u0010\u001dR\u0019\u0010-\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010A\u001a\u0004\bO\u0010\u0010R\u0019\u0010/\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010A\u001a\u0004\bP\u0010\u0010R\u001b\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010Q\u001a\u0004\bR\u0010\u0007R\u0019\u0010,\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010A\u001a\u0004\b,\u0010\u0010R\u001f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010S\u001a\u0004\bT\u0010\u001aR\u001b\u00106\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010U\u001a\u0004\bV\u0010&¨\u0006Y"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Initialized;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "component2", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component4", "()Lcom/discord/api/channel/Channel;", "", "component5", "()Z", "component6", "component7", "component8", "component9", "component10", "component11", "", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "component12", "()Ljava/util/List;", "Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;", "component13", "()Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;", "Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "component14", "()Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "", "component15", "()I", "Lcom/discord/models/guild/UserGuildMember;", "component16", "()Lcom/discord/models/guild/UserGuildMember;", "guildScheduledEvent", "locationInfo", "guild", "channel", "isInGuild", "isRsvped", "canShare", "isConnected", "canStartEvent", "isDeveloperMode", "canConnect", "rsvpUsers", "section", "rsvpUsersFetchState", "segmentedControlIndex", "creator", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;ZZZZZZZLjava/util/List;Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;ILcom/discord/models/guild/UserGuildMember;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Initialized;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getSegmentedControlIndex", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "Lcom/discord/api/channel/Channel;", "getChannel", "getCanConnect", "Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "getRsvpUsersFetchState", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;", "getSection", "getCanShare", "getCanStartEvent", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "getLocationInfo", "Ljava/util/List;", "getRsvpUsers", "Lcom/discord/models/guild/UserGuildMember;", "getCreator", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;ZZZZZZZLjava/util/List;Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;ILcom/discord/models/guild/UserGuildMember;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Initialized extends ViewState {
            private final boolean canConnect;
            private final boolean canShare;
            private final boolean canStartEvent;
            private final Channel channel;
            private final UserGuildMember creator;
            private final Guild guild;
            private final GuildScheduledEvent guildScheduledEvent;
            private final boolean isConnected;
            private final boolean isDeveloperMode;
            private final boolean isInGuild;
            private final boolean isRsvped;
            private final GuildScheduledEventLocationInfo locationInfo;
            private final List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers;
            private final GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState;
            private final GuildScheduledEventDetailsViewModel3 section;
            private final int segmentedControlIndex;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List<GuildScheduledEventRsvpUserListItem.RsvpUser> list, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i, UserGuildMember userGuildMember) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(list, "rsvpUsers");
                Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel3, "section");
                Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel2, "rsvpUsersFetchState");
                this.guildScheduledEvent = guildScheduledEvent;
                this.locationInfo = guildScheduledEventLocationInfo;
                this.guild = guild;
                this.channel = channel;
                this.isInGuild = z2;
                this.isRsvped = z3;
                this.canShare = z4;
                this.isConnected = z5;
                this.canStartEvent = z6;
                this.isDeveloperMode = z7;
                this.canConnect = z8;
                this.rsvpUsers = list;
                this.section = guildScheduledEventDetailsViewModel3;
                this.rsvpUsersFetchState = guildScheduledEventDetailsViewModel2;
                this.segmentedControlIndex = i;
                this.creator = userGuildMember;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List list, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i, UserGuildMember userGuildMember, int i2, Object obj) {
                return initialized.copy((i2 & 1) != 0 ? initialized.guildScheduledEvent : guildScheduledEvent, (i2 & 2) != 0 ? initialized.locationInfo : guildScheduledEventLocationInfo, (i2 & 4) != 0 ? initialized.guild : guild, (i2 & 8) != 0 ? initialized.channel : channel, (i2 & 16) != 0 ? initialized.isInGuild : z2, (i2 & 32) != 0 ? initialized.isRsvped : z3, (i2 & 64) != 0 ? initialized.canShare : z4, (i2 & 128) != 0 ? initialized.isConnected : z5, (i2 & 256) != 0 ? initialized.canStartEvent : z6, (i2 & 512) != 0 ? initialized.isDeveloperMode : z7, (i2 & 1024) != 0 ? initialized.canConnect : z8, (i2 & 2048) != 0 ? initialized.rsvpUsers : list, (i2 & 4096) != 0 ? initialized.section : guildScheduledEventDetailsViewModel3, (i2 & 8192) != 0 ? initialized.rsvpUsersFetchState : guildScheduledEventDetailsViewModel2, (i2 & 16384) != 0 ? initialized.segmentedControlIndex : i, (i2 & 32768) != 0 ? initialized.creator : userGuildMember);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getIsDeveloperMode() {
                return this.isDeveloperMode;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getCanConnect() {
                return this.canConnect;
            }

            public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> component12() {
                return this.rsvpUsers;
            }

            /* renamed from: component13, reason: from getter */
            public final GuildScheduledEventDetailsViewModel3 getSection() {
                return this.section;
            }

            /* renamed from: component14, reason: from getter */
            public final GuildScheduledEventDetailsViewModel2 getRsvpUsersFetchState() {
                return this.rsvpUsersFetchState;
            }

            /* renamed from: component15, reason: from getter */
            public final int getSegmentedControlIndex() {
                return this.segmentedControlIndex;
            }

            /* renamed from: component16, reason: from getter */
            public final UserGuildMember getCreator() {
                return this.creator;
            }

            /* renamed from: component2, reason: from getter */
            public final GuildScheduledEventLocationInfo getLocationInfo() {
                return this.locationInfo;
            }

            /* renamed from: component3, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component4, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsInGuild() {
                return this.isInGuild;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsRsvped() {
                return this.isRsvped;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getCanShare() {
                return this.canShare;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsConnected() {
                return this.isConnected;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getCanStartEvent() {
                return this.canStartEvent;
            }

            public final Initialized copy(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo locationInfo, Guild guild, Channel channel, boolean isInGuild, boolean isRsvped, boolean canShare, boolean isConnected, boolean canStartEvent, boolean isDeveloperMode, boolean canConnect, List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers, GuildScheduledEventDetailsViewModel3 section, GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState, int segmentedControlIndex, UserGuildMember creator) {
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(rsvpUsers, "rsvpUsers");
                Intrinsics3.checkNotNullParameter(section, "section");
                Intrinsics3.checkNotNullParameter(rsvpUsersFetchState, "rsvpUsersFetchState");
                return new Initialized(guildScheduledEvent, locationInfo, guild, channel, isInGuild, isRsvped, canShare, isConnected, canStartEvent, isDeveloperMode, canConnect, rsvpUsers, section, rsvpUsersFetchState, segmentedControlIndex, creator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return Intrinsics3.areEqual(this.guildScheduledEvent, initialized.guildScheduledEvent) && Intrinsics3.areEqual(this.locationInfo, initialized.locationInfo) && Intrinsics3.areEqual(this.guild, initialized.guild) && Intrinsics3.areEqual(this.channel, initialized.channel) && this.isInGuild == initialized.isInGuild && this.isRsvped == initialized.isRsvped && this.canShare == initialized.canShare && this.isConnected == initialized.isConnected && this.canStartEvent == initialized.canStartEvent && this.isDeveloperMode == initialized.isDeveloperMode && this.canConnect == initialized.canConnect && Intrinsics3.areEqual(this.rsvpUsers, initialized.rsvpUsers) && Intrinsics3.areEqual(this.section, initialized.section) && Intrinsics3.areEqual(this.rsvpUsersFetchState, initialized.rsvpUsersFetchState) && this.segmentedControlIndex == initialized.segmentedControlIndex && Intrinsics3.areEqual(this.creator, initialized.creator);
            }

            public final boolean getCanConnect() {
                return this.canConnect;
            }

            public final boolean getCanShare() {
                return this.canShare;
            }

            public final boolean getCanStartEvent() {
                return this.canStartEvent;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final UserGuildMember getCreator() {
                return this.creator;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            public final GuildScheduledEventLocationInfo getLocationInfo() {
                return this.locationInfo;
            }

            public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> getRsvpUsers() {
                return this.rsvpUsers;
            }

            public final GuildScheduledEventDetailsViewModel2 getRsvpUsersFetchState() {
                return this.rsvpUsersFetchState;
            }

            public final GuildScheduledEventDetailsViewModel3 getSection() {
                return this.section;
            }

            public final int getSegmentedControlIndex() {
                return this.segmentedControlIndex;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
                int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
                GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
                int iHashCode2 = (iHashCode + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
                Channel channel = this.channel;
                int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z2 = this.isInGuild;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode4 + i) * 31;
                boolean z3 = this.isRsvped;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.canShare;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isConnected;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                boolean z6 = this.canStartEvent;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (i8 + i9) * 31;
                boolean z7 = this.isDeveloperMode;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (i10 + i11) * 31;
                boolean z8 = this.canConnect;
                int i13 = (i12 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
                List<GuildScheduledEventRsvpUserListItem.RsvpUser> list = this.rsvpUsers;
                int iHashCode5 = (i13 + (list != null ? list.hashCode() : 0)) * 31;
                GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = this.section;
                int iHashCode6 = (iHashCode5 + (guildScheduledEventDetailsViewModel3 != null ? guildScheduledEventDetailsViewModel3.hashCode() : 0)) * 31;
                GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2 = this.rsvpUsersFetchState;
                int iHashCode7 = (((iHashCode6 + (guildScheduledEventDetailsViewModel2 != null ? guildScheduledEventDetailsViewModel2.hashCode() : 0)) * 31) + this.segmentedControlIndex) * 31;
                UserGuildMember userGuildMember = this.creator;
                return iHashCode7 + (userGuildMember != null ? userGuildMember.hashCode() : 0);
            }

            public final boolean isConnected() {
                return this.isConnected;
            }

            public final boolean isDeveloperMode() {
                return this.isDeveloperMode;
            }

            public final boolean isInGuild() {
                return this.isInGuild;
            }

            public final boolean isRsvped() {
                return this.isRsvped;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Initialized(guildScheduledEvent=");
                sbU.append(this.guildScheduledEvent);
                sbU.append(", locationInfo=");
                sbU.append(this.locationInfo);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", isInGuild=");
                sbU.append(this.isInGuild);
                sbU.append(", isRsvped=");
                sbU.append(this.isRsvped);
                sbU.append(", canShare=");
                sbU.append(this.canShare);
                sbU.append(", isConnected=");
                sbU.append(this.isConnected);
                sbU.append(", canStartEvent=");
                sbU.append(this.canStartEvent);
                sbU.append(", isDeveloperMode=");
                sbU.append(this.isDeveloperMode);
                sbU.append(", canConnect=");
                sbU.append(this.canConnect);
                sbU.append(", rsvpUsers=");
                sbU.append(this.rsvpUsers);
                sbU.append(", section=");
                sbU.append(this.section);
                sbU.append(", rsvpUsersFetchState=");
                sbU.append(this.rsvpUsersFetchState);
                sbU.append(", segmentedControlIndex=");
                sbU.append(this.segmentedControlIndex);
                sbU.append(", creator=");
                sbU.append(this.creator);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildScheduledEventDetailsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildScheduledEventDetailsViewModel(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable observable, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i2 & 2) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreGuildScheduledEvents guildScheduledEvents = (i2 & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreGuilds guilds = (i2 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i2 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i2 & 32) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i2 & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUserSettings userSettings = (i2 & 128) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i2 & 256) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreDirectories directories = (i2 & 512) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        this(widgetGuildScheduledEventDetailsBottomSheet2, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories, (i2 & 1024) != 0 ? Companion.access$observeStores(INSTANCE, widgetGuildScheduledEventDetailsBottomSheet2, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories) : observable, (i2 & 2048) != 0 ? GuildScheduledEventDetailsViewModel3.EVENT_INFO : guildScheduledEventDetailsViewModel3, (i2 & 4096) != 0 ? GuildScheduledEventDetailsViewModel2.LOADING : guildScheduledEventDetailsViewModel2, (i2 & 8192) != 0 ? 0 : i);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, StoreState storeState) {
        guildScheduledEventDetailsViewModel.handleStoreState(storeState);
    }

    private final GuildScheduledEventDetailsViewModel2 getRsvpUsersFetchState(StoreState storeState) {
        return (storeState.isRsvpUsersFetching() && storeState.getRsvpUsers().isEmpty()) ? GuildScheduledEventDetailsViewModel2.LOADING : storeState.isRsvpUsersError() ? GuildScheduledEventDetailsViewModel2.ERROR : storeState.getRsvpUsers().isEmpty() ? GuildScheduledEventDetailsViewModel2.EMPTY : GuildScheduledEventDetailsViewModel2.SUCCESS;
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState initialized;
        boolean z2;
        if (storeState.getGuildScheduledEvent() == null || storeState.getGuild() == null) {
            initialized = ViewState.Invalid.INSTANCE;
        } else {
            if (getViewState() == null) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUserCounts(storeState.getGuild().getId());
            }
            GuildScheduledEventLocationInfo guildScheduledEventLocationInfoBuildLocationInfo = (this.args.getSource() == WidgetGuildScheduledEventDetailsBottomSheet3.Guild || storeState.getGuildScheduledEvent().getEntityType() == GuildScheduledEventEntityType.EXTERNAL || storeState.isInGuild()) ? GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(storeState.getGuildScheduledEvent(), storeState.getChannel()) : null;
            this.rsvpUsersFetchState = getRsvpUsersFetchState(storeState);
            GuildScheduledEvent guildScheduledEvent = storeState.getGuildScheduledEvent();
            Guild guild = storeState.getGuild();
            Channel channel = storeState.getChannel();
            boolean zIsInGuild = storeState.isInGuild();
            boolean zIsRsvped = storeState.isRsvped();
            Long channelId = storeState.getGuildScheduledEvent().getChannelId();
            boolean z3 = false;
            if (channelId != null) {
                long jLongValue = channelId.longValue();
                Long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
                if (selectedVoiceChannelId != null && jLongValue == selectedVoiceChannelId.longValue()) {
                    z3 = true;
                }
                z2 = z3;
            } else {
                z2 = false;
            }
            initialized = new ViewState.Initialized(guildScheduledEvent, guildScheduledEventLocationInfoBuildLocationInfo, guild, channel, zIsInGuild, zIsRsvped, storeState.getCanShare(), z2, storeState.getCanStartEvent(), storeState.isDeveloperMode(), storeState.getCanConnect(), storeState.getRsvpUsers(), this.section, this.rsvpUsersFetchState, this.segmentControlIndex, storeState.getCreator());
        }
        updateViewState(initialized);
    }

    public final void endEventClicked(Context context, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.endEvent(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId()), false, 1, null), GuildScheduledEventDetailsViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDetailsViewModel4(this, context, onSuccess), 60, (Object) null);
        }
    }

    public final void onDeleteButtonClicked(Context context, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildScheduledEvent(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId()), false, 1, null), GuildScheduledEventDetailsViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventDetailsViewModel5(this, context, onSuccess), 60, (Object) null);
        }
    }

    public final void onGuildNameClicked() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            StoreStream.INSTANCE.getGuildSelected().set(initialized.getGuild().getId());
        }
    }

    public final void onRsvpButtonClicked() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            this.guildScheduledEventsStore.toggleMeRsvpForEvent(initialized.getGuildScheduledEvent());
        }
    }

    public final void onShareButtonClicked(WeakReference<Fragment> weakFragment) {
        Intrinsics3.checkNotNullParameter(weakFragment, "weakFragment");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            Long channelId = initialized.getGuildScheduledEvent().getChannelId();
            long guildId = initialized.getGuildScheduledEvent().getGuildId();
            long id2 = initialized.getGuildScheduledEvent().getId();
            GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
            boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(companion, channelId, guildId, null, null, null, null, 60, null);
            Fragment fragment = weakFragment.get();
            if (fragment != null) {
                Intrinsics3.checkNotNullExpressionValue(fragment, "weakFragment.get() ?: return");
                companion.launchInvite(zCanShareEvent$default, fragment, guildId, initialized.getChannel(), id2);
            }
        }
    }

    public final void setSegmentedControlIndex(int index) {
        if (this.segmentControlIndex == index) {
            return;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            this.segmentControlIndex = index;
            GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = index == 0 ? GuildScheduledEventDetailsViewModel3.EVENT_INFO : GuildScheduledEventDetailsViewModel3.RSVP_LIST;
            this.section = guildScheduledEventDetailsViewModel3;
            if (guildScheduledEventDetailsViewModel3 == GuildScheduledEventDetailsViewModel3.RSVP_LIST) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUsers(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId());
                if (initialized.getRsvpUsers().isEmpty()) {
                    this.rsvpUsersFetchState = GuildScheduledEventDetailsViewModel2.LOADING;
                }
            }
            updateViewState(ViewState.Initialized.copy$default(initialized, null, null, null, null, false, false, false, false, false, false, false, null, this.section, this.rsvpUsersFetchState, this.segmentControlIndex, null, 36863, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable<StoreState> observable, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(widgetGuildScheduledEventDetailsBottomSheet2, "args");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel3, "section");
        Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel2, "rsvpUsersFetchState");
        this.args = widgetGuildScheduledEventDetailsBottomSheet2;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.userStore = storeUser;
        this.section = guildScheduledEventDetailsViewModel3;
        this.rsvpUsersFetchState = guildScheduledEventDetailsViewModel2;
        this.segmentControlIndex = i;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildScheduledEventDetailsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
