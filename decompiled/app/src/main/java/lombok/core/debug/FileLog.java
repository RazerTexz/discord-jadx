package lombok.core.debug;

import com.adjust.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: discord:lombok/core/debug/FileLog.SCL.lombok */
public class FileLog {
    private static FileOutputStream fos;

    static /* synthetic */ FileOutputStream access$0() {
        return fos;
    }

    public static void log(String message) throws IOException {
        log(message, null);
    }

    public static synchronized void log(String message, Throwable t) throws IOException {
        try {
            if (fos == null) {
                fos = new FileOutputStream(new File(System.getProperty("user.home"), "LOMBOK-DEBUG-OUT.txt"));
                Runtime.getRuntime().addShutdownHook(new AnonymousClass1());
            }
            fos.write(message.getBytes(Constants.ENCODING));
            fos.write(10);
            if (t != null) {
                StringWriter sw = new StringWriter();
                t.printStackTrace(new PrintWriter(sw));
                fos.write(sw.toString().getBytes(Constants.ENCODING));
                fos.write(10);
            }
            fos.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Internal lombok file-based debugging not possible", e);
        }
    }

    /* renamed from: lombok.core.debug.FileLog$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/debug/FileLog$1.SCL.lombok */
    class AnonymousClass1 extends Thread {
        AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                FileLog.access$0().close();
            } catch (Throwable unused) {
            }
        }
    }
}
