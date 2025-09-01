package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/fcm/NotificationType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "Reminder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.fcm.NotificationType, reason: use source file name */
/* loaded from: classes2.dex */
public enum NotificationData3 {
    Reminder(NotificationCompat.CATEGORY_REMINDER);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* compiled from: NotificationData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/fcm/NotificationType$Companion;", "", "", "value", "Lcom/discord/utilities/fcm/NotificationType;", "parse", "(Ljava/lang/String;)Lcom/discord/utilities/fcm/NotificationType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.fcm.NotificationType$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final NotificationData3 parse(String value) {
            NotificationData3[] notificationData3ArrValues = NotificationData3.values();
            for (int i = 0; i < 1; i++) {
                NotificationData3 notificationData3 = notificationData3ArrValues[i];
                if (Intrinsics3.areEqual(notificationData3.getValue(), value)) {
                    return notificationData3;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    NotificationData3(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
