package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public class ApiException extends Exception {

    @RecentlyNonNull
    @Deprecated
    public final Status mStatus;

    public ApiException(@RecentlyNonNull Status status) {
        int i = status.p;
        String str = status.q;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        super(sb.toString());
        this.mStatus = status;
    }
}
