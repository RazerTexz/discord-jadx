package b.g.a.c;

import b.g.a.c.JsonSerializable;
import b.g.a.c.i0.ClassUtil;
import java.util.Iterator;

/* compiled from: JsonNode.java */
/* renamed from: b.g.a.c.l, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class JsonNode extends JsonSerializable.a implements Iterable<JsonNode> {
    @Override // java.lang.Iterable
    public final Iterator<JsonNode> iterator() {
        return ClassUtil.c;
    }
}
