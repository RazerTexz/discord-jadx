package com.discord.rtcconnection.enums;

import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ThermalStatus.kt */
@RequiresApi(29)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/rtcconnection/enums/ThermalStatus;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "None", "Light", "Moderate", "Severe", "Critical", "Emergency", "Shutdown", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum ThermalStatus {
    None(0),
    Light(1),
    Moderate(2),
    Severe(3),
    Critical(4),
    Emergency(5),
    Shutdown(6);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: ThermalStatus.kt */
    /* renamed from: com.discord.rtcconnection.enums.ThermalStatus$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ThermalStatus a(int i) {
            ThermalStatus thermalStatus;
            ThermalStatus[] thermalStatusArrValues = ThermalStatus.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 7) {
                    thermalStatus = null;
                    break;
                }
                thermalStatus = thermalStatusArrValues[i2];
                if (thermalStatus.getValue() == i) {
                    break;
                }
                i2++;
            }
            return thermalStatus != null ? thermalStatus : ThermalStatus.None;
        }
    }

    ThermalStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
