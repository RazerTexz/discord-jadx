package com.discord.p000native.engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VideoInputDeviceDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/native/engine/VideoInputDeviceDescription;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/discord/native/engine/VideoInputDeviceFacing;", "component3", "()Lcom/discord/native/engine/VideoInputDeviceFacing;", ModelAuditLogEntry.CHANGE_KEY_NAME, "guid", "facing", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/native/engine/VideoInputDeviceFacing;)Lcom/discord/native/engine/VideoInputDeviceDescription;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/native/engine/VideoInputDeviceFacing;", "getFacing", "Ljava/lang/String;", "getName", "getGuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/native/engine/VideoInputDeviceFacing;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class VideoInputDeviceDescription {
    private final VideoInputDeviceFacing facing;
    private final String guid;
    private final String name;

    public VideoInputDeviceDescription(String str, String str2, VideoInputDeviceFacing videoInputDeviceFacing) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "guid");
        Intrinsics3.checkNotNullParameter(videoInputDeviceFacing, "facing");
        this.name = str;
        this.guid = str2;
        this.facing = videoInputDeviceFacing;
    }

    public static /* synthetic */ VideoInputDeviceDescription copy$default(VideoInputDeviceDescription videoInputDeviceDescription, String str, String str2, VideoInputDeviceFacing videoInputDeviceFacing, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoInputDeviceDescription.name;
        }
        if ((i & 2) != 0) {
            str2 = videoInputDeviceDescription.guid;
        }
        if ((i & 4) != 0) {
            videoInputDeviceFacing = videoInputDeviceDescription.facing;
        }
        return videoInputDeviceDescription.copy(str, str2, videoInputDeviceFacing);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGuid() {
        return this.guid;
    }

    /* renamed from: component3, reason: from getter */
    public final VideoInputDeviceFacing getFacing() {
        return this.facing;
    }

    public final VideoInputDeviceDescription copy(String name, String guid, VideoInputDeviceFacing facing) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guid, "guid");
        Intrinsics3.checkNotNullParameter(facing, "facing");
        return new VideoInputDeviceDescription(name, guid, facing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoInputDeviceDescription)) {
            return false;
        }
        VideoInputDeviceDescription videoInputDeviceDescription = (VideoInputDeviceDescription) other;
        return Intrinsics3.areEqual(this.name, videoInputDeviceDescription.name) && Intrinsics3.areEqual(this.guid, videoInputDeviceDescription.guid) && Intrinsics3.areEqual(this.facing, videoInputDeviceDescription.facing);
    }

    public final VideoInputDeviceFacing getFacing() {
        return this.facing;
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
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        VideoInputDeviceFacing videoInputDeviceFacing = this.facing;
        return iHashCode2 + (videoInputDeviceFacing != null ? videoInputDeviceFacing.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("VideoInputDeviceDescription(name=");
        sbU.append(this.name);
        sbU.append(", guid=");
        sbU.append(this.guid);
        sbU.append(", facing=");
        sbU.append(this.facing);
        sbU.append(")");
        return sbU.toString();
    }
}
