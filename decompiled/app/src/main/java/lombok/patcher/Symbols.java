package lombok.patcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: discord:lombok/patcher/Symbols.SCL.lombok */
public class Symbols {
    private static final ThreadLocal<LinkedList<String>> stack = new AnonymousClass1();

    /* renamed from: lombok.patcher.Symbols$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/Symbols$1.SCL.lombok */
    class AnonymousClass1 extends ThreadLocal<LinkedList<String>> {
        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ LinkedList<String> initialValue() {
            return initialValue();
        }

        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        protected LinkedList<String> initialValue() {
            return new LinkedList<>();
        }
    }

    private Symbols() {
    }

    public static void push(String symbol) {
        stack.get().addFirst(symbol);
    }

    public static void pop() {
        stack.get().poll();
    }

    public static boolean isEmpty() {
        return stack.get().isEmpty();
    }

    public static int size() {
        return stack.get().size();
    }

    public static boolean hasSymbol(String symbol) {
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        return stack.get().contains(symbol);
    }

    public static boolean hasTail(String symbol) {
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        return symbol.equals(stack.get().peek());
    }

    public static List<String> getCopy() {
        return new ArrayList(stack.get());
    }
}
