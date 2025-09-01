package lombok.launch;

import android.animation.Animator;
import android.animation.AnimatorSet;
import b.f.e.AbstractDataSource3;
import b.f.e.DataSubscriber;
import d0.e0.p.d.m0.g.FqName;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import lombok.eclipse.EcjAugments;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.core.SourceField;
import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.RewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.TokenScanner;
import org.eclipse.jdt.internal.corext.refactoring.SearchResultGroup;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

/* loaded from: discord:Class50/lombok/launch/PatchFixesHider.SCL.lombok */
final class PatchFixesHider {
    PatchFixesHider() {
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$Util.SCL.lombok */
    public static final class Util {
        private static ClassLoader shadowLoader;

        public static Class<?> shadowLoadClass(String name) throws ClassNotFoundException {
            try {
                if (shadowLoader == null) {
                    try {
                        Class.forName("lombok.core.LombokNode");
                        shadowLoader = Util.class.getClassLoader();
                    } catch (ClassNotFoundException unused) {
                        shadowLoader = Main.getShadowClassLoader();
                    }
                }
                return Class.forName(name, true, shadowLoader);
            } catch (ClassNotFoundException e) {
                throw sneakyThrow(e);
            }
        }

        public static Method findMethod(Class<?> type, String name, Class<?>... clsArr) {
            try {
                return type.getDeclaredMethod(name, clsArr);
            } catch (NoSuchMethodException e) {
                throw sneakyThrow(e);
            }
        }

        public static Object invokeMethod(Method method, Object... args) {
            try {
                return method.invoke(null, args);
            } catch (IllegalAccessException e) {
                throw sneakyThrow(e);
            } catch (InvocationTargetException e2) {
                throw sneakyThrow(e2.getCause());
            }
        }

        private static RuntimeException sneakyThrow(Throwable t) throws Throwable {
            if (t == null) {
                throw new NullPointerException("t");
            }
            sneakyThrow0(t);
            return null;
        }

        private static <T extends Throwable> void sneakyThrow0(Throwable t) throws Throwable {
            throw t;
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$LombokDeps.SCL.lombok */
    public static final class LombokDeps {
        public static final Method ADD_LOMBOK_NOTES;
        public static final Method POST_COMPILER_BYTES_STRING;
        public static final Method POST_COMPILER_OUTPUTSTREAM;
        public static final Method POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchFixesShadowLoaded");
            ADD_LOMBOK_NOTES = Util.findMethod(shadowed, "addLombokNotesToEclipseAboutDialog", String.class, String.class);
            POST_COMPILER_BYTES_STRING = Util.findMethod(shadowed, "runPostCompiler", byte[].class, String.class);
            POST_COMPILER_OUTPUTSTREAM = Util.findMethod(shadowed, "runPostCompiler", OutputStream.class);
            POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING = Util.findMethod(shadowed, "runPostCompiler", BufferedOutputStream.class, String.class, String.class);
        }

        public static String addLombokNotesToEclipseAboutDialog(String origReturnValue, String key) {
            try {
                return (String) Util.invokeMethod(ADD_LOMBOK_NOTES, origReturnValue, key);
            } catch (Throwable unused) {
                return origReturnValue;
            }
        }

        public static byte[] runPostCompiler(byte[] bytes, String fileName) {
            return (byte[]) Util.invokeMethod(POST_COMPILER_BYTES_STRING, bytes, fileName);
        }

        public static OutputStream runPostCompiler(OutputStream out) throws IOException {
            return (OutputStream) Util.invokeMethod(POST_COMPILER_OUTPUTSTREAM, out);
        }

        public static BufferedOutputStream runPostCompiler(BufferedOutputStream out, String path, String name) throws IOException {
            return (BufferedOutputStream) Util.invokeMethod(POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING, out, path, name);
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$Transform.SCL.lombok */
    public static final class Transform {
        private static final Method TRANSFORM;
        private static final Method TRANSFORM_SWAPPED;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.TransformEclipseAST");
            TRANSFORM = Util.findMethod(shadowed, "transform", Parser.class, CompilationUnitDeclaration.class);
            TRANSFORM_SWAPPED = Util.findMethod(shadowed, "transform_swapped", CompilationUnitDeclaration.class, Parser.class);
        }

        public static void transform(Parser parser, CompilationUnitDeclaration ast) throws IOException {
            Util.invokeMethod(TRANSFORM, parser, ast);
        }

        public static void transform_swapped(CompilationUnitDeclaration ast, Parser parser) throws IOException {
            Util.invokeMethod(TRANSFORM_SWAPPED, ast, parser);
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$Delegate.SCL.lombok */
    public static final class Delegate {
        private static final Method HANDLE_DELEGATE_FOR_TYPE = null;
        private static final Method GET_CHILDREN = null;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        public Delegate(b.f.e.AbstractDataSource3 r3, boolean r4, b.f.e.DataSubscriber r5, boolean r6) {
            /*
                r2 = this;
                r0 = r2
                super/*android.animation.AnimatorSet*/.removeListener(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Delegate.<init>(b.f.e.c, boolean, b.f.e.f, boolean):void");
        }

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        static boolean d(
        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Failed to calculate best type for var: r1v1 ??
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayPutListener(TypeUpdate.java:609)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:156)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:133)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:238)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
         */
        /* JADX WARN: Failed to calculate best type for var: r1v1 ??
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayPutListener(TypeUpdate.java:609)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('classScope' java.lang.Object)]), block:B:2:0x0000 */
        public static void run() {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.Delegate.HANDLE_DELEGATE_FOR_TYPE
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                java.lang.Object r0 = android.animation.Keyframe.getValue()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                android.animation.Keyframe r0 = r0.ofObject(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Delegate.run():void");
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object[], void] */
        /* renamed from: <init>, reason: not valid java name */
        public static void m268init(AbstractDataSource3 abstractDataSource3, DataSubscriber dataSubscriber) {
            Method method = GET_CHILDREN;
            Object[] objArr = {abstractDataSource3, dataSubscriber};
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$ValPortal.SCL.lombok */
    public static final class ValPortal {
        private static final Method COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE;
        private static final Method COPY_INITIALIZATION_OF_LOCAL_DECLARATION;
        private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT;
        private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchValEclipsePortal");
            COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE = Util.findMethod(shadowed, "copyInitializationOfForEachIterable", Object.class);
            COPY_INITIALIZATION_OF_LOCAL_DECLARATION = Util.findMethod(shadowed, "copyInitializationOfLocalDeclaration", Object.class);
            ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT = Util.findMethod(shadowed, "addFinalAndValAnnotationToVariableDeclarationStatement", Object.class, Object.class, Object.class);
            ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION = Util.findMethod(shadowed, "addFinalAndValAnnotationToSingleVariableDeclaration", Object.class, Object.class, Object.class);
        }

        public static void copyInitializationOfForEachIterable(Object parser) {
            Util.invokeMethod(COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE, parser);
        }

        public static void copyInitializationOfLocalDeclaration(Object parser) {
            Util.invokeMethod(COPY_INITIALIZATION_OF_LOCAL_DECLARATION, parser);
        }

        public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, Object out, Object in) {
            Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT, converter, out, in);
        }

        public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, Object out, Object in) {
            Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION, converter, out, in);
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$Val.SCL.lombok */
    public static final class Val {
        private static final Method SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED;
        private static final Method SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2;
        private static final Method HANDLE_VAL_FOR_LOCAL_DECLARATION;
        private static final Method HANDLE_VAL_FOR_FOR_EACH;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchVal");
            SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED = Util.findMethod(shadowed, "skipResolveInitializerIfAlreadyCalled", Expression.class, BlockScope.class);
            SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2 = Util.findMethod(shadowed, "skipResolveInitializerIfAlreadyCalled2", Expression.class, BlockScope.class, LocalDeclaration.class);
            HANDLE_VAL_FOR_LOCAL_DECLARATION = Util.findMethod(shadowed, "handleValForLocalDeclaration", LocalDeclaration.class, BlockScope.class);
            HANDLE_VAL_FOR_FOR_EACH = Util.findMethod(shadowed, "handleValForForEach", ForeachStatement.class, BlockScope.class);
        }

        public static TypeBinding skipResolveInitializerIfAlreadyCalled(Expression expr, BlockScope scope) {
            return (TypeBinding) Util.invokeMethod(SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED, expr, scope);
        }

        public static TypeBinding skipResolveInitializerIfAlreadyCalled2(Expression expr, BlockScope scope, LocalDeclaration decl) {
            return (TypeBinding) Util.invokeMethod(SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2, expr, scope, decl);
        }

        public static boolean handleValForLocalDeclaration(LocalDeclaration local, BlockScope scope) {
            return ((Boolean) Util.invokeMethod(HANDLE_VAL_FOR_LOCAL_DECLARATION, local, scope)).booleanValue();
        }

        public static boolean handleValForForEach(ForeachStatement forEach, BlockScope scope) {
            return ((Boolean) Util.invokeMethod(HANDLE_VAL_FOR_FOR_EACH, forEach, scope)).booleanValue();
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$ExtensionMethod.SCL.lombok */
    public static final class ExtensionMethod {
        private static final Method RESOLVE_TYPE = null;
        private static final Method ERROR_NO_METHOD_FOR = null;
        private static final Method INVALID_METHOD = null;
        private static final Method INVALID_METHOD2 = null;
        private static final Method NON_STATIC_ACCESS_TO_STATIC_METHOD = null;

        /* JADX WARN: Multi-variable type inference failed */
        public ExtensionMethod() {
            super/*android.app.Activity*/.setResult(this, this);
            return;
        }

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        /* renamed from: <init>, reason: not valid java name */
        static void m269init(
        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('resolvedType' org.eclipse.jdt.internal.compiler.lookup.TypeBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('methodCall' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('scope' org.eclipse.jdt.internal.compiler.lookup.BlockScope)])
        , block:B:2:0x0000 */
        /* renamed from: component10 */
        public static boolean getIsOnCooldown() {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.ExtensionMethod.RESOLVE_TYPE
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4
                r2 = r1
                r3 = 2
                r4 = r8
                r2[r3] = r4
                void r0 = android.app.AlarmManager.set(r0, r1, r0)
                org.eclipse.jdt.internal.compiler.lookup.TypeBinding r0 = (org.eclipse.jdt.internal.compiler.lookup.TypeBinding) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.getIsOnCooldown():boolean");
        }

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('problemReporter' org.eclipse.jdt.internal.compiler.problem.ProblemReporter)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('recType' org.eclipse.jdt.internal.compiler.lookup.TypeBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0015: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('params' org.eclipse.jdt.internal.compiler.lookup.TypeBinding[])])
        , block:B:2:0x0000 */
        /* renamed from: component11 */
        public static int getMaxFileSizeMB() {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.ExtensionMethod.ERROR_NO_METHOD_FOR
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4
                r2 = r1
                r3 = 2
                r4 = r8
                r2[r3] = r4
                r2 = r1
                r3 = 3
                r4 = r9
                r2[r3] = r4
                void r0 = android.app.AlarmManager.set(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.getMaxFileSizeMB():int");
        }

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('problemReporter' org.eclipse.jdt.internal.compiler.problem.ProblemReporter)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('method' org.eclipse.jdt.internal.compiler.lookup.MethodBinding)])
        , block:B:2:0x0000 */
        /* renamed from: component12 */
        public static boolean getShouldShowFollow() {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.ExtensionMethod.INVALID_METHOD
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4
                r2 = r1
                r3 = 2
                r4 = r8
                r2[r3] = r4
                void r0 = android.app.AlarmManager.set(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.getShouldShowFollow():boolean");
        }

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('problemReporter' org.eclipse.jdt.internal.compiler.problem.ProblemReporter)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('method' org.eclipse.jdt.internal.compiler.lookup.MethodBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0015: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('scope' org.eclipse.jdt.internal.compiler.lookup.Scope)])
        , block:B:2:0x0000 */
        /* renamed from: component13 */
        public static com.discord.widgets.chat.input.ChatInputViewModel.ViewState.Loaded.PendingReplyState getPendingReplyState() {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.ExtensionMethod.INVALID_METHOD2
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4
                r2 = r1
                r3 = 2
                r4 = r8
                r2[r3] = r4
                r2 = r1
                r3 = 3
                r4 = r9
                r2[r3] = r4
                void r0 = android.app.AlarmManager.set(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.getPendingReplyState():com.discord.widgets.chat.input.ChatInputViewModel$ViewState$Loaded$PendingReplyState");
        }

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('problemReporter' org.eclipse.jdt.internal.compiler.problem.ProblemReporter)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('location' org.eclipse.jdt.internal.compiler.ast.ASTNode)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('method' org.eclipse.jdt.internal.compiler.lookup.MethodBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0015: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* renamed from: component14 */
        public static boolean getShouldBadgeChatInput() {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.ExtensionMethod.NON_STATIC_ACCESS_TO_STATIC_METHOD
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4
                r2 = r1
                r3 = 2
                r4 = r8
                r2[r3] = r4
                r2 = r1
                r3 = 3
                r4 = r9
                r2[r3] = r4
                void r0 = android.app.AlarmManager.set(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.getShouldBadgeChatInput():boolean");
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$Javadoc.SCL.lombok */
    public static final class Javadoc {
        private static final Method GET_HTML = null;
        private static final Method PRINT_METHOD = null;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
            */
        public Javadoc(d0.e0.p.d.m0.g.FqName r3, d0.e0.p.d.m0.g.Name r4) {
            /*
                r2 = this;
                r0 = r2
                super/*android.animation.ObjectAnimator*/.setEvaluator(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Javadoc.shouldCreateClass(d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.e):boolean");
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.reflect.Method, void] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.reflect.Method, void] */
        static Collection getAllContributedClassesIfPossible(FqName fqName) {
            Animator.setDuration("lombok.eclipse.agent.PatchJavadoc");
            Class[] clsArr = {String.class, IJavaElement.class};
            GET_HTML = AnimatorSet.end();
            Class[] clsArr2 = {AbstractMethodDeclaration.class, Integer.class, StringBuffer.class, TypeDeclaration.class};
            PRINT_METHOD = AnimatorSet.end();
            return;
        }

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Failed to calculate best type for var: r1v1 ??
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayPutListener(TypeUpdate.java:609)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:156)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:133)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:238)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
         */
        /* JADX WARN: Failed to calculate best type for var: r1v1 ??
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.arrayPutListener(TypeUpdate.java:609)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
         */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('original' java.lang.String)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('member' org.eclipse.jdt.core.IJavaElement)]), block:B:2:0x0000 */
        static {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.Javadoc.GET_HTML
                r1 = 2
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                r2[r3] = r4
                android.animation.PropertyValuesHolder r0 = android.animation.PropertyValuesHolder.clone()
                java.lang.String r0 = (java.lang.String) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Javadoc.m270clinit():void");
        }

        /*  JADX ERROR: Types fix failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
            */
        /* JADX WARN: Failed to apply debug info
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnoreUnknown(TypeUpdate.java:74)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
         */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0014: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('output' java.lang.StringBuffer)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0018: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('type' org.eclipse.jdt.internal.compiler.ast.TypeDeclaration)])
        , block:B:2:0x0000 */
        /* renamed from: <init>, reason: not valid java name */
        public static void m271init(java.lang.String r6, int r7) {
            /*
                java.lang.reflect.Method r0 = lombok.launch.PatchFixesHider.Javadoc.PRINT_METHOD
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r6
                r2[r3] = r4
                r2 = r1
                r3 = 1
                r4 = r7
                void r4 = android.animation.ValueAnimator.cancel()
                r2[r3] = r4
                r2 = r1
                r3 = 2
                r4 = r8
                r2[r3] = r4
                r2 = r1
                r3 = 3
                r4 = r9
                r2[r3] = r4
                android.animation.PropertyValuesHolder r0 = android.animation.PropertyValuesHolder.clone()
                java.lang.StringBuffer r0 = (java.lang.StringBuffer) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Javadoc.m271init(java.lang.String, int):void");
        }
    }

    /* loaded from: discord:Class50/lombok/launch/PatchFixesHider$PatchFixes.SCL.lombok */
    public static final class PatchFixes {
        public static final int ALREADY_PROCESSED_FLAG = 8388608;

        public static boolean isGenerated(ASTNode node) {
            boolean result = false;
            try {
                result = ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
                if (!result && node.getParent() != null && (node.getParent() instanceof QualifiedName)) {
                    result = isGenerated(node.getParent());
                }
            } catch (Exception unused) {
            }
            return result;
        }

        public static boolean isGenerated(org.eclipse.jdt.internal.compiler.ast.ASTNode node) {
            boolean result = false;
            try {
                result = node.getClass().getField("$generatedBy").get(node) != null;
            } catch (Exception unused) {
            }
            return result;
        }

        public static boolean isListRewriteOnGeneratedNode(ListRewrite rewrite) {
            return isGenerated(rewrite.getParent());
        }

        public static boolean returnFalse(Object object) {
            return false;
        }

        public static boolean returnTrue(Object object) {
            return true;
        }

        public static List removeGeneratedNodes(List list) {
            try {
                List realNodes = new ArrayList(list.size());
                for (Object node : list) {
                    if (!isGenerated((ASTNode) node)) {
                        realNodes.add(node);
                    }
                }
                return realNodes;
            } catch (Exception unused) {
                return list;
            }
        }

        public static String getRealMethodDeclarationSource(String original, Object processor, MethodDeclaration declaration) throws Exception {
            if (!isGenerated((ASTNode) declaration)) {
                return original;
            }
            List<Annotation> annotations = new ArrayList<>();
            for (Object modifier : declaration.modifiers()) {
                if (modifier instanceof Annotation) {
                    Annotation annotation = (Annotation) modifier;
                    String qualifiedAnnotationName = annotation.resolveTypeBinding().getQualifiedName();
                    if (!"java.lang.Override".equals(qualifiedAnnotationName) && !"java.lang.SuppressWarnings".equals(qualifiedAnnotationName)) {
                        annotations.add(annotation);
                    }
                }
            }
            StringBuilder signature = new StringBuilder();
            addAnnotations(annotations, signature);
            if (((Boolean) processor.getClass().getDeclaredField("fPublic").get(processor)).booleanValue()) {
                signature.append("public ");
            }
            if (((Boolean) processor.getClass().getDeclaredField("fAbstract").get(processor)).booleanValue()) {
                signature.append("abstract ");
            }
            signature.append(declaration.getReturnType2().toString()).append(" ").append(declaration.getName().getFullyQualifiedName()).append("(");
            boolean first = true;
            for (Object parameter : declaration.parameters()) {
                if (!first) {
                    signature.append(", ");
                }
                first = false;
                signature.append(parameter);
            }
            signature.append(");");
            return signature.toString();
        }

        public static void addAnnotations(List<Annotation> annotations, StringBuilder signature) {
            Iterator<Annotation> it = annotations.iterator();
            while (it.hasNext()) {
                SingleMemberAnnotation singleMemberAnnotation = (Annotation) it.next();
                List<String> values = new ArrayList<>();
                if (singleMemberAnnotation.isSingleMemberAnnotation()) {
                    SingleMemberAnnotation smAnn = singleMemberAnnotation;
                    values.add(smAnn.getValue().toString());
                } else if (singleMemberAnnotation.isNormalAnnotation()) {
                    NormalAnnotation normalAnn = (NormalAnnotation) singleMemberAnnotation;
                    for (Object value : normalAnn.values()) {
                        values.add(value.toString());
                    }
                }
                signature.append("@").append(singleMemberAnnotation.resolveTypeBinding().getQualifiedName());
                if (!values.isEmpty()) {
                    signature.append("(");
                    boolean first = true;
                    for (String string : values) {
                        if (!first) {
                            signature.append(", ");
                        }
                        first = false;
                        signature.append('\"').append(string).append('\"');
                    }
                    signature.append(")");
                }
                signature.append(" ");
            }
        }

        public static MethodDeclaration getRealMethodDeclarationNode(IMethod sourceMethod, CompilationUnit cuUnit) throws JavaModelException {
            AbstractTypeDeclaration typeDeclaration;
            MethodDeclaration methodDeclarationNode = ASTNodeSearchUtil.getMethodDeclarationNode(sourceMethod, cuUnit);
            if (isGenerated((ASTNode) methodDeclarationNode)) {
                Stack<IType> typeStack = new Stack<>();
                for (IType declaringType = sourceMethod.getDeclaringType(); declaringType != null; declaringType = declaringType.getDeclaringType()) {
                    typeStack.push(declaringType);
                }
                IType rootType = typeStack.pop();
                AbstractTypeDeclaration abstractTypeDeclarationFindTypeDeclaration = findTypeDeclaration(rootType, cuUnit.types());
                while (true) {
                    typeDeclaration = abstractTypeDeclarationFindTypeDeclaration;
                    if (typeStack.isEmpty() || typeDeclaration == null) {
                        break;
                    }
                    abstractTypeDeclarationFindTypeDeclaration = findTypeDeclaration(typeStack.pop(), typeDeclaration.bodyDeclarations());
                }
                if (typeStack.isEmpty() && typeDeclaration != null) {
                    String methodName = sourceMethod.getElementName();
                    for (Object declaration : typeDeclaration.bodyDeclarations()) {
                        if (declaration instanceof MethodDeclaration) {
                            MethodDeclaration methodDeclaration = (MethodDeclaration) declaration;
                            if (methodDeclaration.getName().toString().equals(methodName)) {
                                return methodDeclaration;
                            }
                        }
                    }
                }
            }
            return methodDeclarationNode;
        }

        public static AbstractTypeDeclaration findTypeDeclaration(IType searchType, List<?> nodes) {
            for (Object object : nodes) {
                if (object instanceof AbstractTypeDeclaration) {
                    AbstractTypeDeclaration typeDeclaration = (AbstractTypeDeclaration) object;
                    if (typeDeclaration.getName().toString().equals(searchType.getElementName())) {
                        return typeDeclaration;
                    }
                }
            }
            return null;
        }

        public static int getSourceEndFixed(int sourceEnd, org.eclipse.jdt.internal.compiler.ast.ASTNode node) throws Exception {
            org.eclipse.jdt.internal.compiler.ast.ASTNode object;
            if (sourceEnd == -1 && (object = (org.eclipse.jdt.internal.compiler.ast.ASTNode) node.getClass().getField("$generatedBy").get(node)) != null) {
                return object.sourceEnd;
            }
            return sourceEnd;
        }

        public static int fixRetrieveStartingCatchPosition(int original, int start) {
            return original == -1 ? start : original;
        }

        public static int fixRetrieveIdentifierEndPosition(int original, int start, int end) {
            if (original != -1 && original >= start) {
                return original;
            }
            return end;
        }

        public static int fixRetrieveEllipsisStartPosition(int original, int end) {
            return original == -1 ? end : original;
        }

        public static int fixRetrieveStartBlockPosition(int original, int start) {
            return original == -1 ? start : original;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int original, int end) {
            return original == -1 ? end : original;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, AbstractMethodDeclaration amd) {
            if (retVal != -1 || amd == null) {
                return retVal;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(amd) != null;
            if (isGenerated) {
                return amd.declarationSourceEnd;
            }
            return -1;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, FieldDeclaration fd) {
            if (retVal != -1 || fd == null) {
                return retVal;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(fd) != null;
            if (isGenerated) {
                return fd.declarationSourceEnd;
            }
            return -1;
        }

        public static int fixRetrieveProperRightBracketPosition(int retVal, Type type) {
            if (retVal != -1 || type == null) {
                return retVal;
            }
            if (isGenerated((ASTNode) type)) {
                return (type.getStartPosition() + type.getLength()) - 1;
            }
            return -1;
        }

        public static boolean checkBit24(Object node) throws Exception {
            int bits = ((Integer) node.getClass().getField("bits").get(node)).intValue();
            return (bits & 8388608) != 0;
        }

        public static boolean skipRewritingGeneratedNodes(ASTNode node) throws Exception {
            return ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
        }

        public static void setIsGeneratedFlag(ASTNode domNode, org.eclipse.jdt.internal.compiler.ast.ASTNode internalNode) throws Exception {
            if (internalNode == null || domNode == null) {
                return;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(internalNode) != null;
            if (isGenerated) {
                domNode.getClass().getField("$isGenerated").set(domNode, true);
            }
        }

        public static void setIsGeneratedFlagForName(Name name, Object internalNode) throws Exception {
            if (internalNode instanceof org.eclipse.jdt.internal.compiler.ast.ASTNode) {
                boolean isGenerated = EcjAugments.ASTNode_generatedBy.get((org.eclipse.jdt.internal.compiler.ast.ASTNode) internalNode) != null;
                if (isGenerated) {
                    name.getClass().getField("$isGenerated").set(name, true);
                }
            }
        }

        public static RewriteEvent[] listRewriteHandleGeneratedMethods(RewriteEvent parent) {
            RewriteEvent[] children = parent.getChildren();
            List<RewriteEvent> newChildren = new ArrayList<>();
            List<RewriteEvent> modifiedChildren = new ArrayList<>();
            for (RewriteEvent child : children) {
                boolean isGenerated = isGenerated((ASTNode) child.getOriginalValue());
                if (isGenerated) {
                    boolean isReplacedOrRemoved = child.getChangeKind() == 4 || child.getChangeKind() == 2;
                    boolean convertingFromMethod = child.getOriginalValue() instanceof MethodDeclaration;
                    if (isReplacedOrRemoved && convertingFromMethod && child.getNewValue() != null) {
                        modifiedChildren.add(new NodeRewriteEvent((Object) null, child.getNewValue()));
                    }
                } else {
                    newChildren.add(child);
                }
            }
            newChildren.addAll(modifiedChildren);
            return (RewriteEvent[]) newChildren.toArray(new RewriteEvent[0]);
        }

        public static int getTokenEndOffsetFixed(TokenScanner scanner, int token, int startOffset, Object domNode) throws CoreException {
            boolean isGenerated = false;
            try {
                isGenerated = ((Boolean) domNode.getClass().getField("$isGenerated").get(domNode)).booleanValue();
            } catch (Exception unused) {
            }
            if (isGenerated) {
                return -1;
            }
            return scanner.getTokenEndOffset(token, startOffset);
        }

        public static IMethod[] removeGeneratedMethods(IMethod[] methods) throws Exception {
            List<IMethod> result = new ArrayList<>();
            for (IMethod m : methods) {
                if (m.getNameRange().getLength() > 0 && !m.getNameRange().equals(m.getSourceRange())) {
                    result.add(m);
                }
            }
            return result.size() == methods.length ? methods : (IMethod[]) result.toArray(new IMethod[0]);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static SearchMatch[] removeGenerated(SearchMatch[] returnValue) {
            List<SearchMatch> result = new ArrayList<>();
            for (SearchMatch searchResult : returnValue) {
                if (searchResult.getElement() instanceof IField) {
                    IField field = (IField) searchResult.getElement();
                    IAnnotation annotation = field.getAnnotation("Generated");
                    if (annotation == null) {
                        result.add(searchResult);
                    }
                }
            }
            return (SearchMatch[]) result.toArray(new SearchMatch[0]);
        }

        public static SearchResultGroup[] createFakeSearchResult(SearchResultGroup[] returnValue, Object processor) throws Exception {
            Field declaredField;
            if ((returnValue == null || returnValue.length == 0) && (declaredField = processor.getClass().getDeclaredField("fField")) != null) {
                declaredField.setAccessible(true);
                SourceField fField = (SourceField) declaredField.get(processor);
                IAnnotation dataAnnotation = fField.getDeclaringType().getAnnotation("Data");
                if (dataAnnotation != null) {
                    return new SearchResultGroup[]{new SearchResultGroup((IResource) null, new SearchMatch[1])};
                }
            }
            return returnValue;
        }

        public static SimpleName[] removeGeneratedSimpleNames(SimpleName[] in) throws Exception {
            Field f = SimpleName.class.getField("$isGenerated");
            int count = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == null || !((Boolean) f.get(in[i])).booleanValue()) {
                    count++;
                }
            }
            if (count == in.length) {
                return in;
            }
            SimpleName[] newSimpleNames = new SimpleName[count];
            int count2 = 0;
            for (int i2 = 0; i2 < in.length; i2++) {
                if (in[i2] == null || !((Boolean) f.get(in[i2])).booleanValue()) {
                    int i3 = count2;
                    count2++;
                    newSimpleNames[i3] = in[i2];
                }
            }
            return newSimpleNames;
        }

        public static org.eclipse.jdt.internal.compiler.ast.Annotation[] convertAnnotations(org.eclipse.jdt.internal.compiler.ast.Annotation[] out, IAnnotatable annotatable) {
            try {
                IAnnotation[] in = annotatable.getAnnotations();
                if (out == null) {
                    return null;
                }
                int toWrite = 0;
                for (int idx = 0; idx < out.length; idx++) {
                    String oName = new String(out[idx].type.getLastToken());
                    boolean found = false;
                    int length = in.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        IAnnotation i2 = in[i];
                        String name = i2.getElementName();
                        int li = name.lastIndexOf(46);
                        if (li > -1) {
                            name = name.substring(li + 1);
                        }
                        if (!name.equals(oName)) {
                            i++;
                        } else {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        toWrite++;
                    } else {
                        out[idx] = null;
                    }
                }
                org.eclipse.jdt.internal.compiler.ast.Annotation[] replace = out;
                if (toWrite < out.length) {
                    replace = new org.eclipse.jdt.internal.compiler.ast.Annotation[toWrite];
                    int idx2 = 0;
                    for (int i3 = 0; i3 < out.length; i3++) {
                        if (out[i3] != null) {
                            int i4 = idx2;
                            idx2++;
                            replace[i4] = out[i3];
                        }
                    }
                }
                return replace;
            } catch (Exception unused) {
                return out;
            }
        }
    }
}
