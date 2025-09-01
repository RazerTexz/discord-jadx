package com.discord.widgets.guilds.join;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003 !\"B#\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ;\u0010\u0019\u001a\u00020\u00052\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\n\u0010\u0013\u001a\u00060\u000fj\u0002`\u00122\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001b¨\u0006#"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;)V", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "welcomeScreen", "handleLoadedGuild", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/guild/welcome/GuildWelcomeScreen;)V", "handleLoadedWelcomeScreen", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "index", "", "Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "welcomeChannels", "onClickChannel", "(JJILjava/util/List;)V", "J", "Lrx/Observable;", "storeObservable", "<init>", "(JLrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long guildId;

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$1, reason: invalid class name */
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
            WidgetGuildWelcomeSheetViewModel.access$handleStoreState(WidgetGuildWelcomeSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "observeStores", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getGuilds().observeGuild(guildId), companion.getGuildWelcomeScreens().observeGuildWelcomeScreen(guildId), WidgetGuildWelcomeSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n            .…          )\n            }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "component2", "()Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "guild", "guildWelcomeScreen", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildWelcomeScreens$State;)Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "getGuildWelcomeScreen", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildWelcomeScreens$State;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final StoreGuildWelcomeScreens.State guildWelcomeScreen;

        public StoreState(Guild guild, StoreGuildWelcomeScreens.State state) {
            this.guild = guild;
            this.guildWelcomeScreen = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, StoreGuildWelcomeScreens.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                state = storeState.guildWelcomeScreen;
            }
            return storeState.copy(guild, state);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreGuildWelcomeScreens.State getGuildWelcomeScreen() {
            return this.guildWelcomeScreen;
        }

        public final StoreState copy(Guild guild, StoreGuildWelcomeScreens.State guildWelcomeScreen) {
            return new StoreState(guild, guildWelcomeScreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.guildWelcomeScreen, storeState.guildWelcomeScreen);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildWelcomeScreens.State getGuildWelcomeScreen() {
            return this.guildWelcomeScreen;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildWelcomeScreens.State state = this.guildWelcomeScreen;
            return iHashCode + (state != null ? state.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", guildWelcomeScreen=");
            sbU.append(this.guildWelcomeScreen);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Loading", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\\\u0010\u0016\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\bR\u0019\u0010\u0012\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b%\u0010\bR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u0005R\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010\bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b)\u0010\b¨\u0006,"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "component6", "()Ljava/util/List;", "guildId", "guildName", "guildShortName", "guildIcon", "guildDescription", "welcomeChannelsData", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getWelcomeChannelsData", "Ljava/lang/String;", "getGuildIcon", "getGuildShortName", "J", "getGuildId", "getGuildName", "getGuildDescription", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final String guildDescription;
            private final String guildIcon;
            private final long guildId;
            private final String guildName;
            private final String guildShortName;
            private final List<GuildWelcomeChannel> welcomeChannelsData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, String str, String str2, String str3, String str4, List<GuildWelcomeChannel> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "guildName");
                Intrinsics3.checkNotNullParameter(str2, "guildShortName");
                this.guildId = j;
                this.guildName = str;
                this.guildShortName = str2;
                this.guildIcon = str3;
                this.guildDescription = str4;
                this.welcomeChannelsData = list;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, long j, String str, String str2, String str3, String str4, List list, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.guildId : j, (i & 2) != 0 ? loaded.guildName : str, (i & 4) != 0 ? loaded.guildShortName : str2, (i & 8) != 0 ? loaded.guildIcon : str3, (i & 16) != 0 ? loaded.guildDescription : str4, (i & 32) != 0 ? loaded.welcomeChannelsData : list);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getGuildShortName() {
                return this.guildShortName;
            }

            /* renamed from: component4, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* renamed from: component5, reason: from getter */
            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final List<GuildWelcomeChannel> component6() {
                return this.welcomeChannelsData;
            }

            public final Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, List<GuildWelcomeChannel> welcomeChannelsData) {
                Intrinsics3.checkNotNullParameter(guildName, "guildName");
                Intrinsics3.checkNotNullParameter(guildShortName, "guildShortName");
                return new Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, welcomeChannelsData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.guildId == loaded.guildId && Intrinsics3.areEqual(this.guildName, loaded.guildName) && Intrinsics3.areEqual(this.guildShortName, loaded.guildShortName) && Intrinsics3.areEqual(this.guildIcon, loaded.guildIcon) && Intrinsics3.areEqual(this.guildDescription, loaded.guildDescription) && Intrinsics3.areEqual(this.welcomeChannelsData, loaded.welcomeChannelsData);
            }

            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildShortName() {
                return this.guildShortName;
            }

            public final List<GuildWelcomeChannel> getWelcomeChannelsData() {
                return this.welcomeChannelsData;
            }

            public int hashCode() {
                int iA = b.a(this.guildId) * 31;
                String str = this.guildName;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildShortName;
                int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.guildDescription;
                int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                List<GuildWelcomeChannel> list = this.welcomeChannelsData;
                return iHashCode4 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildShortName=");
                sbU.append(this.guildShortName);
                sbU.append(", guildIcon=");
                sbU.append(this.guildIcon);
                sbU.append(", guildDescription=");
                sbU.append(this.guildDescription);
                sbU.append(", welcomeChannelsData=");
                return outline.L(sbU, this.welcomeChannelsData, ")");
            }
        }

        /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    public /* synthetic */ WidgetGuildWelcomeSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildWelcomeSheetViewModel widgetGuildWelcomeSheetViewModel, StoreState storeState) {
        widgetGuildWelcomeSheetViewModel.handleStoreState(storeState);
    }

    private final void handleLoadedGuild(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new ViewState.Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen != null ? welcomeScreen.getDescription() : null, welcomeScreen != null ? welcomeScreen.b() : null));
    }

    private final void handleLoadedWelcomeScreen(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new ViewState.Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen.getDescription(), welcomeScreen.b()));
    }

    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildWelcomeScreens.State guildWelcomeScreen = storeState.getGuildWelcomeScreen();
        StoreGuildWelcomeScreens.State.Loaded loaded = (StoreGuildWelcomeScreens.State.Loaded) (!(guildWelcomeScreen instanceof StoreGuildWelcomeScreens.State.Loaded) ? null : guildWelcomeScreen);
        if (guild != null && guildWelcomeScreen == StoreGuildWelcomeScreens.State.Failure.INSTANCE) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (guildWelcomeScreen == StoreGuildWelcomeScreens.State.Fetching.INSTANCE) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (guild != null) {
            if ((loaded != null ? loaded.getData() : null) != null) {
                handleLoadedWelcomeScreen(guild, loaded.getData());
                return;
            }
        }
        if (guild != null) {
            handleLoadedGuild(guild, loaded != null ? loaded.getData() : null);
            return;
        }
        if ((loaded != null ? loaded.getData() : null) == null) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else {
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    public final void onClickChannel(long guildId, long channelId, int index, List<GuildWelcomeChannel> welcomeChannels) {
        Intrinsics3.checkNotNullParameter(welcomeChannels, "welcomeChannels");
        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), guildId, channelId, null, null, 12, null);
        String description = welcomeChannels.get(index).getDescription();
        boolean z2 = welcomeChannels.get(index).getEmojiId() != null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (GuildWelcomeChannel guildWelcomeChannel : welcomeChannels) {
            arrayList2.add(Long.valueOf(guildWelcomeChannel.getChannelId()));
            arrayList.add(guildWelcomeChannel.getDescription());
        }
        AnalyticsTracker.welcomeScreenChannelSelected(index, guildId, arrayList, arrayList2, description, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheetViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetGuildWelcomeSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getGuildWelcomeScreens().fetchIfNonexisting(j);
        companion.getGuildWelcomeScreens().markWelcomeScreenShown(j);
        AnalyticsTracker.openModal("Guild Welcome Screen", "", Long.valueOf(j));
    }
}
