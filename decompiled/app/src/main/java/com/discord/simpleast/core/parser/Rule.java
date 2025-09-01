package com.discord.simpleast.core.parser;

import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: Rule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u0004\b\u0002\u0010\u00042\u00020\u0005:\u0001\u001cB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001bJ+\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJG\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f2\u0006\u0010\n\u001a\u00028\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/discord/simpleast/core/parser/Rule;", "R", "Lcom/discord/simpleast/core/node/Node;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "", "", "inspectionSource", "", "lastCapture", "state", "Ljava/util/regex/Matcher;", "match", "(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/Object;)Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "Ljava/util/regex/Matcher;", "getMatcher", "()Ljava/util/regex/Matcher;", "<init>", "(Ljava/util/regex/Matcher;)V", "Ljava/util/regex/Pattern;", "pattern", "(Ljava/util/regex/Pattern;)V", "BlockRule", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class Rule<R, T extends Node<R>, S> {
    private final Matcher matcher;

    /* compiled from: Rule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u000e\b\u0004\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00030\u0002*\u0004\b\u0005\u0010\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00028\u0005H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/discord/simpleast/core/parser/Rule$BlockRule;", "R", "Lcom/discord/simpleast/core/node/Node;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "Lcom/discord/simpleast/core/parser/Rule;", "", "inspectionSource", "", "lastCapture", "state", "Ljava/util/regex/Matcher;", "match", "(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/Object;)Ljava/util/regex/Matcher;", "Ljava/util/regex/Pattern;", "pattern", "<init>", "(Ljava/util/regex/Pattern;)V", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class BlockRule<R, T extends Node<R>, S> extends Rule<R, T, S> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BlockRule(Pattern pattern) {
            super(pattern);
            Intrinsics3.checkNotNullParameter(pattern, "pattern");
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
            Intrinsics3.checkNotNullParameter(inspectionSource, "inspectionSource");
            if (lastCapture == null || Strings4.endsWith$default((CharSequence) lastCapture, '\n', false, 2, (Object) null)) {
                return super.match(inspectionSource, lastCapture, state);
            }
            return null;
        }
    }

    public Rule(Matcher matcher) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        this.matcher = matcher;
    }

    public final Matcher getMatcher() {
        return this.matcher;
    }

    public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
        Intrinsics3.checkNotNullParameter(inspectionSource, "inspectionSource");
        this.matcher.reset(inspectionSource);
        if (this.matcher.find()) {
            return this.matcher;
        }
        return null;
    }

    public abstract ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super T, S> parser, S state);

    /* JADX WARN: Illegal instructions before constructor call */
    public Rule(Pattern pattern) {
        Intrinsics3.checkNotNullParameter(pattern, "pattern");
        Matcher matcher = pattern.matcher("");
        Intrinsics3.checkNotNullExpressionValue(matcher, "pattern.matcher(\"\")");
        this(matcher);
    }
}
