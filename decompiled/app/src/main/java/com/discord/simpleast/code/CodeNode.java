package com.discord.simpleast.code;

import android.text.SpannableStringBuilder;
import b.a.t.a.CodeStyleProviders;
import b.a.t.b.a.TextNode;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CodeNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u0013\u000fB'\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/discord/simpleast/code/CodeNode;", "RC", "Lb/a/t/b/a/a;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/simpleast/core/node/StyleNode$a;", "b", "Lcom/discord/simpleast/core/node/StyleNode$a;", "stylesProvider", "", "a", "Ljava/lang/String;", "language", "Lcom/discord/simpleast/code/CodeNode$a;", "content", "<init>", "(Lcom/discord/simpleast/code/CodeNode$a;Ljava/lang/String;Lcom/discord/simpleast/core/node/StyleNode$a;)V", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class CodeNode<RC> extends TextNode<RC> {

    /* renamed from: a, reason: from kotlin metadata */
    public final String language;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StyleNode.a<RC> stylesProvider;

    /* compiled from: CodeNode.kt */
    public static abstract class a {
        public final String a;

        /* compiled from: CodeNode.kt */
        /* renamed from: com.discord.simpleast.code.CodeNode$a$a, reason: collision with other inner class name */
        public static final class C0068a<RC> extends a {

            /* renamed from: b, reason: collision with root package name */
            public final List<Node<RC>> f2807b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0068a(String str, List<? extends Node<RC>> list) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(str, "raw");
                Intrinsics3.checkNotNullParameter(list, "children");
                this.f2807b = list;
            }
        }

        /* compiled from: CodeNode.kt */
        public static final class b extends a {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(str, "body");
            }
        }

        public a(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this.a = str;
        }
    }

    /* compiled from: CodeNode.kt */
    public static final class b<RC> extends Node.a<RC> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, CodeStyleProviders<RC> codeStyleProviders) {
            super(new StyleNode.b(str, codeStyleProviders.d), new StyleNode.b(str2, codeStyleProviders.f));
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeNode(a aVar, String str, StyleNode.a<RC> aVar2) {
        super(aVar.a);
        Intrinsics3.checkNotNullParameter(aVar, "content");
        Intrinsics3.checkNotNullParameter(aVar2, "stylesProvider");
        this.language = str;
        this.stylesProvider = aVar2;
        if (aVar instanceof a.C0068a) {
            Iterator<T> it = ((a.C0068a) aVar).f2807b.iterator();
            while (it.hasNext()) {
                Node<R> node = (Node) it.next();
                Objects.requireNonNull(node, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
                addChild(node);
            }
        }
    }

    public boolean equals(Object other) {
        if (other instanceof CodeNode) {
            CodeNode codeNode = (CodeNode) other;
            if (Intrinsics3.areEqual(codeNode.language, this.language) && Intrinsics3.areEqual(codeNode.getContent(), getContent())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.a.t.b.a.TextNode, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Iterable<?> iterable = this.stylesProvider.get(renderContext);
        if (!hasChildren()) {
            int length = builder.length();
            builder.append(getContent());
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                builder.setSpan(it.next(), length, builder.length(), 17);
            }
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<?> it2 = iterable.iterator();
        while (it2.hasNext()) {
            spannableStringBuilder.setSpan(it2.next(), 0, 0, 18);
        }
        Collection<Node<RC>> children = getChildren();
        if (children != null) {
            Iterator<T> it3 = children.iterator();
            while (it3.hasNext()) {
                ((Node) it3.next()).render(spannableStringBuilder, renderContext);
            }
        }
        builder.append((char) 8202);
        builder.insert(builder.length() - 1, (CharSequence) spannableStringBuilder);
    }
}
