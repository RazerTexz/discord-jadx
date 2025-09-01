package lombok.eclipse.handlers;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Data;
import lombok.Getter;
import lombok.Lombok;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.LombokImmutableList;
import lombok.core.LombokNode;
import lombok.core.TypeResolver;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.core.configuration.NullAnnotationLibrary;
import lombok.core.configuration.NullCheckExceptionType;
import lombok.core.configuration.TypeName;
import lombok.core.debug.ProblemReporter;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EcjAugments;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAST;
import lombok.eclipse.EclipseNode;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;
import lombok.permit.Permit;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ExtendedStringLiteral;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.FloatLiteral;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.Literal;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.StringLiteralConcatenation;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.core.CompilationUnit;

/* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil.SCL.lombok */
public class EclipseHandlerUtil {
    private static final int MODIFIERS_INDICATING_STATIC = 16904;
    private static final Constructor<CastExpression> castExpressionConstructor;
    private static final boolean castExpressionConstructorIsTypeRefBased;
    private static final Constructor<IntLiteral> intLiteralConstructor;
    private static final Method intLiteralFactoryMethod;
    private static Boolean eclipseMode;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$AccessLevel;
    private static final Annotation[] EMPTY_ANNOTATIONS_ARRAY = new Annotation[0];
    private static final char[] OBJECT_SIG = "Ljava/lang/Object;".toCharArray();
    static final char[] ALL = "all".toCharArray();
    static final char[] UNCHECKED = "unchecked".toCharArray();
    private static final char[] JUSTIFICATION = "justification".toCharArray();
    private static final char[] GENERATED_CODE = "generated code".toCharArray();
    private static final char[] LOMBOK = "lombok".toCharArray();
    private static final char[][] JAVAX_ANNOTATION_GENERATED = Eclipse.fromQualifiedName("javax.annotation.Generated");
    private static final char[][] LOMBOK_GENERATED = Eclipse.fromQualifiedName("lombok.Generated");
    private static final char[][] EDU_UMD_CS_FINDBUGS_ANNOTATIONS_SUPPRESSFBWARNINGS = Eclipse.fromQualifiedName("edu.umd.cs.findbugs.annotations.SuppressFBWarnings");

    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$MemberExistsResult.SCL.lombok */
    public enum MemberExistsResult {
        NOT_EXISTS,
        EXISTS_BY_LOMBOK,
        EXISTS_BY_USER;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static MemberExistsResult[] valuesCustom() {
            MemberExistsResult[] memberExistsResultArrValuesCustom = values();
            int length = memberExistsResultArrValuesCustom.length;
            MemberExistsResult[] memberExistsResultArr = new MemberExistsResult[length];
            System.arraycopy(memberExistsResultArrValuesCustom, 0, memberExistsResultArr, 0, length);
            return memberExistsResultArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$AccessLevel() {
        int[] iArr = $SWITCH_TABLE$lombok$AccessLevel;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AccessLevel.values().length];
        try {
            iArr2[AccessLevel.MODULE.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AccessLevel.NONE.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AccessLevel.PACKAGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AccessLevel.PRIVATE.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AccessLevel.PROTECTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AccessLevel.PUBLIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$lombok$AccessLevel = iArr2;
        return iArr2;
    }

    private EclipseHandlerUtil() {
    }

    public static void error(CompilationUnitDeclaration cud, String message, Throwable ex) {
        ProblemReporter.error(message, ex);
        if (cud != null) {
            EclipseAST.addProblemToCompilationResult(cud.getFileName(), cud.compilationResult, false, String.valueOf(message) + " - See error log.", 0, 0);
        }
    }

    public static void warning(String message, Throwable ex) {
        ProblemReporter.warning(message, ex);
    }

    public static ASTNode getGeneratedBy(ASTNode node) {
        return EcjAugments.ASTNode_generatedBy.get(node);
    }

    public static boolean isGenerated(ASTNode node) {
        return getGeneratedBy(node) != null;
    }

    public static <T extends ASTNode> T setGeneratedBy(T node, ASTNode source) {
        EcjAugments.ASTNode_generatedBy.set(node, source);
        return node;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [char[], char[][]] */
    public static MarkerAnnotation generateDeprecatedAnnotation(ASTNode source) {
        QualifiedTypeReference qtr = new QualifiedTypeReference((char[][]) new char[]{new char[]{'j', 'a', 'v', 'a'}, new char[]{'l', 'a', 'n', 'g'}, new char[]{'D', 'e', 'p', 'r', 'e', 'c', 'a', 't', 'e', 'd'}}, Eclipse.poss(source, 3));
        setGeneratedBy(qtr, source);
        MarkerAnnotation ma = new MarkerAnnotation(qtr, source.sourceStart);
        ma.sourceStart = 1;
        setGeneratedBy(ma, source);
        return ma;
    }

    public static MarkerAnnotation generateNamedAnnotation(ASTNode source, String typeName) {
        char[][] cc = Eclipse.fromQualifiedName(typeName);
        QualifiedTypeReference qtr = new QualifiedTypeReference(cc, Eclipse.poss(source, cc.length));
        setGeneratedBy(qtr, source);
        MarkerAnnotation ma = new MarkerAnnotation(qtr, source.sourceStart);
        ma.sourceStart = 1;
        setGeneratedBy(ma, source);
        return ma;
    }

    public static boolean isFieldDeprecated(EclipseNode fieldNode) {
        if (!(fieldNode.get() instanceof FieldDeclaration)) {
            return false;
        }
        FieldDeclaration field = fieldNode.get();
        if ((field.modifiers & 1048576) != 0) {
            return true;
        }
        if (field.annotations == null) {
            return false;
        }
        for (Annotation annotation : field.annotations) {
            if (typeMatches((Class<?>) Deprecated.class, fieldNode, annotation.type)) {
                return true;
            }
        }
        return false;
    }

    public static CheckerFrameworkVersion getCheckerFrameworkVersion(EclipseNode node) {
        CheckerFrameworkVersion cfv = (CheckerFrameworkVersion) node.getAst().readConfiguration(ConfigurationKeys.CHECKER_FRAMEWORK);
        return cfv != null ? cfv : CheckerFrameworkVersion.NONE;
    }

    public static boolean typeMatches(Class<?> type, EclipseNode node, TypeReference typeRef) {
        return typeMatches(type.getName(), node, typeRef);
    }

    public static boolean typeMatches(String type, EclipseNode node, TypeReference typeRef) {
        char[][] tn = typeRef == null ? null : typeRef.getTypeName();
        if (tn == null || tn.length == 0) {
            return false;
        }
        char[] lastPartA = tn[tn.length - 1];
        int lastIndex = Math.max(type.lastIndexOf(46), type.lastIndexOf(36)) + 1;
        if (lastPartA.length != type.length() - lastIndex) {
            return false;
        }
        for (int i = 0; i < lastPartA.length; i++) {
            if (lastPartA[i] != type.charAt(i + lastIndex)) {
                return false;
            }
        }
        String typeName = Eclipse.toQualifiedName(tn);
        TypeResolver resolver = node.getImportListAsTypeResolver();
        return resolver.typeMatches(node, type, typeName);
    }

    public static void sanityCheckForMethodGeneratingAnnotationsOnBuilderClass(EclipseNode typeNode, EclipseNode errorNode) {
        List<String> disallowed = null;
        Iterator<EclipseNode> it = typeNode.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION) {
                for (String annType : HandlerUtil.INVALID_ON_BUILDERS) {
                    if (annotationTypeMatches(annType, child)) {
                        if (disallowed == null) {
                            disallowed = new ArrayList<>();
                        }
                        int lastIndex = annType.lastIndexOf(46);
                        disallowed.add(lastIndex == -1 ? annType : annType.substring(lastIndex + 1));
                    }
                }
            }
        }
        int size = disallowed == null ? 0 : disallowed.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            errorNode.addError("@" + disallowed.get(0) + " is not allowed on builder classes.");
            return;
        }
        StringBuilder out = new StringBuilder();
        for (String a : disallowed) {
            out.append("@").append(a).append(", ");
        }
        out.setLength(out.length() - 2);
        errorNode.addError(out.append(" are not allowed on builder classes.").toString());
    }

    public static Annotation copyAnnotation(Annotation annotation, ASTNode source) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        if (annotation instanceof MarkerAnnotation) {
            MarkerAnnotation ann = new MarkerAnnotation(copyType(annotation.type, source), pS);
            setGeneratedBy(ann, source);
            ann.statementEnd = pE;
            ann.sourceEnd = pE;
            ann.declarationSourceEnd = pE;
            try {
                EclipseReflectiveMembers.reflectSet(EclipseReflectiveMembers.ANNOTATION__MEMBER_VALUE_PAIR_NAME, ann, EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.ANNOTATION__MEMBER_VALUE_PAIR_NAME, annotation));
            } catch (Exception unused) {
            }
            return ann;
        }
        if (annotation instanceof SingleMemberAnnotation) {
            SingleMemberAnnotation ann2 = new SingleMemberAnnotation(copyType(annotation.type, source), pS);
            setGeneratedBy(ann2, source);
            ann2.statementEnd = pE;
            ann2.sourceEnd = pE;
            ann2.declarationSourceEnd = pE;
            ann2.memberValue = copyAnnotationMemberValue(((SingleMemberAnnotation) annotation).memberValue);
            try {
                EclipseReflectiveMembers.reflectSet(EclipseReflectiveMembers.ANNOTATION__MEMBER_VALUE_PAIR_NAME, ann2, EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.ANNOTATION__MEMBER_VALUE_PAIR_NAME, annotation));
            } catch (Exception unused2) {
            }
            return ann2;
        }
        if (annotation instanceof NormalAnnotation) {
            NormalAnnotation ann3 = new NormalAnnotation(copyType(annotation.type, source), pS);
            setGeneratedBy(ann3, source);
            ann3.sourceEnd = pE;
            ann3.statementEnd = pE;
            ann3.declarationSourceEnd = pE;
            MemberValuePair[] inPairs = ((NormalAnnotation) annotation).memberValuePairs;
            if (inPairs == null) {
                ann3.memberValuePairs = null;
            } else {
                ann3.memberValuePairs = new MemberValuePair[inPairs.length];
                for (int i = 0; i < inPairs.length; i++) {
                    ann3.memberValuePairs[i] = new MemberValuePair(inPairs[i].name, inPairs[i].sourceStart, inPairs[i].sourceEnd, copyAnnotationMemberValue(inPairs[i].value));
                }
            }
            try {
                EclipseReflectiveMembers.reflectSet(EclipseReflectiveMembers.ANNOTATION__MEMBER_VALUE_PAIR_NAME, ann3, EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.ANNOTATION__MEMBER_VALUE_PAIR_NAME, annotation));
            } catch (Exception unused3) {
            }
            return ann3;
        }
        return annotation;
    }

    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$EclipseReflectiveMembers.SCL.lombok */
    static class EclipseReflectiveMembers {
        public static final Field STRING_LITERAL__LINE_NUMBER = getField(StringLiteral.class, "lineNumber");
        public static final Field ANNOTATION__MEMBER_VALUE_PAIR_NAME = getField(Annotation.class, "memberValuePairName");
        public static final Field TYPE_REFERENCE__ANNOTATIONS = getField(TypeReference.class, "annotations");
        public static final Class<?> INTERSECTION_BINDING1 = getClass("org.eclipse.jdt.internal.compiler.lookup.IntersectionTypeBinding18");
        public static final Class<?> INTERSECTION_BINDING2 = getClass("org.eclipse.jdt.internal.compiler.lookup.IntersectionCastTypeBinding");
        public static final Field INTERSECTION_BINDING_TYPES1;
        public static final Field INTERSECTION_BINDING_TYPES2;

        EclipseReflectiveMembers() {
        }

        static {
            INTERSECTION_BINDING_TYPES1 = INTERSECTION_BINDING1 == null ? null : getField(INTERSECTION_BINDING1, "intersectingTypes");
            INTERSECTION_BINDING_TYPES2 = INTERSECTION_BINDING2 == null ? null : getField(INTERSECTION_BINDING2, "intersectingTypes");
        }

        public static int reflectInt(Field f, Object o) {
            try {
                return ((Number) f.get(o)).intValue();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public static void reflectSet(Field f, Object o, Object v) throws IllegalAccessException, IllegalArgumentException {
            try {
                f.set(o, v);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public static Object reflect(Field f, Object o) {
            try {
                return f.get(o);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        private static Class<?> getClass(String fqn) {
            try {
                return Class.forName(fqn);
            } catch (Exception unused) {
                return null;
            }
        }

        private static Field getField(Class<?> c, String fName) {
            try {
                return Permit.getField(c, fName);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static Expression copyAnnotationMemberValue(Expression in) {
        Expression out = copyAnnotationMemberValue0(in);
        out.constant = in.constant;
        return out;
    }

    private static Expression copyAnnotationMemberValue0(Expression in) {
        int s2 = in.sourceStart;
        int e = in.sourceEnd;
        if (in instanceof FalseLiteral) {
            return new FalseLiteral(s2, e);
        }
        if (in instanceof TrueLiteral) {
            return new TrueLiteral(s2, e);
        }
        if (in instanceof NullLiteral) {
            return new NullLiteral(s2, e);
        }
        if (in instanceof CharLiteral) {
            return new CharLiteral(((Literal) in).source(), s2, e);
        }
        if (in instanceof DoubleLiteral) {
            return new DoubleLiteral(((Literal) in).source(), s2, e);
        }
        if (in instanceof FloatLiteral) {
            return new FloatLiteral(((Literal) in).source(), s2, e);
        }
        if (in instanceof IntLiteral) {
            return IntLiteral.buildIntLiteral(((Literal) in).source(), s2, e);
        }
        if (in instanceof LongLiteral) {
            return LongLiteral.buildLongLiteral(((Literal) in).source(), s2, e);
        }
        if (in instanceof StringLiteral) {
            return new StringLiteral(((Literal) in).source(), s2, e, EclipseReflectiveMembers.reflectInt(EclipseReflectiveMembers.STRING_LITERAL__LINE_NUMBER, in) + 1);
        }
        if (in instanceof ExtendedStringLiteral) {
            StringLiteral str = new StringLiteral(((Literal) in).source(), s2, e, EclipseReflectiveMembers.reflectInt(EclipseReflectiveMembers.STRING_LITERAL__LINE_NUMBER, in) + 1);
            StringLiteral empty = new StringLiteral(new char[0], s2, e, EclipseReflectiveMembers.reflectInt(EclipseReflectiveMembers.STRING_LITERAL__LINE_NUMBER, in) + 1);
            return new ExtendedStringLiteral(str, empty);
        }
        if (in instanceof StringLiteralConcatenation) {
            Expression[] literals = ((StringLiteralConcatenation) in).literals;
            if (literals.length == 0) {
                return new StringLiteral(new char[0], s2, e, 0);
            }
            if (literals.length == 1) {
                return copyAnnotationMemberValue0(literals[0]);
            }
            StringLiteralConcatenation c = new StringLiteralConcatenation((StringLiteral) literals[0], (StringLiteral) literals[1]);
            for (int i = 2; i < literals.length; i++) {
                c = c.extendsWith((StringLiteral) literals[i]);
            }
            return c;
        }
        if (in instanceof SingleNameReference) {
            SingleNameReference snr = (SingleNameReference) in;
            return new SingleNameReference(snr.token, Eclipse.pos(in));
        }
        if (in instanceof QualifiedNameReference) {
            QualifiedNameReference qnr = (QualifiedNameReference) in;
            return new QualifiedNameReference(qnr.tokens, Eclipse.poss(in, qnr.tokens.length), s2, e);
        }
        if (in instanceof ClassLiteralAccess) {
            return new ClassLiteralAccess(e, copyType(((ClassLiteralAccess) in).type));
        }
        if (in instanceof ArrayInitializer) {
            Expression[] exprs = ((ArrayInitializer) in).expressions;
            Expression[] copy = new Expression[exprs.length];
            for (int i2 = 0; i2 < exprs.length; i2++) {
                copy[i2] = copyAnnotationMemberValue(exprs[i2]);
            }
            ArrayInitializer out = new ArrayInitializer();
            out.sourceStart = s2;
            out.sourceEnd = e;
            out.bits = in.bits;
            out.implicitConversion = in.implicitConversion;
            out.statementEnd = e;
            out.expressions = copy;
            return out;
        }
        if (in instanceof BinaryExpression) {
            BinaryExpression be = (BinaryExpression) in;
            BinaryExpression out2 = new BinaryExpression(be);
            out2.left = copyAnnotationMemberValue(be.left);
            out2.right = copyAnnotationMemberValue(be.right);
            out2.sourceStart = s2;
            out2.sourceEnd = e;
            out2.statementEnd = e;
            return out2;
        }
        return in;
    }

    public static TypeParameter[] copyTypeParams(TypeParameter[] params, ASTNode source) {
        if (params == null) {
            return null;
        }
        TypeParameter[] out = new TypeParameter[params.length];
        int idx = 0;
        for (TypeParameter param : params) {
            TypeParameter o = new TypeParameter();
            setGeneratedBy(o, source);
            o.annotations = param.annotations;
            o.bits = param.bits;
            o.modifiers = param.modifiers;
            o.name = param.name;
            o.type = copyType(param.type, source);
            o.sourceStart = param.sourceStart;
            o.sourceEnd = param.sourceEnd;
            o.declarationEnd = param.declarationEnd;
            o.declarationSourceStart = param.declarationSourceStart;
            o.declarationSourceEnd = param.declarationSourceEnd;
            if (param.bounds != null) {
                TypeReference[] b2 = new TypeReference[param.bounds.length];
                int idx2 = 0;
                for (TypeReference ref : param.bounds) {
                    int i = idx2;
                    idx2++;
                    b2[i] = copyType(ref, source);
                }
                o.bounds = b2;
            }
            int i2 = idx;
            idx++;
            out[i2] = o;
        }
        return out;
    }

    public static Annotation[] getTypeUseAnnotations(TypeReference from) {
        try {
            Annotation[][] a = (Annotation[][]) EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.TYPE_REFERENCE__ANNOTATIONS, from);
            if (a == null) {
                return null;
            }
            Annotation[] b2 = a[a.length - 1];
            if (b2.length == 0) {
                return null;
            }
            return b2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void removeTypeUseAnnotations(TypeReference from) {
        try {
            EclipseReflectiveMembers.reflectSet(EclipseReflectiveMembers.TYPE_REFERENCE__ANNOTATIONS, from, null);
        } catch (Exception unused) {
        }
    }

    public static TypeReference namePlusTypeParamsToTypeReference(EclipseNode type, TypeParameter[] params, long p) {
        TypeDeclaration td = type.get();
        boolean instance = (td.modifiers & MODIFIERS_INDICATING_STATIC) == 0;
        return namePlusTypeParamsToTypeReference(type.up(), td.name, instance, params, p);
    }

    public static TypeReference namePlusTypeParamsToTypeReference(EclipseNode parentType, char[] typeName, boolean instance, TypeParameter[] params, long p) {
        if (params != null && params.length > 0) {
            TypeReference[] refs = new TypeReference[params.length];
            int idx = 0;
            for (TypeParameter param : params) {
                int i = idx;
                idx++;
                refs[i] = new SingleTypeReference(param.name, p);
            }
            return generateParameterizedTypeReference(parentType, typeName, instance, refs, p);
        }
        return generateTypeReference(parentType, typeName, instance, p);
    }

    public static TypeReference[] copyTypes(TypeReference[] refs) {
        return copyTypes(refs, null);
    }

    public static TypeReference[] copyTypes(TypeReference[] refs, ASTNode source) {
        if (refs == null) {
            return null;
        }
        TypeReference[] outs = new TypeReference[refs.length];
        int idx = 0;
        for (TypeReference ref : refs) {
            int i = idx;
            idx++;
            outs[i] = copyType(ref, source);
        }
        return outs;
    }

    public static TypeReference copyType(TypeReference ref) {
        return copyType(ref, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[]] */
    public static TypeReference copyType(TypeReference ref, ASTNode source) throws IllegalAccessException, IllegalArgumentException {
        if (ref instanceof ParameterizedQualifiedTypeReference) {
            ParameterizedQualifiedTypeReference iRef = (ParameterizedQualifiedTypeReference) ref;
            TypeReference[][] args = null;
            if (iRef.typeArguments != null) {
                args = new TypeReference[iRef.typeArguments.length];
                int idx = 0;
                for (TypeReference[] inRefArray : iRef.typeArguments) {
                    if (inRefArray == null) {
                        int i = idx;
                        idx++;
                        args[i] = null;
                    } else {
                        TypeReference[] outRefArray = new TypeReference[inRefArray.length];
                        int idx2 = 0;
                        for (TypeReference typeReference : inRefArray) {
                            int i2 = idx2;
                            idx2++;
                            outRefArray[i2] = copyType(typeReference, source);
                        }
                        int i3 = idx;
                        idx++;
                        args[i3] = outRefArray;
                    }
                }
            }
            ParameterizedQualifiedTypeReference parameterizedQualifiedTypeReference = new ParameterizedQualifiedTypeReference(iRef.tokens, args, iRef.dimensions(), copy(iRef.sourcePositions));
            copyTypeAnns(ref, parameterizedQualifiedTypeReference);
            if (source != null) {
                setGeneratedBy(parameterizedQualifiedTypeReference, source);
            }
            return parameterizedQualifiedTypeReference;
        }
        if (ref instanceof ArrayQualifiedTypeReference) {
            ArrayQualifiedTypeReference iRef2 = (ArrayQualifiedTypeReference) ref;
            ArrayQualifiedTypeReference arrayQualifiedTypeReference = new ArrayQualifiedTypeReference(iRef2.tokens, iRef2.dimensions(), copy(iRef2.sourcePositions));
            copyTypeAnns(ref, arrayQualifiedTypeReference);
            if (source != null) {
                setGeneratedBy(arrayQualifiedTypeReference, source);
            }
            return arrayQualifiedTypeReference;
        }
        if (ref instanceof QualifiedTypeReference) {
            QualifiedTypeReference iRef3 = (QualifiedTypeReference) ref;
            QualifiedTypeReference qualifiedTypeReference = new QualifiedTypeReference(iRef3.tokens, copy(iRef3.sourcePositions));
            copyTypeAnns(ref, qualifiedTypeReference);
            if (source != null) {
                setGeneratedBy(qualifiedTypeReference, source);
            }
            return qualifiedTypeReference;
        }
        if (ref instanceof ParameterizedSingleTypeReference) {
            ParameterizedSingleTypeReference iRef4 = (ParameterizedSingleTypeReference) ref;
            TypeReference[] args2 = null;
            if (iRef4.typeArguments != null) {
                args2 = new TypeReference[iRef4.typeArguments.length];
                int idx3 = 0;
                for (TypeReference inRef : iRef4.typeArguments) {
                    if (inRef == null) {
                        int i4 = idx3;
                        idx3++;
                        args2[i4] = null;
                    } else {
                        int i5 = idx3;
                        idx3++;
                        args2[i5] = copyType(inRef, source);
                    }
                }
            }
            ParameterizedSingleTypeReference parameterizedSingleTypeReference = new ParameterizedSingleTypeReference(iRef4.token, args2, iRef4.dimensions(), (iRef4.sourceStart << 32) | iRef4.sourceEnd);
            copyTypeAnns(ref, parameterizedSingleTypeReference);
            if (source != null) {
                setGeneratedBy(parameterizedSingleTypeReference, source);
            }
            return parameterizedSingleTypeReference;
        }
        if (ref instanceof ArrayTypeReference) {
            ArrayTypeReference iRef5 = (ArrayTypeReference) ref;
            ArrayTypeReference arrayTypeReference = new ArrayTypeReference(iRef5.token, iRef5.dimensions(), (iRef5.sourceStart << 32) | iRef5.sourceEnd);
            copyTypeAnns(ref, arrayTypeReference);
            if (source != null) {
                setGeneratedBy(arrayTypeReference, source);
            }
            return arrayTypeReference;
        }
        if (ref instanceof Wildcard) {
            Wildcard original = (Wildcard) ref;
            Wildcard wildcard = new Wildcard(original.kind);
            wildcard.sourceStart = original.sourceStart;
            wildcard.sourceEnd = original.sourceEnd;
            if (original.bound != null) {
                wildcard.bound = copyType(original.bound, source);
            }
            copyTypeAnns(ref, wildcard);
            if (source != null) {
                setGeneratedBy(wildcard, source);
            }
            return wildcard;
        }
        if (ref instanceof SingleTypeReference) {
            SingleTypeReference singleTypeReference = new SingleTypeReference(((SingleTypeReference) ref).token, (r0.sourceStart << 32) | r0.sourceEnd);
            copyTypeAnns(ref, singleTypeReference);
            if (source != null) {
                setGeneratedBy(singleTypeReference, source);
            }
            return singleTypeReference;
        }
        return ref;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void copyTypeAnns(TypeReference in, TypeReference out) throws IllegalAccessException, IllegalArgumentException {
        try {
            ASTNode[][] aSTNodeArr = (Annotation[][]) EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.TYPE_REFERENCE__ANNOTATIONS, in);
            if (aSTNodeArr == null) {
                EclipseReflectiveMembers.reflectSet(EclipseReflectiveMembers.TYPE_REFERENCE__ANNOTATIONS, out, null);
                return;
            }
            Annotation[] annotationArr = new Annotation[aSTNodeArr.length];
            for (int i = 0; i < aSTNodeArr.length; i++) {
                if (aSTNodeArr[i] != null) {
                    annotationArr[i] = new Annotation[aSTNodeArr[i].length];
                    for (int j = 0; j < aSTNodeArr[i].length; j++) {
                        annotationArr[i][j] = copyAnnotation(aSTNodeArr[i][j], aSTNodeArr[i][j]);
                    }
                }
            }
            EclipseReflectiveMembers.reflectSet(EclipseReflectiveMembers.TYPE_REFERENCE__ANNOTATIONS, out, annotationArr);
        } catch (Exception unused) {
        }
    }

    public static Annotation[] copyAnnotations(ASTNode source, Annotation[]... allAnnotations) {
        List<Annotation> result = null;
        for (Annotation[] annotations : allAnnotations) {
            if (annotations != null) {
                for (Annotation annotation : annotations) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(copyAnnotation(annotation, source));
                }
            }
        }
        if (result == null) {
            return null;
        }
        return (Annotation[]) result.toArray(new Annotation[0]);
    }

    public static boolean hasAnnotation(Class<? extends java.lang.annotation.Annotation> type, EclipseNode node) {
        if (node == null || type == null) {
            return false;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                Iterator<EclipseNode> it = node.down().iterator();
                while (it.hasNext()) {
                    EclipseNode child = it.next();
                    if (annotationTypeMatches(type, child)) {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    public static boolean hasAnnotation(String type, EclipseNode node) {
        if (node == null || type == null) {
            return false;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                Iterator<EclipseNode> it = node.down().iterator();
                while (it.hasNext()) {
                    EclipseNode child = it.next();
                    if (annotationTypeMatches(type, child)) {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    public static EclipseNode findInnerClass(EclipseNode parent, String name) {
        char[] c = name.toCharArray();
        Iterator<EclipseNode> it = parent.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.TYPE) {
                TypeDeclaration td = child.get();
                if (Arrays.equals(td.name, c)) {
                    return child;
                }
            }
        }
        return null;
    }

    public static EclipseNode findAnnotation(Class<? extends java.lang.annotation.Annotation> type, EclipseNode node) {
        if (node == null || type == null) {
            return null;
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[node.getKind().ordinal()]) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                Iterator<EclipseNode> it = node.down().iterator();
                while (it.hasNext()) {
                    EclipseNode child = it.next();
                    if (annotationTypeMatches(type, child)) {
                        break;
                    }
                }
                break;
        }
        return null;
    }

    public static String scanForNearestAnnotation(EclipseNode node, String... anns) {
        while (node != null) {
            Iterator<EclipseNode> it = node.down().iterator();
            while (it.hasNext()) {
                EclipseNode ann = it.next();
                if (ann.getKind() == AST.Kind.ANNOTATION) {
                    Annotation a = ann.get();
                    TypeReference aType = a.type;
                    for (String annToFind : anns) {
                        if (typeMatches(annToFind, node, aType)) {
                            return annToFind;
                        }
                    }
                }
            }
            node = node.up();
        }
        return null;
    }

    public static boolean hasNonNullAnnotations(EclipseNode node) {
        AbstractVariableDeclaration avd = node.get();
        if (avd.annotations == null) {
            return false;
        }
        for (Annotation annotation : avd.annotations) {
            TypeReference typeRef = annotation.type;
            if (typeRef != null && typeRef.getTypeName() != null) {
                for (String bn : HandlerUtil.NONNULL_ANNOTATIONS) {
                    if (typeMatches(bn, node, typeRef)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasNonNullAnnotations(EclipseNode node, List<Annotation> anns) {
        if (anns == null) {
            return false;
        }
        for (Annotation annotation : anns) {
            TypeReference typeRef = annotation.type;
            if (typeRef != null && typeRef.getTypeName() != null) {
                for (String bn : HandlerUtil.NONNULL_ANNOTATIONS) {
                    if (typeMatches(bn, node, typeRef)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static {
        Constructor<CastExpression> constructor = null;
        for (Constructor<CastExpression> constructor2 : CastExpression.class.getConstructors()) {
            if (constructor2.getParameterTypes().length == 2) {
                constructor = constructor2;
            }
        }
        Constructor<CastExpression> castExpressionConstructor_ = constructor;
        castExpressionConstructor = castExpressionConstructor_;
        castExpressionConstructorIsTypeRefBased = castExpressionConstructor.getParameterTypes()[1] == TypeReference.class;
        Class[] parameterTypes = {char[].class, Integer.TYPE, Integer.TYPE};
        Constructor<IntLiteral> intLiteralConstructor_ = null;
        Method intLiteralFactoryMethod_ = null;
        try {
            intLiteralConstructor_ = Permit.getConstructor(IntLiteral.class, parameterTypes);
        } catch (Throwable unused) {
        }
        try {
            intLiteralFactoryMethod_ = Permit.getMethod(IntLiteral.class, "buildIntLiteral", parameterTypes);
        } catch (Throwable unused2) {
        }
        intLiteralConstructor = intLiteralConstructor_;
        intLiteralFactoryMethod = intLiteralFactoryMethod_;
    }

    public static Annotation[] findCopyableAnnotations(EclipseNode node) {
        AbstractVariableDeclaration avd = node.get();
        if (avd.annotations == null) {
            return EMPTY_ANNOTATIONS_ARRAY;
        }
        List<Annotation> result = new ArrayList<>();
        List<TypeName> configuredCopyable = (List) node.getAst().readConfiguration(ConfigurationKeys.COPYABLE_ANNOTATIONS);
        for (Annotation annotation : avd.annotations) {
            TypeReference typeRef = annotation.type;
            boolean match = false;
            if (typeRef != null && typeRef.getTypeName() != null) {
                Iterator<TypeName> it = configuredCopyable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TypeName cn = it.next();
                    if (cn != null && typeMatches(cn.toString(), node, typeRef)) {
                        result.add(annotation);
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    Iterator<String> it2 = HandlerUtil.BASE_COPYABLE_ANNOTATIONS.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        String bn = it2.next();
                        if (typeMatches(bn, node, typeRef)) {
                            result.add(annotation);
                            break;
                        }
                    }
                }
            }
        }
        return (Annotation[]) result.toArray(EMPTY_ANNOTATIONS_ARRAY);
    }

    public static Annotation[] findCopyableToSetterAnnotations(EclipseNode node) {
        return findAnnotationsInList(node, HandlerUtil.COPY_TO_SETTER_ANNOTATIONS);
    }

    public static Annotation[] findCopyableToBuilderSingularSetterAnnotations(EclipseNode node) {
        return findAnnotationsInList(node, HandlerUtil.COPY_TO_BUILDER_SINGULAR_SETTER_ANNOTATIONS);
    }

    private static Annotation[] findAnnotationsInList(EclipseNode node, List<String> annotationsToFind) {
        AbstractVariableDeclaration avd = node.get();
        if (avd.annotations == null) {
            return EMPTY_ANNOTATIONS_ARRAY;
        }
        List<Annotation> result = new ArrayList<>();
        for (Annotation annotation : avd.annotations) {
            TypeReference typeRef = annotation.type;
            if (typeRef != null && typeRef.getTypeName() != null) {
                Iterator<String> it = annotationsToFind.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String bn = it.next();
                    if (typeMatches(bn, node, typeRef)) {
                        result.add(annotation);
                        break;
                    }
                }
            }
        }
        return (Annotation[]) result.toArray(EMPTY_ANNOTATIONS_ARRAY);
    }

    public static boolean annotationTypeMatches(Class<? extends java.lang.annotation.Annotation> type, EclipseNode node) {
        if (node.getKind() != AST.Kind.ANNOTATION) {
            return false;
        }
        return typeMatches(type, node, node.get().type);
    }

    public static boolean annotationTypeMatches(String type, EclipseNode node) {
        if (node.getKind() != AST.Kind.ANNOTATION) {
            return false;
        }
        return typeMatches(type, node, node.get().type);
    }

    public static TypeReference cloneSelfType(EclipseNode context) {
        return cloneSelfType(context, null);
    }

    public static TypeReference cloneSelfType(EclipseNode context, ASTNode source) {
        int pS = source == null ? 0 : source.sourceStart;
        int pE = source == null ? 0 : source.sourceEnd;
        long p = (pS << 32) | pE;
        EclipseNode type = context;
        TypeReference result = null;
        while (type != null && type.getKind() != AST.Kind.TYPE) {
            type = type.up();
        }
        if (type != null && (type.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = type.get();
            if (typeDecl.typeParameters != null && typeDecl.typeParameters.length > 0) {
                TypeReference[] refs = new TypeReference[typeDecl.typeParameters.length];
                int idx = 0;
                for (TypeParameter param : typeDecl.typeParameters) {
                    SingleTypeReference singleTypeReference = new SingleTypeReference(param.name, (param.sourceStart << 32) | param.sourceEnd);
                    if (source != null) {
                        setGeneratedBy(singleTypeReference, source);
                    }
                    int i = idx;
                    idx++;
                    refs[i] = singleTypeReference;
                }
                result = generateParameterizedTypeReference(type, refs, p);
            } else {
                result = generateTypeReference(type, p);
            }
        }
        if (result != null && source != null) {
            setGeneratedBy(result, source);
        }
        return result;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    public static TypeReference generateParameterizedTypeReference(EclipseNode type, TypeReference[] typeParams, long p) {
        TypeDeclaration td = type.get();
        char[][] tn = getQualifiedInnerName(type.up(), td.name);
        if (tn.length == 1) {
            return new ParameterizedSingleTypeReference(tn[0], typeParams, 0, p);
        }
        int tnLen = tn.length;
        long[] ps = new long[tnLen];
        for (int i = 0; i < tnLen; i++) {
            ps[i] = p;
        }
        ?? r0 = new TypeReference[tnLen];
        r0[tnLen - 1] = typeParams;
        boolean instance = (td.modifiers & MODIFIERS_INDICATING_STATIC) == 0;
        if (instance) {
            fillOuterTypeParams(r0, tnLen - 2, type.up(), p);
        }
        return new ParameterizedQualifiedTypeReference(tn, (TypeReference[][]) r0, 0, ps);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    public static TypeReference generateParameterizedTypeReference(EclipseNode parent, char[] name, boolean instance, TypeReference[] typeParams, long p) {
        char[][] tn = getQualifiedInnerName(parent, name);
        if (tn.length == 1) {
            return new ParameterizedSingleTypeReference(tn[0], typeParams, 0, p);
        }
        int tnLen = tn.length;
        long[] ps = new long[tnLen];
        for (int i = 0; i < tnLen; i++) {
            ps[i] = p;
        }
        ?? r0 = new TypeReference[tnLen];
        r0[tnLen - 1] = typeParams;
        if (instance) {
            fillOuterTypeParams(r0, tnLen - 2, parent, p);
        }
        return new ParameterizedQualifiedTypeReference(tn, (TypeReference[][]) r0, 0, ps);
    }

    private static boolean fillOuterTypeParams(TypeReference[][] rr, int idx, EclipseNode node, long p) {
        if (idx < 0 || node == null || !(node.get() instanceof TypeDeclaration)) {
            return false;
        }
        boolean filled = false;
        TypeDeclaration td = node.get();
        if ((td.modifiers & 16896) != 0) {
            return false;
        }
        TypeParameter[] tps = td.typeParameters;
        if (tps != null && tps.length > 0) {
            TypeReference[] trs = new TypeReference[tps.length];
            for (int i = 0; i < tps.length; i++) {
                trs[i] = new SingleTypeReference(tps[i].name, p);
            }
            rr[idx] = trs;
            filled = true;
        }
        if ((td.modifiers & MODIFIERS_INDICATING_STATIC) != 0) {
            return filled;
        }
        boolean f2 = fillOuterTypeParams(rr, idx - 1, node.up(), p);
        return f2 || filled;
    }

    public static NameReference generateNameReference(EclipseNode type, long p) {
        char[][] tn = getQualifiedInnerName(type.up(), type.get().name);
        if (tn.length == 1) {
            return new SingleNameReference(tn[0], p);
        }
        int tnLen = tn.length;
        long[] ps = new long[tnLen];
        for (int i = 0; i < tnLen; i++) {
            ps[i] = p;
        }
        int ss = (int) (p >> 32);
        int se = (int) p;
        return new QualifiedNameReference(tn, ps, ss, se);
    }

    public static NameReference generateNameReference(EclipseNode parent, char[] name, long p) {
        char[][] tn = getQualifiedInnerName(parent, name);
        if (tn.length == 1) {
            return new SingleNameReference(tn[0], p);
        }
        int tnLen = tn.length;
        long[] ps = new long[tnLen];
        for (int i = 0; i < tnLen; i++) {
            ps[i] = p;
        }
        int ss = (int) (p >> 32);
        int se = (int) p;
        return new QualifiedNameReference(tn, ps, ss, se);
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    public static TypeReference generateTypeReference(EclipseNode type, long p) {
        TypeDeclaration td = type.get();
        char[][] tn = getQualifiedInnerName(type.up(), td.name);
        if (tn.length == 1) {
            return new SingleTypeReference(tn[0], p);
        }
        int tnLen = tn.length;
        long[] ps = new long[tnLen];
        for (int i = 0; i < tnLen; i++) {
            ps[i] = p;
        }
        boolean instance = (td.modifiers & MODIFIERS_INDICATING_STATIC) == 0 && type.up() != null && (type.up().get() instanceof TypeDeclaration);
        if (instance) {
            ?? r0 = new TypeReference[tn.length];
            boolean filled = fillOuterTypeParams(r0, r0.length - 2, type.up(), p);
            if (filled) {
                return new ParameterizedQualifiedTypeReference(tn, (TypeReference[][]) r0, 0, ps);
            }
        }
        return new QualifiedTypeReference(tn, ps);
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [org.eclipse.jdt.internal.compiler.ast.TypeReference[], org.eclipse.jdt.internal.compiler.ast.TypeReference[][]] */
    public static TypeReference generateTypeReference(EclipseNode parent, char[] name, boolean instance, long p) {
        char[][] tn = getQualifiedInnerName(parent, name);
        if (tn.length == 1) {
            return new SingleTypeReference(tn[0], p);
        }
        int tnLen = tn.length;
        long[] ps = new long[tnLen];
        for (int i = 0; i < tnLen; i++) {
            ps[i] = p;
        }
        if (instance && parent != null && (parent.get() instanceof TypeDeclaration)) {
            ?? r0 = new TypeReference[tn.length];
            if (fillOuterTypeParams(r0, tn.length - 2, parent, p)) {
                return new ParameterizedQualifiedTypeReference(tn, (TypeReference[][]) r0, 0, ps);
            }
        }
        return new QualifiedTypeReference(tn, ps);
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [char[], char[][]] */
    /* JADX WARN: Type inference failed for: r0v7, types: [char[], char[][]] */
    public static char[][] getQualifiedInnerName(EclipseNode parent, char[] name) {
        int count = 0;
        EclipseNode eclipseNodeUp = parent;
        while (true) {
            EclipseNode n = eclipseNodeUp;
            if (n == null || n.getKind() != AST.Kind.TYPE || !(n.get() instanceof TypeDeclaration)) {
                break;
            }
            TypeDeclaration td = n.get();
            if (td.name == null || td.name.length == 0) {
                break;
            }
            count++;
            eclipseNodeUp = n.up();
        }
        if (count == 0) {
            return new char[]{name};
        }
        ?? r0 = new char[count + 1];
        r0[count] = name;
        EclipseNode eclipseNodeUp2 = parent;
        while (true) {
            EclipseNode n2 = eclipseNodeUp2;
            if (n2 == null || n2.getKind() != AST.Kind.TYPE || !(n2.get() instanceof TypeDeclaration)) {
                break;
            }
            count--;
            r0[count] = n2.get().name;
            eclipseNodeUp2 = n2.up();
        }
        return r0;
    }

    private static int compare(char[] a, char[] b2) {
        if (a == null) {
            return b2 == null ? 0 : -1;
        }
        if (b2 == null) {
            return 1;
        }
        int len = Math.min(a.length, b2.length);
        for (int i = 0; i < len; i++) {
            if (a[i] < b2[i]) {
                return -1;
            }
            if (a[i] > b2[i]) {
                return 1;
            }
        }
        if (a.length < b2.length) {
            return -1;
        }
        return a.length > b2.length ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v105, types: [char[]] */
    /* JADX WARN: Type inference failed for: r0v274, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v53, types: [char[]] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r15v0 */
    public static TypeReference makeType(TypeBinding typeBinding, ASTNode aSTNode, boolean z2) {
        char[][] cArr;
        char c;
        TypeBinding[] typeBindingArr = null;
        if (typeBinding.getClass() == EclipseReflectiveMembers.INTERSECTION_BINDING1) {
            typeBindingArr = (Object[]) EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.INTERSECTION_BINDING_TYPES1, typeBinding);
        } else if (typeBinding.getClass() == EclipseReflectiveMembers.INTERSECTION_BINDING2) {
            typeBindingArr = (Object[]) EclipseReflectiveMembers.reflect(EclipseReflectiveMembers.INTERSECTION_BINDING_TYPES2, typeBinding);
        }
        if (typeBindingArr != null) {
            TypeBinding typeBinding2 = null;
            char c2 = 0;
            for (TypeBinding typeBinding3 : typeBindingArr) {
                if (typeBinding3 instanceof TypeBinding) {
                    TypeBinding typeBinding4 = typeBinding3;
                    if (typeBinding4.isArrayType()) {
                        c = 'd';
                    } else if (typeBinding4.isClass()) {
                        c = '2';
                    } else if (typeBinding4.isTypeVariable()) {
                        c = 20;
                    } else {
                        c = typeBinding4.isWildcard() ? (char) 15 : '\n';
                    }
                    if (c == '2' && compare(typeBinding4.signature(), OBJECT_SIG) == 0) {
                        c = 1;
                    }
                    if (c2 <= c) {
                        if (c2 < c) {
                            typeBinding2 = typeBinding4;
                            c2 = c;
                        } else if (compare(typeBinding2.signature(), typeBinding4.signature()) > 0) {
                            typeBinding2 = typeBinding4;
                        }
                    }
                }
            }
            typeBinding = typeBinding2;
        }
        int iDimensions = typeBinding.dimensions();
        ReferenceBinding referenceBindingLeafComponentType = typeBinding.leafComponentType();
        char[] cArr2 = null;
        switch (((TypeBinding) referenceBindingLeafComponentType).id) {
            case 2:
                cArr2 = TypeConstants.CHAR;
                break;
            case 3:
                cArr2 = TypeConstants.BYTE;
                break;
            case 4:
                cArr2 = TypeConstants.SHORT;
                break;
            case 5:
                cArr2 = TypeConstants.BOOLEAN;
                break;
            case 6:
                cArr2 = TypeConstants.VOID;
                break;
            case 7:
                cArr2 = TypeConstants.LONG;
                break;
            case 8:
                cArr2 = TypeConstants.DOUBLE;
                break;
            case 9:
                cArr2 = TypeConstants.FLOAT;
                break;
            case 10:
                cArr2 = TypeConstants.INT;
                break;
            case 12:
                return null;
        }
        if (cArr2 != null) {
            if (iDimensions > 0) {
                ArrayTypeReference arrayTypeReference = new ArrayTypeReference(cArr2, iDimensions, Eclipse.pos(aSTNode));
                setGeneratedBy(arrayTypeReference, aSTNode);
                return arrayTypeReference;
            }
            SingleTypeReference singleTypeReference = new SingleTypeReference(cArr2, Eclipse.pos(aSTNode));
            setGeneratedBy(singleTypeReference, aSTNode);
            return singleTypeReference;
        }
        if (referenceBindingLeafComponentType.isAnonymousType()) {
            ReferenceBinding referenceBinding = referenceBindingLeafComponentType;
            TypeBinding[] typeBindingArrSuperInterfaces = referenceBinding.superInterfaces();
            if (typeBindingArrSuperInterfaces == null || typeBindingArrSuperInterfaces.length == 0) {
                typeBindingArrSuperInterfaces = new ReferenceBinding[]{referenceBinding.superclass()};
            }
            if (typeBindingArrSuperInterfaces[0] == null) {
                QualifiedTypeReference qualifiedTypeReference = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(aSTNode, 3));
                setGeneratedBy(qualifiedTypeReference, aSTNode);
                return qualifiedTypeReference;
            }
            return makeType(typeBindingArrSuperInterfaces[0], aSTNode, false);
        }
        if (referenceBindingLeafComponentType instanceof CaptureBinding) {
            return makeType(((CaptureBinding) referenceBindingLeafComponentType).wildcard, aSTNode, z2);
        }
        if (referenceBindingLeafComponentType.isUnboundWildcard()) {
            if (!z2) {
                QualifiedTypeReference qualifiedTypeReference2 = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(aSTNode, 3));
                setGeneratedBy(qualifiedTypeReference2, aSTNode);
                return qualifiedTypeReference2;
            }
            Wildcard wildcard = new Wildcard(0);
            setGeneratedBy(wildcard, aSTNode);
            wildcard.sourceStart = aSTNode.sourceStart;
            wildcard.sourceEnd = aSTNode.sourceEnd;
            return wildcard;
        }
        if (referenceBindingLeafComponentType.isWildcard()) {
            WildcardBinding wildcardBinding = (WildcardBinding) referenceBindingLeafComponentType;
            if (wildcardBinding.boundKind == 1) {
                if (!z2) {
                    TypeBinding typeBinding5 = wildcardBinding.bound;
                    boolean z3 = typeBinding5.id == 1;
                    TypeBinding[] typeBindingArr2 = wildcardBinding.otherBounds;
                    if (z3 && typeBindingArr2 != null && typeBindingArr2.length > 0) {
                        return makeType(typeBindingArr2[0], aSTNode, false);
                    }
                    return makeType(typeBinding5, aSTNode, false);
                }
                Wildcard wildcard2 = new Wildcard(1);
                setGeneratedBy(wildcard2, aSTNode);
                wildcard2.bound = makeType(wildcardBinding.bound, aSTNode, false);
                wildcard2.sourceStart = aSTNode.sourceStart;
                wildcard2.sourceEnd = aSTNode.sourceEnd;
                return wildcard2;
            }
            if (z2 && wildcardBinding.boundKind == 2) {
                Wildcard wildcard3 = new Wildcard(2);
                setGeneratedBy(wildcard3, aSTNode);
                wildcard3.bound = makeType(wildcardBinding.bound, aSTNode, false);
                wildcard3.sourceStart = aSTNode.sourceStart;
                wildcard3.sourceEnd = aSTNode.sourceEnd;
                return wildcard3;
            }
            QualifiedTypeReference qualifiedTypeReference3 = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(aSTNode, 3));
            setGeneratedBy(qualifiedTypeReference3, aSTNode);
            return qualifiedTypeReference3;
        }
        ArrayList arrayList = new ArrayList();
        if (!(referenceBindingLeafComponentType instanceof RawTypeBinding)) {
            ReferenceBinding referenceBindingEnclosingType = referenceBindingLeafComponentType;
            while (true) {
                ReferenceBinding referenceBinding2 = referenceBindingEnclosingType;
                boolean z4 = referenceBinding2.isLocalType() || !referenceBinding2.isMemberType() || referenceBinding2.enclosingType() == null;
                TypeReference[] typeReferenceArr = null;
                if (referenceBinding2 instanceof ParameterizedTypeBinding) {
                    ParameterizedTypeBinding parameterizedTypeBinding = (ParameterizedTypeBinding) referenceBinding2;
                    if (parameterizedTypeBinding.arguments != null) {
                        typeReferenceArr = new TypeReference[parameterizedTypeBinding.arguments.length];
                        for (int i = 0; i < typeReferenceArr.length; i++) {
                            typeReferenceArr[i] = makeType(parameterizedTypeBinding.arguments[i], aSTNode, true);
                        }
                    }
                }
                arrayList.add(typeReferenceArr);
                if (!z4) {
                    referenceBindingEnclosingType = referenceBinding2.enclosingType();
                }
            }
        }
        if (referenceBindingLeafComponentType.isTypeVariable()) {
            cArr = new char[]{referenceBindingLeafComponentType.shortReadableName()};
        } else if (referenceBindingLeafComponentType.isLocalType()) {
            cArr = new char[]{referenceBindingLeafComponentType.sourceName()};
        } else {
            String[] strArrSplit = new String(referenceBindingLeafComponentType.qualifiedPackageName()).split("\\.");
            String[] strArrSplit2 = new String(referenceBindingLeafComponentType.qualifiedSourceName()).split("\\.");
            if (strArrSplit.length == 1 && strArrSplit[0].isEmpty()) {
                strArrSplit = new String[0];
            }
            ?? r15 = new char[strArrSplit.length + strArrSplit2.length];
            int i2 = 0;
            while (i2 < strArrSplit.length) {
                r15[i2] = strArrSplit[i2].toCharArray();
                i2++;
            }
            while (true) {
                cArr = r15;
                if (i2 < strArrSplit.length + strArrSplit2.length) {
                    r15[i2] = strArrSplit2[i2 - strArrSplit.length].toCharArray();
                    i2++;
                }
            }
        }
        while (arrayList.size() < cArr.length) {
            arrayList.add(null);
        }
        Collections.reverse(arrayList);
        boolean z5 = false;
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((TypeReference[]) it.next()) != null) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            if (cArr.length > 1) {
                ParameterizedQualifiedTypeReference parameterizedQualifiedTypeReference = new ParameterizedQualifiedTypeReference(cArr, (TypeReference[][]) arrayList.toArray(new TypeReference[0]), iDimensions, Eclipse.poss(aSTNode, cArr.length));
                setGeneratedBy(parameterizedQualifiedTypeReference, aSTNode);
                return parameterizedQualifiedTypeReference;
            }
            ParameterizedSingleTypeReference parameterizedSingleTypeReference = new ParameterizedSingleTypeReference(cArr[0], (TypeReference[]) arrayList.get(0), iDimensions, Eclipse.pos(aSTNode));
            setGeneratedBy(parameterizedSingleTypeReference, aSTNode);
            return parameterizedSingleTypeReference;
        }
        if (iDimensions > 0) {
            if (cArr.length > 1) {
                ArrayQualifiedTypeReference arrayQualifiedTypeReference = new ArrayQualifiedTypeReference(cArr, iDimensions, Eclipse.poss(aSTNode, cArr.length));
                setGeneratedBy(arrayQualifiedTypeReference, aSTNode);
                return arrayQualifiedTypeReference;
            }
            ArrayTypeReference arrayTypeReference2 = new ArrayTypeReference(cArr[0], iDimensions, Eclipse.pos(aSTNode));
            setGeneratedBy(arrayTypeReference2, aSTNode);
            return arrayTypeReference2;
        }
        if (cArr.length > 1) {
            QualifiedTypeReference qualifiedTypeReference4 = new QualifiedTypeReference(cArr, Eclipse.poss(aSTNode, cArr.length));
            setGeneratedBy(qualifiedTypeReference4, aSTNode);
            return qualifiedTypeReference4;
        }
        SingleTypeReference singleTypeReference2 = new SingleTypeReference(cArr[0], Eclipse.pos(aSTNode));
        setGeneratedBy(singleTypeReference2, aSTNode);
        return singleTypeReference2;
    }

    public static <A extends java.lang.annotation.Annotation> AnnotationValues<A> createAnnotation(Class<A> type, EclipseNode annotationNode) throws SecurityException {
        Annotation annotation = annotationNode.get();
        Map<String, AnnotationValues.AnnotationValue> values = new HashMap<>();
        MemberValuePair[] memberValuePairs = annotation.memberValuePairs();
        if (memberValuePairs != null) {
            for (MemberValuePair pair : memberValuePairs) {
                List<String> raws = new ArrayList<>();
                List<Object> expressionValues = new ArrayList<>();
                List<Object> guesses = new ArrayList<>();
                Expression[] expressions = null;
                char[] n = pair.name;
                String mName = (n == null || n.length == 0) ? "value" : new String(pair.name);
                ArrayInitializer arrayInitializer = pair.value;
                if (arrayInitializer instanceof ArrayInitializer) {
                    expressions = arrayInitializer.expressions;
                } else if (arrayInitializer != null) {
                    expressions = new Expression[]{arrayInitializer};
                }
                if (expressions != null) {
                    for (Expression ex : expressions) {
                        StringBuffer sb = new StringBuffer();
                        ex.print(0, sb);
                        raws.add(sb.toString());
                        expressionValues.add(ex);
                        guesses.add(Eclipse.calculateValue(ex));
                    }
                }
                Expression[] exprs = expressions;
                values.put(mName, new AnonymousClass1(annotationNode, raws, expressionValues, guesses, true, arrayInitializer, exprs, annotation, annotationNode));
            }
        }
        for (Method m : type.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) {
                String name = m.getName();
                if (!values.containsKey(name)) {
                    values.put(name, new AnonymousClass2(annotationNode, new ArrayList(), new ArrayList(), new ArrayList(), false, annotationNode));
                }
            }
        }
        return new AnnotationValues<>(type, values, annotationNode);
    }

    /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$1, reason: invalid class name */
    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$1.SCL.lombok */
    class AnonymousClass1 extends AnnotationValues.AnnotationValue {
        private final /* synthetic */ Expression val$rhs;
        private final /* synthetic */ Expression[] val$exprs;
        private final /* synthetic */ Annotation val$annotation;
        private final /* synthetic */ EclipseNode val$annotationNode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LombokNode lombokNode, List list, List list2, List list3, boolean $anonymous4, Expression expression, Expression[] expressionArr, Annotation annotation, EclipseNode eclipseNode) {
            super(lombokNode, list, list2, list3, $anonymous4);
            this.val$rhs = expression;
            this.val$exprs = expressionArr;
            this.val$annotation = annotation;
            this.val$annotationNode = eclipseNode;
        }

        @Override // lombok.core.AnnotationValues.AnnotationValue
        public void setError(String message, int valueIdx) {
            Expression ex;
            if (valueIdx == -1) {
                ex = this.val$rhs;
            } else {
                ex = this.val$exprs != null ? this.val$exprs[valueIdx] : null;
            }
            if (ex == null) {
                ex = this.val$annotation;
            }
            int sourceStart = ex.sourceStart;
            int sourceEnd = ex.sourceEnd;
            this.val$annotationNode.addError(message, sourceStart, sourceEnd);
        }

        @Override // lombok.core.AnnotationValues.AnnotationValue
        public void setWarning(String message, int valueIdx) {
            Expression ex;
            if (valueIdx == -1) {
                ex = this.val$rhs;
            } else {
                ex = this.val$exprs != null ? this.val$exprs[valueIdx] : null;
            }
            if (ex == null) {
                ex = this.val$annotation;
            }
            int sourceStart = ex.sourceStart;
            int sourceEnd = ex.sourceEnd;
            this.val$annotationNode.addWarning(message, sourceStart, sourceEnd);
        }
    }

    /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$2, reason: invalid class name */
    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$2.SCL.lombok */
    class AnonymousClass2 extends AnnotationValues.AnnotationValue {
        private final /* synthetic */ EclipseNode val$annotationNode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LombokNode lombokNode, List list, List list2, List list3, boolean $anonymous4, EclipseNode eclipseNode) {
            super(lombokNode, list, list2, list3, $anonymous4);
            this.val$annotationNode = eclipseNode;
        }

        @Override // lombok.core.AnnotationValues.AnnotationValue
        public void setError(String message, int valueIdx) {
            this.val$annotationNode.addError(message);
        }

        @Override // lombok.core.AnnotationValues.AnnotationValue
        public void setWarning(String message, int valueIdx) {
            this.val$annotationNode.addWarning(message);
        }
    }

    public static int toEclipseModifier(AccessLevel value) {
        switch ($SWITCH_TABLE$lombok$AccessLevel()[value.ordinal()]) {
            case 1:
            default:
                return 1;
            case 2:
            case 4:
                return 0;
            case 3:
                return 4;
            case 5:
            case 6:
                return 2;
        }
    }

    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$GetterMethod.SCL.lombok */
    private static class GetterMethod {
        private final char[] name;
        private final TypeReference type;

        static /* synthetic */ char[] access$1(GetterMethod getterMethod) {
            return getterMethod.name;
        }

        static /* synthetic */ TypeReference access$0(GetterMethod getterMethod) {
            return getterMethod.type;
        }

        GetterMethod(char[] name, TypeReference type) {
            this.name = name;
            this.type = type;
        }
    }

    static void registerCreatedLazyGetter(FieldDeclaration field, char[] methodName, TypeReference returnType) {
        if (isBoolean(returnType)) {
            EcjAugments.FieldDeclaration_booleanLazyGetter.set(field, true);
        }
    }

    public static boolean isBoolean(TypeReference typeReference) {
        return Eclipse.nameEquals(typeReference.getTypeName(), "boolean") && typeReference.dimensions() == 0;
    }

    private static GetterMethod findGetter(EclipseNode field) throws SecurityException {
        String getterName;
        EclipseNode containingType;
        FieldDeclaration fieldDeclaration = field.get();
        boolean forceBool = EcjAugments.FieldDeclaration_booleanLazyGetter.get(fieldDeclaration).booleanValue();
        TypeReference fieldType = fieldDeclaration.type;
        boolean isBoolean = forceBool || isBoolean(fieldType);
        EclipseNode typeNode = field.up();
        for (String potentialGetterName : toAllGetterNames(field, isBoolean)) {
            Iterator<EclipseNode> it = typeNode.down().iterator();
            while (it.hasNext()) {
                EclipseNode potentialGetter = it.next();
                if (potentialGetter.getKind() == AST.Kind.METHOD && (potentialGetter.get() instanceof MethodDeclaration)) {
                    MethodDeclaration method = potentialGetter.get();
                    if (potentialGetterName.equalsIgnoreCase(new String(method.selector)) && (method.modifiers & 8) == 0 && (method.arguments == null || method.arguments.length <= 0)) {
                        return new GetterMethod(method.selector, method.returnType);
                    }
                }
            }
        }
        boolean hasGetterAnnotation = false;
        Iterator<EclipseNode> it2 = field.down().iterator();
        while (it2.hasNext()) {
            EclipseNode child = it2.next();
            if (child.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Getter.class, child)) {
                AnnotationValues<Getter> ann = createAnnotation(Getter.class, child);
                if (ann.getInstance().value() == AccessLevel.NONE) {
                    return null;
                }
                hasGetterAnnotation = true;
            }
        }
        if (!hasGetterAnnotation && HandleGetter.fieldQualifiesForGetterGeneration(field) && (containingType = field.up()) != null) {
            Iterator<EclipseNode> it3 = containingType.down().iterator();
            while (it3.hasNext()) {
                EclipseNode child2 = it3.next();
                if (child2.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Data.class, child2)) {
                    hasGetterAnnotation = true;
                }
                if (child2.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Getter.class, child2)) {
                    AnnotationValues<Getter> ann2 = createAnnotation(Getter.class, child2);
                    if (ann2.getInstance().value() == AccessLevel.NONE) {
                        return null;
                    }
                    hasGetterAnnotation = true;
                }
            }
        }
        if (!hasGetterAnnotation || (getterName = toGetterName(field, isBoolean)) == null) {
            return null;
        }
        return new GetterMethod(getterName.toCharArray(), fieldType);
    }

    static boolean lookForGetter(EclipseNode field, HandlerUtil.FieldAccess fieldAccess) throws SecurityException {
        if (fieldAccess == HandlerUtil.FieldAccess.GETTER) {
            return true;
        }
        if (fieldAccess == HandlerUtil.FieldAccess.ALWAYS_FIELD) {
            return false;
        }
        Iterator<EclipseNode> it = field.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (child.getKind() == AST.Kind.ANNOTATION && annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Getter.class, child)) {
                AnnotationValues<Getter> ann = createAnnotation(Getter.class, child);
                if (ann.getInstance().lazy()) {
                    return true;
                }
            }
        }
        return false;
    }

    static TypeReference getFieldType(EclipseNode field, HandlerUtil.FieldAccess fieldAccess) throws SecurityException {
        if (field.get() instanceof MethodDeclaration) {
            return field.get().returnType;
        }
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        if (getter == null) {
            return field.get().type;
        }
        return GetterMethod.access$0(getter);
    }

    static Expression createFieldAccessor(EclipseNode field, HandlerUtil.FieldAccess fieldAccess, ASTNode source) throws SecurityException {
        int pS = source == null ? 0 : source.sourceStart;
        int pE = source == null ? 0 : source.sourceEnd;
        long p = (pS << 32) | pE;
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        if (getter == null) {
            FieldDeclaration fieldDecl = field.get();
            FieldReference ref = new FieldReference(fieldDecl.name, p);
            if ((fieldDecl.modifiers & 8) != 0) {
                EclipseNode containerNode = field.up();
                if (containerNode != null && (containerNode.get() instanceof TypeDeclaration)) {
                    ref.receiver = new SingleNameReference(containerNode.get().name, p);
                } else {
                    FieldReference fieldReference = new FieldReference(field.getName().toCharArray(), p);
                    if (source != null) {
                        setGeneratedBy(fieldReference, source);
                    }
                    return fieldReference;
                }
            } else {
                ref.receiver = new ThisReference(pS, pE);
            }
            if (source != null) {
                setGeneratedBy(ref, source);
                setGeneratedBy(ref.receiver, source);
            }
            return ref;
        }
        MessageSend call = new MessageSend();
        setGeneratedBy(call, source);
        call.sourceStart = pS;
        call.sourceEnd = pE;
        call.statementEnd = pE;
        call.receiver = new ThisReference(pS, pE);
        setGeneratedBy(call.receiver, source);
        call.selector = GetterMethod.access$1(getter);
        return call;
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [char[], char[][]] */
    static Expression createFieldAccessor(EclipseNode field, HandlerUtil.FieldAccess fieldAccess, ASTNode source, char[] receiver) throws SecurityException {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        boolean lookForGetter = lookForGetter(field, fieldAccess);
        GetterMethod getter = lookForGetter ? findGetter(field) : null;
        if (getter == null) {
            long[] poss = {p, p};
            QualifiedNameReference qualifiedNameReference = new QualifiedNameReference((char[][]) new char[]{receiver, field.getName().toCharArray()}, poss, pS, pE);
            setGeneratedBy(qualifiedNameReference, source);
            return qualifiedNameReference;
        }
        MessageSend call = new MessageSend();
        setGeneratedBy(call, source);
        call.sourceStart = pS;
        call.sourceEnd = pE;
        call.statementEnd = pE;
        call.receiver = new SingleNameReference(receiver, p);
        setGeneratedBy(call.receiver, source);
        call.selector = GetterMethod.access$1(getter);
        return call;
    }

    static Expression createMethodAccessor(EclipseNode method, ASTNode source) {
        int pS = source == null ? 0 : source.sourceStart;
        int pE = source == null ? 0 : source.sourceEnd;
        long p = (pS << 32) | pE;
        MethodDeclaration methodDecl = method.get();
        MessageSend call = new MessageSend();
        setGeneratedBy(call, source);
        call.sourceStart = pS;
        call.sourceEnd = pE;
        call.statementEnd = pE;
        if ((methodDecl.modifiers & 8) == 0) {
            call.receiver = new ThisReference(pS, pE);
            setGeneratedBy(call.receiver, source);
        } else {
            EclipseNode containerNode = method.up();
            if (containerNode != null && (containerNode.get() instanceof TypeDeclaration)) {
                call.receiver = new SingleNameReference(containerNode.get().name, p);
                setGeneratedBy(call.receiver, source);
            }
        }
        call.selector = methodDecl.selector;
        return call;
    }

    static Expression createMethodAccessor(EclipseNode method, ASTNode source, char[] receiver) {
        int pS = source == null ? 0 : source.sourceStart;
        int pE = source == null ? 0 : source.sourceEnd;
        long p = (pS << 32) | pE;
        MethodDeclaration methodDecl = method.get();
        MessageSend call = new MessageSend();
        setGeneratedBy(call, source);
        call.sourceStart = pS;
        call.sourceEnd = pE;
        call.statementEnd = pE;
        call.receiver = new SingleNameReference(receiver, p);
        setGeneratedBy(call.receiver, source);
        call.selector = methodDecl.selector;
        return call;
    }

    public static List<String> toAllGetterNames(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toAllGetterNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static String toGetterName(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toGetterName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static List<String> toAllSetterNames(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toAllSetterNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static String toSetterName(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toSetterName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static List<String> toAllWithNames(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toAllWithNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static List<String> toAllWithByNames(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toAllWithByNames(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static String toWithName(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toWithName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static String toWithByName(EclipseNode field, boolean isBoolean) {
        return HandlerUtil.toWithByName(field.getAst(), getAccessorsForField(field), field.getName(), isBoolean);
    }

    public static boolean shouldReturnThis(EclipseNode field) {
        if ((field.get().modifiers & 8) != 0) {
            return false;
        }
        AnnotationValues<Accessors> accessors = getAccessorsForField(field);
        return HandlerUtil.shouldReturnThis0(accessors, field.getAst());
    }

    public static boolean filterField(FieldDeclaration declaration) {
        return filterField(declaration, true);
    }

    public static boolean filterField(FieldDeclaration declaration, boolean skipStatic) {
        if (((declaration.initialization instanceof AllocationExpression) && declaration.initialization.enumConstant != null) || declaration.type == null) {
            return false;
        }
        if (declaration.name.length <= 0 || declaration.name[0] != '$') {
            return !skipStatic || (declaration.modifiers & 8) == 0;
        }
        return false;
    }

    public static char[] removePrefixFromField(EclipseNode field) throws SecurityException {
        CharSequence newName;
        List<String> prefixes = null;
        Iterator<EclipseNode> it = field.down().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EclipseNode node = it.next();
            if (annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Accessors.class, node)) {
                AnnotationValues<Accessors> ann = createAnnotation(Accessors.class, node);
                if (ann.isExplicit("prefix")) {
                    prefixes = Arrays.asList(ann.getInstance().prefix());
                }
            }
        }
        if (prefixes == null) {
            EclipseNode eclipseNodeUp = field.up();
            while (true) {
                EclipseNode current = eclipseNodeUp;
                if (current == null) {
                    break;
                }
                Iterator<EclipseNode> it2 = current.down().iterator();
                while (it2.hasNext()) {
                    EclipseNode node2 = it2.next();
                    if (annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Accessors.class, node2)) {
                        AnnotationValues<Accessors> ann2 = createAnnotation(Accessors.class, node2);
                        if (ann2.isExplicit("prefix")) {
                            prefixes = Arrays.asList(ann2.getInstance().prefix());
                        }
                    }
                }
                eclipseNodeUp = current.up();
            }
        }
        if (prefixes == null) {
            prefixes = (List) field.getAst().readConfiguration(ConfigurationKeys.ACCESSORS_PREFIX);
        }
        return (prefixes.isEmpty() || (newName = HandlerUtil.removePrefix(field.getName(), prefixes)) == null) ? field.get().name : newName.toString().toCharArray();
    }

    public static AnnotationValues<Accessors> getAccessorsForField(EclipseNode field) {
        Iterator<EclipseNode> it = field.down().iterator();
        while (it.hasNext()) {
            EclipseNode node = it.next();
            if (annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Accessors.class, node)) {
                return createAnnotation(Accessors.class, node);
            }
        }
        EclipseNode eclipseNodeUp = field.up();
        while (true) {
            EclipseNode current = eclipseNodeUp;
            if (current != null) {
                Iterator<EclipseNode> it2 = current.down().iterator();
                while (it2.hasNext()) {
                    EclipseNode node2 = it2.next();
                    if (annotationTypeMatches((Class<? extends java.lang.annotation.Annotation>) Accessors.class, node2)) {
                        return createAnnotation(Accessors.class, node2);
                    }
                }
                eclipseNodeUp = current.up();
            } else {
                return AnnotationValues.of(Accessors.class, field);
            }
        }
    }

    public static EclipseNode upToTypeNode(EclipseNode node) {
        if (node == null) {
            throw new NullPointerException("node");
        }
        while (node != null && !(node.get() instanceof TypeDeclaration)) {
            node = node.up();
        }
        return node;
    }

    public static MemberExistsResult fieldExists(String fieldName, EclipseNode node) {
        EclipseNode node2 = upToTypeNode(node);
        char[] fieldNameChars = null;
        if (node2 != null && (node2.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = node2.get();
            if (typeDecl.fields != null) {
                for (FieldDeclaration def : typeDecl.fields) {
                    char[] fName = def.name;
                    if (fName != null) {
                        if (fieldNameChars == null) {
                            fieldNameChars = fieldName.toCharArray();
                        }
                        if (Arrays.equals(fName, fieldNameChars)) {
                            return getGeneratedBy(def) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                        }
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static MemberExistsResult methodExists(String methodName, EclipseNode node, int params) {
        return methodExists(methodName, node, true, params);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MemberExistsResult methodExists(String methodName, EclipseNode node, boolean caseSensitive, int params) {
        char[] mName;
        while (node != null && !(node.get() instanceof TypeDeclaration)) {
            node = node.up();
        }
        if (node != null && (node.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = node.get();
            if (typeDecl.methods != null) {
                for (AbstractMethodDeclaration def : typeDecl.methods) {
                    if ((def instanceof MethodDeclaration) && (mName = def.selector) != null) {
                        boolean nameEquals = caseSensitive ? methodName.equals(new String(mName)) : methodName.equalsIgnoreCase(new String(mName));
                        if (!nameEquals) {
                            continue;
                        } else if (params > -1) {
                            int minArgs = 0;
                            int maxArgs = 0;
                            if (def.arguments != null && def.arguments.length > 0) {
                                minArgs = def.arguments.length;
                                if ((def.arguments[def.arguments.length - 1].type.bits & 16384) != 0) {
                                    minArgs--;
                                    maxArgs = Integer.MAX_VALUE;
                                } else {
                                    maxArgs = minArgs;
                                }
                            }
                            if (params >= minArgs && params <= maxArgs) {
                                if (!isTolerate(node, def)) {
                                    return getGeneratedBy(def) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                                }
                            }
                        }
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static boolean isTolerate(EclipseNode node, AbstractMethodDeclaration def) {
        if (def.annotations != null) {
            for (Annotation anno : def.annotations) {
                if (typeMatches((Class<?>) Tolerate.class, node, anno.type)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static MemberExistsResult constructorExists(EclipseNode node) {
        EclipseNode node2 = upToTypeNode(node);
        if (node2 != null && (node2.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = node2.get();
            if (typeDecl.methods != null) {
                for (AbstractMethodDeclaration def : typeDecl.methods) {
                    if ((def instanceof ConstructorDeclaration) && (def.bits & 128) == 0 && !isTolerate(node2, def)) {
                        return getGeneratedBy(def) == null ? MemberExistsResult.EXISTS_BY_USER : MemberExistsResult.EXISTS_BY_LOMBOK;
                    }
                }
            }
        }
        return MemberExistsResult.NOT_EXISTS;
    }

    public static EclipseNode injectFieldAndMarkGenerated(EclipseNode type, FieldDeclaration field) {
        field.annotations = addSuppressWarningsAll(type, field, field.annotations);
        field.annotations = addGenerated(type, field, field.annotations);
        return injectField(type, field);
    }

    public static EclipseNode injectField(EclipseNode type, FieldDeclaration field) {
        TypeDeclaration parent = type.get();
        if (parent.fields == null) {
            parent.fields = new FieldDeclaration[1];
            parent.fields[0] = field;
        } else {
            int size = parent.fields.length;
            FieldDeclaration[] newArray = new FieldDeclaration[size + 1];
            System.arraycopy(parent.fields, 0, newArray, 0, size);
            int index = 0;
            while (index < size) {
                FieldDeclaration f = newArray[index];
                if (!isEnumConstant(f) && !isGenerated(f)) {
                    break;
                }
                index++;
            }
            System.arraycopy(newArray, index, newArray, index + 1, size - index);
            newArray[index] = field;
            parent.fields = newArray;
        }
        if ((isEnumConstant(field) || (field.modifiers & 8) != 0) && !Eclipse.hasClinit(parent)) {
            parent.addClinit();
        }
        return type.add(field, AST.Kind.FIELD);
    }

    public static boolean isEnumConstant(FieldDeclaration field) {
        return (field.initialization instanceof AllocationExpression) && field.initialization.enumConstant == field;
    }

    public static EclipseNode injectMethod(EclipseNode type, AbstractMethodDeclaration method) {
        method.annotations = addSuppressWarningsAll(type, method, method.annotations);
        method.annotations = addGenerated(type, method, method.annotations);
        TypeDeclaration parent = type.get();
        if (parent.methods == null) {
            parent.methods = new AbstractMethodDeclaration[1];
            parent.methods[0] = method;
        } else {
            if (method instanceof ConstructorDeclaration) {
                int i = 0;
                while (true) {
                    if (i >= parent.methods.length) {
                        break;
                    }
                    if (!(parent.methods[i] instanceof ConstructorDeclaration) || (parent.methods[i].bits & 128) == 0) {
                        i++;
                    } else {
                        EclipseNode tossMe = type.getNodeFor(parent.methods[i]);
                        AbstractMethodDeclaration[] withoutGeneratedConstructor = new AbstractMethodDeclaration[parent.methods.length - 1];
                        System.arraycopy(parent.methods, 0, withoutGeneratedConstructor, 0, i);
                        System.arraycopy(parent.methods, i + 1, withoutGeneratedConstructor, i, (parent.methods.length - i) - 1);
                        parent.methods = withoutGeneratedConstructor;
                        if (tossMe != null) {
                            tossMe.up().removeChild(tossMe);
                        }
                    }
                }
            }
            AbstractMethodDeclaration[] newArray = new AbstractMethodDeclaration[parent.methods.length + 1];
            System.arraycopy(parent.methods, 0, newArray, 0, parent.methods.length);
            newArray[parent.methods.length] = method;
            parent.methods = newArray;
        }
        return type.add(method, AST.Kind.METHOD);
    }

    public static EclipseNode injectType(EclipseNode typeNode, TypeDeclaration type) {
        type.annotations = addSuppressWarningsAll(typeNode, type, type.annotations);
        type.annotations = addGenerated(typeNode, type, type.annotations);
        TypeDeclaration parent = typeNode.get();
        if (parent.memberTypes == null) {
            parent.memberTypes = new TypeDeclaration[]{type};
        } else {
            TypeDeclaration[] newArray = new TypeDeclaration[parent.memberTypes.length + 1];
            System.arraycopy(parent.memberTypes, 0, newArray, 0, parent.memberTypes.length);
            newArray[parent.memberTypes.length] = type;
            parent.memberTypes = newArray;
        }
        return typeNode.add(type, AST.Kind.TYPE);
    }

    public static Annotation[] addSuppressWarningsAll(EclipseNode node, ASTNode source, Annotation[] originalAnnotationArray) {
        Annotation[] anns = originalAnnotationArray;
        if (!Boolean.FALSE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_SUPPRESSWARNINGS_ANNOTATIONS))) {
            anns = addAnnotation(source, anns, TypeConstants.JAVA_LANG_SUPPRESSWARNINGS, new StringLiteral(ALL, 0, 0, 0));
        }
        if (Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_FINDBUGS_SUPPRESSWARNINGS_ANNOTATIONS))) {
            anns = addAnnotation(source, anns, EDU_UMD_CS_FINDBUGS_ANNOTATIONS_SUPPRESSFBWARNINGS, new MemberValuePair(JUSTIFICATION, 0, 0, new StringLiteral(GENERATED_CODE, 0, 0, 0)));
        }
        return anns;
    }

    public static Annotation[] addGenerated(EclipseNode node, ASTNode source, Annotation[] originalAnnotationArray) {
        Annotation[] result = originalAnnotationArray;
        if (HandlerUtil.shouldAddGenerated(node)) {
            result = addAnnotation(source, result, JAVAX_ANNOTATION_GENERATED, new StringLiteral(LOMBOK, 0, 0, 0));
        }
        if (Boolean.TRUE.equals(node.getAst().readConfiguration(ConfigurationKeys.ADD_LOMBOK_GENERATED_ANNOTATIONS))) {
            result = addAnnotation(source, result, LOMBOK_GENERATED);
        }
        return result;
    }

    static Annotation[] addAnnotation(ASTNode source, Annotation[] originalAnnotationArray, char[][] annotationTypeFqn) {
        return addAnnotation(source, originalAnnotationArray, annotationTypeFqn, null);
    }

    static Annotation[] addAnnotation(ASTNode source, Annotation[] originalAnnotationArray, char[][] annotationTypeFqn, ASTNode... args) {
        SingleMemberAnnotation singleMemberAnnotation;
        char[] simpleName = annotationTypeFqn[annotationTypeFqn.length - 1];
        if (originalAnnotationArray != null) {
            for (Annotation ann : originalAnnotationArray) {
                if (ann.type instanceof QualifiedTypeReference) {
                    char[][] t = ann.type.tokens;
                    if (Arrays.deepEquals(t, annotationTypeFqn)) {
                        return originalAnnotationArray;
                    }
                }
                if (ann.type instanceof SingleTypeReference) {
                    char[] lastToken = ann.type.token;
                    if (Arrays.equals(lastToken, simpleName)) {
                        return originalAnnotationArray;
                    }
                }
            }
        }
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        long[] poss = new long[annotationTypeFqn.length];
        Arrays.fill(poss, p);
        QualifiedTypeReference qualifiedType = new QualifiedTypeReference(annotationTypeFqn, poss);
        setGeneratedBy(qualifiedType, source);
        if (args != null && args.length == 1 && (args[0] instanceof Expression)) {
            SingleMemberAnnotation sma = new SingleMemberAnnotation(qualifiedType, pS);
            sma.declarationSourceEnd = pE;
            args[0].sourceStart = pS;
            args[0].sourceEnd = pE;
            sma.memberValue = (Expression) args[0];
            setGeneratedBy(sma.memberValue, source);
            singleMemberAnnotation = sma;
        } else if (args != null && args.length >= 1 && arrayHasOnlyElementsOfType(args, MemberValuePair.class)) {
            SingleMemberAnnotation normalAnnotation = new NormalAnnotation(qualifiedType, pS);
            ((NormalAnnotation) normalAnnotation).declarationSourceEnd = pE;
            ((NormalAnnotation) normalAnnotation).memberValuePairs = new MemberValuePair[args.length];
            for (int i = 0; i < args.length; i++) {
                args[i].sourceStart = pS;
                args[i].sourceEnd = pE;
                ((NormalAnnotation) normalAnnotation).memberValuePairs[i] = (MemberValuePair) args[i];
            }
            setGeneratedBy(((NormalAnnotation) normalAnnotation).memberValuePairs[0], source);
            setGeneratedBy(((NormalAnnotation) normalAnnotation).memberValuePairs[0].value, source);
            ((NormalAnnotation) normalAnnotation).memberValuePairs[0].value.sourceStart = pS;
            ((NormalAnnotation) normalAnnotation).memberValuePairs[0].value.sourceEnd = pE;
            singleMemberAnnotation = normalAnnotation;
        } else {
            SingleMemberAnnotation markerAnnotation = new MarkerAnnotation(qualifiedType, pS);
            ((MarkerAnnotation) markerAnnotation).declarationSourceEnd = pE;
            singleMemberAnnotation = markerAnnotation;
        }
        setGeneratedBy(singleMemberAnnotation, source);
        if (originalAnnotationArray == null) {
            return new Annotation[]{singleMemberAnnotation};
        }
        Annotation[] newAnnotationArray = new Annotation[originalAnnotationArray.length + 1];
        System.arraycopy(originalAnnotationArray, 0, newAnnotationArray, 0, originalAnnotationArray.length);
        newAnnotationArray[originalAnnotationArray.length] = singleMemberAnnotation;
        return newAnnotationArray;
    }

    private static boolean arrayHasOnlyElementsOfType(Object[] array, Class<?> clazz) {
        for (Object element : array) {
            if (!clazz.isInstance(element)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v82, types: [char[], char[][]] */
    public static Statement generateNullCheck(TypeReference type, char[] variable, EclipseNode sourceNode, String customMessage) {
        NullCheckExceptionType exceptionType = (NullCheckExceptionType) sourceNode.getAst().readConfiguration(ConfigurationKeys.NON_NULL_EXCEPTION_TYPE);
        if (exceptionType == null) {
            exceptionType = NullCheckExceptionType.NULL_POINTER_EXCEPTION;
        }
        ASTNode source = sourceNode.get();
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        if (type != null && Eclipse.isPrimitive(type)) {
            return null;
        }
        Expression singleNameReference = new SingleNameReference(variable, p);
        setGeneratedBy(singleNameReference, source);
        Expression stringLiteral = new StringLiteral(exceptionType.toExceptionMessage(new String(variable), customMessage).toCharArray(), pS, pE, 0);
        setGeneratedBy(stringLiteral, source);
        LombokImmutableList<String> method = exceptionType.getMethod();
        if (method != null) {
            MessageSend invocation = new MessageSend();
            invocation.sourceStart = pS;
            invocation.sourceEnd = pE;
            setGeneratedBy(invocation, source);
            ?? r0 = new char[method.size() - 1];
            for (int i = 0; i < method.size() - 1; i++) {
                r0[i] = method.get(i).toCharArray();
            }
            invocation.receiver = new QualifiedNameReference((char[][]) r0, new long[method.size() - 1], pS, pE);
            setGeneratedBy(invocation.receiver, source);
            invocation.selector = method.get(method.size() - 1).toCharArray();
            invocation.arguments = new Expression[]{singleNameReference, stringLiteral};
            return invocation;
        }
        AllocationExpression exception = new AllocationExpression();
        setGeneratedBy(exception, source);
        NullLiteral nullLiteral = new NullLiteral(pS, pE);
        setGeneratedBy(nullLiteral, source);
        int equalOperator = exceptionType == NullCheckExceptionType.ASSERTION ? 29 : 18;
        EqualExpression equalExpression = new EqualExpression(singleNameReference, nullLiteral, equalOperator);
        equalExpression.sourceStart = pS;
        equalExpression.sourceEnd = pE;
        equalExpression.statementEnd = pE;
        setGeneratedBy(equalExpression, source);
        if (exceptionType == NullCheckExceptionType.ASSERTION) {
            AssertStatement assertStatement = new AssertStatement(stringLiteral, equalExpression, pS);
            setGeneratedBy(assertStatement, source);
            return assertStatement;
        }
        String exceptionTypeStr = exceptionType.getExceptionType();
        int partCount = 1;
        for (int i2 = 0; i2 < exceptionTypeStr.length(); i2++) {
            if (exceptionTypeStr.charAt(i2) == '.') {
                partCount++;
            }
        }
        long[] ps = new long[partCount];
        Arrays.fill(ps, 0L);
        exception.type = new QualifiedTypeReference(Eclipse.fromQualifiedName(exceptionTypeStr), ps);
        setGeneratedBy(exception.type, source);
        exception.arguments = new Expression[]{stringLiteral};
        Statement throwStatement = new ThrowStatement(exception, pS, pE);
        setGeneratedBy(throwStatement, source);
        Block throwBlock = new Block(0);
        throwBlock.statements = new Statement[]{throwStatement};
        throwBlock.sourceStart = pS;
        throwBlock.sourceEnd = pE;
        setGeneratedBy(throwBlock, source);
        IfStatement ifStatement = new IfStatement(equalExpression, throwBlock, 0, 0);
        setGeneratedBy(ifStatement, source);
        return ifStatement;
    }

    public static Statement generateNullCheck(AbstractVariableDeclaration variable, EclipseNode sourceNode, String customMessage) {
        return generateNullCheck(variable.type, variable.name, sourceNode, customMessage);
    }

    public static MarkerAnnotation makeMarkerAnnotation(char[][] name, ASTNode source) {
        long pos = (source.sourceStart << 32) | source.sourceEnd;
        long[] poss = new long[name.length];
        Arrays.fill(poss, pos);
        QualifiedTypeReference qualifiedTypeReference = new QualifiedTypeReference(name, poss);
        setGeneratedBy(qualifiedTypeReference, source);
        MarkerAnnotation ann = new MarkerAnnotation(qualifiedTypeReference, (int) (pos >> 32));
        int i = (int) pos;
        ann.statementEnd = i;
        ann.sourceEnd = i;
        ann.declarationSourceEnd = i;
        setGeneratedBy(ann, source);
        return ann;
    }

    public static List<Integer> createListOfNonExistentFields(List<String> list, EclipseNode type, boolean excludeStandard, boolean excludeTransient) {
        boolean[] matched = new boolean[list.size()];
        Iterator<EclipseNode> it = type.down().iterator();
        while (it.hasNext()) {
            EclipseNode child = it.next();
            if (list.isEmpty()) {
                break;
            }
            if (child.getKind() == AST.Kind.FIELD && (!excludeStandard || ((child.get().modifiers & 8) == 0 && !child.getName().startsWith("$")))) {
                if (!excludeTransient || (child.get().modifiers & 128) == 0) {
                    int idx = list.indexOf(child.getName());
                    if (idx > -1) {
                        matched[idx] = true;
                    }
                }
            }
        }
        List<Integer> problematic = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!matched[i]) {
                problematic.add(Integer.valueOf(i));
            }
        }
        return problematic;
    }

    public static CastExpression makeCastExpression(Expression ref, TypeReference castTo, ASTNode source) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        CastExpression result;
        try {
            if (castExpressionConstructorIsTypeRefBased) {
                result = castExpressionConstructor.newInstance(ref, castTo);
            } else {
                TypeReference qualifiedNameReference = castTo;
                if (castTo.getClass() == SingleTypeReference.class && !Eclipse.isPrimitive(castTo)) {
                    SingleTypeReference str = (SingleTypeReference) castTo;
                    qualifiedNameReference = new SingleNameReference(str.token, 0L);
                    ((Expression) qualifiedNameReference).bits = (((Expression) qualifiedNameReference).bits & (-4)) | 4;
                    ((Expression) qualifiedNameReference).sourceStart = str.sourceStart;
                    ((Expression) qualifiedNameReference).sourceEnd = str.sourceEnd;
                    setGeneratedBy(qualifiedNameReference, source);
                } else if (castTo.getClass() == QualifiedTypeReference.class) {
                    QualifiedTypeReference qtr = (QualifiedTypeReference) castTo;
                    qualifiedNameReference = new QualifiedNameReference(qtr.tokens, copy(qtr.sourcePositions), qtr.sourceStart, qtr.sourceEnd);
                    ((Expression) qualifiedNameReference).bits = (((Expression) qualifiedNameReference).bits & (-4)) | 4;
                    setGeneratedBy(qualifiedNameReference, source);
                }
                result = castExpressionConstructor.newInstance(ref, qualifiedNameReference);
            }
            result.sourceStart = source.sourceStart;
            result.sourceEnd = source.sourceEnd;
            result.statementEnd = source.sourceEnd;
            setGeneratedBy(result, source);
            return result;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw Lombok.sneakyThrow(e2);
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static IntLiteral makeIntLiteral(char[] token, ASTNode source) {
        int pS = source == null ? 0 : source.sourceStart;
        int pE = source == null ? 0 : source.sourceEnd;
        try {
            IntLiteral result = intLiteralConstructor != null ? intLiteralConstructor.newInstance(token, Integer.valueOf(pS), Integer.valueOf(pE)) : (IntLiteral) intLiteralFactoryMethod.invoke(null, token, Integer.valueOf(pS), Integer.valueOf(pE));
            if (source != null) {
                setGeneratedBy(result, source);
            }
            return result;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw Lombok.sneakyThrow(e2);
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    private static boolean isAllValidOnXCharacters(char[] in) {
        if (in == null || in.length == 0) {
            return false;
        }
        for (char c : in) {
            if (c != '_' && c != 'X' && c != 'x' && c != '$') {
                return false;
            }
        }
        return true;
    }

    public static void addError(String errorName, EclipseNode node) {
        if (node.getLatestJavaSpecSupported() < 8) {
            node.addError("The correct format is " + errorName + "_={@SomeAnnotation, @SomeOtherAnnotation})");
        } else {
            node.addError("The correct format is " + errorName + "=@__({@SomeAnnotation, @SomeOtherAnnotation}))");
        }
    }

    public static List<Annotation> unboxAndRemoveAnnotationParameter(Annotation annotation, String annotationName, String errorName, EclipseNode errorNode) {
        if ("value".equals(annotationName)) {
            throw new UnsupportedOperationException("Lombok cannot unbox 'value' from SingleMemberAnnotation at this time.");
        }
        if (!NormalAnnotation.class.equals(annotation.getClass())) {
            return Collections.emptyList();
        }
        NormalAnnotation normalAnnotation = (NormalAnnotation) annotation;
        MemberValuePair[] pairs = normalAnnotation.memberValuePairs;
        if (pairs == null) {
            return Collections.emptyList();
        }
        char[] nameAsCharArray = annotationName.toCharArray();
        for (int i = 0; i < pairs.length; i++) {
            char[] name = pairs[i].name;
            if (name != null && name.length >= nameAsCharArray.length) {
                int j = 0;
                while (true) {
                    if (j < nameAsCharArray.length) {
                        if (name[j] != nameAsCharArray[j]) {
                            break;
                        }
                        j++;
                    } else {
                        boolean allowRaw = name.length > nameAsCharArray.length;
                        for (int j2 = nameAsCharArray.length; j2 < name.length; j2++) {
                            if (name[j2] != '_') {
                                break;
                            }
                        }
                        Annotation annotation2 = pairs[i].value;
                        MemberValuePair[] newPairs = new MemberValuePair[pairs.length - 1];
                        if (i > 0) {
                            System.arraycopy(pairs, 0, newPairs, 0, i);
                        }
                        if (i < pairs.length - 1) {
                            System.arraycopy(pairs, i + 1, newPairs, i, (pairs.length - i) - 1);
                        }
                        normalAnnotation.memberValuePairs = newPairs;
                        Annotation annotation3 = null;
                        if (annotation2 instanceof ArrayInitializer) {
                            if (!allowRaw) {
                                addError(errorName, errorNode);
                                return Collections.emptyList();
                            }
                            annotation3 = annotation2;
                        } else {
                            if (!(annotation2 instanceof Annotation)) {
                                addError(errorName, errorNode);
                                return Collections.emptyList();
                            }
                            Annotation atDummyIdentifier = annotation2;
                            if ((atDummyIdentifier.type instanceof SingleTypeReference) && isAllValidOnXCharacters(atDummyIdentifier.type.token)) {
                                if (atDummyIdentifier instanceof MarkerAnnotation) {
                                    return Collections.emptyList();
                                }
                                if (atDummyIdentifier instanceof NormalAnnotation) {
                                    MemberValuePair[] mvps = ((NormalAnnotation) atDummyIdentifier).memberValuePairs;
                                    if (mvps == null || mvps.length == 0) {
                                        return Collections.emptyList();
                                    }
                                    if (mvps.length == 1 && Arrays.equals("value".toCharArray(), mvps[0].name)) {
                                        annotation3 = mvps[0].value;
                                    }
                                } else if (atDummyIdentifier instanceof SingleMemberAnnotation) {
                                    annotation3 = ((SingleMemberAnnotation) atDummyIdentifier).memberValue;
                                } else {
                                    addError(errorName, errorNode);
                                    return Collections.emptyList();
                                }
                            } else if (allowRaw) {
                                annotation3 = atDummyIdentifier;
                            } else {
                                addError(errorName, errorNode);
                                return Collections.emptyList();
                            }
                        }
                        if (annotation3 == null) {
                            addError(errorName, errorNode);
                            return Collections.emptyList();
                        }
                        if (annotation3 instanceof Annotation) {
                            return Collections.singletonList(annotation3);
                        }
                        if (annotation3 instanceof ArrayInitializer) {
                            Annotation[] annotationArr = ((ArrayInitializer) annotation3).expressions;
                            List<Annotation> result = new ArrayList<>();
                            if (annotationArr != null) {
                                for (Annotation annotation4 : annotationArr) {
                                    if (annotation4 instanceof Annotation) {
                                        result.add(annotation4);
                                    } else {
                                        addError(errorName, errorNode);
                                        return Collections.emptyList();
                                    }
                                }
                            }
                            return result;
                        }
                        addError(errorName, errorNode);
                        return Collections.emptyList();
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    public static NameReference createNameReference(String name, Annotation source) {
        return generateQualifiedNameRef(source, Eclipse.fromQualifiedName(name));
    }

    private static long[] copy(long[] array) {
        if (array == null) {
            return null;
        }
        return (long[]) array.clone();
    }

    public static <T> T[] concat(T[] tArr, T[] tArr2, Class<T> cls) {
        if (tArr == null) {
            return tArr2;
        }
        if (tArr2 == null) {
            return tArr;
        }
        if (tArr.length == 0) {
            return tArr2;
        }
        if (tArr2.length == 0) {
            return tArr;
        }
        T[] tArr3 = (T[]) newArray(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    private static <T> T[] newArray(Class<T> cls, int i) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    public static boolean isDirectDescendantOfObject(EclipseNode typeNode) {
        if (!(typeNode.get() instanceof TypeDeclaration)) {
            throw new IllegalArgumentException("not a type node");
        }
        TypeDeclaration typeDecl = typeNode.get();
        if (typeDecl.superclass == null) {
            return true;
        }
        String p = typeDecl.superclass.toString();
        return p.equals("Object") || p.equals("java.lang.Object");
    }

    public static void createRelevantNullableAnnotation(EclipseNode typeNode, MethodDeclaration mth) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToMethodDecl(typeNode, mth, lib.getNullableAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNonNullAnnotation(EclipseNode typeNode, MethodDeclaration mth) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToMethodDecl(typeNode, mth, lib.getNonNullAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNullableAnnotation(EclipseNode typeNode, Argument arg) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToVarDecl(typeNode, arg, lib.getNullableAnnotation(), lib.isTypeUse());
    }

    public static void createRelevantNonNullAnnotation(EclipseNode typeNode, Argument arg) {
        NullAnnotationLibrary lib = (NullAnnotationLibrary) typeNode.getAst().readConfiguration(ConfigurationKeys.ADD_NULL_ANNOTATIONS);
        if (lib == null) {
            return;
        }
        applyAnnotationToVarDecl(typeNode, arg, lib.getNonNullAnnotation(), lib.isTypeUse());
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private static void applyAnnotationToMethodDecl(EclipseNode typeNode, MethodDeclaration mth, String annType, boolean typeUse) {
        Annotation[] a;
        Annotation[] a2;
        if (annType == null) {
            return;
        }
        int partCount = 1;
        for (int i = 0; i < annType.length(); i++) {
            if (annType.charAt(i) == '.') {
                partCount++;
            }
        }
        long[] ps = new long[partCount];
        Arrays.fill(ps, 0L);
        Annotation ann = new MarkerAnnotation(new QualifiedTypeReference(Eclipse.fromQualifiedName(annType), ps), 0);
        if (!typeUse || mth.returnType == null || mth.returnType.getTypeName().length < 2) {
            Annotation[] a3 = mth.annotations;
            if (a3 == null) {
                a = new Annotation[1];
            } else {
                Annotation[] b2 = new Annotation[a3.length + 1];
                System.arraycopy(a3, 0, b2, 0, a3.length);
                a = b2;
            }
            a[a.length - 1] = ann;
            mth.annotations = a;
            return;
        }
        int len = mth.returnType.getTypeName().length;
        if (mth.returnType.annotations == null) {
            mth.returnType.annotations = new Annotation[len];
        }
        Annotation[] a4 = mth.returnType.annotations[len - 1];
        if (a4 == null) {
            a2 = new Annotation[1];
        } else {
            Annotation[] b3 = new Annotation[a4.length + 1];
            System.arraycopy(a4, 0, b3, 1, a4.length);
            a2 = b3;
        }
        a2[0] = ann;
        mth.returnType.annotations[len - 1] = a2;
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [org.eclipse.jdt.internal.compiler.ast.Annotation[], org.eclipse.jdt.internal.compiler.ast.Annotation[][]] */
    private static void applyAnnotationToVarDecl(EclipseNode typeNode, Argument arg, String annType, boolean typeUse) {
        Annotation[] a;
        Annotation[] a2;
        if (annType == null) {
            return;
        }
        int partCount = 1;
        for (int i = 0; i < annType.length(); i++) {
            if (annType.charAt(i) == '.') {
                partCount++;
            }
        }
        long[] ps = new long[partCount];
        Arrays.fill(ps, 0L);
        Annotation ann = new MarkerAnnotation(new QualifiedTypeReference(Eclipse.fromQualifiedName(annType), ps), 0);
        if (!typeUse || arg.type.getTypeName().length < 2) {
            Annotation[] a3 = arg.annotations;
            if (a3 == null) {
                a = new Annotation[1];
            } else {
                Annotation[] b2 = new Annotation[a3.length + 1];
                System.arraycopy(a3, 0, b2, 0, a3.length);
                a = b2;
            }
            a[a.length - 1] = ann;
            arg.annotations = a;
            return;
        }
        int len = arg.type.getTypeName().length;
        if (arg.type.annotations == null) {
            arg.type.annotations = new Annotation[len];
        }
        Annotation[] a4 = arg.type.annotations[len - 1];
        if (a4 == null) {
            a2 = new Annotation[1];
        } else {
            Annotation[] b3 = new Annotation[a4.length + 1];
            System.arraycopy(a4, 0, b3, 1, a4.length);
            a2 = b3;
        }
        a2[0] = ann;
        arg.type.annotations[len - 1] = a2;
    }

    public static NameReference generateQualifiedNameRef(ASTNode source, char[]... varNames) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        QualifiedNameReference qualifiedNameReference = varNames.length > 1 ? new QualifiedNameReference(varNames, new long[varNames.length], pS, pE) : new SingleNameReference(varNames[0], p);
        setGeneratedBy(qualifiedNameReference, source);
        return qualifiedNameReference;
    }

    public static TypeReference generateQualifiedTypeRef(ASTNode source, char[]... varNames) {
        int pS = source.sourceStart;
        int pE = source.sourceEnd;
        long p = (pS << 32) | pE;
        long[] poss = Eclipse.poss(source, varNames.length);
        QualifiedTypeReference qualifiedTypeReference = varNames.length > 1 ? new QualifiedTypeReference(varNames, poss) : new SingleTypeReference(varNames[0], p);
        setGeneratedBy(qualifiedTypeReference, source);
        return qualifiedTypeReference;
    }

    public static TypeReference createTypeReference(String typeName, ASTNode source) {
        return generateQualifiedTypeRef(source, Eclipse.fromQualifiedName(typeName));
    }

    public static String getDocComment(CompilationUnitDeclaration cud, ASTNode node) {
        ICompilationUnit compilationUnit = cud.compilationResult.compilationUnit;
        if (node instanceof FieldDeclaration) {
            FieldDeclaration fieldDeclaration = (FieldDeclaration) node;
            char[] rawContent = CharOperation.subarray(compilationUnit.getContents(), fieldDeclaration.declarationSourceStart, fieldDeclaration.declarationSourceEnd);
            String rawContentString = new String(rawContent);
            int startIndex = rawContentString.indexOf("/**");
            int endIndex = rawContentString.indexOf("*/");
            if (startIndex != -1 && endIndex != -1) {
                return rawContentString.substring(startIndex + 3, endIndex).replaceAll("(?m)^\\s*\\* ?", "").trim();
            }
            return null;
        }
        return null;
    }

    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$EclipseOnlyUtil.SCL.lombok */
    private static class EclipseOnlyUtil {
        private EclipseOnlyUtil() {
        }

        public static void setDocComment(CompilationUnitDeclaration cud, TypeDeclaration type, ASTNode node, String doc) {
            if (cud.compilationResult.compilationUnit instanceof CompilationUnit) {
                CompilationUnit compilationUnit = cud.compilationResult.compilationUnit;
                Map<String, String> docs = EcjAugments.EclipseAugments.CompilationUnit_javadoc.setIfAbsent(compilationUnit, new HashMap());
                if (node instanceof AbstractMethodDeclaration) {
                    AbstractMethodDeclaration methodDeclaration = (AbstractMethodDeclaration) node;
                    String signature = EclipseHandlerUtil.getSignature(type, methodDeclaration);
                    docs.put(signature, String.format("/**%n%s%n */", doc.replaceAll("(?m)^", " * ")));
                }
            }
        }
    }

    private static boolean eclipseMode() throws ClassNotFoundException {
        if (eclipseMode != null) {
            return eclipseMode.booleanValue();
        }
        try {
            Class.forName("org.eclipse.jdt.internal.core.CompilationUnit");
            eclipseMode = true;
        } catch (Exception unused) {
            eclipseMode = false;
        }
        return eclipseMode.booleanValue();
    }

    public static void setDocComment(CompilationUnitDeclaration cud, EclipseNode eclipseNode, String doc) {
        if (eclipseMode()) {
            setDocComment(cud, upToTypeNode(eclipseNode).get(), eclipseNode.get(), doc);
        }
    }

    public static void setDocComment(CompilationUnitDeclaration cud, TypeDeclaration type, ASTNode node, String doc) {
        if (eclipseMode()) {
            EclipseOnlyUtil.setDocComment(cud, type, node, doc);
        }
    }

    public static String getSignature(TypeDeclaration type, AbstractMethodDeclaration methodDeclaration) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.name);
        sb.append(".");
        sb.append(methodDeclaration.selector);
        sb.append("(");
        Argument[] arguments = methodDeclaration.arguments;
        if (arguments != null) {
            for (Argument argument : arguments) {
                String signature = Signature.createTypeSignature(argument.type.getLastToken(), false);
                sb.append(signature);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc.SCL.lombok */
    public static abstract class CopyJavadoc {
        public static final CopyJavadoc VERBATIM = new AnonymousClass1("VERBATIM", 0);
        public static final CopyJavadoc GETTER = new AnonymousClass2("GETTER", 1);
        public static final CopyJavadoc SETTER = new AnonymousClass3("SETTER", 2);
        public static final CopyJavadoc WITH = new AnonymousClass4("WITH", 3);
        public static final CopyJavadoc WITH_BY = new AnonymousClass5("WITH_BY", 4);
        private static final /* synthetic */ CopyJavadoc[] ENUM$VALUES = {VERBATIM, GETTER, SETTER, WITH, WITH_BY};

        public abstract String apply(CompilationUnitDeclaration compilationUnitDeclaration, EclipseNode eclipseNode);

        public static CopyJavadoc[] values() {
            CopyJavadoc[] copyJavadocArr = ENUM$VALUES;
            int length = copyJavadocArr.length;
            CopyJavadoc[] copyJavadocArr2 = new CopyJavadoc[length];
            System.arraycopy(copyJavadocArr, 0, copyJavadocArr2, 0, length);
            return copyJavadocArr2;
        }

        public static CopyJavadoc valueOf(String str) {
            return (CopyJavadoc) Enum.valueOf(CopyJavadoc.class, str);
        }

        /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc$1, reason: invalid class name */
        /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$1.SCL.lombok */
        enum AnonymousClass1 extends CopyJavadoc {
            AnonymousClass1(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.eclipse.handlers.EclipseHandlerUtil.CopyJavadoc
            public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
                return EclipseHandlerUtil.getDocComment(cu, node.get());
            }
        }

        private CopyJavadoc(String str, int i) {
        }

        /* synthetic */ CopyJavadoc(String str, int i, CopyJavadoc copyJavadoc) {
            this(str, i);
        }

        /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc$2, reason: invalid class name */
        /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$2.SCL.lombok */
        enum AnonymousClass2 extends CopyJavadoc {
            AnonymousClass2(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.eclipse.handlers.EclipseHandlerUtil.CopyJavadoc
            public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
                ASTNode n = node.get();
                String javadoc = EclipseHandlerUtil.getDocComment(cu, n);
                String out = HandlerUtil.getJavadocSection(javadoc, "GETTER");
                boolean sectionBased = out != null;
                if (!sectionBased) {
                    out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@param(?:eter)?\\s+.*");
                }
                return out;
            }
        }

        /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc$3, reason: invalid class name */
        /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$3.SCL.lombok */
        enum AnonymousClass3 extends CopyJavadoc {
            AnonymousClass3(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.eclipse.handlers.EclipseHandlerUtil.CopyJavadoc
            public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
                return CopyJavadoc.access$3(cu, node, "SETTER");
            }
        }

        /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc$4, reason: invalid class name */
        /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$4.SCL.lombok */
        enum AnonymousClass4 extends CopyJavadoc {
            AnonymousClass4(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.eclipse.handlers.EclipseHandlerUtil.CopyJavadoc
            public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
                return HandlerUtil.addReturnsUpdatedSelfIfNeeded(CopyJavadoc.access$3(cu, node, "WITH|WITHER"));
            }
        }

        /* renamed from: lombok.eclipse.handlers.EclipseHandlerUtil$CopyJavadoc$5, reason: invalid class name */
        /* loaded from: discord:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc$5.SCL.lombok */
        enum AnonymousClass5 extends CopyJavadoc {
            AnonymousClass5(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.eclipse.handlers.EclipseHandlerUtil.CopyJavadoc
            public String apply(CompilationUnitDeclaration cu, EclipseNode node) {
                return CopyJavadoc.access$3(cu, node, "WITHBY|WITH_BY");
            }
        }

        static /* synthetic */ String access$3(CompilationUnitDeclaration compilationUnitDeclaration, EclipseNode eclipseNode, String str) {
            return applySetter(compilationUnitDeclaration, eclipseNode, str);
        }

        private static String applySetter(CompilationUnitDeclaration cu, EclipseNode node, String sectionName) {
            ASTNode n = node.get();
            String javadoc = EclipseHandlerUtil.getDocComment(cu, n);
            String out = HandlerUtil.getJavadocSection(javadoc, sectionName);
            boolean sectionBased = out != null;
            if (!sectionBased) {
                out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@returns?\\s+.*");
            }
            return EclipseHandlerUtil.shouldReturnThis(node) ? HandlerUtil.addReturnsThisIfNeeded(out) : out;
        }
    }

    public static void copyJavadoc(EclipseNode from, ASTNode to, CopyJavadoc copyMode) {
        copyJavadoc(from, to, upToTypeNode(from).get(), copyMode, false);
    }

    public static void copyJavadoc(EclipseNode from, ASTNode to, CopyJavadoc copyMode, boolean forceAddReturn) {
        copyJavadoc(from, to, upToTypeNode(from).get(), copyMode, forceAddReturn);
    }

    public static void copyJavadoc(EclipseNode from, ASTNode to, TypeDeclaration type, CopyJavadoc copyMode) {
        copyJavadoc(from, to, type, copyMode, false);
    }

    public static void copyJavadoc(EclipseNode from, ASTNode to, TypeDeclaration type, CopyJavadoc copyMode, boolean forceAddReturn) {
        if (copyMode == null) {
            copyMode = CopyJavadoc.VERBATIM;
        }
        try {
            CompilationUnitDeclaration cud = (CompilationUnitDeclaration) from.top().get();
            String newJavadoc = copyMode.apply(cud, from);
            if (newJavadoc != null) {
                if (forceAddReturn) {
                    newJavadoc = HandlerUtil.addReturnsThisIfNeeded(newJavadoc);
                }
                setDocComment(cud, type, to, newJavadoc);
            }
        } catch (Exception unused) {
        }
    }
}
