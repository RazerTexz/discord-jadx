package com.discord.api.report;

import b.d.b.a.outline;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/api/report/ReportNodeBottomButton;", "", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Cancel", "Done", "Next", "Submit", "Lcom/discord/api/report/ReportNodeBottomButton$Next;", "Lcom/discord/api/report/ReportNodeBottomButton$Submit;", "Lcom/discord/api/report/ReportNodeBottomButton$Cancel;", "Lcom/discord/api/report/ReportNodeBottomButton$Done;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class ReportNodeBottomButton {
    private final String type;

    /* compiled from: InAppReportsMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/report/ReportNodeBottomButton$Cancel;", "Lcom/discord/api/report/ReportNodeBottomButton;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Cancel extends ReportNodeBottomButton {
        public static final Cancel INSTANCE = new Cancel();

        public Cancel() {
            super("cancel", null);
        }
    }

    /* compiled from: InAppReportsMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/report/ReportNodeBottomButton$Done;", "Lcom/discord/api/report/ReportNodeBottomButton;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Done extends ReportNodeBottomButton {
        public static final Done INSTANCE = new Done();

        public Done() {
            super("done", null);
        }
    }

    /* compiled from: InAppReportsMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000e\u001a\u00060\u0005j\u0002`\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u00060\u0005j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/discord/api/report/ReportNodeBottomButton$Next;", "Lcom/discord/api/report/ReportNodeBottomButton;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/report/ReportNodeRef;", "target", "I", "b", "<init>", "(I)V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Next extends ReportNodeBottomButton {
        private final int target;

        public Next(int i) {
            super("next", null);
            this.target = i;
        }

        /* renamed from: b, reason: from getter */
        public final int getTarget() {
            return this.target;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Next) && this.target == ((Next) other).target;
            }
            return true;
        }

        public int hashCode() {
            return this.target;
        }

        public String toString() {
            return outline.B(outline.U("Next(target="), this.target, ")");
        }
    }

    /* compiled from: InAppReportsMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/report/ReportNodeBottomButton$Submit;", "Lcom/discord/api/report/ReportNodeBottomButton;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Submit extends ReportNodeBottomButton {
        public static final Submit INSTANCE = new Submit();

        public Submit() {
            super("submit", null);
        }
    }

    public ReportNodeBottomButton(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.type = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getType() {
        return this.type;
    }
}
