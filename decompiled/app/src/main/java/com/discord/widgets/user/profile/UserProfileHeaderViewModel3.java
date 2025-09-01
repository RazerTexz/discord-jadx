package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.Observable;

/* compiled from: UserProfileHeaderViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0082\u0001\u0012:\b\u0001\u00126\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0001*\u001a\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0004 \u0001*@\u0012:\b\u0001\u00126\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0001*\u001a\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lrx/Observable;", "Lkotlin/Pair;", "Lcom/discord/models/user/User;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel3<T, R> implements Func1<MeUser, Observable<? extends Tuples2<? extends MeUser, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ long $userId;

    /* compiled from: UserProfileHeaderViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a6\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0000 \u0004*\u001a\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/User;", "targetUser", "Lkotlin/Pair;", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/User;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<User, Tuples2<? extends MeUser, ? extends User>> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends User> call(User user) {
            return call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<MeUser, User> call2(User user) {
            return new Tuples2<>(this.$meUser, user);
        }
    }

    public UserProfileHeaderViewModel3(long j, StoreUser storeUser) {
        this.$userId = j;
        this.$storeUser = storeUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends MeUser, ? extends User>> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Tuples2<MeUser, User>> call2(MeUser meUser) {
        long j = this.$userId;
        return j == -1 ? new ScalarSynchronousObservable(new Tuples2(meUser, meUser)) : this.$storeUser.observeUser(j).G(new AnonymousClass1(meUser));
    }
}
