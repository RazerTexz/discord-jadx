package com.discord.rtcconnection.enums;

import android.annotation.SuppressLint;
import d0.t.Sets5;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AudioDeviceInfoType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\b\u0087\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006*"}, d2 = {"Lcom/discord/rtcconnection/enums/AudioDeviceInfoType;", "", "", "toString", "()Ljava/lang/String;", "", "isOutputType", "()Z", "", "value", "I", "getValue", "()I", "isInputType", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "BuiltinEarpiece", "BuiltinSpeaker", "WiredHeadset", "WiredHeadphones", "BluetoothSco", "BluetoothA2dp", "Hdmi", "Dock", "UsbAccessory", "UsbDevice", "Telephony", "LineAnalog", "HdmiArc", "LineDigital", "Fm", "AuxLine", "Ip", "BuiltinMic", "FmTuner", "TvTuner", "Bus", "UsbHeadset", "HearingAid", "Unknown", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public enum AudioDeviceInfoType {
    BuiltinEarpiece(1),
    BuiltinSpeaker(2),
    WiredHeadset(3),
    WiredHeadphones(4),
    BluetoothSco(7),
    BluetoothA2dp(8),
    Hdmi(9),
    Dock(13),
    UsbAccessory(12),
    UsbDevice(11),
    Telephony(18),
    LineAnalog(5),
    HdmiArc(10),
    LineDigital(6),
    Fm(14),
    AuxLine(19),
    Ip(20),
    BuiltinMic(15),
    FmTuner(16),
    TvTuner(17),
    Bus(21),
    UsbHeadset(22),
    HearingAid(23),
    Unknown(Integer.MIN_VALUE);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<AudioDeviceInfoType> supportedOutputTypes;
    private final int value;

    /* compiled from: AudioDeviceInfoType.kt */
    /* renamed from: com.discord.rtcconnection.enums.AudioDeviceInfoType$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        AudioDeviceInfoType audioDeviceInfoType = BuiltinEarpiece;
        AudioDeviceInfoType audioDeviceInfoType2 = BuiltinSpeaker;
        AudioDeviceInfoType audioDeviceInfoType3 = WiredHeadset;
        AudioDeviceInfoType audioDeviceInfoType4 = WiredHeadphones;
        AudioDeviceInfoType audioDeviceInfoType5 = BluetoothSco;
        AudioDeviceInfoType audioDeviceInfoType6 = UsbAccessory;
        AudioDeviceInfoType audioDeviceInfoType7 = UsbDevice;
        AudioDeviceInfoType audioDeviceInfoType8 = UsbHeadset;
        INSTANCE = new Companion(null);
        supportedOutputTypes = Sets5.setOf((Object[]) new AudioDeviceInfoType[]{audioDeviceInfoType, audioDeviceInfoType2, audioDeviceInfoType5, audioDeviceInfoType3, audioDeviceInfoType4, audioDeviceInfoType6, audioDeviceInfoType7, audioDeviceInfoType8});
    }

    AudioDeviceInfoType(int i) {
        this.value = i;
    }

    public static final /* synthetic */ Set access$getSupportedOutputTypes$cp() {
        return supportedOutputTypes;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean isInputType() {
        Companion companion = INSTANCE;
        int i = this.value;
        Objects.requireNonNull(companion);
        switch (i) {
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
                return true;
            case 4:
            case 10:
            case 14:
            case 19:
            default:
                return false;
        }
    }

    public final boolean isOutputType() {
        Companion companion = INSTANCE;
        int i = this.value;
        Objects.requireNonNull(companion);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return true;
            case 15:
            case 16:
            case 17:
            default:
                return false;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + "(value=" + this.value + ", isInputType=" + isInputType() + ", isOutputType=" + isOutputType() + ')';
    }
}
