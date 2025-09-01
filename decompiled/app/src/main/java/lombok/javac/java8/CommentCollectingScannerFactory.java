package lombok.javac.java8;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.Context;
import java.nio.CharBuffer;

/* loaded from: discord:lombok/javac/java8/CommentCollectingScannerFactory.SCL.lombok */
public class CommentCollectingScannerFactory extends ScannerFactory {
    public static boolean findTextBlocks;

    public static void preRegister(Context context) {
        if (context.get(scannerFactoryKey) == null) {
            Context.Factory<ScannerFactory> factory = new C1MyFactory(context);
            context.put(scannerFactoryKey, factory);
        }
    }

    /* renamed from: lombok.javac.java8.CommentCollectingScannerFactory$1MyFactory, reason: invalid class name */
    /* loaded from: discord:lombok/javac/java8/CommentCollectingScannerFactory$1MyFactory.SCL.lombok */
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

    public Scanner newScanner(CharSequence input, boolean keepDocComments) {
        if (input instanceof CharBuffer) {
            CharBuffer buf = (CharBuffer) input;
            return new CommentCollectingScanner(this, new CommentCollectingTokenizer(this, buf, findTextBlocks));
        }
        char[] array = input.toString().toCharArray();
        return newScanner(array, array.length, keepDocComments);
    }

    public Scanner newScanner(char[] input, int inputLength, boolean keepDocComments) {
        return new CommentCollectingScanner(this, new CommentCollectingTokenizer(this, input, inputLength, findTextBlocks));
    }
}
