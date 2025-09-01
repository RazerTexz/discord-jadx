package lombok.core;

import java.util.Iterator;
import java.util.List;
import lombok.core.AST;

/* loaded from: discord:lombok/core/TypeResolver.SCL.lombok */
public class TypeResolver {
    private ImportList imports;

    public TypeResolver(ImportList importList) {
        this.imports = importList;
    }

    public boolean typeMatches(LombokNode<?, ?, ?> context, String fqn, String typeRef) {
        return typeRefToFullyQualifiedName(context, TypeLibrary.createLibraryForSingleType(fqn), typeRef) != null;
    }

    public String typeRefToFullyQualifiedName(LombokNode<?, ?, ?> context, TypeLibrary library, String typeRef) {
        List<String> qualifieds = library.toQualifieds(typeRef);
        if (qualifieds == null || qualifieds.isEmpty()) {
            return null;
        }
        if (qualifieds.contains(typeRef)) {
            return LombokInternalAliasing.processAliases(typeRef);
        }
        int firstDot = typeRef.indexOf(46);
        if (firstDot == -1) {
            firstDot = typeRef.length();
        }
        String firstTypeRef = typeRef.substring(0, firstDot);
        String fromExplicitImport = this.imports.getFullyQualifiedNameForSimpleNameNoAliasing(firstTypeRef);
        if (fromExplicitImport != null) {
            String fqn = String.valueOf(fromExplicitImport) + typeRef.substring(firstDot);
            if (qualifieds.contains(fqn)) {
                return LombokInternalAliasing.processAliases(fqn);
            }
            return null;
        }
        for (String qualified : qualifieds) {
            String pkgName = qualified.substring(0, (qualified.length() - typeRef.length()) - 1);
            if (this.imports.hasStarImport(pkgName)) {
                LombokNode<?, ?, ?> lombokNodeDirectUp = context;
                while (true) {
                    LombokNode<?, ?, ?> n = lombokNodeDirectUp;
                    if (n == null) {
                        break;
                    }
                    if (n.getKind() == AST.Kind.TYPE && firstTypeRef.equals(n.getName())) {
                        return null;
                    }
                    if (n.getKind() == AST.Kind.STATEMENT || n.getKind() == AST.Kind.LOCAL) {
                        LombokNode<?, ?, ?> newN = n.directUp();
                        if (newN == null) {
                            break;
                        }
                        if (newN.getKind() == AST.Kind.STATEMENT || newN.getKind() == AST.Kind.INITIALIZER || newN.getKind() == AST.Kind.METHOD) {
                            Iterator it = newN.down().iterator();
                            while (it.hasNext()) {
                                LombokNode<?, ?, ?> child = (LombokNode) it.next();
                                if (child.getKind() == AST.Kind.TYPE && firstTypeRef.equals(child.getName())) {
                                    return null;
                                }
                                if (child == n) {
                                    break;
                                }
                            }
                        }
                        lombokNodeDirectUp = newN;
                    } else {
                        if (n.getKind() == AST.Kind.TYPE || n.getKind() == AST.Kind.COMPILATION_UNIT) {
                            Iterator it2 = n.down().iterator();
                            while (it2.hasNext()) {
                                LombokNode<?, ?, ?> child2 = (LombokNode) it2.next();
                                if (child2.getKind() == AST.Kind.TYPE && firstTypeRef.equals(child2.getName())) {
                                    return null;
                                }
                            }
                        }
                        lombokNodeDirectUp = n.directUp();
                    }
                }
                return LombokInternalAliasing.processAliases(qualified);
            }
        }
        return null;
    }
}
