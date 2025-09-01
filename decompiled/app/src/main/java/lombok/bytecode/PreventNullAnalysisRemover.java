package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.core.DiagnosticsReceiver;
import lombok.core.PostCompilerTransformation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* loaded from: discord:lombok/bytecode/PreventNullAnalysisRemover.SCL.lombok */
public class PreventNullAnalysisRemover implements PostCompilerTransformation {
    @Override // lombok.core.PostCompilerTransformation
    public byte[] applyTransformations(byte[] original, String fileName, DiagnosticsReceiver diagnostics) {
        if (!new ClassFileMetaData(original).usesMethod("lombok/Lombok", "preventNullAnalysis")) {
            return null;
        }
        byte[] fixedByteCode = AsmUtil.fixJSRInlining(original);
        ClassReader reader = new ClassReader(fixedByteCode);
        ClassWriter writer = new FixedClassWriter(reader, 0);
        AtomicBoolean changesMade = new AtomicBoolean();
        reader.accept(new AnonymousClass1(Opcodes.ASM7, writer, changesMade), 0);
        if (changesMade.get()) {
            return writer.toByteArray();
        }
        return null;
    }

    /* renamed from: lombok.bytecode.PreventNullAnalysisRemover$1PreventNullAnalysisVisitor, reason: invalid class name */
    /* loaded from: discord:lombok/bytecode/PreventNullAnalysisRemover$1PreventNullAnalysisVisitor.SCL.lombok */
    class C1PreventNullAnalysisVisitor extends MethodVisitor {
        private final /* synthetic */ AtomicBoolean val$changesMade;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1PreventNullAnalysisVisitor(MethodVisitor mv, AtomicBoolean atomicBoolean) {
            super(Opcodes.ASM7, mv);
            this.val$changesMade = atomicBoolean;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            boolean hit = true;
            if (1 != 0 && opcode != 184) {
                hit = false;
            }
            if (hit && !"preventNullAnalysis".equals(name)) {
                hit = false;
            }
            if (hit && !"lombok/Lombok".equals(owner)) {
                hit = false;
            }
            if (hit && !"(Ljava/lang/Object;)Ljava/lang/Object;".equals(desc)) {
                hit = false;
            }
            if (hit) {
                this.val$changesMade.set(true);
                if (System.getProperty("lombok.debugAsmOnly", null) != null) {
                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                    return;
                }
                return;
            }
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }

    /* renamed from: lombok.bytecode.PreventNullAnalysisRemover$1, reason: invalid class name */
    /* loaded from: discord:lombok/bytecode/PreventNullAnalysisRemover$1.SCL.lombok */
    class AnonymousClass1 extends ClassVisitor {
        private final /* synthetic */ AtomicBoolean val$changesMade;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int $anonymous0, ClassVisitor $anonymous1, AtomicBoolean atomicBoolean) {
            super($anonymous0, $anonymous1);
            this.val$changesMade = atomicBoolean;
        }

        @Override // org.objectweb.asm.ClassVisitor
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            return PreventNullAnalysisRemover.this.new C1PreventNullAnalysisVisitor(super.visitMethod(access, name, desc, signature, exceptions), this.val$changesMade);
        }
    }
}
