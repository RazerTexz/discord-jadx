package lombok.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.List;

/* loaded from: discord:lombok/core/PostCompiler.SCL.lombok */
public final class PostCompiler {
    private static List<PostCompilerTransformation> transformations;

    private PostCompiler() {
    }

    public static byte[] applyTransformations(byte[] original, String fileName, DiagnosticsReceiver diagnostics) {
        if (System.getProperty("lombok.disablePostCompiler", null) != null) {
            return original;
        }
        init(diagnostics);
        byte[] previous = original;
        for (PostCompilerTransformation transformation : transformations) {
            try {
                byte[] next = transformation.applyTransformations(previous, fileName, diagnostics);
                if (next != null) {
                    previous = next;
                }
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter((Writer) sw, true));
                diagnostics.addError(String.format("Error during the transformation of '%s'; post-compiler '%s' caused an exception: %s", fileName, transformation.getClass().getName(), sw));
            }
        }
        return previous;
    }

    private static synchronized void init(DiagnosticsReceiver diagnostics) {
        if (transformations != null) {
            return;
        }
        try {
            transformations = SpiLoadUtil.readAllFromIterator(SpiLoadUtil.findServices(PostCompilerTransformation.class, PostCompilerTransformation.class.getClassLoader()));
        } catch (IOException e) {
            transformations = Collections.emptyList();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter((Writer) sw, true));
            diagnostics.addError("Could not load post-compile transformers: " + e.getMessage() + "\n" + sw.toString());
        }
    }

    /* renamed from: lombok.core.PostCompiler$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/PostCompiler$1.SCL.lombok */
    class AnonymousClass1 extends ByteArrayOutputStream {
        private final /* synthetic */ String val$fileName;
        private final /* synthetic */ DiagnosticsReceiver val$diagnostics;
        private final /* synthetic */ OutputStream val$originalStream;

        AnonymousClass1(String str, DiagnosticsReceiver diagnosticsReceiver, OutputStream outputStream) {
            this.val$fileName = str;
            this.val$diagnostics = diagnosticsReceiver;
            this.val$originalStream = outputStream;
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            byte[] original = toByteArray();
            byte[] copy = null;
            if (original.length > 0) {
                try {
                    copy = PostCompiler.applyTransformations(original, this.val$fileName, this.val$diagnostics);
                } catch (Exception unused) {
                    this.val$diagnostics.addWarning(String.format("Error during the transformation of '%s'; no post-compilation has been applied", this.val$fileName));
                }
            }
            if (copy == null) {
                copy = original;
            }
            this.val$originalStream.write(copy);
            this.val$originalStream.close();
        }
    }

    public static OutputStream wrapOutputStream(OutputStream originalStream, String fileName, DiagnosticsReceiver diagnostics) throws IOException {
        return System.getProperty("lombok.disablePostCompiler", null) != null ? originalStream : new AnonymousClass1(fileName, diagnostics, originalStream);
    }
}
