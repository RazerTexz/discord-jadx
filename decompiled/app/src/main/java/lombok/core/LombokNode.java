package lombok.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lombok.core.AST;
import lombok.core.LombokNode;

/* loaded from: discord:lombok/core/LombokNode.SCL.lombok */
public abstract class LombokNode<A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N> implements DiagnosticsReceiver {
    protected final AST.Kind kind;
    protected final N node;
    protected LombokImmutableList<L> children;
    protected L parent;
    protected boolean isStructurallySignificant;

    public abstract A getAst();

    protected abstract boolean calculateIsStructurallySignificant(N n);

    public abstract String getName();

    protected abstract boolean fieldContainsAnnotation(N n, N n2);

    public abstract boolean hasAnnotation(Class<? extends Annotation> cls);

    public abstract <Z extends Annotation> AnnotationValues<Z> findAnnotation(Class<Z> cls);

    public abstract boolean isStatic();

    public abstract boolean isFinal();

    public abstract boolean isTransient();

    public abstract boolean isPrimitive();

    public abstract boolean isEnumMember();

    public abstract boolean isEnumType();

    public abstract String fieldOrMethodBaseType();

    public abstract int countMethodParameters();

    public abstract int getStartPos();

    protected LombokNode(N node, List<L> children, AST.Kind kind) {
        this.kind = kind;
        this.node = node;
        this.children = children != null ? LombokImmutableList.copyOf((Collection) children) : LombokImmutableList.of();
        Iterator<L> it = this.children.iterator();
        while (it.hasNext()) {
            L child = it.next();
            child.parent = this;
            if (!child.isStructurallySignificant) {
                child.isStructurallySignificant = calculateIsStructurallySignificant(node);
            }
        }
        this.isStructurallySignificant = calculateIsStructurallySignificant(null);
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.kind;
        objArr[1] = this.node == null ? "(NULL)" : this.node.getClass();
        objArr[2] = this.node == null ? "" : this.node;
        return String.format("NODE %s (%s) %s", objArr);
    }

    public String getPackageDeclaration() {
        return getAst().getPackageDeclaration();
    }

    public ImportList getImportList() {
        return getAst().getImportList();
    }

    public TypeResolver getImportListAsTypeResolver() {
        return getAst().getImportListAsTypeResolver();
    }

    public L getNodeFor(N n) {
        return (L) getAst().get(n);
    }

    public N get() {
        return this.node;
    }

    public AST.Kind getKind() {
        return this.kind;
    }

    public L up() {
        L result;
        L l = this.parent;
        while (true) {
            result = l;
            if (result == null || result.isStructurallySignificant) {
                break;
            }
            l = result.parent;
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Collection<L> upFromAnnotationToFields() {
        if (getKind() != AST.Kind.ANNOTATION) {
            return Collections.emptyList();
        }
        LombokNode lombokNodeUp = up();
        if (lombokNodeUp == null || lombokNodeUp.getKind() != AST.Kind.FIELD) {
            return Collections.emptyList();
        }
        LombokNode lombokNodeUp2 = lombokNodeUp.up();
        if (lombokNodeUp2 == null || lombokNodeUp2.getKind() != AST.Kind.TYPE) {
            return Collections.emptyList();
        }
        List<L> fields = new ArrayList<>();
        Iterator<L> it = lombokNodeUp2.down().iterator();
        while (it.hasNext()) {
            L potentialField = it.next();
            if (potentialField.getKind() == AST.Kind.FIELD && fieldContainsAnnotation(potentialField.get(), get())) {
                fields.add(potentialField);
            }
        }
        return fields;
    }

    public L directUp() {
        return this.parent;
    }

    public LombokImmutableList<L> down() {
        return this.children;
    }

    public int getLatestJavaSpecSupported() {
        return getAst().getLatestJavaSpecSupported();
    }

    public int getSourceVersion() {
        return getAst().getSourceVersion();
    }

    public L top() {
        return (L) getAst().top();
    }

    public String getFileName() {
        return getAst().getFileName();
    }

    public L add(N n, AST.Kind kind) {
        getAst().setChanged();
        L l = (L) getAst().buildTree(n, kind);
        if (l == null) {
            return null;
        }
        l.parent = this;
        this.children = this.children.append(l);
        return l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void rebuild() {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        gatherAndRemoveChildren(identityHashMap);
        LombokNode lombokNodeBuildTree = getAst().buildTree(get(), this.kind);
        getAst().setChanged();
        getAst().replaceNewWithExistingOld(identityHashMap, lombokNodeBuildTree);
    }

    private void gatherAndRemoveChildren(Map<N, L> map) {
        Iterator<L> it = this.children.iterator();
        while (it.hasNext()) {
            LombokNode child = it.next();
            child.gatherAndRemoveChildren(map);
        }
        getAst().identityDetector.remove(get());
        map.put(get(), this);
        this.children = LombokImmutableList.of();
        getAst().getNodeMap().remove(get());
    }

    public void removeChild(L child) {
        getAst().setChanged();
        this.children = this.children.removeElement(child);
    }

    public boolean isStructurallySignificant() {
        return this.isStructurallySignificant;
    }
}
