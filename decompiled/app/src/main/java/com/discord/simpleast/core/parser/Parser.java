package com.discord.simpleast.core.parser;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.simpleast.core.node.Node;
import d0.Tuples;
import d0.t._ArraysJvm;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Parser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 #*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u0004\b\u0002\u0010\u00042\u00020\u0005:\u0002#$B\u0013\b\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"JM\u0010\u000b\u001a\u00020\n\"\u0004\b\u0003\u0010\u0001\"\u000e\b\u0004\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00030\u0002\"\u0004\b\u0005\u0010\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJM\u0010\r\u001a\u00020\n\"\u0004\b\u0003\u0010\u0001\"\u000e\b\u0004\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00030\u0002\"\u0004\b\u0005\u0010\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ;\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002:\u0010\u0011\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0010\"\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013JA\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002 \u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0014¢\u0006\u0004\b\u0012\u0010\u0015JI\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00028\u00022\"\b\u0002\u0010\u0018\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR0\u0010\u0018\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/discord/simpleast/core/parser/Parser;", "R", "Lcom/discord/simpleast/core/node/Node;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "", "Lcom/discord/simpleast/core/parser/Rule;", "rule", "", "source", "", "logMatch", "(Lcom/discord/simpleast/core/parser/Rule;Ljava/lang/CharSequence;)V", "logMiss", "addRule", "(Lcom/discord/simpleast/core/parser/Rule;)Lcom/discord/simpleast/core/parser/Parser;", "", "newRules", "addRules", "([Lcom/discord/simpleast/core/parser/Rule;)Lcom/discord/simpleast/core/parser/Parser;", "", "(Ljava/util/Collection;)Lcom/discord/simpleast/core/parser/Parser;", "initialState", "", "rules", "", "parse", "(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "", "enableDebugging", "Z", "<init>", "(Z)V", "Companion", "ParseException", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class Parser<R, T extends Node<R>, S> {
    private static final String TAG = "Parser";
    private final boolean enableDebugging;
    private final ArrayList<Rule<R, ? extends T, S>> rules;

    /* compiled from: Parser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/simpleast/core/parser/Parser$ParseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "message", "", "source", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/Throwable;)V", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
    public static final class ParseException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParseException(String str, CharSequence charSequence, Throwable th) {
            super("Error while parsing: " + str + " \n Source: " + charSequence, th);
            Intrinsics3.checkNotNullParameter(str, "message");
        }
    }

    public Parser() {
        this(false, 1, null);
    }

    public Parser(boolean z2) {
        this.enableDebugging = z2;
        this.rules = new ArrayList<>();
    }

    private final <R, T extends Node<R>, S> void logMatch(Rule<R, T, S> rule, CharSequence source) {
        if (this.enableDebugging) {
            StringBuilder sbU = outline.U("MATCH: with rule with pattern: ");
            sbU.append(rule.getMatcher().pattern().toString());
            sbU.append(" to source: ");
            sbU.append(source);
            Log.i(TAG, sbU.toString());
        }
    }

    private final <R, T extends Node<R>, S> void logMiss(Rule<R, T, S> rule, CharSequence source) {
        if (this.enableDebugging) {
            StringBuilder sbU = outline.U("MISS: with rule with pattern: ");
            sbU.append(rule.getMatcher().pattern().toString());
            sbU.append(" to source: ");
            sbU.append(source);
            Log.i(TAG, sbU.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List parse$default(Parser parser, CharSequence charSequence, Object obj, List list, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parse");
        }
        if ((i & 4) != 0) {
            list = parser.rules;
        }
        return parser.parse(charSequence, obj, list);
    }

    public final Parser<R, T, S> addRule(Rule<R, ? extends T, S> rule) {
        Intrinsics3.checkNotNullParameter(rule, "rule");
        this.rules.add(rule);
        return this;
    }

    public final Parser<R, T, S> addRules(Rule<R, ? extends T, S>... newRules) {
        Intrinsics3.checkNotNullParameter(newRules, "newRules");
        return addRules(_ArraysJvm.asList(newRules));
    }

    public final List<T> parse(CharSequence charSequence, S s2) {
        return parse$default(this, charSequence, s2, null, 4, null);
    }

    public final List<T> parse(CharSequence source, S initialState, List<? extends Rule<R, ? extends T, S>> rules) {
        ParseSpec parseSpec;
        int i;
        int i2;
        Tuples2 tuples2;
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(rules, "rules");
        Stack stack = new Stack();
        Node node = new Node(null, 1, null);
        if (source.length() > 0) {
            stack.add(new ParseSpec(node, initialState, 0, source.length()));
        }
        String strGroup = null;
        while (!stack.isEmpty() && (i = (parseSpec = (ParseSpec) stack.pop()).startIndex) < (i2 = parseSpec.endIndex)) {
            CharSequence charSequenceSubSequence = source.subSequence(i, i2);
            int i3 = parseSpec.startIndex;
            Iterator<? extends Rule<R, ? extends T, S>> it = rules.iterator();
            while (true) {
                if (!it.hasNext()) {
                    tuples2 = null;
                    break;
                }
                Rule<R, ? extends T, S> next = it.next();
                Matcher matcherMatch = next.match(charSequenceSubSequence, strGroup, parseSpec.state);
                if (matcherMatch == null) {
                    logMiss(next, charSequenceSubSequence);
                    tuples2 = null;
                } else {
                    logMatch(next, charSequenceSubSequence);
                    tuples2 = Tuples.to(next, matcherMatch);
                }
                if (tuples2 != null) {
                    break;
                }
            }
            if (tuples2 == null) {
                throw new ParseException("failed to find rule to match source", source, null);
            }
            Rule rule = (Rule) tuples2.component1();
            Matcher matcher = (Matcher) tuples2.component2();
            int iEnd = matcher.end() + i3;
            ParseSpec<R, S> parseSpec2 = rule.parse(matcher, this, parseSpec.state);
            Node<R> node2 = parseSpec.root;
            node2.addChild(parseSpec2.root);
            int i4 = parseSpec.endIndex;
            if (iEnd != i4) {
                S s2 = parseSpec.state;
                Intrinsics3.checkNotNullParameter(node2, "node");
                stack.push(new ParseSpec(node2, s2, iEnd, i4));
            }
            if (!parseSpec2.isTerminal) {
                parseSpec2.startIndex += i3;
                parseSpec2.endIndex += i3;
                stack.push(parseSpec2);
            }
            try {
                strGroup = matcher.group(0);
            } catch (Throwable th) {
                throw new ParseException("matcher found no matches", source, th);
            }
        }
        Collection<Node<R>> children = node.getChildren();
        List<T> mutableList = children != null ? _Collections.toMutableList((Collection) children) : null;
        List<T> list = TypeIntrinsics.isMutableList(mutableList) ? mutableList : null;
        return list != null ? list : new ArrayList();
    }

    public final Parser<R, T, S> addRules(Collection<? extends Rule<R, ? extends T, S>> newRules) {
        Intrinsics3.checkNotNullParameter(newRules, "newRules");
        this.rules.addAll(newRules);
        return this;
    }

    public /* synthetic */ Parser(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }
}
