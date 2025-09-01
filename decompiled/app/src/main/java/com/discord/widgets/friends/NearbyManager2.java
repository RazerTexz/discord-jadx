package com.discord.widgets.friends;

import b.i.a.f.j.b.c;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.friends.NearbyManager;
import java.util.HashSet;
import kotlin.Metadata;

/* compiled from: NearbyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/discord/widgets/friends/NearbyManager$buildClient$1$1", "Lb/i/a/f/j/b/c;", "", "permissionGranted", "", "onPermissionChanged", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.NearbyManager$buildClient$$inlined$also$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NearbyManager2 extends c {
    public final /* synthetic */ NearbyManager this$0;

    public NearbyManager2(NearbyManager nearbyManager) {
        this.this$0 = nearbyManager;
    }

    @Override // b.i.a.f.j.b.c
    public void onPermissionChanged(boolean permissionGranted) {
        super.onPermissionChanged(permissionGranted);
        if (!permissionGranted) {
            NearbyManager.access$getNearbyStateSubject$p(this.this$0).onNext(new NearbyManager.NearbyState.Disconnected(98));
        } else {
            AnalyticsTracker.nearbyConnected();
            NearbyManager.access$getNearbyStateSubject$p(this.this$0).onNext(new NearbyManager.NearbyState.Connected(new HashSet(NearbyManager.access$getNearbyUserIds$p(this.this$0))));
        }
    }
}
