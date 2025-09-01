package com.discord.media_picker;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RequestType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/media_picker/RequestType;", "", "", "getCode$media_picker_release", "()I", ModelAuditLogEntry.CHANGE_KEY_CODE, "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "CAMERA", "GALLERY", "DOCUMENTS", "CROP", "CHOOSER", "media_picker_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum RequestType {
    CAMERA,
    GALLERY,
    DOCUMENTS,
    CROP,
    CHOOSER;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RequestType.kt */
    /* renamed from: com.discord.media_picker.RequestType$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final int getCode$media_picker_release() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return 777;
        }
        if (iOrdinal == 1) {
            return 778;
        }
        if (iOrdinal == 2) {
            return 779;
        }
        if (iOrdinal == 3) {
            return 800;
        }
        if (iOrdinal == 4) {
            return 801;
        }
        throw new NoWhenBranchMatchedException();
    }
}
