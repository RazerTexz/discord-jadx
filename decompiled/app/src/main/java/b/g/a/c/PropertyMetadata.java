package b.g.a.c;

import b.g.a.a.Nulls;
import b.g.a.c.c0.AnnotatedMember;
import java.io.Serializable;

/* compiled from: PropertyMetadata.java */
/* renamed from: b.g.a.c.s, reason: use source file name */
/* loaded from: classes3.dex */
public class PropertyMetadata implements Serializable {
    public static final PropertyMetadata j = new PropertyMetadata(Boolean.TRUE, null, null, null, null, null, null);
    public static final PropertyMetadata k = new PropertyMetadata(Boolean.FALSE, null, null, null, null, null, null);
    public static final PropertyMetadata l = new PropertyMetadata(null, null, null, null, null, null, null);
    private static final long serialVersionUID = -1;
    public Nulls _contentNulls;
    public final String _defaultValue;
    public final String _description;
    public final Integer _index;
    public final Boolean _required;
    public Nulls _valueNulls;
    public final transient a m;

    /* compiled from: PropertyMetadata.java */
    /* renamed from: b.g.a.c.s$a */
    public static final class a {
        public a(AnnotatedMember annotatedMember, boolean z2) {
        }
    }

    public PropertyMetadata(Boolean bool, String str, Integer num, String str2, a aVar, Nulls nulls, Nulls nulls2) {
        this._required = bool;
        this._description = str;
        this._index = num;
        this._defaultValue = (str2 == null || str2.isEmpty()) ? null : str2;
        this.m = aVar;
        this._valueNulls = nulls;
        this._contentNulls = nulls2;
    }

    public PropertyMetadata a(a aVar) {
        return new PropertyMetadata(this._required, this._description, this._index, this._defaultValue, aVar, this._valueNulls, this._contentNulls);
    }

    public Object readResolve() {
        if (this._description != null || this._index != null || this._defaultValue != null || this.m != null || this._valueNulls != null || this._contentNulls != null) {
            return this;
        }
        Boolean bool = this._required;
        return bool == null ? l : bool.booleanValue() ? j : k;
    }
}
