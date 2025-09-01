package co.discord.media_engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: EncryptionSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lco/discord/media_engine/EncryptionSettings;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[I", "mode", "secretKey", "copy", "(Ljava/lang/String;[I)Lco/discord/media_engine/EncryptionSettings;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[I", "getSecretKey", "Ljava/lang/String;", "getMode", "<init>", "(Ljava/lang/String;[I)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EncryptionSettings {
    private final String mode;
    private final int[] secretKey;

    public EncryptionSettings(String str, int[] iArr) {
        Intrinsics3.checkNotNullParameter(str, "mode");
        Intrinsics3.checkNotNullParameter(iArr, "secretKey");
        this.mode = str;
        this.secretKey = iArr;
    }

    public static /* synthetic */ EncryptionSettings copy$default(EncryptionSettings encryptionSettings, String str, int[] iArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = encryptionSettings.mode;
        }
        if ((i & 2) != 0) {
            iArr = encryptionSettings.secretKey;
        }
        return encryptionSettings.copy(str, iArr);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component2, reason: from getter */
    public final int[] getSecretKey() {
        return this.secretKey;
    }

    public final EncryptionSettings copy(String mode, int[] secretKey) {
        Intrinsics3.checkNotNullParameter(mode, "mode");
        Intrinsics3.checkNotNullParameter(secretKey, "secretKey");
        return new EncryptionSettings(mode, secretKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptionSettings)) {
            return false;
        }
        EncryptionSettings encryptionSettings = (EncryptionSettings) other;
        return Intrinsics3.areEqual(this.mode, encryptionSettings.mode) && Intrinsics3.areEqual(this.secretKey, encryptionSettings.secretKey);
    }

    public final String getMode() {
        return this.mode;
    }

    public final int[] getSecretKey() {
        return this.secretKey;
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        int[] iArr = this.secretKey;
        return iHashCode + (iArr != null ? Arrays.hashCode(iArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EncryptionSettings(mode=");
        sbU.append(this.mode);
        sbU.append(", secretKey=");
        sbU.append(Arrays.toString(this.secretKey));
        sbU.append(")");
        return sbU.toString();
    }
}
