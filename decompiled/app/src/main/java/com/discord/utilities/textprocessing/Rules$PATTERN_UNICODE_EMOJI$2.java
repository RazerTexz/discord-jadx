package com.discord.utilities.textprocessing;

import b.d.b.a.outline;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Rules.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/regex/Pattern;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Rules$PATTERN_UNICODE_EMOJI$2 extends Lambda implements Function0<Pattern> {
    public static final Rules$PATTERN_UNICODE_EMOJI$2 INSTANCE = new Rules$PATTERN_UNICODE_EMOJI$2();

    public Rules$PATTERN_UNICODE_EMOJI$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pattern invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pattern invoke2() {
        StringBuilder sbU = outline.U("^(");
        sbU.append(Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisPattern().pattern());
        sbU.append(')');
        return Pattern.compile(sbU.toString());
    }
}
