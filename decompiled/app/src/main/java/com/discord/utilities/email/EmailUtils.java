package com.discord.utilities.email;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: EmailUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/utilities/email/EmailUtils;", "", "", "input", "", "isEmailLike", "(Ljava/lang/String;)Z", "Lkotlin/text/Regex;", "EMAIL_REGEX", "Lkotlin/text/Regex;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmailUtils {
    public static final EmailUtils INSTANCE = new EmailUtils();
    private static final Regex EMAIL_REGEX = new Regex("/^([\\w-+]+(?:\\.[\\w-+]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,63}(?:\\.[a-z]{2})?)$/i");

    private EmailUtils() {
    }

    public final boolean isEmailLike(String input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        return EMAIL_REGEX.matches(input);
    }
}
