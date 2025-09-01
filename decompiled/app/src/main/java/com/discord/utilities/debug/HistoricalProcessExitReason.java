package com.discord.utilities.debug;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: HistoricalProcessExitReason.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\b\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/utilities/debug/HistoricalProcessExitReason;", "", "Lcom/discord/utilities/debug/HistoricalProcessExitReason$Reason;", "createLastReason", "()Lcom/discord/utilities/debug/HistoricalProcessExitReason$Reason;", "lastReason$delegate", "Lkotlin/Lazy;", "getLastReason", "lastReason", "<init>", "()V", "Reason", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class HistoricalProcessExitReason {
    public static final HistoricalProcessExitReason INSTANCE = new HistoricalProcessExitReason();

    /* renamed from: lastReason$delegate, reason: from kotlin metadata */
    private static final Lazy lastReason = LazyJVM.lazy(HistoricalProcessExitReason2.INSTANCE);

    /* compiled from: HistoricalProcessExitReason.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/debug/HistoricalProcessExitReason$Reason;", "", "", "component1", "()Ljava/lang/String;", "component2", ModelAuditLogEntry.CHANGE_KEY_REASON, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/utilities/debug/HistoricalProcessExitReason$Reason;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Reason {
        private final String description;
        private final String reason;

        public Reason(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
            this.reason = str;
            this.description = str2;
        }

        public static /* synthetic */ Reason copy$default(Reason reason, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reason.reason;
            }
            if ((i & 2) != 0) {
                str2 = reason.description;
            }
            return reason.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Reason copy(String reason, String description) {
            Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            return new Reason(reason, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reason)) {
                return false;
            }
            Reason reason = (Reason) other;
            return Intrinsics3.areEqual(this.reason, reason.reason) && Intrinsics3.areEqual(this.description, reason.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            String str = this.reason;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Reason(reason=");
            sbU.append(this.reason);
            sbU.append(", description=");
            return outline.J(sbU, this.description, ")");
        }
    }

    private HistoricalProcessExitReason() {
    }

    public static final /* synthetic */ Reason access$createLastReason(HistoricalProcessExitReason historicalProcessExitReason) {
        return historicalProcessExitReason.createLastReason();
    }

    private final Reason createLastReason() {
        Reason reason = null;
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Map mapMapOf = Maps6.mapOf(Tuples.to(6, "ANR"), Tuples.to(4, "CRASH"), Tuples.to(5, "CRASH_NATIVE"), Tuples.to(12, "DEPENDENCY_DIED"), Tuples.to(9, "EXCESSIVE_RESOURCE_USAGE"), Tuples.to(1, "EXIT_SELF"), Tuples.to(7, "INITIALIZATION_FAILURE"), Tuples.to(3, "LOW_MEMORY"), Tuples.to(13, "OTHER"), Tuples.to(8, "PERMISSION_CHANGE"), Tuples.to(2, "SIGNALED"), Tuples.to(0, "UNKNOWN"), Tuples.to(10, "USER_REQUESTED"), Tuples.to(11, "USER_STOPPED"));
        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 1);
            Intrinsics3.checkNotNullExpressionValue(historicalProcessExitReasons, "activityManager.getHisto…ssExitReasons(null, 0, 1)");
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) _Collections.firstOrNull((List) historicalProcessExitReasons);
            if (applicationExitInfo != null) {
                String string = (String) mapMapOf.get(Integer.valueOf(applicationExitInfo.getReason()));
                if (string == null) {
                    StringBuilder sbU = outline.U("Unknown ");
                    sbU.append(applicationExitInfo.getReason());
                    string = sbU.toString();
                }
                reason = new Reason(string, applicationExitInfo.getDescription());
            }
        }
        return reason;
    }

    public final Reason getLastReason() {
        return (Reason) lastReason.getValue();
    }
}
