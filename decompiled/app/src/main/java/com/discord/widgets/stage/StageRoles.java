package com.discord.widgets.stage;

import b.d.b.a.outline;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageRoles.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087@\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0019\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u001b\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/stage/StageRoles;", "", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "", "hashCode-impl", "(I)I", "hashCode", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "equals", "rolesFlags", "I", "getRolesFlags", "()I", "isAudience-impl", "(I)Z", "isAudience", "isModerator-impl", "isModerator", "isInvitedToSpeak-impl", "isInvitedToSpeak", "isSpeaker-impl", "isSpeaker", "constructor-impl", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageRoles {
    private static final int AUDIENCE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final int IS_INVITED_TO_SPEAK = 4;
    private static final int IS_MODERATOR = 2;
    private static final int IS_SPEAKER = 1;
    private final int rolesFlags;

    /* compiled from: StageRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\u00068\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/stage/StageRoles$Companion;", "", "", "isSpeaker", "isModerator", "isInvitedToSpeak", "Lcom/discord/widgets/stage/StageRoles;", "invoke-H48EO60", "(ZZZ)I", "invoke", "AUDIENCE", "I", "getAUDIENCE-1LxfuJo", "()I", "", "IS_INVITED_TO_SPEAK", "IS_MODERATOR", "IS_SPEAKER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* renamed from: invoke-H48EO60$default, reason: not valid java name */
        public static /* synthetic */ int m36invokeH48EO60$default(Companion companion, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            if ((i & 2) != 0) {
                z3 = false;
            }
            if ((i & 4) != 0) {
                z4 = false;
            }
            return companion.m38invokeH48EO60(z2, z3, z4);
        }

        /* renamed from: getAUDIENCE-1LxfuJo, reason: not valid java name */
        public final int m37getAUDIENCE1LxfuJo() {
            return StageRoles.m24access$getAUDIENCE$cp1LxfuJo();
        }

        /* renamed from: invoke-H48EO60, reason: not valid java name */
        public final int m38invokeH48EO60(boolean isSpeaker, boolean isModerator, boolean isInvitedToSpeak) {
            int i = isSpeaker ? 1 : 0;
            if (isModerator) {
                i |= 2;
            }
            if (isInvitedToSpeak) {
                i |= 4;
            }
            return StageRoles.m26constructorimpl(i);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        AUDIENCE = Companion.m36invokeH48EO60$default(companion, false, false, false, 7, null);
    }

    private /* synthetic */ StageRoles(int i) {
        this.rolesFlags = i;
    }

    /* renamed from: access$getAUDIENCE$cp-1LxfuJo, reason: not valid java name */
    public static final /* synthetic */ int m24access$getAUDIENCE$cp1LxfuJo() {
        return AUDIENCE;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StageRoles m25boximpl(int i) {
        return new StageRoles(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m26constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m27equalsimpl(int i, Object obj) {
        return (obj instanceof StageRoles) && i == ((StageRoles) obj).m35unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m28equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m29hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: isAudience-impl, reason: not valid java name */
    public static final boolean m30isAudienceimpl(int i) {
        return (m33isSpeakerimpl(i) || m32isModeratorimpl(i)) ? false : true;
    }

    /* renamed from: isInvitedToSpeak-impl, reason: not valid java name */
    public static final boolean m31isInvitedToSpeakimpl(int i) {
        return (i & 4) != 0;
    }

    /* renamed from: isModerator-impl, reason: not valid java name */
    public static final boolean m32isModeratorimpl(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: isSpeaker-impl, reason: not valid java name */
    public static final boolean m33isSpeakerimpl(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m34toStringimpl(int i) {
        return outline.r("StageRoles(rolesFlags=", i, ")");
    }

    public boolean equals(Object obj) {
        return m27equalsimpl(this.rolesFlags, obj);
    }

    public final int getRolesFlags() {
        return this.rolesFlags;
    }

    public int hashCode() {
        return m29hashCodeimpl(this.rolesFlags);
    }

    public String toString() {
        return m34toStringimpl(this.rolesFlags);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m35unboximpl() {
        return this.rolesFlags;
    }
}
