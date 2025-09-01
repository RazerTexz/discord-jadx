package com.discord.utilities.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NetworkMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/discord/utilities/networking/NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "", "onAvailable", "(Landroid/net/Network;)V", "onUnavailable", "()V", "onLost", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onCapabilitiesChanged", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$networkCallback$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NetworkMonitor2 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ NetworkMonitor this$0;

    public NetworkMonitor2(NetworkMonitor networkMonitor, Context context) {
        this.this$0 = networkMonitor;
        this.$context = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics3.checkNotNullParameter(network, "network");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onAvailable fired: " + network, null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics3.checkNotNullParameter(network, "network");
        Intrinsics3.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onCapabilitiesChanged fired: " + network, null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics3.checkNotNullParameter(network, "network");
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onLost fired: " + network, null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        Logger.i$default(NetworkMonitor.access$getLogger$p(this.this$0), "[NetworkMonitor]", "Network callback, onUnavailable fired.", null, 4, null);
        NetworkMonitor.updateNetworkState$default(this.this$0, this.$context, null, 2, null);
    }
}
