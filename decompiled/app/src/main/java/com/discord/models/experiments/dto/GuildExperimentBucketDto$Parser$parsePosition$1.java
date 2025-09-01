package com.discord.models.experiments.dto;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import rx.functions.Action1;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", ModelAuditLogEntry.CHANGE_KEY_NAME, "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parsePosition$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $end;
    public final /* synthetic */ Model.JsonReader $jsonReader;
    public final /* synthetic */ Ref$IntRef $start;

    public GuildExperimentBucketDto$Parser$parsePosition$1(Ref$IntRef ref$IntRef, Model.JsonReader jsonReader, Ref$IntRef ref$IntRef2) {
        this.$start = ref$IntRef;
        this.$jsonReader = jsonReader;
        this.$end = ref$IntRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 101) {
                if (iHashCode == 115 && str.equals("s")) {
                    Ref$IntRef ref$IntRef = this.$start;
                    ref$IntRef.element = this.$jsonReader.nextInt(ref$IntRef.element);
                    return;
                }
            } else if (str.equals("e")) {
                Ref$IntRef ref$IntRef2 = this.$end;
                ref$IntRef2.element = this.$jsonReader.nextInt(ref$IntRef2.element);
                return;
            }
        }
        this.$jsonReader.skipValue();
    }
}
