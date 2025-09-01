package com.discord.stores;

import com.discord.api.user.UserSurvey2;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: StoreUserSurvey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "", "IMPLEMENTED_GUILD_REQUIREMENTS", "Ljava/util/Set;", "getIMPLEMENTED_GUILD_REQUIREMENTS", "()Ljava/util/Set;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreUserSurveyKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUserSurvey2 {
    private static final Set<String> IMPLEMENTED_GUILD_REQUIREMENTS;

    static {
        UserSurvey2[] userSurvey2ArrValues = UserSurvey2.values();
        ArrayList arrayList = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            arrayList.add(userSurvey2ArrValues[i].getValue());
        }
        IMPLEMENTED_GUILD_REQUIREMENTS = _Collections.toSet(arrayList);
    }

    public static final Set<String> getIMPLEMENTED_GUILD_REQUIREMENTS() {
        return IMPLEMENTED_GUILD_REQUIREMENTS;
    }
}
