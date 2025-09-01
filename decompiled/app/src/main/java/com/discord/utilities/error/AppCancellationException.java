package com.discord.utilities.error;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* compiled from: AppCancellationException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005¨\u0006\""}, d2 = {"Lcom/discord/utilities/error/AppCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Throwable;", "Lcom/discord/utilities/error/Error;", "component3", "()Lcom/discord/utilities/error/Error;", "message", "cause", "error", "copy", "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/discord/utilities/error/Error;)Lcom/discord/utilities/error/AppCancellationException;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "Ljava/lang/Throwable;", "getCause", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AppCancellationException extends CancellationException {
    private final Throwable cause;
    private final Error error;
    private final String message;

    public AppCancellationException(String str, Throwable th, Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        this.message = str;
        this.cause = th;
        this.error = error;
    }

    public static /* synthetic */ AppCancellationException copy$default(AppCancellationException appCancellationException, String str, Throwable th, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appCancellationException.getMessage();
        }
        if ((i & 2) != 0) {
            th = appCancellationException.getCause();
        }
        if ((i & 4) != 0) {
            error = appCancellationException.error;
        }
        return appCancellationException.copy(str, th, error);
    }

    public final String component1() {
        return getMessage();
    }

    public final Throwable component2() {
        return getCause();
    }

    /* renamed from: component3, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final AppCancellationException copy(String message, Throwable cause, Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        return new AppCancellationException(message, cause, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppCancellationException)) {
            return false;
        }
        AppCancellationException appCancellationException = (AppCancellationException) other;
        return Intrinsics3.areEqual(getMessage(), appCancellationException.getMessage()) && Intrinsics3.areEqual(getCause(), appCancellationException.getCause()) && Intrinsics3.areEqual(this.error, appCancellationException.error);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public final Error getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String message = getMessage();
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        Throwable cause = getCause();
        int iHashCode2 = (iHashCode + (cause != null ? cause.hashCode() : 0)) * 31;
        Error error = this.error;
        return iHashCode2 + (error != null ? error.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbU = outline.U("AppCancellationException(message=");
        sbU.append(getMessage());
        sbU.append(", cause=");
        sbU.append(getCause());
        sbU.append(", error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
