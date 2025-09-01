package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePermissions;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.home.WidgetHomeViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func5;

/* compiled from: WidgetHomeViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "selectedGuildId", "Lrx/Observable;", "Lcom/discord/widgets/home/WidgetHomeViewModel$GuildInfo;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeViewModel3<T, R> implements Func1<Long, Observable<? extends WidgetHomeViewModel.GuildInfo>> {
    public final /* synthetic */ StoreGuildWelcomeScreens $storeGuildWelcomeScreens;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildsNsfw;
    public final /* synthetic */ StoreLurking $storeLurking;
    public final /* synthetic */ StorePermissions $storePermissions;

    /* compiled from: WidgetHomeViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\u000b0\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\n\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "kotlin.jvm.PlatformType", "isLurking", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "welcomeScreenState", "", "Lcom/discord/api/permission/PermissionBit;", "guildPermissions", "isNsfwGateAgreed", "Lcom/discord/widgets/home/WidgetHomeViewModel$GuildInfo;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/lang/Boolean;Lcom/discord/stores/StoreGuildWelcomeScreens$State;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/discord/widgets/home/WidgetHomeViewModel$GuildInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, R> implements Func5<Guild, Boolean, StoreGuildWelcomeScreens.State, Long, Boolean, WidgetHomeViewModel.GuildInfo> {
        public final /* synthetic */ Long $selectedGuildId;

        public AnonymousClass1(Long l) {
            this.$selectedGuildId = l;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetHomeViewModel.GuildInfo call(Guild guild, Boolean bool, StoreGuildWelcomeScreens.State state, Long l, Boolean bool2) {
            return call2(guild, bool, state, l, bool2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetHomeViewModel.GuildInfo call2(Guild guild, Boolean bool, StoreGuildWelcomeScreens.State state, Long l, Boolean bool2) {
            Long l2 = this.$selectedGuildId;
            Intrinsics3.checkNotNullExpressionValue(l2, "selectedGuildId");
            long jLongValue = l2.longValue();
            Intrinsics3.checkNotNullExpressionValue(bool, "isLurking");
            return new WidgetHomeViewModel.GuildInfo(jLongValue, guild, bool.booleanValue(), state, !bool2.booleanValue(), l != null ? PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue())) : false);
        }
    }

    public WidgetHomeViewModel3(StoreGuilds storeGuilds, StoreLurking storeLurking, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StorePermissions storePermissions, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeGuilds = storeGuilds;
        this.$storeLurking = storeLurking;
        this.$storeGuildWelcomeScreens = storeGuildWelcomeScreens;
        this.$storePermissions = storePermissions;
        this.$storeGuildsNsfw = storeGuildsNsfw;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeViewModel.GuildInfo> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeViewModel.GuildInfo> call2(Long l) {
        StoreGuilds storeGuilds = this.$storeGuilds;
        Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
        return Observable.g(storeGuilds.observeGuild(l.longValue()), this.$storeLurking.isLurkingObs(l.longValue()), this.$storeGuildWelcomeScreens.observeGuildWelcomeScreen(l.longValue()), this.$storePermissions.observePermissionsForGuild(l.longValue()), this.$storeGuildsNsfw.observeIsGuildNsfwGateAgreed(l.longValue()), new AnonymousClass1(l));
    }
}
