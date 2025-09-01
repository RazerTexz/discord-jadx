package com.discord.rtcconnection.audio;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.annotation.MainThread;
import b.a.q.k0.AudioManagerBroadcastReceiver;
import b.a.q.k0.AudioPermissions;
import b.a.q.k0.BluetoothBroadcastReceiver;
import b.a.q.k0.BluetoothHeadsetPrivateApi;
import b.a.q.k0.DiscordAudioManager2;
import b.a.q.k0.DiscordAudioManager3;
import b.a.q.k0.OnAudioManagerBroadcastListener;
import b.a.q.k0.OnBluetoothBroadcastListener;
import b.a.q.l0.WiredHeadsetState;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import com.discord.rtcconnection.enums.ScoAudioState;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: DiscordAudioManager.kt */
/* loaded from: classes.dex */
public final class DiscordAudioManager {
    public static final Lazy a = LazyJVM.lazy(d.j);

    /* renamed from: b, reason: collision with root package name */
    public static final AudioDevice f2784b = new AudioDevice(null, false, null, null, 15);
    public static final List<DeviceTypes> c = Collections2.listOf((Object[]) new DeviceTypes[]{DeviceTypes.EARPIECE, DeviceTypes.SPEAKERPHONE, DeviceTypes.BLUETOOTH_HEADSET, DeviceTypes.WIRED_HEADSET});
    public static final DiscordAudioManager d = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final AudioManager e;
    public final BluetoothManager f;
    public final Lazy g;
    public final boolean h;
    public final Object i;
    public final long j;
    public final ContentResolver k;
    public final BluetoothBroadcastReceiver l;
    public final AudioManagerBroadcastReceiver m;
    public BluetoothHeadset n;
    public BluetoothScoState o;
    public AudioManager.OnAudioFocusChangeListener p;
    public AudioFocusRequest q;
    public List<AudioDevice> r;

    /* renamed from: s, reason: collision with root package name */
    public final SerializedSubject<List<AudioDevice>, List<AudioDevice>> f2785s;
    public DeviceTypes t;
    public final SerializedSubject<DeviceTypes, DeviceTypes> u;
    public ContentObserver v;
    public int w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2786x;

    /* renamed from: y, reason: collision with root package name */
    public final SerializedSubject<Integer, Integer> f2787y;

    /* renamed from: z, reason: collision with root package name */
    public DeviceTypes f2788z;

    /* compiled from: DiscordAudioManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/discord/rtcconnection/audio/DiscordAudioManager$AudioDevice;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Z", "isAvailable", "()Z", "d", "Ljava/lang/String;", "getName", ModelAuditLogEntry.CHANGE_KEY_NAME, "c", "getId", ModelAuditLogEntry.CHANGE_KEY_ID, "Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "a", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "getType", "()Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "type", "<init>", "(Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;ZLjava/lang/String;Ljava/lang/String;)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AudioDevice {

        /* renamed from: a, reason: from kotlin metadata */
        public final DeviceTypes type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean isAvailable;

        /* renamed from: c, reason: from kotlin metadata */
        public final String id;

        /* renamed from: d, reason: from kotlin metadata */
        public final String name;

        public AudioDevice() {
            this(null, false, null, null, 15);
        }

        public AudioDevice(DeviceTypes deviceTypes, boolean z2, String str, String str2) {
            Intrinsics3.checkNotNullParameter(deviceTypes, "type");
            this.type = deviceTypes;
            this.isAvailable = z2;
            this.id = str;
            this.name = str2;
        }

        public static AudioDevice a(AudioDevice audioDevice, DeviceTypes deviceTypes, boolean z2, String str, String str2, int i) {
            DeviceTypes deviceTypes2 = (i & 1) != 0 ? audioDevice.type : null;
            if ((i & 2) != 0) {
                z2 = audioDevice.isAvailable;
            }
            if ((i & 4) != 0) {
                str = audioDevice.id;
            }
            if ((i & 8) != 0) {
                str2 = audioDevice.name;
            }
            Objects.requireNonNull(audioDevice);
            Intrinsics3.checkNotNullParameter(deviceTypes2, "type");
            return new AudioDevice(deviceTypes2, z2, str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioDevice)) {
                return false;
            }
            AudioDevice audioDevice = (AudioDevice) other;
            return Intrinsics3.areEqual(this.type, audioDevice.type) && this.isAvailable == audioDevice.isAvailable && Intrinsics3.areEqual(this.id, audioDevice.id) && Intrinsics3.areEqual(this.name, audioDevice.name);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            DeviceTypes deviceTypes = this.type;
            int iHashCode = (deviceTypes != null ? deviceTypes.hashCode() : 0) * 31;
            boolean z2 = this.isAvailable;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            String str = this.id;
            int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AudioDevice(type=");
            sbU.append(this.type);
            sbU.append(", isAvailable=");
            sbU.append(this.isAvailable);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", name=");
            return outline.J(sbU, this.name, ")");
        }

        public AudioDevice(DeviceTypes deviceTypes, boolean z2, String str, String str2, int i) {
            deviceTypes = (i & 1) != 0 ? DeviceTypes.INVALID : deviceTypes;
            z2 = (i & 2) != 0 ? false : z2;
            int i2 = i & 4;
            int i3 = i & 8;
            Intrinsics3.checkNotNullParameter(deviceTypes, "type");
            this.type = deviceTypes;
            this.isAvailable = z2;
            this.id = null;
            this.name = null;
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/rtcconnection/audio/DiscordAudioManager$BluetoothScoState;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "INVALID", "OFF", "ON", "TURNING_ON", "TURNING_OFF", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum BluetoothScoState {
        INVALID(-1),
        OFF(0),
        ON(1),
        TURNING_ON(2),
        TURNING_OFF(3);

        private final int value;

        BluetoothScoState(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "INVALID", "SPEAKERPHONE", "WIRED_HEADSET", "EARPIECE", "BLUETOOTH_HEADSET", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum DeviceTypes {
        DEFAULT(-2),
        INVALID(-1),
        SPEAKERPHONE(0),
        WIRED_HEADSET(1),
        EARPIECE(2),
        BLUETOOTH_HEADSET(3);

        private final int value;

        DeviceTypes(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
            AudioManagerBroadcastReceiver audioManagerBroadcastReceiver = discordAudioManager.m;
            Objects.requireNonNull(audioManagerBroadcastReceiver);
            ThreadUtils.checkIsOnMainThread();
            boolean profileProxy = false;
            List listListOf = Collections2.listOf((Object[]) new AudioManagerBroadcastAction[]{AudioManagerBroadcastAction.HeadsetPlug, AudioManagerBroadcastAction.ScoAudioStateUpdated});
            AnimatableValueParser.b1("AudioManagerBroadcastReceiver", "registering for broadcasts with actions: " + listListOf);
            IntentFilter intentFilter = new IntentFilter();
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                intentFilter.addAction(((AudioManagerBroadcastAction) it.next()).getAction());
            }
            audioManagerBroadcastReceiver.f261b.registerReceiver(audioManagerBroadcastReceiver, intentFilter);
            BluetoothBroadcastReceiver bluetoothBroadcastReceiver = discordAudioManager.l;
            Objects.requireNonNull(bluetoothBroadcastReceiver);
            ThreadUtils.checkIsOnMainThread();
            if (!bluetoothBroadcastReceiver.l) {
                StringBuilder sbU = outline.U("registering for broadcasts with actions: ");
                Set<BluetoothBroadcastAction> set = BluetoothBroadcastReceiver.j;
                sbU.append(set);
                AnimatableValueParser.b1("BluetoothBroadcastReceiver", sbU.toString());
                IntentFilter intentFilter2 = new IntentFilter();
                Iterator<T> it2 = set.iterator();
                while (it2.hasNext()) {
                    intentFilter2.addAction(((BluetoothBroadcastAction) it2.next()).getAction());
                }
                bluetoothBroadcastReceiver.n.registerReceiver(bluetoothBroadcastReceiver, intentFilter2);
                BluetoothHeadsetPrivateApi bluetoothHeadsetPrivateApi = BluetoothHeadsetPrivateApi.c;
                Lazy lazy = BluetoothHeadsetPrivateApi.a;
                if (((String) lazy.getValue()) != null) {
                    Context context = bluetoothBroadcastReceiver.n;
                    Intrinsics3.checkNotNullParameter(context, "context");
                    Intrinsics3.checkNotNullParameter(bluetoothBroadcastReceiver, "receiver");
                    try {
                        String str = (String) lazy.getValue();
                        if (str != null) {
                            context.registerReceiver(bluetoothBroadcastReceiver, new IntentFilter(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
                try {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        profileProxy = defaultAdapter.getProfileProxy(bluetoothBroadcastReceiver.n, bluetoothBroadcastReceiver, 1);
                    }
                } catch (SecurityException e) {
                    AnimatableValueParser.f1("BluetoothBroadcastReceiver", "failed to get BluetoothHeadset profile: " + e);
                }
                if (profileProxy) {
                    AnimatableValueParser.b1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy");
                } else {
                    AnimatableValueParser.c1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy failed", null);
                }
                bluetoothBroadcastReceiver.l = true;
            }
            DiscordAudioManager2 discordAudioManager2 = new DiscordAudioManager2(discordAudioManager);
            synchronized (discordAudioManager.i) {
                discordAudioManager.p = discordAudioManager2;
            }
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public final class b implements OnAudioManagerBroadcastListener {
        public b() {
        }

        @Override // b.a.q.k0.OnAudioManagerBroadcastListener
        public void a(Context context, boolean z2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(context, "context");
        }

        @Override // b.a.q.k0.OnAudioManagerBroadcastListener
        @MainThread
        public void b(Context context, ScoAudioState.b bVar) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(bVar, "scoAudioStateUpdate");
            int iOrdinal = bVar.a.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                AnimatableValueParser.b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + bVar);
                DiscordAudioManager.this.j();
                return;
            }
            AnimatableValueParser.b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + bVar);
            DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
            BluetoothScoState bluetoothScoState = discordAudioManager.o;
            discordAudioManager.k();
            int iOrdinal2 = bluetoothScoState.ordinal();
            if (iOrdinal2 == 2) {
                synchronized (DiscordAudioManager.this.i) {
                    z2 = DiscordAudioManager.this.D;
                }
                if (z2) {
                    AnimatableValueParser.b1("DiscordAudioManager", "SCO off detected directly from ON. Refreshing Bluetooth device");
                    DiscordAudioManager.this.j();
                    DiscordAudioManager.this.l();
                    return;
                }
                return;
            }
            if (iOrdinal2 != 3) {
                return;
            }
            StringBuilder sbU = outline.U("Unable to turn on SCO. Clearing Bluetooth device. mode: ");
            sbU.append(DiscordAudioManager.this.e.getMode());
            AnimatableValueParser.b1("DiscordAudioManager", sbU.toString());
            synchronized (DiscordAudioManager.this.i) {
                DiscordAudioManager discordAudioManager2 = DiscordAudioManager.this;
                List<AudioDevice> list = discordAudioManager2.r;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, false, null, null, 1));
                }
                discordAudioManager2.r = arrayList;
                discordAudioManager2.f2785s.k.onNext(arrayList);
            }
            DiscordAudioManager discordAudioManager3 = DiscordAudioManager.this;
            discordAudioManager3.a(discordAudioManager3.r);
        }

        @Override // b.a.q.k0.OnAudioManagerBroadcastListener
        public void c(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(context, "context");
        }

        @Override // b.a.q.k0.OnAudioManagerBroadcastListener
        public void d(Context context, boolean z2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(context, "context");
        }

        @Override // b.a.q.k0.OnAudioManagerBroadcastListener
        @MainThread
        public void e(Context context, WiredHeadsetState wiredHeadsetState) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(wiredHeadsetState, "wiredHeadsetState");
            AnimatableValueParser.b1("DiscordAudioManager", "[onWiredHeadsetPlug] wiredHeadsetState = " + wiredHeadsetState);
            if (Intrinsics3.areEqual(wiredHeadsetState, WiredHeadsetState.b.a)) {
                synchronized (DiscordAudioManager.this.i) {
                    DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
                    List<AudioDevice> list = discordAudioManager.r;
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    for (AudioDevice audioDevice : list) {
                        int iOrdinal = audioDevice.type.ordinal();
                        arrayList.add(iOrdinal != 3 ? iOrdinal != 4 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, DiscordAudioManager.this.h, null, null, 13) : AudioDevice.a(audioDevice, null, false, null, null, 13));
                    }
                    discordAudioManager.r = arrayList;
                    discordAudioManager.f2785s.k.onNext(arrayList);
                }
            } else if (wiredHeadsetState instanceof WiredHeadsetState.a) {
                synchronized (DiscordAudioManager.this.i) {
                    DiscordAudioManager discordAudioManager2 = DiscordAudioManager.this;
                    List<AudioDevice> list2 = discordAudioManager2.r;
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                    for (AudioDevice audioDevice2 : list2) {
                        int iOrdinal2 = audioDevice2.type.ordinal();
                        arrayList2.add(iOrdinal2 != 3 ? iOrdinal2 != 4 ? AudioDevice.a(audioDevice2, null, false, null, null, 15) : AudioDevice.a(audioDevice2, null, false, null, null, 13) : AudioDevice.a(audioDevice2, null, true, null, null, 13));
                    }
                    discordAudioManager2.r = arrayList2;
                    discordAudioManager2.f2785s.k.onNext(arrayList2);
                }
            }
            DiscordAudioManager.this.l();
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public final class c implements OnBluetoothBroadcastListener {
        public c() {
        }

        @Override // b.a.q.k0.OnBluetoothBroadcastListener
        @MainThread
        public void a(Context context, BluetoothHeadsetAudioState.b bVar) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(bVar, "audioState");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bVar.a;
            if (bluetoothHeadsetAudioState == null) {
                bluetoothHeadsetAudioState = BluetoothHeadsetAudioState.Disconnected;
            }
            BluetoothDevice bluetoothDevice = bVar.c;
            StringBuilder sb = new StringBuilder();
            sb.append("[onHeadsetAudioStateChanged] state: ");
            sb.append(bluetoothHeadsetAudioState);
            sb.append(", device: ");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
            AnimatableValueParser.b1("DiscordAudioManager", sb.toString());
            int iOrdinal = bluetoothHeadsetAudioState.ordinal();
            if (iOrdinal == 0) {
                DiscordAudioManager.this.l();
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            synchronized (DiscordAudioManager.this.i) {
                DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
                List<AudioDevice> list = discordAudioManager.r;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, true, bluetoothDevice != null ? bluetoothDevice.getAddress() : null, bluetoothDevice != null ? bluetoothDevice.getName() : null, 1));
                }
                discordAudioManager.r = arrayList;
                discordAudioManager.f2785s.k.onNext(arrayList);
            }
        }

        @Override // b.a.q.k0.OnBluetoothBroadcastListener
        @MainThread
        public void b(BluetoothDevice bluetoothDevice) {
            BluetoothHeadsetPrivateApi bluetoothHeadsetPrivateApi = BluetoothHeadsetPrivateApi.c;
            if (!(((String) BluetoothHeadsetPrivateApi.a.getValue()) != null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (bluetoothDevice != null) {
                DiscordAudioManager.this.l();
            }
        }

        @Override // b.a.q.k0.OnBluetoothBroadcastListener
        @MainThread
        public void c(BluetoothHeadset bluetoothHeadset) {
            DiscordAudioManager.this.n = bluetoothHeadset;
        }

        @Override // b.a.q.k0.OnBluetoothBroadcastListener
        @MainThread
        public void d(Context context, BluetoothProfileConnectionState.b bVar) {
            ArrayList arrayList;
            DiscordAudioManager discordAudioManager;
            DeviceTypes deviceTypes;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(bVar, "connectionState");
            BluetoothProfileConnectionState bluetoothProfileConnectionState = bVar.f2791b;
            if (bluetoothProfileConnectionState == null) {
                bluetoothProfileConnectionState = BluetoothProfileConnectionState.Disconnected;
            }
            BluetoothDevice bluetoothDevice = bVar.c;
            StringBuilder sb = new StringBuilder();
            sb.append("[onHeadsetConnectionStateChanged] state: ");
            sb.append(bluetoothProfileConnectionState);
            sb.append(", device: ");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
            AnimatableValueParser.b1("DiscordAudioManager", sb.toString());
            int iOrdinal = bluetoothProfileConnectionState.ordinal();
            if (iOrdinal == 0) {
                synchronized (DiscordAudioManager.this.i) {
                    List<AudioDevice> list = DiscordAudioManager.this.r;
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AudioDevice.a((AudioDevice) it.next(), null, false, null, null, 15));
                    }
                }
                DeviceTypes deviceTypes2 = DeviceTypes.BLUETOOTH_HEADSET;
                if (((AudioDevice) arrayList.get(deviceTypes2.getValue())).id != null) {
                    if (Intrinsics3.areEqual(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, ((AudioDevice) arrayList.get(deviceTypes2.getValue())).id)) {
                        DiscordAudioManager.this.l();
                        return;
                    }
                    return;
                }
                return;
            }
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    synchronized (DiscordAudioManager.this.i) {
                        discordAudioManager = DiscordAudioManager.this;
                        deviceTypes = discordAudioManager.t;
                    }
                    if (deviceTypes == DeviceTypes.BLUETOOTH_HEADSET) {
                        discordAudioManager.g();
                        return;
                    } else {
                        discordAudioManager.l();
                        return;
                    }
                }
                if (iOrdinal != 3) {
                    return;
                }
            }
            AnimatableValueParser.b1("DiscordAudioManager", "[onHeadsetConnectionStateChanged] " + bluetoothProfileConnectionState + "...");
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public static final class d extends Lambda implements Function0<DiscordAudioManager> {
        public static final d j = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public DiscordAudioManager invoke() {
            return new DiscordAudioManager(ApplicationProvider.INSTANCE.get());
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public static final class e extends Lambda implements Function0<AudioPermissions> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public AudioPermissions invoke() {
            return new AudioPermissions(this.$context);
        }
    }

    public DiscordAudioManager(Context context) {
        AudioDevice audioDeviceA;
        Intrinsics3.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.e = (AudioManager) systemService;
        Object systemService2 = context.getSystemService("bluetooth");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.f = (BluetoothManager) systemService2;
        this.g = LazyJVM.lazy(new e(context));
        this.h = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        this.i = this;
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        this.j = threadCurrentThread.getId();
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        this.k = contentResolver;
        this.l = new BluetoothBroadcastReceiver(context, new c());
        this.m = new AudioManagerBroadcastReceiver(context, new b());
        new Handler(Looper.getMainLooper()).post(new a());
        this.o = BluetoothScoState.INVALID;
        List<AudioDevice> listListOf = Collections2.listOf((Object[]) new AudioDevice[]{new AudioDevice(DeviceTypes.SPEAKERPHONE, false, null, null, 14), new AudioDevice(DeviceTypes.WIRED_HEADSET, false, null, null, 14), new AudioDevice(DeviceTypes.EARPIECE, false, null, null, 14), new AudioDevice(DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
        ArrayList arrayList = new ArrayList();
        for (AudioDevice audioDevice : listListOf) {
            int iOrdinal = audioDevice.type.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                audioDeviceA = null;
            } else if (iOrdinal == 2) {
                audioDeviceA = AudioDevice.a(audioDevice, null, true, null, null, 13);
            } else if (iOrdinal == 3) {
                audioDeviceA = AudioDevice.a(audioDevice, null, this.e.isWiredHeadsetOn(), null, null, 13);
            } else if (iOrdinal == 4) {
                audioDeviceA = AudioDevice.a(audioDevice, null, this.h, null, null, 13);
            } else {
                if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                audioDeviceA = AudioDevice.a(audioDevice, null, false, null, null, 15);
            }
            if (audioDeviceA != null) {
                arrayList.add(audioDeviceA);
            }
        }
        this.r = arrayList;
        this.f2785s = new SerializedSubject<>(BehaviorSubject.l0(arrayList));
        DeviceTypes deviceTypes = DeviceTypes.INVALID;
        this.t = deviceTypes;
        this.u = new SerializedSubject<>(BehaviorSubject.l0(deviceTypes));
        this.f2786x = this.e.getStreamMaxVolume(3);
        this.f2787y = new SerializedSubject<>(BehaviorSubject.l0(Integer.valueOf(this.w)));
        this.f2788z = DeviceTypes.DEFAULT;
    }

    public static final DiscordAudioManager d() {
        return (DiscordAudioManager) a.getValue();
    }

    public static final List<AudioDevice> f() {
        return Collections2.listOf((Object[]) new AudioDevice[]{new AudioDevice(DeviceTypes.SPEAKERPHONE, false, null, null, 14), new AudioDevice(DeviceTypes.WIRED_HEADSET, false, null, null, 14), new AudioDevice(DeviceTypes.EARPIECE, false, null, null, 14), new AudioDevice(DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
    }

    public final void a(List<AudioDevice> list) {
        DeviceTypes deviceTypesPrevious;
        DeviceTypes deviceTypes;
        synchronized (this.i) {
            List<DeviceTypes> list2 = c;
            ListIterator<DeviceTypes> listIterator = list2.listIterator(list2.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    deviceTypesPrevious = null;
                    break;
                } else {
                    deviceTypesPrevious = listIterator.previous();
                    if (list.get(deviceTypesPrevious.getValue()).isAvailable) {
                        break;
                    }
                }
            }
            deviceTypes = deviceTypesPrevious;
            if (deviceTypes == null) {
                deviceTypes = DeviceTypes.SPEAKERPHONE;
            }
        }
        AnimatableValueParser.b1("DiscordAudioManager", "Default device to activate: " + deviceTypes);
        b(deviceTypes);
    }

    public final void b(DeviceTypes deviceTypes) {
        boolean z2;
        synchronized (this.i) {
            z2 = !this.D;
        }
        if (z2) {
            AnimatableValueParser.f1("DiscordAudioManager", "Unable to activate audio output outside Discord-requested communication mode");
            return;
        }
        if (deviceTypes == DeviceTypes.BLUETOOTH_HEADSET) {
            j();
        } else {
            k();
        }
        boolean z3 = deviceTypes == DeviceTypes.SPEAKERPHONE;
        if (this.e.isSpeakerphoneOn() != z3) {
            this.e.setSpeakerphoneOn(z3);
        }
        synchronized (this.i) {
            this.t = deviceTypes;
            this.u.k.onNext(deviceTypes);
        }
        AnimatableValueParser.b1("DiscordAudioManager", "Activated device: " + deviceTypes);
    }

    public final void c() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != this.j) {
            throw new IllegalStateException("Method was not called from a valid thread");
        }
    }

    public final AudioPermissions e() {
        return (AudioPermissions) this.g.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        List<BluetoothDevice> listEmptyList;
        Object next;
        BluetoothDevice bluetoothDevice;
        boolean z2;
        if (!e().d) {
            AnimatableValueParser.f1("DiscordAudioManager", "refreshBluetoothHeadset() requires BLUETOOTH permission");
            return;
        }
        BluetoothHeadset bluetoothHeadset = this.n;
        if (bluetoothHeadset == null || (listEmptyList = bluetoothHeadset.getConnectedDevices()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        Iterator<T> it = listEmptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) next;
            BluetoothHeadset bluetoothHeadset2 = this.n;
            if (bluetoothHeadset2 != null ? bluetoothHeadset2.isAudioConnected(bluetoothDevice2) : false) {
                break;
            }
        }
        BluetoothDevice bluetoothDevice3 = (BluetoothDevice) next;
        BluetoothHeadset bluetoothHeadset3 = this.n;
        if (bluetoothHeadset3 != null) {
            BluetoothHeadsetPrivateApi bluetoothHeadsetPrivateApi = BluetoothHeadsetPrivateApi.c;
            Intrinsics3.checkNotNullParameter(bluetoothHeadset3, "headsetProfile");
            try {
                Method method = (Method) BluetoothHeadsetPrivateApi.f263b.getValue();
                Object objInvoke = method != null ? method.invoke(bluetoothHeadset3, new Object[0]) : null;
                if (!(objInvoke instanceof BluetoothDevice)) {
                    objInvoke = null;
                }
                bluetoothDevice = (BluetoothDevice) objInvoke;
            } catch (Throwable unused) {
            }
        } else {
            bluetoothDevice = null;
        }
        if (bluetoothDevice3 == null) {
            bluetoothDevice3 = bluetoothDevice;
        }
        if (e().d) {
            BluetoothAdapter adapter = this.f.getAdapter();
            if (adapter != null) {
                int profileConnectionState = adapter.getProfileConnectionState(1);
                if (adapter.isEnabled() && profileConnectionState == 2) {
                    z2 = true;
                }
            }
            synchronized (this.i) {
                List<AudioDevice> list = this.r;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, (this.D && this.t == DeviceTypes.BLUETOOTH_HEADSET) ? bluetoothDevice3 != null : z2, bluetoothDevice3 != null ? bluetoothDevice3.getAddress() : null, bluetoothDevice3 != null ? bluetoothDevice3.getName() : null, 1));
                }
                this.r = arrayList;
                this.f2785s.k.onNext(arrayList);
            }
            return;
        }
        AnimatableValueParser.f1("DiscordAudioManager", "hasBluetoothHeadset() requires BLUETOOTH permission");
        z2 = false;
        synchronized (this.i) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(boolean z2) {
        AudioFocusRequest audioFocusRequest;
        c();
        if (!e().f262b) {
            AnimatableValueParser.f1("DiscordAudioManager", "MODIFY_AUDIO_SETTINGS is missing. Client will run with reduced functionality");
            return;
        }
        boolean z3 = false;
        if (z2) {
            Looper looperMyLooper = Looper.myLooper();
            DiscordAudioManager3 discordAudioManager3 = new DiscordAudioManager3(this, looperMyLooper != null ? new Handler(looperMyLooper) : null);
            this.k.registerContentObserver(Settings.System.CONTENT_URI, true, discordAudioManager3);
            this.v = discordAudioManager3;
            this.A = this.e.isSpeakerphoneOn();
            this.B = this.e.isMicrophoneMute();
            this.C = this.e.isBluetoothScoOn();
            i(true);
            synchronized (this.i) {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.p;
                if (onAudioFocusChangeListener != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        AudioFocusRequest.Builder builder = new AudioFocusRequest.Builder(1);
                        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                        builder2.setUsage(2);
                        builder2.setContentType(1);
                        builder.setAcceptsDelayedFocusGain(true);
                        Looper looperMyLooper2 = Looper.myLooper();
                        Intrinsics3.checkNotNull(looperMyLooper2);
                        builder.setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(looperMyLooper2));
                        builder.setAudioAttributes(builder2.build());
                        AudioFocusRequest audioFocusRequestBuild = builder.build();
                        this.q = audioFocusRequestBuild;
                        if (this.e.requestAudioFocus(audioFocusRequestBuild) == 1) {
                            z3 = true;
                        }
                        if (z3) {
                            AnimatableValueParser.f1("DiscordAudioManager", "Unable to requestAudioFocus()");
                        } else {
                            AnimatableValueParser.b1("DiscordAudioManager", "Successful requestAudioFocus()");
                        }
                    } else {
                        if (this.e.requestAudioFocus(onAudioFocusChangeListener, 0, 1) == 1) {
                        }
                        if (z3) {
                        }
                    }
                }
            }
            l();
            return;
        }
        ContentObserver contentObserver = this.v;
        if (contentObserver != null) {
            this.k.unregisterContentObserver(contentObserver);
        }
        this.v = null;
        b(DeviceTypes.INVALID);
        synchronized (this.i) {
            this.f2788z = DeviceTypes.DEFAULT;
        }
        i(false);
        if (Build.VERSION.SDK_INT >= 26) {
            synchronized (this.i) {
                audioFocusRequest = this.q;
            }
            if (audioFocusRequest != null && this.e.abandonAudioFocusRequest(audioFocusRequest) == 1) {
                z3 = true;
            }
            if (z3) {
                AnimatableValueParser.f1("DiscordAudioManager", "Unable to releaseAudioFocus()");
            } else {
                AnimatableValueParser.b1("DiscordAudioManager", "Successful releaseAudioFocus()");
            }
        } else {
            synchronized (this.i) {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener2 = this.p;
                if (onAudioFocusChangeListener2 != null) {
                    if (this.e.abandonAudioFocus(onAudioFocusChangeListener2) == 1) {
                    }
                    if (z3) {
                    }
                }
            }
        }
        boolean z4 = this.B;
        if (this.e.isMicrophoneMute() != z4) {
            this.e.setMicrophoneMute(z4);
        }
        boolean z5 = this.A;
        if (this.e.isSpeakerphoneOn() != z5) {
            this.e.setSpeakerphoneOn(z5);
        }
        if (this.C) {
            j();
        }
    }

    public final void i(boolean z2) {
        try {
            this.e.setMode(z2 ? 3 : 0);
        } catch (SecurityException unused) {
        }
        synchronized (this.i) {
            this.D = z2;
        }
    }

    public final synchronized void j() {
        BluetoothScoState bluetoothScoState;
        BluetoothScoState bluetoothScoState2 = this.o;
        BluetoothScoState bluetoothScoState3 = BluetoothScoState.ON;
        if (bluetoothScoState2 != bluetoothScoState3 && bluetoothScoState2 != (bluetoothScoState = BluetoothScoState.TURNING_ON)) {
            if (this.e.isBluetoothScoOn()) {
                this.o = bluetoothScoState3;
            } else {
                this.o = bluetoothScoState;
                this.e.startBluetoothSco();
            }
        }
    }

    public final synchronized void k() {
        BluetoothScoState bluetoothScoState = this.o;
        if (bluetoothScoState == BluetoothScoState.ON || bluetoothScoState == BluetoothScoState.TURNING_ON) {
            if (!this.e.isBluetoothScoOn()) {
                this.o = BluetoothScoState.OFF;
            } else {
                this.o = BluetoothScoState.TURNING_OFF;
                this.e.stopBluetoothSco();
            }
        }
    }

    public final void l() {
        DeviceTypes deviceTypes;
        ArrayList arrayList;
        synchronized (this.i) {
            deviceTypes = this.f2788z;
        }
        g();
        synchronized (this.i) {
            List<AudioDevice> list = this.r;
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AudioDevice.a((AudioDevice) it.next(), null, false, null, null, 15));
            }
        }
        if (deviceTypes == DeviceTypes.DEFAULT || !arrayList.get(deviceTypes.getValue()).isAvailable) {
            a(arrayList);
        } else {
            b(deviceTypes);
        }
    }
}
