package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SingleTypePayload.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u000b\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/mg_recycler/SingleTypePayload;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "component1", "()Ljava/lang/Object;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "data", "key", "type", "copy", "(Ljava/lang/Object;Ljava/lang/String;I)Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getType", "Ljava/lang/Object;", "getData", "Ljava/lang/String;", "getKey", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class SingleTypePayload<T> implements MGRecyclerDataPayload {
    private final T data;
    private final String key;
    private final int type;

    public SingleTypePayload(T t, String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "key");
        this.data = t;
        this.key = str;
        this.type = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleTypePayload copy$default(SingleTypePayload singleTypePayload, Object obj, String str, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = singleTypePayload.data;
        }
        if ((i2 & 2) != 0) {
            str = singleTypePayload.getKey();
        }
        if ((i2 & 4) != 0) {
            i = singleTypePayload.getType();
        }
        return singleTypePayload.copy(obj, str, i);
    }

    public final T component1() {
        return this.data;
    }

    public final String component2() {
        return getKey();
    }

    public final int component3() {
        return getType();
    }

    public final SingleTypePayload<T> copy(T data, String key, int type) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return new SingleTypePayload<>(data, key, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleTypePayload)) {
            return false;
        }
        SingleTypePayload singleTypePayload = (SingleTypePayload) other;
        return Intrinsics3.areEqual(this.data, singleTypePayload.data) && Intrinsics3.areEqual(getKey(), singleTypePayload.getKey()) && getType() == singleTypePayload.getType();
    }

    public final T getData() {
        return this.data;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        T t = this.data;
        int iHashCode = (t != null ? t.hashCode() : 0) * 31;
        String key = getKey();
        return getType() + ((iHashCode + (key != null ? key.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("SingleTypePayload(data=");
        sbU.append(this.data);
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ SingleTypePayload(Object obj, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, (i2 & 4) != 0 ? 0 : i);
    }
}
