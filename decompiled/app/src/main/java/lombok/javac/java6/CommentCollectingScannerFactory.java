package lombok.javac.java6;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.util.Context;
import java.nio.CharBuffer;

/* loaded from: discord:lombok/javac/java6/CommentCollectingScannerFactory.SCL.lombok */
public class CommentCollectingScannerFactory extends Scanner.Factory {
    public static void preRegister(Context context) {
        if (context.get(scannerFactoryKey) == null) {
            Context.Factory<Scanner.Factory> factory = new C1MyFactory(context);
            context.put(scannerFactoryKey, factory);
        }
    }

    /* renamed from: lombok.javac.java6.CommentCollectingScannerFactory$1MyFactory, reason: invalid class name */
    /* loaded from: discord:lombok/javac/java6/CommentCollectingScannerFactory$1MyFactory.SCL.lombok */
    class C1MyFactory implements Context.Factory {
        private final /* synthetic */ Context val$context;

        C1MyFactory(Context context) {
            this.val$context = context;
        }

        public Object make() {
            return new CommentCollectingScannerFactory(this.val$context);
        }

        public Object make(Context c) {
            return new CommentCollectingScannerFactory(c);
        }
    }

    protected CommentCollectingScannerFactory(Context context) {
        super(context);
    }

    public Scanner newScanner(CharSequence input) {
        if (input instanceof CharBuffer) {
            return new CommentCollectingScanner(this, (CharBuffer) input);
        }
        char[] array = input.toString().toCharArray();
        return newScanner(array, array.length);
    }

    public Scanner newScanner(char[] input, int inputLength) {
        return new CommentCollectingScanner(this, input, inputLength);
    }
}
