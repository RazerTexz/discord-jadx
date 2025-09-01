package co.discord.media_engine;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: Codecs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b$\u0010\u0004R%\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\fR\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e¨\u0006+"}, d2 = {"Lco/discord/media_engine/AudioDecoder;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()Ljava/util/Map;", "type", ModelAuditLogEntry.CHANGE_KEY_NAME, "freq", "channels", "params", "copy", "(ILjava/lang/String;IILjava/util/Map;)Lco/discord/media_engine/AudioDecoder;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "paramsKeys", "[Ljava/lang/String;", "getParamsKeys", "()[Ljava/lang/String;", "I", "getChannels", "getFreq", "Ljava/lang/String;", "getName", "getType", "Ljava/util/Map;", "getParams", "paramsValues", "getParamsValues", "<init>", "(ILjava/lang/String;IILjava/util/Map;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.AudioDecoder, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class Codecs2 {
    private final int channels;
    private final int freq;
    private final String name;
    private final Map<String, String> params;
    private final String[] paramsKeys;
    private final String[] paramsValues;
    private final int type;

    public Codecs2(int i, String str, int i2, int i3, Map<String, String> map) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(map, "params");
        this.type = i;
        this.name = str;
        this.freq = i2;
        this.channels = i3;
        this.params = map;
        Object[] array = map.keySet().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.paramsKeys = (String[]) array;
        Object[] array2 = map.values().toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this.paramsValues = (String[]) array2;
    }

    public static /* synthetic */ Codecs2 copy$default(Codecs2 codecs2, int i, String str, int i2, int i3, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = codecs2.type;
        }
        if ((i4 & 2) != 0) {
            str = codecs2.name;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = codecs2.freq;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = codecs2.channels;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            map = codecs2.params;
        }
        return codecs2.copy(i, str2, i5, i6, map);
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
    public final int getChannels() {
        return this.channels;
    }

    public final Map<String, String> component5() {
        return this.params;
    }

    public final Codecs2 copy(int type, String name, int freq, int channels, Map<String, String> params) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(params, "params");
        return new Codecs2(type, name, freq, channels, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Codecs2)) {
            return false;
        }
        Codecs2 codecs2 = (Codecs2) other;
        return this.type == codecs2.type && Intrinsics3.areEqual(this.name, codecs2.name) && this.freq == codecs2.freq && this.channels == codecs2.channels && Intrinsics3.areEqual(this.params, codecs2.params);
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

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String[] getParamsKeys() {
        return this.paramsKeys;
    }

    public final String[] getParamsValues() {
        return this.paramsValues;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.name;
        int iHashCode = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.freq) * 31) + this.channels) * 31;
        Map<String, String> map = this.params;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AudioDecoder(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", freq=");
        sbU.append(this.freq);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", params=");
        return outline.M(sbU, this.params, ")");
    }
}
