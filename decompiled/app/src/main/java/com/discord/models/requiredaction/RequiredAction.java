package com.discord.models.requiredaction;

import d0.z.d.Intrinsics3;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RequiredAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/models/requiredaction/RequiredAction;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "AGREEMENTS", "TOS_UPDATE_ACKNOWLEDGMENT", "REQUIRE_VERIFIED_EMAIL", "REQUIRE_VERIFIED_PHONE", "REQUIRE_CAPTCHA", "NONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum RequiredAction {
    AGREEMENTS,
    TOS_UPDATE_ACKNOWLEDGMENT,
    REQUIRE_VERIFIED_EMAIL,
    REQUIRE_VERIFIED_PHONE,
    REQUIRE_CAPTCHA,
    NONE;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RequiredAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/requiredaction/RequiredAction$Companion;", "", "", "requiredAction", "Lcom/discord/models/requiredaction/RequiredAction;", "fromApiString", "(Ljava/lang/String;)Lcom/discord/models/requiredaction/RequiredAction;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final RequiredAction fromApiString(String requiredAction) {
            if (requiredAction != null) {
                try {
                    Locale locale = Locale.ROOT;
                    Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                    String upperCase = requiredAction.toUpperCase(locale);
                    Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    RequiredAction requiredActionValueOf = RequiredAction.valueOf(upperCase);
                    if (requiredActionValueOf != null) {
                        return requiredActionValueOf;
                    }
                } catch (IllegalArgumentException unused) {
                    return RequiredAction.NONE;
                } catch (NullPointerException unused2) {
                    return RequiredAction.NONE;
                }
            }
            return RequiredAction.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
