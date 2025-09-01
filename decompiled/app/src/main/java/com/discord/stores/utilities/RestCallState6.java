package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RestCallState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/utilities/Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/stores/utilities/RestCallState;", "invoke", "()Ljava/lang/Object;", "component1", "response", "copy", "(Ljava/lang/Object;)Lcom/discord/stores/utilities/Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getResponse", "<init>", "(Ljava/lang/Object;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.utilities.Success, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class RestCallState6<T> extends RestCallState<T> {
    private final T response;

    public RestCallState6(T t) {
        super(null);
        this.response = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestCallState6 copy$default(RestCallState6 restCallState6, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = restCallState6.response;
        }
        return restCallState6.copy(obj);
    }

    public final T component1() {
        return this.response;
    }

    public final RestCallState6<T> copy(T response) {
        return new RestCallState6<>(response);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestCallState6) && Intrinsics3.areEqual(this.response, ((RestCallState6) other).response);
        }
        return true;
    }

    public final T getResponse() {
        return this.response;
    }

    public int hashCode() {
        T t = this.response;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    @Override // com.discord.stores.utilities.RestCallState
    public T invoke() {
        return this.response;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Success(response=");
        sbU.append(this.response);
        sbU.append(")");
        return sbU.toString();
    }
}
