package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BluetoothHeadsetAudioState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/rtcconnection/enums/BluetoothHeadsetAudioState;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "b", "Disconnected", "Connecting", "Connected", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum BluetoothHeadsetAudioState {
    Disconnected(10),
    Connecting(11),
    Connected(12);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: BluetoothHeadsetAudioState.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BluetoothHeadsetAudioState a(int i) {
            BluetoothHeadsetAudioState[] bluetoothHeadsetAudioStateArrValues = BluetoothHeadsetAudioState.values();
            for (int i2 = 0; i2 < 3; i2++) {
                BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bluetoothHeadsetAudioStateArrValues[i2];
                if (bluetoothHeadsetAudioState.getValue() == i) {
                    return bluetoothHeadsetAudioState;
                }
            }
            return null;
        }

        public final b b(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "intent");
            if (!Intrinsics3.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Intrinsics3.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Integer numX0 = AnimatableValueParser.x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioStateA = numX0 != null ? BluetoothHeadsetAudioState.INSTANCE.a(numX0.intValue()) : null;
            Integer numX02 = AnimatableValueParser.x0(intent, "android.bluetooth.profile.extra.STATE");
            return new b(numX02 != null ? BluetoothHeadsetAudioState.INSTANCE.a(numX02.intValue()) : null, bluetoothHeadsetAudioStateA, bluetoothDevice);
        }
    }

    /* compiled from: BluetoothHeadsetAudioState.kt */
    public static final class b {
        public final BluetoothHeadsetAudioState a;

        /* renamed from: b, reason: collision with root package name */
        public final BluetoothHeadsetAudioState f2790b;
        public final BluetoothDevice c;

        public b(BluetoothHeadsetAudioState bluetoothHeadsetAudioState, BluetoothHeadsetAudioState bluetoothHeadsetAudioState2, BluetoothDevice bluetoothDevice) {
            this.a = bluetoothHeadsetAudioState;
            this.f2790b = bluetoothHeadsetAudioState2;
            this.c = bluetoothDevice;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f2790b, bVar.f2790b) && Intrinsics3.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = this.a;
            int iHashCode = (bluetoothHeadsetAudioState != null ? bluetoothHeadsetAudioState.hashCode() : 0) * 31;
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState2 = this.f2790b;
            int iHashCode2 = (iHashCode + (bluetoothHeadsetAudioState2 != null ? bluetoothHeadsetAudioState2.hashCode() : 0)) * 31;
            BluetoothDevice bluetoothDevice = this.c;
            return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Update(current=");
            sbU.append(this.a);
            sbU.append(", previous=");
            sbU.append(this.f2790b);
            sbU.append(", device=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    BluetoothHeadsetAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
