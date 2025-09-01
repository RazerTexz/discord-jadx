package com.discord.widgets.channels;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003)*+BK\u0012\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017\u0012\n\u0010 \u001a\u00060\u0016j\u0002`\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00060\u0016j\u0002`\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00060\u0016j\u0002`\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019¨\u0006,"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;)V", "generateViewState", "(Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;)Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "buildChannelItemList", "(Ljava/util/List;)Ljava/util/List;", "", "query", "updateSearchQuery", "(Ljava/lang/String;)V", "currentStoreState", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "", "hideAnnouncementChannels", "Z", "searchQuery", "Ljava/lang/String;", "Lcom/discord/primitives/ChannelId;", "selectedChannelId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lrx/Observable;", "storeStateObservable", "<init>", "(JJZLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StoreState currentStoreState;
    private final long guildId;
    private final boolean hideAnnouncementChannels;
    private String searchQuery;
    private final long selectedChannelId;

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel$1, reason: invalid class name */
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
            WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel = WidgetChannelPickerBottomSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetChannelPickerBottomSheetViewModel.access$handleStoreState(widgetChannelPickerBottomSheetViewModel, storeState);
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreChannels;", "storeChannels", "", "hideAnnouncementChannels", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;Z)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels, boolean z2) {
            return companion.observeStoreState(j, observationDeck, storeChannels, z2);
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreChannels storeChannels, boolean hideAnnouncementChannels) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeChannels}, false, null, null, new WidgetChannelPickerBottomSheetViewModel2(storeChannels, guildId, hideAnnouncementChannels), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Loaded", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Ljava/util/List;", "channels", "copy", "(Ljava/util/List;)Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getChannels", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends StoreState {
            private final List<Channel> channels;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Channel> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "channels");
                this.channels = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.channels;
                }
                return loaded.copy(list);
            }

            public final List<Channel> component1() {
                return this.channels;
            }

            public final Loaded copy(List<Channel> channels) {
                Intrinsics3.checkNotNullParameter(channels, "channels");
                return new Loaded(channels);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.channels, ((Loaded) other).channels);
                }
                return true;
            }

            public final List<Channel> getChannels() {
                return this.channels;
            }

            public int hashCode() {
                List<Channel> list = this.channels;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(channels="), this.channels, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Loading", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "component1", "()Ljava/util/List;", "adapterItems", "copy", "(Ljava/util/List;)Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAdapterItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<WidgetChannelPickerAdapter> adapterItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends WidgetChannelPickerAdapter> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                return loaded.copy(list);
            }

            public final List<WidgetChannelPickerAdapter> component1() {
                return this.adapterItems;
            }

            public final Loaded copy(List<? extends WidgetChannelPickerAdapter> adapterItems) {
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
                }
                return true;
            }

            public final List<WidgetChannelPickerAdapter> getAdapterItems() {
                return this.adapterItems;
            }

            public int hashCode() {
                List<WidgetChannelPickerAdapter> list = this.adapterItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
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
    public /* synthetic */ WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 8) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        this(j, j2, z2, observationDeck2, channels, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, j, observationDeck2, channels, z2) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel, StoreState storeState) {
        widgetChannelPickerBottomSheetViewModel.handleStoreState(storeState);
    }

    private final List<WidgetChannelPickerAdapter> buildChannelItemList(List<Channel> channels) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(WidgetChannelPickerAdapter.CreateChannelItem.INSTANCE);
        for (Channel channel : channels) {
            if (StringsJVM.isBlank(this.searchQuery) || Strings4.contains$default((CharSequence) ChannelUtils.c(channel), (CharSequence) this.searchQuery, false, 2, (Object) null)) {
                arrayList.add(new WidgetChannelPickerAdapter.ChannelItem(channel, channel.getId() == this.selectedChannelId));
            }
        }
        return arrayList;
    }

    private final ViewState generateViewState(StoreState storeState) {
        if (storeState instanceof StoreState.Invalid) {
            return ViewState.Loading.INSTANCE;
        }
        if (storeState instanceof StoreState.Loaded) {
            return new ViewState.Loaded(buildChannelItemList(((StoreState.Loaded) storeState).getChannels()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
        updateViewState(generateViewState(storeState));
    }

    public final void updateSearchQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        if (Intrinsics3.areEqual(query, this.searchQuery)) {
            return;
        }
        this.searchQuery = query;
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.selectedChannelId = j2;
        this.hideAnnouncementChannels = z2;
        this.searchQuery = "";
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelPickerBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
