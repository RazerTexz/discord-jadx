package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.Func1;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\r\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\t0\t \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\b \u0005*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\t0\t \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\b\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "friends", "Lrx/Observable;", "", "Lcom/discord/models/user/User;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends List<User>>> {
    public final /* synthetic */ Observable $addedUsers;

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0003\u0010\t\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00060\u0005 \u0002*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00060\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "alreadyAddedUsers", "Lrx/Observable;", "", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Collection;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Collection<? extends User>, Observable<? extends List<User>>> {
        public final /* synthetic */ Map $friends;

        /* compiled from: WidgetGroupInviteFriends.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "user", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/User;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02441<T, R> implements Func1<User, Boolean> {
            public C02441() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(User user) {
                return call2(user);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(User user) {
                return Boolean.valueOf(AnonymousClass1.this.$friends.containsKey(Long.valueOf(user.getId())));
            }
        }

        public AnonymousClass1(Map map) {
            this.$friends = map;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Collection<? extends User> collection) {
            return call2(collection);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<User>> call2(Collection<? extends User> collection) {
            return Observable.B(collection).y(new C02441()).f0();
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1(Observable observable) {
        this.$addedUsers = observable;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<User>> call2(Map<Long, Integer> map) {
        return this.$addedUsers.Y(new AnonymousClass1(map));
    }
}
