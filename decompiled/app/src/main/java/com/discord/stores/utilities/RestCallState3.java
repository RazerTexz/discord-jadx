package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RestCallState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/utilities/Failure;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/stores/utilities/Failure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.utilities.Failure, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class RestCallState3<T> extends RestCallState<T> {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestCallState3(Error error) {
        super(null);
        Intrinsics3.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ RestCallState3 copy$default(RestCallState3 restCallState3, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = restCallState3.error;
        }
        return restCallState3.copy(error);
    }

    /* renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final RestCallState3<T> copy(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        return new RestCallState3<>(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestCallState3) && Intrinsics3.areEqual(this.error, ((RestCallState3) other).error);
        }
        return true;
    }

    public final Error getError() {
        return this.error;
    }

    public int hashCode() {
        Error error = this.error;
        if (error != null) {
            return error.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Failure(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
