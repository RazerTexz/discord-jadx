package com.discord.simpleast.core.parser;

import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ParseSpec.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B/\b\u0016\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b \u0010!B\u001f\b\u0016\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0004\b \u0010\"R\u0019\u0010\b\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u0019\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/simpleast/core/parser/ParseSpec;", "R", ExifInterface.LATITUDE_SOUTH, "", "c", "Ljava/lang/Object;", "getState", "()Ljava/lang/Object;", "state", "", "d", "I", "getStartIndex", "()I", "setStartIndex", "(I)V", "startIndex", "Lcom/discord/simpleast/core/node/Node;", "a", "Lcom/discord/simpleast/core/node/Node;", "getRoot", "()Lcom/discord/simpleast/core/node/Node;", "root", "e", "getEndIndex", "setEndIndex", "endIndex", "", "b", "Z", "isTerminal", "()Z", "<init>", "(Lcom/discord/simpleast/core/node/Node;Ljava/lang/Object;II)V", "(Lcom/discord/simpleast/core/node/Node;Ljava/lang/Object;)V", "simpleast-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ParseSpec<R, S> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Node<R> root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isTerminal;

    /* renamed from: c, reason: from kotlin metadata */
    public final S state;

    /* renamed from: d, reason: from kotlin metadata */
    public int startIndex;

    /* renamed from: e, reason: from kotlin metadata */
    public int endIndex;

    public ParseSpec(Node<R> node, S s2, int i, int i2) {
        Intrinsics3.checkNotNullParameter(node, "root");
        this.root = node;
        this.state = s2;
        this.isTerminal = false;
        this.startIndex = i;
        this.endIndex = i2;
    }

    public ParseSpec(Node<R> node, S s2) {
        Intrinsics3.checkNotNullParameter(node, "root");
        this.root = node;
        this.state = s2;
        this.isTerminal = true;
    }
}
