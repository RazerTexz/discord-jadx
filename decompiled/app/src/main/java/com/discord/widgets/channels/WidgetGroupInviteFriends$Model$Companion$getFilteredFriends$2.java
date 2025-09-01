package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0010\r\u001aê\u0001\u0012n\b\u0001\u0012j\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t \u0003*4\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t\u0018\u00010\n0\u0007 \u0003*t\u0012n\b\u0001\u0012j\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t \u0003*4\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t\u0018\u00010\n0\u0007\u0018\u00010\u00060\u00062>\u0010\u0005\u001a:\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002 \u0003*\u001c\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0018\u00010\u00040\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "", "excludeUserIds", "Lrx/Observable;", "", "", "Lcom/discord/primitives/RelationshipType;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2<T, R> implements Func1<List<Long>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ String $nameFilter;

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\u0010\u000b\u001aê\u0001\u0012n\b\u0001\u0012j\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004 \u0005*4\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004\u0018\u00010\u00000\b \u0005*t\u0012n\b\u0001\u0012j\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004 \u0005*4\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004\u0018\u00010\u00000\b\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "relationships", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends Map<Long, Integer>>> {
        public final /* synthetic */ List $excludeUserIds;

        /* compiled from: WidgetGroupInviteFriends.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001aê\u0001\u0012n\b\u0001\u0012j\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t \u0004*4\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t\u0018\u00010\u00000\u0007 \u0004*t\u0012n\b\u0001\u0012j\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t \u0004*4\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\bj\u0002`\t\u0018\u00010\u00000\u0007\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "Lrx/Observable;", "", "", "Lcom/discord/primitives/RelationshipType;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02411<T, R> implements Func1<Map<Long, ? extends User>, Observable<? extends Map<Long, Integer>>> {
            public final /* synthetic */ Map $relationships;

            /* compiled from: WidgetGroupInviteFriends.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "entry", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map$Entry;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02421<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Boolean> {
                public final /* synthetic */ Map $users;

                public C02421(Map map) {
                    this.$users = map;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Boolean call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
                /* renamed from: call, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean call2(Map.Entry<Long, Integer> entry) {
                    boolean zContains;
                    User user;
                    String username;
                    boolean z2 = true;
                    if (AnonymousClass1.this.$excludeUserIds.contains(entry.getKey()) || !this.$users.containsKey(entry.getKey())) {
                        z2 = false;
                    } else {
                        Map map = this.$users;
                        if (map == null || (user = (User) map.get(entry.getKey())) == null || (username = user.getUsername()) == null) {
                            zContains = false;
                        } else {
                            String str = WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2.this.$nameFilter;
                            if (str != null) {
                                String lowerCase = str.toLowerCase();
                                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                if (lowerCase == null) {
                                    lowerCase = "";
                                }
                                zContains = Strings4.contains((CharSequence) username, (CharSequence) lowerCase, true);
                            }
                        }
                        if (!zContains) {
                        }
                    }
                    return Boolean.valueOf(z2);
                }
            }

            /* compiled from: WidgetGroupInviteFriends.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u000226\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map$Entry;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Long> {
                public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Long call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Long call2(Map.Entry<Long, Integer> entry) {
                    return entry.getKey();
                }
            }

            /* compiled from: WidgetGroupInviteFriends.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map$Entry;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$3, reason: invalid class name */
            public static final class AnonymousClass3<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Integer> {
                public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Integer call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Integer call2(Map.Entry<Long, Integer> entry) {
                    return entry.getValue();
                }
            }

            public C02411(Map map) {
                this.$relationships = map;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends User> map) {
                return call2(map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, Integer>> call2(Map<Long, ? extends User> map) {
                return Observable.B(this.$relationships.entrySet()).y(new C02421(map)).g0(AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE);
            }
        }

        public AnonymousClass1(List list) {
            this.$excludeUserIds = list;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, Integer>> call2(Map<Long, Integer> map) {
            return StoreStream.INSTANCE.getUsers().observeUsers(map.keySet()).Y(new C02411(map));
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(String str) {
        this.$nameFilter = str;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(List<Long> list) {
        return call2(list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, Integer>> call2(List<Long> list) {
        return StoreStream.INSTANCE.getUserRelationships().observeForType(1).Y(new AnonymousClass1(list));
    }
}
