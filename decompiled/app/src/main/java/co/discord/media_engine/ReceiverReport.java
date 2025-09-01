package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\u000f\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00060\tj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ6\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\f\b\u0002\u0010\u000e\u001a\u00060\u0005j\u0002`\u00062\f\b\u0002\u0010\u000f\u001a\u00060\tj\u0002`\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\fJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u000e\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001d\u0010\u000f\u001a\u00060\tj\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\f¨\u0006 "}, d2 = {"Lco/discord/media_engine/ReceiverReport;", "", "", "component1", "()Ljava/lang/String;", "", "Lco/discord/media_engine/I64;", "component2", "()J", "", "Lco/discord/media_engine/U8;", "component3", "()I", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_BITRATE, "fractionLost", "copy", "(Ljava/lang/String;JI)Lco/discord/media_engine/ReceiverReport;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getBitrate", "Ljava/lang/String;", "getId", "I", "getFractionLost", "<init>", "(Ljava/lang/String;JI)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ReceiverReport {
    private final long bitrate;
    private final int fractionLost;
    private final String id;

    public ReceiverReport(String str, long j, int i) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.id = str;
        this.bitrate = j;
        this.fractionLost = i;
    }

    public static /* synthetic */ ReceiverReport copy$default(ReceiverReport receiverReport, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = receiverReport.id;
        }
        if ((i2 & 2) != 0) {
            j = receiverReport.bitrate;
        }
        if ((i2 & 4) != 0) {
            i = receiverReport.fractionLost;
        }
        return receiverReport.copy(str, j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFractionLost() {
        return this.fractionLost;
    }

    public final ReceiverReport copy(String id2, long bitrate, int fractionLost) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return new ReceiverReport(id2, bitrate, fractionLost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiverReport)) {
            return false;
        }
        ReceiverReport receiverReport = (ReceiverReport) other;
        return Intrinsics3.areEqual(this.id, receiverReport.id) && this.bitrate == receiverReport.bitrate && this.fractionLost == receiverReport.fractionLost;
    }

    public final long getBitrate() {
        return this.bitrate;
    }

    public final int getFractionLost() {
        return this.fractionLost;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        return ((b.a(this.bitrate) + ((str != null ? str.hashCode() : 0) * 31)) * 31) + this.fractionLost;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReceiverReport(id=");
        sbU.append(this.id);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", fractionLost=");
        return outline.B(sbU, this.fractionLost, ")");
    }
}
