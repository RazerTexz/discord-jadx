package com.discord.utilities.intent;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: IntentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Intent;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "getLongExtraOrNull", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/Long;", "default", "getStringExtraOrDefault", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class IntentUtilsKt {
    public static final Long getLongExtraOrNull(Intent intent, String str) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getLongExtraOrNull");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        long longExtra = intent.getLongExtra(str, RecyclerView.FOREVER_NS);
        if (longExtra != RecyclerView.FOREVER_NS) {
            return Long.valueOf(longExtra);
        }
        return null;
    }

    public static final String getStringExtraOrDefault(Intent intent, String str, String str2) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getStringExtraOrDefault");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "default");
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            str2 = stringExtra;
        }
        Intrinsics3.checkNotNullExpressionValue(str2, "getStringExtra(name) ?: default");
        return str2;
    }

    public static /* synthetic */ String getStringExtraOrDefault$default(Intent intent, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getStringExtraOrDefault(intent, str, str2);
    }
}
