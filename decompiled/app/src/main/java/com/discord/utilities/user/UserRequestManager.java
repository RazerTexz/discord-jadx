package com.discord.utilities.user;

import android.content.Context;
import com.discord.api.user.User;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* compiled from: UserRequestManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0010\u0010\u000bR:\u0010\u0013\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\u0011j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0005`\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/utilities/user/UserRequestManager;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "onRequestStarted", "(JLrx/Subscription;)V", "onRequestEnded", "(J)V", "", "userIds", "requestUsers", "(Ljava/util/Collection;)V", "requestUser", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "userRequests", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Lcom/discord/api/user/User;", "onFlush", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UserRequestManager {
    private final Function1<User, Unit> onFlush;
    private final HashMap<Long, Subscription> userRequests;

    /* compiled from: UserRequestManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/User;", "it", "", "invoke", "(Lcom/discord/api/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.user.UserRequestManager$requestUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            if (user != null) {
                UserRequestManager.access$getOnFlush$p(UserRequestManager.this).invoke(user);
            }
        }
    }

    /* compiled from: UserRequestManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.user.UserRequestManager$requestUser$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UserRequestManager.access$onRequestEnded(UserRequestManager.this, this.$userId);
        }
    }

    /* compiled from: UserRequestManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.user.UserRequestManager$requestUser$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            UserRequestManager.access$onRequestStarted(UserRequestManager.this, this.$userId, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserRequestManager(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onFlush");
        this.onFlush = function1;
        this.userRequests = new HashMap<>();
    }

    public static final /* synthetic */ Function1 access$getOnFlush$p(UserRequestManager userRequestManager) {
        return userRequestManager.onFlush;
    }

    public static final /* synthetic */ void access$onRequestEnded(UserRequestManager userRequestManager, long j) {
        userRequestManager.onRequestEnded(j);
    }

    public static final /* synthetic */ void access$onRequestStarted(UserRequestManager userRequestManager, long j, Subscription subscription) {
        userRequestManager.onRequestStarted(j, subscription);
    }

    private final synchronized void onRequestEnded(long userId) {
        Subscription subscriptionRemove = this.userRequests.remove(Long.valueOf(userId));
        if (subscriptionRemove != null) {
            subscriptionRemove.unsubscribe();
        }
    }

    private final synchronized void onRequestStarted(long userId, Subscription subscription) {
        this.userRequests.put(Long.valueOf(userId), subscription);
    }

    public final synchronized void requestUser(long userId) {
        if (this.userRequests.containsKey(Long.valueOf(userId))) {
            return;
        }
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userGet(userId), false, 1, null);
        Class<?> cls = getClass();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn$default, cls, (Context) null, new AnonymousClass3(userId), (Function1) null, (Function0) null, new AnonymousClass2(userId), anonymousClass1, 26, (Object) null);
    }

    public final synchronized void requestUsers(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            requestUser(((Number) it.next()).longValue());
        }
    }
}
