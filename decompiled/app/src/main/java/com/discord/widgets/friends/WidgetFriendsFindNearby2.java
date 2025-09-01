package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsFindNearby;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* compiled from: WidgetFriendsFindNearby.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "kotlin.jvm.PlatformType", "nearbyState", "Lrx/Observable;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/friends/NearbyManager$NearbyState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby2<T, R> implements Func1<NearbyManager.NearbyState, Observable<? extends WidgetFriendsFindNearby.Model>> {
    public static final WidgetFriendsFindNearby2 INSTANCE = new WidgetFriendsFindNearby2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetFriendsFindNearby.Model> call(NearbyManager.NearbyState nearbyState) {
        return call2(nearbyState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetFriendsFindNearby.Model> call2(NearbyManager.NearbyState nearbyState) {
        ScalarSynchronousObservable scalarSynchronousObservable;
        if (nearbyState instanceof NearbyManager.NearbyState.Disconnected) {
            return new ScalarSynchronousObservable(new WidgetFriendsFindNearby.Model.Error(Integer.valueOf(((NearbyManager.NearbyState.Disconnected) nearbyState).getCode())));
        }
        if (nearbyState instanceof NearbyManager.NearbyState.Uninitialized) {
            scalarSynchronousObservable = new ScalarSynchronousObservable(WidgetFriendsFindNearby.Model.Uninitialized.INSTANCE);
        } else {
            if (!(nearbyState instanceof NearbyManager.NearbyState.Connected)) {
                throw new NoWhenBranchMatchedException();
            }
            NearbyManager.NearbyState.Connected connected = (NearbyManager.NearbyState.Connected) nearbyState;
            if (!connected.getNearbyUserIds().isEmpty()) {
                return WidgetFriendsFindNearby.ModelProvider.access$getUserModels(WidgetFriendsFindNearby.ModelProvider.INSTANCE, connected.getNearbyUserIds());
            }
            scalarSynchronousObservable = new ScalarSynchronousObservable(WidgetFriendsFindNearby.Model.Empty.INSTANCE);
        }
        return scalarSynchronousObservable;
    }
}
