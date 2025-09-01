package lombok.javac;

/* loaded from: discord:lombok/javac/CommentInfo.SCL.lombok */
public final class CommentInfo {
    public final int pos;
    public final int prevEndPos;
    public final String content;
    public final int endPos;
    public final StartConnection start;
    public final EndConnection end;

    /* loaded from: discord:lombok/javac/CommentInfo$EndConnection.SCL.lombok */
    public enum EndConnection {
        DIRECT_AFTER_COMMENT,
        AFTER_COMMENT,
        ON_NEXT_LINE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EndConnection[] valuesCustom() {
            EndConnection[] endConnectionArrValuesCustom = values();
            int length = endConnectionArrValuesCustom.length;
            EndConnection[] endConnectionArr = new EndConnection[length];
            System.arraycopy(endConnectionArrValuesCustom, 0, endConnectionArr, 0, length);
            return endConnectionArr;
        }
    }

    /* loaded from: discord:lombok/javac/CommentInfo$StartConnection.SCL.lombok */
    public enum StartConnection {
        START_OF_LINE,
        ON_NEXT_LINE,
        DIRECT_AFTER_PREVIOUS,
        AFTER_PREVIOUS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static StartConnection[] valuesCustom() {
            StartConnection[] startConnectionArrValuesCustom = values();
            int length = startConnectionArrValuesCustom.length;
            StartConnection[] startConnectionArr = new StartConnection[length];
            System.arraycopy(startConnectionArrValuesCustom, 0, startConnectionArr, 0, length);
            return startConnectionArr;
        }
    }

    public CommentInfo(int prevEndPos, int pos, int endPos, String content, StartConnection start, EndConnection end) {
        this.pos = pos;
        this.prevEndPos = prevEndPos;
        this.endPos = endPos;
        this.content = content;
        this.start = start;
        this.end = end;
    }

    public boolean isJavadoc() {
        return this.content.startsWith("/**") && this.content.length() > 4;
    }

    public String toString() {
        return String.format("%d: %s (%s,%s)", Integer.valueOf(this.pos), this.content, this.start, this.end);
    }
}
