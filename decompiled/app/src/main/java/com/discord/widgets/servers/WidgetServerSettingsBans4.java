package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelBan;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorToObservableSortedList;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsBans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006 \u0007*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00050\u00052\u0018\u0010\u0004\u001a\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/domain/ModelBan;", "bannedUserMap", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans4<T, R> implements Func1<Map<Long, ? extends ModelBan>, Observable<? extends WidgetServerSettingsBans.Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/guild/Guild;", "it", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Guild, WidgetServerSettingsBans.Model> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetServerSettingsBans.Model call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsBans.Model call2(Guild guild) {
            return WidgetServerSettingsBans.Model.Companion.access$createLoading(WidgetServerSettingsBans.Model.INSTANCE, guild);
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\t\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00050\u0005 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00060\u0004 \u0001*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00050\u0005 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00060\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "kotlin.jvm.PlatformType", "filter", "Lrx/Observable;", "", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<String, Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>>> {
        public final /* synthetic */ Map $bannedUserMap;

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelBan;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelBan;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<ModelBan, Boolean> {
            public final /* synthetic */ String $filter;

            public AnonymousClass1(String str) {
                this.$filter = str;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(ModelBan modelBan) {
                return call2(modelBan);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(ModelBan modelBan) {
                Intrinsics3.checkNotNullExpressionValue(modelBan, "it");
                String username = modelBan.getUser().getUsername();
                String str = this.$filter;
                Intrinsics3.checkNotNullExpressionValue(str, "filter");
                return Boolean.valueOf(Strings4.contains((CharSequence) username, (CharSequence) str, true));
            }
        }

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelBan;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelBan;)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03032<T, R> implements Func1<ModelBan, WidgetServerSettingsBans.Model.BanItem> {
            public static final C03032 INSTANCE = new C03032();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ WidgetServerSettingsBans.Model.BanItem call(ModelBan modelBan) {
                return call2(modelBan);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsBans.Model.BanItem call2(ModelBan modelBan) {
                return new WidgetServerSettingsBans.Model.BanItem(modelBan);
            }
        }

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "kotlin.jvm.PlatformType", "banItem1", "banItem2", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, R> implements Func2<WidgetServerSettingsBans.Model.BanItem, WidgetServerSettingsBans.Model.BanItem, Integer> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Integer call(WidgetServerSettingsBans.Model.BanItem banItem, WidgetServerSettingsBans.Model.BanItem banItem2) {
                return call2(banItem, banItem2);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(WidgetServerSettingsBans.Model.BanItem banItem, WidgetServerSettingsBans.Model.BanItem banItem2) {
                User user;
                String username;
                String username2;
                User user2;
                ModelBan ban = banItem.getBan();
                if (ban == null || (user = ban.getUser()) == null || (username = user.getUsername()) == null) {
                    return null;
                }
                ModelBan ban2 = banItem2.getBan();
                if (ban2 == null || (user2 = ban2.getUser()) == null || (username2 = user2.getUsername()) == null) {
                    username2 = "";
                }
                return Integer.valueOf(StringsJVM.compareTo(username, username2, true));
            }
        }

        public AnonymousClass2(Map map) {
            this.$bannedUserMap = map;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>> call2(String str) {
            Observable<R> observableG = Observable.B(this.$bannedUserMap.values()).y(new AnonymousClass1(str)).G(C03032.INSTANCE);
            return Observable.h0(new OnSubscribeLift(observableG.j, new OperatorToObservableSortedList(AnonymousClass3.INSTANCE, 10)));
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022*\u0010\b\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u0005H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "kotlin.jvm.PlatformType", "totalBannedUsers", "", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "", "filteredBannedUsers", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/lang/Integer;Ljava/util/List;)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, R> implements Func3<Guild, Integer, List<WidgetServerSettingsBans.Model.BanItem>, WidgetServerSettingsBans.Model> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetServerSettingsBans.Model call(Guild guild, Integer num, List<WidgetServerSettingsBans.Model.BanItem> list) {
            return call2(guild, num, list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsBans.Model call2(Guild guild, Integer num, List<WidgetServerSettingsBans.Model.BanItem> list) {
            return WidgetServerSettingsBans.Model.INSTANCE.create(guild, num, list);
        }
    }

    public WidgetServerSettingsBans4(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans.Model> call(Map<Long, ? extends ModelBan> map) {
        return call2(map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans.Model> call2(Map<Long, ? extends ModelBan> map) {
        return map == null ? StoreStream.INSTANCE.getGuilds().observeGuild(this.$guildId).G(AnonymousClass1.INSTANCE) : Observable.i(StoreStream.INSTANCE.getGuilds().observeGuild(this.$guildId), new ScalarSynchronousObservable(Integer.valueOf(map.size())), this.$filterPublisher.Y(new AnonymousClass2(map)), AnonymousClass3.INSTANCE);
    }
}
