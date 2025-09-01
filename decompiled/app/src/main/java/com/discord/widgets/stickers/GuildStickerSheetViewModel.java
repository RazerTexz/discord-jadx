package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildStickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !BG\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;)V", "Lcom/discord/models/guild/Guild;", "guild", "Landroidx/fragment/app/Fragment;", "fragment", "joinGuild", "(Lcom/discord/models/guild/Guild;Landroidx/fragment/app/Fragment;)V", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/api/sticker/Sticker;", "sticker", "Lcom/discord/api/sticker/Sticker;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lcom/discord/api/sticker/Sticker;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreGuilds;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildStickerSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RestAPI restAPI;
    private final Sticker sticker;
    private final StoreUser storeUser;

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$1, reason: invalid class name */
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
            GuildStickerSheetViewModel.access$handleStoreState(GuildStickerSheetViewModel.this, storeState);
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion;", "", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/api/sticker/Sticker;", "sticker", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/api/sticker/Sticker;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "getGuildForGuildSticker", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/api/sticker/Sticker;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "GuildStickerGuildInfo", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: GuildStickerSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "", "", "isPublic", "()Z", "isUserInGuild", "<init>", "()V", "Known", "Unknown", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Unknown;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static abstract class GuildStickerGuildInfo {

            /* compiled from: GuildStickerSheetViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\r\u0010\u0007¨\u0006\""}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()Z", "component3", "", "component4", "()Ljava/lang/Integer;", "guild", "isPublic", "isUserInGuild", "approximateOnline", "copy", "(Lcom/discord/models/guild/Guild;ZZLjava/lang/Integer;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getApproximateOnline", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "<init>", "(Lcom/discord/models/guild/Guild;ZZLjava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class Known extends GuildStickerGuildInfo {
                private final Integer approximateOnline;
                private final Guild guild;
                private final boolean isPublic;
                private final boolean isUserInGuild;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Known(Guild guild, boolean z2, boolean z3, Integer num) {
                    super(null);
                    Intrinsics3.checkNotNullParameter(guild, "guild");
                    this.guild = guild;
                    this.isPublic = z2;
                    this.isUserInGuild = z3;
                    this.approximateOnline = num;
                }

                public static /* synthetic */ Known copy$default(Known known, Guild guild, boolean z2, boolean z3, Integer num, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guild = known.guild;
                    }
                    if ((i & 2) != 0) {
                        z2 = known.getIsPublic();
                    }
                    if ((i & 4) != 0) {
                        z3 = known.getIsUserInGuild();
                    }
                    if ((i & 8) != 0) {
                        num = known.approximateOnline;
                    }
                    return known.copy(guild, z2, z3, num);
                }

                /* renamed from: component1, reason: from getter */
                public final Guild getGuild() {
                    return this.guild;
                }

                public final boolean component2() {
                    return getIsPublic();
                }

                public final boolean component3() {
                    return getIsUserInGuild();
                }

                /* renamed from: component4, reason: from getter */
                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Known copy(Guild guild, boolean isPublic, boolean isUserInGuild, Integer approximateOnline) {
                    Intrinsics3.checkNotNullParameter(guild, "guild");
                    return new Known(guild, isPublic, isUserInGuild, approximateOnline);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Known)) {
                        return false;
                    }
                    Known known = (Known) other;
                    return Intrinsics3.areEqual(this.guild, known.guild) && getIsPublic() == known.getIsPublic() && getIsUserInGuild() == known.getIsUserInGuild() && Intrinsics3.areEqual(this.approximateOnline, known.approximateOnline);
                }

                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Guild getGuild() {
                    return this.guild;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                /* JADX WARN: Type inference failed for: r2v4 */
                /* JADX WARN: Type inference failed for: r2v5 */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v1, types: [int] */
                /* JADX WARN: Type inference failed for: r3v2 */
                public int hashCode() {
                    Guild guild = this.guild;
                    int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                    boolean isPublic = getIsPublic();
                    ?? r2 = isPublic;
                    if (isPublic) {
                        r2 = 1;
                    }
                    int i = (iHashCode + r2) * 31;
                    boolean isUserInGuild = getIsUserInGuild();
                    int i2 = (i + (isUserInGuild ? 1 : isUserInGuild)) * 31;
                    Integer num = this.approximateOnline;
                    return i2 + (num != null ? num.hashCode() : 0);
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* renamed from: isPublic, reason: from getter */
                public boolean getIsPublic() {
                    return this.isPublic;
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* renamed from: isUserInGuild, reason: from getter */
                public boolean getIsUserInGuild() {
                    return this.isUserInGuild;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Known(guild=");
                    sbU.append(this.guild);
                    sbU.append(", isPublic=");
                    sbU.append(getIsPublic());
                    sbU.append(", isUserInGuild=");
                    sbU.append(getIsUserInGuild());
                    sbU.append(", approximateOnline=");
                    return outline.F(sbU, this.approximateOnline, ")");
                }
            }

            /* compiled from: GuildStickerSheetViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Unknown;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "", "isUserInGuild", "Z", "()Z", "isPublic", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Unknown extends GuildStickerGuildInfo {
                public static final Unknown INSTANCE = new Unknown();
                private static final boolean isPublic = false;
                private static final boolean isUserInGuild = false;

                private Unknown() {
                    super(null);
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* renamed from: isPublic */
                public boolean getIsPublic() {
                    return isPublic;
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* renamed from: isUserInGuild */
                public boolean getIsUserInGuild() {
                    return isUserInGuild;
                }
            }

            private GuildStickerGuildInfo() {
            }

            /* renamed from: isPublic */
            public abstract boolean getIsPublic();

            /* renamed from: isUserInGuild */
            public abstract boolean getIsUserInGuild();

            public /* synthetic */ GuildStickerGuildInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
            return companion.observeStoreState(restAPI, sticker, storeUser, storeChannelsSelected, storeGuilds);
        }

        private final Observable<GuildStickerGuildInfo> getGuildForGuildSticker(RestAPI restAPI, Sticker sticker, StoreGuilds storeGuilds) {
            Observable<GuildStickerGuildInfo> observableA = Observable.D(new GuildStickerSheetViewModel2(storeGuilds, sticker)).A(new GuildStickerSheetViewModel3(restAPI, sticker));
            Intrinsics3.checkNotNullExpressionValue(observableA, "Observable.fromCallable …      }\n        }\n      }");
            return observableA;
        }

        private final Observable<StoreState> observeStoreState(RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
            Observable<StoreState> observableH = Observable.h(getGuildForGuildSticker(restAPI, sticker, storeGuilds), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeSelectedChannel(), storeGuilds.observeGuilds(), GuildStickerSheetViewModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…erGuildInfo\n      )\n    }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJP\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0013\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0004R!\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\bR\u0019\u0010\u0013\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u000fR)\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\f¨\u0006*"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "", "Lcom/discord/models/guild/Guild;", "component3", "()Ljava/util/Map;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "component4", "()Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "meUser", "currentGuildId", "userGuilds", "guildStickerGuildInfo", "copy", "(Lcom/discord/models/user/MeUser;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getMeUser", "Ljava/lang/Long;", "getCurrentGuildId", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "getGuildStickerGuildInfo", "Ljava/util/Map;", "getUserGuilds", "<init>", "(Lcom/discord/models/user/MeUser;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Long currentGuildId;
        private final Companion.GuildStickerGuildInfo guildStickerGuildInfo;
        private final MeUser meUser;
        private final Map<Long, Guild> userGuilds;

        public StoreState(MeUser meUser, Long l, Map<Long, Guild> map, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(map, "userGuilds");
            Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
            this.meUser = meUser;
            this.currentGuildId = l;
            this.userGuilds = map;
            this.guildStickerGuildInfo = guildStickerGuildInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Long l, Map map, Companion.GuildStickerGuildInfo guildStickerGuildInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.meUser;
            }
            if ((i & 2) != 0) {
                l = storeState.currentGuildId;
            }
            if ((i & 4) != 0) {
                map = storeState.userGuilds;
            }
            if ((i & 8) != 0) {
                guildStickerGuildInfo = storeState.guildStickerGuildInfo;
            }
            return storeState.copy(meUser, l, map, guildStickerGuildInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getCurrentGuildId() {
            return this.currentGuildId;
        }

        public final Map<Long, Guild> component3() {
            return this.userGuilds;
        }

        /* renamed from: component4, reason: from getter */
        public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
            return this.guildStickerGuildInfo;
        }

        public final StoreState copy(MeUser meUser, Long currentGuildId, Map<Long, Guild> userGuilds, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(userGuilds, "userGuilds");
            Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
            return new StoreState(meUser, currentGuildId, userGuilds, guildStickerGuildInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.currentGuildId, storeState.currentGuildId) && Intrinsics3.areEqual(this.userGuilds, storeState.userGuilds) && Intrinsics3.areEqual(this.guildStickerGuildInfo, storeState.guildStickerGuildInfo);
        }

        public final Long getCurrentGuildId() {
            return this.currentGuildId;
        }

        public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
            return this.guildStickerGuildInfo;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Guild> getUserGuilds() {
            return this.userGuilds;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Long l = this.currentGuildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Guild> map = this.userGuilds;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Companion.GuildStickerGuildInfo guildStickerGuildInfo = this.guildStickerGuildInfo;
            return iHashCode3 + (guildStickerGuildInfo != null ? guildStickerGuildInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", currentGuildId=");
            sbU.append(this.currentGuildId);
            sbU.append(", userGuilds=");
            sbU.append(this.userGuilds);
            sbU.append(", guildStickerGuildInfo=");
            sbU.append(this.guildStickerGuildInfo);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState;", "", "<init>", "()V", "Dismiss", "Loaded", "Loading", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Dismiss;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildStickerSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Dismiss;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends ViewState {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: GuildStickerSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u000e\u0010\u0007¨\u0006#"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState;", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "", "component2", "()Z", "component3", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "component4", "()Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "sticker", "isUserPremium", "isCurrentGuild", "guildStickerGuildInfo", "copy", "(Lcom/discord/api/sticker/Sticker;ZZLcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "getGuildStickerGuildInfo", "Z", "Lcom/discord/api/sticker/Sticker;", "getSticker", "<init>", "(Lcom/discord/api/sticker/Sticker;ZZLcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Companion.GuildStickerGuildInfo guildStickerGuildInfo;
            private final boolean isCurrentGuild;
            private final boolean isUserPremium;
            private final Sticker sticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Sticker sticker, boolean z2, boolean z3, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
                super(null);
                Intrinsics3.checkNotNullParameter(sticker, "sticker");
                Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
                this.sticker = sticker;
                this.isUserPremium = z2;
                this.isCurrentGuild = z3;
                this.guildStickerGuildInfo = guildStickerGuildInfo;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Sticker sticker, boolean z2, boolean z3, Companion.GuildStickerGuildInfo guildStickerGuildInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = loaded.sticker;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isUserPremium;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.isCurrentGuild;
                }
                if ((i & 8) != 0) {
                    guildStickerGuildInfo = loaded.guildStickerGuildInfo;
                }
                return loaded.copy(sticker, z2, z3, guildStickerGuildInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final Sticker getSticker() {
                return this.sticker;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsCurrentGuild() {
                return this.isCurrentGuild;
            }

            /* renamed from: component4, reason: from getter */
            public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
                return this.guildStickerGuildInfo;
            }

            public final Loaded copy(Sticker sticker, boolean isUserPremium, boolean isCurrentGuild, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
                Intrinsics3.checkNotNullParameter(sticker, "sticker");
                Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
                return new Loaded(sticker, isUserPremium, isCurrentGuild, guildStickerGuildInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.sticker, loaded.sticker) && this.isUserPremium == loaded.isUserPremium && this.isCurrentGuild == loaded.isCurrentGuild && Intrinsics3.areEqual(this.guildStickerGuildInfo, loaded.guildStickerGuildInfo);
            }

            public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
                return this.guildStickerGuildInfo;
            }

            public final Sticker getSticker() {
                return this.sticker;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Sticker sticker = this.sticker;
                int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
                boolean z2 = this.isUserPremium;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isCurrentGuild;
                int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                Companion.GuildStickerGuildInfo guildStickerGuildInfo = this.guildStickerGuildInfo;
                return i3 + (guildStickerGuildInfo != null ? guildStickerGuildInfo.hashCode() : 0);
            }

            public final boolean isCurrentGuild() {
                return this.isCurrentGuild;
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(sticker=");
                sbU.append(this.sticker);
                sbU.append(", isUserPremium=");
                sbU.append(this.isUserPremium);
                sbU.append(", isCurrentGuild=");
                sbU.append(this.isCurrentGuild);
                sbU.append(", guildStickerGuildInfo=");
                sbU.append(this.guildStickerGuildInfo);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildStickerSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$joinGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            GuildStickerSheetViewModel.access$updateViewState(GuildStickerSheetViewModel.this, ViewState.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(sticker, api, users, channelsSelected, guilds, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, api, sticker, users, channelsSelected, guilds) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildStickerSheetViewModel guildStickerSheetViewModel, StoreState storeState) {
        guildStickerSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(GuildStickerSheetViewModel guildStickerSheetViewModel, ViewState viewState) {
        guildStickerSheetViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(this.sticker, UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()), Intrinsics3.areEqual(storeState.getCurrentGuildId(), this.sticker.getGuildId()), storeState.getGuildStickerGuildInfo()));
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelper.joinGuild$default(contextRequireContext, guild.getId(), false, null, null, null, GuildStickerSheetViewModel.class, null, null, null, new AnonymousClass1(), 952, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.restAPI = restAPI;
        this.storeUser = storeUser;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildStickerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
