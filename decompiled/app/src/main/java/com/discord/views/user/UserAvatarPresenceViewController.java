package com.discord.views.user;

import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.viewcontroller.RxViewController;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: UserAvatarPresenceViewController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00060\u000bj\u0002`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/discord/views/user/UserAvatarPresenceViewController;", "Lcom/discord/utilities/viewcontroller/RxViewController;", "Lcom/discord/views/user/UserAvatarPresenceView;", "Lcom/discord/views/user/UserAvatarPresenceView$a;", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "Lcom/discord/stores/StoreUserPresence;", "c", "Lcom/discord/stores/StoreUserPresence;", "storeUserPresence", "", "Lcom/discord/primitives/UserId;", "a", "J", "userId", "Lcom/discord/stores/StoreUser;", "b", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/utilities/streams/StreamContextService;", "d", "Lcom/discord/utilities/streams/StreamContextService;", "streamContextService", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UserAvatarPresenceViewController extends RxViewController<UserAvatarPresenceView, UserAvatarPresenceView.a> {

    /* renamed from: a, reason: from kotlin metadata */
    public long userId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StoreUser storeUser;

    /* renamed from: c, reason: from kotlin metadata */
    public final StoreUserPresence storeUserPresence;

    /* renamed from: d, reason: from kotlin metadata */
    public final StreamContextService streamContextService;

    /* compiled from: UserAvatarPresenceViewController.kt */
    public static final class a<T1, T2, T3, R> implements Func3<User, ModelRichPresence, StreamContext, UserAvatarPresenceView.a> {
        public static final a a = new a();

        @Override // rx.functions.Func3
        public UserAvatarPresenceView.a call(User user, ModelRichPresence modelRichPresence, StreamContext streamContext) {
            User user2 = user;
            ModelRichPresence modelRichPresence2 = modelRichPresence;
            StreamContext streamContext2 = streamContext;
            Intrinsics3.checkNotNullExpressionValue(user2, "user");
            return new UserAvatarPresenceView.a(user2, modelRichPresence2 != null ? modelRichPresence2.getPresence() : null, streamContext2, true, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceViewController(UserAvatarPresenceView userAvatarPresenceView, StoreUser storeUser, StoreUserPresence storeUserPresence, StreamContextService streamContextService, int i) {
        super(userAvatarPresenceView);
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        StoreUserPresence presences = (i & 4) != 0 ? StoreStream.INSTANCE.getPresences() : null;
        StreamContextService streamContextService2 = (i & 8) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : null;
        Intrinsics3.checkNotNullParameter(userAvatarPresenceView, "view");
        Intrinsics3.checkNotNullParameter(users, "storeUser");
        Intrinsics3.checkNotNullParameter(presences, "storeUserPresence");
        Intrinsics3.checkNotNullParameter(streamContextService2, "streamContextService");
        this.storeUser = users;
        this.storeUserPresence = presences;
        this.streamContextService = streamContextService2;
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public void configureView(UserAvatarPresenceView.a aVar) {
        UserAvatarPresenceView.a aVar2 = aVar;
        Intrinsics3.checkNotNullParameter(aVar2, "viewState");
        getView().a(aVar2);
    }

    @Override // com.discord.utilities.viewcontroller.RxViewController
    public Observable<UserAvatarPresenceView.a> observeState() {
        Observable<R> observableG = this.storeUser.observeUser(this.userId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<UserAvatarPresenceView.a> observableI = Observable.i(observableG, ModelRichPresence.INSTANCE.get(this.userId, this.storeUserPresence), this.streamContextService.getForUser(this.userId, false), a.a);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…nce = true,\n      )\n    }");
        return observableI;
    }
}
