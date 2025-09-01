package com.discord.widgets.chat.input;

import d0.g0.CharJVM;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: MentionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0005\u001a+\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u000b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"\u0016\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e\"\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "content", "", "cursorPosition", "Lkotlin/Pair;", "", "getSelectedToken", "(Ljava/lang/CharSequence;I)Lkotlin/Pair;", "", "char", "endPosition", "reverseIndexOf", "(Ljava/lang/CharSequence;CI)I", "SLASH_CHAR", "C", "CHANNELS_CHAR", "MENTIONS_CHAR", "EMOJIS_AND_STICKERS_CHAR", "", "DEFAULT_LEADING_IDENTIFIERS", "Ljava/util/Set;", "getDEFAULT_LEADING_IDENTIFIERS", "()Ljava/util/Set;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.MentionUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class MentionUtils {
    public static final char MENTIONS_CHAR = '@';
    public static final char EMOJIS_AND_STICKERS_CHAR = ':';
    public static final char CHANNELS_CHAR = '#';
    public static final char SLASH_CHAR = '/';
    private static final Set<Character> DEFAULT_LEADING_IDENTIFIERS = Sets5.hashSetOf(Character.valueOf(MENTIONS_CHAR), Character.valueOf(EMOJIS_AND_STICKERS_CHAR), Character.valueOf(CHANNELS_CHAR), Character.valueOf(SLASH_CHAR));

    public static final Set<Character> getDEFAULT_LEADING_IDENTIFIERS() {
        return DEFAULT_LEADING_IDENTIFIERS;
    }

    public static final Tuples2<String, Integer> getSelectedToken(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "content");
        if ((charSequence.length() == 0) || i < 0) {
            return new Tuples2<>(null, -1);
        }
        boolean z2 = i == charSequence.length();
        boolean z3 = i == 0 || CharJVM.isWhitespace(charSequence.charAt(i + (-1)));
        if (z2 && z3) {
            return new Tuples2<>(null, -1);
        }
        int iMax = Math.max(reverseIndexOf(charSequence, ' ', i), reverseIndexOf(charSequence, '\n', i)) + 1;
        String string = charSequence.subSequence(iMax, i).toString();
        return string.length() > 0 ? new Tuples2<>(string, Integer.valueOf(iMax)) : new Tuples2<>(null, -1);
    }

    private static final int reverseIndexOf(CharSequence charSequence, char c, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (charSequence.charAt(i2) == c) {
                return i2;
            }
        }
        return -1;
    }
}
