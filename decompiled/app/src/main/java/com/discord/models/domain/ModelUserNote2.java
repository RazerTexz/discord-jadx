package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelUserNote.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelUserNote$Update$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelUserNote2<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $id;
    public final /* synthetic */ Ref$ObjectRef $note;
    public final /* synthetic */ Model.JsonReader $reader;

    public ModelUserNote2(Ref$LongRef ref$LongRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$id = ref$LongRef;
        this.$reader = jsonReader;
        this.$note = ref$ObjectRef;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 3355) {
                if (iHashCode == 3387378 && str.equals("note")) {
                    Ref$ObjectRef ref$ObjectRef = this.$note;
                    T t = (T) this.$reader.nextString("");
                    Intrinsics3.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                    ref$ObjectRef.element = t;
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                this.$id.element = this.$reader.nextLong(0L);
                return;
            }
        }
        this.$reader.skipValue();
    }
}
