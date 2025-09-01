package com.discord.widgets.user.calls;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissions2;
import com.discord.widgets.voice.call.PrivateCallLaunchUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PrivateCallLauncher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\u0007R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/calls/PrivateCallLauncher;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "launchVoiceCall", "(J)V", "launchVideoCall", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/discord/app/AppPermissionsRequests;", "appPermissionsRequests", "Lcom/discord/app/AppPermissionsRequests;", "getAppPermissionsRequests", "()Lcom/discord/app/AppPermissionsRequests;", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppComponent;", "getAppComponent", "()Lcom/discord/app/AppComponent;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "<init>", "(Lcom/discord/app/AppPermissionsRequests;Lcom/discord/app/AppComponent;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class PrivateCallLauncher {
    private final AppComponent appComponent;
    private final AppPermissions2 appPermissionsRequests;
    private final Context context;
    private final FragmentManager fragmentManager;

    public PrivateCallLauncher(AppPermissions2 appPermissions2, AppComponent appComponent, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(appPermissions2, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.appPermissionsRequests = appPermissions2;
        this.appComponent = appComponent;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    public final AppPermissions2 getAppPermissionsRequests() {
        return this.appPermissionsRequests;
    }

    public final Context getContext() {
        return this.context;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void launchVideoCall(long channelId) {
        PrivateCallLaunchUtils.callAndLaunch(channelId, true, this.appPermissionsRequests, this.context, this.appComponent, this.fragmentManager);
    }

    public final void launchVoiceCall(long channelId) {
        PrivateCallLaunchUtils.callAndLaunch(channelId, false, this.appPermissionsRequests, this.context, this.appComponent, this.fragmentManager);
    }
}
