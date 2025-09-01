package lombok.bytecode;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.JSRInlinerAdapter;

/* loaded from: discord:lombok/bytecode/AsmUtil.SCL.lombok */
class AsmUtil {
    private AsmUtil() {
        throw new UnsupportedOperationException();
    }

    static byte[] fixJSRInlining(byte[] byteCode) {
        ClassReader reader = new ClassReader(byteCode);
        ClassWriter writer = new FixedClassWriter(reader, 0);
        ClassVisitor visitor = new AnonymousClass1(Opcodes.ASM7, writer);
        reader.accept(visitor, 0);
        return writer.toByteArray();
    }

    /* renamed from: lombok.bytecode.AsmUtil$1, reason: invalid class name */
    /* loaded from: discord:lombok/bytecode/AsmUtil$1.SCL.lombok */
    class AnonymousClass1 extends ClassVisitor {
        AnonymousClass1(int $anonymous0, ClassVisitor $anonymous1) {
            super($anonymous0, $anonymous1);
        }

        @Override // org.objectweb.asm.ClassVisitor
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            return new JSRInlinerAdapter(super.visitMethod(access, name, desc, signature, exceptions), access, name, desc, signature, exceptions);
        }
    }
}
