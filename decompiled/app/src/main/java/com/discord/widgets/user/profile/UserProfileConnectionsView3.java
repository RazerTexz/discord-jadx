package com.discord.widgets.user.profile;

import android.view.View;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.platform.Platform;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import kotlin.Metadata;

/* compiled from: UserProfileConnectionsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$ViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileConnectionsView3 implements View.OnClickListener {
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ String $profileUrl;
    public final /* synthetic */ int $themedPlatformImageRes;
    public final /* synthetic */ String $username;
    public final /* synthetic */ UserProfileConnectionsView.ViewHolder this$0;

    public UserProfileConnectionsView3(UserProfileConnectionsView.ViewHolder viewHolder, Platform platform, String str, int i, String str2) {
        this.this$0 = viewHolder;
        this.$platform = platform;
        this.$username = str;
        this.$themedPlatformImageRes = i;
        this.$profileUrl = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnalyticsTracker.connectedAccountViewed(this.$platform.getPlatformId());
        UserProfileConnectionsView.ViewHolder.access$getAdapter$p(this.this$0).getOnConnectedAccountClick().invoke(this.$username, Integer.valueOf(this.$themedPlatformImageRes), this.$profileUrl);
    }
}
