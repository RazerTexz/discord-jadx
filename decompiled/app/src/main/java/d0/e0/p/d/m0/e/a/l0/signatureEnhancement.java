package d0.e0.p.d.m0.e.a.l0;

import d0.Tuples;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMapper;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations3;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.Annotations5;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.e.a.AnnotationQualifierApplicabilityType;
import d0.e0.p.d.m0.e.a.AnnotationQualifiersFqNames2;
import d0.e0.p.d.m0.e.a.AnnotationTypeQualifierResolver;
import d0.e0.p.d.m0.e.a.JavaTypeQualifiersByElementType;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames2;
import d0.e0.p.d.m0.e.a.h0.AnnotationDefaultValue;
import d0.e0.p.d.m0.e.a.h0.AnnotationDefaultValue2;
import d0.e0.p.d.m0.e.a.h0.AnnotationDefaultValue3;
import d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaPropertyDescriptor;
import d0.e0.p.d.m0.e.a.h0.PossiblyExternalAnnotationDescriptor;
import d0.e0.p.d.m0.e.a.h0.util3;
import d0.e0.p.d.m0.e.a.h0.util4;
import d0.e0.p.d.m0.e.a.i0.context;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.l.JavaDescriptorUtil;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaAnnotationDescriptor;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaTypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.utils2;
import d0.e0.p.d.m0.e.a.utils4;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.e.b.methodSignatureBuildingUtils;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.w.deprecation;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.RawType3;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.TypeWithEnhancement2;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement {
    public final AnnotationTypeQualifierResolver a;

    /* renamed from: b, reason: collision with root package name */
    public final JavaTypeEnhancementState f3348b;
    public final typeEnhancement4 c;

    /* compiled from: signatureEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.l$a */
    public static class a {
        public final KotlinType a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3349b;
        public final boolean c;

        public a(KotlinType kotlinType, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            this.a = kotlinType;
            this.f3349b = z2;
            this.c = z3;
        }

        public final boolean getContainsFunctionN() {
            return this.c;
        }

        public final KotlinType getType() {
            return this.a;
        }

        public final boolean getWereChanges() {
            return this.f3349b;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.l$c */
    public static final class c extends a {
        public final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(KotlinType kotlinType, boolean z2, boolean z3, boolean z4) {
            super(kotlinType, z3, z4);
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            this.d = z2;
        }

        public final boolean getHasDefaultValue() {
            return this.d;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.l$d */
    public static final class d extends Lambda implements Function1<KotlinType3, Boolean> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(KotlinType3 kotlinType3) {
            return Boolean.valueOf(invoke2(kotlinType3));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "it");
            return kotlinType3 instanceof RawType3;
        }
    }

    public signatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, JavaTypeEnhancementState javaTypeEnhancementState, typeEnhancement4 typeenhancement4) {
        Intrinsics3.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        Intrinsics3.checkNotNullParameter(typeenhancement4, "typeEnhancement");
        this.a = annotationTypeQualifierResolver;
        this.f3348b = javaTypeEnhancementState;
        this.c = typeenhancement4;
    }

    public static final /* synthetic */ AnnotationTypeQualifierResolver access$getAnnotationTypeQualifierResolver$p(signatureEnhancement signatureenhancement) {
        return signatureenhancement.a;
    }

    public static final /* synthetic */ typeEnhancement4 access$getTypeEnhancement$p(signatureEnhancement signatureenhancement) {
        return signatureenhancement.c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final NullabilityQualifierWithMigrationStatus a(AnnotationDescriptor annotationDescriptor, boolean z2, boolean z3) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus3;
        typeQualifiers3 typequalifiers3 = typeQualifiers3.FORCE_FLEXIBILITY;
        typeQualifiers3 typequalifiers32 = typeQualifiers3.NULLABLE;
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        boolean z4 = (annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || z3) && !z2;
        if (this.f3348b.getJspecifyReportLevel() != JavaTypeEnhancementState2.IGNORE) {
            boolean z5 = this.f3348b.getJspecifyReportLevel() == JavaTypeEnhancementState2.WARN;
            nullabilityQualifierWithMigrationStatus = Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getJSPECIFY_NULLABLE()) ? new NullabilityQualifierWithMigrationStatus(typequalifiers32, z5) : Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getJSPECIFY_NULLNESS_UNKNOWN()) ? new NullabilityQualifierWithMigrationStatus(typequalifiers3, z5) : null;
        }
        if (nullabilityQualifierWithMigrationStatus == null) {
            typeQualifiers3 typequalifiers33 = typeQualifiers3.NOT_NULL;
            if (JvmAnnotationNames2.getNULLABLE_ANNOTATIONS().contains(fqName)) {
                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers32, z4);
            } else {
                if (JvmAnnotationNames2.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
                    nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers33, z4);
                } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getJAVAX_NONNULL_ANNOTATION())) {
                    d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = DescriptorUtils2.firstArgument(annotationDescriptor);
                    d0.e0.p.d.m0.k.v.j jVar = gVarFirstArgument instanceof d0.e0.p.d.m0.k.v.j ? (d0.e0.p.d.m0.k.v.j) gVarFirstArgument : null;
                    if (jVar != null) {
                        String strAsString = jVar.getEnumEntryName().asString();
                        switch (strAsString.hashCode()) {
                            case 73135176:
                                if (!strAsString.equals("MAYBE")) {
                                    nullabilityQualifierWithMigrationStatus = null;
                                    break;
                                } else {
                                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers32, z4);
                                    break;
                                }
                            case 74175084:
                                if (!strAsString.equals("NEVER")) {
                                }
                                break;
                            case 433141802:
                                if (strAsString.equals("UNKNOWN")) {
                                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers3, z4);
                                    break;
                                }
                                break;
                            case 1933739535:
                                if (strAsString.equals("ALWAYS")) {
                                    nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers33, z4);
                                    break;
                                }
                                nullabilityQualifierWithMigrationStatus = null;
                                break;
                        }
                    } else {
                        nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers33, z4);
                    }
                } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers32, z4);
                } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers33, z4);
                } else {
                    if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
                        nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(typequalifiers33, true);
                    } else {
                        if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
                            nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(typequalifiers32, true);
                        }
                        nullabilityQualifierWithMigrationStatus = null;
                    }
                    nullabilityQualifierWithMigrationStatus = nullabilityQualifierWithMigrationStatus2;
                }
                nullabilityQualifierWithMigrationStatus = nullabilityQualifierWithMigrationStatus3;
            }
            if (nullabilityQualifierWithMigrationStatus == null) {
                return null;
            }
        }
        return (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() && (annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, null, true, 1, null) : nullabilityQualifierWithMigrationStatus;
    }

    public final b b(CallableMemberDescriptor callableMemberDescriptor, Annotations3 annotations3, boolean z2, context4 context4Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        KotlinType kotlinTypeInvoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptor2, "it");
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return new b(annotations3, kotlinTypeInvoke, arrayList, z2, context.copyWithNewDefaultTypeQualifiers(context4Var, function1.invoke(callableMemberDescriptor).getAnnotations()), annotationQualifierApplicabilityType, false, 64, null);
    }

    public final b c(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, context4 context4Var, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        context4 context4VarCopyWithNewDefaultTypeQualifiers;
        return b(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (context4VarCopyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(context4Var, valueParameterDescriptor.getAnnotations())) == null) ? context4Var : context4VarCopyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0298 A[LOOP:4: B:153:0x0292->B:155:0x0298, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(context4 context4Var, Collection<? extends D> collection) {
        CallableMemberDescriptor callableMemberDescriptor;
        JavaCallableMemberDescriptor javaCallableMemberDescriptor;
        a aVarEnhance$default;
        predefinedEnhancementInfo2 predefinedenhancementinfo2;
        Boolean bool;
        boolean z2;
        Iterator it;
        boolean z3;
        boolean z4;
        KotlinType type;
        boolean zDeclaresDefaultValue;
        List<predefinedEnhancementInfo4> parametersInfo;
        String strSignature;
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(collection, "platformSignatures");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            CallableMemberDescriptor callableMemberDescriptorEnhance = (CallableMemberDescriptor) it2.next();
            if (callableMemberDescriptorEnhance instanceof JavaCallableMemberDescriptor) {
                JavaCallableMemberDescriptor javaCallableMemberDescriptor2 = (JavaCallableMemberDescriptor) callableMemberDescriptorEnhance;
                if (javaCallableMemberDescriptor2.getKind() != CallableMemberDescriptor.a.FAKE_OVERRIDE || javaCallableMemberDescriptor2.getOriginal().getOverriddenDescriptors().size() != 1) {
                    context4 context4VarCopyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(context4Var, callableMemberDescriptorEnhance.getAnnotations());
                    predefinedEnhancementInfo4 predefinedenhancementinfo4 = null;
                    if (callableMemberDescriptorEnhance instanceof JavaPropertyDescriptor) {
                        JavaPropertyDescriptor javaPropertyDescriptor = (JavaPropertyDescriptor) callableMemberDescriptorEnhance;
                        PropertyGetterDescriptorImpl getter = javaPropertyDescriptor.getGetter();
                        if (Intrinsics3.areEqual(getter == null ? null : Boolean.valueOf(getter.isDefault()), Boolean.FALSE)) {
                            PropertyGetterDescriptorImpl getter2 = javaPropertyDescriptor.getGetter();
                            Intrinsics3.checkNotNull(getter2);
                            callableMemberDescriptor = getter2;
                        }
                        javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) callableMemberDescriptorEnhance;
                        if (javaCallableMemberDescriptor.getExtensionReceiverParameter() == null) {
                        }
                        if (!(callableMemberDescriptorEnhance instanceof JavaMethodDescriptor)) {
                        }
                        if (javaMethodDescriptor == null) {
                            if (predefinedenhancementinfo2 != null) {
                            }
                            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
                            Intrinsics3.checkNotNullExpressionValue(valueParameters, "annotationOwnerForMember.valueParameters");
                            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters, 10));
                            while (r0.hasNext()) {
                            }
                            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) (callableMemberDescriptorEnhance instanceof PropertyDescriptor ? null : callableMemberDescriptorEnhance);
                            if (propertyDescriptor != null) {
                            }
                            bool = Boolean.TRUE;
                            a aVarEnhance = b(callableMemberDescriptorEnhance, callableMemberDescriptor, true, context4VarCopyWithNewDefaultTypeQualifiers, !Intrinsics3.areEqual(boolValueOf, bool) ? AnnotationQualifierApplicabilityType.FIELD : AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, signatureEnhancement4.j).enhance(predefinedenhancementinfo2 != null ? null : predefinedenhancementinfo2.getReturnTypeInfo());
                            if (Intrinsics3.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getContainsFunctionN()), bool)) {
                                z2 = true;
                                if (Intrinsics3.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE)) {
                                }
                            }
                        }
                    } else {
                        callableMemberDescriptor = callableMemberDescriptorEnhance;
                        javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) callableMemberDescriptorEnhance;
                        if (javaCallableMemberDescriptor.getExtensionReceiverParameter() == null) {
                            FunctionDescriptor functionDescriptor = (FunctionDescriptor) (!(callableMemberDescriptor instanceof FunctionDescriptor) ? null : callableMemberDescriptor);
                            aVarEnhance$default = b.enhance$default(c(callableMemberDescriptorEnhance, functionDescriptor == null ? null : (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.M), context4VarCopyWithNewDefaultTypeQualifiers, signatureEnhancement3.j), null, 1, null);
                        } else {
                            aVarEnhance$default = null;
                        }
                        JavaMethodDescriptor javaMethodDescriptor = !(callableMemberDescriptorEnhance instanceof JavaMethodDescriptor) ? (JavaMethodDescriptor) callableMemberDescriptorEnhance : null;
                        predefinedenhancementinfo2 = (javaMethodDescriptor == null || (strSignature = methodSignatureBuildingUtils.signature(SignatureBuildingComponents.a, (ClassDescriptor) javaMethodDescriptor.getContainingDeclaration(), methodSignatureMapping3.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null))) == null) ? null : predefinedEnhancementInfo.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(strSignature);
                        if (predefinedenhancementinfo2 != null) {
                            predefinedenhancementinfo2.getParametersInfo().size();
                            javaCallableMemberDescriptor.getValueParameters().size();
                        }
                        List<ValueParameterDescriptor> valueParameters2 = callableMemberDescriptor.getValueParameters();
                        Intrinsics3.checkNotNullExpressionValue(valueParameters2, "annotationOwnerForMember.valueParameters");
                        ArrayList arrayList22 = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters2, 10));
                        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters2) {
                            a aVarEnhance2 = c(callableMemberDescriptorEnhance, valueParameterDescriptor, context4VarCopyWithNewDefaultTypeQualifiers, new signatureEnhancement5(valueParameterDescriptor)).enhance((predefinedenhancementinfo2 == null || (parametersInfo = predefinedenhancementinfo2.getParametersInfo()) == null) ? predefinedenhancementinfo4 : (predefinedEnhancementInfo4) _Collections.getOrNull(parametersInfo, valueParameterDescriptor.getIndex()));
                            if (aVarEnhance2.getWereChanges()) {
                                type = aVarEnhance2.getType();
                            } else {
                                type = valueParameterDescriptor.getType();
                                Intrinsics3.checkNotNullExpressionValue(type, "p.type");
                            }
                            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "p");
                            AnnotationDefaultValue defaultValueFromAnnotation = util3.getDefaultValueFromAnnotation(valueParameterDescriptor);
                            if (defaultValueFromAnnotation instanceof AnnotationDefaultValue3) {
                                zDeclaresDefaultValue = utils2.lexicalCastFrom(type, ((AnnotationDefaultValue3) defaultValueFromAnnotation).getValue()) != null;
                            } else if (Intrinsics3.areEqual(defaultValueFromAnnotation, AnnotationDefaultValue2.a)) {
                                zDeclaresDefaultValue = TypeUtils.acceptsNullable(type);
                            } else {
                                if (defaultValueFromAnnotation != null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                zDeclaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
                            }
                            boolean z5 = zDeclaresDefaultValue && valueParameterDescriptor.getOverriddenDescriptors().isEmpty();
                            arrayList22.add(new c(aVarEnhance2.getType(), z5, aVarEnhance2.getWereChanges() || z5 != valueParameterDescriptor.declaresDefaultValue(), aVarEnhance2.getContainsFunctionN()));
                            predefinedenhancementinfo4 = null;
                        }
                        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) (callableMemberDescriptorEnhance instanceof PropertyDescriptor ? null : callableMemberDescriptorEnhance);
                        Boolean boolValueOf = propertyDescriptor2 != null ? null : Boolean.valueOf(JavaDescriptorUtil.isJavaField(propertyDescriptor2));
                        bool = Boolean.TRUE;
                        a aVarEnhance3 = b(callableMemberDescriptorEnhance, callableMemberDescriptor, true, context4VarCopyWithNewDefaultTypeQualifiers, !Intrinsics3.areEqual(boolValueOf, bool) ? AnnotationQualifierApplicabilityType.FIELD : AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, signatureEnhancement4.j).enhance(predefinedenhancementinfo2 != null ? null : predefinedenhancementinfo2.getReturnTypeInfo());
                        if (!Intrinsics3.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getContainsFunctionN()), bool) || aVarEnhance3.getContainsFunctionN()) {
                            z2 = true;
                            if (!Intrinsics3.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE) || aVarEnhance3.getWereChanges()) {
                                Tuples2<CallableDescriptor.a<?>, ?> tuples2 = z2 ? Tuples.to(deprecation.getDEPRECATED_FUNCTION_KEY(), new utils4(callableMemberDescriptorEnhance)) : null;
                                KotlinType type2 = aVarEnhance$default == null ? null : aVarEnhance$default.getType();
                                ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList22, 10));
                                it = arrayList22.iterator();
                                while (it.hasNext()) {
                                    c cVar = (c) it.next();
                                    arrayList3.add(new util4(cVar.getType(), cVar.getHasDefaultValue()));
                                }
                                callableMemberDescriptorEnhance = javaCallableMemberDescriptor.enhance(type2, arrayList3, aVarEnhance3.getType(), tuples2);
                            } else if (arrayList22.isEmpty()) {
                                z3 = false;
                                if (!z3 || z2) {
                                }
                            } else {
                                Iterator it3 = arrayList22.iterator();
                                while (it3.hasNext()) {
                                    if (((c) it3.next()).getWereChanges()) {
                                        z3 = true;
                                        break;
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                    if (z2) {
                                    }
                                    if (aVarEnhance$default == null) {
                                    }
                                    ArrayList arrayList32 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList22, 10));
                                    it = arrayList22.iterator();
                                    while (it.hasNext()) {
                                    }
                                    callableMemberDescriptorEnhance = javaCallableMemberDescriptor.enhance(type2, arrayList32, aVarEnhance3.getType(), tuples2);
                                }
                            }
                        } else if (arrayList22.isEmpty()) {
                            z4 = false;
                            if (z4) {
                                z2 = false;
                            }
                            if (Intrinsics3.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE)) {
                                if (z2) {
                                }
                                if (aVarEnhance$default == null) {
                                }
                                ArrayList arrayList322 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList22, 10));
                                it = arrayList22.iterator();
                                while (it.hasNext()) {
                                }
                                callableMemberDescriptorEnhance = javaCallableMemberDescriptor.enhance(type2, arrayList322, aVarEnhance3.getType(), tuples2);
                            }
                        } else {
                            Iterator it4 = arrayList22.iterator();
                            while (it4.hasNext()) {
                                if (((c) it4.next()).getContainsFunctionN()) {
                                    z4 = true;
                                    break;
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                            if (Intrinsics3.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE)) {
                            }
                        }
                    }
                }
            }
            arrayList.add(callableMemberDescriptorEnhance);
        }
        return arrayList;
    }

    public final KotlinType enhanceSuperType(KotlinType kotlinType, context4 context4Var) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        Intrinsics3.checkNotNullParameter(context4Var, "context");
        return b.enhance$default(new b(null, kotlinType, Collections2.emptyList(), false, context4Var, AnnotationQualifierApplicabilityType.TYPE_USE, false, 64, null), null, 1, null).getType();
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameterDescriptor, List<? extends KotlinType> list, context4 context4Var) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics3.checkNotNullParameter(list, "bounds");
        Intrinsics3.checkNotNullParameter(context4Var, "context");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (KotlinType type : list) {
            if (!TypeUtils2.contains(type, d.j)) {
                type = b.enhance$default(new b(this, typeParameterDescriptor, type, Collections2.emptyList(), false, context4Var, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true), null, 1, null).getType();
            }
            arrayList.add(type);
        }
        return arrayList;
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor, boolean z2, boolean z3) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusA;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusA2 = a(annotationDescriptor, z2, z3);
        if (nullabilityQualifierWithMigrationStatusA2 != null) {
            return nullabilityQualifierWithMigrationStatusA2;
        }
        AnnotationDescriptor annotationDescriptorResolveTypeQualifierAnnotation = this.a.resolveTypeQualifierAnnotation(annotationDescriptor);
        if (annotationDescriptorResolveTypeQualifierAnnotation == null) {
            return null;
        }
        JavaTypeEnhancementState2 javaTypeEnhancementState2ResolveJsr305AnnotationState = this.a.resolveJsr305AnnotationState(annotationDescriptor);
        if (javaTypeEnhancementState2ResolveJsr305AnnotationState.isIgnore() || (nullabilityQualifierWithMigrationStatusA = a(annotationDescriptorResolveTypeQualifierAnnotation, z2, z3)) == null) {
            return null;
        }
        return NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatusA, null, javaTypeEnhancementState2ResolveJsr305AnnotationState.isWarning(), 1, null);
    }

    /* compiled from: signatureEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.l$b */
    public final class b {
        public final Annotations3 a;

        /* renamed from: b, reason: collision with root package name */
        public final KotlinType f3350b;
        public final Collection<KotlinType> c;
        public final boolean d;
        public final context4 e;
        public final AnnotationQualifierApplicabilityType f;
        public final boolean g;

        /* compiled from: signatureEnhancement.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.l0.l$b$a */
        public static final class a extends Lambda implements Function1<KotlinType3, Boolean> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KotlinType3 kotlinType3) {
                return invoke2(kotlinType3);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(KotlinType3 kotlinType3) {
                ClassifierDescriptor declarationDescriptor = kotlinType3.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor == null) {
                    return Boolean.FALSE;
                }
                Name name = declarationDescriptor.getName();
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.a;
                return Boolean.valueOf(Intrinsics3.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics3.areEqual(DescriptorUtils2.fqNameOrNull(declarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
            }
        }

        /* compiled from: signatureEnhancement.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.l0.l$b$b, reason: collision with other inner class name */
        public static final class C0386b extends Lambda implements Function1<Integer, typeQualifiers> {
            public final /* synthetic */ predefinedEnhancementInfo4 $predefined;
            public final /* synthetic */ Function1<Integer, typeQualifiers> $qualifiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0386b(predefinedEnhancementInfo4 predefinedenhancementinfo4, Function1<? super Integer, typeQualifiers> function1) {
                super(1);
                this.$predefined = predefinedenhancementinfo4;
                this.$qualifiers = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ typeQualifiers invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final typeQualifiers invoke(int i) {
                typeQualifiers typequalifiers = this.$predefined.getMap().get(Integer.valueOf(i));
                return typequalifiers == null ? this.$qualifiers.invoke(Integer.valueOf(i)) : typequalifiers;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(signatureEnhancement signatureenhancement, Annotations3 annotations3, KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z2, context4 context4Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z3) {
            Intrinsics3.checkNotNullParameter(signatureenhancement, "this$0");
            Intrinsics3.checkNotNullParameter(kotlinType, "fromOverride");
            Intrinsics3.checkNotNullParameter(collection, "fromOverridden");
            Intrinsics3.checkNotNullParameter(context4Var, "containerContext");
            Intrinsics3.checkNotNullParameter(annotationQualifierApplicabilityType, "containerApplicabilityType");
            signatureEnhancement.this = signatureenhancement;
            this.a = annotations3;
            this.f3350b = kotlinType;
            this.c = collection;
            this.d = z2;
            this.e = context4Var;
            this.f = annotationQualifierApplicabilityType;
            this.g = z3;
        }

        public static final <T> T c(List<FqName> list, Annotations4 annotations4, T t) {
            boolean z2 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (annotations4.findAnnotation((FqName) it.next()) != null) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                return t;
            }
            return null;
        }

        public static final void d(b bVar, ArrayList<signatureEnhancement7> arrayList, KotlinType kotlinType, context4 context4Var, TypeParameterDescriptor typeParameterDescriptor) {
            context4 context4VarCopyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(context4Var, kotlinType.getAnnotations());
            JavaTypeQualifiersByElementType defaultTypeQualifiers = context4VarCopyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = defaultTypeQualifiers == null ? null : defaultTypeQualifiers.get(bVar.g ? AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS : AnnotationQualifierApplicabilityType.TYPE_USE);
            arrayList.add(new signatureEnhancement7(kotlinType, annotationQualifiersFqNames2, typeParameterDescriptor, false));
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
            for (Tuples2 tuples2 : _Collections.zip(arguments, parameters)) {
                TypeProjection typeProjection = (TypeProjection) tuples2.component1();
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) tuples2.component2();
                if (typeProjection.isStarProjection()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "arg.type");
                    arrayList.add(new signatureEnhancement7(type, annotationQualifiersFqNames2, typeParameterDescriptor2, true));
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type2, "arg.type");
                    d(bVar, arrayList, type2, context4VarCopyWithNewDefaultTypeQualifiers, typeParameterDescriptor2);
                }
            }
        }

        public static /* synthetic */ a enhance$default(b bVar, predefinedEnhancementInfo4 predefinedenhancementinfo4, int i, Object obj) {
            if ((i & 1) != 0) {
                predefinedenhancementinfo4 = null;
            }
            return bVar.enhance(predefinedenhancementinfo4);
        }

        public final typeQualifiers3 a(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z2;
            boolean z3;
            if (!(typeParameterDescriptor instanceof LazyJavaTypeParameterDescriptor)) {
                return null;
            }
            LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor) typeParameterDescriptor;
            List<KotlinType> upperBounds = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds, "upperBounds");
            boolean z4 = false;
            if ((upperBounds instanceof Collection) && upperBounds.isEmpty()) {
                z2 = true;
            } else {
                Iterator<T> it = upperBounds.iterator();
                while (it.hasNext()) {
                    if (!KotlinType2.isError((KotlinType) it.next())) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
            }
            if (z2) {
                return null;
            }
            List<KotlinType> upperBounds2 = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds2, "upperBounds");
            if ((upperBounds2 instanceof Collection) && upperBounds2.isEmpty()) {
                z3 = true;
            } else {
                Iterator<T> it2 = upperBounds2.iterator();
                while (it2.hasNext()) {
                    if (!signatureEnhancement6.access$isNullabilityFlexible((KotlinType) it2.next())) {
                        z3 = false;
                        break;
                    }
                }
                z3 = true;
            }
            if (z3) {
                return null;
            }
            List<KotlinType> upperBounds3 = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds3, "upperBounds");
            if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                Iterator<T> it3 = upperBounds3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Intrinsics3.checkNotNullExpressionValue((KotlinType) it3.next(), "it");
                    if (!KotlinType2.isNullable(r0)) {
                        z4 = true;
                        break;
                    }
                }
            }
            return z4 ? typeQualifiers3.NOT_NULL : typeQualifiers3.NULLABLE;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final typeQualifiers b(KotlinType kotlinType) {
            Tuples2 tuples2;
            typeQualifiers3 typequalifiers3;
            typeQualifiers3 typequalifiers32;
            if (flexibleTypes2.isFlexible(kotlinType)) {
                KotlinType6 kotlinType6AsFlexibleType = flexibleTypes2.asFlexibleType(kotlinType);
                tuples2 = new Tuples2(kotlinType6AsFlexibleType.getLowerBound(), kotlinType6AsFlexibleType.getUpperBound());
            } else {
                tuples2 = new Tuples2(kotlinType, kotlinType);
            }
            KotlinType kotlinType2 = (KotlinType) tuples2.component1();
            KotlinType kotlinType3 = (KotlinType) tuples2.component2();
            JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.a;
            if (kotlinType2.isMarkedNullable()) {
                typequalifiers32 = typeQualifiers3.NULLABLE;
            } else {
                if (kotlinType3.isMarkedNullable()) {
                    typequalifiers3 = null;
                    return new typeQualifiers(typequalifiers3, !javaToKotlinClassMapper.isReadOnly(kotlinType2) ? typeQualifiers2.READ_ONLY : javaToKotlinClassMapper.isMutable(kotlinType3) ? typeQualifiers2.MUTABLE : null, kotlinType.unwrap() instanceof typeEnhancement5, false, 8, null);
                }
                typequalifiers32 = typeQualifiers3.NOT_NULL;
            }
            typequalifiers3 = typequalifiers32;
            return new typeQualifiers(typequalifiers3, !javaToKotlinClassMapper.isReadOnly(kotlinType2) ? typeQualifiers2.READ_ONLY : javaToKotlinClassMapper.isMutable(kotlinType3) ? typeQualifiers2.MUTABLE : null, kotlinType.unwrap() instanceof typeEnhancement5, false, 8, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0227  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0247  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x024a  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x024d  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0255  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x02b4  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x02b7  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x02fc  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x030a  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x030e  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x0315  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x032c  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0333  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0335  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x035a  */
        /* JADX WARN: Removed duplicated region for block: B:190:0x035d  */
        /* JADX WARN: Removed duplicated region for block: B:196:0x036a  */
        /* JADX WARN: Removed duplicated region for block: B:198:0x036d  */
        /* JADX WARN: Removed duplicated region for block: B:199:0x036f  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0388  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x038a  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x038d  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x038f  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x03a1  */
        /* JADX WARN: Removed duplicated region for block: B:215:0x03ab  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:232:0x03cd  */
        /* JADX WARN: Removed duplicated region for block: B:235:0x03dc  */
        /* JADX WARN: Removed duplicated region for block: B:239:0x03e7  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x03f0  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x0413  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0415  */
        /* JADX WARN: Removed duplicated region for block: B:258:0x0418 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:260:0x0424  */
        /* JADX WARN: Removed duplicated region for block: B:261:0x0426  */
        /* JADX WARN: Removed duplicated region for block: B:262:0x0428  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x02ac A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0222  */
        /* JADX WARN: Type inference failed for: r1v1, types: [d0.e0.p.d.m0.e.a.l0.m, kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18, types: [d0.e0.p.d.m0.e.a.l0.e] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r4v4, types: [d0.e0.p.d.m0.e.a.l0.d] */
        /* JADX WARN: Type inference failed for: r6v3, types: [d0.e0.p.d.m0.e.a.l0.l$a] */
        /* JADX WARN: Type inference failed for: r6v44 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a enhance(predefinedEnhancementInfo4 predefinedenhancementinfo4) {
            Object obj;
            boolean z2;
            ArrayList arrayList;
            typeQualifiers[] typequalifiersArr;
            int i;
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames2;
            Annotations4 annotations;
            Annotations3 annotations3;
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames22;
            typeQualifiers3 typequalifiers3A;
            Set set;
            Set set2;
            Set set3;
            Tuples2 tuples2;
            Iterator<AnnotationDescriptor> it;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusExtractNullability;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
            typeQualifiers3 typequalifiers3;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
            boolean z3;
            typeQualifiers typequalifiers;
            Object objC;
            typeQualifiers3 nullability;
            typeQualifiers3 nullability2;
            Set set4;
            boolean z4;
            typeQualifiers3 typequalifiers3Select;
            Set set5;
            boolean z5;
            boolean z6;
            typeQualifiers typequalifiersCreateJavaTypeQualifiers;
            boolean z7;
            NullabilityQualifierWithMigrationStatus nullabilityQualifier;
            boolean z8;
            Collection<KotlinType> collection = this.c;
            int i2 = 10;
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
            Iterator it2 = collection.iterator();
            while (true) {
                obj = null;
                if (!it2.hasNext()) {
                    break;
                }
                KotlinType kotlinType = (KotlinType) it2.next();
                ArrayList arrayList3 = new ArrayList(1);
                d(this, arrayList3, kotlinType, this.e, null);
                arrayList2.add(arrayList3);
            }
            KotlinType kotlinType2 = this.f3350b;
            ArrayList arrayList4 = new ArrayList(1);
            d(this, arrayList4, kotlinType2, this.e, null);
            if (this.d) {
                Collection<KotlinType> collection2 = this.c;
                if ((collection2 instanceof Collection) && collection2.isEmpty()) {
                    z8 = false;
                    if (!z8) {
                    }
                } else {
                    Iterator it3 = collection2.iterator();
                    while (it3.hasNext()) {
                        if (!KotlinTypeChecker.a.equalTypes((KotlinType) it3.next(), this.f3350b)) {
                            z8 = true;
                            break;
                        }
                    }
                    z8 = false;
                    z2 = !z8;
                }
            }
            int size = z2 ? 1 : arrayList4.size();
            typeQualifiers[] typequalifiersArr2 = new typeQualifiers[size];
            int i3 = 0;
            while (i3 < size) {
                boolean z9 = i3 == 0;
                signatureEnhancement7 signatureenhancement7 = (signatureEnhancement7) arrayList4.get(i3);
                KotlinType kotlinTypeComponent1 = signatureenhancement7.component1();
                AnnotationQualifiersFqNames2 annotationQualifiersFqNames2Component2 = signatureenhancement7.component2();
                TypeParameterDescriptor typeParameterDescriptorComponent3 = signatureenhancement7.component3();
                boolean zComponent4 = signatureenhancement7.component4();
                ArrayList arrayList5 = new ArrayList();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    signatureEnhancement7 signatureenhancement72 = (signatureEnhancement7) _Collections.getOrNull((List) it4.next(), i3);
                    Object type = signatureenhancement72 == null ? obj : signatureenhancement72.getType();
                    if (type != null) {
                        arrayList5.add(type);
                    }
                }
                typeQualifiers3 typequalifiers32 = typeQualifiers3.NULLABLE;
                int i4 = size;
                ArrayList arrayList6 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList5, i2));
                Iterator it5 = arrayList5.iterator();
                while (it5.hasNext()) {
                    arrayList6.add(b((KotlinType) it5.next()));
                }
                ArrayList arrayList7 = new ArrayList();
                Iterator it6 = arrayList6.iterator();
                while (it6.hasNext()) {
                    ArrayList arrayList8 = arrayList2;
                    typeQualifiers2 mutability = ((typeQualifiers) it6.next()).getMutability();
                    if (mutability != null) {
                        arrayList7.add(mutability);
                    }
                    arrayList2 = arrayList8;
                }
                ArrayList arrayList9 = arrayList2;
                Set set6 = _Collections.toSet(arrayList7);
                ArrayList arrayList10 = new ArrayList();
                Iterator it7 = arrayList6.iterator();
                while (it7.hasNext()) {
                    Iterator it8 = it7;
                    typeQualifiers3 nullability3 = ((typeQualifiers) it7.next()).getNullability();
                    if (nullability3 != null) {
                        arrayList10.add(nullability3);
                    }
                    it7 = it8;
                }
                Set set7 = _Collections.toSet(arrayList10);
                ArrayList arrayList11 = new ArrayList();
                Iterator it9 = arrayList5.iterator();
                while (it9.hasNext()) {
                    ArrayList arrayList12 = arrayList4;
                    typeQualifiers3 nullability4 = b(TypeWithEnhancement2.unwrapEnhancement((KotlinType) it9.next())).getNullability();
                    if (nullability4 != null) {
                        arrayList11.add(nullability4);
                    }
                    arrayList4 = arrayList12;
                }
                ArrayList arrayList13 = arrayList4;
                Set set8 = _Collections.toSet(arrayList11);
                typeQualifiers3 typequalifiers33 = typeQualifiers3.NOT_NULL;
                boolean typeEnhancementImprovements = this.e.getComponents().getSettings().getTypeEnhancementImprovements();
                if (z9) {
                    annotationQualifiersFqNames2 = annotationQualifiersFqNames2Component2;
                    Annotations3 annotations32 = this.a;
                    if (annotations32 == null || (annotations32 instanceof TypeParameterDescriptor) || !typeEnhancementImprovements) {
                        arrayList = arrayList6;
                        typequalifiersArr = typequalifiersArr2;
                        i = i3;
                    } else {
                        Annotations4 annotations2 = annotations32.getAnnotations();
                        signatureEnhancement signatureenhancement = signatureEnhancement.this;
                        typequalifiersArr = typequalifiersArr2;
                        ArrayList arrayList14 = new ArrayList();
                        Iterator<AnnotationDescriptor> it10 = annotations2.iterator();
                        while (it10.hasNext()) {
                            int i5 = i3;
                            AnnotationDescriptor next = it10.next();
                            Iterator<AnnotationDescriptor> it11 = it10;
                            ArrayList arrayList15 = arrayList6;
                            AnnotationTypeQualifierResolver.a aVarResolveAnnotation = signatureEnhancement.access$getAnnotationTypeQualifierResolver$p(signatureenhancement).resolveAnnotation(next);
                            if ((aVarResolveAnnotation == null || aVarResolveAnnotation.component2().contains(AnnotationQualifierApplicabilityType.TYPE_USE)) ? false : true) {
                                arrayList14.add(next);
                            }
                            i3 = i5;
                            it10 = it11;
                            arrayList6 = arrayList15;
                        }
                        arrayList = arrayList6;
                        i = i3;
                        annotations = Annotations5.composeAnnotations(Annotations4.f.create(arrayList14), kotlinTypeComponent1.getAnnotations());
                        if (z9) {
                            annotationQualifiersFqNames22 = annotationQualifiersFqNames2;
                        } else {
                            JavaTypeQualifiersByElementType defaultTypeQualifiers = this.e.getDefaultTypeQualifiers();
                            annotationQualifiersFqNames22 = defaultTypeQualifiers == null ? null : defaultTypeQualifiers.get(this.f);
                        }
                        if (annotationQualifiersFqNames22 != null) {
                            if (!(annotationQualifiersFqNames22.getAffectsTypeParameterBasedTypes() || !TypeUtils2.isTypeParameter(kotlinTypeComponent1))) {
                                annotationQualifiersFqNames22 = null;
                            }
                        }
                        ClassifierDescriptor declarationDescriptor = kotlinTypeComponent1.getConstructor().getDeclarationDescriptor();
                        TypeParameterDescriptor typeParameterDescriptor = !(declarationDescriptor instanceof TypeParameterDescriptor) ? (TypeParameterDescriptor) declarationDescriptor : null;
                        typequalifiers3A = typeParameterDescriptor != null ? null : a(typeParameterDescriptor);
                        if (typequalifiers3A != null) {
                            tuples2 = new Tuples2(null, Boolean.FALSE);
                            set2 = set6;
                            set3 = set7;
                            set = set8;
                        } else {
                            set = set8;
                            set2 = set6;
                            set3 = set7;
                            tuples2 = new Tuples2(new NullabilityQualifierWithMigrationStatus(typequalifiers33, false, 2, null), Boolean.valueOf(typequalifiers3A == typequalifiers33));
                        }
                        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus3 = (NullabilityQualifierWithMigrationStatus) tuples2.component1();
                        boolean zBooleanValue = ((Boolean) tuples2.component2()).booleanValue();
                        boolean z10 = this.g;
                        signatureEnhancement signatureenhancement2 = signatureEnhancement.this;
                        it = annotations.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                nullabilityQualifierWithMigrationStatusExtractNullability = null;
                                break;
                            }
                            nullabilityQualifierWithMigrationStatusExtractNullability = signatureenhancement2.extractNullability(it.next(), typeEnhancementImprovements, z10);
                            if (nullabilityQualifierWithMigrationStatusExtractNullability != null) {
                                break;
                            }
                        }
                        nullabilityQualifierWithMigrationStatus = (nullabilityQualifierWithMigrationStatusExtractNullability == null && !zComponent4) ? nullabilityQualifierWithMigrationStatusExtractNullability : null;
                        if (nullabilityQualifierWithMigrationStatus != null) {
                            if (nullabilityQualifierWithMigrationStatus3 == null) {
                                nullabilityQualifierWithMigrationStatus3 = (annotationQualifiersFqNames22 == null || (nullabilityQualifier = annotationQualifiersFqNames22.getNullabilityQualifier()) == null) ? null : new NullabilityQualifierWithMigrationStatus(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                            }
                            typeQualifiers3 typequalifiers3A2 = typeParameterDescriptorComponent3 == null ? null : a(typeParameterDescriptorComponent3);
                            if (typequalifiers3A2 == null) {
                                nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatus3;
                                typequalifiers3 = null;
                            } else if (nullabilityQualifierWithMigrationStatus3 == null) {
                                nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(typequalifiers3A2, false, 2, null);
                                typequalifiers3 = null;
                            } else {
                                typeQualifiers3 qualifier = nullabilityQualifierWithMigrationStatus3.getQualifier();
                                typeQualifiers3 typequalifiers34 = typeQualifiers3.FORCE_FLEXIBILITY;
                                if (typequalifiers3A2 != typequalifiers34) {
                                    if (qualifier != typequalifiers34) {
                                        if (typequalifiers3A2 == typequalifiers32) {
                                            typequalifiers3A2 = qualifier;
                                        } else if (qualifier != typequalifiers32) {
                                            typequalifiers3A2 = typequalifiers33;
                                        }
                                    }
                                    typequalifiers3 = null;
                                    nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(typequalifiers3A2, false, 2, null);
                                }
                            }
                        } else {
                            typequalifiers3 = null;
                            nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatus;
                        }
                        if (nullabilityQualifierWithMigrationStatus == null) {
                            z3 = nullabilityQualifierWithMigrationStatus.getQualifier() == typequalifiers33;
                        } else {
                            if (!zBooleanValue) {
                                if (Intrinsics3.areEqual(annotationQualifiersFqNames22 == null ? typequalifiers3 : Boolean.valueOf(annotationQualifiersFqNames22.getMakesTypeParameterNotNull()), Boolean.TRUE)) {
                                }
                            }
                        }
                        typeQualifiers3 qualifier2 = nullabilityQualifierWithMigrationStatus2 != null ? typequalifiers3 : nullabilityQualifierWithMigrationStatus2.getQualifier();
                        List<FqName> read_only_annotations = JvmAnnotationNames2.getREAD_ONLY_ANNOTATIONS();
                        typeQualifiers2 typequalifiers2 = typeQualifiers2.READ_ONLY;
                        objC = c(read_only_annotations, annotations, typequalifiers2);
                        List<FqName> mutable_annotations = JvmAnnotationNames2.getMUTABLE_ANNOTATIONS();
                        typeQualifiers2 typequalifiers22 = typeQualifiers2.MUTABLE;
                        Object objC2 = c(mutable_annotations, annotations, typequalifiers22);
                        if (objC == null && objC2 != null && !Intrinsics3.areEqual(objC, objC2)) {
                            objC2 = typequalifiers3;
                        } else if (objC != null) {
                            objC2 = objC;
                        }
                        typequalifiers = new typeQualifiers(qualifier2, (typeQualifiers2) objC2, !z3 && TypeUtils2.isTypeParameter(kotlinTypeComponent1), Intrinsics3.areEqual(nullabilityQualifierWithMigrationStatus2 != null ? typequalifiers3 : Boolean.valueOf(nullabilityQualifierWithMigrationStatus2.isForWarningOnly()), Boolean.TRUE));
                        ?? r1 = !(typequalifiers.isNullabilityQualifierForWarning() ^ true) ? typequalifiers : typequalifiers3;
                        nullability = r1 != 0 ? typequalifiers3 : r1.getNullability();
                        nullability2 = typequalifiers.getNullability();
                        if (this.d || !z9) {
                            set4 = set3;
                            z4 = false;
                        } else {
                            set4 = set3;
                            z4 = true;
                        }
                        typequalifiers3Select = typeEnchancementUtils.select(set4, nullability, z4);
                        if (typequalifiers3Select != null) {
                            typequalifiers3Select = typequalifiers3;
                        } else {
                            Object obj2 = this.a;
                            if (!(obj2 instanceof ValueParameterDescriptor)) {
                                obj2 = typequalifiers3;
                            }
                            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj2;
                            if (((valueParameterDescriptor == null ? typequalifiers3 : valueParameterDescriptor.getVarargElementType()) != null) && z9 && typequalifiers3Select == typequalifiers32) {
                            }
                        }
                        typeQualifiers2 typequalifiers23 = (typeQualifiers2) typeEnchancementUtils.select(set2, typequalifiers22, typequalifiers2, typequalifiers.getMutability(), z4);
                        if (nullability2 != nullability) {
                            set5 = set;
                            if (Intrinsics3.areEqual(set5, set4)) {
                                z5 = false;
                            }
                            if (typequalifiers.isNotNullTypeParameter()) {
                                z6 = true;
                            } else if (arrayList.isEmpty()) {
                                z7 = false;
                                if (z7) {
                                    z6 = false;
                                }
                            } else {
                                Iterator it12 = arrayList.iterator();
                                while (it12.hasNext()) {
                                    if (((typeQualifiers) it12.next()).isNotNullTypeParameter()) {
                                        z7 = true;
                                        break;
                                    }
                                }
                                z7 = false;
                                if (z7) {
                                }
                            }
                            if (typequalifiers3Select == null && z5) {
                                typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typeEnchancementUtils.select(set5, nullability2, z4), typequalifiers23, true, z6);
                            } else {
                                typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers23, typequalifiers3Select != null, z6);
                            }
                            typequalifiersArr[i] = typequalifiersCreateJavaTypeQualifiers;
                            i3 = i + 1;
                            obj = typequalifiers3;
                            size = i4;
                            arrayList2 = arrayList9;
                            arrayList4 = arrayList13;
                            typequalifiersArr2 = typequalifiersArr;
                            i2 = 10;
                        } else {
                            set5 = set;
                        }
                        z5 = true;
                        if (typequalifiers.isNotNullTypeParameter()) {
                        }
                        if (typequalifiers3Select == null) {
                            typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers23, typequalifiers3Select != null, z6);
                        }
                        typequalifiersArr[i] = typequalifiersCreateJavaTypeQualifiers;
                        i3 = i + 1;
                        obj = typequalifiers3;
                        size = i4;
                        arrayList2 = arrayList9;
                        arrayList4 = arrayList13;
                        typequalifiersArr2 = typequalifiersArr;
                        i2 = 10;
                    }
                } else {
                    arrayList = arrayList6;
                    typequalifiersArr = typequalifiersArr2;
                    i = i3;
                    annotationQualifiersFqNames2 = annotationQualifiersFqNames2Component2;
                }
                annotations = (!z9 || (annotations3 = this.a) == null) ? kotlinTypeComponent1.getAnnotations() : Annotations5.composeAnnotations(annotations3.getAnnotations(), kotlinTypeComponent1.getAnnotations());
                if (z9) {
                }
                if (annotationQualifiersFqNames22 != null) {
                }
                ClassifierDescriptor declarationDescriptor2 = kotlinTypeComponent1.getConstructor().getDeclarationDescriptor();
                if (!(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
                }
                if (typeParameterDescriptor != null) {
                }
                if (typequalifiers3A != null) {
                }
                NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus32 = (NullabilityQualifierWithMigrationStatus) tuples2.component1();
                boolean zBooleanValue2 = ((Boolean) tuples2.component2()).booleanValue();
                boolean z102 = this.g;
                signatureEnhancement signatureenhancement22 = signatureEnhancement.this;
                it = annotations.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                if (nullabilityQualifierWithMigrationStatusExtractNullability == null) {
                }
                if (nullabilityQualifierWithMigrationStatus != null) {
                }
                if (nullabilityQualifierWithMigrationStatus == null) {
                }
                if (nullabilityQualifierWithMigrationStatus2 != null) {
                }
                List<FqName> read_only_annotations2 = JvmAnnotationNames2.getREAD_ONLY_ANNOTATIONS();
                typeQualifiers2 typequalifiers24 = typeQualifiers2.READ_ONLY;
                objC = c(read_only_annotations2, annotations, typequalifiers24);
                List<FqName> mutable_annotations2 = JvmAnnotationNames2.getMUTABLE_ANNOTATIONS();
                typeQualifiers2 typequalifiers222 = typeQualifiers2.MUTABLE;
                Object objC22 = c(mutable_annotations2, annotations, typequalifiers222);
                if (objC == null) {
                    if (objC != null) {
                    }
                }
                typequalifiers = new typeQualifiers(qualifier2, (typeQualifiers2) objC22, !z3 && TypeUtils2.isTypeParameter(kotlinTypeComponent1), Intrinsics3.areEqual(nullabilityQualifierWithMigrationStatus2 != null ? typequalifiers3 : Boolean.valueOf(nullabilityQualifierWithMigrationStatus2.isForWarningOnly()), Boolean.TRUE));
                if (!(typequalifiers.isNullabilityQualifierForWarning() ^ true)) {
                }
                if (r1 != 0) {
                }
                nullability2 = typequalifiers.getNullability();
                if (this.d) {
                    set4 = set3;
                    z4 = false;
                }
                typequalifiers3Select = typeEnchancementUtils.select(set4, nullability, z4);
                if (typequalifiers3Select != null) {
                }
                typeQualifiers2 typequalifiers232 = (typeQualifiers2) typeEnchancementUtils.select(set2, typequalifiers222, typequalifiers24, typequalifiers.getMutability(), z4);
                if (nullability2 != nullability) {
                }
                z5 = true;
                if (typequalifiers.isNotNullTypeParameter()) {
                }
                if (typequalifiers3Select == null) {
                }
                typequalifiersArr[i] = typequalifiersCreateJavaTypeQualifiers;
                i3 = i + 1;
                obj = typequalifiers3;
                size = i4;
                arrayList2 = arrayList9;
                arrayList4 = arrayList13;
                typequalifiersArr2 = typequalifiersArr;
                i2 = 10;
            }
            Object obj3 = obj;
            ?? signatureenhancement23 = new signatureEnhancement2(typequalifiersArr2);
            Object c0386b = predefinedenhancementinfo4 == null ? obj3 : new C0386b(predefinedenhancementinfo4, signatureenhancement23);
            boolean zContains = TypeUtils.contains(this.f3350b, a.j);
            ?? Access$getTypeEnhancement$p = signatureEnhancement.access$getTypeEnhancement$p(signatureEnhancement.this);
            KotlinType kotlinType3 = this.f3350b;
            if (c0386b != null) {
                signatureenhancement23 = c0386b;
            }
            KotlinType kotlinTypeEnhance = Access$getTypeEnhancement$p.enhance(kotlinType3, signatureenhancement23);
            ?? aVar = kotlinTypeEnhance == null ? obj3 : new a(kotlinTypeEnhance, true, zContains);
            return aVar == 0 ? new a(this.f3350b, false, zContains) : aVar;
        }

        public /* synthetic */ b(Annotations3 annotations3, KotlinType kotlinType, Collection collection, boolean z2, context4 context4Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(signatureEnhancement.this, annotations3, kotlinType, collection, z2, context4Var, annotationQualifierApplicabilityType, (i & 64) != 0 ? false : z3);
        }
    }
}
