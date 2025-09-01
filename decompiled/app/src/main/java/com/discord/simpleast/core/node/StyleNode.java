package com.discord.simpleast.core.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.TextNode;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StyleNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\b\u0016\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\u0011\u0012\u0013B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/discord/simpleast/core/node/StyleNode;", "RC", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node$a;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;)V", "", "styles", "Ljava/util/List;", "getStyles", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "a", "b", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class StyleNode<RC, T> extends Node.a<RC> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<T> styles;

    /* compiled from: StyleNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/simpleast/core/node/StyleNode$Companion;", "", "<init>", "()V", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: StyleNode.kt */
    public interface a<RC> {
        Iterable<?> get(RC rc);
    }

    /* compiled from: StyleNode.kt */
    public static final class b<RC> extends TextNode<RC> {
        public final a<RC> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, a<RC> aVar) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, "content");
            Intrinsics3.checkNotNullParameter(aVar, "stylesProvider");
            this.a = aVar;
        }

        @Override // b.a.t.b.a.TextNode, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, rc);
            Iterator<?> it = this.a.get(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StyleNode(List<? extends T> list) {
        super(new Node[0]);
        Intrinsics3.checkNotNullParameter(list, "styles");
        this.styles = list;
    }

    public static final <RC, T> StyleNode<RC, T> wrapText(String str, List<? extends T> list) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(list, "styles");
        StyleNode<RC, T> styleNode = new StyleNode<>(list);
        styleNode.addChild(new TextNode(str));
        return styleNode;
    }

    public final List<T> getStyles() {
        return this.styles;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, RC renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        int length = builder.length();
        super.render(builder, renderContext);
        Iterator<T> it = this.styles.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
