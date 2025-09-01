package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Codecs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lco/discord/media_engine/AudioEncoder;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "type", ModelAuditLogEntry.CHANGE_KEY_NAME, "freq", "pacsize", "channels", "rate", "copy", "(ILjava/lang/String;IIII)Lco/discord/media_engine/AudioEncoder;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChannels", "Ljava/lang/String;", "getName", "getPacsize", "getFreq", "getType", "getRate", "<init>", "(ILjava/lang/String;IIII)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.AudioEncoder, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class Codecs3 {
    private final int channels;
    private final int freq;
    private final String name;
    private final int pacsize;
    private final int rate;
    private final int type;

    public Codecs3(int i, String str, int i2, int i3, int i4, int i5) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.type = i;
        this.name = str;
        this.freq = i2;
        this.pacsize = i3;
        this.channels = i4;
        this.rate = i5;
    }

    public static /* synthetic */ Codecs3 copy$default(Codecs3 codecs3, int i, String str, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = codecs3.type;
        }
        if ((i6 & 2) != 0) {
            str = codecs3.name;
        }
        String str2 = str;
        if ((i6 & 4) != 0) {
            i2 = codecs3.freq;
        }
        int i7 = i2;
        if ((i6 & 8) != 0) {
            i3 = codecs3.pacsize;
        }
        int i8 = i3;
        if ((i6 & 16) != 0) {
            i4 = codecs3.channels;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = codecs3.rate;
        }
        return codecs3.copy(i, str2, i7, i8, i9, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFreq() {
        return this.freq;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPacsize() {
        return this.pacsize;
    }

    /* renamed from: component5, reason: from getter */
    public final int getChannels() {
        return this.channels;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRate() {
        return this.rate;
    }

    public final Codecs3 copy(int type, String name, int freq, int pacsize, int channels, int rate) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new Codecs3(type, name, freq, pacsize, channels, rate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Codecs3)) {
            return false;
        }
        Codecs3 codecs3 = (Codecs3) other;
        return this.type == codecs3.type && Intrinsics3.areEqual(this.name, codecs3.name) && this.freq == codecs3.freq && this.pacsize == codecs3.pacsize && this.channels == codecs3.channels && this.rate == codecs3.rate;
    }

    public final int getChannels() {
        return this.channels;
    }

    public final int getFreq() {
        return this.freq;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPacsize() {
        return this.pacsize;
    }

    public final int getRate() {
        return this.rate;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.name;
        return ((((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.freq) * 31) + this.pacsize) * 31) + this.channels) * 31) + this.rate;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AudioEncoder(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", freq=");
        sbU.append(this.freq);
        sbU.append(", pacsize=");
        sbU.append(this.pacsize);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", rate=");
        return outline.B(sbU, this.rate, ")");
    }
}
