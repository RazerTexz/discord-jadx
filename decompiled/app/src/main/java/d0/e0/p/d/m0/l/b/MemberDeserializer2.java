package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.i.MessageLite;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: MemberDeserializer.kt */
/* renamed from: d0.e0.p.d.m0.l.b.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class MemberDeserializer2 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ AnnotatedCallableKind $kind;
    public final /* synthetic */ MessageLite $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer2(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = messageLite;
        this.$kind = annotatedCallableKind;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends AnnotationDescriptor> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends AnnotationDescriptor> invoke2() {
        List<AnnotationDescriptor> listLoadExtensionReceiverParameterAnnotations;
        MemberDeserializer memberDeserializer = this.this$0;
        ProtoContainer protoContainerAccess$asProtoContainer = MemberDeserializer.access$asProtoContainer(memberDeserializer, MemberDeserializer.access$getC$p(memberDeserializer).getContainingDeclaration());
        if (protoContainerAccess$asProtoContainer == null) {
            listLoadExtensionReceiverParameterAnnotations = null;
        } else {
            listLoadExtensionReceiverParameterAnnotations = MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(protoContainerAccess$asProtoContainer, this.$proto, this.$kind);
        }
        return listLoadExtensionReceiverParameterAnnotations != null ? listLoadExtensionReceiverParameterAnnotations : Collections2.emptyList();
    }
}
