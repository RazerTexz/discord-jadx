package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BluetoothProfileConnectionState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/rtcconnection/enums/BluetoothProfileConnectionState;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "b", "Disconnected", "Connecting", "Connected", "Disconnecting", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum BluetoothProfileConnectionState {
    Disconnected(0),
    Connecting(1),
    Connected(2),
    Disconnecting(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: BluetoothProfileConnectionState.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothProfileConnectionState$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BluetoothProfileConnectionState a(int i) {
            BluetoothProfileConnectionState[] bluetoothProfileConnectionStateArrValues = BluetoothProfileConnectionState.values();
            for (int i2 = 0; i2 < 4; i2++) {
                BluetoothProfileConnectionState bluetoothProfileConnectionState = bluetoothProfileConnectionStateArrValues[i2];
                if (bluetoothProfileConnectionState.getValue() == i) {
                    return bluetoothProfileConnectionState;
                }
            }
            return null;
        }

        public final b b(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "intent");
            if (!Intrinsics3.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Integer numX0 = AnimatableValueParser.x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothProfileConnectionState bluetoothProfileConnectionStateA = numX0 != null ? BluetoothProfileConnectionState.INSTANCE.a(numX0.intValue()) : null;
            Integer numX02 = AnimatableValueParser.x0(intent, "android.bluetooth.profile.extra.STATE");
            return new b(bluetoothProfileConnectionStateA, numX02 != null ? BluetoothProfileConnectionState.INSTANCE.a(numX02.intValue()) : null, (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
        }
    }

    /* compiled from: BluetoothProfileConnectionState.kt */
    public static final class b {
        public final BluetoothProfileConnectionState a;

        /* renamed from: b, reason: collision with root package name */
        public final BluetoothProfileConnectionState f2791b;
        public final BluetoothDevice c;

        public b(BluetoothProfileConnectionState bluetoothProfileConnectionState, BluetoothProfileConnectionState bluetoothProfileConnectionState2, BluetoothDevice bluetoothDevice) {
            this.a = bluetoothProfileConnectionState;
            this.f2791b = bluetoothProfileConnectionState2;
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
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f2791b, bVar.f2791b) && Intrinsics3.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            BluetoothProfileConnectionState bluetoothProfileConnectionState = this.a;
            int iHashCode = (bluetoothProfileConnectionState != null ? bluetoothProfileConnectionState.hashCode() : 0) * 31;
            BluetoothProfileConnectionState bluetoothProfileConnectionState2 = this.f2791b;
            int iHashCode2 = (iHashCode + (bluetoothProfileConnectionState2 != null ? bluetoothProfileConnectionState2.hashCode() : 0)) * 31;
            BluetoothDevice bluetoothDevice = this.c;
            return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Update(previous=");
            sbU.append(this.a);
            sbU.append(", current=");
            sbU.append(this.f2791b);
            sbU.append(", device=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    BluetoothProfileConnectionState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
