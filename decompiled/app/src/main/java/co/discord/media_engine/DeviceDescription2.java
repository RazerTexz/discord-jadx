package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DeviceDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lco/discord/media_engine/AudioOutputDeviceDescription;", "", "", "component1", "()Ljava/lang/String;", "component2", ModelAuditLogEntry.CHANGE_KEY_NAME, "guid", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lco/discord/media_engine/AudioOutputDeviceDescription;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuid", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.AudioOutputDeviceDescription, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class DeviceDescription2 {
    private final String guid;
    private final String name;

    public DeviceDescription2(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "guid");
        this.name = str;
        this.guid = str2;
    }

    public static /* synthetic */ DeviceDescription2 copy$default(DeviceDescription2 deviceDescription2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceDescription2.name;
        }
        if ((i & 2) != 0) {
            str2 = deviceDescription2.guid;
        }
        return deviceDescription2.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGuid() {
        return this.guid;
    }

    public final DeviceDescription2 copy(String name, String guid) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guid, "guid");
        return new DeviceDescription2(name, guid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceDescription2)) {
            return false;
        }
        DeviceDescription2 deviceDescription2 = (DeviceDescription2) other;
        return Intrinsics3.areEqual(this.name, deviceDescription2.name) && Intrinsics3.areEqual(this.guid, deviceDescription2.guid);
    }

    public final String getGuid() {
        return this.guid;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.guid;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AudioOutputDeviceDescription(name=");
        sbU.append(this.name);
        sbU.append(", guid=");
        return outline.J(sbU, this.guid, ")");
    }
}
