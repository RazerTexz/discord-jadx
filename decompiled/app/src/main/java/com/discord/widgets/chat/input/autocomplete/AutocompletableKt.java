package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.Intrinsics3;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "lower", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "", "getSortIndex", "(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)I", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AutocompletableKt {
    public static final /* synthetic */ String access$lower(String str) {
        return lower(str);
    }

    public static final int getSortIndex(Autocompletable autocompletable) {
        Intrinsics3.checkNotNullParameter(autocompletable, "$this$getSortIndex");
        if (autocompletable instanceof UserAutocompletable) {
            return 0;
        }
        if (autocompletable instanceof RoleAutocompletable) {
            return 1;
        }
        if (autocompletable instanceof GlobalRoleAutocompletable) {
            return 2;
        }
        if (autocompletable instanceof ChannelAutocompletable) {
            return 3;
        }
        if (autocompletable instanceof EmojiAutocompletable) {
            return 4;
        }
        if (autocompletable instanceof ApplicationCommandAutocompletable) {
            return 5;
        }
        if (autocompletable instanceof ApplicationCommandChoiceAutocompletable) {
            return 6;
        }
        if (autocompletable instanceof ApplicationCommandLoadingPlaceholder) {
            return 7;
        }
        if (autocompletable instanceof ApplicationPlaceholder) {
            return 8;
        }
        if (autocompletable instanceof EmojiUpsellPlaceholder) {
            return 9;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String lower(String str) {
        Locale locale = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
