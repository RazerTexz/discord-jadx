package com.linecorp.apng.decoder;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApngException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0011B\u001d\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/linecorp/apng/decoder/ApngException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "getMessage", "()Ljava/lang/String;", "message", "Lcom/linecorp/apng/decoder/ApngException$ErrorCode;", "errorCode", "Lcom/linecorp/apng/decoder/ApngException$ErrorCode;", "getErrorCode", "()Lcom/linecorp/apng/decoder/ApngException$ErrorCode;", "", "throwable", "<init>", "(Lcom/linecorp/apng/decoder/ApngException$ErrorCode;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "ErrorCode", "apng-drawable_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ApngException extends Exception {
    private final ErrorCode errorCode;

    /* compiled from: ApngException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/linecorp/apng/decoder/ApngException$ErrorCode;", "", "", "errorCode", "I", "getErrorCode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "ERR_STREAM_READ_FAIL", "ERR_UNEXPECTED_EOF", "ERR_INVALID_FILE_FORMAT", "ERR_NOT_EXIST_IMAGE", "ERR_FRAME_INDEX_OUT_OF_RANGE", "ERR_OUT_OF_MEMORY", "ERR_BITMAP_OPERATION", "ERR_UNSUPPORTED_TYPE", "ERR_WITH_CHILD_EXCEPTION", "apng-drawable_release"}, k = 1, mv = {1, 4, 2})
    public enum ErrorCode {
        ERR_STREAM_READ_FAIL(-100),
        ERR_UNEXPECTED_EOF(-101),
        ERR_INVALID_FILE_FORMAT(-102),
        ERR_NOT_EXIST_IMAGE(-103),
        ERR_FRAME_INDEX_OUT_OF_RANGE(-104),
        ERR_OUT_OF_MEMORY(-105),
        ERR_BITMAP_OPERATION(-106),
        ERR_UNSUPPORTED_TYPE(-107),
        ERR_WITH_CHILD_EXCEPTION(-200);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int errorCode;

        /* compiled from: ApngException.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/linecorp/apng/decoder/ApngException$ErrorCode$Companion;", "", "", "errorCode", "Lcom/linecorp/apng/decoder/ApngException$ErrorCode;", "fromErrorCode$apng_drawable_release", "(I)Lcom/linecorp/apng/decoder/ApngException$ErrorCode;", "fromErrorCode", "<init>", "()V", "apng-drawable_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public final ErrorCode fromErrorCode$apng_drawable_release(int errorCode) {
                ErrorCode[] errorCodeArrValues = ErrorCode.values();
                for (int i = 0; i < 9; i++) {
                    ErrorCode errorCode2 = errorCodeArrValues[i];
                    if (errorCode2.getErrorCode() == errorCode) {
                        return errorCode2;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        ErrorCode(int i) {
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ErrorCode.values();
            int[] iArr = new int[9];
            $EnumSwitchMapping$0 = iArr;
            iArr[ErrorCode.ERR_STREAM_READ_FAIL.ordinal()] = 1;
            iArr[ErrorCode.ERR_UNEXPECTED_EOF.ordinal()] = 2;
            iArr[ErrorCode.ERR_INVALID_FILE_FORMAT.ordinal()] = 3;
            iArr[ErrorCode.ERR_NOT_EXIST_IMAGE.ordinal()] = 4;
            iArr[ErrorCode.ERR_FRAME_INDEX_OUT_OF_RANGE.ordinal()] = 5;
            iArr[ErrorCode.ERR_OUT_OF_MEMORY.ordinal()] = 6;
            iArr[ErrorCode.ERR_BITMAP_OPERATION.ordinal()] = 7;
            iArr[ErrorCode.ERR_UNSUPPORTED_TYPE.ordinal()] = 8;
            iArr[ErrorCode.ERR_WITH_CHILD_EXCEPTION.ordinal()] = 9;
        }
    }

    public /* synthetic */ ApngException(ErrorCode errorCode, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorCode, (i & 2) != 0 ? null : th);
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        switch (this.errorCode) {
            case ERR_STREAM_READ_FAIL:
                return "Can't read the stream.";
            case ERR_UNEXPECTED_EOF:
                return "Unexpected end of file.";
            case ERR_INVALID_FILE_FORMAT:
                return "Invalid file format.";
            case ERR_NOT_EXIST_IMAGE:
                return "Not exist native image.";
            case ERR_FRAME_INDEX_OUT_OF_RANGE:
                return "Frame index is out of range.";
            case ERR_OUT_OF_MEMORY:
                return "Out of memory";
            case ERR_BITMAP_OPERATION:
                return "Error in the native bitmap operation.";
            case ERR_UNSUPPORTED_TYPE:
                return "Unsupported image type.";
            case ERR_WITH_CHILD_EXCEPTION:
                StringBuilder sbU = outline.U("Failed with sub exception : ");
                Throwable cause = getCause();
                sbU.append(cause != null ? cause.getMessage() : null);
                return sbU.toString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApngException(ErrorCode errorCode, Throwable th) {
        super(th);
        Intrinsics3.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApngException(Throwable th) {
        this(ErrorCode.ERR_WITH_CHILD_EXCEPTION, th);
        Intrinsics3.checkNotNullParameter(th, "throwable");
    }
}
