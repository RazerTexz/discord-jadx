package com.discord.widgets.emoji;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaFavorites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: EmojiSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003567Bo\u0012\u0006\u0010/\u001a\u00020.\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u000301¢\u0006\u0004\b3\u00104J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00068"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;)V", "standardPopoutAnalytics", "customPopoutAnalytics", "handleStoreStateUnicode", "handleStoreStateCustom", "", "favorite", "setFavorite", "(Z)V", "Lcom/discord/models/guild/Guild;", "guild", "Landroidx/fragment/app/Fragment;", "fragment", "joinGuild", "(Lcom/discord/models/guild/Guild;Landroidx/fragment/app/Fragment;)V", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lcom/discord/stores/StoreEmoji;", "Lcom/discord/stores/StoreEmojiCustom;", "storeEmojiCustom", "Lcom/discord/stores/StoreEmojiCustom;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreMediaFavorites;", "storeMediaFavorites", "Lcom/discord/stores/StoreMediaFavorites;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreEmoji;Lcom/discord/stores/StoreEmojiCustom;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreMediaFavorites;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EmojiNode.EmojiIdAndType emojiIdAndType;
    private final RestAPI restAPI;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreEmojiCustom storeEmojiCustom;
    private final StoreGuilds storeGuilds;
    private final StoreMediaFavorites storeMediaFavorites;
    private final StoreUser storeUsers;

    /* compiled from: EmojiSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$1, reason: invalid class name */
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
            EmojiSheetViewModel emojiSheetViewModel = EmojiSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "it");
            EmojiSheetViewModel.access$handleStoreState(emojiSheetViewModel, storeState);
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JM\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion;", "", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreEmojiCustom;", "storeEmojiCustom", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreMediaFavorites;", "storeMediaFavorites", "Lrx/Observable;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreEmojiCustom;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreMediaFavorites;)Lrx/Observable;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "getGuildForCustomEmoji", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreEmojiCustom;)Lrx/Observable;", "<init>", "()V", "CustomEmojGuildInfo", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: EmojiSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "", "", "isPublic", "()Z", "isUserInGuild", "<init>", "()V", "Known", "Unknown", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Unknown;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static abstract class CustomEmojGuildInfo {

            /* compiled from: EmojiSheetViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()Z", "component3", "", "component4", "()Ljava/lang/Integer;", "guild", "isPublic", "isUserInGuild", "approximateOnline", "copy", "(Lcom/discord/models/guild/Guild;ZZLjava/lang/Integer;)Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Integer;", "getApproximateOnline", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;ZZLjava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class Known extends CustomEmojGuildInfo {
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

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isPublic, reason: from getter */
                public boolean getIsPublic() {
                    return this.isPublic;
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
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

            /* compiled from: EmojiSheetViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Unknown;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "", "isPublic", "Z", "()Z", "isUserInGuild", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Unknown extends CustomEmojGuildInfo {
                public static final Unknown INSTANCE = new Unknown();
                private static final boolean isPublic = false;
                private static final boolean isUserInGuild = false;

                private Unknown() {
                    super(null);
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isPublic */
                public boolean getIsPublic() {
                    return isPublic;
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isUserInGuild */
                public boolean getIsUserInGuild() {
                    return isUserInGuild;
                }
            }

            private CustomEmojGuildInfo() {
            }

            /* renamed from: isPublic */
            public abstract boolean getIsPublic();

            /* renamed from: isUserInGuild */
            public abstract boolean getIsUserInGuild();

            public /* synthetic */ CustomEmojGuildInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, StoreUser storeUser, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
            return companion.observeStoreState(restAPI, emojiIdAndType, storeUser, storeGuilds, storeEmojiCustom, storeChannelsSelected, storeMediaFavorites);
        }

        private final Observable<CustomEmojGuildInfo> getGuildForCustomEmoji(RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
            if (!(emojiIdAndType instanceof EmojiNode.EmojiIdAndType.Custom)) {
                emojiIdAndType = null;
            }
            EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emojiIdAndType;
            if (custom != null) {
                Observable<CustomEmojGuildInfo> observableA = Observable.D(new EmojiSheetViewModel2(storeEmojiCustom, custom, storeGuilds)).A(new EmojiSheetViewModel3(restAPI, custom));
                Intrinsics3.checkNotNullExpressionValue(observableA, "Observable.fromCallable …      }\n        }\n      }");
                return observableA;
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            return scalarSynchronousObservable;
        }

        private final Observable<StoreState> observeStoreState(RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, StoreUser storeUsers, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
            Observable<StoreState> observableG = Observable.g(getGuildForCustomEmoji(restAPI, emojiIdAndType, storeGuilds, storeEmojiCustom), StoreUser.observeMe$default(storeUsers, false, 1, null), storeGuilds.observeGuilds(), storeChannelsSelected.observeSelectedChannel(), storeMediaFavorites.observeFavorites(StoreMediaFavorites.Favorite.INSTANCE.getEmojiTypes()), new EmojiSheetViewModel4(emojiIdAndType));
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…es,\n          )\n        }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ`\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\b2\u0012\b\u0002\u0010\u0018\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\nR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010\u0012R#\u0010\u0018\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u000fR\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b0\u0010\u000f¨\u00063"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "component1", "()Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "component2", "()Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "", "component3", "()Z", "", "", "Lcom/discord/primitives/GuildId;", "component4", "()Ljava/util/Set;", "Lcom/discord/api/channel/Channel;", "component5", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "component6", "customEmojiGuildInfo", "emoji", "meUserIsPremium", "joinedGuildIds", "currentChannel", "favorites", "copy", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;ZLjava/util/Set;Lcom/discord/api/channel/Channel;Ljava/util/Set;)Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "getCustomEmojiGuildInfo", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "getEmoji", "Z", "getMeUserIsPremium", "Lcom/discord/api/channel/Channel;", "getCurrentChannel", "Ljava/util/Set;", "getJoinedGuildIds", "getFavorites", "<init>", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;ZLjava/util/Set;Lcom/discord/api/channel/Channel;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel currentChannel;
        private final Companion.CustomEmojGuildInfo customEmojiGuildInfo;
        private final EmojiNode.EmojiIdAndType emoji;
        private final Set<StoreMediaFavorites.Favorite> favorites;
        private final Set<Long> joinedGuildIds;
        private final boolean meUserIsPremium;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Companion.CustomEmojGuildInfo customEmojGuildInfo, EmojiNode.EmojiIdAndType emojiIdAndType, boolean z2, Set<Long> set, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set2) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emoji");
            Intrinsics3.checkNotNullParameter(set, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(set2, "favorites");
            this.customEmojiGuildInfo = customEmojGuildInfo;
            this.emoji = emojiIdAndType;
            this.meUserIsPremium = z2;
            this.joinedGuildIds = set;
            this.currentChannel = channel;
            this.favorites = set2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Companion.CustomEmojGuildInfo customEmojGuildInfo, EmojiNode.EmojiIdAndType emojiIdAndType, boolean z2, Set set, Channel channel, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                customEmojGuildInfo = storeState.customEmojiGuildInfo;
            }
            if ((i & 2) != 0) {
                emojiIdAndType = storeState.emoji;
            }
            EmojiNode.EmojiIdAndType emojiIdAndType2 = emojiIdAndType;
            if ((i & 4) != 0) {
                z2 = storeState.meUserIsPremium;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                set = storeState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 16) != 0) {
                channel = storeState.currentChannel;
            }
            Channel channel2 = channel;
            if ((i & 32) != 0) {
                set2 = storeState.favorites;
            }
            return storeState.copy(customEmojGuildInfo, emojiIdAndType2, z3, set3, channel2, set2);
        }

        /* renamed from: component1, reason: from getter */
        public final Companion.CustomEmojGuildInfo getCustomEmojiGuildInfo() {
            return this.customEmojiGuildInfo;
        }

        /* renamed from: component2, reason: from getter */
        public final EmojiNode.EmojiIdAndType getEmoji() {
            return this.emoji;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getMeUserIsPremium() {
            return this.meUserIsPremium;
        }

        public final Set<Long> component4() {
            return this.joinedGuildIds;
        }

        /* renamed from: component5, reason: from getter */
        public final Channel getCurrentChannel() {
            return this.currentChannel;
        }

        public final Set<StoreMediaFavorites.Favorite> component6() {
            return this.favorites;
        }

        public final StoreState copy(Companion.CustomEmojGuildInfo customEmojiGuildInfo, EmojiNode.EmojiIdAndType emoji, boolean meUserIsPremium, Set<Long> joinedGuildIds, Channel currentChannel, Set<? extends StoreMediaFavorites.Favorite> favorites) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            Intrinsics3.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(favorites, "favorites");
            return new StoreState(customEmojiGuildInfo, emoji, meUserIsPremium, joinedGuildIds, currentChannel, favorites);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.customEmojiGuildInfo, storeState.customEmojiGuildInfo) && Intrinsics3.areEqual(this.emoji, storeState.emoji) && this.meUserIsPremium == storeState.meUserIsPremium && Intrinsics3.areEqual(this.joinedGuildIds, storeState.joinedGuildIds) && Intrinsics3.areEqual(this.currentChannel, storeState.currentChannel) && Intrinsics3.areEqual(this.favorites, storeState.favorites);
        }

        public final Channel getCurrentChannel() {
            return this.currentChannel;
        }

        public final Companion.CustomEmojGuildInfo getCustomEmojiGuildInfo() {
            return this.customEmojiGuildInfo;
        }

        public final EmojiNode.EmojiIdAndType getEmoji() {
            return this.emoji;
        }

        public final Set<StoreMediaFavorites.Favorite> getFavorites() {
            return this.favorites;
        }

        public final Set<Long> getJoinedGuildIds() {
            return this.joinedGuildIds;
        }

        public final boolean getMeUserIsPremium() {
            return this.meUserIsPremium;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Companion.CustomEmojGuildInfo customEmojGuildInfo = this.customEmojiGuildInfo;
            int iHashCode = (customEmojGuildInfo != null ? customEmojGuildInfo.hashCode() : 0) * 31;
            EmojiNode.EmojiIdAndType emojiIdAndType = this.emoji;
            int iHashCode2 = (iHashCode + (emojiIdAndType != null ? emojiIdAndType.hashCode() : 0)) * 31;
            boolean z2 = this.meUserIsPremium;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode3 = (i2 + (set != null ? set.hashCode() : 0)) * 31;
            Channel channel = this.currentChannel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            Set<StoreMediaFavorites.Favorite> set2 = this.favorites;
            return iHashCode4 + (set2 != null ? set2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(customEmojiGuildInfo=");
            sbU.append(this.customEmojiGuildInfo);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", meUserIsPremium=");
            sbU.append(this.meUserIsPremium);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", currentChannel=");
            sbU.append(this.currentChannel);
            sbU.append(", favorites=");
            return outline.N(sbU, this.favorites, ")");
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "", "<init>", "()V", "Dismiss", "EmojiCustom", "EmojiUnicode", "Invalid", "Loading", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$Dismiss;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiCustom;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiUnicode;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: EmojiSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$Dismiss;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends ViewState {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJL\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b\u0010\u0010\nR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b\u0011\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiCustom;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "component1", "()Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "component2", "()Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "", "component3", "()Z", "component4", "component5", "component6", "emojiCustom", "emojiGuildInfo", "isUserPremium", "isCurrentGuild", "canFavorite", "isFavorite", "copy", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;ZZZZ)Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiCustom;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "getEmojiGuildInfo", "Z", "getCanFavorite", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "getEmojiCustom", "<init>", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;ZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EmojiCustom extends ViewState {
            private final boolean canFavorite;
            private final EmojiNode.EmojiIdAndType.Custom emojiCustom;
            private final Companion.CustomEmojGuildInfo emojiGuildInfo;
            private final boolean isCurrentGuild;
            private final boolean isFavorite;
            private final boolean isUserPremium;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiCustom(EmojiNode.EmojiIdAndType.Custom custom, Companion.CustomEmojGuildInfo customEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5) {
                super(null);
                Intrinsics3.checkNotNullParameter(custom, "emojiCustom");
                Intrinsics3.checkNotNullParameter(customEmojGuildInfo, "emojiGuildInfo");
                this.emojiCustom = custom;
                this.emojiGuildInfo = customEmojGuildInfo;
                this.isUserPremium = z2;
                this.isCurrentGuild = z3;
                this.canFavorite = z4;
                this.isFavorite = z5;
            }

            public static /* synthetic */ EmojiCustom copy$default(EmojiCustom emojiCustom, EmojiNode.EmojiIdAndType.Custom custom, Companion.CustomEmojGuildInfo customEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
                if ((i & 1) != 0) {
                    custom = emojiCustom.emojiCustom;
                }
                if ((i & 2) != 0) {
                    customEmojGuildInfo = emojiCustom.emojiGuildInfo;
                }
                Companion.CustomEmojGuildInfo customEmojGuildInfo2 = customEmojGuildInfo;
                if ((i & 4) != 0) {
                    z2 = emojiCustom.isUserPremium;
                }
                boolean z6 = z2;
                if ((i & 8) != 0) {
                    z3 = emojiCustom.isCurrentGuild;
                }
                boolean z7 = z3;
                if ((i & 16) != 0) {
                    z4 = emojiCustom.canFavorite;
                }
                boolean z8 = z4;
                if ((i & 32) != 0) {
                    z5 = emojiCustom.isFavorite;
                }
                return emojiCustom.copy(custom, customEmojGuildInfo2, z6, z7, z8, z5);
            }

            /* renamed from: component1, reason: from getter */
            public final EmojiNode.EmojiIdAndType.Custom getEmojiCustom() {
                return this.emojiCustom;
            }

            /* renamed from: component2, reason: from getter */
            public final Companion.CustomEmojGuildInfo getEmojiGuildInfo() {
                return this.emojiGuildInfo;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsCurrentGuild() {
                return this.isCurrentGuild;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsFavorite() {
                return this.isFavorite;
            }

            public final EmojiCustom copy(EmojiNode.EmojiIdAndType.Custom emojiCustom, Companion.CustomEmojGuildInfo emojiGuildInfo, boolean isUserPremium, boolean isCurrentGuild, boolean canFavorite, boolean isFavorite) {
                Intrinsics3.checkNotNullParameter(emojiCustom, "emojiCustom");
                Intrinsics3.checkNotNullParameter(emojiGuildInfo, "emojiGuildInfo");
                return new EmojiCustom(emojiCustom, emojiGuildInfo, isUserPremium, isCurrentGuild, canFavorite, isFavorite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiCustom)) {
                    return false;
                }
                EmojiCustom emojiCustom = (EmojiCustom) other;
                return Intrinsics3.areEqual(this.emojiCustom, emojiCustom.emojiCustom) && Intrinsics3.areEqual(this.emojiGuildInfo, emojiCustom.emojiGuildInfo) && this.isUserPremium == emojiCustom.isUserPremium && this.isCurrentGuild == emojiCustom.isCurrentGuild && this.canFavorite == emojiCustom.canFavorite && this.isFavorite == emojiCustom.isFavorite;
            }

            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            public final EmojiNode.EmojiIdAndType.Custom getEmojiCustom() {
                return this.emojiCustom;
            }

            public final Companion.CustomEmojGuildInfo getEmojiGuildInfo() {
                return this.emojiGuildInfo;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                EmojiNode.EmojiIdAndType.Custom custom = this.emojiCustom;
                int iHashCode = (custom != null ? custom.hashCode() : 0) * 31;
                Companion.CustomEmojGuildInfo customEmojGuildInfo = this.emojiGuildInfo;
                int iHashCode2 = (iHashCode + (customEmojGuildInfo != null ? customEmojGuildInfo.hashCode() : 0)) * 31;
                boolean z2 = this.isUserPremium;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.isCurrentGuild;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.canFavorite;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isFavorite;
                return i6 + (z5 ? 1 : z5 ? 1 : 0);
            }

            public final boolean isCurrentGuild() {
                return this.isCurrentGuild;
            }

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiCustom(emojiCustom=");
                sbU.append(this.emojiCustom);
                sbU.append(", emojiGuildInfo=");
                sbU.append(this.emojiGuildInfo);
                sbU.append(", isUserPremium=");
                sbU.append(this.isUserPremium);
                sbU.append(", isCurrentGuild=");
                sbU.append(this.isCurrentGuild);
                sbU.append(", canFavorite=");
                sbU.append(this.canFavorite);
                sbU.append(", isFavorite=");
                return outline.O(sbU, this.isFavorite, ")");
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiUnicode;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "component1", "()Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "", "component2", "()Z", "component3", "emojiUnicode", "canFavorite", "isFavorite", "copy", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;ZZ)Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiUnicode;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanFavorite", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "getEmojiUnicode", "<init>", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EmojiUnicode extends ViewState {
            private final boolean canFavorite;
            private final ModelEmojiUnicode emojiUnicode;
            private final boolean isFavorite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiUnicode(ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "emojiUnicode");
                this.emojiUnicode = modelEmojiUnicode;
                this.canFavorite = z2;
                this.isFavorite = z3;
            }

            public static /* synthetic */ EmojiUnicode copy$default(EmojiUnicode emojiUnicode, ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiUnicode = emojiUnicode.emojiUnicode;
                }
                if ((i & 2) != 0) {
                    z2 = emojiUnicode.canFavorite;
                }
                if ((i & 4) != 0) {
                    z3 = emojiUnicode.isFavorite;
                }
                return emojiUnicode.copy(modelEmojiUnicode, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelEmojiUnicode getEmojiUnicode() {
                return this.emojiUnicode;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsFavorite() {
                return this.isFavorite;
            }

            public final EmojiUnicode copy(ModelEmojiUnicode emojiUnicode, boolean canFavorite, boolean isFavorite) {
                Intrinsics3.checkNotNullParameter(emojiUnicode, "emojiUnicode");
                return new EmojiUnicode(emojiUnicode, canFavorite, isFavorite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiUnicode)) {
                    return false;
                }
                EmojiUnicode emojiUnicode = (EmojiUnicode) other;
                return Intrinsics3.areEqual(this.emojiUnicode, emojiUnicode.emojiUnicode) && this.canFavorite == emojiUnicode.canFavorite && this.isFavorite == emojiUnicode.isFavorite;
            }

            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            public final ModelEmojiUnicode getEmojiUnicode() {
                return this.emojiUnicode;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelEmojiUnicode modelEmojiUnicode = this.emojiUnicode;
                int iHashCode = (modelEmojiUnicode != null ? modelEmojiUnicode.hashCode() : 0) * 31;
                boolean z2 = this.canFavorite;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isFavorite;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiUnicode(emojiUnicode=");
                sbU.append(this.emojiUnicode);
                sbU.append(", canFavorite=");
                sbU.append(this.canFavorite);
                sbU.append(", isFavorite=");
                return outline.O(sbU, this.isFavorite, ")");
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: EmojiSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$joinGuild$1, reason: invalid class name */
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
            EmojiSheetViewModel.access$updateViewState(EmojiSheetViewModel.this, ViewState.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EmojiSheetViewModel(EmojiNode.EmojiIdAndType emojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreEmoji emojis = (i & 4) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreEmojiCustom customEmojis = (i & 8) != 0 ? StoreStream.INSTANCE.getCustomEmojis() : storeEmojiCustom;
        StoreAnalytics analytics = (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreChannelsSelected channelsSelected = (i & 128) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreMediaFavorites mediaFavorites = (i & 256) != 0 ? StoreStream.INSTANCE.getMediaFavorites() : storeMediaFavorites;
        this(emojiIdAndType, api, emojis, customEmojis, analytics, users, guilds, channelsSelected, mediaFavorites, (i & 512) != 0 ? Companion.access$observeStoreState(INSTANCE, api, emojiIdAndType, users, guilds, customEmojis, channelsSelected, mediaFavorites) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(EmojiSheetViewModel emojiSheetViewModel, StoreState storeState) {
        emojiSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(EmojiSheetViewModel emojiSheetViewModel, ViewState viewState) {
        emojiSheetViewModel.updateViewState(viewState);
    }

    private final void customPopoutAnalytics(StoreState storeState) {
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emoji;
        Companion.CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        Intrinsics3.checkNotNull(customEmojiGuildInfo);
        boolean z2 = !customEmojiGuildInfo.getIsPublic();
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        boolean meUserIsPremium = storeState.getMeUserIsPremium();
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openCustomEmojiPopout(currentChannel, custom.getId(), meUserIsPremium, isUserInGuild, z2);
        }
    }

    private final void handleStoreState(StoreState storeState) {
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        if (emoji instanceof EmojiNode.EmojiIdAndType.Unicode) {
            standardPopoutAnalytics(storeState);
            handleStoreStateUnicode(storeState);
        } else if (emoji instanceof EmojiNode.EmojiIdAndType.Custom) {
            customPopoutAnalytics(storeState);
            handleStoreStateCustom(storeState);
        }
    }

    private final void handleStoreStateCustom(StoreState storeState) {
        boolean z2;
        Guild guild;
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emoji;
        Companion.CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        Intrinsics3.checkNotNull(customEmojiGuildInfo);
        boolean zContains = storeState.getFavorites().contains(new StoreMediaFavorites.Favorite.FavCustomEmoji(custom));
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        Channel currentChannel = storeState.getCurrentChannel();
        boolean z3 = false;
        if (currentChannel != null) {
            long guildId = currentChannel.getGuildId();
            Companion.CustomEmojGuildInfo.Known known = (Companion.CustomEmojGuildInfo.Known) (!(customEmojiGuildInfo instanceof Companion.CustomEmojGuildInfo.Known) ? null : customEmojiGuildInfo);
            if (known != null && (guild = known.getGuild()) != null && guild.getId() == guildId) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        updateViewState(new ViewState.EmojiCustom(custom, customEmojiGuildInfo, storeState.getMeUserIsPremium(), z2, isUserInGuild, zContains));
    }

    private final void handleStoreStateUnicode(StoreState storeState) {
        ViewState emojiUnicode;
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Unicode");
        ModelEmojiUnicode modelEmojiUnicode = this.storeEmoji.getUnicodeEmojisNamesMap().get(((EmojiNode.EmojiIdAndType.Unicode) emoji).getName());
        if (modelEmojiUnicode != null) {
            emojiUnicode = new ViewState.EmojiUnicode(modelEmojiUnicode, true, storeState.getFavorites().contains(new StoreMediaFavorites.Favorite.FavUnicodeEmoji(modelEmojiUnicode)));
        } else {
            emojiUnicode = ViewState.Invalid.INSTANCE;
        }
        updateViewState(emojiUnicode);
    }

    private final void standardPopoutAnalytics(StoreState storeState) {
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openUnicodeEmojiPopout(currentChannel);
        }
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelper.joinGuild$default(contextRequireContext, guild.getId(), false, null, null, null, EmojiSheetViewModel.class, null, null, null, new AnonymousClass1(), 952, null);
    }

    public final void setFavorite(boolean favorite) {
        Object favUnicodeEmoji;
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState instanceof ViewState.EmojiCustom) {
                favUnicodeEmoji = new StoreMediaFavorites.Favorite.FavCustomEmoji(((ViewState.EmojiCustom) viewState).getEmojiCustom());
            } else if (!(viewState instanceof ViewState.EmojiUnicode)) {
                return;
            } else {
                favUnicodeEmoji = new StoreMediaFavorites.Favorite.FavUnicodeEmoji(((ViewState.EmojiUnicode) viewState).getEmojiUnicode());
            }
            Object exhaustive = KotlinExtensions.getExhaustive(favUnicodeEmoji);
            if (favorite) {
                this.storeMediaFavorites.addFavorite((StoreMediaFavorites.Favorite) exhaustive);
            } else {
                this.storeMediaFavorites.removeFavorite((StoreMediaFavorites.Favorite) exhaustive);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel(EmojiNode.EmojiIdAndType emojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeMediaFavorites, "storeMediaFavorites");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.emojiIdAndType = emojiIdAndType;
        this.restAPI = restAPI;
        this.storeEmoji = storeEmoji;
        this.storeEmojiCustom = storeEmojiCustom;
        this.storeAnalytics = storeAnalytics;
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeMediaFavorites = storeMediaFavorites;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, EmojiSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
