package b.g.a.a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/* compiled from: JsonIncludeProperties.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.q, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonIncludeProperties {

    /* compiled from: JsonIncludeProperties.java */
    /* renamed from: b.g.a.a.q$a */
    public static class a implements Serializable {
        public static final a j = new a(null);
        private static final long serialVersionUID = 1;
        public final Set<String> _included;

        public a(Set<String> set) {
            this._included = set;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                Set<String> set = this._included;
                Set<String> set2 = ((a) obj)._included;
                if (set == null ? set2 == null : set.equals(set2)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Set<String> set = this._included;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this._included);
        }
    }

    String[] value() default {};
}
