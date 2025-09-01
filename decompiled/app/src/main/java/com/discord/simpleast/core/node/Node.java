package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Node.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B\u001f\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/simpleast/core/node/Node;", "R", "", "", "getChildren", "()Ljava/util/Collection;", "", "hasChildren", "()Z", "child", "", "addChild", "(Lcom/discord/simpleast/core/node/Node;)V", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "render", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V", "", "children", "Ljava/util/Collection;", "<init>", "(Ljava/util/Collection;)V", "a", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class Node<R> {
    private Collection<Node<R>> children;

    /* compiled from: Node.kt */
    public static class a<R> extends Node<R> {

        /* compiled from: Node.kt */
        /* renamed from: com.discord.simpleast.core.node.Node$a$a, reason: collision with other inner class name */
        public static final class C0069a extends Lambda implements Function1<Node<R>, CharSequence> {
            public static final C0069a j = new C0069a();

            public C0069a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public CharSequence invoke(Object obj) {
                Node node = (Node) obj;
                Intrinsics3.checkNotNullParameter(node, "it");
                return node.toString();
            }
        }

        public a(Node<R>... nodeArr) {
            Intrinsics3.checkNotNullParameter(nodeArr, "children");
            ArrayList arrayList = new ArrayList();
            for (Node<R> node : nodeArr) {
                if (node != null) {
                    arrayList.add(node);
                }
            }
            super(_Collections.toMutableList((Collection) arrayList));
        }

        @Override // com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            Collection<Node<R>> children = getChildren();
            if (children != null) {
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    ((Node) it.next()).render(spannableStringBuilder, r);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" >\n");
            Collection<Node<R>> children = getChildren();
            sb.append(children != null ? _Collections.joinToString$default(children, "\n->", ">>", "\n>|", 0, null, C0069a.j, 24, null) : null);
            return sb.toString();
        }
    }

    public Node() {
        this(null, 1, null);
    }

    public Node(Collection<Node<R>> collection) {
        this.children = collection;
    }

    public final void addChild(Node<R> child) {
        Intrinsics3.checkNotNullParameter(child, "child");
        Collection<Node<R>> arrayList = this.children;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(child);
        this.children = arrayList;
    }

    public final Collection<Node<R>> getChildren() {
        return this.children;
    }

    public final boolean hasChildren() {
        Collection<Node<R>> collection = this.children;
        return collection != null && (collection.isEmpty() ^ true);
    }

    public void render(SpannableStringBuilder builder, R renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
    }

    public /* synthetic */ Node(Collection collection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : collection);
    }
}
