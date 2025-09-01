package org.webrtc;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.webrtc.NetworkChangeDetector;

/* loaded from: classes3.dex */
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private volatile NetworkChangeDetector.ConnectionType currentConnectionType;
    private final ArrayList<Long> nativeNetworkObservers;

    @Nullable
    private NetworkChangeDetector networkChangeDetector;
    private NetworkChangeDetectorFactory networkChangeDetectorFactory;
    private final Object networkChangeDetectorLock;
    private final ArrayList<NetworkObserver> networkObservers;
    private int numObservers;

    /* renamed from: org.webrtc.NetworkMonitor$1, reason: invalid class name */
    public class AnonymousClass1 implements NetworkChangeDetectorFactory {
        public AnonymousClass1() {
        }

        @Override // org.webrtc.NetworkChangeDetectorFactory
        public NetworkChangeDetector create(NetworkChangeDetector.Observer observer, Context context) {
            return new NetworkMonitorAutoDetect(observer, context);
        }
    }

    /* renamed from: org.webrtc.NetworkMonitor$2, reason: invalid class name */
    public class AnonymousClass2 implements NetworkChangeDetector.Observer {
        public AnonymousClass2() {
        }

        @Override // org.webrtc.NetworkChangeDetector.Observer
        public void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType connectionType) {
            NetworkMonitor.access$100(NetworkMonitor.this, connectionType);
        }

        @Override // org.webrtc.NetworkChangeDetector.Observer
        public void onNetworkConnect(NetworkChangeDetector.NetworkInformation networkInformation) {
            NetworkMonitor.access$200(NetworkMonitor.this, networkInformation);
        }

        @Override // org.webrtc.NetworkChangeDetector.Observer
        public void onNetworkDisconnect(long j) {
            NetworkMonitor.access$300(NetworkMonitor.this, j);
        }

        @Override // org.webrtc.NetworkChangeDetector.Observer
        public void onNetworkPreference(List<NetworkChangeDetector.ConnectionType> list, int i) {
            NetworkMonitor.access$400(NetworkMonitor.this, list, i);
        }
    }

    public static class InstanceHolder {
        public static final NetworkMonitor instance = new NetworkMonitor(null);

        private InstanceHolder() {
        }
    }

    public interface NetworkObserver {
        void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType connectionType);
    }

    public /* synthetic */ NetworkMonitor(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static /* synthetic */ void access$100(NetworkMonitor networkMonitor, NetworkChangeDetector.ConnectionType connectionType) {
        networkMonitor.updateCurrentConnectionType(connectionType);
    }

    public static /* synthetic */ void access$200(NetworkMonitor networkMonitor, NetworkChangeDetector.NetworkInformation networkInformation) {
        networkMonitor.notifyObserversOfNetworkConnect(networkInformation);
    }

    public static /* synthetic */ void access$300(NetworkMonitor networkMonitor, long j) {
        networkMonitor.notifyObserversOfNetworkDisconnect(j);
    }

    public static /* synthetic */ void access$400(NetworkMonitor networkMonitor, List list, int i) {
        networkMonitor.notifyObserversOfNetworkPreference(list, i);
    }

    @Deprecated
    public static void addNetworkObserver(NetworkObserver networkObserver) {
        getInstance().addObserver(networkObserver);
    }

    @CalledByNative
    private static int androidSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    private static void assertIsTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected to be true");
        }
    }

    public static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context context) {
        NetworkMonitor networkMonitor = getInstance();
        NetworkChangeDetector networkChangeDetectorCreateNetworkChangeDetector = networkMonitor.createNetworkChangeDetector(context);
        networkMonitor.networkChangeDetector = networkChangeDetectorCreateNetworkChangeDetector;
        return (NetworkMonitorAutoDetect) networkChangeDetectorCreateNetworkChangeDetector;
    }

    private NetworkChangeDetector createNetworkChangeDetector(Context context) {
        return this.networkChangeDetectorFactory.create(new AnonymousClass2(), context);
    }

    private NetworkChangeDetector.ConnectionType getCurrentConnectionType() {
        return this.currentConnectionType;
    }

    @CalledByNative
    public static NetworkMonitor getInstance() {
        return InstanceHolder.instance;
    }

    private List<Long> getNativeNetworkObserversSync() {
        ArrayList arrayList;
        synchronized (this.nativeNetworkObservers) {
            arrayList = new ArrayList(this.nativeNetworkObservers);
        }
        return arrayList;
    }

    @Deprecated
    public static void init(Context context) {
    }

    public static boolean isOnline() {
        return getInstance().getCurrentConnectionType() != NetworkChangeDetector.ConnectionType.CONNECTION_NONE;
    }

    private native void nativeNotifyConnectionTypeChanged(long j);

    private native void nativeNotifyOfActiveNetworkList(long j, NetworkChangeDetector.NetworkInformation[] networkInformationArr);

    private native void nativeNotifyOfNetworkConnect(long j, NetworkChangeDetector.NetworkInformation networkInformation);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private native void nativeNotifyOfNetworkPreference(long j, NetworkChangeDetector.ConnectionType connectionType, int i);

    @CalledByNative
    private boolean networkBindingSupported() {
        boolean z2;
        synchronized (this.networkChangeDetectorLock) {
            NetworkChangeDetector networkChangeDetector = this.networkChangeDetector;
            z2 = networkChangeDetector != null && networkChangeDetector.supportNetworkCallback();
        }
        return z2;
    }

    private void notifyObserversOfConnectionTypeChange(NetworkChangeDetector.ConnectionType connectionType) {
        ArrayList arrayList;
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue());
        }
        synchronized (this.networkObservers) {
            arrayList = new ArrayList(this.networkObservers);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((NetworkObserver) it2.next()).onConnectionTypeChanged(connectionType);
        }
    }

    private void notifyObserversOfNetworkConnect(NetworkChangeDetector.NetworkInformation networkInformation) {
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), networkInformation);
        }
    }

    private void notifyObserversOfNetworkDisconnect(long j) {
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), j);
        }
    }

    private void notifyObserversOfNetworkPreference(List<NetworkChangeDetector.ConnectionType> list, int i) {
        List<Long> nativeNetworkObserversSync = getNativeNetworkObserversSync();
        for (NetworkChangeDetector.ConnectionType connectionType : list) {
            Iterator<Long> it = nativeNetworkObserversSync.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkPreference(it.next().longValue(), connectionType, i);
            }
        }
    }

    @Deprecated
    public static void removeNetworkObserver(NetworkObserver networkObserver) {
        getInstance().removeObserver(networkObserver);
    }

    private void updateCurrentConnectionType(NetworkChangeDetector.ConnectionType connectionType) {
        this.currentConnectionType = connectionType;
        notifyObserversOfConnectionTypeChange(connectionType);
    }

    private void updateObserverActiveNetworkList(long j) {
        List<NetworkChangeDetector.NetworkInformation> activeNetworkList;
        synchronized (this.networkChangeDetectorLock) {
            NetworkChangeDetector networkChangeDetector = this.networkChangeDetector;
            activeNetworkList = networkChangeDetector == null ? null : networkChangeDetector.getActiveNetworkList();
        }
        if (activeNetworkList == null || activeNetworkList.size() == 0) {
            return;
        }
        nativeNotifyOfActiveNetworkList(j, (NetworkChangeDetector.NetworkInformation[]) activeNetworkList.toArray(new NetworkChangeDetector.NetworkInformation[activeNetworkList.size()]));
    }

    public void addObserver(NetworkObserver networkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.add(networkObserver);
        }
    }

    @Nullable
    public NetworkChangeDetector getNetworkChangeDetector() {
        NetworkChangeDetector networkChangeDetector;
        synchronized (this.networkChangeDetectorLock) {
            networkChangeDetector = this.networkChangeDetector;
        }
        return networkChangeDetector;
    }

    public int getNumObservers() {
        int i;
        synchronized (this.networkChangeDetectorLock) {
            i = this.numObservers;
        }
        return i;
    }

    public void removeObserver(NetworkObserver networkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.remove(networkObserver);
        }
    }

    public void setNetworkChangeDetectorFactory(NetworkChangeDetectorFactory networkChangeDetectorFactory) {
        assertIsTrue(this.numObservers == 0);
        this.networkChangeDetectorFactory = networkChangeDetectorFactory;
    }

    public void startMonitoring(Context context) {
        synchronized (this.networkChangeDetectorLock) {
            this.numObservers++;
            if (this.networkChangeDetector == null) {
                this.networkChangeDetector = createNetworkChangeDetector(context);
            }
            this.currentConnectionType = this.networkChangeDetector.getCurrentConnectionType();
        }
    }

    public void stopMonitoring() {
        synchronized (this.networkChangeDetectorLock) {
            int i = this.numObservers - 1;
            this.numObservers = i;
            if (i == 0) {
                this.networkChangeDetector.destroy();
                this.networkChangeDetector = null;
            }
        }
    }

    private NetworkMonitor() {
        this.networkChangeDetectorFactory = new AnonymousClass1();
        this.networkChangeDetectorLock = new Object();
        this.nativeNetworkObservers = new ArrayList<>();
        this.networkObservers = new ArrayList<>();
        this.numObservers = 0;
        this.currentConnectionType = NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN;
    }

    @CalledByNative
    private void stopMonitoring(long j) {
        Logging.d(TAG, "Stop monitoring with native observer " + j);
        stopMonitoring();
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.remove(Long.valueOf(j));
        }
    }

    @Deprecated
    public void startMonitoring() {
        startMonitoring(ContextUtils.getApplicationContext());
    }

    @CalledByNative
    private void startMonitoring(@Nullable Context context, long j) {
        Logging.d(TAG, "Start monitoring with native observer " + j);
        if (context == null) {
            context = ContextUtils.getApplicationContext();
        }
        startMonitoring(context);
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.add(Long.valueOf(j));
        }
        updateObserverActiveNetworkList(j);
        notifyObserversOfConnectionTypeChange(this.currentConnectionType);
    }
}
