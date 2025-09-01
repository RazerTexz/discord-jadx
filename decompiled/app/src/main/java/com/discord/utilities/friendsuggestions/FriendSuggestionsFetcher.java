package com.discord.utilities.friendsuggestions;

import android.content.Context;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.Dispatcher;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* compiled from: FriendSuggestionsFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00020\u000e\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/friendsuggestions/FriendSuggestionsFetcher;", "", "", "maybeFetch", "()V", "Lkotlin/Function0;", "onFetchFailure", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lrx/Subscription;", "fetchSubscription", "Lrx/Subscription;", "Lkotlin/Function1;", "", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "onFetchSuccess", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/restapi/RestAPIInterface;", "restApi", "Lcom/discord/restapi/RestAPIInterface;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/restapi/RestAPIInterface;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FriendSuggestionsFetcher {
    private final Dispatcher dispatcher;
    private Subscription fetchSubscription;
    private final Function0<Unit> onFetchFailure;
    private final Function1<List<FriendSuggestion>, Unit> onFetchSuccess;
    private final RestAPIInterface restApi;

    /* compiled from: FriendSuggestionsFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            FriendSuggestionsFetcher.access$setFetchSubscription$p(FriendSuggestionsFetcher.this, subscription);
        }
    }

    /* compiled from: FriendSuggestionsFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "response", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends FriendSuggestion>, Unit> {

        /* compiled from: FriendSuggestionsFetcher.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$response = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.access$getOnFetchSuccess$p(FriendSuggestionsFetcher.this).invoke(this.$response);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
            invoke2((List<FriendSuggestion>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<FriendSuggestion> list) {
            Intrinsics3.checkNotNullParameter(list, "response");
            FriendSuggestionsFetcher.access$getDispatcher$p(FriendSuggestionsFetcher.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: FriendSuggestionsFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: FriendSuggestionsFetcher.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.access$getOnFetchFailure$p(FriendSuggestionsFetcher.this).invoke();
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FriendSuggestionsFetcher.access$getDispatcher$p(FriendSuggestionsFetcher.this).schedule(new AnonymousClass1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendSuggestionsFetcher(Dispatcher dispatcher, RestAPIInterface restAPIInterface, Function1<? super List<FriendSuggestion>, Unit> function1, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPIInterface, "restApi");
        Intrinsics3.checkNotNullParameter(function1, "onFetchSuccess");
        Intrinsics3.checkNotNullParameter(function0, "onFetchFailure");
        this.dispatcher = dispatcher;
        this.restApi = restAPIInterface;
        this.onFetchSuccess = function1;
        this.onFetchFailure = function0;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getFetchSubscription$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.fetchSubscription;
    }

    public static final /* synthetic */ Function0 access$getOnFetchFailure$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.onFetchFailure;
    }

    public static final /* synthetic */ Function1 access$getOnFetchSuccess$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.onFetchSuccess;
    }

    public static final /* synthetic */ void access$setFetchSubscription$p(FriendSuggestionsFetcher friendSuggestionsFetcher, Subscription subscription) {
        friendSuggestionsFetcher.fetchSubscription = subscription;
    }

    public final void maybeFetch() {
        Subscription subscription = this.fetchSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getFriendSuggestions(), false, 1, null), FriendSuggestionsFetcher.class, (Context) null, new AnonymousClass1(), new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 50, (Object) null);
        }
    }
}
