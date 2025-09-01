package com.discord.utilities.buildutils;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: BuildUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/buildutils/BuildUtils;", "", "", "versionName", "", "isValidBuildVersionName", "(Ljava/lang/String;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BuildUtils {
    public static final BuildUtils INSTANCE = new BuildUtils();

    private BuildUtils() {
    }

    public final boolean isValidBuildVersionName(String versionName) {
        Intrinsics3.checkNotNullParameter(versionName, "versionName");
        return new Regex("^\\d+[.]\\d+ - (Dev|Alpha|Beta|Stable)$").matches(versionName);
    }
}
