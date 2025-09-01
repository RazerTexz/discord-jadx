package lombok.javac.handlers;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Helper;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* loaded from: discord:lombok/javac/handlers/HandleHelper.SCL.lombok */
public class HandleHelper extends JavacAnnotationHandler<Helper> {
    private List<JCTree.JCStatement> getStatementsFromJcNode(JCTree tree) {
        if (tree instanceof JCTree.JCBlock) {
            return ((JCTree.JCBlock) tree).stats;
        }
        if (tree instanceof JCTree.JCCase) {
            return ((JCTree.JCCase) tree).stats;
        }
        return null;
    }

    private void setStatementsOfJcNode(JCTree tree, List<JCTree.JCStatement> statements) {
        if (!(tree instanceof JCTree.JCBlock)) {
            if (!(tree instanceof JCTree.JCCase)) {
                throw new IllegalArgumentException("Can't set statements on node type: " + tree.getClass());
            }
            ((JCTree.JCCase) tree).stats = statements;
            return;
        }
        ((JCTree.JCBlock) tree).stats = statements;
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Helper> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        String n;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.HELPER_FLAG_USAGE, "@Helper");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Helper.class);
        JavacNode annotatedType = annotationNode.up();
        JavacNode containingBlock = annotatedType == null ? null : annotatedType.directUp();
        List<JCTree.JCStatement> origStatements = getStatementsFromJcNode(containingBlock == null ? null : containingBlock.get());
        if (annotatedType == null || annotatedType.getKind() != AST.Kind.TYPE || origStatements == null) {
            annotationNode.addError("@Helper is legal only on method-local classes.");
            return;
        }
        JCTree.JCStatement jCStatement = (JCTree.JCClassDecl) annotatedType.get();
        Iterator<JCTree.JCStatement> it = origStatements.iterator();
        while (it.hasNext() && it.next() != jCStatement) {
        }
        java.util.List<String> knownMethodNames = new ArrayList<>();
        Iterator<JavacNode> it2 = annotatedType.down().iterator();
        while (it2.hasNext()) {
            JavacNode ch = it2.next();
            if (ch.getKind() == AST.Kind.METHOD && (n = ch.getName()) != null && !n.isEmpty() && n.charAt(0) != '<') {
                knownMethodNames.add(n);
            }
        }
        Collections.sort(knownMethodNames);
        String[] knownMethodNames_ = (String[]) knownMethodNames.toArray(new String[0]);
        Name helperName = annotationNode.toName("$" + ((JCTree.JCClassDecl) jCStatement).name);
        boolean[] helperUsed = new boolean[1];
        JavacTreeMaker maker = annotationNode.getTreeMaker();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(knownMethodNames_, maker, helperName, helperUsed);
        while (it.hasNext()) {
            it.next().accept(anonymousClass1, (Object) null);
        }
        if (!helperUsed[0]) {
            annotationNode.addWarning("No methods of this helper class are ever used.");
            return;
        }
        ListBuffer<JCTree.JCStatement> newStatements = new ListBuffer<>();
        boolean mark = false;
        Iterator it3 = origStatements.iterator();
        while (it3.hasNext()) {
            JCTree.JCStatement stat = (JCTree.JCStatement) it3.next();
            newStatements.append(stat);
            if (!mark && stat == jCStatement) {
                mark = true;
                JCTree.JCVariableDecl decl = maker.VarDef(maker.Modifiers(16L), helperName, maker.Ident(((JCTree.JCClassDecl) jCStatement).name), maker.NewClass(null, List.nil(), maker.Ident(((JCTree.JCClassDecl) jCStatement).name), List.nil(), null));
                newStatements.append(decl);
            }
        }
        setStatementsOfJcNode(containingBlock.get(), newStatements.toList());
    }

    /* renamed from: lombok.javac.handlers.HandleHelper$1, reason: invalid class name */
    /* loaded from: discord:lombok/javac/handlers/HandleHelper$1.SCL.lombok */
    class AnonymousClass1 extends TreeScanner<Void, Void> {
        private final /* synthetic */ String[] val$knownMethodNames_;
        private final /* synthetic */ JavacTreeMaker val$maker;
        private final /* synthetic */ Name val$helperName;
        private final /* synthetic */ boolean[] val$helperUsed;

        public /* bridge */ /* synthetic */ Object visitMethodInvocation(MethodInvocationTree methodInvocationTree, Object obj) {
            return visitMethodInvocation(methodInvocationTree, (Void) obj);
        }

        AnonymousClass1(String[] strArr, JavacTreeMaker javacTreeMaker, Name name, boolean[] zArr) {
            this.val$knownMethodNames_ = strArr;
            this.val$maker = javacTreeMaker;
            this.val$helperName = name;
            this.val$helperUsed = zArr;
        }

        public Void visitMethodInvocation(MethodInvocationTree node, Void p) {
            JCTree.JCMethodInvocation jcmi = (JCTree.JCMethodInvocation) node;
            apply(jcmi);
            return (Void) super.visitMethodInvocation(node, p);
        }

        private void apply(JCTree.JCMethodInvocation jcmi) {
            if (jcmi.meth instanceof JCTree.JCIdent) {
                JCTree.JCIdent jci = jcmi.meth;
                if (Arrays.binarySearch(this.val$knownMethodNames_, jci.name.toString()) < 0) {
                    return;
                }
                jcmi.meth = this.val$maker.Select(this.val$maker.Ident(this.val$helperName), jci.name);
                this.val$helperUsed[0] = true;
            }
        }
    }
}
