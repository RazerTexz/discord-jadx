package com.discord.utilities.embed;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: FileType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/discord/utilities/embed/FileType$threadLocalMatcher$1", "Ljava/lang/ThreadLocal;", "Ljava/util/regex/Matcher;", "kotlin.jvm.PlatformType", "initialValue", "()Ljava/util/regex/Matcher;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.embed.FileType$threadLocalMatcher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FileType2 extends ThreadLocal<Matcher> {
    public final /* synthetic */ Pattern $pattern;

    public FileType2(Pattern pattern) {
        this.$pattern = pattern;
    }

    @Override // java.lang.ThreadLocal
    public /* bridge */ /* synthetic */ Matcher initialValue() {
        return initialValue2();
    }

    @Override // java.lang.ThreadLocal
    /* renamed from: initialValue, reason: avoid collision after fix types in other method */
    public Matcher initialValue2() {
        return this.$pattern.matcher("");
    }
}
