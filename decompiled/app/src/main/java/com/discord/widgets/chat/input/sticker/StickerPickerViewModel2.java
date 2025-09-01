package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import com.discord.widgets.chat.input.sticker.StickerPickerViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function11;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StickerPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "selectedChannel", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/sticker/StickerPickerViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerPickerViewModel2<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends StickerPickerViewModel.StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ BehaviorSubject $selectedPackIdSubject;
    public final /* synthetic */ StoreExpressionPickerNavigation $storeExpressionPickerNavigation;
    public final /* synthetic */ StoreGuildStickers $storeGuildStickers;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreSlowMode $storeSlowMode;
    public final /* synthetic */ StoreStickers $storeStickers;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    /* compiled from: StickerPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001aT\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0005**\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000j\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0000j\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003`\u00042X\u0010\u0006\u001aT\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0005**\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000j\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0000j\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "kotlin.jvm.PlatformType", "allGuilds", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedHashMap;)Ljava/util/LinkedHashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<LinkedHashMap<Long, Guild>, LinkedHashMap<Long, Guild>> {
        public final /* synthetic */ Guild $currentGuild;

        public AnonymousClass1(Guild guild) {
            this.$currentGuild = guild;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ LinkedHashMap<Long, Guild> call(LinkedHashMap<Long, Guild> linkedHashMap) {
            return call2(linkedHashMap);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedHashMap<Long, Guild> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
            LinkedHashMap<Long, Guild> linkedHashMap2 = new LinkedHashMap<>();
            Guild guild = this.$currentGuild;
            if (guild != null) {
                linkedHashMap2.put(Long.valueOf(guild.getId()), this.$currentGuild);
            }
            Intrinsics3.checkNotNullExpressionValue(linkedHashMap, "allGuilds");
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<Long, Guild> entry : linkedHashMap.entrySet()) {
                Long key = entry.getKey();
                if (!Intrinsics3.areEqual(key, this.$currentGuild != null ? Long.valueOf(r4.getId()) : null)) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            linkedHashMap2.putAll(linkedHashMap3);
            return linkedHashMap2;
        }
    }

    /* compiled from: StickerPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010 \u001a\u00020\u001d2X\u0010\u0006\u001aT\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0005**\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000j\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0000j\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003`\u00042*\u0010\u000b\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\b0\f2\u000e\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u001a\u0010\u001b\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0019\u0012\b\u0012\u00060\u0001j\u0002`\u001a0\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\n¢\u0006\u0004\b\u001e\u0010\u001f"}, d2 = {"Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "kotlin.jvm.PlatformType", "allGuilds", "", "Lcom/discord/primitives/StickerId;", "Lcom/discord/api/sticker/Sticker;", "Lcom/discord/stores/StickerMap;", "guildStickers", "", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "enabledStickerPacks", "frequentlyUsedStickerIds", "", "searchInputString", "", "stickerAnimationSettings", "selectedCategoryId", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "selectedExpressionPickerTab", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "allChannelPermissions", "cooldownSecs", "Lcom/discord/widgets/chat/input/sticker/StickerPickerViewModel$StoreState$Loaded;", "invoke", "(Ljava/util/LinkedHashMap;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/Long;Lcom/discord/models/user/MeUser;Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;Ljava/util/Map;I)Lcom/discord/widgets/chat/input/sticker/StickerPickerViewModel$StoreState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$Companion$observeStoreState$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function11<LinkedHashMap<Long, Guild>, Map<Long, ? extends Map<Long, ? extends Sticker>>, List<? extends ModelStickerPack>, List<? extends Long>, String, Integer, Long, MeUser, ExpressionTrayTab, Map<Long, ? extends Long>, Integer, StickerPickerViewModel.StoreState.Loaded> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(11);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function11
        public /* bridge */ /* synthetic */ StickerPickerViewModel.StoreState.Loaded invoke(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, ? extends Sticker>> map, List<? extends ModelStickerPack> list, List<? extends Long> list2, String str, Integer num, Long l, MeUser meUser, ExpressionTrayTab expressionTrayTab, Map<Long, ? extends Long> map2, Integer num2) {
            return invoke(linkedHashMap, (Map<Long, ? extends Map<Long, Sticker>>) map, (List<ModelStickerPack>) list, (List<Long>) list2, str, num.intValue(), l, meUser, expressionTrayTab, (Map<Long, Long>) map2, num2.intValue());
        }

        public final StickerPickerViewModel.StoreState.Loaded invoke(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, Sticker>> map, List<ModelStickerPack> list, List<Long> list2, String str, int i, Long l, MeUser meUser, ExpressionTrayTab expressionTrayTab, Map<Long, Long> map2, int i2) {
            Intrinsics3.checkNotNullParameter(map, "guildStickers");
            Intrinsics3.checkNotNullParameter(list, "enabledStickerPacks");
            Intrinsics3.checkNotNullParameter(list2, "frequentlyUsedStickerIds");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(expressionTrayTab, "selectedExpressionPickerTab");
            Intrinsics3.checkNotNullParameter(map2, "allChannelPermissions");
            Intrinsics3.checkNotNullExpressionValue(linkedHashMap, "allGuilds");
            Intrinsics3.checkNotNullExpressionValue(str, "searchInputString");
            boolean z2 = expressionTrayTab == ExpressionTrayTab.STICKER;
            Channel channel = this.$channel;
            Long l2 = map2.get(Long.valueOf(channel != null ? channel.getId() : 0L));
            return new StickerPickerViewModel.StoreState.Loaded(linkedHashMap, map, list, list2, str, i, l, meUser, z2, channel, l2 != null ? l2.longValue() : 0L, i2 > 0);
        }
    }

    public StickerPickerViewModel2(StoreGuilds storeGuilds, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, BehaviorSubject behaviorSubject, StoreUserSettings storeUserSettings, BehaviorSubject behaviorSubject2, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StorePermissions storePermissions, StoreSlowMode storeSlowMode) {
        this.$storeGuilds = storeGuilds;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$storeGuildStickers = storeGuildStickers;
        this.$storeStickers = storeStickers;
        this.$searchSubject = behaviorSubject;
        this.$storeUserSettings = storeUserSettings;
        this.$selectedPackIdSubject = behaviorSubject2;
        this.$storeUser = storeUser;
        this.$storeExpressionPickerNavigation = storeExpressionPickerNavigation;
        this.$storePermissions = storePermissions;
        this.$storeSlowMode = storeSlowMode;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends StickerPickerViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Observable<? extends StickerPickerViewModel.StoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Guild guild;
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent != null) {
            guild = this.$storeGuilds.getGuild(channelOrParent.getGuildId());
            if (guild == null) {
                guild = null;
            }
        }
        Observable<R> observableR = this.$storeGuildsSorted.observeOrderedGuilds().G(new AnonymousClass1(guild)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeGuildsSorted.observ… }.distinctUntilChanged()");
        return ObservableCombineLatestOverloads2.combineLatest(observableR, this.$storeGuildStickers.observeGuildStickers(), this.$storeStickers.observeEnabledStickerPacks(), this.$storeStickers.observeFrequentlyUsedStickerIds(), this.$searchSubject, StoreUserSettings.observeStickerAnimationSettings$default(this.$storeUserSettings, false, 1, null), this.$selectedPackIdSubject, StoreUser.observeMe$default(this.$storeUser, false, 1, null), this.$storeExpressionPickerNavigation.observeSelectedTab(), this.$storePermissions.observePermissionsForAllChannels(), this.$storeSlowMode.observeCooldownSecs(Long.valueOf(resolvedSelectedChannel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new AnonymousClass2(channelOrParent));
    }
}
