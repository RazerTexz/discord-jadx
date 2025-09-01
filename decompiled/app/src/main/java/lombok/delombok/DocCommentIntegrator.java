package lombok.delombok;

import com.sun.tools.javac.parser.Tokens;
import com.sun.tools.javac.tree.DocCommentTable;
import com.sun.tools.javac.tree.JCTree;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.javac.CommentInfo;
import lombok.javac.Javac;
import lombok.javac.PackageName;
import lombok.javac.handlers.JavacHandlerUtil;

/* loaded from: discord:lombok/delombok/DocCommentIntegrator.SCL.lombok */
public class DocCommentIntegrator {
    private static final Pattern CONTENT_STRIPPER = Pattern.compile("^(?:\\s*\\*)?(.*?)$", 8);

    public List<CommentInfo> integrate(List<CommentInfo> comments, JCTree.JCCompilationUnit unit) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<CommentInfo> out = new ArrayList<>();
        CommentInfo lastExcisedComment = null;
        JCTree lastNode = null;
        for (CommentInfo cmt : comments) {
            if (!cmt.isJavadoc()) {
                out.add(cmt);
            } else {
                JCTree node = findJavadocableNodeOnOrAfter(unit, cmt.endPos);
                if (node == null) {
                    out.add(cmt);
                } else {
                    if (node == lastNode) {
                        out.add(lastExcisedComment);
                    }
                    if (!attach(unit, node, cmt)) {
                        out.add(cmt);
                    } else {
                        lastNode = node;
                        lastExcisedComment = cmt;
                    }
                }
            }
        }
        return out;
    }

    private boolean attach(JCTree.JCCompilationUnit top, JCTree node, CommentInfo cmt) throws IllegalAccessException, IllegalArgumentException {
        String docCommentContent = cmt.content;
        if (docCommentContent.startsWith("/**")) {
            docCommentContent = docCommentContent.substring(3);
        }
        if (docCommentContent.endsWith("*/")) {
            docCommentContent = docCommentContent.substring(0, docCommentContent.length() - 2);
        }
        String docCommentContent2 = CONTENT_STRIPPER.matcher(docCommentContent).replaceAll("$1").trim();
        if (Javac.getDocComments(top) == null) {
            Javac.initDocComments(top);
        }
        Object map_ = Javac.getDocComments(top);
        if (map_ instanceof Map) {
            ((Map) map_).put(node, docCommentContent2);
            return true;
        }
        if (Javac.instanceOfDocCommentTable(map_)) {
            CommentAttacher_8.attach(node, docCommentContent2, map_);
            return true;
        }
        return false;
    }

    /* loaded from: discord:lombok/delombok/DocCommentIntegrator$CommentAttacher_8.SCL.lombok */
    private static class CommentAttacher_8 {
        private CommentAttacher_8() {
        }

        /* renamed from: lombok.delombok.DocCommentIntegrator$CommentAttacher_8$1, reason: invalid class name */
        /* loaded from: discord:lombok/delombok/DocCommentIntegrator$CommentAttacher_8$1.SCL.lombok */
        class AnonymousClass1 implements Tokens.Comment {
            private final /* synthetic */ String val$docCommentContent_;
            private final /* synthetic */ JCTree val$node;

            AnonymousClass1(String str, JCTree jCTree) {
                this.val$docCommentContent_ = str;
                this.val$node = jCTree;
            }

            public String getText() {
                return this.val$docCommentContent_;
            }

            public int getSourcePos(int index) {
                return -1;
            }

            public Tokens.Comment.CommentStyle getStyle() {
                return Tokens.Comment.CommentStyle.JAVADOC;
            }

            public boolean isDeprecated() {
                return JavacHandlerUtil.nodeHasDeprecatedFlag(this.val$node);
            }
        }

        static void attach(JCTree node, String docCommentContent, Object map_) {
            ((DocCommentTable) map_).putComment(node, new AnonymousClass1(docCommentContent, node));
        }
    }

    private JCTree findJavadocableNodeOnOrAfter(JCTree.JCCompilationUnit unit, int endPos) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        JCTree pid = PackageName.getPackageNode(unit);
        if (pid != null && endPos <= pid.pos) {
            return null;
        }
        Iterator<JCTree> it = unit.defs.iterator();
        while (it.hasNext()) {
            JCTree next = it.next();
            if (next.pos < endPos) {
                if (next instanceof JCTree.JCClassDecl) {
                    com.sun.tools.javac.util.List<JCTree> defs = ((JCTree.JCClassDecl) next).defs;
                    if (!defs.isEmpty()) {
                        while (!defs.tail.isEmpty()) {
                            defs = defs.tail;
                        }
                    }
                    if (defs.head != null && ((JCTree) defs.head).pos >= endPos) {
                        it = ((JCTree.JCClassDecl) next).defs.iterator();
                    }
                }
            } else {
                if ((next instanceof JCTree.JCMethodDecl) || (next instanceof JCTree.JCClassDecl) || (next instanceof JCTree.JCVariableDecl)) {
                    return next;
                }
                return null;
            }
        }
        return null;
    }
}
