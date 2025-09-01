package com.discord.widgets.tabs;

import com.discord.widgets.tabs.TabsHostBottomNavigationView;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: BottomNavViewObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tR:\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\n0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/tabs/BottomNavViewObserver;", "Lcom/discord/widgets/tabs/TabsHostBottomNavigationView$HeightChangedListener;", "", "height", "", "onHeightChanged", "(I)V", "Lrx/Observable;", "observeHeight", "()Lrx/Observable;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "heightSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class BottomNavViewObserver implements TabsHostBottomNavigationView.HeightChangedListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(BottomNavViewObserver2.INSTANCE);
    private final BehaviorSubject<Integer> heightSubject = BehaviorSubject.l0(0);

    /* compiled from: BottomNavViewObserver.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/widgets/tabs/BottomNavViewObserver$Companion;", "", "Lcom/discord/widgets/tabs/BottomNavViewObserver;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/widgets/tabs/BottomNavViewObserver;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final BottomNavViewObserver getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = BottomNavViewObserver.access$getINSTANCE$cp();
            Companion companion = BottomNavViewObserver.INSTANCE;
            return (BottomNavViewObserver) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final Observable<Integer> observeHeight() {
        BehaviorSubject<Integer> behaviorSubject = this.heightSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "heightSubject");
        return behaviorSubject;
    }

    @Override // com.discord.widgets.tabs.TabsHostBottomNavigationView.HeightChangedListener
    public void onHeightChanged(int height) {
        this.heightSubject.onNext(Integer.valueOf(height));
    }
}
